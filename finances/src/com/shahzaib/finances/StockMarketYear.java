package com.shahzaib.finances;

public class StockMarketYear {
	private Dollars startingBalance ;
	private InterestRate interestRate ;
	public Dollars totalWithdrawals ;
	public Dollars startingPrincipal;
	public TaxRate capitalGainsTaxRate;

	public StockMarketYear() {
		
	}
	
	public StockMarketYear(Dollars startingBalance,Dollars startingPrincipal,InterestRate interestRate,TaxRate capitalGainsTaxRate) {
		this.startingBalance= startingBalance;
		this.startingPrincipal= startingPrincipal;
		this.interestRate = interestRate;
		this.totalWithdrawals = new Dollars(0);
		this.capitalGainsTaxRate = capitalGainsTaxRate;
	}
	
	public Dollars startingBalance() {
		return startingBalance;
	}
	
	public StockMarketYear nextYear() {
		return new StockMarketYear(this.endingBalance(),this.endingPrincipal(),this.interestRate(),this.capitalGainsTaxRate());
	}
	
	public Dollars startingPrincipal() {
		return startingPrincipal;
	}
	
	public Dollars totalWithdrawn() {
		return totalWithdrawals.add(capitalGainsTaxIncurred());
	}
	
	public Dollars endingPrincipal() {
		return startingPrincipal.subtractToZero(totalWithdrawals);
	}
	
	public Dollars interestEarned() {
		return interestRate.interestOn(startingBalance.subtract(totalWithdrawn()));
	}
	
	public Dollars endingBalance() {
		return startingBalance.subtract(totalWithdrawn()).add(interestEarned());
	}
	
	public InterestRate interestRate() {
		return interestRate;
	}
	
	public TaxRate capitalGainsTaxRate() {
		return capitalGainsTaxRate;
	}
	
	public void withdraw(Dollars amount) {
		// TODO: Convert amount to dollars
		this.totalWithdrawals = totalWithdrawals.add(amount);
	}

	private Dollars capitalGainsWithdrawn() {
		return totalWithdrawals.subtractToZero(startingPrincipal());
	}

	public Dollars capitalGainsTaxIncurred() {
		return capitalGainsTaxRate.compoundTaxFor(capitalGainsWithdrawn());
	}
}
