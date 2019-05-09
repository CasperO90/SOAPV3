package SOAP;

import DTO.FeedbackBatchDTO;
import DTO.FeedbackDTO;
import DTO.Virksomhed;
import Firebase.EnumCollectionMapException;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class SOAPKlient {

    public static void main(String[] args) throws MalformedURLException, InterruptedException, ExecutionException, RemoteException {
        URL url = new URL("http://[::]:9902/feedbacktjeneste?wsdl"); //http://localhost:9901/kontotjeneste?wsdl"
        QName qname = new QName("http://SOAP/", "SOAPImplService"); //http://kapitel_19_soap/
        Service service = Service.create(url, qname);
        ISOAP feedback = service.getPort(ISOAP.class);

        /*
        Virksomhed v = new Virksomhed();
        v = feedback.HentVirksomhedMedId(0);
        System.out.println(v.getNavn() + "Virksomheds ID" + v.getVirksomhedsID());

*/
        Scanner in = new Scanner(System.in);

     System.out.println("Velkommen til SpinOff! \n Skriv: \n 1 for at oprette virksomhedsID \n 2 for at oprette spørgsmål \n 3 for at give feedback");
    int next = in.nextInt();
        switch (next) {

        case 1:
            System.out.println("Indtast navn på virksomhed");
            String navn = in.nextLine();
            System.out.println("Giv virksomheden et ID");
            int virksomhedsid = in.nextInt();
            try {
                feedback.tilføjVirksomhed(virksomhedsid, navn);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            break;

        case 2:
            System.out.println("Indtast maksimum seks spørgsmål, du vil stille mødedeltageren");

            List<String> questions = new ArrayList();
            for (int i = 0; i < 6; i++) {
                System.out.println("Skriv spørgsmål " + i);
                String spg = in.nextLine();
                questions.add(spg);
            }
            try {
                feedback.setCustomQuestions(questions);
            } catch (EnumCollectionMapException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            break;


        case 3:
            System.out.println("Give feedback! \n ");
            FeedbackBatchDTO feedbackBatchDTO = new FeedbackBatchDTO();
            ArrayList<FeedbackDTO> feedbackDTOArrayList = new ArrayList<FeedbackDTO>();
            for (int i = 0; i < 6; i++) {
                System.out.println("Giv en bedømmelse mellem 0-3");
                int vote = in.nextInt();
                System.out.println("Skriv en kommentar");
                String comment = in.nextLine();
                FeedbackDTO feedbackDTO = new FeedbackDTO();
                feedbackDTO.setVote(vote);
                feedbackDTO.setComment(comment);
                feedbackDTOArrayList.add(feedbackDTO);
            }
            feedback.setFeedback(feedbackDTOArrayList);
            try {
                feedback.givFeedback(feedbackBatchDTO);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (EnumCollectionMapException e) {
                e.printStackTrace();
            }
    }
}




    }

