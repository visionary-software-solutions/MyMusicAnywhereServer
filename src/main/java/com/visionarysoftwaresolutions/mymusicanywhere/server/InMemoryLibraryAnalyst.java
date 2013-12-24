package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.util.Collection;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Album;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Albums;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artist;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artists;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibrary;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibraryAnalyst;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Play;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Plays;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Songs;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Tag;
import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.Year;

public class InMemoryLibraryAnalyst implements MusicLibraryAnalyst {
	
	@Override
	public Plays getPlaysForSong(MusicLibrary library, Song song) {
		PlayHistory songPlayed = new PlayHistory();
		final Plays plays = library.getPlays();
		for (Play play : plays) {
			if (play.getSong().equals(song)) {
				songPlayed.add(play);
			}
		}
		return songPlayed;
	}

	@Override
	public Songs findAllSongsByArtist(MusicLibrary library, Artist artist) {
		final Songs had = new SongLibrary();
		final Artists artists = library.getArtists();
		if (artists.contains(artist)) {
			for (final Song aSong : library.getSongs()) {
				if (aSong.getArtist().equals(artist)) {
					had.addSong(aSong);
				}
			}
		}
		return had;
	}

	@Override
	public Songs findAllSongsByName(MusicLibrary library, Name song) {
		final Songs had = new SongLibrary();
		final Songs inLibrary = library.getSongs();
		for (final Song aSong : inLibrary) {
			if (aSong.getName().equals(song)) {
				had.addSong(aSong);
			}
		}
		return had;
	}

	@Override
	public Songs findAllSongsByAlbumName(MusicLibrary library, Name albumName) {
		final Songs contained = new SongLibrary();
		final Albums albums = library.getAlbums();
		for (final Album album : albums) {
			if (album.getName().equals(albumName)) {
				contained.addAll(album.getSongs());
			}
		}
		return contained;
	}

	@Override
	public Albums findAllAlbumsByYear(MusicLibrary library, Year year) {
		final Albums contained = new Records();
		final Albums albums = library.getAlbums();
		final Collection<Year> years = albums.getYears();
		if (years.contains(year)) {
			for (final Album anAlbum : albums) {
				if (anAlbum.getYear().equals(year)) {
					contained.addAlbum(anAlbum);
				}
			}
		}
		return contained;
	}

	@Override
	public Songs findAllSongsByYear(MusicLibrary library, Year year) {
		final Songs contained = new SongLibrary();
		final Albums albums = library.getAlbums();
		final Collection<Year> years = albums.getYears();
		if (years.contains(year)) {
			for (final Album album : albums) {
				if (album.getYear().equals(year)) {
					contained.addAll(album.getSongs());
				}
			}
		}
		return contained;
	}

	@Override
	public Albums findAllAlbumsByArtist(MusicLibrary library, Artist artist) {
		final Albums forArtist = new Records();
		if (artist != null) {
			for (final Album anAlbum : library.getAlbums()) {
				for (final Song song : anAlbum.getSongs()) {
					if (artist.equals(song.getArtist())) {
						forArtist.addAlbum(anAlbum);
					}
				}
			}
		}
		return forArtist;
	}

	@Override
	public Artists findAllArtistsByAlbum(MusicLibrary library, Album album) {
		Artists artists = new Collaborators();
		for (Artist anArtist : album.getArtists()) {
			artists.addArtist(anArtist);
		}
		return artists;
	}

	@Override
	public Songs findAllSongsByTag(MusicLibrary library, Tag tag) {
		final Songs lib = library.getSongs();
		return lib.findAllSongsByTag(tag);
	}
}
