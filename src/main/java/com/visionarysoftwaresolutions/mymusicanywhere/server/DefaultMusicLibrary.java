package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DefaultMusicLibrary implements MusicLibrary {
	Songs lib = new SongLibrary();
	Map<Year, Albums> albums = new HashMap<>();

	@Override
	public void addAlbum(final Album album) {
		final Year theYear = album.getYear();
		if (albums.containsKey(theYear)) {
			final Albums stored = albums.get(theYear);
			stored.addAlbum(album);
		} else {
			final Albums stored = new Records();
			stored.addAlbum(album);
			albums.put(theYear, stored);
		}
	}

	@Override
	public void addSong(final Song toAdd) {
		lib.addSong(toAdd);
	}

	@Override
	public Albums findAllAlbumsByArtist(final Artist artist) {
		final Albums forArtist = new Records();
		if (artist != null) {
			for (final Albums allAlbums : albums.values()) {
				for (final Album anAlbum : allAlbums) {
					for (final Song song : anAlbum.getSongs()) {
						if (artist.equals(song.getArtist())) {
							forArtist.addAlbum(anAlbum);
						}
					}
				}
			}
		}
		return forArtist;
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
			for (final Album album : allAlbums) {
				if (album.getName().equals(albumName)) {
					contained.addAll(album.getSongs());
				}
			}
		}
		return contained;
	}

	@Override
	public Songs findAllSongsByArtist(final Artist toSearch) {
		final Songs had = new SongLibrary();
		final Collection<Artist> artists = lib.getArtists();
		if (artists.contains(toSearch)) {
			for (final Song aSong : lib) {
				if (aSong.getArtist().equals(toSearch)) {
					had.addSong(aSong);
				}
			}
		}
		return had;
	}

	@Override
	public Songs findAllSongsByName(final Name songName) {
		final Songs had = new SongLibrary();
		for (final Song aSong : lib) {
			if (aSong.getName().equals(songName)) {
				had.addSong(aSong);
			}
		}
		return had;
	}

	@Override
	public Songs findAllSongsByYear(final Year year) {
		final Songs contained = new SongLibrary();
		if (albums.containsKey(year)) {
			final Albums allAlbums = albums.get(year);
			for (final Album album : allAlbums) {
				contained.addAll(album.getSongs());
			}
		}
		return contained;
	}

}
