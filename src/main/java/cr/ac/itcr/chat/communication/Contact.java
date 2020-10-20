package cr.ac.itcr.chat.communication;

import cr.ac.itcr.chat.GUI.App;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Class stores the ip and port of the contact and has related methods
 */
public class Contact {
    private InetAddress ip;
    private int port;

    // TODO: 9/20/2020 add ip/port validation maybe?

    /**
     * Class constructor
     *
     * @param ip
     * @param port
     */
    public Contact(InetAddress ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    /**
     * @return ip
     */
    public InetAddress getIp() {
        return ip;
    }

    /**
     * @return port
     */
    public int getPort() {
        return port;
    }

    /**
     * @return String formatted as "ip:port"
     */
    public String getContactInfo() {
        return (ip.getHostAddress() + ":" + port);
    }

    /**
     * Overrides the toString method of this class for listview purposes
     *
     * @return "IP: @ip\nPort: @port"
     */
    @Override
    public String toString() {
        return ("IP: " + ip.getHostAddress() + "\n" + "Port: " + port);
    }

    /**
     * opens up a socket and sends a message to the contact object's address
     *
     * @param msg
     */
    public void sendMessage(ChatMessage msg) {
        try {
            Socket s = new Socket(this.getIp(), this.getPort()); //open socket
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); //open data stream
            // TODO: 9/25/2020 Check if server is still available and if not display some error and delete from contacts? maybe?
            if (ip.getHostAddress().equals(InetAddress.getByName("localhost").getHostAddress()) || ip.getHostAddress().equals(App.getUser().getIp().getHostAddress())) { //in case sending msgs in same machine have the contact info be sent with ip localhost
                dos.writeUTF(InetAddress.getByName("localhost").getHostAddress() + ":" + msg.getSender().getPort() + "-" + msg.getPayload()); //Send the msg
            } else {
                dos.writeUTF(msg.getSender().getContactInfo() + "-" + msg.getPayload()); //Send the msg
            }

            dos.close(); //close data stream + socket

            App.addMessage(this, msg); //Add msg to DB

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Failed to connect to given ip/port combination");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Opens up a socket to check if the socket server exists but sends no message
     *
     * @param contact
     * @return boolean
     */
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
