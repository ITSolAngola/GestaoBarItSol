/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import gestao.bar.api.configuracao.DBConect;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author bacar
 */
public class AdministradorController implements Initializable {

    @FXML
    private Label log_usuario;
    @FXML
    private Label log_nivelAcesso;
    @FXML
    private Pane pane_vendas;
    @FXML
    private Pane pane_faturacao;
    @FXML
    private Pane pane_produtos;
    @FXML
    private Pane pane_pessoal;
    @FXML
    private Pane pane_estatisticas;
    @FXML
    private Pane pane_seguranca;
    @FXML
    private Pane pane_monitoracao;
    @FXML
    private Pane pane_definicoes;
    @FXML
    private StackPane stackGerenciaBar;
    Map map;
    
    public static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("teste.jpa");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       log_usuario.setText("Bem-Vindo " +LogUsuario.logUsers.get(0));
       log_nivelAcesso.setText(LogUsuario.logUsers.get(1));
       
       //map = DBConect.propMysql("gestaobar", "root","");
       //DBConect.execute("teste.jpa", map);
    }    


    @FXML
    private void bt_sair(MouseEvent event) {
        
        MetodosComuns.mensagemSairTerminarLog(stackGerenciaBar);
        
    }

  @FXML
    private void mouse_exit__vendas(MouseEvent event) {
        pane_vendas.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_faturacao(MouseEvent event) {
        pane_faturacao.setStyle(EstiloControlador.corHover);
        
    }

    @FXML
    private void mouse_exit_faturacao(MouseEvent event) {
        pane_faturacao.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_produtos(MouseEvent event) {
        pane_produtos.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void mouse_exit_produtos(MouseEvent event) {
        pane_produtos.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_estatisticas(MouseEvent event) {
        pane_estatisticas.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void mouse_exit_estatisticas(MouseEvent event) {
        pane_estatisticas.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_definicoes(MouseEvent event) {
        pane_definicoes.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void mouse_exit_definicoes(MouseEvent event) {
        pane_definicoes.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_seguranca(MouseEvent event) {
        pane_seguranca.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void mouse_exit_seguranca(MouseEvent event) {
        pane_seguranca.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_monitoracao(MouseEvent event) {
        pane_monitoracao.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void mouse_exit_monitoracao(MouseEvent event) {
        pane_monitoracao.setStyle(EstiloControlador.corExit);
    }

    @FXML
    private void mouse_hover_vendas(MouseEvent event) {
         pane_vendas.setStyle(EstiloControlador.corHover);
    }

    @FXML
    private void mouse_exit_pessoal(MouseEvent event) {
        
        pane_pessoal.setStyle(EstiloControlador.corExit);
        
    }

    @FXML
    private void mouse_hover_pessoal(MouseEvent event) {
         pane_pessoal.setStyle(EstiloControlador.corHover);
    }
    
    //TELAAS GERENCIAMENTO
    
   @FXML
    private void telaProduto(MouseEvent event) {
        
        Stage produtos = new Stage();
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource("/visualizacao/ProdutosGerenciamento.fxml"));
            EstiloControlador.efeitoTransacao(root);
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage current = (Stage)pane_pessoal.getScene().getWindow();
        Scene scene = new Scene(root);
        
        produtos.setScene(scene);
        produtos.setMaximized(true);
        
        current.hide();
        produtos.show();

        
    }
    
    @FXML
    private void telaPessoal(MouseEvent event) {
        
        Stage pessoal = new Stage();
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource("/visualizacao/PessoalGerenciamento.fxml"));
            EstiloControlador.efeitoTransacao(root);
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage current = (Stage)pane_pessoal.getScene().getWindow();
        Scene scene = new Scene(root);
        
        pessoal.setScene(scene);
        pessoal.setMaximized(true);
        
        current.hide();
        pessoal.show();
        
    }

    
}
