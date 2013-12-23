package com.visionarysoftwaresolutions.mymusicanywhere.server;

import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibraryAnalyst;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Play;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Plays;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visonarysoftwaresolutions.types.Date;

public class InMemoryLibraryAnalyst implements MusicLibraryAnalyst {
	Plays plays = new PlayHistory();
	
	@Override
	public void incrementNumberOfPlaysForSong(Song song) {
		Play played = new DefaultPlay(song, new Date());
		plays.add(played);
	}

	@Override
	public Plays getPlaysForSong(Song song) {
		PlayHistory songPlayed = new PlayHistory();
		for (Play play : plays) {
			if (play.getSong().equals(song)) {
				songPlayed.add(play);
			}
		}
		return songPlayed;
	}
}
