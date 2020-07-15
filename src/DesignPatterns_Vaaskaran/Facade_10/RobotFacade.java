package Facade;

public class RobotFacade {
    RobotColor rc;
    RobotMetal rm;
    RobotBody rb;

    public RobotFacade() {
        rc = new RobotColor();
        rm = new RobotMetal();
        rb = new RobotBody();
    }

    public void ConstructRobot(String color, String metal) {
        rc.SetColor(color);
        rm.SetMetal(metal);
        rb.CreateBody();
    }
}