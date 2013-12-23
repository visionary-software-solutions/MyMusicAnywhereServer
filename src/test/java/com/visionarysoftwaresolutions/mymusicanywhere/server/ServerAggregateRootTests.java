package com.visionarysoftwaresolutions.mymusicanywhere.server;

import static org.junit.Assert.*;

import java.io.IOException;

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
		disturbed = TestFixtures.createDisturbed();
		song = TestFixtures.createStricken();
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
		Artist korn = TestFixtures.createKorn();
		Songs amazing = toTest.findAllSongsByArtist(korn);
		// Then: Stricken is not one of the songs
		assertFalse(amazing.contains(song));
		// And: Songs is empty
		assertTrue(amazing.isEmpty());
	}
	
	@Test
	public void canFindSongsByName() {
		// When: I request all songs by the name "Stricken"
		Name stricken = TestFixtures.createName("Stricken");
		Songs amazing = toTest.findAllSongsByName(stricken);
		// Then: Stricken is one of the songs
		assertTrue(amazing.contains(song));
	}
	
	@Test
	public void returnsEmptySongsWhenNoSongsByName() {
		// When: I request all songs by the name "Blind"
		Name blind = TestFixtures.createName("Blind");
		Songs amazing = toTest.findAllSongsByName(blind);
		// Then: Stricken is not one of the songs
		assertFalse(amazing.contains(song));
		// And: Songs is empty
		assertTrue(amazing.isEmpty());
	}
	
	@Test
	public void canListAllSongsByAlbumName() {
		// When: I request all the songs from Ten Thousand Fists
		Name tenThousandFists = TestFixtures.createName("Ten Thousand Fists");
		Songs amazing = toTest.findAllSongsByAlbumName(tenThousandFists);
		// Then: Stricken is one of the songs
		assertTrue(amazing.contains(song));
	}
	
	@Test
	public void returnsEmptySongsWhenNoSongsByAlbumName() {
		// When: I request all the songs from Ten Thousand Fists
		Name issues = TestFixtures.createName("Issues");
		Songs amazing = toTest.findAllSongsByAlbumName(issues);
		// Then: Stricken is not one of the songs
		assertFalse(amazing.contains(song));
		// And: Songs is empty
		assertTrue(amazing.isEmpty());
	}
	
	@Test
	public void canFindAllAlbumsByYear() {
		// When: I request all albums from the year 2005
		Year twoThousandFive = TestFixtures.createYear(2005);
		Albums amazing = toTest.findAllAlbumsByYear(twoThousandFive);
		// Then: Ten Thousand Fists is one of the albums
		assertTrue(amazing.contains(album));
	}
	
	@Test
	public void returnsEmptyAlbumsWhenNoAlbumsByYear() {
		// When: I request all albums from the year 1969
		Year nineteenSixtyNine = TestFixtures.createYear(1969);
		Albums amazing = toTest.findAllAlbumsByYear(nineteenSixtyNine);
		// Then: Ten Thousand Fists is not one of the albums
		assertFalse(amazing.contains(album));
		// And: Albums is empty
		assertTrue(amazing.isEmpty());
	}
	
	@Test
	public void canFindAllSongsByYear() {
		// When: I request all songs from the year 2005
		Year twoThousandFive = TestFixtures.createYear(2005);
		Songs amazing = toTest.findAllSongsByYear(twoThousandFive);
		// Then: Stricken is one of the songs
		assertTrue(amazing.contains(song));
	}
	
	@Test
	public void returnsEmptySongsWhenNoSongsByYear() {
		// When: I request all albums from the year 1969
		Year nineteenSixtyNine = TestFixtures.createYear(1969);
		Songs amazing = toTest.findAllSongsByYear(nineteenSixtyNine);
		// Then: Stricken is not one of the songs
		assertFalse(amazing.contains(song));
		// And: Songs is empty
		assertTrue(amazing.isEmpty());
	}
	
	@Test
	public void canFindAllAlbumsByArtist() {
		// When: I request all albums from Disturbed
		Artist disturbed = TestFixtures.createDisturbed();
		Albums amazing = toTest.findAllAlbumsByArtist(disturbed);
		// Then: Ten Thousand Fists is one of the albums
		assertTrue(amazing.contains(album));
	}
	
	@Test
	public void returnsEmptyAlbumsWhenNoAlbumsByArtist() {
		// When: I request all albums from Disturbed
		Artist pantera = TestFixtures.createPantera();
		Albums amazing = toTest.findAllAlbumsByArtist(pantera);
		// Then: Ten Thousand Fists is not one of the albums
		assertFalse(amazing.contains(album));
		// And: Albums is empty
		assertTrue(amazing.isEmpty());
	}
	
	@Test
	public void canFindAllArtistsForAnAlbum() {
		// Given: the music library contains an album with multiple artists
		Album dracula2000 = TestFixtures.createDracula2000(); 
		library.addAlbum(dracula2000);
		// When: I request all of the Artists for an album
		Artists artists = toTest.findAllArtistsByAlbum(dracula2000);
		// Then: I should get back all the Artists on that album
		assertTrue(artists.contains(TestFixtures.createPowerman5000()));
		assertTrue(artists.contains(TestFixtures.createDisturbed()));
		assertTrue(artists.contains(TestFixtures.createPantera()));
	}
	
	@Test
	public void onlyFindsArtistsOnAnAlbum() {
		// When: I request all of the Artists for an album not in the library
		Artists artists = toTest.findAllArtistsByAlbum(TestFixtures.createFollowTheLeader());
		// Then: Disturbed is not one of the artists
		assertFalse(artists.contains(disturbed));
		// And: Korn is the only artist
		assertTrue(artists.contains(TestFixtures.createKorn()));
	}
	
	@Test
	public void canAddAndGetTheAudioFileForASong() throws IOException {
		// Given: My music library has the audio file for the song Stricken in it
		Song stricken = TestFixtures.createStricken();
		AudioFile strickenAudio = TestFixtures.createStrickenAudio();
		toTest.addAudioForSong(stricken, strickenAudio);
		// When: I request the audio file for Stricken
		AudioFile music = toTest.getAudioFileForSong(stricken);
		// Then: I receive an audio file
		assertEquals(strickenAudio, music);
		// And: I should be able to get the byte data
		assertNotNull(music.getBytes());
	}
}
