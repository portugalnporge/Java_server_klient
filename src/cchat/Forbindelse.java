
package cchat;


import java.util.ArrayList;

/**
 *
 * @author sergiofundanga
 */
public class Forbindelse extends Thread implements Runnable       
{
    
    public static Forbindelse fServer=new Forbindelse();//static
    private final ArrayList<SMSforbindelse> forbindelse=new ArrayList();
    
    public static Forbindelse getInstance()//static
    {
        
         return fServer;
    }  
   
    
  public void SendSms(String sms)
  {
      for(SMSforbindelse smsForbindelse:forbindelse)
      {
          smsForbindelse.SendSMS(sms);
      }
  }
    public void NyKoblet(SMSforbindelse ny)
    {
        forbindelse.add(ny);
    }
}
