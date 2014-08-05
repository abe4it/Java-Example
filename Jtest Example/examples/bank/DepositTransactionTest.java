package examples.bank;

import static org.junit.Assert.*;

public class DepositTransactionTest 
{

	@org.junit.runner.RunWith(org.junit.runners.Parameterized.class)
	public static class Transaction extends DepositTransactionTest {
		private int _customer_id;
		private int _initial_balance;
		private int _amount;
		private int _outcome0;
		private int _outcome1;

		public Transaction(int customer_id, int initial_balance, int amount,
				int outcome0, int outcome1) {
			_customer_id = customer_id;
			_initial_balance = initial_balance;
			_amount = amount;
			_outcome0 = outcome0;
			_outcome1 = outcome1;

		}

		@org.junit.runners.Parameterized.Parameters
		public static java.util.Collection getParameters()
				throws java.lang.Exception {
			java.lang.Class[] types = new java.lang.Class[] { int.class,
					int.class, int.class, int.class, int.class, };
			java.util.List list = jtest.PT.getInputAsObjects(
					"DepositTransactionTest_Transaction_testTransaction",
					new String[] { "_customer_id", "_initial_balance",
							"_amount", "_outcome0", "_outcome1", }, types);
			return list;
		}

		@org.junit.Test
		public void testTransaction() {
			BankAccount account = new BankAccount(_customer_id,
					_initial_balance);
			Deposit transaction = new Deposit(_amount);
			account.apply(transaction);

			int new_id = account.getCustomerId();
			int new_balance = account.getBalance();
			assertEquals(_outcome0, new_id);
			assertEquals(_outcome1, new_balance);
		}

	}

	@org.junit.runner.RunWith(org.junit.runners.Suite.class)
	@org.junit.runners.Suite.SuiteClasses({ DepositTransactionTest.Transaction.class, })
	public static class Suite {
	}
}
