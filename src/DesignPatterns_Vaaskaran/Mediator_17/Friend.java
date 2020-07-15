package Mediator_17;

// Friend
abstract class Friend {
    protected Mediator mediator;
    public String name;

    public Friend(Mediator _mediator) {
        mediator = _mediator;
    }
}
