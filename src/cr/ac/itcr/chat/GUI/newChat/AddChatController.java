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
    private Stage stage = (Stage) cancelButton.getScene().getWindow();

    public void cancelButtonAction(ActionEvent actionEvent) {
        stage.close();
    }

    public void OKButtonAction(ActionEvent actionEvent) {
        contact newContact = new contact(IPBox.getText(), PortBox.getText());
        stage.getOwner();
    }

    public void setParentController(AppFxmlController parentController) {
        this.parentController = parentController;
    }
}
