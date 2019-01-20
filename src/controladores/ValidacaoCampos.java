/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author bacar
 */
public class ValidacaoCampos {
    
    public static boolean textFieldNaoEstaVaziaTelef(TextField tf){
        boolean estado = false;
        if (tf.getText().length() != 0 || !tf.getText().isEmpty()){
            if((tf.getText().matches("[0-9]+"))){
                 estado = true;
            }
        }
        return estado;
    }
    
    public static boolean textFieldNaoEstaVaziaTelef(TextField tf,Label lb,String mensagemErro){
        boolean estado = true;
        String mensagem = null;
        if (!textFieldNaoEstaVaziaTelef(tf)){
            estado = false;
            mensagem = mensagemErro;   
        }
        lb.setText(mensagem);
        return estado;
    }
    
    
    public static boolean textFieldNaoEstaVaziaBi(TextField tf){
        boolean estado = false;
        if ((tf.getText().length() != 0 || !tf.getText().isEmpty()) && (tf.getText().matches("[0-9]+[a-zA-Z]+")) )
            estado = true;
        return estado;
    }
    
    public static boolean textFieldNaoEstaVaziaBi(TextField tf,Label lb,String mensagemErro){
        boolean estado = true;
        String mensagem = null;
        //tf.getStyleClass().remove("erro");
        if (!textFieldNaoEstaVaziaBi(tf)){
            estado = false;
            mensagem = mensagemErro;   
        }
        lb.setText(mensagem);
        return estado;
    }
    
    
    public static boolean textFieldNaoEstaVazia(TextField tf){
        boolean estado = false;
        if ((tf.getText().length() != 0 || !tf.getText().isEmpty() ) && (tf.getText().matches("([a-zA-Z]+(\\s)*)+")) )
            estado = true;
        return estado;
    }
    
    public static boolean textFieldNaoEstaVazia(TextField tf,Label lb,String mensagemErro){
        boolean estado = true;
        String mensagem = null;
        //tf.getStyleClass().remove("erro");
        if (!textFieldNaoEstaVazia(tf)){
            estado = false;
            mensagem = mensagemErro;   
        }
        lb.setText(mensagem);
        return estado;
    }
    
    public static boolean campoData(DatePicker datepicker){
        
         boolean estado = false;
        if (datepicker.getValue() != null)
            estado = true;
        return estado;
        
    }   
    
    public static boolean campoData(DatePicker data,Label lb,String mensagemErro){
        
         boolean estado = true;
        String mensagem = null;
        if (!campoData(data)){
            estado = false;
            mensagem = mensagemErro;  
        }
        lb.setText(mensagem);
        return estado;
        
    }
    
    public static boolean comboBoxValor(ComboBox comboBox){
        
         boolean estado = false;
        if (comboBox.getValue() != null)
            estado = true;
        return estado;
        
    }   
    
    public static boolean comboBoxValor(ComboBox cb,Label lb,String mensagemErro){
        
         boolean estado = true;
        String mensagem = null;
        if (!comboBoxValor(cb)){
            estado = false;
            mensagem = mensagemErro;  
        }
        lb.setText(mensagem);
        return estado;
        
    }
    
    public static boolean isCampoTextoTipoNumero(TextField tf){
        
        boolean estado = false;

        if(tf.getText().matches("([0-9]+(\\.[0-9]+)?)+")){
        estado = true;              
        return estado;
        }
        return estado;
        
    }
    
    public static boolean isCampoTextoTipoNumero(TextField tf, Label lb, String mensagemErro){
        
        boolean estado = true;
        String mensagem= null;
        if(!isCampoTextoTipoNumero(tf)){
            estado = false;              
            mensagem = mensagemErro;
        }
        lb.setText(mensagem);
        return estado;
    } 
    
    public static boolean isCampoId(TextField tf, Label lb, String mensagemErro){
        
        boolean estado = true;
        String mensagem= null;
       // tf.getStyleClass().remove("erro");
        if(!isCampoTextoTipoNumero(tf)){
            estado = false;              
            mensagem = mensagemErro;
         //   tf.getStyleClass().add("erro");
        }
        lb.setText(mensagem);
        return estado;
    } 
}
