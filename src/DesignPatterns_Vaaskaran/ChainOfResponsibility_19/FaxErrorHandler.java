package ChainOfResponsibility_19;

class FaxErrorHandler implements IReceiver {
    private IReceiver _nextReceiver;

    public FaxErrorHandler(IReceiver nextReceiver) {
        _nextReceiver = nextReceiver;
    }

    public Boolean ProcessMessage(Message msg) {
        if (msg.Text.contains("Fax")) {
            System.out.println("FaxErrorHandler processed " + msg.Priority + "priority issue: " + msg.Text);
            return true;
        } else {
            if (_nextReceiver != null)
                _nextReceiver.ProcessMessage(msg);
        }
        return false;
    }
}
