package SOAP;


import DTO.FeedbackBatchDTO;
import DTO.FeedbackDTO;
import DTO.Virksomhed;
import Firebase.EnumCollectionMapException;

import javax.jws.WebService;
import javax.jws.WebMethod;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@WebService
public interface ISOAP {


    @WebMethod Virksomhed HentVirksomhedMedId(int id) throws InterruptedException, ExecutionException, RemoteException;

    @WebMethod void tilføjVirksomhed(int virksomhedsID, String navn) throws InterruptedException, RemoteException;

    @WebMethod void setVote(int vote);

    @WebMethod void setCommenet(String commenet);

    @WebMethod void givFeedback(FeedbackBatchDTO batchDTO) throws RemoteException, EnumCollectionMapException;

    @WebMethod  void setCustomQuestions(List<String> questionsArray) throws EnumCollectionMapException, RemoteException;

    @WebMethod  void setFeedback(ArrayList<FeedbackDTO> feedback);






}

/*





 */