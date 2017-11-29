
package cchat;

import java.io.IOException;



/**
 *
 * @author sergiofundanga
 */
public class Chat 
{

    private static void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   private String ip;
   private int portNr;
   public Kobling server;
   public KoblingKlient klient;
   ServerWindow serverW;
   
    
    public Chat() throws IOException
    {
       Start(); 
       
       //StartServer(portNr);
       //StartKlient(ip,portNr);
      
       
    }
    //metode for å starte server
    public void StartServer(int portNr) throws IOException
           
    {
       server=new Kobling(portNr);
       //Thread th=new Thread(server); depois poe
       server.start();
       
    }
    //metode for å starte klient
       public  void StartKlient(String ip,int portNr)//String ip,int portNr)
    {
        klient=new KoblingKlient(ip,portNr,serverW);
        Thread th=new Thread(klient);
        klient.start();
        
    }   
    
    public void Start()
    {
        serverW=new ServerWindow(this);
      //  Thread th=new Thread(serverW);depois poe 2
         
        serverW.setVisible(true); //viser på skjerm  
         
    }
    
    public static void main(String[] args) throws IOException 
    {
        
       new Chat();
    }
    
}
