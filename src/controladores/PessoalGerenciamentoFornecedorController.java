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
    private Label erro_nome;
    @FXML
    private Label erro_telef1;
    @FXML
    private Label erro_telef2;
    @FXML
    private Button btn_func_adicionar;
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
    @FXML
    private TextField fornecedor_nome;
    @FXML
    private TextField fornecedor_pais;
    @FXML
    private TextField fornecedor_municipio;
    @FXML
    private TextField fornecedor_rua;
    @FXML
    private TextField fornecedor_telefone1;
    @FXML
    private TextField fornecedor_telefone2;
    @FXML
    private TextField fornecedor_idPesquisa;
    @FXML
    private Label erro_pais;
    @FXML
    private Label erro_municipio;
    @FXML
    private Label erro_rua;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        log_usuario.setText(LogUsuario.logUsers.get(0));
        log_nivelAcesso.setText(LogUsuario.logUsers.get(1));
        
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
         MetodosComuns.mensagemSairTerminarLog(stckPane_conteiner_forncedor);
    }


    @FXML
    private void pesquisarFuncionario(ActionEvent event) {
        
         boolean txtPesquisa = ValidacaoCampos.textFieldNaoEstaVazia(fornecedor_idPesquisa, erro_pesquisa, "Campo Incorrecto *");
         
         if (txtPesquisa ) {
            
        }
        
    }

    @FXML
    private void adicionarFornecedor(MouseEvent event) {
        
        boolean txtNomeVazio = ValidacaoCampos.textFieldNaoEstaVazia(fornecedor_nome, erro_nome, "Campo Incorrecto *");
        boolean txtPais = ValidacaoCampos.textFieldNaoEstaVazia(fornecedor_pais, erro_pais, "Campo Incorrecto *");
        boolean txtRua = ValidacaoCampos.textFieldNaoEstaVazia(fornecedor_rua, erro_rua, "Campo Incorrecto *");
        boolean txtMunicipio = ValidacaoCampos.textFieldNaoEstaVazia(fornecedor_municipio, erro_municipio, "Campo Incorrecto *");
        boolean txtTelef = ValidacaoCampos.textFieldNaoEstaVaziaTelef(fornecedor_telefone1, erro_telef1, "Campo Incorrecto *");
        boolean txtTelef1 = ValidacaoCampos.textFieldNaoEstaVaziaTelef(fornecedor_telefone2, erro_telef2, "Campo Incorrecto *");
        
        if (txtNomeVazio && txtPais && txtRua && txtMunicipio && txtTelef && txtTelef1 ) {
            
        }
        
    }

    @FXML
    private void atualizarFornecedor(MouseEvent event) {
        
         boolean txtNomeVazio = ValidacaoCampos.textFieldNaoEstaVazia(fornecedor_nome, erro_nome, "Campo Incorrecto *");
        boolean txtPais = ValidacaoCampos.textFieldNaoEstaVazia(fornecedor_pais, erro_pais, "Campo Incorrecto *");
        boolean txtRua = ValidacaoCampos.textFieldNaoEstaVazia(fornecedor_rua, erro_rua, "Campo Incorrecto *");
        boolean txtMunicipio = ValidacaoCampos.textFieldNaoEstaVazia(fornecedor_municipio, erro_municipio, "Campo Incorrecto *");
        boolean txtTelef = ValidacaoCampos.textFieldNaoEstaVaziaTelef(fornecedor_telefone1, erro_telef1, "Campo Incorrecto *");
        boolean txtTelef1 = ValidacaoCampos.textFieldNaoEstaVaziaTelef(fornecedor_telefone2, erro_telef2, "Campo Incorrecto *");
        
        if (txtNomeVazio && txtPais && txtRua && txtMunicipio && txtTelef && txtTelef1 ) {
            
        }
        
    }

    @FXML
    private void listarFornecedor(MouseEvent event) {
    }

    @FXML
    private void limparCamposFornecedor(MouseEvent event) {
        limpar();
    }
    
    
      public void limpar() {

        String textoNulo = "";

        //Apagar valores no campo de texto , primeiro recuperar depois apagar
        fornecedor_idPesquisa.getText();
        fornecedor_nome.getText();
        fornecedor_pais.getText();
        fornecedor_rua.getText();
        fornecedor_municipio.getText();
        fornecedor_telefone1.getText();
        fornecedor_telefone2.getText();
        
        
        fornecedor_idPesquisa.setText(textoNulo);
        fornecedor_nome.setText(textoNulo);
        fornecedor_pais.setText(textoNulo);
        fornecedor_rua.setText(textoNulo);
        fornecedor_municipio.setText(textoNulo);
        fornecedor_telefone1.setText(textoNulo);
        fornecedor_telefone2.setText(textoNulo);

        

        //Apagar mensagens de erro, primeiro recuperar depois apagar
        erro_pesquisa.getText();
        erro_nome.getText();
        erro_pais.getText();
        erro_rua.getText();
        erro_municipio.getText();
        erro_telef1.getText();
        erro_telef2.getText();
        
        erro_pesquisa.setText(textoNulo);
        erro_nome.setText(textoNulo);
        erro_pais.setText(textoNulo);
        erro_rua.setText(textoNulo);
        erro_municipio.setText(textoNulo);
        erro_telef1.setText(textoNulo);
        erro_telef2.setText(textoNulo);

    }

    
}
