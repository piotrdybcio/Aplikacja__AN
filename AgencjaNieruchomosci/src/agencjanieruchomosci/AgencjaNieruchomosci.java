/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agencjanieruchomosci;



/**
 *
 * @author Piotr
 */
public class AgencjaNieruchomosci {

    public static ekran ekr;
    public static show show;
    public static add add;
    public static login login;
    public static window window;
    public static ColorPane CP;
    public static connection connection;
    public static select select;
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //na teraz wyłączyłem w celu sprawdzenia samego ekranu, login dołożymy na koniec ;)
       // login=new login();      
        //login.setVisible(true);
        ekr = new ekran();
        ekr.setVisible(false);
        
        window = new window();
        window.setVisible(true);
        connection = new connection(); // Zainisjowanie komponentu connection definiującego metody start_connectio i stop_connection
            select.select_id_pracownika("Piotr");
    }
    
}
