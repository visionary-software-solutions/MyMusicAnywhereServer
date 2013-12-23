package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.util.HashMap;
import java.util.Map;

import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibraryAnalyst;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visonarysoftwaresolutions.types.NaturalNumber;

public class InMemoryLibraryAnalyst implements MusicLibraryAnalyst {
	Map<Song, NaturalNumber> plays = new HashMap<>();
	
	@Override
	public void incrementNumberOfPlaysForSong(Song song) {
		if (!plays.containsKey(song)) {
			NaturalNumber newPlay = new NaturalNumber(1);
			plays.put(song, newPlay);
		} else {
			NaturalNumber playCount = plays.get(song);
			NaturalNumber newCount = new NaturalNumber(
					playCount.intValue() + 1);
			plays.put(song, newCount);
		}
	}

	@Override
	public NaturalNumber getNumberOfPlaysForSong(Song song) {
		return plays.get(song);
	}

}
