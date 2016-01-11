package org.team1515.robama.subsystems;

public class Triple<Type> {
	
	public final Type first;
	public final Type middle;
	public final Type last;
	
	public Triple(Type first, Type middle, Type last) {
		this.first = first;
		this.middle = middle;
		this.last = last;
	}
}
