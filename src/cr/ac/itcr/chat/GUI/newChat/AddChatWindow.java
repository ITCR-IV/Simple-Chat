package cr.ac.itcr.chat.GUI.newChat;

import cr.ac.itcr.chat.GUI.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddChatWindow extends App {

    public AddChatWindow() throws Exception {
        //setup stage
        Stage stage = new Stage();
        stage.initOwner(getStage());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setTitle("Add Contact");

        //setup loader and send parent controller to controller
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addChat.fxml"));
        Parent root = loader.load();
        AddChatController controller = loader.getController();

        //setup scene
        Scene scene = new Scene(root, 250, 150);//setup the scene
        stage.setScene(scene);
        stage.show();
    }
}
