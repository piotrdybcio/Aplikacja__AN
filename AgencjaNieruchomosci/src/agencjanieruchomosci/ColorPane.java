/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agencjanieruchomosci;

//import static agencjanieruchomosci.ekran.jTextPane1;
import static agencjanieruchomosci.window.jTextPane1;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author Piotr
 */
public class ColorPane extends JTextPane{
    AgencjaNieruchomosci AN;
    
    
   /**
    *
    * Funkcja odopowiada za wyświetlanie w kolorze komunikatów i wyjątków
    * poprzez parametr message dostępny w klasie ekran [v.1.0]
    * 
    */
    public void append(Color c, String s) {
        
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        int len = getDocument().getLength();
        jTextPane1.setCaretPosition(len); 
        jTextPane1.setCharacterAttributes(aset, false);
        jTextPane1.replaceSelection(s+"\n");
    }

    


}
