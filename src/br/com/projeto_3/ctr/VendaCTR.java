/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_3.ctr;
import br.com.projeto_3.dto.ClienteDTO;
import br.com.projeto_3.dto.VendaDTO;
import br.com.projeto_3.dao.ConexaoDAO;
import br.com.projeto_3.dao.VendaDAO;
import javax.swing.JTable;


/**
 *
 * @author paulo
 */
public class VendaCTR {
    VendaDAO vendaDAO = new VendaDAO();

    public VendaCTR() {
    }
    
    public String inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable produtos){
        try{
            
        if(vendaDAO.inserirVenda(vendaDTO, clienteDTO, produtos)){
                return "Venda Cadastrada com Sucesso!!!";
        } else {
                return "Venda não Cadastrada!!!";        
        }
    }catch (Exception e){
            System.out.println(e.getMessage());
            return "Venda não Cadastrada";
        }
    }
    
    public void CloseDB (){
        ConexaoDAO.CloseDB();
}
}