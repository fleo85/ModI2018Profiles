package modi2018.busywaiting.server;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class SOAPBusyWaitingServer {

    public static void main(String args[]) throws InterruptedException {
        SOAPBusyWaitingImpl implementor = new SOAPBusyWaitingImpl();
        String address = "http://localhost:8080/soap/nomeinterfacciaservizio/v1";
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(SOAPBusyWaiting.class);
        factory.setAddress(address);
        factory.setServiceBean(implementor);
        factory.create();
    }
}
