package DesignPatterns_Vaaskaran;

class RobotBody {
	public void CreateBody() {
		System.out.println("Body Creation done");
	}
}

class RobotColor {
	private String color;

	public void SetColor(String color) {
		this.color = color;
		System.out.println("Color is set to : " + this.color);
	}
}

class RobotMetal {
	private String metal;

	public void SetMetal(String metal) {
		this.metal = metal;
		System.out.println("Metal is set to : " + this.metal);
	}
}

class RobotFacade {
	RobotColor rc;
	RobotMetal rm;
	RobotBody rb;

	public RobotFacade() {
		rc = new RobotColor();
		rm = new RobotMetal();
		rb = new RobotBody();
	}

	public void ConstructRobot(String color, String metal) {
		System.out.println("\nCreation of the Robot Start");
		rc.SetColor(color);
		rm.SetMetal(metal);
		rb.CreateBody();
		System.out.println(" \nRobot Creation End");
		System.out.println();
	}
}

class FacadePatternEx {
	public static void main(String[] args) {
		System.out.println("***Facade Pattern Demo***");
		RobotFacade rf1 = new RobotFacade();
		rf1.ConstructRobot("Green", "Iron");
		RobotFacade rf2 = new RobotFacade();
		rf2.ConstructRobot("Blue", "Steel");
	}
}
