package examples.nbank;

import junit.framework.TestCase;

/**
 * This is an example of a user defined JUnit test class for the Account class
 * It contains a test method that would be useful to Parameterize 
 * and use to test the Account class with many different inputs and expected outputs.
 * To Parameterize right click on the testApply() method in the editor or package explorer
 * and from the popup menu select Jtest -> Extract Parameterized Test Case
 */
public class AccountTest extends TestCase {

    public void testApply() {
        Customer customer = new Customer("Mary Smith", "111-11-1111");
        Account account = new Account(customer, 1000);
        DepositTransaction deposit = new DepositTransaction(500);
        account.apply(deposit);
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(200);
        account.apply(withdrawal);
        assertEquals(1300, account.getBalance());
        assertEquals(customer, account.getCustomer());
    }
    
    public void testApply2() {
        Customer customer = new Customer("Mary Smith", "111-11-1111");
        Account account = new Account(customer, 1000);
        DepositTransaction deposit = new DepositTransaction(500);
        account.apply(deposit);
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(200);
        account.apply(withdrawal);
        assertEquals(1300, account.getBalance());
    }
}