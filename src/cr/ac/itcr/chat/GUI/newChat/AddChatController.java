package cr.ac.itcr.chat.GUI.newChat;

import cr.ac.itcr.chat.GUI.AppFxmlController;
import cr.ac.itcr.chat.GUI.contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddChatController {
    @FXML private Button cancelButton;
    @FXML private TextField IPBox;
    @FXML private TextField PortBox;
    private AppFxmlController parentController;


    public void cancelButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void OKButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        contact newContact = new contact(IPBox.getText(), PortBox.getText());
        parentController.add_contact(newContact);
        stage.close();
    }

    public void setParentController(AppFxmlController parentController) {
        this.parentController = parentController;
    }
}
