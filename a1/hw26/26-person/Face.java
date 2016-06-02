public class Face {
    // instance vars
    private String hair;
    private String eyes;
    private String nose;
    private String mouth;

    // default constructor
    public Face() {
	hair = "|||||||";
	eyes = "| o o |";
	nose = "|  >  |";
	mouth = "| --- |";
    }


    // overloaded constructor
    public Face( String newHair, String newEyes, String newNose, String newMouth ) {
	this();
	setHair(newHair);
	setEyes(newEyes);
	setNose(newNose);
	setMouth(newMouth);
    }

    // overwritten toString()
    public String toString() {
	String retStr = "";
	retStr += hair + "\n";
	retStr += eyes + "\n";
	retStr += nose + "\n";
	retStr += mouth + "\n";
	
	return retStr;
    }
    
    // accessors
    public String getHair() {
	return hair;
    }

    public String getEyes() {
	return eyes;
    }

    public String getNose() {
	return nose;
    }

    public String getMouth() {
	return mouth;
    }
    
    // mutators
    public void setHair( String newHair ) {
	hair = newHair;
    }

    public void setEyes( String newEyes ) {
	eyes = newEyes;
    }

    public void setNose( String newNose ) {
	nose = newNose;
    }

    public void setMouth( String newMouth ) {
	mouth = newMouth;
    }

}
       
