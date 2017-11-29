

// server
package cchat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.WindowConstants;


/**
 *
 * @author sergiofundanga
 */
public class Kobling extends Thread implements Runnable
        //Thread
{
  private Socket s;//an endpoint of a connection across a computer network. 
  private ServerSocket ss;
   private DataOutputStream ut;//utgang data
   private BufferedReader inn; // for å kunne lese melding,msm
 private InputStreamReader innSocket;  // inngang data//tirar depois
    public Kobling(int portNr) throws IOException
            
    {
        try 
        {
             System.out.println("starting server....");
            //for å høre på portNr
            ss=new ServerSocket(portNr);
            System.out.println("Venting for forbindelse....");
            //denne skal sørge for å koble til remote host når klient koble seg til port
            
            while(true)
            {
              System.out.println("før accept....");  
              //reserveløsning
              
            this.s=ss.accept();
           System.out.println("in while true....");
             Forbindelse.getInstance().NyKoblet(new SMSforbindelse(s));//Forbindelse
             System.out.println("rett etter Forb....");
             ////////////////////////////////////
             //inngang til data for å lese sms
            this.innSocket=new InputStreamReader(s.getInputStream());
            this.inn=new BufferedReader(innSocket);
            
            //utgang til data for å sende sms
            this.ut=new DataOutputStream(s.getOutputStream());
            }
            
        }
         
            
        catch (Exception e) 
        {
            System.out.println(" Feil ");
        }
        
    }

   
    

   public void SendMelding(String sms)//Send meldinger til alle klienter
   {
       try
       {
            this.ut=new DataOutputStream(s.getOutputStream());//
            
        this.ut.writeUTF(sms+"\n");// 
          ServerWindow.jTextArea1.setText(ServerWindow.jTextArea1.getText()+"\n"+sms);//
         
       } catch (Exception e) {
       }
   }
    public void run()
    {

     String tekst="mÅ";  
     
     while (true)
            { 
                try{
              //denne metoden skal lese alt som blir sendt til meg 
             tekst=this.inn.readLine();
             System.out.println(tekst);
                                
            ServerWindow.jTextArea1.setText(ServerWindow.jTextArea1.getText()+"\n"+tekst);//
            }
        catch (Exception e) {}    
        }
    }
     
  
    
    public void KobleAv()
    {
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);/// ta vekk det virker
        try
        {   // koble av forbindelse Socket på port
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
