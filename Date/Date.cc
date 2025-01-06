#include "Date.h"
#include <cassert>	// assert
#include <iomanip>
#include <time.h>

using namespace std;

// Return true if year is a leap year, false if it isn’t.
//
// The rules are:
// • Years divisible by 4 are leap years, except
// • years divisible by 100 are NOT leap years, except
// • years divisible by 400 ARE leap years.
//
// Examples:
// • Leap years: 1600, 2000, 2004, 2008, 2400
// • Not leap years: 1700, 1800, 1900, 2001, 2002, 2003
//
// Ancient Romans used only the divisible-by-4 rule, which gives an
// average year length of 365.25 days.  This was called the Julian
// Calendar, after Julius Caesar, who promoted it.
//
// However, the actual length of the year (365.24217 days) is a bit less
// than that, so Pope Gregory XIII added the next two rules, creating
// our current Gregorian Calendar, which is closer (365.2425 days).

static bool isLeapYear(int year) {		// Calculate Gregorian leap year
    year_assert(year);
    if (year % 4 != 0) { return false; }    // Boring plain non-leap year.
    if (year % 400 == 0) { return true; }   // If Divisible by 400; leap year
    if (year % 100 == 0) { return false; }  // If then Divisible by 100 not a leap year
    // Otherwise is leap year
    return true;
}

// assert within year range; max 9999 for 4 digit year
void year_assert(int year){
    assert(1 <= year <= 9999); //
}

// assert within month range
void month_assert(int month) {
    assert(1 <= month <= 12);
}

// assert within day range
void day_assert(int year, int month, int day) {
    assert(1 <= day <= days_per_month(year, month));
}

// wrapper to assert all values
void ymd_assert(int year, int month, int day){
    year_assert(year);
    month_assert(month);
    day_assert(year, month, day);
}

void daynum_assert(int daynum){
    assert(1 <= daynum <= 3652059); // 3652059 number of days on 9999-12-31 
}

// return number of days in a year based on if year is leap year
static int days_per_year(int year) {
    year_assert(year);
    return isLeapYear(year) ? 366 : 365; 
}

static int days_per_month(int year, int month) {
    year_assert(year);
    month_assert(month);
    // padded with 0 to not need months - 1; then number of days in each month
    const int days[] = {00,31,28,31,30,31,30,31,31,30,31,30,31};
    // see if case is Febuary of leap year to return 29
    if (month == 2 && isLeapYear(year)) { return 29; }
    // all other cases return number of days in a month
    return days[month];
}

int Date::ymd_to_daynum(int year, int month, int day) {
    ymd_assert(year, month, day);   // validate within year, month, day range
    // Start at Jan 1, 0001, as day #1 and increment until we get to what we want
    int daynum=1;
    // add all days for full years
    for (int y=1; y < year; y++) { daynum += days_per_year(y); }
    // add all days for full months elapsed
    for (int m=1; m < month; m++) { daynum += days_per_month(year, m); }
    // add all days elasped in current month
    daynum += day - 1;
    // check to be within bounds
    daynum_assert(daynum);
    return daynum;
}

static void daynum_to_ymd(int daynum, int &year, int &month, int &day) {
    daynum_assert(daynum);
    // local variable to not be constanly updating the inputs
    int y=1, m=1, d=1;

//#if 1
    // Jump forward by years, at first.
    // Why 400 instead of 365 or 366?  Too much caution, I suppose.
    while (daynum >= 400) { daynum -= days_per_year(y++); }
//#endif

    for (; daynum > 1; daynum--) { // for days remaining
        // Increment y-m-d
        // first increase day count
        d++;
        if (d > days_per_month(y, m)) { // if day count greater than days in month
            m++; // increment month
            d=1; // reset day
            if (m > 12) { // if curren month greater than 12
                y++; // increment year
                m=1; // reset month
            }
        }
    }

    ymd_assert(y, m, d);    // check year, month, day range
    // set input values to result
    year = y; month = m; day = d;
}

Date::Date(int year, int month, int day) : daynum(ymd_to_daynum(year, month, day)) {
    ymd_assert(year, month, day);
    daynum_assert(daynum);
}

Date::Date(int year, int month, int day, bool ymd_checked) : daynum(ymd_to_daynum(year, month, day)) {
    if (!ymd_checked) {
        ymd_assert(year, month, day);
    }
    daynum_assert(daynum);
}

Date::Date() {
    const time_t now = time(nullptr);	    // Seconds since 1970 started
    struct tm *tm = localtime(&now);	    // year/month/day/hour/min/sec
    daynum = ymd_to_daynum(tm->tm_year + 1900, tm->tm_mon + 1, tm->tm_mday);
    // Yes, 1900.  That’s not a Y2K bug--that’s how localtime is defined.
}

int Date::getday() const {
    int year, month, day;
    daynum_to_ymd(daynum, year, month, day);
    return day;
}

int Date::getmonth() const {
    int year, month, day;
    daynum_to_ymd(daynum, year, month, day);
    return month;
}

int Date::getyear() const {
    int year, month, day;
    daynum_to_ymd(daynum, year, month, day);
    return year;
}

void Date::setday(int new_day) {
    int year, month, day;
    daynum_to_ymd(daynum, year, month, day);
    daynum = ymd_to_daynum(year, month, new_day);
}

void Date::setmonth(int new_month) {
    int year, month, day;
    daynum_to_ymd(daynum, year, month, day);
    daynum = ymd_to_daynum(year, new_month, day);
}

void Date::setyear(int new_year) {
    int year, month, day;
    daynum_to_ymd(daynum, year, month, day);
    daynum = ymd_to_daynum(new_year, month, day);
}

/*

bool in_range(int num, int l_bounds, int u_bounds) {
    return  l_bounds <= num <= u_bounds;            }

bool is_valid_y(int year) {
    return in_range(year, 1, 9999);     }

bool is_valid_m(int month) {
    return in_range(month, 1, 12);      }

// y_valid, m_valid default to false using .h declaration
bool is_valid_d(int year, int month, int day, bool y_valid, bool m_valid) {
    if (!y_valid || !m_valid) {
        return 1 <= day <= days_per_month(year, month);
    } else {
        return in_range(day, 1, days_per_month(year, month));
    }
}

*/

// This does the real work of all numeric operations, All other operators (+, -, ++, -=, etc) should invoke operator+=.
Date &Date::operator+=(int value) {
    daynum += value;
    return *this;
}

Date Date::operator+(int value) const {
    Date result = *this;
    return result += value;
}

const Date &Date::operator++() {			// prefix
    *this += 1;
    return *this;
}

Date Date::operator++(int /* dummy */) {		// postfix
    const auto before = *this;
    *this += 1;
    return before;
}

int Date::operator-(const Date &rhs) const {
    return daynum - rhs.daynum;
}

Date Date::operator-(int value) const {
    return *this + -value;
}

Date &Date::operator-=(int value) {
    return *this += -value;
}

const Date &Date::operator--() {			// prefix
    *this -= 1;
    return *this;
}

Date Date::operator--(int /* dummy */) {		// postfix
    Date before = *this;
    *this -= 1;
    return before;
}

bool Date::operator<(const Date &rhs) const {
    return daynum < rhs.daynum;
}

bool Date::operator<=(const Date &rhs) const {
    return daynum <= rhs.daynum;
}

bool Date::operator>(const Date &rhs) const {
    return daynum > rhs.daynum;
}

bool Date::operator>=(const Date &rhs) const {
    return daynum >= rhs.daynum;
}

bool Date::operator==(const Date &rhs) const {
    return daynum == rhs.daynum;
}

bool Date::operator!=(const Date &rhs) const {
    return daynum != rhs.daynum;
}

Date operator+(int value, const Date &rhs) {
    return rhs + value;
}

ostream &operator<<(ostream &out, const Date &d) {
    // output in format YYYY-MM-DD
    return out << d.getyear() << '-' << d.getmonth() << '-' << d.getday();
}

istream &operator>>(istream &in, Date &d) {
    int year, month, day;
    char c1, c2;
    // read in istream with each line assumed to be in format YYYY-MM-DD
    if (in >> year >> c1 && c1=='-'
        && in >> month >> c2 && c2=='-'
        && in >> day) // not needing to check is_Valid as checked in construction
            d = Date(year, month, day);
    else
	    in.setstate(ios::failbit);	// Input failed, so spoil the stream
    return in;
}
