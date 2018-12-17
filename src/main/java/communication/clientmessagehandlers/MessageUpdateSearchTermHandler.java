package communication.clientmessagehandlers;

import communication.clienthandler.IClientHandler;
import communication.messages.MessageUpdateSearchTerm;

public class MessageUpdateSearchTermHandler extends MessageHandler<MessageUpdateSearchTerm> {

    public MessageUpdateSearchTermHandler(IClientHandler clientHandler) {
        super(clientHandler);
    }

    @Override
    public void handleMessageInternal(MessageUpdateSearchTerm message, String sessionId) {
        clientHandler.updateSearchTerms(message.getSearchTerm(), message.DoAddTerm());
    }
}
