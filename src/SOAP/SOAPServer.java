package SOAP;

import javax.xml.ws.Endpoint;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class SOAPServer {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {




        System.out.println("publicerer feedbacktjeenste");
        SOAPImpl feedback = new SOAPImpl();

        Endpoint.publish("http://[::]:9901/feedbacktjeneste", feedback);

        System.out.println("Feedbacktjeneste publiceret");
    }

    /*

class Kontoserver {
	public static void main(String[] args) {
		System.out.println("publicerer kontotjeneste");
		KontoImpl k = new KontoImpl();
		// Ipv6-addressen [::] svarer til Ipv4-adressen 0.0.0.0, der matcher alle maskinens netkort og IP-adresser
		Endpoint.publish("http://[::]:9901/kontotjeneste", k);
		System.out.println("Kontotjeneste publiceret.");
	}
}


     */
}
