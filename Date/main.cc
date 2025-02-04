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

#include "Date.h"
#include <fstream>	// ifstream
#include <string>	// string
#include <sstream>	// istringstream

using namespace std;

int main() {
    // Read & display some dates
    ifstream data("data");
    Date d;
    // Read each line, try to convert it to a date, complain if it fails.
    for (string s; getline(data, s); ) {
        istringstream iss(s);   // Initialize stream with string
        if (iss >> d)           // Try to convert to a date
            cout << d << '\n';
        else
            cerr << "Bad date \"" << s << "\"\n";
    }

    const Date a(2009,3,4);
    cout << a << '\n';		// Wed Mar 4 2009

    const Date b(a);
    cout << b << '\n';		// Wed Mar 4 2009

    Date c; c=a;
    cout << c << '\n';		// Wed Mar 4 2009

    c = c+1;
    cout << c << '\n';		// Thu Mar 5 2009
    c += 9;
    cout << c << '\n';		// Sat Mar 14 2009
    d = ++c;
    cout << c << '\n';		// Sun Mar 15 2009
    cout << d << '\n';		// Sun Mar 15 2009

    d = c++;
    cout << c << '\n';		// Mon Mar 16 2009
    cout << d << '\n';		// Sun Mar 15 2009

    Date e = d-1;
    cout << e << '\n';		// Sat Mar 14 2009
    d = e--;
    cout << d << '\n';		// Sat Mar 14 2009
    cout << e << '\n';		// Fri Mar 13 2009
    d = --e;
    cout << d << '\n';		// Thu Mar 12 2009
    cout << e << '\n';		// Thu Mar 12 2009
    e -= 5;
    cout << e << '\n';		// Sat Mar 7 2009
    e -= -2;
    cout << e << '\n';		// Mon Mar 9 2009
    cout << d-e << '\n';	// 3
    cout << e-d << '\n';	// -3

    // a==b, a<c
    cout << ((a==b) ? "== good\n" : "== bad\n");
    cout << ((a==c) ? "== bad\n"  : "== good\n");
    cout << ((a!=c) ? "!= good\n" : "!= bad\n");
    cout << ((a!=b) ? "!= bad\n"  : "!= good\n");
    cout << ((a<c)  ? "<  good\n" : "<  bad\n");
    cout << ((a<b)  ? "<  bad\n"  : "<  good\n");
    cout << ((c>a)  ? ">  good\n" : ">  bad\n");
    cout << ((b>a)  ? ">  bad\n"  : ">  good\n");
    cout << ((a<=b) ? "<= good\n" : "<= bad\n");
    cout << ((a<=c) ? "<= good\n" : "<= bad\n");
    cout << ((c<=a) ? "<= bad\n"  : "<= good\n");
    cout << ((a>=b) ? ">= good\n" : ">= bad\n");
    cout << ((c>=a) ? ">= good\n" : ">= bad\n");
    cout << ((a>=c) ? ">= bad\n"  : ">= good\n");

    //new coverage
    c.setday(1);
    cout << ((c.getday() == 1) ? "setday good\n" : "setday bad\n");
    c.setmonth(12);
    cout << ((c.getmonth() == 12) ? "setmonth good\n" : "setmonth bad\n");
    c.setyear(1942);
    cout << ((c.getyear() == 1942) ? "setmonth good\n" : "setmonth bad\n");
    c = 20 + c;
    cout << ((c.getday() == 21 && c.getmonth() == 12 && c.getyear() == 1942) ?
		"int + date good\n" : "int + date bad\n");

    istringstream isz("====-==-==");   // Initialize stream with string
        if (isz >> d);

    return 0;
}
