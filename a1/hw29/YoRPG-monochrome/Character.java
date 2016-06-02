public class Character {

    //instance vars
    protected int hp;
    protected int strength;
    protected int defense;
    protected double ar;


    //accessors
    public int getHP( Character character ) {
	return character.hp;
    }

    public int getStrength( Character character ) {
	return character.strength;
    }

    public int getDefense( Character character ) {
	return character.defense;
    }

    public double getAR( Character character ) {
	return character.ar;
    }


    //methods
    public boolean isAlive() {
	return (hp > 0);
    }

    public void lowerHP( int hit ) {
	hp -= hit;
    }

    public int attack( Character opponent ) {
	int damage = (int)( (strength * ar) - getDefense(opponent) );
	//System.out.println( "\t\t**DIAG** damage: " + damage );

	if ( damage < 0 )
	    damage = 0;

	opponent.lowerHP( damage );

	return damage;
    }
    
}
