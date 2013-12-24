package com.visionarysoftwaresolutions.mymusicanywhere.server;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Album;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Albums;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artists;
import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFile;
import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFiles;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibrary;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Songs;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Tag;

public class DefaultMusicLibrary implements MusicLibrary {
	Songs lib = new SongLibrary();
	Albums albums = new Records();
	AudioFiles files = new AudioFileSystem();
	
	@Override
	public void addAlbum(final Album album) {
		if (!albums.contains(album)) {
			albums.addAlbum(album);
		}
	}

	@Override
	public void addSong(final Song toAdd) {
		if (!lib.contains(toAdd)) {
			lib.addSong(toAdd);
		}
	}

	@Override
	public AudioFile getAudioFileForSong(Song song) {
		AudioFile result = new EmptyAudioFile();
		if (files.contains(song)) {
			result = files.getAudioFileForSong(song);
		}
		return result;
	}

	@Override
	public void addAudioForSong(Song song, AudioFile audio) {
		files.addAudioForSong(song, audio);
	}

	@Override
	public void addTagToSong(Song song, Tag tag) {
		if(lib.contains(song)) {
			lib.addTagToSong(song, tag);
		}
		
	}

	@Override
	public Albums getAlbums() {
		return albums;
	}

	@Override
	public Songs getSongs() {
		return lib;
	}

	@Override
	public Artists getArtists() {
		return lib.getArtists();
	}

}
