package ChainOfResponsibility_19;

interface IReceiver {
    Boolean ProcessMessage(Message msg);
}
