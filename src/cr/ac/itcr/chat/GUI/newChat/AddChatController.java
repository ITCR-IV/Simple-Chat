package cr.ac.itcr.chat.GUI.newChat;

import cr.ac.itcr.chat.GUI.App;
import cr.ac.itcr.chat.sockets.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddChatController {
    //fxml file elements
    @FXML
    private Button cancelButton;
    @FXML
    private TextField IPBox;
    @FXML
    private TextField PortBox;


    public void cancelButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow(); //get the stage
        stage.close();
    }

    public void OKButtonAction(ActionEvent actionEvent) throws UnknownHostException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        // TODO: 9/24/2020 Add port and ip verification
        // TODO: 9/25/2020 Check for empty fields
        Contact newContact = new Contact(InetAddress.getByName(IPBox.getText()), Integer.parseInt(PortBox.getText())); //generate new contact object
        if (Contact.serverExists(newContact)) {
            App.addContact(newContact); //pass it to parent controller}
            stage.close();
        }
    }
}
