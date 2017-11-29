/*
    Klient


 */
package cchat;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author sergiofundanga//
 */
public class KoblingKlient extends Thread
{
  private Socket s;//an endpoint of a connection across a computer network. 
  private ServerSocket ss;
  private InputStreamReader innSocket;  // inngang data
  private DataOutputStream ut;//utgang data
  private BufferedReader inn; // for å kunne lese melding,msm

 //public ServerWindow brukerNavn;
    
  
  // hvis jeg er en klient
    //vi bruker den samme koden fra kobling
    public KoblingKlient(String ip,int portNr, ServerWindow serverW)
    {
      // String user=brukerNavn.brukerNavn.getText().toString();
        try {
            //Creates a stream socket and connects it to the specified port number on the named host.
            // if null In other words, it is equivalent to specifying an address of the loopback interface
           this.s=new Socket(ip,portNr);// this.s=new Socket(ip,this.portNr);
            
            //denne skal sørge for å koble til remote host når klient koble seg til port
             //inngang til data for å lese sms
            this.innSocket=new InputStreamReader(s.getInputStream());
            this.inn=new BufferedReader(innSocket);
            
            //utgang til data for å sende sms
           this.ut=new DataOutputStream(s.getOutputStream());
           
           this.ut.writeUTF(serverW.brukerNavn.getText()+"-->"+" er koblet til Serveren \n");// ta vekk serv....
        } 
        catch (Exception ex) {}
    }

   
  @Override
    public void run()
    {
        
        while (true) 
        {      
            String tekst;
             try {
               //tekst for lagre alle meldinger som jeg får fra Server
                tekst= inn.readLine();
                //sett inn tekst etterpå hente tekst + "tekst" fra før av
                ServerWindow.jTextArea1.setText(ServerWindow.jTextArea1.getText()+"\n"+tekst);
        }
        catch (Exception e) {}    
        }
    }
    public void SendMSM(String msm)
    {
        System.out.println(" Meldingen har blitt sendt");
        try
        {
            this.ut=new DataOutputStream(s.getOutputStream());
            this.ut.writeUTF(msm+"\n");
        } 
        catch (Exception e)
        {
             System.out.println(" Meldingen har ikke blitt sendt");
        }
    }
   
    //denne metoden skal lese alt som blir sendt til meg
  
    
    public void KobleAv()
    {
        try
        {   // koble av forbindelse
            s.close();
        } 
        catch (Exception ex) {}
        try
        {   
            // koble av server
            ss.close();
        } 
        catch (Exception ex) {}
    } 
}
