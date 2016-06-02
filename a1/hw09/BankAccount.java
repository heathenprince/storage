/* Anna Tolen
APCS1 pd10
HW09 -- CMYM
2015-09-29 */

public class BankAccount {

    // TESTS
    
    /*  public static void main (String [] args) {
	BankAccount Lucas = new BankAccount("Lucas", "password", "2222", "234567891", 213123);
	BankAccount Ethan = new BankAccount("Ethan","password","3970","205330566", 200);
	Lucas.printAll();
	Lucas.withdraw(239.34f); //f terminates num -- Java assumes it's a double
	Lucas.printAll();
	} */
    

    // instance vars
    private String fullName;
    private String password;
    private String pin;
    private String acctNum;
    private float balance;
    
    // set instance vars
    	
    public void setName( String name ) {
	fullName = name;
    }

    public void setPass( String pass ) {
	password = pass;
    }

    public void setPIN( String pinNum ) {
	pin = pinNum;
    }

    public void setAcctNum( String num ) {
	acctNum = num;
    }


    public void setBalance( float bal ) { 
	balance = bal;
    } 
    
    // -------------------------------------------------

    public void printAll() {
	String retStr;
	retStr = "NAME: " + fullName;
	retStr += "\nPASSWORD: " + password;
	retStr += "\nPIN NUMBER: " + pin;
	retStr += "\nACCOUNT NUMBER: " + acctNum;
	retStr += "\nACCOUNT BALANCE: $" + balance;
	System.out.println(retStr);
    }

    public void deposit( float amount ) {
	balance += amount;
	System.out.println("Your account balance is now $" + balance);
    }

    public void withdraw( float amount ) {
	balance -= amount;
	System.out.println("Your account balance is now $" + balance);
    }

    public BankAccount( String name, String password, String pinNum, String acctNum, float balance ) {
	setName(name);
	setPass(password);
	setPIN(pinNum);
	setAcctNum(acctNum);
	setBalance(balance);
    }
    

    
} // close BankAccount


