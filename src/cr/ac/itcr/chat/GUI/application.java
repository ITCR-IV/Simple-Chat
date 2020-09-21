package cr.ac.itcr.chat.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class application extends Application{

    private Window window;

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

    @Override
    public void stop() throws Exception {
        System.out.println("After");
    }

    public Window getStage(){
        return window;
    }
}
