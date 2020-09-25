package cr.ac.itcr.chat.sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver implements Runnable {

    private ServerSocket server;

    public Receiver() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        try (ServerSocket ss = new ServerSocket(0)) {
            this.server = ss;
            while (true) {
                Socket s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String incomingMsg = dis.readUTF();
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InetAddress getIP() {
        return server.getInetAddress();
    }

    public int getPort() {
        return server.getLocalPort();
    }
}
