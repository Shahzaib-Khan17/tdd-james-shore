package com.shahzaib.finances;

public class StockMarketYear {
	private int startingBalance ;
	private InterestRate interestRate ;
	public int totalWithdrawals ;
	public int startingPrincipal;
	public TaxRate capitalGainsTaxRate;

	public StockMarketYear() {
		
	}
	
	public StockMarketYear(int startingBalance,int startingPrincipal,InterestRate interestRate,TaxRate capitalGainsTaxRate) {
		this.startingBalance= startingBalance;
		this.startingPrincipal= startingPrincipal;
		this.interestRate = interestRate;
		this.totalWithdrawals = 0;
		this.capitalGainsTaxRate = capitalGainsTaxRate;
	}
	
	public int startingBalance() {
		return startingBalance;
	}
	
	public StockMarketYear nextYear() {
		return new StockMarketYear(this.endingBalance(),this.endingPrincipal(),this.interestRate(),this.capitalGainsTaxRate());
	}
	
	public int startingPrincipal() {
		return startingPrincipal;
	}
	
	public int totalWithdrawn() {
		return totalWithdrawals + capitalGainsTaxIncurred();
	}
	
	public int endingPrincipal() {
		int result = startingPrincipal()- totalWithdrawals;
		return Math.max(0, result);
	}
	
	public int interestEarned() {
		return interestRate.interestOn(startingBalance - totalWithdrawn());
	}
	
	public int endingBalance() {
		return startingBalance - totalWithdrawn() + interestEarned();
	}
	
	public InterestRate interestRate() {
		return interestRate;
	}
	
	public TaxRate capitalGainsTaxRate() {
		return capitalGainsTaxRate;
	}
	
	public void withdraw(int amount) {
		this.totalWithdrawals += amount;
	}

	private int capitalGainsWithdrawn() {
		int result = -1*(startingPrincipal()-totalWithdrawals);
		return Math.max(0, result);
	}

	public int capitalGainsTaxIncurred() {
		return capitalGainsTaxRate.compoundTaxFor(capitalGainsWithdrawn());
	}
}
