
package Spring.CustomEvent;

import org.springframework.context.annotation.Bean;

public class Configuration {
	
	@Bean
	public CustomEventPublisher customEventPublisher(){
		return new CustomEventPublisher();
	}
	

}
