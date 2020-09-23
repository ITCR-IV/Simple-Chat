package cr.ac.itcr.chat.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class application extends Application{
    // TODO: 9/20/2020 add label where chat msgs are going to be displayed 
    private Window window;

    //What to do before application starts
    @Override
    public void init() throws Exception {
        System.out.println("Before");
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        window=primaryStage;
        primaryStage.setTitle("Simple Chat");
        primaryStage.setResizable(false);

        Parent root = FXMLLoader.load(getClass().getResource("app_fxml.fxml"));//Group node that is root

        Scene scene = new Scene(root, 800, 600);//setup the scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //What to do when application closes
    @Override
    public void stop() throws Exception {
        System.out.println("After");
    }

    //This is so the addChatWindow can find this parent window and set it as owner
    public Window getStage(){
        return window;
    }

}
