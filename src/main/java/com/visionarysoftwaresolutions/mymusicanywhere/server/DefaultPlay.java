package com.visionarysoftwaresolutions.mymusicanywhere.server;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Play;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visonarysoftwaresolutions.types.Date;

public class DefaultPlay implements Play {
	private final Song song;
	private final Date playedAt;
	
	public DefaultPlay(final Song song, final Date played) {
		this.song = song;
		this.playedAt = played;
	}
	
	@Override
	public Song getSong() {
		return song;
	}

	@Override
	public Date getDate() {
		return playedAt;
	}

}
