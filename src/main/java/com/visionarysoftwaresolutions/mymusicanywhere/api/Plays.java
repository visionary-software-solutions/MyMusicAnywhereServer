package com.visionarysoftwaresolutions.mymusicanywhere.api;

import com.visonarysoftwaresolutions.types.Dates;
import com.visonarysoftwaresolutions.types.NaturalNumber;

public interface Plays extends Iterable<Play> {

	NaturalNumber count();

	Dates dates();

	boolean withinLastNHours(NaturalNumber hours);

	void add(Play toAdd);
}
