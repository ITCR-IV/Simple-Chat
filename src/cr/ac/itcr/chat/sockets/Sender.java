package cr.ac.itcr.chat.sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Sender {
    static private int PORT=50000;

    public static void main(String[] args) {
            try {
                Socket s = new Socket("127.0.0.1", 50000);

                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
