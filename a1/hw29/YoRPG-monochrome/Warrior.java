//Monochrome--Arpita Abrol, Shamaul Dilmohamed, Anna Tolen
//APCS1 pd10
//HW28 -- Ye Olde Role Playing Game
//2015-11-12

public class Warrior extends Character{

    // attributes
    private String name;
    private int special; // amount attack/defense atttributes go up/down

    
    // methods
    // constructors
    public Warrior() {
        setName("John Smith"); //random names yay
        setHP( (int)((Math.random() * 100) + 50 )); // [50,150)
        setStrength( (int)((Math.random() * 100) + 50 )); // [50,150)
        setDefense( (int)((Math.random() * 30) + 10 )); // [10,40)
        setAR( Math.random() ); // random probability for landing hits
        setSpecial((int) ((Math.random() * 10) + 1));
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

    
    //accessors
    public String getName() {
	    return name;
    }
    
    public int getSpecial() {
        return special;
    }

    
    // mutators
    public void setName( String newName ) {
	    name = newName;
    }

    public void setHP( int newHP ) {
	    hp = newHP;
    }

    public void setStrength( int newStrength ) {
	    strength = newStrength;
    }

    public void setDefense( int newDefense ) {
	    defense = newDefense;
    }

    public void setAR( double newAR ) {
    	ar = newAR;
    }
    
    public void setSpecial(int newSpecial) {
        special = newSpecial;
    } 

    
    // other methods

    public void specialize() {
        setDefense(defense - special);
        setStrength(strength + special);
    }

    public void normalize() {
        setDefense(defense + special);
        setStrength(strength - special);
    }

}

    

    
