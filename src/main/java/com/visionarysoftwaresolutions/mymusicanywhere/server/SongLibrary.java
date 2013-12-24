package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Artists;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Songs;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Tag;

public class SongLibrary implements Songs, Iterable<Song> {
	private final Map<Song, Set<Tag>> songs = new HashMap<>();

	@Override
	public void addSong(final Song song) {
		Set<Tag> tags = new HashSet<Tag>();
		songs.put(song, tags);
	}

	@Override
	public boolean contains(final Song searchingFor) {
		return songs.keySet().contains(searchingFor);
	}

	@Override
	public boolean isEmpty() {
		return songs.isEmpty();
	}

	@Override
	public Iterator<Song> iterator() {
		return songs.keySet().iterator();
	}

	@Override
	public void addAll(Songs songs) {
		if (songs!= null) {
			for (Song aSong : songs) {
				addSong(aSong);
			}
		}
	}

	@Override
	public Artists getArtists() {
		Artists artists = new Collaborators();
		for (Song aSong : songs.keySet()) {
			artists.addArtist(aSong.getArtist());
		}
		return artists;
	}

	@Override
	public void addTagToSong(Song song, Tag tag) {
		if(songs.containsKey(song)) {
			Set<Tag> tags = songs.get(song);
			tags.add(tag);
		}
	}

	@Override
	public Songs findAllSongsByTag(Tag tag) {
		Songs withTag = new SongLibrary();
		for (Map.Entry<Song, Set<Tag>> entry : songs.entrySet()) {
			if (entry.getValue().contains(tag)) {
				withTag.addSong(entry.getKey());
			}
		}
		return withTag;
	}
}
