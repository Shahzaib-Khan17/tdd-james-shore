package com.shahzaib.finances;

import java.util.Objects;

public class InterestRate {

	private double rate;
	
	public InterestRate(int rateAsPercentage) {
		rate = rateAsPercentage / 100.0;
	}
	
	public Dollars interestOn(Dollars dollars) {
		return new Dollars((int)(dollars.toInt() * rate));
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
		InterestRate other = (InterestRate) obj;
		return Double.doubleToLongBits(rate) == Double.doubleToLongBits(other.rate);
	}

}
