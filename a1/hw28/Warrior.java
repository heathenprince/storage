public class Warrior {

    // attributes
    private String name;
    private int hp; // hit points 
    private int strength;
    private int defense;
    private double ar; // attack rating -- % chance that you hit target
    private int special; // amount attack/defense atttributes go up/down

    // methods
    // constructors
    public Warrior() {
        setName("Pat"); 
        setHP( 200 );
	setStrength( 50 );
        setDefense( 50 );
        setAR( Math.random() ); // random probability for landing hits
        setSpecial((int)((Math.random() * 10) + 1));
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

    public int getHP() {
	    return hp;
    }

    public int getStrength() {
	    return strength;
    }

    public int getDefense() {
	    return defense;
    }

    public double getAR() {
	    return ar;
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
    public boolean isAlive() {
	    return (hp > 0);
    }

    public void lowerHP( int hit ) {
	    hp -= hit;
    }

    public int attack( Monster monster ) {
	int damage = (int)(getStrength() * getAR() - monster.getDefense());
	if (damage > 0) {
	    monster.lowerHP( damage );
	}
	else {
	    damage = 0;
	    monster.lowerHP( damage );
	}
	return damage;
    }

    public void specialize() {
        setDefense(getDefense() - getSpecial());
        setStrength(getStrength() + getSpecial());
    }

    public void normalize() {
        setDefense(getDefense() + getSpecial());
        setStrength(getStrength() - getSpecial());
    }

}

    

    
