package DesignPatterns;

import java.util.Set;
import java.util.TreeSet;

public final class ImmutableAndThreadSafe {
//	
//	immutable Planets class whose objects store sets of planet
//names. Although the set is mutable, the design of this class prevents the set from being
//modified after the constructor exits. By declaring planets final, the reference stored
//in this field cannot be modified. Furthermore, this reference will not be cached so the
//cached variable problem goes away.
//Java provides a special thread-safety guarantee concerning immutable objects. These
//objects can be safely accessed from multiple threads, even when synchronization isn’t
//used to publish (expose) their references provided that the following rules are observed:
//• Immutable objects must not allow state to be modified.
//• All fields must be declared final.
//• Objects must be properly constructed so that “this” references
//don’t escape from constructors.

	private final Set<String> planets = new TreeSet<>();

	public ImmutableAndThreadSafe() {
		planets.add("Mercury");
		planets.add("Venus");
		planets.add("Earth");
		planets.add("Mars");
		planets.add("Jupiter");
		planets.add("Saturn");
		planets.add("Uranus");
		planets.add("Neptune");
	}

	public boolean isPlanet(String planetName) {
		return planets.contains(planetName);
	}
}
