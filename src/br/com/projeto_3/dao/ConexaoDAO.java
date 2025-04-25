/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_3.dao;
import java.sql.*;

/**
 *
 * @author paulo
 */
public class ConexaoDAO {
    
    /**
     * Criando um atributo tipo connection qye servira para guardar a conexao
     * com o banco de dados
     */
    public static Connection con = null;
    
    /**
     * Método construtor da classe
     */
    
    public ConexaoDAO(){
        
    }
    
    /**
     * Método que abre a conexão com o banco de dados é do tipo static 
     */
    
    public static void ConnectDB(){
        try{
            //dados para conectar com o banco de dados do postgres
            String dsn = "projeto_3";// nome do banco de dados (Igual criado ao postgres)
            String user = "postgres";// nome do tipo de banco, no caso o postgres
            String senha = "postdba";
            
            DriverManager.registerDriver(new org.postgresql.Driver());
            
            String url = "jdbc:postgresql://localhost:5432/"+dsn;
            
            con = DriverManager.getConnection(url, user, senha);
            
            con.setAutoCommit(false);
            
            if(con == null){
                System.out.println("Erro ao abrir o banco de dados");
                
            }
        }//fecha o try
        //Caso ocorra problema para abrir o banco de dados é emitido a mensagem no console.
        catch(Exception e){
            System.out.println("Problema ao abrir o banco de dados!"+
                    e.getMessage());
        }//Fecha o catch
    }//Fecha o método ConnectDB
    
    public static void CloseDB(){
        try{
            con.close();
        }//fecha o try
        //caso ocorra problemas para fechar o banco de dados é emitido a menagem no console.
    catch (Exception e){
        System.out.println("Problema ao fechar o banco de dados!" +
                e.getMessage());
    }//fecha o catch
    }//Fecha o método ColseDB
}//fecha a classe conexaoDAO
