package com.shahzaib.finances;

import static org.junit.Assert.*;

import org.junit.Test;

public class _SavingsAccountTest {

	@Test
	public void depositAndWithdrawl() {
		SavingsAccount account = new SavingsAccount();
		account.deposit(100);
		assertEquals("After deposit",100,account.balance());
		account.withdraw(50);
		assertEquals("After withdrawl",50,account.balance());
	}
	
	@Test
	public void negativeBalanceIsJustFine() {
		SavingsAccount account = new SavingsAccount();
		account.withdraw(75);
		assertEquals(-75,account.balance());
	}
	
	@Test
	public void nextYear() {
		SavingsAccount account = new SavingsAccount();
		account.deposit(10000);
		SavingsAccount nextYear = account.nextYear(10);
		assertEquals(11000,nextYear.balance());
		
	}

}
