package cr.ac.itcr.chat.GUI;

import cr.ac.itcr.chat.GUI.newChat.addChatWindow;
import cr.ac.itcr.chat.sockets.ChatMessage;
import cr.ac.itcr.chat.sockets.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppFxmlController {

    @FXML
    private ListView msgList;
    @FXML
    private ListView<Contact> contactsDisplay;
    @FXML
    private Label CurrentSession;
    @FXML
    private TextField msgBox;

    @FXML //When New Chat button is pressed
    private void open_new_chat_selector(ActionEvent event) throws Exception {
        addChatWindow window = new addChatWindow();
    }

    //When Send button is pressed
    public void send_msg(ActionEvent actionEvent) {
        ChatMessage msg = new ChatMessage(App.user, msgBox.getText());
        Contact contact = contactsDisplay.getSelectionModel().getSelectedItem();
        if (contact != null) {
            contact.sendMessage(msg);
        }
    }

    public void update_info() {
        CurrentSession.setText("Current Session:\n" + App.user.getIp().getHostAddress() + ": " + Integer.toString(App.user.getPort()));
    }

    public ListView getContactsDisplay() {
        return contactsDisplay;
    }
}
