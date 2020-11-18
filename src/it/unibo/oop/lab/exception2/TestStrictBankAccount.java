package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit test to test {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

	/**
	 * Used to test Exceptions on {@link StrictBankAccount}.
	 */
	@Test
	public void testBankOperations() {
		/*
		 * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a scelta,
		 * con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
		 * 
		 * 2) Effetture un numero di operazioni a piacere per verificare che le
		 * eccezioni create vengano lanciate soltanto quando opportuno, cioè in presenza
		 * di un id utente errato, oppure al superamento del numero di operazioni ATM
		 * gratuite.
		 */
		AccountHolder h1 = new AccountHolder("Marsild", "Spahiu", 1);
		AccountHolder h2 = new AccountHolder("Albi", "Spahiu", 2);
		BankAccount marsild = new StrictBankAccount(h1.getUserID(), 10000, 10);
		BankAccount albi = new StrictBankAccount(h2.getUserID(), 10000, 10);
		try {
			marsild.deposit(h2.getUserID(), 10);
		} catch (WrongAccountHolderException e) {
			assertTrue(e.toString().contains("WrongAccountHolderException [id inserito=" + h2.getUserID() + "]"));
		}
		try {
			albi.deposit(h1.getUserID(), 10);
		} catch (WrongAccountHolderException e) {
			assertTrue(e.toString().contains("WrongAccountHolderException [id inserito=" + h1.getUserID() + "]"));
		}
		try {
			for (int i = 0; i < 20; i++) {
				marsild.deposit(h1.getUserID(), 10);
			}
		}
		catch(TransactionsOverQuotaException e) {
			assertTrue(e.toString().contains("TransactionsOverQuotaException [transazioni=" + marsild.getTransactionCount() + "]"));
		}
		try {
			albi.withdraw(h2.getUserID(), 50000);
		}
		catch(NotEnoughFoundsException e) {
			assertTrue(e.toString().contains("NotEnoughFoundsException [balance=" + albi.getBalance() + "]"));
		}
	}
}
