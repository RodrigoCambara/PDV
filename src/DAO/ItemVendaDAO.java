/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JDBC.ConnectionFactory;
import java.sql.Connection;
import Model.itensVendaClass;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ItemVendaDAO {
    
     //Conexão
    private Connection con;

    public ItemVendaDAO() {

        this.con = new ConnectionFactory().getConnection();
    }
    
    // Método cadastrar itens
    public void cadastrarItem(itensVendaClass obj){
        
         try {

            //1 passo: Criar o comando SQL
            String sql = "INSERT INTO tb_itensvendas (venda_id,produto_id,qtd,subtotal) "
                    + "values(?,?,?,?)";

            //2 passo: conectar o banco de dados e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getVenda().getId());
            stmt.setInt(2, obj.getProduto().getId());
            stmt.setInt( 3, obj.getQtd());
            stmt.setDouble(4, obj.getSubtotal());          

            //3 passo: Executar o comando SQL
            stmt.execute();
            stmt.close();

            //JOptionPane.showMessageDialog(null, "Item registrado com sucesso!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        
    }
}
