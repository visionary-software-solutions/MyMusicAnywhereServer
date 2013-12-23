package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.io.File;
import java.io.IOException;

import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.Year;

public class TestFixtures {
	static Name createName(String name) {
		return MyMusicAnywhereFactory.createName(name);
	}
	
	static Song createStricken() {
		return MyMusicAnywhereFactory.createSong(
				createName("Stricken"), createDisturbed());
	}

	static MusicLibrary createLibrary() {
		return MyMusicAnywhereFactory.createLibrary();
	}

	static Artist createDisturbed() {
		return MyMusicAnywhereFactory.createArtist("Disturbed");
	}
	
	static Artist createKorn() {
		return MyMusicAnywhereFactory.createArtist("Korn");
	}
	
	static Album createTenThousandFists() {
		Songs tracks = createTrax(createStricken());
		Name name = createName("Ten Thousand Fists");
		Year year = createYear(2005);
		return MyMusicAnywhereFactory.createAlbum(name, year , tracks);
	}
	
	static Album createFollowTheLeader() {
		Song freakOnALeash = createFreakOnALeash();
		Songs tracks = createTrax(freakOnALeash);
		Name name = createName("Follow the Leader");
		Year year = createYear(1998);
		return MyMusicAnywhereFactory.createAlbum(name, year , tracks);
	}

	private static Song createFreakOnALeash() {
		return MyMusicAnywhereFactory.createSong(
				MyMusicAnywhereFactory.createName("Freak on A Leash"),
				createKorn());
	}

	static Songs createTrax(Song...songs) {
		return MyMusicAnywhereFactory.createTrax(songs);
	}

	static Year createYear(final int year) {
		return MyMusicAnywhereFactory.createYear(year);
	}

	static Album createDracula2000() {
		Song ultraMega = createUltraMega();
		Song aWelcomeBurden = createAWelcomeBurden();
		Song avoidTheLight = createAvoidTheLight();
		Songs tracks = createTrax(ultraMega, aWelcomeBurden, avoidTheLight);
		Name name = createName("Dracula 2000");
		Year year = createYear(2000);
		return MyMusicAnywhereFactory.createAlbum(name, year , tracks);
	}
	
	static Song createUltraMega() {
		return MyMusicAnywhereFactory.createSong(
				MyMusicAnywhereFactory.createName("Ultra Mega"),
				createPowerman5000());
	}

	static Artist createPowerman5000() {
		return MyMusicAnywhereFactory.createArtist("Pomerman 5000");
	}
	
	static Song createAWelcomeBurden() {
		return MyMusicAnywhereFactory.createSong(
				MyMusicAnywhereFactory.createName("A Welcome Burden"),
				createDisturbed());
	}
	
	static Song createAvoidTheLight() {
		return MyMusicAnywhereFactory.createSong(
				MyMusicAnywhereFactory.createName("Avoid The Light"),
				createPantera());
	}

	static Artist createPantera() {
		return MyMusicAnywhereFactory.createArtist("Pantera");
	}

	public static AudioFile createStrickenAudio() throws IOException {
		File strickenBytes = new File("/home/master/Programming/server/src/main/resources/Stricken.mp3");
		return MyMusicAnywhereFactory.createAudioFile(strickenBytes);
	}
}
