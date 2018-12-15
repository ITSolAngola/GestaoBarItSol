/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author bacar
 */
public class MetodosComuns {
    
    public static void mensagemSairTerminarLog(Pane dialogoPane) {
        
        JFXDialogLayout mensagemLayout = new JFXDialogLayout();
        mensagemLayout.setHeading(new Text("Saida do Sistema"));
        mensagemLayout.setBody(new Text(" Tens a certeza que pretendes terminar a sessão ?"));
        
        JFXButton sim = new JFXButton("Sim");
        JFXButton cancelar = new JFXButton("Cancelar");
        
        JFXDialog dialog = new JFXDialog((StackPane) dialogoPane,mensagemLayout,JFXDialog.DialogTransition.CENTER);
        
        sim.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage telaInicialLogin = new Stage();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/visualizacao/LoginInicial.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
                }
        Stage current = (Stage)dialogoPane.getScene().getWindow();
        Scene scene = new Scene(root);
       
        
        telaInicialLogin.setScene(scene);
        telaInicialLogin.initStyle(StageStyle.TRANSPARENT);
        current.close();
        telaInicialLogin.show();
            }
        });
        
        cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               dialog.close();
            }
        });
        
        mensagemLayout.setActions(sim,cancelar);
        dialog.show();
    
    }
    
    
    public static void mensagemFecharSistema(Pane dialogoPane) {
        
        JFXDialogLayout mensagemLayout = new JFXDialogLayout();
        mensagemLayout.setHeading(new Text("Saida do Sistema"));
        mensagemLayout.setBody(new Text(" Tens a certeza que pretendes fechar o Sistema ?"));
        
        JFXButton sim = new JFXButton("Sim");
        JFXButton cancelar = new JFXButton("Cancelar");
        
        JFXDialog dialog = new JFXDialog((StackPane) dialogoPane,mensagemLayout,JFXDialog.DialogTransition.CENTER);
        
        sim.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        
        cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               dialog.close();
            }
        });
        
        mensagemLayout.setActions(sim,cancelar);
        dialog.show();
    
    } 
    
   public static void mensagem(Pane dialogoPane , String mensagem) {
       
        JFXDialogLayout mensagemLayout = new JFXDialogLayout();
      
        mensagemLayout.setBody(new Text(mensagem));
        
        JFXButton sim = new JFXButton("Ok");
        
        JFXDialog dialog = new JFXDialog((StackPane) dialogoPane,mensagemLayout,JFXDialog.DialogTransition.CENTER);
        
        sim.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               dialog.close();
            }
        });
        
        mensagemLayout.setActions(sim);
        dialog.show();
        
           
        
    }
    
    public static void hora(Label l){
        
        Thread hora = new Thread(){
            
            public void run(){
                try {
                    for(;;){
                        Calendar calendario = new GregorianCalendar();
                        int dia = calendario.get(Calendar.DAY_OF_MONTH);
                        int mes = calendario.get(Calendar.MONTH);
                        int ano = calendario.get(Calendar.YEAR);
                    
                    int segundos = calendario.get(Calendar.SECOND);
                    int minuto = calendario.get(Calendar.MINUTE);
                    int hora = calendario.get(Calendar.HOUR);
                    
                    l.setText("Hora "+hora+":"+minuto+":"+segundos+" Data "+dia+"/"+mes+"/"+ano);
                    sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        hora.start();
    }
    
}
