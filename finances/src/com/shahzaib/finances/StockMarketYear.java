package com.shahzaib.finances;

public class StockMarketYear {
	private int startingBalance ;
	private int interestRate ;
	public int totalWithdrawals ;
	public int startingPrincipal;

	public StockMarketYear() {
		
	}
	
	public StockMarketYear(int startingBalance,int startingPrincipal,int interestRate) {
		this.startingBalance= startingBalance;
		this.startingPrincipal= startingPrincipal;
		this.interestRate = interestRate;
		this.totalWithdrawals = 0;
	}
	
	public int startingBalance() {
		return startingBalance;
	}
	
	public StockMarketYear nextYear(int capitalGainsTaxRate) {
		return new StockMarketYear(this.endingBalance(capitalGainsTaxRate),this.endingPrincipal(),this.interestRate());
	}
	
	public int endingBalance(int capitalGainsTaxRate) {
		int modifiedStart=startingBalance - totalWithdrawn(capitalGainsTaxRate);
		return modifiedStart + interestEarned(capitalGainsTaxRate);
	}
	
	public int startingPrincipal() {
		return startingPrincipal;
	}
	
	public int totalWithdrawn(int capitalGainsTax) {
		return totalWithdrawals + capitalGainsTaxIncurred(capitalGainsTax);
	}
	
	public int endingPrincipal() {
		int result = startingPrincipal()- totalWithdrawals;
		return Math.max(0, result);
	}
	
	public int interestEarned(int capitalGainsTaxRate) {
		return (startingBalance - totalWithdrawn(capitalGainsTaxRate)) * interestRate/100;
	}
	
//	public int endingCapitalGains(int capitalGainsTaxRate) {
//		return endingBalance(capitalGainsTaxRate) - endingPrincipal();
//	}
	
	public int interestRate() {
		return interestRate;
	}
	
	public void withdraw(int amount) {
		this.totalWithdrawals += amount;
	}

	public int capitalGainsWithdrawn() {
		int result = -1*(startingPrincipal()-totalWithdrawals);
		return Math.max(0, result);
	}

	public int capitalGainsTaxIncurred(int taxRate) {
		double dblTaxRate = taxRate/100.0;
		double dblCapGains = capitalGainsWithdrawn();
		return (int)((dblCapGains/(1-dblTaxRate)) -dblCapGains);
	}

}
