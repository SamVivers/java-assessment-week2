package main;

import static org.junit.Assert.assertFalse;

public class OfflineExercises {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") → "TTThhheee"
	// multChar("AAbb") → "AAAAAAbbbbbb"
	// multChar("Hi-There") → "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String a = "";
		for (int i = 0; i < input.length(); i++) {
			a += input.substring(i, i + 1) + input.substring(i, i + 1) + input.substring(i, i + 1);
		}
		return a;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") → "evilc"
	// getBert("xxbertfridgebertyy") → "egdirf"
	// getBert("xxBertfridgebERtyy") → "egdirf"
	// getBert("xxbertyy") → ""
	// getBert("xxbeRTyy") → ""

	public String getBert(String input) {
		String a = "";
		String b = "";
		String c = "";
		for (int i = 3; i < input.length(); i++) {
			if (input.substring(i - 3, i + 1).equalsIgnoreCase("bert")) {
				a += input.substring(i + 1, input.length());
				break;
			}
		}
		for (int i = a.length(); i > 0; i--) {
			b += a.substring(i - 1, i);
		}
		for (int i = 3; i < b.length(); i++) {
			if (b.substring(i - 3, i + 1).equalsIgnoreCase("treb")) {
				c += b.substring(i + 1, b.length());
				break;
			}
		}
		return c;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false
	// evenlySpaced(4, 60, 9) → false

	public boolean evenlySpaced(int a, int b, int c) {
		int A = 0;
		int B = 0;
		int C = 0;
		if (a < b && b < c) {
			A = a;
			B = b;
			C = c;
		} else if (a < b && b > c && c < a){
			A = c;
			B = a;
			C = b;
		} else if (a < b && b > c && c > a){
			A = a;
			B = c;
			C = b;
		}
		if (B - A == C - B) {
			return true;
		} else {
			return false;
		}	
	}
	// Not all cases considered

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) → "Ho"
	// nMid("Chocolate", 3) → "Choate"
	// nMid("Chocolate", 1) → "Choclate"

	public String nMid(String input, int a) {
		String b = "";
		for (int i = 0; i < (input.length() - a) / 2; i++) {
			b += input.substring(i, i + 1);
		}
		for (int i = (input.length() + a) / 2 ; i < input.length(); i++) {
			b += input.substring(i, i + 1);
		}
		return b;
	}

	// Given a string, return true if it ends in "dev". Ignore Case

	// endsDev("ihatedev") → true
	// endsDev("wehateDev") → true
	// endsDev("everoyonehatesdevforreal") → false
	// endsDev("devisnotcool") → false
	// Hidden! endsDev("jh"));
	
	public boolean endsDev(String input) {
		if (input.length() < 3) {
			return false;
		} else {
			if (input.substring(input.length() - 3, input.length()).equalsIgnoreCase("dev")) {
				return true;
			} else {
				return false;
			}
		}
	}
	


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") → 2
	// superBlock("abbCCCddDDDeeEEE") → 3
	// superBlock("") → 0

	public int superBlock(String input) {
		int n = 0;
		for (int j = 1; j <= input.length() ; j++) {
			for (int i = 0; i < input.length() - j + 1; i++) {
				if (input.substring(i, i + j - 1).equals(input.substring(i + 1, i + j))) {
					n = j;
				}
			}
		}
		return n;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") → 1
	//amISearch("I am in Amsterdam am I?") → 2
	//amISearch("I have been in Amsterdam") → 0

	public int amISearch(String arg1) {
		int n = 0;
		for (int i = 0; i < arg1.length() - 3; i++) {
			if (arg1.substring(i, i + 4).equalsIgnoreCase(" am ")) {
				n++;
			}
		}
		if (arg1.substring(0, 3).equalsIgnoreCase("am ")) {
			n++;
		}
		if (arg1.substring(arg1.length() - 3, arg1.length()).equalsIgnoreCase(" am")) {
			n++;
		}
		return n;
		
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) → "fizz"
	//fizzBuzz(10) → "buzz"
	//fizzBuzz(15) → "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		String a = "";
		if (arg1 % 3 == 0) {
			a += "fizz";
		}
		if (arg1 % 5 == 0) {
			a += "buzz";
		}
		return a;
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") → 14
	//largest("15 72 80 164") → 11
	//largest("555 72 86 45 10") → 15
	
	
	public int largest(String arg1) {
		int a = 0;
		int n = 0;
		for (int i = 0; i < arg1.length(); i++) {
			if (arg1.substring(i, i + 1).equals("1")) {
				a += 1;
			}
			if (arg1.substring(i, i + 1).equals("2")) {
				a += 2;
			}
			if (arg1.substring(i, i + 1).equals("3")) {
				a += 3;
			}
			if (arg1.substring(i, i + 1).equals("4")) {
				a += 4;
			}
			if (arg1.substring(i, i + 1).equals("5")) {
				a += 5;
			}
			if (arg1.substring(i, i + 1).equals("6")) {
				a += 6;
			}
			if (arg1.substring(i, i + 1).equals("7")) {
				a += 7;
			}
			if (arg1.substring(i, i + 1).equals("8")) {
				a += 8;
			}
			if (arg1.substring(i, i + 1).equals("9")) {
				a += 9;
			}
			if (arg1.substring(i, i + 1).equals(" ") || i == arg1.length() -1) {
				if (a > n) {
					n = a;
				}
				a = 0;
			}
		}
	return n;
	}
	
	
}
