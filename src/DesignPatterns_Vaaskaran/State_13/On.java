package  State;

public class On extends State.RemoteControl {
    @Override
    public void pressSwitch(State.TV context) {
        System.out.println("I am already On .Going to be Off now");
        context.setState(new Off());
    }
}
