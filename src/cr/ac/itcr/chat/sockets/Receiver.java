package cr.ac.itcr.chat.sockets;

import cr.ac.itcr.chat.GUI.App;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver implements Runnable {

    private ServerSocket ss;

    public Receiver() {
        Thread t = new Thread(this); //thread so that it's permanently checking for sockets
        t.start();
    }

    @Override
    public void run() {
        try (ServerSocket server = new ServerSocket(0)) {  //this try automatically closes the server socket when done
            this.ss = server;
            while (true) {
                Socket s = ss.accept(); //waits for client socket to connect
                try {
                    DataInputStream dis = new DataInputStream(s.getInputStream()); // input stream
                    String incomingMsg = dis.readUTF(); // reads the incoming msg
                    System.out.println(incomingMsg);
                    Contact newContact = new Contact(s.getInetAddress(), s.getPort());
                    App.add_contact(newContact); //Adds the contact to the DB
                } catch (IOException e) {
                    System.out.println("No msg was received");
                }
                s.close(); //closes the socket
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InetAddress getIP() {
        return ss.getInetAddress();
    }

    public int getPort() {
        return ss.getLocalPort();
    }
}
