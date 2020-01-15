package DesignPatterns_Vaaskaran.ObserverSimple;

import java.util.ArrayList;
import java.util.List;

interface ISubject {

	void register(ObserverSimple o);

	void unregister(ObserverSimple o);

	void notifyObservers();
}




