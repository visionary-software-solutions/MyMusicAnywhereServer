package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Album;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artist;
import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFile;
import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFiles;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Songs;
import com.visionarysoftwaresolutions.mymusicanywhere.server.mp3.MP3File;
import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.Year;

public class TheLostChildren {
	private static final Name name = TestFixtures.createName("The Lost Children");
	private static final Artist disturbed = TestFixtures.createDisturbed();
	private static final Year year = TestFixtures.createYear(2011);
	private static final Songs tracks = TestFixtures.createTrax(
			createHell(),
			createThisMoment(),
			createOldFriend(),
			createMonster(),
			createRun(),
			createLeaveItAlone(),
			createTwoWorlds(),
			createGodOfTheMind(),
			createSickened(),
			createMine(),
			createParasite(),
			createDehumanized(),
			create3(),
			createMidlifeCrisis(),
			createLivingAfterMidnight()); 
	
	public static Album createTheLostChildren() {
		return MyMusicAnywhereFactory.createAlbum(name, year, tracks);
	}
	
	public static Song createHell() {
		final Name name = MyMusicAnywhereFactory.createName("Hell");
		return MyMusicAnywhereFactory.createSong(name, disturbed);
	}
	
	public static Song createThisMoment() {
		final Name name = MyMusicAnywhereFactory.createName("This Moment");
		return MyMusicAnywhereFactory.createSong(name, disturbed);
	}
	
	public static Song createOldFriend() {
		final Name name = MyMusicAnywhereFactory.createName("Old Friend");
		return MyMusicAnywhereFactory.createSong(name, disturbed);
	}
	
	public static Song createMonster() {
		final Name name = MyMusicAnywhereFactory.createName("Monster");
		return MyMusicAnywhereFactory.createSong(name, disturbed);
	}
	
	public static Song createRun() {
		final Name name = MyMusicAnywhereFactory.createName("Run");
		return MyMusicAnywhereFactory.createSong(name, disturbed);
	}
	
	public static Song createLeaveItAlone() {
		final Name name = MyMusicAnywhereFactory.createName("Leave It Alone");
		return MyMusicAnywhereFactory.createSong(name, disturbed);
	}
	
	public static Song createTwoWorlds() {
		final Name name = MyMusicAnywhereFactory.createName("Two Worlds");
		return MyMusicAnywhereFactory.createSong(name, disturbed);
	}
	
    public static Song createGodOfTheMind() {
		final Name name = MyMusicAnywhereFactory.createName("God of the Mind");
		return MyMusicAnywhereFactory.createSong(name, disturbed);
	}
	
	public static Song createSickened() {
		final Name name = MyMusicAnywhereFactory.createName("Sickened");
		return MyMusicAnywhereFactory.createSong(name, disturbed);
	}
	
	public static Song createMine() {
		final Name name = MyMusicAnywhereFactory.createName("Mine");
		return MyMusicAnywhereFactory.createSong(name, disturbed);
	}
	
	public static Song createParasite() {
		final Name name = MyMusicAnywhereFactory.createName("Parasite");
		return MyMusicAnywhereFactory.createSong(name, disturbed);
	}
	
	public static Song createDehumanized() {
		final Name name = MyMusicAnywhereFactory.createName("Dehumanized");
		return MyMusicAnywhereFactory.createSong(name, disturbed);
	}
	
	public static Song create3() {
		final Name name = MyMusicAnywhereFactory.createName("3");
		return MyMusicAnywhereFactory.createSong(name, disturbed);
	}
	
	public static Song createMidlifeCrisis() {
		final Name name = MyMusicAnywhereFactory.createName("Midlife Crisis");
		return MyMusicAnywhereFactory.createSong(name, disturbed);
	}
	
	public static Song createLivingAfterMidnight() {
		final Name name = MyMusicAnywhereFactory.createName("Living After Midnight");
		return MyMusicAnywhereFactory.createSong(name, disturbed);
	}
	
	public static AudioFiles createLostChildrenAudio() {
		AudioFiles lostChildrenAudioFiles = new AudioFileSystem();
		for (Song aSong : tracks) {
			AudioFile file = getBytesFor(aSong, createLostChildrenPath());
			lostChildrenAudioFiles.addAudioForSong(aSong, file);
		}
		return lostChildrenAudioFiles;
	}
	
	
	private static AudioFile getBytesFor(Song aSong, Path toSearch) {
		AudioFile result = new EmptyAudioFile();
		if(Files.isDirectory(toSearch, LinkOption.NOFOLLOW_LINKS)) {
			try(DirectoryStream<Path> stream = 
					Files.newDirectoryStream(toSearch,  "*.mp3")) {
				result = extracted(aSong, stream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	private static AudioFile extracted(Song aSong,
			DirectoryStream<Path> stream) throws IOException {
		AudioFile result = new EmptyAudioFile();
		for(Path mp3File : stream) {
			final String name = mp3File.getFileName().toString();
			final Name potentialName = new Name(name);
			if(potentialName.contains(aSong.getName())) {
				try {
					result = new MP3File(mp3File);
				} catch (InvalidFileTypeException e) {
					throw new RuntimeException("did not expect to fail", e);
				}
			}
		}
		return result;
	}

	public static Path createLostChildrenPath() {
		return Paths.get("/home/master/The Lost Children");
	}
}
