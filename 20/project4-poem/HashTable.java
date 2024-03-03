
// QuadraticProbing Hash table class
//
// CONSTRUCTION: an approximate initial size or default of 101
//
// ******************PUBLIC OPERATIONS*********************
// bool insert( x )       --> Insert x
// bool remove( x )       --> Remove x
// bool contains( x )     --> Return true if x is present
// void makeEmpty( )      --> Remove all items


import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Probing table implementation of hash tables.
 * Note that all "matching" is based on the equals method.
 * @author Mark Allen Weiss
 */
public class HashTable<E, K>
{
    /**
     * Construct the hash table.
     */
    public HashTable( )
    {
        this( DEFAULT_TABLE_SIZE );
    }

    /**
     * Construct the hash table.
     * @param size the approximate initial size.
     */
    public HashTable( int size )
    {
        allocateArray( size );
        doClear( );
    }

    /**
     * Insert into the hash table. If the item is
     * already present, do nothing.
     * Implementation issue: This routine doesn't allow you to use a lazily deleted location.  Do you see why?
     * @param item the item to insert.
     */
    public boolean insert(E key, K item)
    {
        // Insert x as active
        int currentPos = findPos( key );
        if( isActive( currentPos ) )
            return false;
        ArrayList<Object> entry = new ArrayList<>(2);
        entry.add(key);
        entry.add(item);
        array[ currentPos ] = (HashEntry<E>) new HashEntry<>(entry, true );
        currentActiveEntries++;

        // Rehash; see Section 5.5
        if( ++occupiedCt > array.length / 2 )
            rehash( );

        return true;
    }

    public String toString (int limit){
        StringBuilder sb = new StringBuilder();
        int ct=0;
        for (int i=0; i < array.length && ct < limit; i++){
            if (array[i]!=null && array[i].isActive) {
                sb.append( i + ": " + array[i].element + "\n" );
                ct++;
            }
        }
        return sb.toString();
    }

    /**
     * Expand the hash table.
     */
    private void rehash( )
    {
        HashEntry<E> [ ] oldArray = array;

        // Create a new double-sized, empty table
        allocateArray( 2 * oldArray.length );
        occupiedCt = 0;
        currentActiveEntries = 0;

        // Copy table over
        for (HashEntry<E> entry : oldArray) {
            if (entry != null && entry.isActive) {
                ArrayList<Object> elements = (ArrayList<Object>) entry.element;
                insert( (E)elements.get(0), (K)elements.get(1));
            }
        }
    }

    /**
     * Method that performs quadratic probing resolution.
     * @param key the item to search for.
     * @return the position where the search terminates.
     * Never returns an inactive location.
     */
    //implement double hashing here
    private int findPos( E key ) {
        int offset = myHash2(key);
        int currentPos = myhash(key);
        while (array[currentPos] != null) {
            ArrayList<Object> element = (ArrayList<Object>) array[currentPos].element;
            if (element != null && element.get(0).equals(key)) {
                return currentPos; // Found the key, return the current position
            }
            currentPos += offset; // Compute ith probe
            //offset += 2;
            if (currentPos >= array.length) {
                currentPos -= array.length;
            }
        }
        return currentPos;
    }

    /**
     * Remove from the hash table.
     * @param item the item to remove.
     * @return true if item removed
     */
    public boolean remove( E item )
    {
        int currentPos = findPos( item );
        if( isActive( currentPos ) )
        {
            array[ currentPos ].isActive = false;
            currentActiveEntries--;
            return true;
        }
        else
            return false;
    }

    /**
     * Get current size.
     * @return the size.
     */
    public int size( )
    {
        return currentActiveEntries;
    }

    /**
     * Get length of internal table.
     * @return the size.
     */
    public int capacity( )
    {
        return array.length;
    }

    /**
     * Find an item in the hash table.
     * @param item the item to search for.
     * @return true if item is found
     */
    public boolean contains( E item )
    {
        int currentPos = findPos( item );
        return isActive( currentPos );
    }

    /**
     * Find an item in the hash table.
     * @param item the item to search for.
     * @return the matching item.
     */
    public ArrayList<Object> find(E item )
    {
        int currentPos = findPos( item );
        if (!isActive( currentPos )) {
            return null;
        }
        else {
            ArrayList<Object> element = new ArrayList<>();
            element.add(array[currentPos].element);
            element = (ArrayList<Object>) element.get(0);
            return element;
        }
    }

    /**
     * Return true if currentPos exists and is active.
     * @param currentPos the result of a call to findPos.
     * @return true if currentPos is active.
     */
    private boolean isActive( int currentPos )
    {
        return array[ currentPos ] != null && array[ currentPos ].isActive;
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty( )
    {
        doClear( );
    }

    private void doClear( )
    {
        occupiedCt = 0;
        for( int i = 0; i < array.length; i++ )
            array[ i ] = null;
    }

    private int myhash( E item )
    {
        int hashVal = item.hashCode( );

        hashVal %= array.length;
        if( hashVal < 0 )
            hashVal += array.length;

        return hashVal;
    }

    private int myHash2(E item){
        String var = (String) item;
        char[] myChars = var.toCharArray();
        int val = 0;
        for (int i = 0; i < myChars.length; i++) {
            int x = myChars[i];
            val += x;
        }
        int step = 11-(val%11);
        return step;
    }

    private static class HashEntry<E>
    {
        public E  element;   // the element
        public boolean isActive;  // false if marked deleted

        public HashEntry( E e )
        {
            this( e, true );
        }

        public HashEntry( E e, boolean i )
        {
            element  = e;
            isActive = i;
        }
    }

    private static final int DEFAULT_TABLE_SIZE = 101;

    private HashEntry<E> [ ] array; // The array of elements
    private int occupiedCt;         // The number of occupied cells: active or deleted
    private int currentActiveEntries;                  // Current size

    /**
     * Internal method to allocate array.
     * @param arraySize the size of the array.
     */
    private void allocateArray( int arraySize )
    {
        array = new HashEntry[ nextPrime( arraySize ) ];
    }

    /**
     * Internal method to find a prime number at least as large as n.
     * @param num the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     *
     */
    private static int nextPrime( int num )
    {
        if( num % 2 == 0 )
            num++;

        for( ; !isPrime( num ); num += 2 )
            ;

        return num;
    }

    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     * @param num the number to test.
     * @return the result of the test.
     */
    private static boolean isPrime( int num )
    {
        if( num == 2 || num == 3 )
            return true;

        if( num == 1 || num % 2 == 0 )
            return false;

        for( int i = 3; i * i <= num; i += 2 )
            if( num % i == 0 )
                return false;

        return true;
    }


    // Simple main
    public static void main(String[] args) {
        HashTable<String, String> H = new HashTable<>();
        // Add your test code here.
        File file = new File("green.txt");
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                String word = reader.next();
                word = word.toLowerCase();
                if(!H.contains(word)) {
                    H.insert(word, "e");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(H.contains("green"));
        System.out.println(H.contains("sam"));
        System.out.println(H.contains("?"));
        System.out.println(H.contains("aaa"));
        System.out.println();
        System.out.println(H.toString(25));
        System.out.println();
        H.remove("green");
        H.remove("eggs");
        H.remove("bacon");
        System.out.println();
        System.out.println(H.toString(25));
        System.out.println();

        ArrayList<Object> info = H.find("sam");
        System.out.println(info);
        System.out.println(info.get(0));
        System.out.println(info.get(1));

    }
}

