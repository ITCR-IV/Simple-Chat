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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App extends Application {
    private Window window;
    public static Map<Contact, List<ChatMessage>> messagesDB = new HashMap<>(); //To store contacts + their msgs
    public static Receiver receiver; //Creates the receiver for the current instance
    public static Contact user; //quick access to the current user
    private static AppFxmlController controller;

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
        controller = loader.getController();
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

    //Method to add a contact to the messagesDB and the App's listview, is here to easily reference the controller
    public static void add_contact(Contact contact) {
        // TODO: 9/25/2020 make it so you can't add yourself
        if (!App.messagesDB.containsKey(contact)) { // TODO: 9/25/2020 this always returns true, debug it so it won't add duplicates
            App.messagesDB.put(contact, new ArrayList<>());
            controller.getContactsDisplay().getItems().add(contact);
        }
    }

}
