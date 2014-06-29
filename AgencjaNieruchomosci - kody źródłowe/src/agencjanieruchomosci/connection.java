/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agencjanieruchomosci;

import static agencjanieruchomosci.ekran.con;
import static agencjanieruchomosci.ekran.doPolaczenia;
import static agencjanieruchomosci.ekran.jTable2;
import static agencjanieruchomosci.ekran.jTextArea1;
import static agencjanieruchomosci.ekran.message;
import static agencjanieruchomosci.window.con_w;
import static agencjanieruchomosci.window.doPolaczenia_1;
import static agencjanieruchomosci.window.messagee;
import static agencjanieruchomosci.window.select;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Piotr
 */
public class connection {
    AgencjaNieruchomosci AN;
    ekran ekran;
    window window;
    
    public void start_connection(){
        
        final String hostname="hostname";
        final int port=1521;
        final String SID="SID";
        final String login="login";
        final String password="password";
        
        doPolaczenia=new Thread(){
        public void run(){
            try{    
                try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(ekran.class.getName()).log(Level.SEVERE, null, ex);
                                                         }
                if(con==null){
                con = DriverManager.getConnection("jdbc:oracle:thin:@" + hostname+":"+port+":"+SID ,login, password);

                jTextArea1.append("Połączono w watku\n");
                message.append(Color.GREEN.darker(), "Połączono w watku");

                }else{
                jTextArea1.append("Jesteś połączony z Bazą Danych! \n");
                message.append(Color.GREEN.brighter(), "Jesteś połączony z Bazą Danych!");
                 }
                    }catch(SQLException e){
                                        jTextArea1.setText("błąd "+e+"\n");
                                        message.append(Color.RED, "błąd "+e+"");
                                        }
                         
                        }
                        };//koniec wątku
       doPolaczenia.start();  
        
    }
    
     public void start_connection_1(){
        
        final String hostname="hostname";
        final int port=1521;
        final String SID="SID";
        final String login="login";
        final String password="password";
           
        doPolaczenia_1=new Thread(){
        public void run(){
            try{    
                try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(ekran.class.getName()).log(Level.SEVERE, null, ex);
                                                         }
                if(con_w==null){
                con_w = DriverManager.getConnection("jdbc:oracle:thin:@" + hostname+":"+port+":"+SID ,login, password);

               // jTextArea1.append("Połączono w watku\n");
                message.append(Color.GREEN.darker(), "Połączono w watku");
                 select.select_id_oferta();   
                }else{
              //  jTextArea1.append("Jesteś połączony z Bazą Danych! \n");
                message.append(Color.GREEN.brighter(), "Jesteś połączony z Bazą Danych!");
                 }
                    }catch(SQLException e){
                                      //  jTextArea1.setText("błąd "+e+"\n");
                                        message.append(Color.RED, "błąd "+e+"");
                                        }
                         
                        }
                        };//koniec wątku
       doPolaczenia_1.start();  
        
    }
    
    
    public void stop_connection(){
        if(con==null){
       jTextArea1.append("Jesteś rozłączony! \n");
       message.append(Color.RED.brighter(), "Jesteś rozłączony!");
       }else{
        try {
            // TODO add your handling code here:
            con.close(); // Zamykanie połączenia
            DefaultTableModel dat = (DefaultTableModel)jTable2.getModel();  // Czyszczenie tablicy
            dat.setRowCount(0);                                             // Czyszczenie tablicy
        
        }catch(SQLException e){
            jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
            message.append(Color.RED, "SQLException: "+e.getMessage()+ "");
        }
        jTextArea1.append("Rozłączono \n");
        message.append(Color.RED.brighter(), "Rozłączono");
        message.append(Color.ORANGE.darker(), "Wyczyszczono pobrane, i wyświetlone zapytanie");
        con=null;
         }
    }
    
    public void stop_connection_1(){
        if(con_w==null){
       jTextArea1.append("Jesteś rozłączony! \n");
       message.append(Color.RED.brighter(), "Jesteś rozłączony!");
       }else{
        try {
            // TODO add your handling code here:
            con_w.close(); // Zamykanie połączenia
            DefaultTableModel dat = (DefaultTableModel)jTable2.getModel();  // Czyszczenie tablicy
            dat.setRowCount(0);                                             // Czyszczenie tablicy
        
        }catch(SQLException e){
            jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
            message.append(Color.RED, "SQLException: "+e.getMessage()+ "");
        }
        jTextArea1.append("Rozłączono \n");
        message.append(Color.RED.brighter(), "Rozłączono");
        message.append(Color.ORANGE.darker(), "Wyczyszczono pobrane, i wyświetlone zapytanie");
        con_w=null;
         }
    }
    
    
}
