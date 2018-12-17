package guienzo;

import communication.clienthandler.IClientHandler;

import java.util.ArrayList;

public interface IGui {
    void setClientHandler(IClientHandler clientHandler);
    void setSearchTerms(ArrayList<String> terms);
    void updateSearchTerms(String term, boolean add);
}
