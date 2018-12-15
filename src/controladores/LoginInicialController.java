/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import conexao.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
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
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(MouseEvent event) {
        
            Stage administrador=new Stage();
                        Parent root=null;
                        
                        LogUsuario.logUsers.add("AD");
                        LogUsuario.logUsers.add("Administrador");
                        
                        try {
                            root=FXMLLoader.load(getClass().getResource("/visualizacao/Administrador.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(LoginInicialController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        Stage current=(Stage)txtUsuario.getScene().getWindow();
                        Scene scene=new Scene(root);
                        administrador.setScene(scene);
                        administrador.getIcons().add(new Image(LoginInicialController.class.getResourceAsStream("/imagens/prod_bebidas.JPG")));
                        administrador.setMaximized(true);
                        //administrador.initStyle(StageStyle.TRANSPARENT);
                       
                                
                        current.hide();
                        
                        administrador.show();
        
          /*
        
         if(txtUsuario.getText().toString().equals("")){
            Image image=new Image("imagens/delete.png");
                Notifications notification=Notifications.create()
                        .title("Error")
                        .text("Precisa preencher o campo usuário")
                        .hideAfter(Duration.seconds(4))
                        .position(Pos.BOTTOM_LEFT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
        }else if(txtSenha.getText().toString().equals("")){
            Image image=new Image("imagens/delete.png");
                Notifications notification=Notifications.create()
                        .title("Error")
                        .text("Precisa preencher o campo senha")
                        .hideAfter(Duration.seconds(4))
                        .position(Pos.BOTTOM_LEFT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
                
        }else{
            
            
            boolean isExist=false;
            
        String usuario_senha="";
        String usuario_tipo="";
        String usuario = "";
        String sql="select *from usuario where usuario='"+txtUsuario.getText().toString().trim()+"'";
        
        Connection connection=DBConnection.getConnection();
        
        try {

            PreparedStatement ps=(PreparedStatement)connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                isExist=true;
                usuario_senha=rs.getString(3);
                usuario =rs.getString(2);
                usuario_tipo=rs.getString(4);
            }
            
            if(isExist){
                
              if(txtSenha.getText().toString().trim().equals(usuario_senha)){
                    
                    if(usuario_tipo.equals("Administrador")){
                       //if user admin --> Admin Screen 
                       
                        Stage administrador=new Stage();
                        Parent root=null;
                        
                        LogUsuario.logUsers.add(txtUsuario.getText());
                        LogUsuario.logUsers.add("Administrador");
                        
                        try {
                            root=FXMLLoader.load(getClass().getResource("/visualizacao/Administrador.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(LoginInicialController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        Stage current=(Stage)txtUsuario.getScene().getWindow();
                        Scene scene=new Scene(root);
                        administrador.setScene(scene);
                        administrador.getIcons().add(new Image(LoginInicialController.class.getResourceAsStream("/imagens/prod_bebidas.JPG")));
                        administrador.setMaximized(true);
                        //administrador.initStyle(StageStyle.TRANSPARENT);
                       
                                
                        current.hide();
                        
                        administrador.show();
                        
                        Image image=new Image("imagens/mooo.png");
                Notifications notification=Notifications.create()
                        .title("Bem-Vindo")
                        .text("Olá " + usuario + " Bem-vindo ao sistema ")
                        .hideAfter(Duration.seconds(4))
                        .position(Pos.BOTTOM_LEFT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
                        
                        
                    }else{
                        //if usuario normal --> TelaInicial Caixa
                        
                        
                        Stage caixaVendedor=new Stage();
                        Parent root=null;
                        
                        try {
                            root=FXMLLoader.load(getClass().getResource(""));
                        } catch (IOException ex) {
                            Logger.getLogger(LoginInicialController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Stage current=(Stage)txtUsuario.getScene().getWindow();
                        Scene scene=new Scene(root,1366,730);
                        
                        caixaVendedor.setScene(scene);
                        caixaVendedor.initStyle(StageStyle.TRANSPARENT);
                        
                        current.hide();
                        
                        caixaVendedor.show();
                    }
                    
                }else{
                
                Image image=new Image("imagens/delete.png");
                Notifications notification=Notifications.create()
                        .title("Error")
                        .text("Verifica a senha do usuário")
                        .hideAfter(Duration.seconds(4))
                        .position(Pos.BOTTOM_LEFT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
              }
            }else{
                
                Image image=new Image("imagens/delete.png");
                Notifications notification=Notifications.create()
                        .title("Error")
                        .text("Verifica o nome de usuário")
                        .hideAfter(Duration.seconds(4))
                        .position(Pos.BOTTOM_LEFT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginInicialController.class.getName()).log(Level.SEVERE, null, ex.getCause());
        }
        
        
        }
        
        */
        
       
    }

    @FXML
    private void fechar(MouseEvent event) {
        
        MetodosComuns.mensagemFecharSistema(stackLogin);
        
    }
    
}
