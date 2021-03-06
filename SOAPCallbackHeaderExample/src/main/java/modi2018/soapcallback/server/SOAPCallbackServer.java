package modi2018.soapcallback.server;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class SOAPCallbackServer {

    public static void main(String args[]) throws InterruptedException {
        SOAPCallbackImpl implementor = new SOAPCallbackImpl();
        String address = "http://localhost:8080/soap/nomeinterfacciaservizio/v1";
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(SOAPCallback.class);
        factory.setAddress(address);
        factory.setServiceBean(implementor);
        factory.create();
    }
}
