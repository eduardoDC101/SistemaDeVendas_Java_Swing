/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_3.ctr;
import br.com.projeto_3.dto.ProdutoDTO;
import br.com.projeto_3.dto.FornecedorDTO;
import br.com.projeto_3.dao.ProdutoDAO;
import br.com.projeto_3.dao.ConexaoDAO;
import java.sql.ResultSet;
/**
 *
 * @author paulo
 */
public class ProdutoCTR {
    
    ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public ProdutoCTR(){
    
    }
    
    public String inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try{
            //chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if(produtoDAO.inserirProduto(produtoDTO, fornecedorDTO)){
                return "Produto Cadastro com Sucesso!!";
            }else{
                return "Produto NÃO cadastrado";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO cadastrado!!";
        }
    }
    
    
    
    public String alterarProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try {
            // chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (produtoDAO.alterarProduto(produtoDTO, fornecedorDTO)) {
                return "Produto Alterado com Sucesso!!";
            } else {
                return "Produto NÃO Alterado";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO alterado!!";
        }
    }
    
    public String excluirProduto(ProdutoDTO produtoDTO){
        try {
            // chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (produtoDAO.excluirProduto(produtoDTO)) {
                return "Produto excluido com Sucesso!!";
            } else {
                return "Produto NÃO excluido";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO excluido!!";
        }
    }

    
    
    public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao) {
        
        ResultSet rs = null;
        
        rs = produtoDAO.consultarProduto(produtoDTO, opcao);
        
        return rs;
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
    
}
