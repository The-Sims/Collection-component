package communication.clienthandler;


import guienzo.IGui;

import java.util.ArrayList;

public interface IClientHandler {
    void setGui(IGui gui);
    void sendTip(String origin, String sender, String message, String location);
    void setSearchTerms(ArrayList<String> terms);
    void updateSearchTerms(String term, boolean add);
}
