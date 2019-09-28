package Spring.CustomEvent;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);

        CustomEventPublisher cvp = (CustomEventPublisher) context.getBean("customEventPublisher");

        cvp.publish();
        cvp.publish();

        context.registerShutdownHook();
    }
}
