package cr.ac.itcr.chat.communication;

import cr.ac.itcr.chat.GUI.App;

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

    @Override
    public String toString() {
        if (sender.getIp().getHostAddress().equals(App.getUser().getIp().getHostAddress())) {
            return ("You: " + payload);
        } else {
            return (sender.getIp().getHostAddress() + ":" + sender.getPort() + ": " + payload);
        }
    }
}

