package com.shahzaib.finances;

public class SavingsAccountYear {
	private int startingBalance = 0;
	private int interestRate = 0;
	public int totalWithdrawn = 0;
	public int startingPrincipal;

	public SavingsAccountYear() {
		
	}
	
	public SavingsAccountYear(int startingBalance,int startingPrincipal,int interestRate) {
		this.startingBalance= startingBalance;
		this.startingPrincipal= startingPrincipal;
		this.interestRate = interestRate;
	}
	
	public int startingBalance() {
		return startingBalance;
	}
	
	public SavingsAccountYear nextYear(int capitalGainsTaxRate) {
		return new SavingsAccountYear(this.endingBalance(capitalGainsTaxRate),0,interestRate);
	}
	
	public int endingBalance(int capitalGainsTaxRate) {
		int modifiedStart=startingBalance - totalWithdrawnExceptCapitalGainsTax() - capitalGainsTaxIncurred(capitalGainsTaxRate);
		return modifiedStart + interestEarned(capitalGainsTaxRate);
	}
	
	public int startingPrincipal() {
		return startingPrincipal;
	}
	
	public int startingCapitalGains() {
		return startingBalance - startingPrincipal;
	}
	
	public int interestEarned(int capitalGainsTaxRate) {
		return (startingBalance - totalWithdrawnExceptCapitalGainsTax() - capitalGainsTaxIncurred(capitalGainsTaxRate)) * interestRate/100;
	}
	
	public int totalWithdrawnExceptCapitalGainsTax() {
		return totalWithdrawn;
	}
	
	public int totalWithdrawn(int capitalGainsTax) {
		return totalWithdrawnExceptCapitalGainsTax() + capitalGainsTaxIncurred(capitalGainsTax);
	}
	
	public int endingPrincipal() {
		int result = startingPrincipal()- totalWithdrawnExceptCapitalGainsTax();
		return Math.max(0, result);
	}
	
	public int endingCapitalGains() {
		return 0;
	}
	
	public int interestRate() {
		return interestRate;
	}

	public void withdraw(int amount) {
		this.totalWithdrawn += amount;
	}

	public int capitalGainsWithdrawn() {
		int result = -1*(startingPrincipal()-totalWithdrawnExceptCapitalGainsTax());
		return Math.max(0, result);
	}

	public int capitalGainsTaxIncurred(int taxRate) {
		double dblTaxRate = taxRate/100.0;
		double dblCapGains = capitalGainsWithdrawn();
		return (int)((dblCapGains/(1-dblTaxRate)) -dblCapGains);
	}

}
