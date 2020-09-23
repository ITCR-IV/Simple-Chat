package cr.ac.itcr.chat.GUI;

public class contact {
    private String ip;
    private String port;

    // TODO: 9/20/2020 add ip/port validation maybe? 
    public contact(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }
}
