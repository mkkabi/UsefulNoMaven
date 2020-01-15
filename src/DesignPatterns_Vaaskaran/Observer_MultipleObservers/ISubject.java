package DesignPatterns_Vaaskaran.Observer_MultipleObservers;

interface ISubject {
	void register(IObserver o);
	void unregister(IObserver o);
	void notifyObservers(int i);
}
