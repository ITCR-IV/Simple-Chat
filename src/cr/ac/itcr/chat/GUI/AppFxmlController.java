package cr.ac.itcr.chat.GUI;

import cr.ac.itcr.chat.GUI.newChat.AddChatWindow;
import cr.ac.itcr.chat.communication.ChatMessage;
import cr.ac.itcr.chat.communication.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AppFxmlController {

    @FXML
    private ListView<ChatMessage> msgList;
    @FXML
    private ListView<Contact> contactsDisplay;
    @FXML
    private Label CurrentSession;
    @FXML
    private TextField msgBox;

    @FXML //When New Chat button is pressed
    private void open_new_chat_selector(ActionEvent event) throws Exception {
        AddChatWindow window = new AddChatWindow();
    }

    //When Send button is pressed
    public void send_msg(ActionEvent actionEvent) {
        ChatMessage msg = new ChatMessage(App.getUser(), msgBox.getText());
        Contact contact = contactsDisplay.getSelectionModel().getSelectedItem();
        if (contact != null) {
            contact.sendMessage(msg);
        }
    }


    public void update_info() {
        CurrentSession.setText("Current Session:\n" + App.getUser().getIp().getHostAddress() + ": " + App.getUser().getPort());
    }

    public ListView getContactsDisplay() {
        return contactsDisplay;
    }


    public void clickedContacts(MouseEvent mouseEvent) {
        Contact contact = contactsDisplay.getSelectionModel().getSelectedItem();
        if (contact != null) {
            msgList.setItems(App.getMessagesDB().get(contact.getContactInfo()));
            //Display messages
        }
    }
}
