package DesignPatterns_Vaaskaran.ObserverSimple;

import java.util.ArrayList;
import java.util.List;

class Subject implements ISubject {

	List<ObserverSimple> observerList = new ArrayList<ObserverSimple>();
	private int _flag;

	public int getFlag() {
		return _flag;
	}

	public void setFlag(int _flag) {
		this._flag = _flag;
		//flag value changed .So notify observer(s) 
		notifyObservers();
	}

	@Override
	public void register(ObserverSimple o) {
		observerList.add(o);
	}

	@Override
	public void unregister(ObserverSimple o) {
		observerList.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observerList.size(); i++) {
			observerList.get(i).update();
		}
	}
}