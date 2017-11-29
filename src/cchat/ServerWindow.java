
package cchat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

//jeg forandret brukerNavnServer is private nå er public
/**
 *
 * @author sergiofundanga
 */
public class ServerWindow extends javax.swing.JFrame implements Runnable,ActionListener// på denne måten fjernes main og du får run
{
    /* jeg hadde static
    men jeg fikk problem derfor
    måtte bytte til en referanse som skal peke.
    jeg hentet klasse Chat og opprette en klasse
    */
    private Chat chat;//referanse
    private boolean isServer = false;
    
   
    /**
     * Creates new form ServerWindow
     * sette inn i en argument
     * og påpeker chat som er objekt
     */
    public ServerWindow(Chat chat) {/* indre objekter*/
        initComponents();
        this.chat = chat;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSend = new javax.swing.JButton();
        startServer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        TXTsendServer = new javax.swing.JTextField();
        brukerNavn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        portNr = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        koble = new javax.swing.JButton();
        ipTXT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonSend.setText("Send");
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        startServer.setText(" Server");
        startServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startServerActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        TXTsendServer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXTsendServerKeyPressed(evt);
            }
        });

        jLabel1.setText(" Brukernavn");

        jLabel2.setText("PortNr.");

        koble.setText("Klient");
        koble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kobleActionPerformed(evt);
            }
        });

        jLabel3.setText("IP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(brukerNavn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ipTXT))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(portNr, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(koble, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(startServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TXTsendServer, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(brukerNavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(portNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(startServer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(koble, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTsendServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startServerActionPerformed
        try {
            chat.StartServer(Integer.parseInt(this.portNr.getText()));//denne skal høre på porten// du må ikke klasse
            
            startServer.setText(this.jTextArea1.getText()+"\n"+this.brukerNavn.getText()+" Sier: "+this.TXTsendServer.getText());
            isServer = true;
        } catch (Exception ex) { }
       
    }//GEN-LAST:event_startServerActionPerformed
//for å kunne bruke enter. Det blir lettere hvis du oppretter en metode
    public void Funksjon()
    {
        if (isServer)
      {
        chat.server.SendMelding(this.brukerNavn.getText()+" sier:  "+this.TXTsendServer.getText());//det er viktig at server public static
 
        
        //for å vise hva du skriver- derfor må bli public jTextArea1
        this.jTextArea1.setText(this.jTextArea1.getText()+"\n"+this.brukerNavn.getText()+" Sier: "+this.TXTsendServer.getText());
        TXTsendServer.setText("");//å rense viser ingenting
      } else {   
         chat.klient.SendMSM(this.brukerNavn.getText()+" Sier:  "+this.TXTsendServer.getText());
       
      TXTsendServer.setText("");//å rense viser ingenting
      }
        
    }
    
    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
      Funksjon();
    }//GEN-LAST:event_jButtonSendActionPerformed

    private void kobleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kobleActionPerformed
         isServer = false;
         chat.StartKlient(this.ipTXT.getText(),Integer.parseInt(this.portNr.getText()));//får hente IP og portNr
                                    //Integer.parseInt(this.portNrKlient.getText()) brukes denne metoden for converter String to int
    }//GEN-LAST:event_kobleActionPerformed

    private void TXTsendServerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTsendServerKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        Funksjon();
    }//GEN-LAST:event_TXTsendServerKeyPressed

    public void run(){}
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TXTsendServer;
    public javax.swing.JTextField brukerNavn;
    private javax.swing.JTextField ipTXT;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea1;
    public javax.swing.JButton koble;
    private javax.swing.JTextField portNr;
    public javax.swing.JButton startServer;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
