/* Copyright (c) 2024 [Devin Dumonceau]
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


#include <cstdint>
#include <string>

namespace Individual_Values {

/*  SELECTORS   */
// Each battle stat is represented by a unique charecter litteral in octal
// These are used as indexes to identify the respective stat in the bit-packed data.
#define HP  (_i8)'\0'      // Index for Hit Points (health)
#define ATT (_i8)'\1'      // Index for Attack
#define DEF (_i8)'\2'      // Index for Defense
#define SPA (_i8)'\3'      // Index for Special Attack
#define SPD (_i8)'\4'      // Index for Special Defense
#define SPE (_i8)'\5'      // Index for Speed

/* IV BIT MASK */
// Masks are used to isolate specific groups of bits in the 32-bit data
// Each retreives 5 bits worth to be able to represent the 0-31 value range
#define HP_MASK  (_i32) 0xF8'00'00'00 // 1111'1000'...        (bits 31-27)
#define ATT_MASK (_i32) 0x07'C0'00'00 // ... 0111'1100'...    (bits 26-22)
#define DEF_MASK (_i32) 0x00'3E'00'00 // ... 0011'1110'...    (bits 21-17)
#define SPA_MASK (_i32) 0x00'01'F0'00 // ... 0001'1111'...    (bits 16-12)
#define SPD_MASK (_i32) 0x00'00'0F'80 // ... 1111'1000'...    (bits 11-07)
#define SPE_MASK (_i32) 0x00'00'00'7C // ... 0111'1100'...    (bits 06-02)
#define REM_MASK (_i32) 0x00'00'00'03 // ... 0000'0011        (bits 01-00)
#define LOW5_MASK (_i8)(0x1F)

/* BIT SHIFT */
// Shifts are used to align the desired bits to the least significant position.
#define HP_SHIFT  (_i8)'\33'       // Shift HP bits down by 27 to isolate them
#define ATT_SHIFT (_i8)'\26'       // Shift Attack bits down by 22
#define DEF_SHIFT (_i8)'\21'       // Shift Defense bits down by 17
#define SPA_SHIFT (_i8)'\14'       // Shift Special Attack bits down by 12
#define SPD_SHIFT (_i8)'\7'        // Shift Special Defense bits down by 7
#define SPE_SHIFT (_i8)'\2'        // Shift Speed bits down by 2

/* MACROS */

// p_index expected value from 0-31 representing bit to be retreaved from stats
// Step One:   Sifts a 1 bit (1000 ....) to the right by amount from p_index
// Step Two:   Binary ANDs the bit mask with the stats to get the value 0 or 1
// Step Three: Returns '\0' or '\1' based on conditional value from Steps 2
#define GET_BIT(stats, index) ((stats) & (0x8000'0000 >> (index)) ? '\1' : '\0')

// Step One:    Add the input (p_num) to current value of stat which could exceed
//              the range of 0-31 which is then stored in p_num
// Step Two:	The value from the previous opperation is then used as in a tertiary
//              statment with p_num being binary ANDed with the inverse of the 
//				LOW5_MASK which checks if any carry operations happen in which case
//				it is right shifted by 5 bits to overflow into the 0-31 range which
//				p_num is now set to so it can be read as need be
#define WRAP_LOW5(p_num) ((p_num) = ((p_num) & ~LOW5_MASK ? (p_num) >> '\5' : (p_num)))

// Macro to match the correct bitmask based on the index given (used in place of 
// constexpr _i32 [] to avoid static memory usage)
#define BIT_MASK(index)	((index) == '\0' ? HP_MASK  : (index) == '\1' ? ATT_MASK : \
     					 (index) == '\2' ? DEF_MASK : (index) == '\3' ? SPA_MASK : \
     					 (index) == '\4' ? SPD_MASK : SPE_MASK)

// Macro to match the correct bitshift based on the index given (used in place of 
// constexpr _i8 [] to avoid static memory usage)
#define BIT_SHIFT(index)	((index) == '\0' ? HP_SHIFT  : (index) == '\1' ? ATT_SHIFT :\
    						 (index) == '\2' ? DEF_SHIFT : (index) == '\3' ? SPA_SHIFT :\
    						 (index) == '\4' ? SPD_SHIFT : SPE_SHIFT)

/* ALIASES */
typedef uint32_t _i32;        // 32-bit unsigned integer for IV storage
typedef uint8_t _i8;          // 8-bit unsigned integer for smaller values

class IV {
  protected:
		_i32 stats;       // Packed 32-bit integer holding all IV data

  public:
  	// Accessor for raw bit by treating stats as an array
	_i8 operator[](_i8 p_index) {	
		return GET_BIT(stats, p_index);
	}

	// Getter to extract IVs based on stat index
	_i8 get (_i8 p_index) { // TODO Explination NEEDED
		if (HP <= p_index <= SPE) {
			// Step One:	Stats is bit shifted to the right the correct number of steps
			//				so that the desired information is in lower 5 bits
			// Step Two:	Return the Binary AND with LOW5_MASK for only the last 5 bits
			//				3 bit 0 padding such that the value is within the range 0-31
			return (stats >> BIT_SHIFT(p_index) & LOW5_MASK);
			// return (stats & BIT_MASK(p_index)) >> BIT_SHIFT(p_index); // shift and just and with low5;
		}
		return (stats & REM_MASK);
	}

	// Convenience getters for individual stats
	_i8 getHP ()	{ return get(HP);  }
	_i8 getAtt()	{ return get(ATT); }
	_i8 getDef()	{ return get(DEF); }
	_i8 getSpA()	{ return get(SPA); }
	_i8 getSpD()	{ return get(SPD); }
	_i8 getSpe()	{ return get(SPE); }
	_i8 getRem()	{ return get('\200'); }	// Retrieve remainder
	_i32& getFull()	{ return stats; }	// Retrieve full packed IV data

	//  SETTERS
	void set (_i8 p_index, _i8& p_num) {	// Assumes that p_num is a LMSB _i8 with a
		if (HP <= p_index <= SPE) {			// range between 0-31
		// Step One:    Using the correct bit mask it is inverted have 0 bits in the 
		//              the positions for that variable while having 1 bits in all
		//              other bit locations
		// Step Two:    Binary ANDs the mask with stats clearing the correct 5 bits
		//              while preserving all other data; required for the next step
		// Step Three:  Binary shifts the trunkated p_num to the left to line up with
		//              the cleared bits (this implicitly makes it of a _i32 to have
		//              the nessesary amount of space while padding with zeros)
		// Step Four:   The two results are binary ORed with the p_num now having its
		//              result in the correct bits
			stats = (stats & ~BIT_MASK(p_index)) | ((p_num & LOW5_MASK) << BIT_SHIFT(p_index));
		} else {
			stats = (stats & ~REM_MASK) | (p_num & LOW5_MASK); } // Reserved bits for invalid indices
	}

	void setHP   (_i8& p_num) { set(HP,  p_num); }
	void setATT  (_i8& p_num) { set(ATT, p_num); }
	void setDEF  (_i8& p_num) { set(DEF, p_num); }
	void setSPA  (_i8& p_num) { set(SPA, p_num); }
	void setSPD  (_i8& p_num) { set(SPD, p_num); }
	void setSPE  (_i8& p_num) { set(SPE, p_num); }
	void setRem  (_i8& p_num) { set('\200', p_num); }
	void setFull (_i32& p_stats) { stats = p_stats; }

	void add (_i8 p_index, _i8& p_num) {
	// Step One:    Retrieve the current value of the stat specified by p_index using
	//              the get() function to extract the 5-bit value from the stats
	// Step Two:	Writes the new value to the correct location in the stats variable
	//				using the set() function
		p_num += get(p_index);
		set(p_index, WRAP_LOW5(p_num));	}

	// call add with the address of a local variable that is derefrenced as the changed
	// value does not matter
	void increment (_i8 p_index) { add(p_index, *(_i8*)'\1'); }
	// uses setFull to maximize all bits
	void max () { setFull(*(_i32*) 0xFF'FF'FF'FF); }
	// uses set with an index to set the value to 31 for the correct variable
	void max (_i8 p_index) { set(p_index, *(_i8*) '\37'); }

	//  SUBTRACT
	void sub (_i8 p_index, _i8& p_num) {	// uses the same structure as add but
		p_num = ~p_num + 1 + get(p_index);	// negates p_num using bitwise inverse + 1
		set(p_index, WRAP_LOW5(p_num));	}

	// negative equivelent to increment
	void decrement (_i8 p_index) { sub(p_index, *(_i8*)'\1'); }
	// sets all bits to zero
	void clear () { setFull( *(_i32*) 0x00'00'00'00);}
	// sets the correct bits based on p_index to zero
	void clear (_i8 p_index) { set(p_index, *(_i8*)'\0'); }

};

	std::string rawToString (IV& p_IVs) {
		std::string rtn = "";   rtn.resize('\40'); //declares and sizes rtn to 32 char
		// initializes i to -1 before incrementing in each comparison for 32 times
		// with each read byte appended to the rtn string; uses the overloaded []
		for (char i = '\377'; ++i < '\40';) { rtn += p_IVs[i]; } 
		return rtn; // return string
	}

	std::string rawToString (_i32& p_stats) {
		std::string rtn = "";   rtn.resize('\40');
		// uses bitwise indexing 
		for (char i = '\377'; ++i < '\40';) { rtn += GET_BIT(p_stats, i); } 
		return rtn; // return string
	}
