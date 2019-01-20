/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import gestao.bar.api.constantes.Papel;
import gestao.bar.api.model.pessoal.Endereco;
import gestao.bar.api.model.pessoal.Funcionario;
import gestao.bar.api.model.pessoal.Usuario;
import gestao.bar.api.operacaoCRUD.FuncionarioCRUD;
import gestao.bar.api.operacaoCRUD.UsuarioCRUD;
import static gestaobaritsol.GestaoBarItSol.FACTORY;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import modelo.FuncionarioDAO;

/**
 * FXML Controller class
 *
 * @author bacar
 */
public class PessoalGerenciamentoFuncionarioController implements Initializable {

    @FXML
    private StackPane stckPane_conteiner_funcionarios;
    @FXML
    private Label log_usuario;
    @FXML
    private Label log_nivelAcesso;
    @FXML
    private TextField funcionario_idPesquisa;
    @FXML
    private Label erro_pesquisa;
    @FXML
    private TextField funcionario_nome;
    @FXML
    private Label erro_nome;
    @FXML
    private TextField funcionario_bilheteIdent;
    @FXML
    private Label erro_bi;
    @FXML
    private DatePicker funcionario_data_nasc;
    @FXML
    private Label erro_dataNasc;
    private TextField funcionario_endereco;
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
    private ComboBox<Papel> funcionario_cargo;
    @FXML
    private Label erro_cargo;
    private TextField funcionario_salario;
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
    private Button btn_func_adicionar;
    @FXML
    private TableColumn<Funcionario, Integer> col_Cod_Funcionário;
    @FXML
    private TableColumn<Funcionario, String> col_Nome;
    @FXML
    private TableColumn<Funcionario, String> col_BI;
    @FXML
    private TableColumn<Funcionario, ?> col_Data_Nascimento;
    @FXML
    private TableColumn<Funcionario, String> col_Endereco;
    @FXML
    private TableColumn<Funcionario, Integer> col_Telefone_Principal;
    @FXML
    private TableColumn<Funcionario, Integer> col_Telefone_Opcional;
    @FXML
    private TableColumn<Funcionario, String> col_Cargo;
    @FXML
    private TableColumn<Funcionario, Double> col_Salario;
    @FXML
    private TableColumn<Funcionario, String> col_usuario;
    @FXML
    private TableColumn<Funcionario, String> col_senha;
    @FXML
    private TableView<FuncionarioDAO> tabelaFuncionario;

    private Logger log = Logger.getLogger(getClass().getName());

    //--------------------------------------------------------------------------------------------
    //conexao
    //para pegar todas as funcoes
    private ObservableList<FuncionarioDAO> funcionarioList;

    Funcionario funcionario = new Funcionario();

    private ObservableList<Papel> acesso;

    Map map;

    FuncionarioCRUD funcionarioCRUD = new FuncionarioCRUD();
    @FXML
    private TextField funcionario_pais;
    @FXML
    private TextField funcionario_municipio;
    @FXML
    private TextField funcionario_rua;
    @FXML
    private TextField funcionario_casa;
    @FXML
    private RadioButton rd_masculino;
    @FXML
    private ToggleGroup radio;
    @FXML
    private RadioButton rd_feminino;
    @FXML
    private Label erro_casa;
    @FXML
    private Label erro_municipio;
    @FXML
    private Label erro_pais;
    @FXML
    private Label erro_rua;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        log_usuario.setText(LogUsuario.logUsers.get(0));
        log_nivelAcesso.setText(LogUsuario.logUsers.get(1));

        //conexao = DBConnection.getConnection();
        acesso = FXCollections.observableArrayList();

        acesso.add(Papel.ADMIN);
        acesso.add(Papel.SUPERVISOR);
        acesso.add(Papel.VENDEDOR);

        funcionario_cargo.setItems(acesso);

        mudarColunaTabFuncionario();
        funcionarioList = FXCollections.observableArrayList();
        carregarDadosFuncionarioBaseDados();
        mudarColunaTabelaParaTextFild();
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

        Stage current = (Stage) stckPane_conteiner_funcionarios.getScene().getWindow();
        Scene scene = new Scene(root);

        administradorHome.setScene(scene);
        administradorHome.setMaximized(true);
        current.hide();
        administradorHome.show();

    }

    @FXML
    private void fechar(MouseEvent event) {
        MetodosComuns.mensagemSairTerminarLog(stckPane_conteiner_funcionarios);
    }


    @FXML
    private void registrarFuncionario(ActionEvent event) throws SQLException {

        ArrayList<String> telef;
        
        boolean txtNomeVazio = ValidacaoCampos.textFieldNaoEstaVazia(funcionario_nome, erro_nome, "Campo Incorrecto *");
        boolean txtBiVazio = ValidacaoCampos.textFieldNaoEstaVaziaBi(funcionario_bilheteIdent, erro_bi, "Campo Incorrecto *");
        boolean txtDataNasc = ValidacaoCampos.campoData(funcionario_data_nasc, erro_dataNasc, "Preencha o campo *");
        boolean txtPais = ValidacaoCampos.textFieldNaoEstaVazia(funcionario_pais, erro_pais, "Campo Incorrecto *");
        boolean txtRua = ValidacaoCampos.textFieldNaoEstaVazia(funcionario_rua, erro_rua, "Em falta *");
        boolean txtMunicipio = ValidacaoCampos.textFieldNaoEstaVazia(funcionario_municipio, erro_municipio, "Campo Incorrecto *");
        boolean txtCasa = ValidacaoCampos.textFieldNaoEstaVaziaTelef(funcionario_casa, erro_casa, "Em falta *");
        boolean txtTelef1 = ValidacaoCampos.textFieldNaoEstaVaziaTelef(funcionario_telefone1, erro_telef1, "Campo incorrecto *");
        boolean txtTelef2 = ValidacaoCampos.textFieldNaoEstaVaziaTelef(funcionario_telefone2, erro_telef2, "Campo incorrecto *");
        boolean txtCargo = ValidacaoCampos.comboBoxValor(funcionario_cargo, erro_cargo, "Campo Incorrecto *");
   
        
        if (txtNomeVazio && txtBiVazio && txtPais && txtRua && txtMunicipio && txtCasa && txtTelef1 && txtTelef2
                && txtDataNasc && txtCargo) {

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionario_nome.getText());
        funcionario.setnBilhete(funcionario_bilheteIdent.getText());
        Endereco endereco = new Endereco(funcionario_pais.getText(),
                funcionario_municipio.getText(), funcionario_rua.getText(),
                funcionario_casa.getText());
        funcionario.setEndereco(endereco);
        funcionario.setDataNascimento(funcionario_data_nasc.getValue());
        if (rd_feminino.isSelected()) {

            funcionario.setSexo("Feminino");
        } else {
            funcionario.setSexo("Masculino");
        }
        // funcionario.setDataNascimento(java.sql.Date.valueOf(funcionario_data_nasc.getValue()).toLocalDate());
        funcionario.getContactos().add(funcionario_telefone1.getText());
        funcionario.getContactos().add(funcionario_telefone2.getText());
        // funcionario.setSalario(Double.valueOf(funcionario_salario.getText()));
        Usuario usuario = new Usuario();
        usuario.setNome(funcionario_usuario.getText());
        usuario.setSenha(funcionario_senha.getText());
        usuario.setEstado(true);
        usuario.setPapel(funcionario_cargo.getValue());

        //funcionario.setUsuario(usuario);
        try {
            UsuarioCRUD cRUD = new UsuarioCRUD();

            EntityManager entityManager = FACTORY.createEntityManager();
            Funcionario funcionarioNovo = funcionarioCRUD.novo(funcionario, entityManager);

            if (!usuario.getNome().isEmpty()) {
            Usuario usuario1 = cRUD.novo(usuario, entityManager);
            funcionario.setUsuario(usuario1);
            }else{
                funcionario.setUsuario(null);
            }
            
            funcionarioCRUD.novo(funcionario, entityManager);
            entityManager.close();
            limpar();
            carregarDadosFuncionarioBaseDados();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        
    }

    @FXML
    private void atualizar(MouseEvent event) {

        boolean txtNomeVazio = ValidacaoCampos.textFieldNaoEstaVazia(funcionario_nome, erro_nome, "Campo Incorrecto *");
        boolean txtBiVazio = ValidacaoCampos.textFieldNaoEstaVaziaBi(funcionario_bilheteIdent, erro_bi, "Campo Incorrecto *");
        boolean txtDataNasc = ValidacaoCampos.campoData(funcionario_data_nasc, erro_dataNasc, "Preencha o campo *");
        boolean txtPais = ValidacaoCampos.textFieldNaoEstaVazia(funcionario_pais, erro_pais, "Campo Incorrecto *");
        boolean txtRua = ValidacaoCampos.textFieldNaoEstaVazia(funcionario_rua, erro_rua, "Em falta *");
        boolean txtMunicipio = ValidacaoCampos.textFieldNaoEstaVazia(funcionario_municipio, erro_municipio, "Campo Incorrecto *");
        boolean txtCasa = ValidacaoCampos.textFieldNaoEstaVaziaTelef(funcionario_casa, erro_casa, "Em falta *");
        boolean txtTelef1 = ValidacaoCampos.textFieldNaoEstaVaziaTelef(funcionario_telefone1, erro_telef1, "Campo incorrecto *");
        boolean txtTelef2 = ValidacaoCampos.textFieldNaoEstaVaziaTelef(funcionario_telefone2, erro_telef2, "Campo incorrecto *");
        boolean txtCargo = ValidacaoCampos.comboBoxValor(funcionario_cargo, erro_cargo, "Campo Incorrecto *");
   
        
        if (txtNomeVazio && txtBiVazio && txtPais && txtRua && txtMunicipio && txtCasa && txtTelef1 && txtTelef2
                && txtDataNasc && txtCargo) {
            
        }

    }

    @FXML
    private void listarFuncionario(MouseEvent event) {
        carregarDadosFuncionarioBaseDados();
        limparErros();
      
    }

    @FXML
    private void limparCampos(MouseEvent event) {
        limpar();

    }

    public void limparErros(){
        
        String textoNulo = "";
        
        erro_pesquisa.getText();
        erro_nome.getText();
        erro_bi.getText();
        erro_dataNasc.getText();
        erro_endereco.getText();
        erro_telef1.getText();
        erro_telef2.getText();
        erro_cargo.getText();
        erro_usuario.getText();
        erro_senha.getText();
        erro_pais.getText();
        erro_municipio.getText();
        erro_rua.getText();
        erro_casa.getText();
        
        erro_pesquisa.setText(textoNulo);
        erro_nome.setText(textoNulo);
        erro_bi.setText(textoNulo);
        erro_pais.setText(textoNulo);
        erro_municipio.setText(textoNulo);
        erro_rua.setText(textoNulo);
        erro_cargo.setText(textoNulo);
        erro_dataNasc.setText(textoNulo);
        erro_endereco.setText(textoNulo);
        erro_telef1.setText(textoNulo);
        erro_telef2.setText(textoNulo);
        erro_casa.setText(textoNulo);
//        erro_salario.setText(textoNulo);
        erro_usuario.setText(textoNulo);
        erro_senha.setText(textoNulo);
    }
    
    public void limpar() {

        String textoNulo = "";

        //Apagar valores no campo de texto , primeiro recuperar depois apagar
        funcionario_idPesquisa.getText();
        funcionario_nome.getText();
        funcionario_bilheteIdent.getText();
        funcionario_telefone1.getText();
        funcionario_telefone2.getText();
        funcionario_cargo.getValue();
        funcionario_pais.getText();
        funcionario_rua.getText();
        funcionario_casa.getText();
        funcionario_municipio.getText();
        //funcionario_salario.getText();
        funcionario_usuario.getText();
        funcionario_senha.getText();

        funcionario_idPesquisa.setText(textoNulo);
        funcionario_idPesquisa.setDisable(false);
        funcionario_nome.setText(textoNulo);
        funcionario_bilheteIdent.setText(textoNulo);
        funcionario_data_nasc.setValue(null);
        funcionario_pais.setText(textoNulo);
        funcionario_rua.setText(textoNulo);
        funcionario_municipio.setText(textoNulo);
        funcionario_casa.setText(textoNulo);
        funcionario_telefone1.setText(textoNulo);
        funcionario_telefone2.setText(textoNulo);
        
        funcionario_cargo.setValue(null);
        //funcionario_salario.setText(null);
        funcionario_usuario.setText(textoNulo);
        funcionario_senha.setText(textoNulo);

        //Apagar mensagens de erro, primeiro recuperar depois apagar
        erro_pesquisa.getText();
        erro_nome.getText();
        erro_bi.getText();
        erro_dataNasc.getText();
        erro_endereco.getText();
        erro_telef1.getText();
        erro_telef2.getText();
        erro_cargo.getText();
        erro_usuario.getText();
        erro_senha.getText();
        erro_pais.getText();
        erro_municipio.getText();
        erro_rua.getText();
        erro_casa.getText();
        
        erro_pesquisa.setText(textoNulo);
        erro_nome.setText(textoNulo);
        erro_bi.setText(textoNulo);
        erro_pais.setText(textoNulo);
        erro_municipio.setText(textoNulo);
        erro_rua.setText(textoNulo);
        erro_cargo.setText(textoNulo);
        erro_dataNasc.setText(textoNulo);
        erro_endereco.setText(textoNulo);
        erro_telef1.setText(textoNulo);
        erro_telef2.setText(textoNulo);
        erro_casa.setText(textoNulo);
//        erro_salario.setText(textoNulo);
        erro_usuario.setText(textoNulo);
        erro_senha.setText(textoNulo);

    }

    @FXML
    private void pesquisarFuncionario(ActionEvent event) throws SQLException {

    }

    private void mudarColunaTabFuncionario() {
        //pegar osvalores para listar na tabela funcionario
        col_Cod_Funcionário.setCellValueFactory(new PropertyValueFactory<>("idfun"));
        col_Nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        col_BI.setCellValueFactory(new PropertyValueFactory<>("i"));
        col_Data_Nascimento.setCellValueFactory(new PropertyValueFactory<>("dataNasc"));
        col_Endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        col_Telefone_Principal.setCellValueFactory(new PropertyValueFactory<>("telefone1"));
        col_Telefone_Opcional.setCellValueFactory(new PropertyValueFactory<>("telefone2"));
        col_Cargo.setCellValueFactory(new PropertyValueFactory<>("tipoUsuario"));
        col_Salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        col_usuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        col_senha.setCellValueFactory(new PropertyValueFactory<>("senha"));

    }

    private void carregarDadosFuncionarioBaseDados() {
        funcionarioList.clear();
        try {
            
            EntityManager entityManager = FACTORY.createEntityManager();
            List<FuncionarioDAO> listFuncionario = funcionarioCRUD.buscarTodos(entityManager).stream()
                                                  .map(funcionario -> new FuncionarioDAO(
                                                          funcionario.getId().intValue(), funcionario.getNome(), funcionario.getnBilhete(), 
                                                          funcionario.getDataNascimento(), funcionario.getEndereco().getPais(),
                                                          0, 0, 0, "rtyui", "", "Supervisos"))
                                                            .collect(Collectors.toList());
            
            
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioList.addAll(listFuncionario);
            tabelaFuncionario.setItems(funcionarioList);
        } catch (Exception e) {
            Logger.getLogger(PessoalGerenciamentoFuncionarioController.class.getName()).log(Level.SEVERE, null, e);
        }
        
         
    }

    private void mudarColunaTabelaParaTextFild() {
        tabelaFuncionario.setOnMouseClicked(e -> {
         
        });
    }



}
