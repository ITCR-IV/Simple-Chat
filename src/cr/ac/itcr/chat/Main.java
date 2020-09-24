package cr.ac.itcr.chat;

import cr.ac.itcr.chat.GUI.App;
import cr.ac.itcr.chat.sockets.Contact;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main{

    public static void main(String[] args) {
//        connector c = new connector();
//        c.initiate();
        Map<Contact, List<String>> messageDB = new HashMap<>();
        List<String> messages = new ArrayList<String>();
        Application.launch(App.class,args); //Start main application window
    }

}

