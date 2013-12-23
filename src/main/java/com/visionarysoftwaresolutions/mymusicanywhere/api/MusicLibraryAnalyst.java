package com.visionarysoftwaresolutions.mymusicanywhere.api;


public interface MusicLibraryAnalyst {

	void incrementNumberOfPlaysForSong(Song song);

	Plays getPlaysForSong(Song song);

}
