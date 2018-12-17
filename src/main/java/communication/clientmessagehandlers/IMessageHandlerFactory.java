package communication.clientmessagehandlers;

public interface IMessageHandlerFactory {
    IMessageHandler getHandler(String simpleType, Object game);
}
