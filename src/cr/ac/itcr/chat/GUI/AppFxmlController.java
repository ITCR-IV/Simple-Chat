package cr.ac.itcr.chat.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import cr.ac.itcr.chat.GUI.newChat.addChatWindow;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppFxmlController {


    @FXML
    private void open_new_chat_selector(ActionEvent event) throws Exception {
        addChatWindow window = new addChatWindow(this);
    }

    public void send_msg(ActionEvent actionEvent) {
        System.out.println("Sending msg");
    }
}
