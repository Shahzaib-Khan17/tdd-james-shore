package com.shahzaib.finances;

import java.util.Objects;

public class TaxRate {
	
	private double rate;

	public TaxRate(double rateAsPercentage) {
		this.rate = rateAsPercentage /100.0;
		
	}
	
	public int rate() {
		return (int)(rate * 100); // TODO: delete me
	}

	public int simpleTaxFor(int amount) {
		return (int)(rate *amount);
	}

	public int compoundTaxFor(int amount) {
		return (int)((amount/(1-rate))-amount);
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
