package ChainOfResponsibility_19;

class Message {
    public String Text;
    public MessagePriority Priority;

    public Message(String msg, MessagePriority p) {
        Text = msg;
        this.Priority = p;
    }
}
