package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DefaultMusicLibrary implements MusicLibrary {
	Map<Artist, Songs> lib = new HashMap<>();
	Map<Year, Albums> albums = new HashMap<>();

	@Override
	public void addAlbum(final Album album) {
		Year theYear = album.getYear();
		if (albums.containsKey(theYear)) {
			Albums stored = albums.get(theYear);
			stored.addAlbum(album);
		} else {
			Albums stored = new Records();
			stored.addAlbum(album);
			albums.put(theYear, stored);
		}
	}

	@Override
	public void addSong(final Song toAdd) {
		final Artist artist = toAdd.getArtist();
		if (artist == null) {
			throw new IllegalStateException("should not have null artist");
		}
		if (lib.containsKey(artist)) {
			final Songs songs = lib.get(artist);
			songs.addSong(toAdd);
		} else {
			Songs songs = new SongLibrary();
			songs.addSong(toAdd);
			lib.put(artist, songs);
		}

	}

	@Override
	public Albums findAllAlbumsByYear(final Year year) {
		final Albums contained;
		if (albums.containsKey(year)) {
			contained = albums.get(year);
		} else {
			contained = new Records();
		}
		return contained;
	}

	@Override
	public Songs findAllSongsByAlbumName(final Name albumName) {
		final Songs contained = new SongLibrary();
		final Collection<Albums> recorded = albums.values();
		for (final Albums allAlbums : recorded) {
			for (Album album : allAlbums) {
				if (album.getName().equals(albumName)) {
					contained.addAll(album.getSongs());
				}
			}
		}
		return contained;
	}

	@Override
	public Songs findAllSongsByArtist(final Artist toSearch) {
		final Songs had;
		if (lib.containsKey(toSearch)) {
			had = lib.get(toSearch);
		} else {
			had = new SongLibrary();
		}
		return had;
	}

	@Override
	public Songs findAllSongsByName(final Name songName) {
		final Songs had = new SongLibrary();
		for (final Songs songs : lib.values()) {
			for (final Song aSong : songs) {
				if (aSong.getName().equals(songName)) {
					had.addSong(aSong);
				}
			}
		}
		return had;
	}

	@Override
	public Songs findAllSongsByYear(Year year) {
		Songs contained = new SongLibrary();
		if (albums.containsKey(year)) {
			Albums allAlbums = albums.get(year);
			for (Album album : allAlbums) {
				contained.addAll(album.getSongs());
			}
		}
		return contained;
	}

	@Override
	public Albums findAllAlbumsByArtist(Artist artist) {
		Albums forArtist = new Records();
		if (artist != null) {
			for (Albums allAlbums : albums.values()) {
				for (Album anAlbum : allAlbums) {
					for (Song song : anAlbum.getSongs()) {
						if (artist.equals(song.getArtist())) {
							forArtist.addAlbum(anAlbum);
						}
					}
				}
			}
		}
		return forArtist;
	}

}
