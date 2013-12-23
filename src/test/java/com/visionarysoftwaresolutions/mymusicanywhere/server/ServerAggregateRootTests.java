package com.visionarysoftwaresolutions.mymusicanywhere.server;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Album;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Albums;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artist;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artists;
import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFile;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibrary;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibraryAnalyst;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MyMusicAnywhereServer;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Plays;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Songs;
import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.NaturalNumber;
import com.visonarysoftwaresolutions.types.Year;

public class ServerAggregateRootTests {
	private Artist disturbed;
	private Song song;
	private MusicLibrary library;
	private MusicLibraryAnalyst anal;
	private Album album;
	private AudioFile strickenAudio;
	MyMusicAnywhereServer toTest;
	
	@Before
	public void setup() throws IOException {
		disturbed = TestFixtures.createDisturbed();
		song = TestFixtures.createStricken();
		strickenAudio = TestFixtures.createStrickenAudio();
		album = TestFixtures.createTenThousandFists();
		library = TestFixtures.createLibrary();
		library.addSong(song);
		library.addAlbum(album);
		library.addAudioForSong(song, strickenAudio);
		anal = TestFixtures.createLibraryAnalyst();
		toTest = new DefaultMyMusicAnywhereServer(library, anal);
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
	public void canAddAudioFileForASong() throws IOException {
		// When: I want to add audio for the song Stricken
		toTest.addAudioForSong(song, strickenAudio);
		// Then; My library should have the audio file added
		assertNotNull(library.getAudioFileForSong(song));
	}
	
	@Test
	public void canGetTheAudioFileForASong() throws IOException {
		// When: I request the audio file for Stricken
		AudioFile music = toTest.getAudioFileForSong(song);
		// Then: I receive an audio file
		assertEquals(strickenAudio, music);
		// And: I should be able to get the byte data
		assertNotNull(music.getBytes());
	}
	
	@Test
	public void canShowNumberOfPlaysForASong() {
		// Given: I have asked for the audio file for Stricken twice
		toTest.getAudioFileForSong(song);
		toTest.getAudioFileForSong(song);
		// When: I ask the server how many times a song has been played
		Plays played = toTest.getPlaysForSong(song);
		// Then: the number of plays should be two
		NaturalNumber two = new NaturalNumber(2); 
		assertEquals(two, played.count());
		// And: the dates of the plays should be two
		assertEquals(two, played.dates().size());
		// And: I know that it was played within the last 1 hour
		assertTrue(played.withinLastNHours(new NaturalNumber(1)));
	}
}
