package Spring.Spring;

import Spring.ConfigurationExample.*;
import org.springframework.context.annotation.*;

/*
 The @Import annotation allows for loading @Bean definitions from another configuration class. 
 rather than needing to specify both ConfigA.class and ConfigurationExample.class when instantiating the context, 
 only ConfigurationExample needs to be supplied as follows
 ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurationExample.class);
 */
@Configuration
@Import(ConfigA.class)
public class ConfigurationExample {

	/*
	 When @Beans have dependencies on one another, expressing that the dependency is 
	 as simple as having one bean method calling another as follows 
	 */
	/*
	 ==Lifecycle Callbacks
	 Th@Bean annotation supports specifying arbitrary initialization and destruction callback methods, 
	 much like Spring XML's init-method and destroy-method attributes on the bean element
	
	 ==Specifying Bean Scope
	 The default scope is singleton, but you can override this with the @Scope annotation
	 */
	@Bean(initMethod = "init", destroyMethod = "cleanup")
	@Scope("prototype")
	public ConfigurationExampleTest foo() {
		return new ConfigurationExampleTest(configurationExampleDependee());
	}

	@Bean
	public ConfigurationExampleDependee configurationExampleDependee() {
		return new ConfigurationExampleDependee();
	}
	
	@Bean
	public EventHandlerExample eventHandlerExample(){
		return new EventHandlerExample();
	}

}
