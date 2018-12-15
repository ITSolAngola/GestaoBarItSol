/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bacar
 */
public class ProdutosGerenciamentoController implements Initializable {

    @FXML
    private StackPane stackGerenciamentoProduto;
    @FXML
    private Label log_usuario;
    @FXML
    private Label log_nivelAcesso;
    @FXML
    private Pane pane_comida;
    @FXML
    private Pane pane_bebida;
    @FXML
    private Pane pane_alimentos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        log_usuario.setText(LogUsuario.logUsers.get(0));
        log_nivelAcesso.setText(LogUsuario.logUsers.get(1));
        
    }    

    @FXML
    private void bt_sair(MouseEvent event) {
        MetodosComuns.mensagemSairTerminarLog(stackGerenciamentoProduto);
    }

    @FXML
    private void bt_voltar(MouseEvent event) {
           Stage administradorHome = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/visualizacao/Administrador.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(PessoalGerenciamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage current = (Stage)stackGerenciamentoProduto.getScene().getWindow();
        Scene scene = new Scene(root);
       
        
        administradorHome.setScene(scene);
        administradorHome.setMaximized(true);
        current.hide();
        administradorHome.show();
    }

    @FXML
    private void mouse_exit_comidas(MouseEvent event) {
        pane_comida.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_comidas(MouseEvent event) {
        pane_comida.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void telaComidas(MouseEvent event) {
    }

    @FXML
    private void mouse_exit_bebidas(MouseEvent event) {
        pane_bebida.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_bebidas(MouseEvent event) {
        pane_bebida.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void telaBebidas(MouseEvent event) {
        
        Stage bebidas = new Stage();
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource("/visualizacao/ProdutosGerenciamentoBebidas.fxml"));
            EstiloControlador.efeitoTransacao(root);
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage current = (Stage)stackGerenciamentoProduto.getScene().getWindow();
        Scene scene = new Scene(root);
        
        bebidas.setScene(scene);
        bebidas.setMaximized(true);
        bebidas.setResizable(false);
        
        current.hide();
        bebidas.show();
        
    }

    @FXML
    private void mouse_exit_alimentos(MouseEvent event) {
        pane_alimentos.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_alimentos(MouseEvent event) {
        pane_alimentos.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void telaAlimentos(MouseEvent event) {
    }
    
}
