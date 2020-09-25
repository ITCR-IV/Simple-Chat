package cr.ac.itcr.chat.GUI;

import cr.ac.itcr.chat.GUI.newChat.addChatWindow;
import cr.ac.itcr.chat.sockets.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppFxmlController {

    @FXML
    private Label CurrentSession;
    @FXML
    private TextField MsgBox;

    public AppFxmlController() {
        CurrentSession.setText("Current Session: " + App.user.getIp().getHostAddress() + ":" + Integer.toString(App.user.getPort()));
    }


    @FXML //When New Chat button is pressed
    private void open_new_chat_selector(ActionEvent event) throws Exception {
        addChatWindow window = new addChatWindow(this); //Passes itself as parameter so that later it can tell the controller who's its parent controller
    }

    //When Send button is pressed
    public void send_msg(ActionEvent actionEvent) {
        System.out.println("Sending msg:" + MsgBox.getText()); // :TODO: 9/20/2020 send msgs through socket and then display in chat
    }

    //Method called by child controller when OK button is pressed
    public void add_contact(Contact contact) {
        System.out.println("IP: " + contact.getIp());
        System.out.println("Port:" + contact.getPort());
    }
}
