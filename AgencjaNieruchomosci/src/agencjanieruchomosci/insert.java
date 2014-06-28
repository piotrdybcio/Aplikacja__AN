/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agencjanieruchomosci;

import static agencjanieruchomosci.ekran.con;
import static agencjanieruchomosci.ekran.jTextArea1;
import static agencjanieruchomosci.ekran.message;
import static agencjanieruchomosci.window.con_w;
import static agencjanieruchomosci.window.*;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Piotr
 */
public class insert {

    window window;
    
    
    public static String insert_into;
            public static int id_oferty;
            public static int id_właściciela;
                   
            public static int id_mieszkania;
            public static int id_dom;
            public static int id_segment;
            public static int id_pracownik;
            public static int  nr_bud;
            public static int id_lokalizacji;
            public static String    stan;
            public static String typ_oferty;
            public static int     cena_obiektu;
            public static int   cena_miesieczna;
    
            
          //  int id_oferty, int id_właściciela, int id_mieszkania, int id_dom, int id_segment, int id_pracownik, int nr_bud, int id_lokalizacji, String    stan, String typ_oferty, int cena_obiektu, int   cena_miesieczna, 
            
            
            
            
    public static void insert_into_db(){
        
        PreparedStatement  psta = null;
        
        try{
            
        
        if(con==null){
            jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
            message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
        } else{
            psta = con.prepareStatement("  INSERT INTO KLIENT VALUES (15, 'Piotr' , 'Nowak' , TO_DATE('1956-01-15') , 645214965 , 12457836914 ,'ASED55' ,'05-952' ,'Warszawa','Polna', 11)"); //efektywniejsze od Statment
            psta.executeUpdate();
            
            
            
            
        }
        
        }catch(SQLException e){
        System.err.println("SQLException: " +e.getMessage());
        jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
        message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");    
        }
            

    }

    public static void insert_into_oferta(String id_oferty, String id_właściciela, String id_mieszkania, String id_dom, String id_segment, String id_pracownik, String nr_bud, String id_lokalizacji, String    stan, String typ_oferty, String cena_obiektu, String   cena_miesieczna){
       PreparedStatement  psta = null;
        
        try{
            
        
        if(con_w==null){
            jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
            message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
        } else{
            
            insert_into=" INSERT INTO OFERTA VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
            
            psta = con_w.prepareStatement(insert_into); //efektywniejsze od Statment
            psta.setString(1, id_mieszkania);
            psta.setString(2, id_dom);
            psta.setString(3, id_segment);
            psta.setString(4, id_właściciela);
            psta.setString(5, id_pracownik);
            psta.setString(6, nr_bud);
            psta.setString(7, id_lokalizacji);
            psta.setString(8, id_oferty);
            psta.setString(9, typ_oferty);
            psta.setString(10, stan);
            psta.setString(11, cena_obiektu);
            psta.setString(12, cena_miesieczna);

            
            psta.executeUpdate();
            
            
            
            
        }
        
        }catch(SQLException e){
        System.err.println("SQLException: " +e.getMessage());
        jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
        message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");    
        }
             
        
    }
    
    
    
    public static void insert_into_lokalizacja(String id_lokalizacji, String Miejscowość, String Ulica, String nr_domu, String Osiedle, String Odleg_od_centrum, String l_sklep, String l_przyst){
       PreparedStatement  psta = null;
        
        try{
            
        
        if(con_w==null){
            jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
            message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
        } else{
            
            insert_into=" INSERT INTO LOKALIZACJA (ID_LOKALIZACJI, MIEJSCOWOSC, ULICA, NR_DOMU, OSIEDLE, ODLEGLOSC_OD_CENTRUM, ILOSC_SKLEPOW_W_OKOLICY, LICZBA_PRZYSTANKOW_W_OKOLICY) VALUES (?,?,?,?,?,?,?,?) ";
            
            psta = con_w.prepareStatement(insert_into); //efektywniejsze od Statment
            psta.setString(1, id_lokalizacji);
            psta.setString(2, Miejscowość);
            psta.setString(3, Ulica);
            psta.setString(4, nr_domu);
            psta.setString(5, Osiedle);
            psta.setString(6, Odleg_od_centrum);
            psta.setString(7, l_sklep);
            psta.setString(8, l_przyst);


            
            psta.executeUpdate();
            message.append(Color.BLUE.darker(), "POMYŚLNIE DODANO LOKALIZACJĘ DO BAZY DANYCH");
            
            
            
        }
        
        }catch(SQLException e){
        System.err.println("SQLException: " +e.getMessage());
        jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
        message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");    
        }
             
        
    }
    
    
    
    public static void insert_into_mieszkanie(String id_mieszkania, String Metraż, String l_pom, String powierz, String piętro, String stan, String Data_Oddania){
       PreparedStatement  psta = null;
        
        try{
            
        
        if(con_w==null){
            jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
            message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
        } else{
            
            insert_into=" INSERT INTO MIESZKANIE (ID_MIESZKANIE, METRAZ, L_POMIESZCZEN, POWIERZCHNIA, PIETRO, STAN, DATA_ODDANIA) VALUES (?,?,?,?,?,?,?) ";
            
            psta = con_w.prepareStatement(insert_into); //efektywniejsze od Statment
            psta.setString(1, id_mieszkania);
            psta.setString(2, Metraż);
            psta.setString(3, l_pom);
            psta.setString(4, powierz);
            psta.setString(5, piętro);
            psta.setString(6, stan);
            psta.setString(7, Data_Oddania);
            


            
            psta.executeUpdate();
            message.append(Color.BLUE.darker(), "POMYŚLNIE DODANO MIESZKANIE DO BAZY DANYCH");
            
            
            
        }
        
        }catch(SQLException e){
        System.err.println("SQLException: " +e.getMessage());
        jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
        message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");    
        }
             
        
    }
    
    
    public static void insert_into_dom(String id_domu, String metraż, String kubatura, String powierzchnia, String l_pomieszczeń, String l_kondygnacji, String stan){
       PreparedStatement  psta = null;
        
        try{
            
        
        if(con_w==null){
            jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
            message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
        } else{
            
            insert_into=" INSERT INTO DOM (ID_DOM, METRAZ, KUBATURA, POWIERZCHNIA_DZIALKI, LICZBA_POMIESZCZEN, LICZBA_KONDYGNACJI, STAN) VALUES (?,?,?,?,?,?,?) ";
            
            psta = con_w.prepareStatement(insert_into); //efektywniejsze od Statment
            psta.setString(1, id_domu);
            psta.setString(2, metraż);
            psta.setString(3, kubatura);
            psta.setString(4, powierzchnia);
            psta.setString(5, l_pomieszczeń);
            psta.setString(6, l_kondygnacji);
            psta.setString(7, stan);
            //psta.setString(8, data_wybud);


            
            psta.executeUpdate();
            message.append(Color.BLUE.darker(), "POMYŚLNIE DODANO DOM DO BAZY DANYCH");
            
            
            
        }
        
        }catch(SQLException e){
        System.err.println("SQLException: " +e.getMessage());
        jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
        message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");    
        }
             
        
    }
    
    
    public static void insert_into_segment(String id_segmentu, String nr_bud_seg, String metraż, String Kubatura, String l_pokoi, String l_pomieszczeń, String stan1){
       PreparedStatement  psta = null;
        
        try{
            
        
        if(con_w==null){
            jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
            message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
        } else{
            
            insert_into=" INSERT INTO LOKALIZACJA (ID_SEGMENTU, NR_BUD_W_SEGMENCIE, METRAZ, KUBATURA, L_POKOI, L_POMIESZCZEN, AKTUALNY_STAN) VALUES (?,?,?,?,?,?,?) ";
            
            psta = con_w.prepareStatement(insert_into); //efektywniejsze od Statment
            psta.setString(1, id_segmentu);
            psta.setString(2, nr_bud_seg);
            psta.setString(3, metraż);
            psta.setString(4, Kubatura);
            psta.setString(5, l_pokoi);
            psta.setString(6, l_pomieszczeń);
            psta.setString(7, stan1);
            //psta.setString(8, l_przyst);


            
            psta.executeUpdate();
            message.append(Color.BLUE.darker(), "POMYŚLNIE DODANO SEGMENT DO BAZY DANYCH");
            
            
            
        }
        
        }catch(SQLException e){
        System.err.println("SQLException: " +e.getMessage());
        jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
        message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");    
        }
             
        
    }
    
    
    
    
    public static void insert_into_mieszkanie(){
        
        PreparedStatement  psta = null;
        String sql;
        
        
        try{
            
        
        if(con_w==null){
            jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
            message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
        } else{
            sql="INSERT INTO WIZYTA (ID_KLIENT, ID_OFERTA , ID_WIZYTA ) VALUES ( ? , ? , ?)";
            psta = con.prepareStatement(sql); //efektywniejsze od Statment
            psta.setString(1, "ID_Klienta.nextvall");
            psta.setString(2, "1");
            psta.setString(3, "2");
            psta.executeUpdate();
            
            
            
            
        }
        
        }catch(SQLException e){
        System.err.println("SQLException: " +e.getMessage());
        jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
        message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");    
        }
        
        
        
        
    }
    
    
    
}
