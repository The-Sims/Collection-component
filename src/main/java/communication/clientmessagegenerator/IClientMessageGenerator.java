package communication.clientmessagegenerator;


public interface IClientMessageGenerator {
    void sendTip(String origin, String sender, String message, String location);
}
