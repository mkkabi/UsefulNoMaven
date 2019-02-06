package Spring.Spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
		objA.setMessage("I'm object A");
		objA.getMessage();
		objA.getMessage1();
		objA.getMessage2();

		HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
		objB.getMessage1();
		objB.getMessage2();
		objB.getMessage3();

		// example of dependency injection
		TextEditor te = (TextEditor) context.getBean("textEditor");
		te.spellCheck();

		// Injecting collection
		JavaCollection jc = (JavaCollection) context.getBean("javaCollection");

		jc.getAddressList();
		jc.getAddressSet();
		jc.getAddressMap();
		jc.getAddressProp();


//		method that is declared on the AbstractApplicationContext class. 
//		This will ensure a graceful shutdown and call the relevant destroy methods.
		context.registerShutdownHook();
	}
}
