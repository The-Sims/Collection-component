package communication.clientmessagehandlers;

import communication.clienthandler.IClientHandler;
import communication.messages.MessageSendSearchTerms;

public class MessageSendSearchTermsHandler extends MessageHandler<MessageSendSearchTerms> {


    public MessageSendSearchTermsHandler(IClientHandler clientHandler) {
        super(clientHandler);
    }

    @Override
    public void handleMessageInternal(MessageSendSearchTerms message, String sessionId) {
        clientHandler.setSearchTerms(message.getSearchTerms());
    }
}
