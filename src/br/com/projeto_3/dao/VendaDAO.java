/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_3.dao;
import br.com.projeto_3.dto.ClienteDTO;
import br.com.projeto_3.dto.VendaDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
/**
 *
 * @author paulo
 */
public class VendaDAO {
    
//    método construtor da classe
    public VendaDAO(){
    }
    private ResultSet rs = null;
    
    Statement stmt = null;
    Statement stmt1 = null;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    
    
    
    public boolean inserirVenda (VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable produtos){
        try{
            ConexaoDAO.ConnectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            stmt1 = ConexaoDAO.con.createStatement();
            
            String comando1 = "Insert into venda (dat_vend, val_vend, id_cli) values( "
                    + "to_date ('"+ date.format(vendaDTO.getDat_vend())+"', 'DD/MM/YYYY'), "
                    +vendaDTO.getVal_vend()+", "
                    +clienteDTO.getId_cli()+")";
            
           
            stmt.execute(comando1.toUpperCase(),Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            rs.next();
            for(int cont=0; cont<produtos.getRowCount(); cont++){
                String comando2 = "Insert into produto_venda (id_vend, id_prod, "
                        + "val_prod, qtd_prod) values ( "
                        + rs.getInt("id_vend")+", "
                        + produtos.getValueAt(cont, 0) + ", "
                        + produtos.getValueAt(cont, 2) + ", "
                        + produtos.getValueAt(cont, 3) + "); ";
               // System.out.println(comando2);
                stmt1.execute(comando2);
            }
            ConexaoDAO.con.commit();
             //fecha o statement
            stmt.close();
            stmt1.close();
            rs.close();
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
    }




