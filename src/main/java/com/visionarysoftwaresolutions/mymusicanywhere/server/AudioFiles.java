package com.visionarysoftwaresolutions.mymusicanywhere.server;

public interface AudioFiles {

	boolean contains(Song song);

	AudioFile getAudioFileForSong(Song song);

	void addAudioForSong(Song song, AudioFile audio);

}
