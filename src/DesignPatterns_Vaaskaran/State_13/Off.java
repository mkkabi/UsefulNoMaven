package State;

class Off extends State.RemoteControl {
    @Override
    public void pressSwitch(State.TV context) {
        System.out.println("I am Off .Going to be State.On now");
        context.setState(new State.On());
    }
}
