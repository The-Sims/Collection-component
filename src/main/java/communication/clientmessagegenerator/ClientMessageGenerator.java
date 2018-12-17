package communication.clientmessagegenerator;

import communication.clientwebsockets.IClientWebsocket;
import models.MessageTip;

public class ClientMessageGenerator implements IClientMessageGenerator {

    private IClientWebsocket clientSocket;

    public ClientMessageGenerator(IClientWebsocket clientSocket){
        this.clientSocket = clientSocket;
    }


    @Override
    public void sendTip(String origin, String sender, String message, String location) {
        MessageTip msg = new MessageTip(origin, sender, message, location);
        clientSocket.send(msg);
    }
}
