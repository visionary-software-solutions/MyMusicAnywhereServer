package com.visionarysoftwaresolutions.mymusicanywhere.server;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Tag;
import com.visonarysoftwaresolutions.types.Name;

public class DefaultTag implements Tag {
	private final Name name;
	
	public DefaultTag(final Name theName) {
		this.name = theName;
	}
	
	@Override
	public Name getName() {
		return name;
	}

}
