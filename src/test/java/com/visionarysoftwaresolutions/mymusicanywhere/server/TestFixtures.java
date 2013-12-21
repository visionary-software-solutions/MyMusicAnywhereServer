package com.visionarysoftwaresolutions.mymusicanywhere.server;

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
		Songs tracks = createTrax();
		Name name = createName("Ten Thousand Fists");
		Year year = createYear(2005);
		return MyMusicAnywhereFactory.createAlbum(name, year , tracks);
	}

	private static Songs createTrax() {
		Songs tracks = new SongLibrary();
		tracks.addSong(createStricken());
		return tracks;
	}

	static Year createYear(final int year) {
		return MyMusicAnywhereFactory.createYear(year);
	}
}
