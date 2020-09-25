package cr.ac.itcr.chat.sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Receiver implements Runnable {

    private ServerSocket ss;

    public Receiver() {
        try (ServerSocket server = new ServerSocket(0)) {
            this.ss = server;
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket s = null;
                try {
                    s = ss.accept();
                } catch (SocketException e) {
                    continue;
                }
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String incomingMsg = dis.readUTF();
                s.close();
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
