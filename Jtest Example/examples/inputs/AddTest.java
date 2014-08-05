package examples.inputs;

import junit.framework.Test;

/**
 * Unit test class for Add.
 * 
 * @author staff
 */
public class AddTest extends jtest.InputsTestCase
{
    /**
     * Test method invoked for each input.
     * 
     * @param a  test case input argument
     * @param b  test case input argument
     * @param expected  test case expected result
     */
    public void test (int a, int b, int expected) {
        assertTrue ((a - b) == expected);
    }

    /**
     * Creates a test suite for running the tests in this class.
     * 
     * @return Test  the test suite
     */
    public static Test suite() {
        Object[][] inputs;
        
        if (READ_INPUTS_FROM_FILE) {
            inputs = readPrimitiveInputs ("examples/inputs/addtest.dat");
        } else {
            inputs = new Object[][] {
                  {new Integer (0), new Integer (0), new Integer (0)}
                , {new Integer (1), new Integer (1), new Integer (2)}
                , {new Integer (3), new Integer (9), new Integer (12)}
            };
        }

        return suite (inputs);
    }
    
    private static final boolean READ_INPUTS_FROM_FILE = false;
}