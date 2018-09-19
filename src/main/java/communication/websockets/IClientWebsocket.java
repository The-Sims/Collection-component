package communication.websockets;

import communication.messageprocessor.IMessageProcessor;

public interface IClientWebsocket {
    void start();

    void stop();

    void send(Object object);

    void setMessageHandler(IMessageProcessor handler);

    void onWebSocketMessageReceived(String message, String sessionId);
}
