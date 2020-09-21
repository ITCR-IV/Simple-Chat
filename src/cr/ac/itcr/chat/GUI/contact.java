package cr.ac.itcr.chat.GUI;

public class contact {
    private String ip;
    private String port;

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
