package examples.bank;

import static org.junit.Assert.assertEquals;

public class WithdrawTransactionTest 
{

	@org.junit.runner.RunWith(org.junit.runners.Parameterized.class)
	public static class Transaction extends WithdrawTransactionTest {
		private int _customer_id;
		private int _initial_balance;
		private int _amount;
		private int _outcome0;

		public Transaction(int customer_id, int initial_balance, int amount,
				int outcome0) {
			_customer_id = customer_id;
			_initial_balance = initial_balance;
			_amount = amount;
			_outcome0 = outcome0;

		}

		@org.junit.runners.Parameterized.Parameters
		public static java.util.Collection getParameters()
				throws java.lang.Exception {
			java.lang.Class[] types = new java.lang.Class[] { int.class,
					int.class, int.class, int.class, };
			java.util.List list = jtest.PT.getInputAsObjects(
					"WithdrawTransactionTest_Transaction_testTransaction",
					new String[] { "_customer_id", "_initial_balance",
							"_amount", "_outcome0", }, types);
			return list;
		}

		@org.junit.Test
		public void testTransaction() {
			BankAccount account = new BankAccount(_customer_id,
					_initial_balance);
			Withdraw transaction = new Withdraw(_amount);
			account.apply(transaction);
			int new_balance = account.getBalance();
			assertEquals(_outcome0, new_balance);
		}

	}

	@org.junit.runner.RunWith(org.junit.runners.Suite.class)
	@org.junit.runners.Suite.SuiteClasses({ WithdrawTransactionTest.Transaction.class, })
	public static class Suite {
	}
}
