package SOAP;

import DTO.FeedbackBatchDTO;
import DTO.Virksomhed;
import Firebase.EnumCollectionMapException;
import Firebase.IFirebaseFacilitator;

import javax.jws.WebService;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;

@WebService(endpointInterface = "SOAP.ISOAP")
public class SOAPImpl implements ISOAP {

     IFirebaseFacilitator rmitjeneste=(IFirebaseFacilitator) Naming.lookup("rmi://localhost:1617/Feedback-backend");

    public SOAPImpl() throws RemoteException, NotBoundException, MalformedURLException {
    }

    @Override
    public Virksomhed HentVirksomhedMedId(int id) throws InterruptedException, ExecutionException, RemoteException {


        return rmitjeneste.HentVirksomhedMedId(id);
    }

    @Override
    public void tilføjVirksomhed(int virksomhedsID, String navn) throws InterruptedException, RemoteException {


    }

    @Override
    public void setVote(int vote) {


    }

    @Override
    public void setCommenet(String commenet) {

    }

    @Override
    public void givFeedback(FeedbackBatchDTO batchDTO) throws RemoteException, EnumCollectionMapException {

    }


}

