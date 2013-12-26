package com.visionarysoftwaresolutions.mymusicanywhere.musicLibrary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Album;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artist;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibrary;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Songs;
import com.visionarysoftwaresolutions.mymusicanywhere.server.DefaultAlbum;
import com.visionarysoftwaresolutions.mymusicanywhere.server.DefaultMusicLibrary;
import com.visionarysoftwaresolutions.mymusicanywhere.server.MyMusicAnywhereFactory;
import com.visionarysoftwaresolutions.mymusicanywhere.server.SongLibrary;
import com.visionarysoftwaresolutions.mymusicanywhere.server.mp3.ID3Tag;
import com.visionarysoftwaresolutions.mymusicanywhere.server.mp3.MP3File;
import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.Year;

public class MusicLibraryFactory {
	public MusicLibrary fromPath(Path buildFrom) throws IOException {
		MusicLibrary toBuild = new DefaultMusicLibrary();
		Collection<MP3File> mp3s = new ConcurrentLinkedDeque<>();
		Mp3Finder visitor = new Mp3Finder(mp3s);
		Files.walkFileTree(buildFrom, visitor);
		populateLibrary(toBuild, visitor);
		return toBuild;
	}

	private void populateLibrary(MusicLibrary toBuild, Mp3Finder visitor) {
		Map<Name, Songs> albums = new HashMap<>();
		String year = "";
		for (MP3File foundFile : visitor.getFound()) {
			ID3Tag info = foundFile.getTag();
			Artist toAddArtist = MyMusicAnywhereFactory.createArtist(info.getArtist());
			Song toAddSong = MyMusicAnywhereFactory.createSong(info.getTitle(), toAddArtist);
			Name albumName = MyMusicAnywhereFactory.createName(info.getAlbum());
			year = info.getYear();
			if (!albums.containsKey(albumName)) {
				Songs onAlbum = new SongLibrary();
				onAlbum.addSong(toAddSong);
				albums.put(albumName, onAlbum);
			} else {
				Songs onAlbum = albums.get(albumName);
				onAlbum.addSong(toAddSong);
			}
		}
		
		addAlbumsToLibrary(toBuild, albums, year);
	}

	private void addAlbumsToLibrary(MusicLibrary toBuild,
			Map<Name, Songs> albums, String year) {
		for(Map.Entry<Name, Songs> album : albums.entrySet()) {
			Songs songs = album.getValue();
			Year newYear = MyMusicAnywhereFactory.createYear(Integer.parseInt(year));
			Album toAddAlbum = new DefaultAlbum(album.getKey(), newYear, songs);
			toBuild.addAlbum(toAddAlbum);
		}
	}
}
