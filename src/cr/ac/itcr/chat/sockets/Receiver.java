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
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try (ServerSocket server = new ServerSocket(0)) {
            this.ss = server;
            while (true) {
                Socket s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String incomingMsg = dis.readUTF();
                s.close();

                Contact newContact = new Contact(s.getInetAddress(), s.getPort());
                App.add_contact(newContact);
                System.out.println(App.sendersDB);
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
