package com.shahzaib.finances;

public class SavingsAccountYear {
	private int startingBalance = 0;
	private int interestRate = 0;
	
	public SavingsAccountYear() {
		
	}
	
	public SavingsAccountYear(int startingBalance,int interestRate) {
		this.startingBalance= startingBalance;
		this.interestRate = interestRate;
	}
	
	public int startingBalance() {
		return startingBalance;
	}
	
	public void deposit(int amount) {
		startingBalance += amount;
	}
	
	public int balance() {
		return startingBalance;
	}
	
	public void withdraw(int amount) {
		startingBalance -= amount;
	}
	
	public SavingsAccountYear nextYear() {
		return new SavingsAccountYear(this.endingBalance(),interestRate);
	}
	
	public int endingBalance() {
		return balance() + (balance() * interestRate / 100);
	}
	
	public int interestRate() {
		return interestRate;
	}

}
