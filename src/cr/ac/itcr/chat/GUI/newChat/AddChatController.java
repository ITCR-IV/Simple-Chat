package cr.ac.itcr.chat.GUI.newChat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AddChatController {
    @FXML
    private javafx.scene.control.Button closeButton;

    public void closeButtonAction(ActionEvent actionEvent) {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
