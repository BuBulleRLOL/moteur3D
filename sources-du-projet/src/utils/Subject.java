package utils;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Subject {

	private final Set<Observer> attached;

	public Subject() {
		attached = new LinkedHashSet<>();
	}

	public boolean attach(Observer obs) {
		return attached.add(obs);
	}

	public boolean detach(Observer obs) {
		return attached.remove(obs);
	}

	public void notifyObservers() {
		for(Observer o : attached) {
			o.update(this);
		}
	}

	public void notifyObservers(Object data) {
		for(Observer o : attached) {
			o.update(this, data);
		}
	}
}