package SOAP;


import DTO.Virksomhed;

import javax.jws.WebService;
import javax.jws.WebMethod;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;

@WebService
public interface ISOAP {


    @WebMethod Virksomhed HentVirksomhedMedId(int id) throws InterruptedException, ExecutionException, RemoteException;

    @WebMethod void tilføjVirksomhed(int virksomhedsID, String navn) throws InterruptedException, RemoteException;

    @WebMethod void setVote(int vote);

    @WebMethod void setCommenet(String commenet);






}

/*





 */