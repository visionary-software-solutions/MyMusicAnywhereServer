package com.visonarysoftwaresolutions.types;

import java.util.ArrayList;
import java.util.Collection;


public class Dates {
	private final Collection<Date> dates;
	
	public Dates() {
		dates = new ArrayList<>();
	}
	
	public void addDate(final Date toAdd) {
		dates.add(toAdd);
	}
	
	public NaturalNumber size() {
		return new NaturalNumber(dates.size());
	}

}
