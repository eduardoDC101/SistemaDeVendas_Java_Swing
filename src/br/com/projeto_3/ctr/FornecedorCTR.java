/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_3.ctr;
import java.sql.ResultSet;
import br.com.projeto_3.dto.FornecedorDTO;
import br.com.projeto_3.dao.FornecedorDAO;
import br.com.projeto_3.dao.ConexaoDAO;
/**
 *
 * @author paulo
 */
public class FornecedorCTR {

    FornecedorDAO fornecedorDAO = new FornecedorDAO();
    
    public FornecedorCTR(){
        
    }
    
    public String inserirFornecedor(FornecedorDTO fornecedorDTO) {
        try{
            //chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if(fornecedorDAO.inserirFornecedor(fornecedorDTO)){
                return "Fornecedor Cadastro com Sucesso!!";
            }else{
                return "Fornecedor NÃO cadastrado";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO cadastrado!!";
        }
    }
    
    public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao) {
        
        ResultSet rs = null;
        
        rs = fornecedorDAO.consultarFornecedor(fornecedorDTO, opcao);
        
        return rs;
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }

    public String alterarFornecedor(FornecedorDTO fornecedorDTO) {
        try{
            //chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if(fornecedorDAO.alterarFornecedor(fornecedorDTO)){
                return "Fornecedor Alterado com Sucesso!!";
            }else{
                return "Fornecedor NÃO Alterado";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO alterado!!";
        }
    }

    public String excluirFornecedor(FornecedorDTO fornecedorDTO) {
        try{
            //chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if(fornecedorDAO.excluirFornecedor(fornecedorDTO)){
                return "Fornecedor Excluído com Sucesso!!";
            }else{
                return "Fornecedor NÃO Excluído";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO deletado!!";
        }
    }
}

