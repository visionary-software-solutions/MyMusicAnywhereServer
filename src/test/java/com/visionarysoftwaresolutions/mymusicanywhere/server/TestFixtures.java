package com.visionarysoftwaresolutions.mymusicanywhere.server;

public class TestFixtures {
	static Name createName(String name) {
		return MyMusicAnywhereFactory.createName(name);
	}
	
	static Song createStricken(Artist disturbed) {
		return MyMusicAnywhereFactory.createSong(
				createName("Stricken"), disturbed);
	}

	static MusicLibrary createLibrary() {
		return MyMusicAnywhereFactory.createLibrary();
	}

	static Artist createArtist(String string) {
		return MyMusicAnywhereFactory.createArtist(string);
	}

	static Album createTenThousandFists() {
		Artist disturbed = createArtist("Disturbed");
		Songs tracks = createTrax(disturbed);
		Name name = createName("Ten Thousand Fists");
		Year year = createYear(2005);
		return MyMusicAnywhereFactory.createAlbum(name, year , tracks);
	}

	private static Songs createTrax(Artist disturbed) {
		Songs tracks = new SongLibrary();
		tracks.addSong(createStricken(disturbed));
		return tracks;
	}

	static Year createYear(final int year) {
		return MyMusicAnywhereFactory.createYear(year);
	}
}
