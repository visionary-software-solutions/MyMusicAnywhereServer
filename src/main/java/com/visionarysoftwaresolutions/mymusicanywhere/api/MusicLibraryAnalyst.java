package com.visionarysoftwaresolutions.mymusicanywhere.api;

import com.visonarysoftwaresolutions.types.NaturalNumber;

public interface MusicLibraryAnalyst {

	void incrementNumberOfPlaysForSong(Song song);

	NaturalNumber getNumberOfPlaysForSong(Song song);

}
