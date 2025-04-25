/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_3.dao;
import br.com.projeto_3.dto.ClienteDTO;
import java.sql.*;

/**
 *
 * @author paulo
 */
public class ClienteDAO {

/**
 * Método construtor da classe
 */    
    public ClienteDAO(){
    }
    //Atributo do tipo resultset utilizando para realizar consultas
    private ResultSet rs = null;
    //manipular o banco de dados
    private Statement stmt = null;

    public boolean inserirCliente(ClienteDTO clienteDTO){
        //chama o metodo que esta na classe conexaoDAO
        try{
        ConexaoDAO.ConnectDB();
        
        stmt = ConexaoDAO.con.createStatement();
        
        String comando = "Insert into cliente (nome_cli, logradouro_cli, numero_cli, "
                +"bairro_cli, cidade_cli, estado_cli, cep_cli, cpf_cli, rg_cli) values ( "
                +"'"+clienteDTO.getNome_cli()+"', "
                +"'"+clienteDTO.getLogradouro_cli()+"',"
                +clienteDTO.getNumero_cli()+", "
                +"'"+clienteDTO.getBairro_cli()+"', "
                +"'"+clienteDTO.getCidade_cli()+"', "
                +"'"+clienteDTO.getEstado_cli()+"', "
                +"'"+clienteDTO.getCep_cli()+"', "
                +"'"+clienteDTO.getCpf_cli()+"', "
                +"'"+clienteDTO.getRg_cli()+"') ";
        
        //Executa o comando no banco de dados
        stmt.execute(comando.toUpperCase());
            
            //Da um commit (Registrar) no bando de dados
            ConexaoDAO.con.commit();
            //fecha o statement
            stmt.close();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    
        
    } 
    
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao){

    try{
        //chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
        ConexaoDAO.ConnectDB();
        //Cria o Statement que responsavel por executar alguma coisa no banco de dados
        stmt = ConexaoDAO.con.createStatement();
        //Comando SQL
        String comando = "";
        switch(opcao){
            case 1:
                comando = "Select c.* "
                        + "from cliente c "
                        + "where c.nome_cli like '"+clienteDTO.getNome_cli()+"%' "
                        + "order by c.nome_cli";
            break;
            case 2:
                comando = "Select c.* "
                        + "from cliente c "
                        + "where c.id_cli = "+clienteDTO.getId_cli();
            break;
            case 3:
                comando = "Select c.id_cli, c.nome_cli "
                        + "from cliente c ";
            break; 
        }
        //execute o comando SQL no banco de dados;
        rs = stmt.executeQuery(comando.toUpperCase());
        return rs;
    }//caso tenha algum erro no código acima é enviado uma mensagem no
     //console com o que esta acontecendo
    
        catch (Exception e){
        System.out.println(e.getMessage());
        return rs;
        }
    
    }//fecha o método consultarCliente 
     
    public boolean alterarCliente(ClienteDTO clienteDTO){
        //chama o metodo que esta na classe conexaoDAO
        try{
        ConexaoDAO.ConnectDB();
        
        stmt = ConexaoDAO.con.createStatement();
        
        String comando = "Update cliente set "
                + "nome_cli = '"+clienteDTO.getNome_cli()+"', "
                + "logradouro_cli = '"+clienteDTO.getLogradouro_cli()+"',"
                + "numero_cli = "+clienteDTO.getNumero_cli()+", "
                + "bairro_cli = '"+clienteDTO.getBairro_cli()+"', "
                + "cidade_cli = '"+clienteDTO.getCidade_cli()+"', "
                + "estado_cli = '"+clienteDTO.getEstado_cli()+"', "
                + "cep_cli = '"+clienteDTO.getCep_cli()+"', "
                + "cpf_cli = '"+clienteDTO.getCpf_cli()+"', "
                + "rg_cli = '"+clienteDTO.getRg_cli()+"' "
                + "where id_cli = "+clienteDTO.getId_cli();
        
        //Executa o comando no banco de dados
        stmt.execute(comando.toUpperCase());
            
            //Da um commit (Registrar) no bando de dados
            ConexaoDAO.con.commit();
            //fecha o statement
            stmt.close();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    
}//fecha classe ClienteDAO
    
    public boolean excluirCliente(ClienteDTO clienteDTO){
        //chama o metodo que esta na classe conexaoDAO
        try{
        ConexaoDAO.ConnectDB();
        
        stmt = ConexaoDAO.con.createStatement();
        
        String comando = "Delete from cliente where id_cli = "+clienteDTO.getId_cli();
        
        //Executa o comando no banco de dados
        stmt.execute(comando);
            
            //Da um commit (Registrar) no bando de dados
            ConexaoDAO.con.commit();
            //fecha o statement
            stmt.close();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    
}//fecha classe ClienteDAO
}

