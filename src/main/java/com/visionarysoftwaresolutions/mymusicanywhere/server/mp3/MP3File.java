package com.visionarysoftwaresolutions.mymusicanywhere.server.mp3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFile;
import com.visionarysoftwaresolutions.mymusicanywhere.server.InvalidFileTypeException;

public class MP3File implements AudioFile {
	private final Path toFile;
	private final ID3Tag tag;
	
	public MP3File(final Path audioFile) throws InvalidFileTypeException, IOException {
		final String fileName = audioFile.getFileName().toString();
		if (Files.isRegularFile(audioFile, LinkOption.NOFOLLOW_LINKS) && 
				fileName.endsWith(".mp3")) {
			toFile = audioFile.toRealPath(LinkOption.NOFOLLOW_LINKS);
		} else {
			throw new InvalidFileTypeException("wrong file type", fileName);
		}
		tag = ID3TagFactory.createTag(Files.newInputStream(audioFile, StandardOpenOption.READ));
	}
	
	@Override
	public byte[] getBytes() {
		try {
			return Files.readAllBytes(toFile);
		} catch (IOException e) {
			throw new RuntimeException("unable to get bytes because", e);
		}
	}
	
	public ID3Tag getTag() {
		return tag;
	}

}
