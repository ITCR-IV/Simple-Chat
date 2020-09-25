package cr.ac.itcr.chat.GUI;

import cr.ac.itcr.chat.GUI.newChat.addChatWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppFxmlController {

    @FXML
    private ListView contactsDisplay;
    
    public ListView getContactsDisplay() {
        return contactsDisplay;
    }

    @FXML
    private Label CurrentSession;
    @FXML
    private TextField MsgBox;

    @FXML //When New Chat button is pressed
    private void open_new_chat_selector(ActionEvent event) throws Exception {
        addChatWindow window = new addChatWindow(); //Passes itself as parameter so that later it can tell the controller who's its parent controller
    }

    //When Send button is pressed
    public void send_msg(ActionEvent actionEvent) {
        System.out.println("Sending msg:" + MsgBox.getText()); // :TODO: 9/20/2020 send msgs through socket and then display in chat
        System.out.println(contactsDisplay);
    }

    public void update_info() {
        CurrentSession.setText("Current Session:\n" + App.user.getIp().getHostAddress() + ":" + Integer.toString(App.user.getPort()));
    }

}
