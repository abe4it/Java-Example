
package examples.runtime;

import junit.framework.TestCase;

/**
 * According to the Object.equals() javadoc all equals method implementation
 * should follow certain conditions (i.e. being symmetric).
 */
public class NonSymmetricEquals extends TestCase {
    
    public NonSymmetricEquals(String name) {
        super(name);
    }
    
    public void testOne() {
        Object obj1 = new NonSymmetricEquals(3);
        Object obj2 = new NonSymmetricEquals(8);
        System.out.println(obj1.equals(obj2) == obj2.equals(obj1));
    }
    
    private int _value;
    
    public NonSymmetricEquals(int value) {
        _value = value;
    }
    
    public boolean equals(Object obj) {
        NonSymmetricEquals other = (NonSymmetricEquals) obj;
        
        // VIOLATION: breaks symmetry: x.equals(y) should return true if and
        // only if y.equals(x) returns true
        return _value >= other._value;
    }
    
    public String toString() {
        return "NonSymmetricEquals[" + _value + ']';
    }
}
