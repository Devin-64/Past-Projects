/* Copyright (c) 2025 [Devin Dumonceau]
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 * Contact: [jobs.devin.dumonceau@gmail.com]	 */

#ifndef DATE_H_INCLUDED
#define DATE_H_INCLUDED

#include <iostream>	    // istream, ostream

class Date {
  protected:
    static int ymd_to_daynum(int year, int month, int day);
    int daynum;				// 1 = January 1, year 1

  public:
    Date();
    // Default copy ctor is fine
    // Default assignment operator is fine
    Date(int year, int month, int day);
    Date(int year, int month, int day, bool ymd_checked);

    int getday() const;
    int getmonth() const;
    int getyear() const;

    void setday(int);
    void setmonth(int);
    void setyear(int);

    Date &operator+=(int);
    int operator-(const Date &) const;

    Date operator+(int) const;
    const Date &operator++();	// prefix
    Date operator++(int);	// postfix

    Date operator-(int) const;
    Date &operator-=(int);
    const Date &operator--();	// prefix
    Date operator--(int);	// postfix

    bool operator<(const Date &) const;
    bool operator<=(const Date &) const;
    bool operator>(const Date &) const;
    bool operator>=(const Date &) const;
    bool operator==(const Date &) const;
    bool operator!=(const Date &) const;

};

//     bool in_range(int num, int l_bounds = 0, int u_bounds = 10);
//     bool is_valid_y(int year);
//     bool is_valid_m(int month);
//     bool is_valid_d(int year, int month, int day, bool y_valid = false, bool m_valid = false);

void year_assert(int year);
void month_assert(int month);
void day_assert(int year, int month, int day);
void ymd_assert(int year, int month, int day);
void daynum_assert(int daynum);

// non-methods (free functions):

Date operator+(int, const Date &);
std::ostream &operator<<(std::ostream &out, const Date &);	// YYYY-MM-DD
std::istream &operator>>(std::istream &in, Date &);		// YYYY-MM-DD

#endif /* DATE_H_INCLUDED */
