package ChainOfResponsibility_19;

class IssueRaiser {
    public IReceiver setFirstReceiver;

    public IssueRaiser(IReceiver firstReceiver) {
        this.setFirstReceiver = firstReceiver;
    }

    public void RaiseMessage(Message msg) {
        if (setFirstReceiver != null)
            setFirstReceiver.ProcessMessage(msg);
    }
}
