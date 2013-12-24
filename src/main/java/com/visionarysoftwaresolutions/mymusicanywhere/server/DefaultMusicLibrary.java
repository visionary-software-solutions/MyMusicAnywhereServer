package com.visionarysoftwaresolutions.mymusicanywhere.server;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Album;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Albums;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artists;
import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFile;
import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFiles;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibrary;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Play;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Plays;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Songs;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Tag;
import com.visonarysoftwaresolutions.types.Date;

public class DefaultMusicLibrary implements MusicLibrary {
	Songs lib = new SongLibrary();
	Albums albums = new Records();
	AudioFiles files = new AudioFileSystem();
	Plays plays = new PlayHistory();
	
	@Override
	public void addAlbum(final Album album) {
		if (!albums.contains(album)) {
			albums.addAlbum(album);
			for(Song toAdd : album.getSongs()) {
				addSong(toAdd);
			}
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
		incrementNumberOfPlaysForSong(song);
		return result;
	}
	
	private void incrementNumberOfPlaysForSong(Song song) {
		Play played = new DefaultPlay(song, new Date());
		plays.add(played);
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

	@Override
	public Plays getPlays() {
		return plays;
	}

}
