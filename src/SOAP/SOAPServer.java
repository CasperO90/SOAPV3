package SOAP;

import Firebase.IFirebaseFacilitator;
import javax.xml.ws.Endpoint;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;

class SOAPServer {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        IFirebaseFacilitator rmitjeneste = (IFirebaseFacilitator) Naming.lookup("rmi://[::]:1617/Feedback-backend");
        try {
            System.out.println(rmitjeneste.HentVirksomhedMedId(0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("publicerer feedbacktjeenste");
        SOAPImpl feedback = new SOAPImpl();
        Endpoint.publish("http://[::]:9902/feedbacktjeneste", feedback);
        System.out.println("Feedbacktjeneste publiceret");
    }

}
