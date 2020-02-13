package DesignPatterns_Vaaskaran.Observer_MultipleObserversAndSubj;

interface ISubject {
	void register(IObserver o);
	void unregister(IObserver o);
	void notifyObservers(int i);
}