public class Character {

    
    // attributes
    protected String name;
    protected int hp; // hit points
    protected int strength;
    protected int defense;
    protected double ar; // attack rating -- % chance that you'll hit a target 
    protected int spatt; //special attack

    
    // accessors
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

    public int getSpatt() {
	return spatt;
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

    public void setSpatt( int newSpatt ) {
	spatt = newSpatt;
    }

    
    // other methods
    public boolean isAlive() {
	return (this.getHP() > 0);
    }
    
    public void lowerHP( int hit ) {
	this.setHP( this.getHP() -  hit );
    }

    public int attack( Character opp ) {
	int damage = (int)(this.strength * this.ar) - opp.getDefense();

	if ( damage < 0 )
	    damage = 0;

	opp.lowerHP( damage );

	return damage;
    }

    public void specialize() {
	setStrength( strength + spatt );
	setDefense( defense - spatt );
    }

    public void normalize() {
	setStrength( strength - spatt );
	setDefense( defense + spatt );
    }

    public static String about() {
	String retStr = "";
	retStr += "WARRIOR :\tWarriors are a proud sort, noble in spirit and skilled in battle. They have great proficiency with short-range weapons (e.g. shortswords, longswords, broadswords, axes, spears, ninja stars, lightsabers...). Normally equipped with heavy armor. They fight for the honor of their kingdom and the good of their people.\n";
	retStr += "MAGE :\tMages are keen, with an unwavering discipline. Their magic is great, and highly dangerous. They attack with their vast array of ranged spells, including the ability to summon fire, and many other spells known to just the mages and the foes unlucky enough to have made an enemy of a mage. But, their great power comes with a fatal weakness. They have no armor, and are left weakened after casting such powerful spells. They fight for the honor of their kingdon and the good of their people..\n";
	retStr += "ROGUE :\tRogues are stealthy and versatile, capable of the highest deception, and always looking out for themselves--or the highest bidder. They are profecient with quick, short-range weapons (e.g. daggers, knives, shortswords...). They typically have little to no armor. Their loyalty can be bought in gold.\n";
	retStr += "MONSTER :\tMonsters are single-minded, and desire to follow their leader, slow and cumbersome, yet powerful. They attack with their fists, and short-range weapons (clubs, axes, spears...). They need not use any armor, for monsters have unusually thick skin. They fight for the glory of their leader.\n";
	retStr += "DEMON :\tDemons are keen, with an unwavering discipline. Their magic is great, and highly dangerous. They attack with their vast variety of spells, which include the ability to summon lesser demons, and other spells known to just the demons and those who have been slaughtered by them. However, their great power comes with a fatal weakness. They have no armor, and are left weakened after casting such powerful spells. They fight for the glory of their leaders.\n";
	return retStr;
    }

} //end class
