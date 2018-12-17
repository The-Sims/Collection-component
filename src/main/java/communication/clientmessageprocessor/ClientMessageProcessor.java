package communication.clientmessageprocessor;

import communication.clienthandler.IClientHandler;
import communication.clientmessagehandlers.IMessageHandler;
import communication.clientmessagehandlers.IMessageHandlerFactory;
import communication.messageprocessor.MessageProcessorBase;

public class ClientMessageProcessor extends MessageProcessorBase {

    public void processMessage(String sessionId, String type, String data){
        String simpleType = type.split("\\.")[type.split("\\.").length - 1];

        IMessageHandler handler = getMessageHandlerFactory().getHandler(simpleType, getHandler());
        handler.handleMessage(data, sessionId, getGson());
    }

    private IClientHandler clientHandler;

    public ClientMessageProcessor(IMessageHandlerFactory messageHandlerFactory, IClientHandler clientHandler)
    {
        super(messageHandlerFactory);
        this.clientHandler = clientHandler;
    }

    public IClientHandler getHandler(){
        return clientHandler;
    }
}
