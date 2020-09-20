package cr.ac.itcr.chat.GUI;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class application extends Application implements EventHandler<ActionEvent>{

    private Button addContact = new Button();

    //Contacts section
    private Rectangle contactsList = new Rectangle(0,0,300,600);

    //Chat msgs section
    private Rectangle chat=new Rectangle(300,0,700,400);

    //Chat text box section
    private Rectangle chatbox=new Rectangle(300,400,700,200);


    @Override
    public void init() throws Exception {
        System.out.println("Before");
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Simple Chat");
        primaryStage.setResizable(false);

        Group root = new Group();//Group node that is root

        ObservableList nodes = root.getChildren();

        //setup colors for areas
        contactsList.setFill(Color.AZURE);
        chatbox.setFill(Color.LIGHTGREY);
        chat.setFill(Color.GHOSTWHITE);

        nodes.addAll(contactsList, chat, chatbox);

        Scene scene = new Scene(root, 1000, 600);//setup the scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("After");
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource()==addContact){
            System.out.println("Button clicked!!");
        }
    }

}
