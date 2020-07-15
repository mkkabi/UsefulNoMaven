package Mediator_17;

// Friend3—Third participant. He is the boss. He is notified whenever friend1 and friend2 communicate.
class Boss extends Friend {
    // Constructor
    public Boss(Mediator mediator, String name) {
        super(mediator);
        this.name = name;
    }

    public void Send(String msg) {
        mediator.Send(this, msg);
    }

    public void Notify(String msg) {
        System.out.println("\nBoss sees message: " + msg);
        System.out.println("");
    }
}
