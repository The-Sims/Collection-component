package communication.clientmessagehandlers;

import communication.clienthandler.IClientHandler;

public class ClientMessageHandlerFactory implements IMessageHandlerFactory {

    public IMessageHandler getHandler(String simpleType, Object clientHandlerIn) {
        IClientHandler clientHandler = (IClientHandler) clientHandlerIn;
        switch(simpleType){
            /*case "MessageDeath":
                return new MessageDeathHandler(clientHandler);*/
            case "MessageSendSearchTerms":
                return new MessageSendSearchTermsHandler(clientHandler);
            case "MessageUpdateSearchTerm":
                return new MessageUpdateSearchTermHandler(clientHandler);
            default:
                return null;
        }
    }
}
