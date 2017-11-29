
package cchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author sergio Cadete
 */
public class SMSforbindelse extends Thread implements Runnable
{
    
   //Socket s;//an endpoint of a connection across a computer network. 
  private DataInputStream in; // inngang data
   private DataOutputStream ut;//utgang data
  
    public SMSforbindelse(Socket s)
    {
        
        try {
        this.in=new DataInputStream(s.getInputStream());
        this.ut=new DataOutputStream(s.getOutputStream());       
       start();//
    } catch (Exception e) {}
    }
    @Override
    public void run()
    {
        
        String sms;
        while(true)
        {
            try {
                sms=in.readUTF();
                
               Forbindelse.getInstance().SendSms(sms);//Forbindelse
        
             System.out.println(sms);
     
            } catch (Exception e) {
            }
        }
    }
    public void SendSMS(String sms)
    {
        try {
            ut.writeUTF(sms);
        } catch (Exception e) {
        }
    }
}

