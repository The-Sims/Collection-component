package communication.messagegenerator;

public class MessageGenerator implements IMessageGenerator {

    private IServerWebsocket serverSocket;

    public MessageGenerator(IServerWebsocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void sendKill(String playerId) {
        Object msg = new Object();
        serverSocket.sendTo(playerId, msg);
    }
}
