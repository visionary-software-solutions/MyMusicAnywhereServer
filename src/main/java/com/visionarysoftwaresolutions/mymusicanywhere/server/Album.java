package com.visionarysoftwaresolutions.mymusicanywhere.server;

import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.Year;

public interface Album {
	Name getName();
	Year getYear();
	Songs getSongs();
	Artists getArtists();
}
