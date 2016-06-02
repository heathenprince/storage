/* Team Cytosis -- Gabriel Marks, Anna Tolen, Ruochong Wu
APCS1 pd10
HW21 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
2015-10-26 */
//a Pig Latin translator

import java.util.Scanner;
public class Pig {

    private static final String VOWELS = "aeiou";
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";


    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") --> true  
			hasA("cat", "p") --> false
      =====================================*/
    public static boolean hasA( String w, String letter ) {
	for( int i = 0; i < w.length(); i++ ) {
	    if( w.substring(i,i+1).equals(letter) )
		return true;
	}
	return false; 
    }//closes hasA()


    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) {
	if( hasA( VOWELS, letter ) )
	    return true;
	else
	    return false; 
    }



    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") --> 3
      =====================================*/
    public static int countVowels( String w ) {
	int count = 0;
	for( int i = 0; i < w.length(); i++ ) {
	    String letter = w.substring(i,i+1);
	    if( isAVowel(letter) ) {
		count++;
	    }
	}	       
	return count; 
    }


    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") --> true
			hasAVowel("zzz") --> false
      =====================================*/
    public static boolean hasAVowel( String w ) {
	for( int i = 0; i < w.length(); i++ ){
	    String letter = w.substring(i,i+1);
	    if( isAVowel(letter) ) 
		return true;
	}
  	return false; 
    }
    

    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") --> "eaa"
      =====================================*/
    public static String allVowels( String w ) {
	String retStr = "";
	for( int i = 0; i < w.length(); i++ ) {
	    String letter = w.substring(i,i+1);	    
	    if( isAVowel(letter) ) {
		retStr += letter;
	    }
	}
	return retStr;
    }


    /*=====================================
      String firstVowel(String) -- returns first vowel in a String
      pre:  w != null
      post: firstVowel("") --> ""
      firstVowel("zzz") --> ""
      firstVowel("meatball") --> "e"
      =====================================*/
    public static String firstVowel( String w ) {
	String s = allVowels(w);
	return s.substring(0,1);
    }
    
    
    /*=====================================
      boolean beginsWithVowel(String) -- tells whether String begins with a vowel
      pre:  w != null and w.length() > 0
      post: beginsWithVowel("apple")  --> true
      beginsWithVowel("strong") --> false
      =====================================*/
    public static boolean beginsWithVowel( String w ) {
	if( isAVowel(w.substring(0,1)) )
	    return true;
	else
	    return false; //placeholder to get past compiler
    }



    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isNonAlpha( String chr ) {
	return ( !hasA( ALPHABET, chr ) );
	    }

    public static boolean hasNonAlpha( String w ) {
	for( int i = 0; i < w.length(); i++ ) {
	    String letter = w.substring(i,i+1);
	    if( isNonAlpha(letter) )
		return true;
	}
	return false;
    }
    
    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") --> 3
      =====================================*/
    public static int countNonAlpha( String w ) {
	int count = 0;
	for( int i = 0; i < w.length(); i++ ) {
	    String chr = w.substring(i,i+1);
	    if( isNonAlpha(chr) ) {
		count++;
	    }
	}	       
	return count; 
    }
    
   /*=====================================
    int findNonAlpha(String) -- returns index of first non-alpha character
    pre: w != null, w.length() > 0
    post: hasNonAlpha("hello!") --> 5
    hasNonAlpha("mr.brownmykolyk") --> 2
    hasNonAlpha("j-a-v-a") --> 1
    hasNonAlpha("google") --> -1
    =====================================*/

    public static int findNonAlpha( String w ) {
	for( int i = 0; i < w.length(); i++ ) {
	    if( !(hasA(ALPHABET,w.substring(i,i+1))) ) 
		return i;
	}
	return -1;
    }

    /* =====================================
    String fixPunc(String) -- returns word/phrase in Pig Latin with correct spacing & punctuation
    pre:  w.length() > 0
    post: engToPig("hello!")  --> "ellohay!"
    engToPig("what? help") --> "atwhay? elphay"
    engToPig("java")   --> "avajay"
    =====================================*/


    public static String fixPunc( String w ) {
	String w1 = w.toLowerCase();
	int i = findNonAlpha(w1);
	String retStr = engToPig(w1);
	if( (hasNonAlpha(w1)) ) {
	    retStr = engToPig(w1.substring(0,i));	    
	    retStr += w1.substring(i,i+1);
	    
	    
	    if( ((w1.substring(i).length() > 1)) ) 
		retStr += fixPunc(w1.substring(i+1));
	    else
		retStr += w1.substring(i+1);
	    }
	if (!( w.substring(0,1).equals(w.substring(0,1).toLowerCase()))){
	    return retStr.substring(0,1).toUpperCase()+retStr.substring(1);
	}
	else {
	    return retStr;
	}
    }

    
   /*=====================================
    String engToPig(String) -- converts an English word to Pig Latin
    pre:  w.length() > 0
    post: engToPig("apple")  --> "appleway"
    engToPig("strong") --> "ongstray"
    engToPig("java")   --> "avajay"
    =====================================*/
    public static String engToPig( String w ) {
	String retStr;
	
	if( beginsWithVowel(w) )
	    retStr = w + "way";
	
	
	else {
	    int i;
	    if( hasA(w,"y") )
		i = firstVowelY(w);
	    else
		i = w.indexOf(firstVowel(w));
	    retStr = w.substring(i) + w.substring(0,i) + "ay";
	}
	return retStr; 
    }

    public static int firstVowelY( String w ) {
	String s = w.substring(1); // y is a consonant if first
	if( hasA(s,"y") && hasAVowel(s)) {
	    int yInd = s.indexOf("y");
	    int vInd = s.indexOf(firstVowel(s));
	    return Math.min(yInd,vInd) + 1;	    
	}
	if( countVowels(s) == 0 )
	    return s.indexOf("y") + 1;
	else
	    return s.indexOf(firstVowel(s)) + 1;
    }    

    public static void main( String[] args ) {

	//Some test calls. You are encouraged to add more.
	
	//	String letter = "p";
	
	/*	for( String w : args ) {
	    System.out.println( w + " has " + letter + "? " + hasA( w, letter ) );
	}   
	*/
	
	for( String word : args ) {
	    //  System.out.println( allVowels(word) );
	    // System.out.println( firstVowel(word) );
	    //System.out.println( countVowels(word) );
	    //	    System.out.println( engToPig(word) );
	    System.out.println( fixPunc(word) );
	   
	}
	Scanner sc = new Scanner (System.in);
	while (sc.hasNext()){
	    System.out.println(fixPunc(sc.next()));
	}
	
    }//end main()
    
}//end class Pig

