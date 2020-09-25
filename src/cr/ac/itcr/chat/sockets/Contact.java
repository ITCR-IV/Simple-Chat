package cr.ac.itcr.chat.sockets;

import java.net.InetAddress;

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

    @Override
    public String toString() {
        return ("IP: " + ip.getHostAddress() + "\n" + "Port: " + Integer.toString(port));
    }
}
