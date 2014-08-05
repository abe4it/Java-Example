
package examples.nbank;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is an example of a user defined JUnit 4 test class for the Account class It contains a
 * test method that would be useful to Parameterize and use to test the Account class with many
 * different inputs and expected outputs. To Parameterize right click on the testApply() method
 * in the editor or package explorer and from the popup menu select Jtest -> Extract
 * Parameterized Test Case
 */
public class AccountJUnit4Test
{

    @Test
    public void testApply()
    {
        Customer customer = new Customer("Mary Smith", "111-11-1111");
        Account account = new Account(customer, 1000);
        DepositTransaction deposit = new DepositTransaction(500);
        account.apply(deposit);
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(200);
        account.apply(withdrawal);
        Assert.assertEquals(1300, account.getBalance());
        Assert.assertEquals(customer, account.getCustomer());
    }
}