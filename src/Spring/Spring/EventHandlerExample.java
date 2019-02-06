
package Spring.Spring;

import java.util.stream.Stream;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;


public class EventHandlerExample implements ApplicationListener{
	
	static{
		System.out.println("created EventHandlerExample");
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		
		System.out.println(event.getClass());
	}
	
//	public void onApplicationEvent(ContextStartedEvent event) {
//      System.out.println("ContextStartedEvent Received");
//   }
//	
//	public void onApplicationEvent(ContextStoppedEvent event) {
//      System.out.println("ContextStoppedEvent Received");
//   }

}
