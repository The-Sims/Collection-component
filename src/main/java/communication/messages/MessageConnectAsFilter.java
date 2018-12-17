package communication.messages;

public class MessageConnectAsFilter {
    String filterName;

    public MessageConnectAsFilter(String filterName){
        this.filterName = filterName;
    }

    public String getFilterName() {
        return filterName;
    }
}
