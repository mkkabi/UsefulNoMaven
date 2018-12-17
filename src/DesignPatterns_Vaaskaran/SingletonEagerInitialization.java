package DesignPatterns_Vaaskaran;

public class SingletonEagerInitialization {

	//Early initialization 
	private static SingletonEagerInitialization _captain = new SingletonEagerInitialization();

	//We make the constructor private to prevent the use of "new" 
	private SingletonEagerInitialization() {}

	// Global point of access //SingletonEagerInitialization.getCaptain() is a public static //method 
	public static SingletonEagerInitialization getCaptain() {
		return _captain;
	}
}
