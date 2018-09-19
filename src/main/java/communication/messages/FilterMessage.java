package communication.messages;

public class FilterMessage {
    String sender;
    String message;
    String location;
    String media;

    public FilterMessage(String sender, String message, String location, String media){
        this.sender=sender;
        this.message=message;
        this.location=location;
        this.media=media;
    }

    public String getLocation() {
        return location;
    }

    public String getMedia() {
        return media;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }
}
