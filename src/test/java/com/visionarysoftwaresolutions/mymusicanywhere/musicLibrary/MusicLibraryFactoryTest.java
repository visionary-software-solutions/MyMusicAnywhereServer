package com.visionarysoftwaresolutions.mymusicanywhere.musicLibrary;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.Before;
import org.junit.Test;

import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibrary;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Songs;
import com.visionarysoftwaresolutions.mymusicanywhere.server.TestFixtures;
import com.visionarysoftwaresolutions.mymusicanywhere.server.TheLostChildren;

public class MusicLibraryFactoryTest {
	MusicLibraryFactory toTest;
	
	@Before
	public void setup() {
		toTest = new MusicLibraryFactory();
	}
	
	@Test
	public void canBuildFromAFolder() throws IOException {
		// Given : I have a path to a folder with some music in it
		Path lostChildren = TheLostChildren.createLostChildrenPath();
		// When: I try to make a music library from that path
		MusicLibrary result = toTest.fromPath(lostChildren);
		// Then: I should get back a music library with the folder's contents
		//MusicLibrary expected = TestFixtures.createMusicLibrary();
		Songs containedSongs = result.getSongs();
		assertTrue(containedSongs.contains(TheLostChildren.createHell()));
		assertTrue(containedSongs.contains(TheLostChildren.createThisMoment()));
		assertTrue(containedSongs.contains(TheLostChildren.createOldFriend()));
		assertTrue(containedSongs.contains(TheLostChildren.createThisMoment()));
		assertTrue(containedSongs.contains(TheLostChildren.createMonster()));
		assertTrue(containedSongs.contains(TheLostChildren.createRun()));
		assertTrue(containedSongs.contains(TheLostChildren.createLeaveItAlone()));
		assertTrue(containedSongs.contains(TheLostChildren.createTwoWorlds()));
		assertTrue(containedSongs.contains(TheLostChildren.createGodOfTheMind()));
		assertTrue(containedSongs.contains(TheLostChildren.createSickened()));
		assertTrue(containedSongs.contains(TheLostChildren.createMine()));
		assertTrue(containedSongs.contains(TheLostChildren.createParasite()));
		assertTrue(containedSongs.contains(TheLostChildren.createDehumanized()));
		assertTrue(containedSongs.contains(TheLostChildren.create3()));
		assertTrue(containedSongs.contains(TheLostChildren.createMidlifeCrisis()));
		assertTrue(containedSongs.contains(TheLostChildren.createLivingAfterMidnight()));
		assertTrue(result.getArtists().contains(TestFixtures.createDisturbed()));
		assertTrue(result.getAlbums().contains(TheLostChildren.createTheLostChildren()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.createHell()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.createThisMoment()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.createOldFriend()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.createThisMoment()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.createMonster()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.createRun()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.createLeaveItAlone()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.createTwoWorlds()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.createGodOfTheMind()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.createSickened()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.createMine()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.createParasite()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.createDehumanized()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.create3()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.createMidlifeCrisis()));
		assertNotNull(result.getAudioFileForSong(TheLostChildren.createLivingAfterMidnight()));
	}

}
