
public class Warrior extends Character{
    
    // methods
    // constructors
    public Warrior() {
        setName("Sam of Hollowstone"); //random names yay
        setHP( (int)((Math.random() * 100) + 50 )); // [50,150)
        setStrength( (int)((Math.random() * 100) + 55 )); // [55,155)
        setDefense( (int)((Math.random() * 30) + 15 )); // [15,45)
        setAR( Math.random() - .1); // random probability for landing hits [-.1,.9)
        setSpatt((int) ((Math.random() * 7) + 1)); // [1,8)
    }
    public Warrior( String n ) {
        this();
        setName(n);
    }
    public Warrior(String n, int h, int s, int d, double a) {
        this(n);
        setHP(h);
        setStrength(s);
        setDefense(d);
        setAR(a);
    }

} //close Warrior

    

    
