package examples.bank;

import junit.framework.Test;

/**
 * Unit test class for Transaction
 * 
 * @author staff
 */
public class TransactionTest extends jtest.InputsTestCase
{
    /**
     * Test method invoked for each input
     * 
     * @param account  test case input argument
     * @param transaction  test case input argument
     * @param expected_id  test case expected id
     * @param expected_balance  test case expected balance
     */
    public void test (
        BankAccount account,
        Transaction transaction, 
        int expected_id,
        int expected_balance
    ) {
        account.apply (transaction);

        int new_id = account.getCustomerId ();
        int new_balance = account.getBalance ();

        assertTrue ("new id is " + new_id + " expected " + expected_id
            , new_id == expected_id
        );
        assertTrue ("new balance is " + new_balance + " expected " + expected_balance
            , new_balance == expected_balance
        );
    }

    /**
     * Creates a test suite for running the tests in this class.
     * 
     * @return Test  the test suite
     */
	public static Test suite() {
		Object[][] inputs;

		BankAccount test_account = new BankAccount(1, 1000);

		inputs =
			new Object[][] {
				{
					test_account,
					new Deposit(100),
					new Integer(1),
					new Integer(1099)
				},
				{
				    test_account,
					new Withdraw(100),
					new Integer(1),
					new Integer(998)
				},
				{
                    test_account,
					new ChangeOwnership(2),
					new Integer(2),
					new Integer(978)
				}
		};

		return suite(inputs);
	}
}