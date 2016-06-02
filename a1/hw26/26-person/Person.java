public class Person {
    // instance vars
    private Face face;
    private Body body;
    private String firstName;
    private String lastName;
    
    // default constructor
    public Person() {
	face = new Face();
	body = new Body();
	firstName = "William";
	lastName = "Shatner";
    }

    // overloaded constructors

    public Person( Face face ) {
	this();
	setFace(face);
    }
    
    public Person( String first, String last ) {
    	setFirstName(first);
	setLastName(last);
    }
    
    public Person( String first, String last, Face face ) {
	this(first,last);
	setFace(face);
	setBody(new Body());
    }
    
    public String toString() {
 	String retStr = "";
	retStr += face;
	retStr += body + "\n";
	retStr += firstName + " ";
	retStr += lastName + "\n";
	return retStr;
    }

    public Face getFace() {
	return face;
    }

    public Body getBody() {
	return body;
    }

    public String getFirstName() {
	return firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setFace( Face newFace ) {
	face = newFace;
    }

    public void setBody( Body newBody ) {
	body = newBody;
    }

    public void setFirstName( String newFirstName ) {
	firstName = newFirstName;
    }

    public void setLastName( String newLastName ) {
	lastName = newLastName;
    }
}
