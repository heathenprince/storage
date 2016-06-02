
public class Rogue extends Character{
    
    // methods
    // constructors
    public Rogue() {
        setName("Riley of Swiftneck"); //random names yay
        setHP( (int)((Math.random() * 100) + 50 )); // [50,150)
        setStrength( (int)((Math.random() * 100) + 55 )); // [55,155)
        setDefense( (int)((Math.random() * 20) + 10 )); // [10,30)
        setAR( Math.random() + .1); // random probability for landing hits [.01, 1.1)
        setSpatt((int) ((Math.random() * 7) + 1)); // [1, 8)
    }
    public Rogue( String n ) {
        this();
        setName(n);
    }
    public Rogue(String n, int h, int s, int d, double a) {
        this(n);
        setHP(h);
        setStrength(s);
        setDefense(d);
        setAR(a);
    }

} //close Rogue
