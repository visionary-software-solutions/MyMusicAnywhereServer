package com.visionarysoftwaresolutions.mymusicanywhere.api;


public interface MusicLibrary {

	void addSong(Song toAdd);
	void addAlbum(Album album);

	AudioFile getAudioFileForSong(Song song);

	void addAudioForSong(Song song, AudioFile audio);

	void addTagToSong(Song song, Tag tag);

	Albums getAlbums();

	Songs getSongs();

	Artists getArtists();

}
