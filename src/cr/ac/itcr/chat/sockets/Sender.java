package cr.ac.itcr.chat.sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Sender {
    private Socket s;
    private DataOutputStream dos;

    public Sender(int PORT) {
        try {
            s = new Socket("127.0.0.1", PORT);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return s;
    }

    public DataOutputStream getDataOutputStream() {
        return dos;
    }
}
