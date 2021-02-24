package hw6.client;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class ClientApp {
    public static void main(String[] args) {
        new MyClient().setVisible(true);
        final Logger LOG = LogManager.getLogger(String.valueOf(ClientApp.class));

        LOG.error("dfdfasd");
    }
}
