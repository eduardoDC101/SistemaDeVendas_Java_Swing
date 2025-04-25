/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_3.dao;
import java.sql.*;
import br.com.projeto_3.dto.ProdutoDTO;
import br.com.projeto_3.dto.FornecedorDTO;
import java.text.SimpleDateFormat;

/**
 *
 * @author paulo
 */
public class ProdutoDAO {
  
    
    public ProdutoDAO(){
        
    }
    
    //Atributo do tipo resultset utilizando para realizar consultas
    private ResultSet rs = null;
    //manipular o banco de dados
    private Statement stmt = null;


public boolean inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
    try{
        ConexaoDAO.ConnectDB();
        
        stmt = ConexaoDAO.con.createStatement();
        
        String comando = "Insert into produto (nome_prod, desc_prod, cod_bar_prod, "
                + "p_custo_prod, p_venda_prod, id_for) values( "
                +"'"+ produtoDTO.getNome_prod()+"', "
                +"'"+ produtoDTO.getDesc_prod()+"', "
                +"'"+ produtoDTO.getCod_bar_prod()+"', "
                +produtoDTO.getP_custo_prod()+", "
                +produtoDTO.getP_venda_prod()+", "
                +fornecedorDTO.getId_for()+") ";
        
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
    
public boolean alterarProduto (ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
    try{
        ConexaoDAO.ConnectDB();
        
        stmt = ConexaoDAO.con.createStatement();
        
        String comando = "Update produto set "
                +"nome_prod = '"+produtoDTO.getNome_prod()+"', "
                +"desc_prod = '"+produtoDTO.getDesc_prod()+"', "
                +"cod_bar_prod = '"+produtoDTO.getCod_bar_prod()+"', "
                +"p_custo_prod = "+produtoDTO.getP_custo_prod()+", "
                +"p_venda_prod = "+produtoDTO.getP_venda_prod()+", "
                +"id_for = "+fornecedorDTO.getId_for()+" "
                +"where id_prod = "+produtoDTO.getId_prod();
   
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

public boolean excluirProduto(ProdutoDTO produtoDTO){
        //chama o metodo que esta na classe conexaoDAO
        try{
        ConexaoDAO.ConnectDB();
        
        stmt = ConexaoDAO.con.createStatement();
        
        String comando = "Delete from produto where id_prod = "+produtoDTO.getId_prod();
        
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
    }

public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao){

    try{
        //chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
        ConexaoDAO.ConnectDB();
        //Cria o Statement que responsavel por executar alguma coisa no banco de dados
        stmt = ConexaoDAO.con.createStatement();
        //Comando SQL
        String comando = "";
        
        switch(opcao){
            case 1:
                comando = "Select p.* "
                        + "from produto p "
                        + "where p.nome_prod ilike '"+produtoDTO.getNome_prod()+"%' "
                        + "order by p.nome_prod";
            break;
            case 2:
                comando = "Select p.*, f.nome_for, f.id_for "
                        + "from produto p, fornecedor f "
                        + "where p.id_for = f.id_for and p.id_prod = "+produtoDTO.getId_prod();
            break;
        }
        //execute o comando SQL no banco de dados;
        rs = stmt.executeQuery(comando.toUpperCase());
        return rs;
    }
    catch (Exception e){
        System.out.println(e.getMessage());
        return rs;
    }
    }
}


    

