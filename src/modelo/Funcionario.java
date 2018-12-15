/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author bacar
 */
public class Funcionario {
    
    private int idfun;
    private String nome;
    private String bi;
    private Date dataNasc;
    private String endereco;
    private int telefone1;
    private int telefone2;
    private double salario;
    private String usuario;
    private String senha;
    private String tipoUsuario;

    public Funcionario(int idfun, String nome, String bi, Date dataNasc, String endereco, int telefone1, int telefone2, double salario, String usuario, String senha, String tipoUsuario) {
        this.idfun = idfun;
        this.nome = nome;
        this.bi = bi;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.salario = salario;
        this.usuario = usuario;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }
    
    

 

    public Funcionario() {
        
    }

    public int getIdfun() {
        return idfun;
    }

    public void setIdfun(int idfun) {
        this.idfun = idfun;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(int telefone1) {
        this.telefone1 = telefone1;
    }

    public int getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(int telefone2) {
        this.telefone2 = telefone2;
    }


    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
    
    
}
