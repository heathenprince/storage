/* Team Paranoid Android -- Grace Stempel, Anna Tolen
APCS1 pd10
HW42 -- Array of Titanium
2015-12-04 */


//interface extends features & functionality of int array

public interface ListInt {
    
    public void add( int newVal );
    public void add( int index, int newVal );
    public void remove( int index );
    public int size();
    public int get( int index );
    public int set( int index, int newVal );
}
