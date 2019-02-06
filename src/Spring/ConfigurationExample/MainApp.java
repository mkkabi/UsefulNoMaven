package Spring.ConfigurationExample;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
//		  Java Based Configuration
		ConfigurableApplicationContext  ctx = new AnnotationConfigApplicationContext(ConfigurationExample.class);
 
		ConfigurationExampleTest configurationExampleTest = ctx.getBean(ConfigurationExampleTest.class);
		configurationExampleTest.getMessage();
		configurationExampleTest.ced.getMessage();

//		method that is declared on the AbstractApplicationContext class. 
//		This will ensure a graceful shutdown and call the relevant destroy methods.
		ctx.registerShutdownHook();
	}
}
