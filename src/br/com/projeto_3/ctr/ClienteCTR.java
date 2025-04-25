/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_3.ctr;
import java.sql.ResultSet;
import br.com.projeto_3.dto.ClienteDTO;
import br.com.projeto_3.dao.ClienteDAO;
import br.com.projeto_3.dao.ConexaoDAO;

/**
 *
 * @author paulo
 */
public class ClienteCTR {

    ClienteDAO clienteDAO = new ClienteDAO();
    
    public ClienteCTR(){
        
    }
    
    public String inserirCliente(ClienteDTO clienteDTO) {
        try{
            //chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if(clienteDAO.inserirCliente(clienteDTO)){
                return "Cliente Cadastro com Sucesso!!";
            }else{
                return "Cliente NÃO cadastrado";
            }
        }//caso tenha algum erro no codigo acima é enviado para uma mensagem no
         //console com o que esta acontecendo
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO cadastrar!!";
        }
    }//Fecha o método de InserirCliente
    
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao) {
        
        ResultSet rs = null;
        
        rs = clienteDAO.consultarCliente(clienteDTO, opcao);
        
        return rs;
    }//fecha o método consultarCliente
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }//fecha o método CloseDB

    public String alterarCliente(ClienteDTO clienteDTO) {
        try{
            //chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if(clienteDAO.alterarCliente(clienteDTO)){
                return "Cliente Alterado com Sucesso!!";
            }else{
                return "Cliente NÃO Alterado";
            }
        }//caso tenha algum erro no codigo acima é enviado para uma mensagem no
         //console com o que esta acontecendo
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO alterador!!";
        }
    }//Fecha o método de alterarCliente

    public String excluirCliente(ClienteDTO clienteDTO) {
        try{
            //chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if(clienteDAO.excluirCliente(clienteDTO)){
                return "Cliente Excluído com Sucesso!!";
            }else{
                return "Cliente NÃO Excluido";
            }
        }//caso tenha algum erro no codigo acima é enviado para uma mensagem no
         //console com o que esta acontecendo
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO deletado!!";
        }
    }//Fecha o método de alterarCliente
    

}
