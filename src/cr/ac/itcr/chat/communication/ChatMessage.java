package cr.ac.itcr.chat.communication;

import cr.ac.itcr.chat.GUI.App;

/**
 * Class stores the sender and payload information of a ChatMessage
 */
public class ChatMessage {

    private Contact sender;
    private String payload;

    /**
     * Class constructor
     *
     * @param sender
     * @param payload
     */
    public ChatMessage(Contact sender, String payload) {
        this.sender = sender;
        this.payload = payload;
    }

    /**
     * @return Contact object of the sender
     */
    public Contact getSender() {
        return this.sender;
    }

    /**
     * @return payload string
     */
    public String getPayload() {
        return this.payload;
    }

    /**
     * Overrides the toString method of this class for listview purposes
     *
     * @return string with "contact info: payload" or "You: payload" if the sender is your own address
     */
    @Override
    public String toString() {
        if (sender.getIp().getHostAddress().equals(App.getUser().getIp().getHostAddress())) {
            return ("You: " + payload);
        } else {
            return (sender.getIp().getHostAddress() + ":" + sender.getPort() + ": " + payload);
        }
    }
}

