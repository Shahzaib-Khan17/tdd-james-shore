package com.shahzaib.finances;

import java.util.Objects;

public class TaxRate {
	
	private double rate;

	public TaxRate(double rateAsPercentage) {
		this.rate = rateAsPercentage /100.0;
		
	}

	public Dollars simpleTaxFor(Dollars amount) {
		return new Dollars((int)(rate *amount.toInt()));
	}

	public Dollars compoundTaxFor(Dollars amount) {
		int amountAsInt = amount.toInt();
		return new Dollars((int)((amountAsInt/(1-rate))-amountAsInt));
	}
	
	@Override
	public String toString() {
		return (rate * 100) + "%";
	}

	@Override
	public int hashCode() {
		return Objects.hash(rate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxRate other = (TaxRate) obj;
		return Double.doubleToLongBits(rate) == Double.doubleToLongBits(other.rate);
	}

}
