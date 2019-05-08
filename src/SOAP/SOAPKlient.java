package SOAP;

import DTO.FeedbackBatchDTO;
import DTO.FeedbackDTO;
import Firebase.IFirebaseFacilitator;
import Firebase.EnumCollectionMapException;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class SOAPKlient {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("//http://[::]:9902/feedbacktjeneste?wsdl"); //http://localhost:9901/kontotjeneste?wsdl"
        QName qname = new QName("//http://SOAP/", "SOAPImplService"); //http://kapitel_19_soap/
        Service service = Service.create(url, qname);
        //ISOAP feedback = service.getPort(ISOAP.class);


        //Yoss klient

        IFirebaseFacilitator fire = null;
        try {
            fire = (IFirebaseFacilitator) Naming.lookup(String.valueOf(url)); // Naming.lookup(url)
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(fire.HentVirksomhedMedId(0).getNavn()); //tilføjet try catch
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


        Scanner in = new Scanner(System.in);

        /*
        //login
        String username;
        System.out.println("Indtast brugernavn: ");
        String brugernavn = in.next();
        fire.init();
        fire.getUserByUsername(brugernavn);
        //skriv noget med password her
        */

        System.out.println("Velkommen til SpinOff! \n Skriv: \n 1 for at oprette virksomhedsID \n 2 for at give feedback");
        int next = in.nextInt();
        switch (next) {

            case 1:
                System.out.println("Indtast navn på virksomhed");
                String navn = in.nextLine();
                System.out.println("Giv virksomheden et ID");
                int virksomhedsid = in.nextInt();
                try {
                    fire.tilføjVirksomhed(virksomhedsid, navn);
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
                    fire.setCustomQuestions(questions);
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
                feedbackBatchDTO.setFeedback(feedbackDTOArrayList);
                try {
                    fire.givFeedback(feedbackBatchDTO);
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (EnumCollectionMapException e) {
                    e.printStackTrace();
                }
        }
    }




    }


/*

public class Kontoklient {
	public static void main(String[] args) throws MalformedURLException {
//		URL url = new URL("http://ubuntu4.saluton.dk:9901/kontotjeneste?wsdl");
		URL url = new URL("http://localhost:9901/kontotjeneste?wsdl");
		QName qname = new QName("http://kapitel_19_soap/", "KontoImplService");
		Service service = Service.create(url, qname);
		KontoI k = service.getPort(KontoI.class);

 */
