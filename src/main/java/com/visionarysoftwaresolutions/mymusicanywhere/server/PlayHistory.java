package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Play;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Plays;
import com.visonarysoftwaresolutions.types.Date;
import com.visonarysoftwaresolutions.types.Dates;
import com.visonarysoftwaresolutions.types.NaturalNumber;

public class PlayHistory implements Plays {
	Collection<Play> played = new ArrayList<>();
	
	@Override
	public NaturalNumber count() {
		return new NaturalNumber(played.size());
	}

	@Override
	public Dates dates() {
		Dates datesPlayed = new Dates();
		for (Play aPlay : played) {
			datesPlayed.addDate(aPlay.getDate());
		}
		return datesPlayed;
	}

	@Override
	public boolean withinLastNHours(NaturalNumber hours) {
		final long millisToHours = 1000 * 60 * 60 * hours.intValue();
		final Date hoursAgo = new Date(millisToHours);
		boolean result = true;
		for (Play aPlay: played) {
			result = result && aPlay.getDate().after(hoursAgo);
		}
		return result;
	}

	@Override
	public void add(Play toAdd) {
		played.add(toAdd);
	}

	@Override
	public Iterator<Play> iterator() {
		return played.iterator();
	}
}
