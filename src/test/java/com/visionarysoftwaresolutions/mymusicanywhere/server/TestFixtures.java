package com.visionarysoftwaresolutions.mymusicanywhere.server;

public class TestFixtures {
	static Name createName(String name) {
		return new Name(name);
	}
	
	static Song createStricken(Artist disturbed) {
		return new DefaultSong(createName("Stricken"), disturbed);
	}

	static MusicLibrary createLibrary() {
		return new DefaultMusicLibrary();
	}

	public static Artist createArtist(String string) {
		return new DefaultArtist(string);
	}

	public static Album createTenThousandFists() {
		Artist disturbed = createArtist("Disturbed");
		Songs tracks = new SongLibrary();
		tracks.addSong(createStricken(disturbed));
		Album tenThousandFists = new DefaultAlbum(createName("Ten Thousand Fists"),
				new Year(new NaturalNumber(2005)), 
				tracks);
		return tenThousandFists;
	}
}
