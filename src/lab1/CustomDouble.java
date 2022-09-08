package lab1;

import java.util.Objects;

public class CustomDouble {
	private int integer;
	private double decimal;

	public CustomDouble(final int integer, final double decimal) {
		this.integer = integer;
		this.decimal = decimal;
	}

	public CustomDouble(final double number) {
		this.integer = (int)number;
		this.decimal = number - (int)number;				
	}
	
	public double toDouble() {
		return integer+decimal;
	}
	
	public String toString() { 
		return Double.toString(toDouble());
	}
	
	public CustomDouble add(final CustomDouble cd) {
		final double result = toDouble() + cd.toDouble();
 		integer = (int)result;
		decimal = result - (int)result;
		return this;
	}

	public CustomDouble minus(final CustomDouble cd) {
		final double result = toDouble() - cd.toDouble();
		integer = (int)result;
		decimal = result - (int)result;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final CustomDouble that = (CustomDouble) o;
		return integer == that.integer && Double.compare(that.decimal, decimal) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(integer, decimal);
	}
}
