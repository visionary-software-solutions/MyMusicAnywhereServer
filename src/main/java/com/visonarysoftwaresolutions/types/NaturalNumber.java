package com.visonarysoftwaresolutions.types;

import java.util.Objects;

public class NaturalNumber extends Number {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1488390335513412329L;
	private final int number;

	public NaturalNumber(final int toNum) {
		if (toNum < 0) {
			throw new IllegalArgumentException("Invalid natural number.");
		}
		number = toNum;
	}

	@Override
	public double doubleValue() {
		return number;
	}

	boolean equals(final NaturalNumber another) {
		return number == another.number;
	}

	@Override
	public boolean equals(final Object another) {
		return (another instanceof NaturalNumber)
				&& equals((NaturalNumber) another);
	}

	@Override
	public float floatValue() {
		return number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public int intValue() {
		return number;
	}

	@Override
	public long longValue() {
		return number;
	}
	
	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
