package com.visonarysoftwaresolutions.types;


public class Year {
	private final NaturalNumber year;
	
	public Year(final NaturalNumber theYear) {
		year = theYear;
	}
	
	@Override
	public int hashCode() {
		return year.hashCode();
	}
	
	@Override
	public boolean equals(final Object another) {
		return another instanceof Year && equals((Year) another);
	}
	
	boolean equals(final Year another) {
		return year.equals(another.year);
	}
	
	@Override
	public String toString() {
		return year.toString();
	}
}
