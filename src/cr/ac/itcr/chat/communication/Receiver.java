package cr.ac.itcr.chat.communication;

import cr.ac.itcr.chat.GUI.App;
import javafx.application.Platform;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Receiver implements Runnable {

    private ServerSocket ss;

    private boolean flag = true;

    public void terminate() throws IOException {
        this.flag = false;
        ss.close();
    }

    public Receiver() {
        Thread t = new Thread(this); //thread so that it's permanently checking for sockets
        t.start();
    }

    @Override
    public void run() {
        try (ServerSocket server = new ServerSocket(0)) {  //this try automatically closes the server socket when done
            this.ss = server;
            while (flag) {
                Socket s = ss.accept(); //waits for client socket to connect
                try {
                    DataInputStream dis = new DataInputStream(s.getInputStream()); // input stream
                    String incomingMsg = dis.readUTF(); // reads the incoming msg

                    String[] contactInfo = incomingMsg.split("-", 2)[0].split(":");
                    Contact sender = new Contact(InetAddress.getByName(contactInfo[0]), Integer.parseInt(contactInfo[1]));
                    App.addContact(sender); //Adds the contact to the DB

                    String messagePayload = incomingMsg.split("-", 2)[1];
                    ChatMessage objectMsg = new ChatMessage(sender, messagePayload);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            App.addMessage(sender, objectMsg);
                        }
                    });
                } catch (IOException e) {
                    System.out.println("No msg was received");
                }
                s.close(); //closes the socket
            }
        } catch (SocketException e) {
            System.out.println("Interrupted server socket accept ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getPort() {
        return ss.getLocalPort();
    }
}
