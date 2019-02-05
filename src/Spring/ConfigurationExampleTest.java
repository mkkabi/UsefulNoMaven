
package Spring;

public class ConfigurationExampleTest {
	
	ConfigurationExampleDependee ced;
	
	public void getMessage(){
		 System.out.println("a message from "+this.getClass());
	 }
	
	public ConfigurationExampleTest(){}
	
	public ConfigurationExampleTest(ConfigurationExampleDependee c){
		ced = c;
	}
	
	public void setConfigurationExampleDependee (ConfigurationExampleDependee c){
		ced = c;
	}
	
	public void init(){
		System.out.println("init method from "+this.getClass());
	}
	
	public void cleanup(){
		System.out.println("cleanup method from "+this.getClass());
	}

}
