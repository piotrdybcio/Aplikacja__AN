/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agencjanieruchomosci;

import static agencjanieruchomosci.ekran.con;
import static agencjanieruchomosci.ekran.data;
import static agencjanieruchomosci.ekran.jTable2;
import static agencjanieruchomosci.ekran.jTextArea1;
import static agencjanieruchomosci.ekran.message;
import static agencjanieruchomosci.show.jTable1;
import static agencjanieruchomosci.show.jTable2;
import static agencjanieruchomosci.show.jTable3;
import static agencjanieruchomosci.show.jTable4;
import static agencjanieruchomosci.show.jTable5;
import static agencjanieruchomosci.window.con_w;
import static agencjanieruchomosci.window.data_w;
import static agencjanieruchomosci.window.jTable1;
import static agencjanieruchomosci.window.messagee;
import java.awt.Color;
import java.awt.Label;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Piotr
 */
public class select {
    
    public static void select_from_db(String query){
         // Connection con = null;
        Statement sta = null;
        Statement sta1 = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        PreparedStatement  psta1 = null; //efektywniejsze od Statment
        ResultSet res = null;
        ResultSet res2 = null;
    if(con==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        
// Load Microsoft JDBC Driver 1.0
     // Class.forName("oracle.jdbc.driver.OracleDriver");

// Obtaining a connection to SQL Server
      //if(con==null){
      //con = DriverManager.getConnection("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf","pdybcio","pdybcio");
      //jTextArea1.append("Połączono automatycznie \n");
      //}
// Getting result meta data
            
        //sta = con.createStatement(); 
        psta = con.prepareStatement("SELECT COUNT(*) FROM KLIENT "); //efektywniejsze od Statment
        long startTime = System.nanoTime();
        res = psta.executeQuery();
        long resultTime = (System.nanoTime() - startTime)/1000000;
        System.out.println(startTime);
        jTextArea1.append("Wysłano zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano zapytanie " + resultTime+"ms ");
        //sta1 = con.createStatement(); 
        psta1 = con.prepareStatement(query); //efektywniejsze od Statment
        
        res2 = psta1.executeQuery();
        jTextArea1.append("Wysłano następne zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano następne zapytanie");
 
        ResultSetMetaData rmd = res2.getMetaData();
        rmd.getColumnCount();
        res.next();

       int f =res.getInt(1); // Liczba wierszy
       int f2=rmd.getColumnCount(); // Liczba kolumn

       String[] columnNamess = new String[f2]; // Tabela String do nazwy kolumny
        data = new Object[f][f2]; // Tworzenie Objektu f x f2 Tabeli
        
       
        /**
        * Nadawanie nazw kolumn tabeli
        */
        for(int w=1; w<=f2; w++){
            columnNamess[w-1]=rmd.getColumnName(w);
        }   
        
        /**
        * Wypełnianie tabeli danymi pobranymi z bazy danych
        */
        int l=0;
        while (res2.next()){
        for (int k = 1; k <= f2; k++)
              {
                  data[l][k-1]=res2.getString(k); 
              }
            l++; // Numer wiersza, krotki

        ekran.jTable2.setModel(new DefaultTableModel(data, columnNamess)); // Wstawianie danych i nazwy kolumn do tabeli 
      
    }
      ekran.jTable2.setVisible(true);  // Włączenie wyświetlania kolumn
      jTextArea1.append("Pomyślnie pobrano dane \n");
      message.append(Color.YELLOW.darker(), "Pomyślnie pobrano dane");
      jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
      
      res.close(); // Zamykanie zapytania
      res2.close(); // Zamykanie zapytania
      //jTextArea1.setForeground(Color.red);
      //jTextArea1.setForeground(Color.BLACK);
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    
        System.out.println(" ");
        
        
    }
    
    /**
     * Wyświetlanie Właścicieli
     * @param query 
     */
    public static void select_właściciel(String query){
        
        Statement sta = null;
        Statement sta1 = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        PreparedStatement  psta1 = null; //efektywniejsze od Statment
        ResultSet res = null;
        ResultSet res2 = null;
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        
// Load Microsoft JDBC Driver 1.0
     // Class.forName("oracle.jdbc.driver.OracleDriver");

// Obtaining a connection to SQL Server
      //if(con==null){
      //con = DriverManager.getConnection("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf","pdybcio","pdybcio");
      //jTextArea1.append("Połączono automatycznie \n");
      //}
// Getting result meta data
            
        //sta = con.createStatement(); 
        psta = con_w.prepareStatement("SELECT COUNT(*) FROM Właściciel "); //efektywniejsze od Statment
        long startTime = System.nanoTime();
        res = psta.executeQuery();
        long resultTime = (System.nanoTime() - startTime)/1000000;
        System.out.println(startTime);
        jTextArea1.append("Wysłano zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano zapytanie " + resultTime+"ms ");
        //sta1 = con.createStatement(); 
        psta1 = con_w.prepareStatement(query); //efektywniejsze od Statment
        
        res2 = psta1.executeQuery();
        jTextArea1.append("Wysłano następne zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano następne zapytanie");
 
        ResultSetMetaData rmd = res2.getMetaData();
        rmd.getColumnCount();
        res.next();

       int f =res.getInt(1); // Liczba wierszy
       int f2=rmd.getColumnCount(); // Liczba kolumn

       String[] columnNamess = new String[f2]; // Tabela String do nazwy kolumny
        data_w = new Object[f][f2]; // Tworzenie Objektu f x f2 Tabeli
        
       
        /**
        * Nadawanie nazw kolumn tabeli
        */
        for(int w=1; w<=f2; w++){
            columnNamess[w-1]=rmd.getColumnName(w);
        }   
        
        /**
        * Wypełnianie tabeli danymi pobranymi z bazy danych
        */
        int l=0;
        while (res2.next()){
        for (int k = 1; k <= f2; k++)
              {
                  data_w[l][k-1]=res2.getString(k); 
              }
            l++; // Numer wiersza, krotki

        show.jTable1.setModel(new DefaultTableModel(data_w, columnNamess)); // Wstawianie danych i nazwy kolumn do tabeli 
      
    }
      show.jTable1.setVisible(true);  // Włączenie wyświetlania kolumn
      jTextArea1.append("Pomyślnie pobrano dane \n");
      message.append(Color.YELLOW.darker(), "Pomyślnie pobrano dane");
      jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
      
      res.close(); // Zamykanie zapytania
      res2.close(); // Zamykanie zapytania
      //jTextArea1.setForeground(Color.red);
      //jTextArea1.setForeground(Color.BLACK);
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    
        System.out.println(" ");
        
        
    }
    
    public static void select_(String query){
        
        Statement sta = null;
        Statement sta1 = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        PreparedStatement  psta1 = null; //efektywniejsze od Statment
        ResultSet res = null;
        ResultSet res2 = null;
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        
// Load Microsoft JDBC Driver 1.0
     // Class.forName("oracle.jdbc.driver.OracleDriver");

// Obtaining a connection to SQL Server
      //if(con==null){
      //con = DriverManager.getConnection("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf","pdybcio","pdybcio");
      //jTextArea1.append("Połączono automatycznie \n");
      //}
// Getting result meta data
            
        //sta = con.createStatement(); 
        psta = con_w.prepareStatement("SELECT COUNT(*) FROM Właściciel "); //efektywniejsze od Statment
        long startTime = System.nanoTime();
        res = psta.executeQuery();
        long resultTime = (System.nanoTime() - startTime)/1000000;
        System.out.println(startTime);
        jTextArea1.append("Wysłano zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano zapytanie " + resultTime+"ms ");
        //sta1 = con.createStatement(); 
        psta1 = con_w.prepareStatement(query); //efektywniejsze od Statment
        
        res2 = psta1.executeQuery();
        jTextArea1.append("Wysłano następne zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano następne zapytanie");
 
        ResultSetMetaData rmd = res2.getMetaData();
        rmd.getColumnCount();
        res.next();

       int f =res.getInt(1); // Liczba wierszy
       int f2=rmd.getColumnCount(); // Liczba kolumn

       String[] columnNamess = new String[f2]; // Tabela String do nazwy kolumny
        data_w = new Object[f][f2]; // Tworzenie Objektu f x f2 Tabeli
        
       
        /**
        * Nadawanie nazw kolumn tabeli
        */
        for(int w=1; w<=f2; w++){
            columnNamess[w-1]=rmd.getColumnName(w);
        }   
        
        /**
        * Wypełnianie tabeli danymi pobranymi z bazy danych
        */
        int l=0;
        while (res2.next()){
        for (int k = 1; k <= f2; k++)
              {
                  data_w[l][k-1]=res2.getString(k); 
              }
            l++; // Numer wiersza, krotki

        show.jTable1.setModel(new DefaultTableModel(data_w, columnNamess)); // Wstawianie danych i nazwy kolumn do tabeli 
      
    }
      show.jTable1.setVisible(true);  // Włączenie wyświetlania kolumn
      jTextArea1.append("Pomyślnie pobrano dane \n");
      message.append(Color.YELLOW.darker(), "Pomyślnie pobrano dane");
      jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
      
      res.close(); // Zamykanie zapytania
      res2.close(); // Zamykanie zapytania
      //jTextArea1.setForeground(Color.red);
      //jTextArea1.setForeground(Color.BLACK);
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    
        System.out.println(" ");
        
        
    }
    
    
    
    public static void select_edytuj(String id){
        
        Statement sta = null;
        Statement sta1 = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        PreparedStatement  psta1 = null; //efektywniejsze od Statment
        ResultSet res = null;
        ResultSet res2 = null;
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        

        psta = con_w.prepareStatement("SELECT STAN, TYP_OFERTY, CENA_OBIEKTU, ID_LOKALIZACJI, CENA_MIESIECZNA, ID_WŁAŚCICIELA FROM Oferta Where ID_OFERT like "+id+""); //efektywniejsze od Statment
        
        jTextArea1.append("Wysłano zapytanie \n");
        
        //sta1 = con.createStatement(); 
        
        
        res = psta.executeQuery();
        
        ResultSetMetaData rmd = res.getMetaData();
        //rmd.getColumnCount();
        res.next();

      
       window.jTextField1.setText(res.getString(1));
       window.jTextField10.setText(res.getString(2));
       window.jTextField11.setText(res.getString(3));
       window.jTextField12.setText(res.getString(4));
       window.jTextField13.setText(res.getString(5));
       window.jTextField14.setText(res.getString(6));
      
      jTextArea1.append("Pomyślnie pobrano dane oferty do edycji \n");
      message.append(Color.YELLOW.darker(), "Pomyślnie pobrano dane oferty do edycji");
      jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
      
      res.close(); // Zamykanie zapytania
      res2.close(); // Zamykanie zapytania
      //jTextArea1.setForeground(Color.red);
      //jTextArea1.setForeground(Color.BLACK);
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: BŁĄD: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    
        System.out.println(" ");
        
        
    }
    
    
    
    
    public static void select_lokalizacja(String query){
        
        Statement sta = null;
        Statement sta1 = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        PreparedStatement  psta1 = null; //efektywniejsze od Statment
        ResultSet res = null;
        ResultSet res2 = null;
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        
// Load Microsoft JDBC Driver 1.0
     // Class.forName("oracle.jdbc.driver.OracleDriver");

// Obtaining a connection to SQL Server
      //if(con==null){
      //con = DriverManager.getConnection("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf","pdybcio","pdybcio");
      //jTextArea1.append("Połączono automatycznie \n");
      //}
// Getting result meta data
            
        //sta = con.createStatement(); 
        psta = con_w.prepareStatement("SELECT COUNT(*) FROM Lokalizacja "); //efektywniejsze od Statment
        long startTime = System.nanoTime();
        res = psta.executeQuery();
        long resultTime = (System.nanoTime() - startTime)/1000000;
        System.out.println(startTime);
        jTextArea1.append("Wysłano zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano zapytanie " + resultTime+"ms ");
        //sta1 = con.createStatement(); 
        psta1 = con_w.prepareStatement(query); //efektywniejsze od Statment
        
        res2 = psta1.executeQuery();
        jTextArea1.append("Wysłano następne zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano następne zapytanie");
 
        ResultSetMetaData rmd = res2.getMetaData();
        rmd.getColumnCount();
        res.next();

       int f =res.getInt(1); // Liczba wierszy
       int f2=rmd.getColumnCount(); // Liczba kolumn

       String[] columnNamess = new String[f2]; // Tabela String do nazwy kolumny
        data_w = new Object[f][f2]; // Tworzenie Objektu f x f2 Tabeli
        
       
        /**
        * Nadawanie nazw kolumn tabeli
        */
        for(int w=1; w<=f2; w++){
            columnNamess[w-1]=rmd.getColumnName(w);
        }   
        
        /**
        * Wypełnianie tabeli danymi pobranymi z bazy danych
        */
        int l=0;
        while (res2.next()){
        for (int k = 1; k <= f2; k++)
              {
                  data_w[l][k-1]=res2.getString(k); 
              }
            l++; // Numer wiersza, krotki

        show.jTable2.setModel(new DefaultTableModel(data_w, columnNamess)); // Wstawianie danych i nazwy kolumn do tabeli 
      
    }
      show.jTable2.setVisible(true);  // Włączenie wyświetlania kolumn
      jTextArea1.append("Pomyślnie pobrano dane \n");
      message.append(Color.YELLOW.darker(), "Pomyślnie pobrano dane");
      jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
      
      res.close(); // Zamykanie zapytania
      res2.close(); // Zamykanie zapytania
      //jTextArea1.setForeground(Color.red);
      //jTextArea1.setForeground(Color.BLACK);
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    
        System.out.println(" ");
        
        
    }
  
    
    public static void select_mieszkanie(String query){
        
        Statement sta = null;
        Statement sta1 = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        PreparedStatement  psta1 = null; //efektywniejsze od Statment
        ResultSet res = null;
        ResultSet res2 = null;
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        
// Load Microsoft JDBC Driver 1.0
     // Class.forName("oracle.jdbc.driver.OracleDriver");

// Obtaining a connection to SQL Server
      //if(con==null){
      //con = DriverManager.getConnection("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf","pdybcio","pdybcio");
      //jTextArea1.append("Połączono automatycznie \n");
      //}
// Getting result meta data
            
        //sta = con.createStatement(); 
        psta = con_w.prepareStatement("SELECT COUNT(*) FROM Mieszkanie "); //efektywniejsze od Statment
        long startTime = System.nanoTime();
        res = psta.executeQuery();
        long resultTime = (System.nanoTime() - startTime)/1000000;
        System.out.println(startTime);
        jTextArea1.append("Wysłano zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano zapytanie " + resultTime+"ms ");
        //sta1 = con.createStatement(); 
        psta1 = con_w.prepareStatement(query); //efektywniejsze od Statment
        
        res2 = psta1.executeQuery();
        jTextArea1.append("Wysłano następne zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano następne zapytanie");
 
        ResultSetMetaData rmd = res2.getMetaData();
        rmd.getColumnCount();
        res.next();

       int f =res.getInt(1); // Liczba wierszy
       int f2=rmd.getColumnCount(); // Liczba kolumn

       String[] columnNamess = new String[f2]; // Tabela String do nazwy kolumny
        data_w = new Object[f][f2]; // Tworzenie Objektu f x f2 Tabeli
        
       
        /**
        * Nadawanie nazw kolumn tabeli
        */
        for(int w=1; w<=f2; w++){
            columnNamess[w-1]=rmd.getColumnName(w);
        }   
        
        /**
        * Wypełnianie tabeli danymi pobranymi z bazy danych
        */
        int l=0;
        while (res2.next()){
        for (int k = 1; k <= f2; k++)
              {
                  data_w[l][k-1]=res2.getString(k); 
              }
            l++; // Numer wiersza, krotki

        show.jTable3.setModel(new DefaultTableModel(data_w, columnNamess)); // Wstawianie danych i nazwy kolumn do tabeli 
      
    }
      show.jTable3.setVisible(true);  // Włączenie wyświetlania kolumn
      jTextArea1.append("Pomyślnie pobrano dane \n");
      message.append(Color.YELLOW.darker(), "Pomyślnie pobrano dane");
      jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
      
      res.close(); // Zamykanie zapytania
      res2.close(); // Zamykanie zapytania
      //jTextArea1.setForeground(Color.red);
      //jTextArea1.setForeground(Color.BLACK);
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    
        System.out.println(" ");
        
        
    }
    
    
    public static void select_dom(String query){
        
        Statement sta = null;
        Statement sta1 = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        PreparedStatement  psta1 = null; //efektywniejsze od Statment
        ResultSet res = null;
        ResultSet res2 = null;
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        
// Load Microsoft JDBC Driver 1.0
     // Class.forName("oracle.jdbc.driver.OracleDriver");

// Obtaining a connection to SQL Server
      //if(con==null){
      //con = DriverManager.getConnection("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf","pdybcio","pdybcio");
      //jTextArea1.append("Połączono automatycznie \n");
      //}
// Getting result meta data
            
        //sta = con.createStatement(); 
        psta = con_w.prepareStatement("SELECT COUNT(*) FROM Dom "); //efektywniejsze od Statment
        long startTime = System.nanoTime();
        res = psta.executeQuery();
        long resultTime = (System.nanoTime() - startTime)/1000000;
        System.out.println(startTime);
        jTextArea1.append("Wysłano zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano zapytanie " + resultTime+"ms ");
        //sta1 = con.createStatement(); 
        psta1 = con_w.prepareStatement(query); //efektywniejsze od Statment
        
        res2 = psta1.executeQuery();
        jTextArea1.append("Wysłano następne zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano następne zapytanie");
 
        ResultSetMetaData rmd = res2.getMetaData();
        rmd.getColumnCount();
        res.next();

       int f =res.getInt(1); // Liczba wierszy
       int f2=rmd.getColumnCount(); // Liczba kolumn

       String[] columnNamess = new String[f2]; // Tabela String do nazwy kolumny
        data_w = new Object[f][f2]; // Tworzenie Objektu f x f2 Tabeli
        
       
        /**
        * Nadawanie nazw kolumn tabeli
        */
        for(int w=1; w<=f2; w++){
            columnNamess[w-1]=rmd.getColumnName(w);
        }   
        
        /**
        * Wypełnianie tabeli danymi pobranymi z bazy danych
        */
        int l=0;
        while (res2.next()){
        for (int k = 1; k <= f2; k++)
              {
                  data_w[l][k-1]=res2.getString(k); 
              }
            l++; // Numer wiersza, krotki

        show.jTable4.setModel(new DefaultTableModel(data_w, columnNamess)); // Wstawianie danych i nazwy kolumn do tabeli 
      
    }
      show.jTable4.setVisible(true);  // Włączenie wyświetlania kolumn
      jTextArea1.append("Pomyślnie pobrano dane \n");
      message.append(Color.YELLOW.darker(), "Pomyślnie pobrano dane");
      jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
      
      res.close(); // Zamykanie zapytania
      res2.close(); // Zamykanie zapytania
      //jTextArea1.setForeground(Color.red);
      //jTextArea1.setForeground(Color.BLACK);
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    
        System.out.println(" ");
        
        
    }
    
    
    public static void select_segment(String query){
        
        Statement sta = null;
        Statement sta1 = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        PreparedStatement  psta1 = null; //efektywniejsze od Statment
        ResultSet res = null;
        ResultSet res2 = null;
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        
// Load Microsoft JDBC Driver 1.0
     // Class.forName("oracle.jdbc.driver.OracleDriver");

// Obtaining a connection to SQL Server
      //if(con==null){
      //con = DriverManager.getConnection("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf","pdybcio","pdybcio");
      //jTextArea1.append("Połączono automatycznie \n");
      //}
// Getting result meta data
            
        //sta = con.createStatement(); 
        psta = con_w.prepareStatement("SELECT COUNT(*) FROM Segment "); //efektywniejsze od Statment
        long startTime = System.nanoTime();
        res = psta.executeQuery();
        long resultTime = (System.nanoTime() - startTime)/1000000;
        System.out.println(startTime);
        jTextArea1.append("Wysłano zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano zapytanie " + resultTime+"ms ");
        //sta1 = con.createStatement(); 
        psta1 = con_w.prepareStatement(query); //efektywniejsze od Statment
        
        res2 = psta1.executeQuery();
        jTextArea1.append("Wysłano następne zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano następne zapytanie");
 
        ResultSetMetaData rmd = res2.getMetaData();
        rmd.getColumnCount();
        res.next();

       int f =res.getInt(1); // Liczba wierszy
       int f2=rmd.getColumnCount(); // Liczba kolumn

       String[] columnNamess = new String[f2]; // Tabela String do nazwy kolumny
        data_w = new Object[f][f2]; // Tworzenie Objektu f x f2 Tabeli
        
       
        /**
        * Nadawanie nazw kolumn tabeli
        */
        for(int w=1; w<=f2; w++){
            columnNamess[w-1]=rmd.getColumnName(w);
        }   
        
        /**
        * Wypełnianie tabeli danymi pobranymi z bazy danych
        */
        int l=0;
        while (res2.next()){
        for (int k = 1; k <= f2; k++)
              {
                  data_w[l][k-1]=res2.getString(k); 
              }
            l++; // Numer wiersza, krotki

        show.jTable5.setModel(new DefaultTableModel(data_w, columnNamess)); // Wstawianie danych i nazwy kolumn do tabeli 
      
    }
      show.jTable5.setVisible(true);  // Włączenie wyświetlania kolumn
      jTextArea1.append("Pomyślnie pobrano dane \n");
      message.append(Color.YELLOW.darker(), "Pomyślnie pobrano dane");
      jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
      
      res.close(); // Zamykanie zapytania
      res2.close(); // Zamykanie zapytania
      //jTextArea1.setForeground(Color.red);
      //jTextArea1.setForeground(Color.BLACK);
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    
        System.out.println(" ");
        
        
    }
    
    public static void select_id_mieszkania(){
        
        Statement sta = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        ResultSet res = null;
       
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        psta = con_w.prepareStatement("SELECT COUNT(*) FROM  Mieszkanie "); //efektywniejsze od Statment
        res = psta.executeQuery();
        res.next();

       int id =res.getInt(1); // Liczba wierszy
       id++;
       add.jLabel18.setText("" + id);
             
      res.close(); // Zamykanie zapytania
      
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    System.out.println(" ");
        
        
    }
    
  public static void select_id_dom(){
        
        Statement sta = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        ResultSet res = null;
       
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        psta = con_w.prepareStatement("SELECT COUNT(*) FROM  Dom "); //efektywniejsze od Statment
        res = psta.executeQuery();
        res.next();

       int id =res.getInt(1); // Liczba wierszy
       id++;
       add.jLabel28.setText("" + id);
             
      res.close(); // Zamykanie zapytania
      
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    System.out.println(" ");
        
        
    }
  
  public static void select_id_segment(){
        
        Statement sta = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        ResultSet res = null;
       
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        psta = con_w.prepareStatement("SELECT COUNT(*) FROM  Segment "); //efektywniejsze od Statment
        res = psta.executeQuery();
        res.next();

       int id =res.getInt(1); // Liczba wierszy
       id++;
       add.jLabel38.setText("" + id);
             
      res.close(); // Zamykanie zapytania
      
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    System.out.println(" ");
        
        
    }
  
  public static void select_id_właściciel(){
        
        Statement sta = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        ResultSet res = null;
       
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        psta = con_w.prepareStatement("SELECT COUNT(*) FROM  Właściciel "); //efektywniejsze od Statment
        res = psta.executeQuery();
        res.next();

       int id =res.getInt(1); // Liczba wierszy
       id++;
       add.jLabel41.setText("" + id);
             
      res.close(); // Zamykanie zapytania
      
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    System.out.println(" ");
        
        
    }
  
  public static void select_id_oferta(){
        
        Statement sta = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        ResultSet res = null;
       
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        psta = con_w.prepareStatement("SELECT COUNT(*) FROM  Oferta "); //efektywniejsze od Statment
        res = psta.executeQuery();
        res.next();

       int id =res.getInt(1); // Liczba wierszy
       id++;
      window.jLabel5.setText("" + id);
             
      res.close(); // Zamykanie zapytania
      
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    System.out.println(" ");
        
        
    }
  
  public static void select_id_fizyczny(){
        
        Statement sta = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        ResultSet res = null;
       
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        psta = con_w.prepareStatement("SELECT COUNT(*) FROM  Fizyczny "); //efektywniejsze od Statment
        res = psta.executeQuery();
        res.next();

       int id =res.getInt(1); // Liczba wierszy
       id++;
       add.jLabel48.setText("" + id);
             
      res.close(); // Zamykanie zapytania
      
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    System.out.println(" ");
        
        
    }
  
  
  public static void select_id_deweloper(){
        
        Statement sta = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        ResultSet res = null;
       
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        psta = con_w.prepareStatement("SELECT COUNT(*) FROM  Deweloper "); //efektywniejsze od Statment
        res = psta.executeQuery();
        res.next();

       int id =res.getInt(1); // Liczba wierszy
       id++;
       add.jLabel57.setText("" + id);
             
      res.close(); // Zamykanie zapytania
      
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    System.out.println(" ");
        
        
    }
  
  
  public static void select_id_lokalizacja(){
        
        Statement sta = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        ResultSet res = null;
       
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        psta = con_w.prepareStatement("SELECT COUNT(*) FROM  Lokalizacja "); //efektywniejsze od Statment
        res = psta.executeQuery();
        res.next();

       int id =res.getInt(1); // Liczba wierszy
       id++;
       add.jLabel9.setText("" + id);
             
      res.close(); // Zamykanie zapytania
      
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    System.out.println(" ");
        
        
    }
  
  
  
  
  public static void select_id_pracownika(String login){
        
        Statement sta = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        ResultSet res = null;
       
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        psta = con_w.prepareStatement("SELECT ID_PRACOWNIK FROM  Pracownik where Login like "+login+""); //efektywniejsze od Statment
        res = psta.executeQuery();
        res.next();

       int id =res.getInt(1); // Liczba wierszy
       id++;
       window.jLabel7.setText("" + id);
             
      res.close(); // Zamykanie zapytania
      
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    System.out.println(" ");
        
        
    }
  
  
  
    public static void select_from_db_new(String query){
         // Connection con = null;
        Statement sta = null;
        Statement sta1 = null;
        PreparedStatement  psta = null; //efektywniejsze od Statment
        PreparedStatement  psta1 = null; //efektywniejsze od Statment
        ResultSet res = null;
        ResultSet res2 = null;
    if(con_w==null){
        jTextArea1.append("Nie jesteś połączony z bazą danych! \n");
        message.append(Color.RED.darker(), "Nie jesteś połączony z bazą danych!");
    } else{
    try {
        
// Load Microsoft JDBC Driver 1.0
     // Class.forName("oracle.jdbc.driver.OracleDriver");

// Obtaining a connection to SQL Server
      //if(con==null){
      //con = DriverManager.getConnection("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf","pdybcio","pdybcio");
      //jTextArea1.append("Połączono automatycznie \n");
      //}
// Getting result meta data
            
        //sta = con.createStatement(); 
        psta = con_w.prepareStatement("SELECT COUNT(*) FROM Oferta "); //efektywniejsze od Statment
        long startTime = System.nanoTime();
        res = psta.executeQuery();
        long resultTime = (System.nanoTime() - startTime)/1000000;
        System.out.println(startTime);
        jTextArea1.append("Wysłano zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano zapytanie " + resultTime+"ms ");
        //sta1 = con.createStatement(); 
        psta1 = con_w.prepareStatement(query); //efektywniejsze od Statment
        
        res2 = psta1.executeQuery();
        jTextArea1.append("Wysłano następne zapytanie \n");
        message.append(Color.BLUE.darker(), "Wysłano następne zapytanie");
 
        ResultSetMetaData rmd = res2.getMetaData();
        rmd.getColumnCount();
        res.next();

       int f =res.getInt(1); // Liczba wierszy
       int f2=rmd.getColumnCount(); // Liczba kolumn

       String[] columnNamess = new String[f2]; // Tabela String do nazwy kolumny
        data_w = new Object[f][f2]; // Tworzenie Objektu f x f2 Tabeli
        
       
        /**
        * Nadawanie nazw kolumn tabeli
        */
        for(int w=1; w<=f2; w++){
            columnNamess[w-1]=rmd.getColumnName(w);
        }   
        
        /**
        * Wypełnianie tabeli danymi pobranymi z bazy danych
        */
        int l=0;
        while (res2.next()){
        for (int k = 1; k <= f2; k++)
              {
                  data_w[l][k-1]=res2.getString(k); 
              }
            l++; // Numer wiersza, krotki

        window.jTable1.setModel(new DefaultTableModel(data_w, columnNamess)); // Wstawianie danych i nazwy kolumn do tabeli 
      
    }
      window.jTable1.setVisible(true);  // Włączenie wyświetlania kolumn
      jTextArea1.append("Pomyślnie pobrano dane \n");
      message.append(Color.YELLOW.darker(), "Pomyślnie pobrano dane");
      jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
      
      res.close(); // Zamykanie zapytania
      res2.close(); // Zamykanie zapytania
      //jTextArea1.setForeground(Color.red);
      //jTextArea1.setForeground(Color.BLACK);
      
    } catch (SQLException e) {
      System.err.println("SQLException: " +e.getMessage());
      jTextArea1.append("SQLException: "+e.getMessage()+ "\n");
      message.append(Color.RED.darker(), "SQLException: "+e.getMessage()+ "");
     
    } catch(Exception e){
     jTextArea1.append("Exception: "+e.getMessage()+ "\n");
     message.append(Color.RED.darker(), "Exception: "+e.getMessage()+ "");
      } 
     }
    
        System.out.println(" ");
        
        
    }
    
    
    
}
