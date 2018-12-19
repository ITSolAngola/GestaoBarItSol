/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author bacar
 */
public class BemVindoController implements Initializable {

    @FXML
    private ImageView imagem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(5000),imagem);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);
        
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
           
                Stage loginTela = new Stage();
                Parent root = null;
                
                try {
                    root = FXMLLoader.load(getClass().getResource("/visualizacao/LoginInicial.fxml"));
                } catch (Exception e) {
                    
                }
                
                Stage atualTela = (Stage) imagem.getScene().getWindow();
                Scene scene = new Scene(root);
                
                loginTela.setScene(scene);
                atualTela.close();
                loginTela.show();
                
            }
        });
        fadeTransition.play();
    }    
    
}

