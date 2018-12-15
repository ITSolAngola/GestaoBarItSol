/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.util.Duration;

/**
 *
 * @author bacar
 */
public class EstiloControlador {
    
    //cores padrões dos botões
    public final static String btnNormalDefault = "-fx-background-color:#56e558";
    public final static String btnFecharDefault = "-fx-background-color: #f00606";
    
    //comportamento ao passar o rato/mouse
    public final static String corHover = "-fx-background-color:#ccc8c8; "
                            + "-fx-background-radius:6px;";
    
    public final static String corExit = "-fx-background-color:white;"
                            + "-fx-background-radius:6px;";
    
    //comportamento assumido depois de passar o rato
    public final static String btnMarcadoNormala ="-fx-background-color:#ccf7c1";
    public final static String btnMarcadoSair = "-fx-background-color:#bd0f0f";
    
    //realce campo de texto
    public final static String realceCampo = "-fx-background-color:#ccf7c1";
    public final static String realceDefault = "-fx-background-color:#fff";
    
    public final static void efeitoTransacao( Parent root){
             //Efeito da sombra
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000),root);
        fadeTransition.setFromValue(0.7);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
       
    }
    
}
