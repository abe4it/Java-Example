package examples.runtime;

import junit.framework.TestCase;

public class AddTest extends TestCase {
    
    public void testAdd() {
        int MAX = Integer.MAX_VALUE;
        assertEquals((long) MAX + 3, Add.add(MAX, 3));
    }
}
