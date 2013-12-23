package com.visonarysoftwaresolutions.types;

import java.util.Comparator;
import java.util.Objects;

public class Date implements Comparable<Date> {
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
		return compareTo(toCheck) > 0;
	}
	
	public boolean before(Date toCheck) {
		return compareTo(toCheck) < 0;
	}
    /* This doesn't work as you would expect
	@Override
	public int compareTo(Date o) {
		return (int) (timestamp - o.timestamp);
	}
	*/
	@Override
	public int compareTo(Date o) {
		return Objects.compare(timestamp, o.timestamp, new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				return o1.compareTo(o2);
			}
		});
	}
}
