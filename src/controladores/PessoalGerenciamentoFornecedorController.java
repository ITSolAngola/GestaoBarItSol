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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bacar
 */
public class PessoalGerenciamentoFornecedorController implements Initializable {

    @FXML
    private Label log_usuario;
    @FXML
    private Label log_nivelAcesso;
    @FXML
    private TextField funcionario_nome;
    @FXML
    private Label erro_nome;
    @FXML
    private TextField funcionario_pais;
    @FXML
    private TextField funcionario_municipio;
    @FXML
    private TextField funcionario_rua;
    @FXML
    private Label erro_endereco;
    @FXML
    private TextField funcionario_telefone1;
    @FXML
    private Label erro_telef1;
    @FXML
    private TextField funcionario_telefone2;
    @FXML
    private Label erro_telef2;
    @FXML
    private Button btn_func_adicionar;
    @FXML
    private TextField funcionario_idPesquisa;
    @FXML
    private Label erro_pesquisa;
    @FXML
    private TableView<?> tabelaFuncionario;
    @FXML
    private TableColumn<?, ?> col_Cod_Funcionário;
    @FXML
    private TableColumn<?, ?> col_Nome;
    @FXML
    private TableColumn<?, ?> col_Endereco;
    @FXML
    private TableColumn<?, ?> col_Telefone_Principal;
    @FXML
    private TableColumn<?, ?> col_Telefone_Opcional;
    @FXML
    private StackPane stckPane_conteiner_forncedor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void voltarBtn(MouseEvent event) {
        
         Stage administradorHome = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/visualizacao/PessoalGerenciamento.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(PessoalGerenciamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Stage current = (Stage) stckPane_conteiner_forncedor.getScene().getWindow();
        Scene scene = new Scene(root);

        administradorHome.setScene(scene);
        administradorHome.setMaximized(true);
        current.close();
        administradorHome.show();
        
    }

    @FXML
    private void fechar(MouseEvent event) {
    }

    @FXML
    private void realceCampoNome_ext(MouseEvent event) {
    }

    @FXML
    private void realceCampoNome(MouseEvent event) {
    }

    @FXML
    private void realceCampo_endereco_ext(MouseEvent event) {
    }

    @FXML
    private void realceCampo_endereco(MouseEvent event) {
    }

    @FXML
    private void realceCampo_telefone1_ext(MouseEvent event) {
    }

    @FXML
    private void realceCampo_telefone1(MouseEvent event) {
    }

    @FXML
    private void realceCampo_telefone2_ext(MouseEvent event) {
    }

    @FXML
    private void realceCampo_telefone2(MouseEvent event) {
    }

    @FXML
    private void registrarFuncionario(ActionEvent event) {
    }

    @FXML
    private void atualizar(MouseEvent event) {
    }

    @FXML
    private void listarFuncionario(MouseEvent event) {
    }

    @FXML
    private void limparCampos(MouseEvent event) {
    }

    @FXML
    private void pesquisarFuncionario(ActionEvent event) {
    }

    @FXML
    private void realceCampo_idPesquisa_ext(MouseEvent event) {
    }

    @FXML
    private void realceCampo_idPesquisa(MouseEvent event) {
    }
    
}
