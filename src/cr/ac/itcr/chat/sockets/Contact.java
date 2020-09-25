package cr.ac.itcr.chat.sockets;

import cr.ac.itcr.chat.GUI.App;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Contact {
    private InetAddress ip;
    private int port;

    // TODO: 9/20/2020 add ip/port validation maybe? 
    public Contact(InetAddress ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public InetAddress getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public String getContactInfo() {
        return (ip.getHostAddress() + ":" + Integer.toString(port));
    }

    @Override
    public String toString() {
        return ("IP: " + ip.getHostAddress() + "\n" + "Port: " + Integer.toString(port));
    }

    public void sendMessage(ChatMessage msg) {
        try {
            Socket s = new Socket(this.getIp(), this.getPort());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            // TODO: 9/25/2020 Add Date and Time to msgs
            // TODO: 9/25/2020 Check if server is still available and if not display some error and delete from contacts
            dos.writeUTF(msg.getSender().getContactInfo() + "-" + msg.getPayload());
            dos.close();

            App.addMessage(this, msg);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Failed to connect to given ip/port combination");
            System.out.println(e.getMessage());
        }
    }

    public static boolean serverExists(Contact contact) {
        try {
            Socket s = new Socket(contact.getIp(), contact.getPort());
            s.close();
            return true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            System.out.println("Failed to connect to given ip/port combination");
            System.out.println(e.getMessage());
            return false;
        }
    }
}
