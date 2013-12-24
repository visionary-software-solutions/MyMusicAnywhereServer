package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.util.Collection;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Album;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Albums;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artist;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artists;
import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFile;
import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFiles;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibrary;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Songs;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Tag;
import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.Year;

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
	public Albums findAllAlbumsByArtist(final Artist artist) {
		final Albums forArtist = new Records();
		if (artist != null) {
			for (final Album anAlbum : albums) {
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
	public Albums findAllAlbumsByYear(final Year year) {
		final Albums contained = new Records();
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
	public Songs findAllSongsByAlbumName(final Name albumName) {
		final Songs contained = new SongLibrary();

		for (final Album album : albums) {
			if (album.getName().equals(albumName)) {
				contained.addAll(album.getSongs());
			}
		}
		return contained;
	}

	@Override
	public Songs findAllSongsByArtist(final Artist toSearch) {
		final Songs had = new SongLibrary();
		final Artists artists = lib.getArtists();
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
	public Artists findAllArtistsByAlbum(Album album) {
		Artists artists = new Collaborators();
		for (Artist anArtist : album.getArtists()) {
			artists.addArtist(anArtist);
		}
		return artists;
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
	public Songs getSongsByTagName(Tag tag) {
		return lib.findAllSongsByTag(tag);
	}

}
