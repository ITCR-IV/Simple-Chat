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

/**
 * Controller for the fxml of the main application
 *
 * @Author Ignacio Vargas
 */
public class AppFxmlController {

    @FXML
    private ListView<ChatMessage> msgList;
    @FXML
    private ListView<Contact> contactsDisplay;
    @FXML
    private Label CurrentSession;
    @FXML
    private TextField msgBox;

    /**
     * Event when New Chat button is pressed
     *
     * @param event
     * @throws Exception
     */
    @FXML
    private void open_new_chat_selector(ActionEvent event) throws Exception {
        AddChatWindow window = new AddChatWindow();
    }

    /**
     * Event when Send button is pressed
     *
     * @param actionEvent
     */
    public void send_msg(ActionEvent actionEvent) {
        ChatMessage msg = new ChatMessage(App.getUser(), msgBox.getText());
        Contact contact = contactsDisplay.getSelectionModel().getSelectedItem();
        if (contact != null) {
            contact.sendMessage(msg);
        }
    }

    /**
     * Updates the label with the information of the current session (ip and port), only needs to be called once
     */
    public void update_info() {
        CurrentSession.setText("Current Session:\n" + App.getUser().getIp().getHostAddress() + ": " + App.getUser().getPort());
    }

    /**
     * @return contactsDisplay
     */
    public ListView getContactsDisplay() {
        return contactsDisplay;
    }

    /**
     * Event when the contacts listview is clicked, changes the current conversation to the contact that was clicked
     *
     * @param mouseEvent
     */
    public void clickedContacts(MouseEvent mouseEvent) {
        Contact contact = contactsDisplay.getSelectionModel().getSelectedItem();
        if (contact != null) {
            msgList.setItems(App.getMessagesDB().get(contact.getContactInfo()));
            //Display messages
        }
    }
}
