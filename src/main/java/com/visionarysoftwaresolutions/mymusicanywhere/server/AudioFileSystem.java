package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.util.HashMap;
import java.util.Map;

import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFile;
import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFiles;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;

public class AudioFileSystem implements AudioFiles {
	private final Map<Song, AudioFile> stored;
	
	public AudioFileSystem() {
		stored = new HashMap<>();
	}
	
	@Override
	public boolean contains(Song song) {
		return stored.containsKey(song);
	}

	@Override
	public AudioFile getAudioFileForSong(Song song) {
		AudioFile result = new EmptyAudioFile();
		if (contains(song)) {
			result = stored.get(song);
		}
		return result;
	}

	@Override
	public void addAudioForSong(Song song, AudioFile audio) {
		stored.put(song, audio);
	}
}
