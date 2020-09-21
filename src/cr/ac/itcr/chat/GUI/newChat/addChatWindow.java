package cr.ac.itcr.chat.GUI.newChat;

import cr.ac.itcr.chat.GUI.application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class addChatWindow extends application {

    public addChatWindow() throws Exception {
        System.out.println("doing stuff");
        Stage stage = new Stage();
        stage.initOwner(getStage());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setTitle("Add Contact");

        Parent root = FXMLLoader.load(getClass().getResource("addChat.fxml"));
        Scene scene = new Scene(root, 250, 150);//setup the scene
        stage.setScene(scene);
        stage.show();
    }
}