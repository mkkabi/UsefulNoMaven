
package DesignPatterns_Pluralsight.Behavioral.CommandPattern;

import java.util.List;

public class AllLightsOnCommand implements Command {

	private List<Light> lights;
	public AllLightsOnCommand(List<Light> lights) {
		this.lights = lights;
	}

	@Override
	public void execute() {
		for(Light light : lights){
			if(!light.isOn()){
				light.toggle();
			}
		}
	}

}
