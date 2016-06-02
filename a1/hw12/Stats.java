/* Anna Tolen
APCS1 pd10
HW12 -- stAtistically sPeaking
2015-10-05 */

public class Stats {

    public static int mean(int a, int b) {
	int ret = (a + b) / 2;
	return ret;
    }

    public static double mean(double a, double b) {
        double ret = (a + b) / 2;
	return ret;
    }
    
    public static int max(int a, int b) {
	if(a > b)
	    return a;
	else
	    return b;
    }

    public static double max(double a, double b) {
	if(a > b)
	    return a;
	else
	    return b;
    }

    
    public static int geoMean(int a, int b) {
	double trouble = Math.sqrt(a*b);
	int ret = (int)trouble;
	return ret;
    }

    public static double geoMean(double a, double b) {
	double ret = Math.sqrt(a*b);
	return ret;
    }
    
    
    public static void main( String [] args ) {
	System.out.println(mean(3,5)); // 4
	System.out.println(mean(4.2, 8.6)); // 6.4
	System.out.println(max(3,5)); // 5
	System.out.println(max(4.2,9.63)); // 9.63
	System.out.println(geoMean(4,9)); // 6
	System.out.println(geoMean(12.47, 1.268)); // 3.97642553...
    }


}
