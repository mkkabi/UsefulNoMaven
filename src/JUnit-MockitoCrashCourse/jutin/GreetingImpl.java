
package mk.mkkabi.jutin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GreetingImpl implements Greeting {

	@Override
	public String greet(String name){
		
		if(name == null || name.length() == 0){
			throw new IllegalArgumentException();
		}
		return "Hello "+ name;
	}

}
