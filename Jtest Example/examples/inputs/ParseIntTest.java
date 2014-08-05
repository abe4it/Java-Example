package examples.inputs;

import junit.framework.Test;

/**
 * Unit test class for the "Integer.parseInt()" method.
 * 
 * @author staff
 */
public class ParseIntTest extends jtest.InputsTestCase
{
    /**
     * Test method invoked for each input
     * 
     * @param string  test case input argument
     * @param parsed_value  test case expected result
     */
    public void test (String string, int parsed_value) {
        assertTrue (Integer.parseInt (string) == parsed_value);
    }

    /**
     * Creates a test suite for running the tests in this class.
     * 
     * @return Test  the test suite
     */
    public static Test suite () {
        Object[][] inputs;

        if (READ_INPUTS_FROM_FILE) {
            inputs = readPrimitiveInputs ("examples/inputs/parseint.dat");
        } else {
            inputs = new Object [][] {
                  {"1", new Integer (1)}
                , {"5", new Integer (5)}
                , {"0", new Integer (7)}
            };
        }

        return suite (inputs);
    }
    
    private static final boolean READ_INPUTS_FROM_FILE = false;
}