package DesignPatterns_Vaaskaran;

/*
 Bill Pugh solution 
 This method does not need to use the synchronization technique and eager initialization. 
 It is regarded as the standard method to implement singletons in Java.
 */
class Singleton_BillPugh {

	private static Singleton_BillPugh _singleton;

	private Singleton_BillPugh() {}

	private static class SingletonHelper {

		//Nested class is referenced after hetSingleton() is called 
		private static final Singleton_BillPugh _singleton = new Singleton_BillPugh();
	}

	public static Singleton_BillPugh getSingleton() {
		return SingletonHelper._singleton;
	}
}
