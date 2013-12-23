package com.visonarysoftwaresolutions.types;

import java.util.Objects;

public class Date {
	private final long timestamp;
	
	public Date() {
		timestamp = System.nanoTime();
	}
	
	public Date(final long millisToHours) {
		timestamp = millisToHours;
	}

	@Override
	public int hashCode() {
		return Objects.hash(timestamp);
	}
	
	@Override
	public boolean equals(final Object another) {
		return another instanceof Date &&
			   equals((Date) another); 
	}
	
	private boolean equals(final Date another) {
		return timestamp == another.timestamp;
	}

	public boolean after(Date toCheck) {
		return timestamp - toCheck.timestamp > 0;
	}
	
	public boolean before(Date toCheck) {
		return timestamp - toCheck.timestamp < 0;
	}

}
