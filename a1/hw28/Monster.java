public class Monster {

    // attributes
    private int hp; // hit points 
    private int strength;
    private int defense;
    private double ar; // attack rating -- % chance that you hit target

    // methods
    // constructor 
    public Monster() {
	    int randStrenf = (int)(Math.random() * 45 + 20); // random int [20,65)
	    setStrength( randStrenf ); 

	    setHP( 150 );
	    setDefense( 20 );
	    setAR( 1 );
    }

    //accessors

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

    // mutators

    public void setHP( int newHP ) {
    	hp = newHP;
    }

    public void setStrength( int newStrength ) {
    	strength = newStrength;
    }

    public void setDefense( int newDefense ) {
    	defense = newDefense;
    }

    public void setAR( int newAR ) {
    	ar = newAR;
    }

    // other methods
    public boolean isAlive() {
    	return (hp > 0);
    }

    public void lowerHP( int hit ) {
    	hp -= hit;
    }

    public int attack( Warrior warrior ) {
	int damage = (int)(getStrength() * getAR() - warrior.getDefense());
    	if (damage > 0) {
	    warrior.lowerHP( damage );
	}
	else {
	    damage = 0;
	    warrior.lowerHP( damage );
	}
    	return damage;
    }
} // close class Monster

    

    
