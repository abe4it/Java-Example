package examples.nbank;

import junit.framework.TestCase;

/**
 * Example of a user defined JUnit3 dynamic test case class.
 */
public  class AccountDynamicTest extends TestCase {

    private int _initial, _deposit, _withdraw, _expexted;

    public AccountDynamicTest(String sName, int initial, 
            int deposit, int withdraw, int expected) {
        super(sName);
        _initial = initial;
        _deposit = deposit;
        _withdraw = withdraw;
        _expexted = expected;
    }

    @Override
    protected void runTest() {
        testApply();
    }

    public void testApply() {
        Customer customer = new Customer("Mary Smith", "111-11-1111");
        Account account = new Account(customer, _initial);
        DepositTransaction deposit = new DepositTransaction(_deposit);
        account.apply(deposit);
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(_withdraw);
        account.apply(withdrawal);
        assertEquals(_expexted, account.getBalance());
    }
}

