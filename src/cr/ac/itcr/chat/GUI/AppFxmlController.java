package cr.ac.itcr.chat.GUI;

import cr.ac.itcr.chat.GUI.newChat.addChatWindow;
import cr.ac.itcr.chat.sockets.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppFxmlController {

    @FXML
    private ListView<Contact> contactsDisplay;

    @FXML
    private Label CurrentSession;
    @FXML
    private TextField MsgBox;

    @FXML //When New Chat button is pressed
    private void open_new_chat_selector(ActionEvent event) throws Exception {
        addChatWindow window = new addChatWindow();
    }

    //When Send button is pressed
    public void send_msg(ActionEvent actionEvent) {
        System.out.println("Sending msg:" + MsgBox.getText()); // :TODO: 9/20/2020 send msgs through socket and then display in chat

        Contact contact = contactsDisplay.getSelectionModel().getSelectedItem();
        if (contact != null) {

        }
    }

    public void update_info() {
        CurrentSession.setText("Current Session:\n" + App.user.getIp().getHostAddress() + ": " + Integer.toString(App.user.getPort()));
    }

    public ListView getContactsDisplay() {
        return contactsDisplay;
    }
}
