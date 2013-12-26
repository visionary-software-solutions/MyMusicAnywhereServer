package com.visionarysoftwaresolutions.mymusicanywhere.musicLibrary;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.Collections;

import com.visionarysoftwaresolutions.mymusicanywhere.server.InvalidFileTypeException;
import com.visionarysoftwaresolutions.mymusicanywhere.server.mp3.MP3File;

public class Mp3Finder implements FileVisitor<Path> {
	private final Collection<MP3File> found;
	
	public Mp3Finder(Collection<MP3File> mp3s) {
		found = mp3s;
	}
	
	public Collection<MP3File> getFound() {
		return Collections.unmodifiableCollection(found);
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
			throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		if(Files.isRegularFile(file, LinkOption.NOFOLLOW_LINKS) && isSuffixedWithMp3(file) ) {
			// TODO: consider replacing with concurrent SeekableByteChannel approach
			MP3File toAddFile;
			try {
				toAddFile = new MP3File(file);
			} catch (InvalidFileTypeException e) {
				System.err.println("had a problem creating MP3 file" + e.getLocalizedMessage());
				return FileVisitResult.CONTINUE;
			}
			found.add(toAddFile);
		}
		return FileVisitResult.CONTINUE;
	}

	private boolean isSuffixedWithMp3(Path file) {
		return file.getFileName().toString().endsWith(".mp3");
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
			throws IOException {
		return FileVisitResult.CONTINUE;
	}

}
