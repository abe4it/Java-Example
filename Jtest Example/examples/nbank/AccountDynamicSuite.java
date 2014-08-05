package examples.nbank;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Example of a user defined JUnit3 dynamic tests suite class.
 */
public class AccountDynamicSuite extends TestSuite {

    public AccountDynamicSuite() {
        addTest(new AccountDynamicTest("test1", 1000, 500, 200, 1300));
        addTest(new AccountDynamicTest("test2", 1000, 500, 1501, 0));
        addTest(new AccountDynamicTest("test3", 0, 0, 0, 0));
        addTest(new AccountDynamicTest("test4", 0, 500, 500, 0));
    }

    /**
     * Creates a test suite for running the tests in this class.
     * @return A test suite to run the tests
     */
    public static Test suite() throws Exception {
        return new AccountDynamicSuite();
    }
}
