package DesignPatterns_Pluralsight.Behavioral.CommandPattern;

//client
import java.util.ArrayList;
import java.util.List;

public class CommandDemo {

	public static void main(String[] args) {
		Light bedroomLight = new Light();
		Light kitchenLlight = new Light();
		Switch lightSwitch = new Switch();

		Command onCommand = new ToggleCommand(bedroomLight);
		lightSwitch.storeAndExecute(onCommand);
		lightSwitch.storeAndExecute(onCommand);


		List<Light> lights = new ArrayList<>();
		lights.add(kitchenLlight);
		lights.add(bedroomLight);
		
		Command allLightsOffCommand = new AllLightsOffCommand(lights);
		Command allLightsOnCommand = new AllLightsOnCommand(lights);
		
		lightSwitch.storeAndExecute(allLightsOnCommand);
	}
}
