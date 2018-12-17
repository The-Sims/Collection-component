package communication.clienthandler;

import communication.clientmessagegenerator.ClientMessageGenerator;
import communication.clientmessagegenerator.IClientMessageGenerator;
import guienzo.IGui;

import java.util.ArrayList;
import java.util.List;

public class ClientHandler implements IClientHandler {

    IClientMessageGenerator generator;
    IGui gui;

    public ClientHandler(IClientMessageGenerator generator){
        this.generator = generator;
    }

    @Override
    public void setGui(IGui gui) {
        this.gui = gui;
    }

    @Override
    public void sendTip(String origin, String sender, String message, String location) {
        generator.sendTip(origin, sender, message, location);
    }

    @Override
    public void setSearchTerms(ArrayList<String> terms) {
        gui.setSearchTerms(terms);
    }

    @Override
    public void updateSearchTerms(String term, boolean add) {
        gui.updateSearchTerms(term, add);
    }


}
