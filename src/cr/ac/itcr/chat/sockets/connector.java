package cr.ac.itcr.chat.sockets;

import java.net.*;
import java.io.*;


public class connector {
    ServerSocket server;
    Socket socket;
    int port = 9000;
    DataOutputStream out;
    BufferedReader in;
    public void initiate() {
        try{
            server = new ServerSocket(port);
            socket = new Socket();
            socket = server.accept();

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = in.readLine();
            System.out.println(msg);
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Goodbye World");
            socket.close();
        }catch (Exception ignored){};
    }
}
