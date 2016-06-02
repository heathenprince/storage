public class codingBat {

    // The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on vacation. We sleep in if it is not a weekday or we're on vacation. Return true if we sleep in. 
    public boolean sleepIn( boolean weekday, boolean vacation ) {
	if (!weekday) {
		return true;
	    }
	else {
	    if ( vacation ) {
		return true;
	    }
	    else {
		return false;
	    }
	}
    }

    // We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is smiling. We are in trouble if they are both smiling or if neither of them is smiling. Return true if we are in trouble. 
    public boolean monkeyTrouble( boolean aSmile, boolean bSmile ) {
	if (( aSmile && bSmile ) || ( !aSmile && !bSmile )) {
	    return true;
	}
	else {
	    return false;
	}
    }

    // Given two int values, return their sum. Unless the two values are the same, then return double their sum.
    public int sumDouble( int a, int b ) {
	int ret = a+b;
	if ( a == b ) {
	    ret *= 2;
	}
	return ret;
    }

    // Given an int n, return the absolute difference between n and 21, except return double the absolute difference if n is over 21.
    public int diff21(int n) {
	int ret = Math.abs(21-n);
	if ( n > 21 ) {
	    ret *= 2;
	}
	return ret;
    }
    
    // We have a loud talking parrot. The "hour" parameter is the current hour time in the range 0..23. We are in trouble if the parrot is talking and the hour is before 7 or after 20. Return true if we are in trouble. 
    public boolean parrotTrouble( boolean talking, int hour ) {
	if (talking && ( (hour < 7) || (hour > 20) ) ) {
	    return true;
	}
	return false;
    }

    // Given 2 ints, a and b, return true if one if them is 10 or if their sum is 10.
    public boolean makes10( int a, int b ) {
	if ( ( (a == 10) || (b == 10) ) || (a + b == 10)) {
	    return true;
	}
	return false;
    }

    // Given an int n, return true if it is within 10 of 100 or 200. Note: Math.abs(num) computes the absolute value of a number. 
    public boolean nearHundred( int n ) {
	if ( (Math.abs(100 - n) <= 10) || (Math.abs(200 - n) <= 10) ) {
	    return true;
	}
	return false;
    }

    // Given 2 int values, return true if one is negative and one is positive. Except if the parameter "negative" is true, then return true only if both are negative.
    public boolean posNeg( int a, int b, boolean negative ) {
	if (negative) {
	    return ( (a < 0) && (b < 0));
	}
	else {
	    return ( ( (a < 0) && (b > 0)) || (a > 0) && (b < 0) );
	}
    }

    // Given a string, return a new string where "not " has been added to the front. However, if the string already begins with "not", return the string unchanged. Note: use .equals() to compare 2 strings.
    public String notString( String str ) {
	if ( "not " + str.substring(3).equals( str )) {
	    return str;
	}
	else {
	    return "not " + str;
	}
    }
    public String doubleChar( String str ) {
	String retStr = "";
	for( int i = 0; i < str.length(); i++ ) {
	    retStr += str.substring(i,i+1) +  str.substring(i,i+1);
	}
	return retStr;
    }

    public int countHi( String str ) {
	int count = 0;
	int len = str.length() - 1;
	for( int i = 0; i < len; i++ ) {
	    if (str.substring(i,i+2).equals("hi")) {
		    count += 1;
		}
	}
	return count;
    }

    public boolean catDog( String str ) {
	int catCount = 0;
	int dogCount = 0;
	for( int i = 0; i < str.length() - 2; i++ ) {
	    if( (str.substring(i,i+3).equals("cat") ) ) {
		catCount++;
	    }
	    else if( str.substring(i,i+3).equals("dog") ) {
		dogCount++;
	    }
	}
	if( catCount == dogCount )
	    return true;
	else
	    return false;
    }

    public int countCode( String str ) {
	int count = 0;
	for( int i = 0; i < str.length() - 3; i++) {
	    if( (str.substring(i,i+2).equals("co")) && (str.substring(i+3,i+4).equals("e")) ) {
		count++;
	    }
	}
	return count;
    }

   
	    
	
		
}		
