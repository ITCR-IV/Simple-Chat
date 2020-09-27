package cr.ac.itcr.chat.GUI;

import cr.ac.itcr.chat.communication.ChatMessage;
import cr.ac.itcr.chat.communication.Contact;
import cr.ac.itcr.chat.communication.Receiver;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * App class is the main class of the applicationv
 */
@SuppressWarnings("SpellCheckingInspection")
public class App extends Application {
    private Window window;

    private static Map<String, ObservableList<ChatMessage>> messagesDB = new HashMap<>(); //To store contacts + their msgs
    private static Receiver receiver; //Creates the receiver for the current instance
    private static Contact user; //quick access to the current user
    private static AppFxmlController controller;

    public static Map<String, ObservableList<ChatMessage>> getMessagesDB() {
        return messagesDB;
    }

    /**
     * @return dfgdf
     */
    public static Receiver getReceiver() {
        return receiver;
    }

    /**
     * @return The ip and port of the user
     */
    public static Contact getUser() {
        return user;
    }

    /**
     * What to do before application starts
     */
    @Override
    public void init() throws Exception {
        receiver = new Receiver();
        user = new Contact(InetAddress.getLocalHost(), getReceiver().getPort());
    }

    /**
     * Main thread when application's running
     */
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

    /**
     * What to do when application closes
     */
    @Override
    public void stop() throws Exception {
        getReceiver().terminate();
    }

    /**
     * This is so the addChatWindow can find this parent window and set it as owner
     *
     * @return The main stage
     */
    public Window getStage() {
        return window;
    }

    /**
     * Method to add a contact to the messagesDB and the App's listview, is here to easily reference the controller
     *
     * @param contact
     * @throws UnknownHostException
     */
    public static void addContact(Contact contact) throws UnknownHostException {
        // TODO: 9/25/2020 make it so you can't add yourself
        String key;

        //Validación de si ingresa ip de misma máquina que lo agrege como localhost
        if (contact.getIp().getHostAddress().equals(App.getUser().getIp().getHostAddress())) {
            key = new Contact(InetAddress.getByName("localhost"), contact.getPort()).getContactInfo();
        } else {
            key = contact.getContactInfo();
        }

        if (!getMessagesDB().containsKey(key)) {
            getMessagesDB().put(key, FXCollections.observableArrayList());
            controller.getContactsDisplay().getItems().add(contact);
        }
    }

    /**
     * Adds a message to the messages hashmap in the conversation with the contact passed as a parameter
     *
     * @param contact
     * @param msg
     */
    public static void addMessage(Contact contact, ChatMessage msg) {
        // TODO: 9/25/2020 Add validation for msgs (not empty or whatevs)
        getMessagesDB().get(contact.getContactInfo()).add(msg);
        // TODO: 9/25/2020 fix bug where if called from thread it throws exception for not being the javafx thread
    }

}
