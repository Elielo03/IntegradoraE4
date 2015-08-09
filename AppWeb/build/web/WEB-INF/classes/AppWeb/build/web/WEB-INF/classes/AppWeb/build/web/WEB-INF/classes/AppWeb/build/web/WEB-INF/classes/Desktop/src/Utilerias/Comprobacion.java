/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;

/**
 *
 * @author Eliel David
 */
public class Comprobacion {
    
    public Comprobacion() {
    }
    
    public boolean validarCampoTxt(String parametro){
        if((parametro.isEmpty())){
            return true;
        }
        
        return false;
    }
    
    public boolean validarCorreo(String correo){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if(mat.find()){
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean validarLetras(java.awt.event.KeyEvent evt){
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas            
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'ü'
                && car != 'Á' //Mayúsculas            
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && car != 'Ü'
                && (car != (char) KeyEvent.VK_SPACE)) {
             evt.consume();
            return true;
        }else{
            return false;
        }
    
}
    public void numeros(java.awt.event.KeyEvent evt){
        char n = evt.getKeyChar();
        if(!Character.isDigit(n)){
            evt.consume();
                    }
    }
    
    public String Mayuscula(String a){
        String asd = a.trim().substring(0, 1).toUpperCase();
             return asd;     
        }
    }
    

