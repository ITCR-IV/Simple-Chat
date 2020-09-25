package cr.ac.itcr.chat.sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Sender {
    private Socket s;
    private DataOutputStream dos;

    public Sender(Contact contact) {
        try {
            s = new Socket(contact.getIp(), contact.getPort());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to given ip/port combination");
        }
    }

    public Socket getSocket() {
        return s;
    }

    public DataOutputStream getDataOutputStream() {
        return dos;
    }
}
