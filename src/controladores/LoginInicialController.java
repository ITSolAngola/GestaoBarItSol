/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import gestao.bar.api.constantes.Papel;
import gestao.bar.api.model.pessoal.Usuario;
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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author bacar
 */
public class LoginInicialController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtSenha;
    @FXML
    private StackPane stackLogin;
    
    public static String usuarioNome;
    public static Papel role;
    @FXML
    private Label erro_usuario;
    @FXML
    private Label erro_senha;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(MouseEvent event) {

        if (txtUsuario.getText().toString().equals("")) {
            erro_usuario.setText("Preencher o campo usuário *");  
            erro_senha.setText(""); 
    }else if (txtSenha.getText().toString().equals("")) {
            erro_usuario.setText(""); 
            erro_senha.setText("Preencher o campo senha *");
    }else{
        Stage administrador = new Stage();
        Parent root = null;
        
        UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
        
        List<Usuario> usuarios = new ArrayList<>();
        
        EntityManager entitymanager = FACTORY.createEntityManager();
        usuarios.addAll( usuarioCRUD.buscarTodos(entitymanager,Usuario.class) );
        entitymanager.close();
        
        Optional<Usuario> optionalUsuario = usuarios.stream().filter(usuario->usuario.isEstado()&&usuario.getNome().equals(txtUsuario.getText())
                                    && usuario.getSenha().equals(txtSenha.getText()))
                                    .findFirst();
        
        if( !optionalUsuario.isPresent() ){

            erro_usuario.setText("");
            erro_senha.setText("");
            
            erro_usuario.setText("Usuario ou senha incorrecta!*");
               
        }else{
            
            usuarioNome = optionalUsuario.get().getNome();
            role = optionalUsuario.get().getPapel();
            LogUsuario.logUsers.add(usuarioNome);
            LogUsuario.logUsers.add(String.valueOf(role));
            
            try {
                root = FXMLLoader.load(getClass().getResource("/visualizacao/Administrador.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(LoginInicialController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Stage current = (Stage) txtUsuario.getScene().getWindow();
            Scene scene = new Scene(root);
            administrador.setScene(scene);
            administrador.getIcons().add(new Image(LoginInicialController.class.getResourceAsStream("/imagens/prod_bebidas.JPG")));
            administrador.setMaximized(true);
            current.hide();
            administrador.show();
        }
            
        }
                }
        
        

    @FXML
    private void fechar(MouseEvent event) {

        MetodosComuns.mensagemFecharSistema(stackLogin);

    }

}
