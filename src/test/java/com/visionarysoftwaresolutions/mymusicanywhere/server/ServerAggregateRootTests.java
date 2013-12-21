package com.visionarysoftwaresolutions.mymusicanywhere.server;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ServerAggregateRootTests {
	private Artist disturbed;
	private Song song;
	private MusicLibrary library;
	MyMusicAnywhereServer toTest;
	private Album album;
	
	@Before
	public void setup() {
		disturbed = TestFixtures.createArtist("Disturbed");
		song = TestFixtures.createStricken(disturbed);
		album = TestFixtures.createTenThousandFists();
		library = TestFixtures.createLibrary();
		library.addSong(song);
		library.addAlbum(album);
		toTest = new DefaultMyMusicAnywhereServer(library);
	}
	
	@Test
	public void canListAllSongsByArtist() {
		// When: I request all the songs by Disturbed
		Songs amazing = toTest.findAllSongsByArtist(disturbed);
		// Then: Stricken is one of the songs
		assertTrue(amazing.contains(song));
	}
	
	@Test
	public void returnsEmptySongsWhenNoSongsByArtist() {
		// When: I request all the songs by Korn
		Artist korn = TestFixtures.createArtist("Korn");
		Songs amazing = toTest.findAllSongsByArtist(korn);
		// Then: Stricken is not one of the songs
		assertFalse(amazing.contains(song));
		// And: Songs is empty
		assertTrue(amazing.isEmpty());
	}
	
	@Test
	public void canFindSongsByName() {
		// When: I request all songs by the name "Stricken"
		Name stricken = new Name("Stricken");
		Songs amazing = toTest.findAllSongsByName(stricken);
		// Then: Stricken is one of the songs
		assertTrue(amazing.contains(song));
	}
	
	@Test
	public void returnsEmptySongsWhenNoSongsByName() {
		// When: I request all songs by the name "Blind"
		Name blind = new Name("Blind");
		Songs amazing = toTest.findAllSongsByName(blind);
		// Then: Stricken is not one of the songs
		assertFalse(amazing.contains(song));
		// And: Songs is empty
		assertTrue(amazing.isEmpty());
	}
	
	@Test
	public void canListAllSongsByAlbumName() {
		// When: I request all the songs from Ten Thousand Fists
		Name tenThousandFists = new Name("Ten Thousand Fists");
		Songs amazing = toTest.findAllSongsByAlbumName(tenThousandFists);
		// Then: Stricken is one of the songs
		assertTrue(amazing.contains(song));
	}
	
	@Test
	public void canFindAllAlbumsByYear() {
		// When: I request all albums from the year 2005
		Year twoThousandFive = new Year(new NaturalNumber(2005));
		Albums amazing = toTest.findAllAlbumsByYear(twoThousandFive);
		// Then: Ten Thousand Fists is one of the albums
		assertTrue(amazing.contains(album));
	}
	
	@Test
	public void canFindAllSongsByYear() {
		// When: I request all songs from the year 2005
		Year twoThousandFive = new Year(new NaturalNumber(2005));
		Songs amazing = toTest.findAllSongsByYear(twoThousandFive);
		// Then: Stricken is one of the songs
		assertTrue(amazing.contains(song));
	}
}
