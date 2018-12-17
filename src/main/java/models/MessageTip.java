package models;

public class MessageTip {
    Origin origin;
    String sender;
    String message;
    String location;

    public MessageTip(String origin, String sender, String message, String location) {
        this.origin = Origin.TWITTER;
        this.sender = sender;
        this.message = message;
        this.location = location;
    }

    public Origin getOrigin() {
        return origin;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Origin: " + origin + ", Sender: " + sender + ", Message: " + message + ", Location: " + location;
    }
}
