package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.io.IOException;
import java.nio.file.Path;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Album;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artist;
import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFile;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibrary;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibraryAnalyst;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Songs;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Tag;
import com.visionarysoftwaresolutions.mymusicanywhere.server.mp3.MP3File;
import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.NaturalNumber;
import com.visonarysoftwaresolutions.types.Year;

public class MyMusicAnywhereFactory {
	public static Name createName(String name) {
		return new Name(name);
	}
	
	public static Year createYear(final int year) {
		return new Year(new NaturalNumber(year));
	}
	
	static MusicLibrary createLibrary() {
		return new DefaultMusicLibrary();
	}
	
	public static Song createSong(String name, Artist artist) {
		return new DefaultSong(createName(name), artist);
	}
	
	static Song createSong(Name name, Artist artist) {
		return new DefaultSong(name, artist);
	}

	public static Artist createArtist(String string) {
		return new DefaultArtist(string);
	}
	
	static Songs createTrax(Song...songs) {
		Songs tracks = new SongLibrary();
		for (Song aSong : songs) {
			tracks.addSong(aSong);
		}
		return tracks;
	}

	public static Album createAlbum(Name name, Year year, Songs songs) {
		return new DefaultAlbum(name, year, songs);
	}

	static AudioFile createAudioFile(Path audioFile) throws IOException {
		AudioFile result = new EmptyAudioFile();
		try {
			result = new MP3File(audioFile);
		} catch (InvalidFileTypeException e) {
			System.err.println("Was not an MP3 file. Was " + e.getFileName());
		}
		return result;
	}

	static MusicLibraryAnalyst createLibraryAnalyst() {
		return new InMemoryLibraryAnalyst();
	}

	static Tag createTag(String string) {
		Name tagName = new Name(string);
		return new DefaultTag(tagName);
	}
}
