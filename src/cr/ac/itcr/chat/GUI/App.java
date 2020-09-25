package cr.ac.itcr.chat.GUI;

import cr.ac.itcr.chat.sockets.ChatMessage;
import cr.ac.itcr.chat.sockets.Contact;
import cr.ac.itcr.chat.sockets.Receiver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App extends Application {
    // TODO: 9/20/2020 add label where chat msgs are going to be displayed 
    private Window window;
    public static Map<Contact, List<ChatMessage>> messagesDB = new HashMap<>(); //To store contacts + their msgs
    public static Receiver receiver; //Creates the receiver for the current instance
    public static Contact user; //quick access to the current user

    //What to do before application starts
    @Override

    public void init() throws Exception {
        receiver = new Receiver();
        user = new Contact(InetAddress.getLocalHost(), receiver.getPort());
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        primaryStage.setTitle("Simple Chat");
        primaryStage.setResizable(false);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_fxml.fxml")); //Group node that is root
        Parent root = loader.load();
        AppFxmlController controller = loader.getController();
        controller.update_info();

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
    public Window getStage() {
        return window;
    }

}
