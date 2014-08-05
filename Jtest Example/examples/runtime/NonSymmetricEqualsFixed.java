
package examples.runtime;

import junit.framework.TestCase;

/**
 * According to the Object.equals() javadoc all equals method implementation
 * should follow certain conditions (i.e. being symmetric).
 */
public class NonSymmetricEqualsFixed extends TestCase {
    
    public void test() {
        Object obj1 = new NonSymmetricEqualsFixed(3);
        Object obj2 = new NonSymmetricEqualsFixed(8);
        System.out.println(obj1.equals(obj2) == obj2.equals(obj1));
    }
    
    private final int _value;
    
    public NonSymmetricEqualsFixed(int value) {
        _value = value;
    }
    
    public boolean equals(Object obj) {
        NonSymmetricEqualsFixed other = (NonSymmetricEqualsFixed) obj;
        
        // FIX: equals is symmetric now
        return _value == other._value;
    }
}
