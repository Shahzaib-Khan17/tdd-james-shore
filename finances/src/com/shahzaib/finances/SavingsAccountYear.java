package com.shahzaib.finances;

public class SavingsAccountYear {
	private int startingBalance = 0;
	private int interestRate = 0;
	private int capitalGainsAmount = 0;
	public int totalWithdrawn = 0;
	public SavingsAccountYear() {
		
	}
	
	public SavingsAccountYear(int startingBalance,int capitalGainsAmount,int interestRate) {
		this.startingBalance= startingBalance;
		this.interestRate = interestRate;
		this.capitalGainsAmount = capitalGainsAmount;
	}
	
	public SavingsAccountYear(int startingBalance,int interestRate) {
		this.startingBalance= startingBalance;
		this.interestRate = interestRate;
	}
	
	public int startingBalance() {
		return startingBalance;
	}
	
	public SavingsAccountYear nextYear() {
		return new SavingsAccountYear(this.endingBalance(),interestRate);
	}
	
	public int endingBalance() {
		int modifiedStart=startingBalance - totalWithdrawn;
		return modifiedStart + (modifiedStart * interestRate / 100);
	}
	
	public int startingPrincipal() {
		return startingBalance - capitalGainsAmount;
	}
	
	public int endingPrincipal() {
		int result = startingPrincipal()- totalWithdrawn;
		return (result<0)?0:result;
	}
	
	public int interestRate() {
		return interestRate;
	}

	public void withdraw(int amount) {
		this.totalWithdrawn += amount;
	}

	
}