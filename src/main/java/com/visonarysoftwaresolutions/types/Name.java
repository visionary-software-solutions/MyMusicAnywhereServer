package com.visonarysoftwaresolutions.types;

public class Name {
	private final String name;
	
	public Name(final String toName) {
		if (toName == null || toName.isEmpty()) {
			throw new IllegalArgumentException("Cannot have null or empty name");
		}
		this.name = toName;
	}
	
	public boolean contains (final Name another) {
		return name.contains(another.name);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(final Object another) {
		return another instanceof Name && equals((Name)another);
	}
	
	private boolean equals(final Name another) {
		return name.equalsIgnoreCase(another.name);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
