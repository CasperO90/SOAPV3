package Firebase;


import DTO.FeedbackBatchDTO;
import DTO.MeetingDTO;
import DTO.UserDTO;
import DTO.Virksomhed;


import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@WebService(endpointInterface = "Firebase.IFirebaseFacilitator")
public interface IFirebaseFacilitator extends Remote {

//static FirebaseFacilitator single_instance = null;

 @WebMethod void init() throws IOException;

 // String CollectionMap(CollectionKeys keys) throws EnumCollectionMapException;

 @WebMethod public void setCustomQuestions(List<String> questionsArray) throws EnumCollectionMapException, RemoteException;

 @WebMethod ArrayList<String> getQuestionsByMeetingID(String id) throws InterruptedException, ExecutionException, EnumCollectionMapException, RemoteException;

 @WebMethod void tilføjVirksomhed(int virksomhedsID, String navn) throws InterruptedException, RemoteException;

 @WebMethod void getMeetingCounter()throws RemoteException;

 @WebMethod Virksomhed HentVirksomhedMedId(int id) throws InterruptedException, ExecutionException, RemoteException;

 @WebMethod void opretmode(MeetingDTO meetingDTO) throws ParseException, RemoteException, EnumCollectionMapException;


 @WebMethod Date addHoursToJavaUtilDate(Date date, int hours, int min)throws RemoteException;

 //  private boolean setDuration(String id, String time1, String time2) throws ParseException;

 //  private String calDuration(String time1, String time2) throws ParseException;

 @WebMethod MeetingDTO getMeetingByID(String id) throws InterruptedException, ExecutionException, RemoteException, EnumCollectionMapException;


 @WebMethod ArrayList<MeetingDTO> getAllMeetings() throws InterruptedException, ExecutionException, RemoteException, EnumCollectionMapException;

 @WebMethod ArrayList<MeetingDTO> getAllMeetingsForUser(String userid, Boolean done) throws InterruptedException, ExecutionException, RemoteException, EnumCollectionMapException;

 @WebMethod void setStateOfMeeting(String id, int state) throws ExecutionException, InterruptedException, RemoteException, EnumCollectionMapException;

 @WebMethod Date setStartTimeOfMeeting(String id) throws ExecutionException, InterruptedException, RemoteException;

 @WebMethod Date setEndTimeOfMeeting(String id) throws ExecutionException, InterruptedException, RemoteException;

//    private String getRandomID();

 //  protected String makeUUID();

 @WebMethod void givFeedback(FeedbackBatchDTO batchDTO) throws RemoteException, EnumCollectionMapException;

 @WebMethod ArrayList<FeedbackBatchDTO> getFeedback(String id) throws ExecutionException, InterruptedException, EnumCollectionMapException, RemoteException;



 // checker om brugeren står i systemet via Email
 @WebMethod boolean checkOmBrugerenFindes(String email) throws RemoteException;


 @WebMethod void validate(String uida) throws RemoteException;

 @WebMethod boolean validateToken(UserDTO userDTO) throws RemoteException;

 // henter en liste over alle brugere i systemet.
 @WebMethod void getlist() throws RemoteException;

 @WebMethod boolean tjekCredentials(UserDTO userDTO) throws EnumCollectionMapException, RemoteException;


 @WebMethod String getUID(String email) throws RemoteException;


 @WebMethod boolean CreateUser(UserDTO userDTO) throws EnumCollectionMapException, RemoteException;

 @WebMethod boolean UpdateUser(UserDTO userDTO) throws ExecutionException, InterruptedException, EnumCollectionMapException, RemoteException;


 @WebMethod UserDTO getUserByUsername(String username) throws InterruptedException, ExecutionException, EnumCollectionMapException, RemoteException;

}

