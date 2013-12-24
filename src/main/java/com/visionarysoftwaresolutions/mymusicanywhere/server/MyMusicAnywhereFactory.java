package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Album;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artist;
import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFile;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibrary;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibraryAnalyst;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Songs;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Tag;
import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.NaturalNumber;
import com.visonarysoftwaresolutions.types.Year;

public class MyMusicAnywhereFactory {
	static Name createName(String name) {
		return new Name(name);
	}
	
	static Year createYear(final int year) {
		return new Year(new NaturalNumber(year));
	}
	
	static MusicLibrary createLibrary() {
		return new DefaultMusicLibrary();
	}
	
	static Song createSong(Name name, Artist artist) {
		return new DefaultSong(name, artist);
	}

	static Artist createArtist(String string) {
		return new DefaultArtist(string);
	}
	
	static Songs createTrax(Song...songs) {
		Songs tracks = new SongLibrary();
		for (Song aSong : songs) {
			tracks.addSong(aSong);
		}
		return tracks;
	}

	static Album createAlbum(Name name, Year year, Songs songs) {
		return new DefaultAlbum(name, year, songs);
	}

	static AudioFile createAudioFile(File audioFile) throws IOException {
		AudioFile result = new EmptyAudioFile();
		// TODO: add checks for if OGG, MP3, WMA, etc. This should conditionally dispatch.
		if (audioFile.exists() && audioFile.canRead()) {
			FileInputStream fileStream = null;
			try {
				fileStream = new FileInputStream(audioFile);
				byte[] fileData = new byte[fileStream.available()];
				fileStream.read(fileData);
				result = new MP3File(fileData);
			} finally {
				if (fileStream != null) {
					fileStream.close();
				}
			}
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
