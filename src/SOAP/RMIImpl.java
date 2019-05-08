package SOAP;

import DTO.FeedbackBatchDTO;
import DTO.MeetingDTO;
import DTO.UserDTO;
import DTO.Virksomhed;
import Firebase.EnumCollectionMapException;
import Firebase.IFirebaseFacilitator;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class RMIImpl implements IFirebaseFacilitator {

    @Override
    public void init() throws IOException {

    }

    @Override
    public void setCustomQuestions(List<String> questionsArray) throws EnumCollectionMapException, RemoteException {

    }

    @Override
    public ArrayList<String> getQuestionsByMeetingID(String id) throws InterruptedException, ExecutionException, EnumCollectionMapException, RemoteException {
        return null;
    }

    @Override
    public void tilføjVirksomhed(int virksomhedsID, String navn) throws InterruptedException, RemoteException {

    }

    @Override
    public void getMeetingCounter() throws RemoteException {

    }

    @Override
    public Virksomhed HentVirksomhedMedId(int id) throws InterruptedException, ExecutionException, RemoteException {
        return null;
    }

    @Override
    public void opretmode(MeetingDTO meetingDTO) throws ParseException, RemoteException, EnumCollectionMapException {

    }

    @Override
    public Date addHoursToJavaUtilDate(Date date, int hours, int min) throws RemoteException {
        return null;
    }

    @Override
    public MeetingDTO getMeetingByID(String id) throws InterruptedException, ExecutionException, RemoteException, EnumCollectionMapException {
        return null;
    }

    @Override
    public ArrayList<MeetingDTO> getAllMeetings() throws InterruptedException, ExecutionException, RemoteException, EnumCollectionMapException {
        return null;
    }

    @Override
    public ArrayList<MeetingDTO> getAllMeetingsForUser(String userid, Boolean done) throws InterruptedException, ExecutionException, RemoteException, EnumCollectionMapException {
        return null;
    }

    @Override
    public void setStateOfMeeting(String id, int state) throws ExecutionException, InterruptedException, RemoteException, EnumCollectionMapException {

    }

    @Override
    public Date setStartTimeOfMeeting(String id) throws ExecutionException, InterruptedException, RemoteException {
        return null;
    }

    @Override
    public Date setEndTimeOfMeeting(String id) throws ExecutionException, InterruptedException, RemoteException {
        return null;
    }

    @Override
    public void givFeedback(FeedbackBatchDTO batchDTO) throws RemoteException, EnumCollectionMapException {

    }

    @Override
    public ArrayList<FeedbackBatchDTO> getFeedback(String id) throws ExecutionException, InterruptedException, EnumCollectionMapException, RemoteException {
        return null;
    }

    @Override
    public boolean checkOmBrugerenFindes(String email) throws RemoteException {
        return false;
    }

    @Override
    public void validate(String uida) throws RemoteException {

    }

    @Override
    public boolean validateToken(UserDTO userDTO) throws RemoteException {
        return false;
    }

    @Override
    public void getlist() throws RemoteException {

    }

    @Override
    public boolean tjekCredentials(UserDTO userDTO) throws EnumCollectionMapException, RemoteException {
        return false;
    }

    @Override
    public String getUID(String email) throws RemoteException {
        return null;
    }

    @Override
    public boolean CreateUser(UserDTO userDTO) throws EnumCollectionMapException, RemoteException {
        return false;
    }

    @Override
    public boolean UpdateUser(UserDTO userDTO) throws ExecutionException, InterruptedException, EnumCollectionMapException, RemoteException {
        return false;
    }

    @Override
    public UserDTO getUserByUsername(String username) throws InterruptedException, ExecutionException, EnumCollectionMapException, RemoteException {
        return null;
    }
}

/*



 */