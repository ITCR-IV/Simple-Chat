package cr.ac.itcr.chat.sockets;

public class ChatMessage {

    private Contact sender;
    private String payload;

    public ChatMessage(Contact sender, String payload) {
        this.sender = sender;
        this.payload = payload;
    }

    public Contact getSender() {
        return this.sender;
    }

    public String getPayload() {
        return this.payload;
    }
}

