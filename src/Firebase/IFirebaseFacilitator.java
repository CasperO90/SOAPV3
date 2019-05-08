package Firebase;


import DTO.FeedbackBatchDTO;
import DTO.MeetingDTO;
import DTO.UserDTO;
import DTO.Virksomhed;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IFirebaseFacilitator extends Remote {

//static FirebaseFacilitator single_instance = null;

 void init() throws IOException;

 // String CollectionMap(CollectionKeys keys) throws EnumCollectionMapException;

 public void setCustomQuestions(List<String> questionsArray) throws EnumCollectionMapException, RemoteException;

 ArrayList<String> getQuestionsByMeetingID(String id) throws InterruptedException, ExecutionException, EnumCollectionMapException, RemoteException;

 void tilføjVirksomhed(int virksomhedsID, String navn) throws InterruptedException, RemoteException;

 void getMeetingCounter()throws RemoteException;

 Virksomhed HentVirksomhedMedId(int id) throws InterruptedException, ExecutionException, RemoteException;

 void opretmode(MeetingDTO meetingDTO) throws ParseException, RemoteException, EnumCollectionMapException;


 Date addHoursToJavaUtilDate(Date date, int hours, int min)throws RemoteException;

 //  private boolean setDuration(String id, String time1, String time2) throws ParseException;

 //  private String calDuration(String time1, String time2) throws ParseException;

 MeetingDTO getMeetingByID(String id) throws InterruptedException, ExecutionException, RemoteException, EnumCollectionMapException;


 ArrayList<MeetingDTO> getAllMeetings() throws InterruptedException, ExecutionException, RemoteException, EnumCollectionMapException;

 ArrayList<MeetingDTO> getAllMeetingsForUser(String userid, Boolean done) throws InterruptedException, ExecutionException, RemoteException, EnumCollectionMapException;

 void setStateOfMeeting(String id, int state) throws ExecutionException, InterruptedException, RemoteException, EnumCollectionMapException;

 Date setStartTimeOfMeeting(String id) throws ExecutionException, InterruptedException, RemoteException;

 Date setEndTimeOfMeeting(String id) throws ExecutionException, InterruptedException, RemoteException;

//    private String getRandomID();

 //  protected String makeUUID();

 void givFeedback(FeedbackBatchDTO batchDTO) throws RemoteException, EnumCollectionMapException;

 ArrayList<FeedbackBatchDTO> getFeedback(String id) throws ExecutionException, InterruptedException, EnumCollectionMapException, RemoteException;



 // checker om brugeren står i systemet via Email
 boolean checkOmBrugerenFindes(String email) throws RemoteException;


 void validate(String uida) throws RemoteException;

 boolean validateToken(UserDTO userDTO) throws RemoteException;

 // henter en liste over alle brugere i systemet.
 void getlist() throws RemoteException;

 boolean tjekCredentials(UserDTO userDTO) throws EnumCollectionMapException, RemoteException;


 String getUID(String email) throws RemoteException;


 boolean CreateUser(UserDTO userDTO) throws EnumCollectionMapException, RemoteException;

 boolean UpdateUser(UserDTO userDTO) throws ExecutionException, InterruptedException, EnumCollectionMapException, RemoteException;


 UserDTO getUserByUsername(String username) throws InterruptedException, ExecutionException, EnumCollectionMapException, RemoteException;

}

