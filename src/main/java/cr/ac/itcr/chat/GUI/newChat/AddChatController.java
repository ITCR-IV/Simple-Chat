package cr.ac.itcr.chat.GUI.newChat;

import cr.ac.itcr.chat.GUI.App;
import cr.ac.itcr.chat.communication.Contact;
import cr.ac.itcr.chat.communication.Receiver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Controller for the fxml of the adding a contact window
 */
public class AddChatController {
    //fxml file elements
    @FXML
    private Button cancelButton;
    @FXML
    private TextField IPBox;
    @FXML
    private TextField PortBox;

    private static final Logger log = LoggerFactory.getLogger(Receiver.class);

    /**
     * Event when the cancel button is pressed, closes teh window
     *
     * @param actionEvent
     */
    public void cancelButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow(); //get the stage
        stage.close();
    }

    /**
     * Event when the ok button is pressed, adds the contact and closes the window
     *
     * @param actionEvent
     * @throws UnknownHostException
     */
    public void OKButtonAction(ActionEvent actionEvent) throws UnknownHostException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        // TODO: 9/24/2020 Add port and ip verification
        // TODO: 9/25/2020 Check for empty fields
        try {
            Contact newContact = new Contact(InetAddress.getByName(IPBox.getText()), Integer.parseInt(PortBox.getText())); //generate new contact object
            if (Contact.serverExists(newContact)) {
                App.addContact(newContact); //pass it to parent controller}
                stage.close();
            }
        } catch (UnknownHostException e) {
            log.error("Invalid parameters for ip/port fields", e);
            System.out.println("Invalid parameters for ip/port fields");
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            log.error("Invalid parameters for ip/port fields", e);
            System.out.println("Invalid parameters for ip/port fields");
            System.out.println(e.getMessage());
        }
    }
}
