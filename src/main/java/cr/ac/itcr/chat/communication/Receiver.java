package cr.ac.itcr.chat.communication;

import cr.ac.itcr.chat.GUI.App;
import javafx.application.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;


/**
 * Class that controls the server socket and runs the thread to check for incoming sockets
 */
public class Receiver implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(Receiver.class);
    private ServerSocket ss;

    private boolean flag = true;

    /**
     * Closes the server socket and finishes the thread
     *
     * @throws IOException
     */
    public void terminate() throws IOException {
        this.flag = false;
        ss.close();
    }

    /**
     * Class constructor
     */
    public Receiver() {
        Thread t = new Thread(this); //thread so that it's permanently checking for sockets
        t.start();
    }


    @Override
    /**
     * Thread logic, waits for socket connection and decodes message and adds it to the messagesDB hashmap and adds teh contact if not added yet
     */
    public void run() {
        try (ServerSocket server = new ServerSocket(0)) {  //this try automatically closes the server socket when done
            this.ss = server;
            while (flag) {
                Socket s = ss.accept(); //waits for client socket to connect
                try {
                    DataInputStream dis = new DataInputStream(s.getInputStream()); // input stream
                    String incomingMsg = dis.readUTF(); // reads the incoming msg

                    String[] contactInfo = incomingMsg.split("-", 2)[0].split(":");
                    final Contact sender = new Contact(InetAddress.getByName(contactInfo[0]), Integer.parseInt(contactInfo[1]));
                    App.addContact(sender); //Adds the contact to the DB

                    String messagePayload = incomingMsg.split("-", 2)[1];
                    final ChatMessage objectMsg = new ChatMessage(sender, messagePayload);
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
            if (!flag) {
                System.out.println("Interrupted server socket accept");
            } else {
                log.error("Interrupted server socket accept", e);
                e.printStackTrace();
            }
        } catch (IOException e) {
            log.error("IOException error in server socket thread", e);
            e.printStackTrace();
        }
    }

    /**
     * @return Server socket's port
     */
    public int getPort() {
        return ss.getLocalPort();
    }
}
