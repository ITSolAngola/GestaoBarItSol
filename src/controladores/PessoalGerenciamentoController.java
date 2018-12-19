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
public class PessoalGerenciamentoController implements Initializable {

    @FXML
    private StackPane stackPessoal;
    @FXML
    private Label log_usuario;
    @FXML
    private Label log_nivelAcesso;
    @FXML
    private Pane pane_pessoal;
    @FXML
    private Pane pane_fornecedores;

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
        MetodosComuns.mensagemSairTerminarLog(stackPessoal);
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
        
        Stage current = (Stage)stackPessoal.getScene().getWindow();
        Scene scene = new Scene(root);
       
        
        administradorHome.setScene(scene);
        administradorHome.setMaximized(true);
        current.close();
        administradorHome.show();
    }


   
    @FXML
    private void mouse_exit_pessoal(MouseEvent event) {
        pane_pessoal.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_pessoal(MouseEvent event) {
         pane_pessoal.setStyle(EstiloControlador.corHover);
    }
    
    @FXML
    private void mouse_exit_fornecedores(MouseEvent event) {
        pane_fornecedores.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_fornecedores(MouseEvent event) {
         pane_fornecedores.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void telaPessoal(MouseEvent event) {
        Stage funcionario = new Stage();
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource("/visualizacao/PessoalGerenciamentoFuncionario.fxml"));
            EstiloControlador.efeitoTransacao(root);
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage current = (Stage)pane_pessoal.getScene().getWindow();
        Scene scene = new Scene(root);
        
        funcionario.setScene(scene);
        funcionario.setMaximized(true);
        funcionario.setResizable(false);
        current.close();
        funcionario.show();
    }
    
    
    @FXML
    private void tela_Fornecedores(MouseEvent event) {
        
             Stage fornecedorTela = new Stage();
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource("/visualizacao/PessoalGerenciamentoFornecedor.fxml"));
            EstiloControlador.efeitoTransacao(root);
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage current = (Stage)pane_pessoal.getScene().getWindow();
        Scene scene = new Scene(root);
        
        fornecedorTela.setScene(scene);
        fornecedorTela.setMaximized(true);
        fornecedorTela.setResizable(false);
        fornecedorTela.close();
        fornecedorTela.show();
        
    }

    

}
