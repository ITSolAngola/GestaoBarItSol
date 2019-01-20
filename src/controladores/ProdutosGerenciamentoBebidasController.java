/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bacar
 */
public class ProdutosGerenciamentoBebidasController implements Initializable {

    @FXML
    private TextField funcionario_nome;
    @FXML
    private Label erro_nome;
    @FXML
    private Label erro_bi;
    @FXML
    private TextField funcionario_endereco;
    @FXML
    private Label erro_endereco;
    @FXML
    private TextField funcionario_telefone1;
    @FXML
    private Label erro_telef1;
    @FXML
    private Label erro_telef2;
    @FXML
    private Label erro_cargo;
    @FXML
    private TextField funcionario_salario;
    @FXML
    private Label erro_salario;
    @FXML
    private TextField funcionario_usuario;
    @FXML
    private Label erro_usuario;
    @FXML
    private TextField funcionario_senha;
    @FXML
    private Label erro_senha;
    @FXML
    private Button btnEscolherFoto;
    @FXML
    private Button btn_func_adicionar;
    @FXML
    private StackPane stack_bebidas;
    @FXML
    private ImageView imagemBebida;
    
    private FileChooser escolherFoto;
    private File arquivo;
    private Stage stage;
    private Desktop computador = Desktop.getDesktop();
    private Image imagem;
    @FXML
    private Label log_usuario1;
    @FXML
    private Label log_nivelAcesso1;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        escolherFoto = new FileChooser();
        escolherFoto.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Todos Arquivos"," "),
                new FileChooser.ExtensionFilter("Imagens","*.png","*.jpg","*.gif"),
                new FileChooser.ExtensionFilter("Arquivos de Texto","*.txt")
        );
        
        
    }    

    @FXML
    private void voltarBtn(MouseEvent event) {
    }

    @FXML
    private void fechar(MouseEvent event) {
    }

    @FXML
    private void pesquisarFuncionario(ActionEvent event) {
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
    private void realceCampoSalario_ext(MouseEvent event) {
    }

    @FXML
    private void realceCampoSalario(MouseEvent event) {
    }

    @FXML
    private void escolherFoto(ActionEvent event) {
        stage = (Stage) stack_bebidas.getScene().getWindow();
        arquivo = escolherFoto.showOpenDialog(stage);
        
        
        if (arquivo != null) {
            System.out.println(""+arquivo.getAbsolutePath());
            imagem = new Image(arquivo.toURI().toString(),imagemBebida.getFitWidth(),imagemBebida.getFitHeight(),true,true);
            imagemBebida.setImage(imagem);
            imagemBebida.setPreserveRatio(true);
        }
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
    
}
