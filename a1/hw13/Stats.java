/* Anna Tolen
APCS1 pd10
HW13 -- May ah Hahv S'maur Please?
2015-10-06 */

public class Stats {

    public static double max(double a, double b, double c) {
	if(a > b)
	    if(a > c)
		return a;
	    else
		return c;
	else
	    if(b > c)
		return b;
	    else
		return c;
    }

    
    public static int geoMean(int a, int b, int c) {
	double trouble = Math.cbrt(a*b*c);
	int ret = (int)trouble;
	return ret;
    }
   
    public static double geoMean(double a, double b, double c) {
	double ret = Math.cbrt(a*b*c);
	return ret;
    }
}
