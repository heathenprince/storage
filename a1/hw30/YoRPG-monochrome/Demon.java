
public class Demon extends Character{
    
    // methods
    // constructors
    public Demon() {
        setName("Tatum of Moorbridge"); //random names yay
        setHP( (int)((Math.random() * 100) + 50 )); // [50,150)
        setStrength( (int)((Math.random() * 100) + 60 )); // [60,160)
        setDefense( (int)((Math.random() * 30) + 5 )); // [5,35)
        setAR( Math.random() ); // random probability for landing hits
        setSpatt((int) ((Math.random() * 10) + 1)); // [1,11)
    }
    public Demon( String n ) {
        this();
        setName(n);
    }
    public Demon(String n, int h, int s, int d, double a) {
        this(n);
        setHP(h);
        setStrength(s);
        setDefense(d);
        setAR(a);
    }

} //close Demon
