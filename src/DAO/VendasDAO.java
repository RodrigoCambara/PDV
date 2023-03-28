/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JDBC.ConnectionFactory;
import Model.vendasClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class VendasDAO {
    
     //Conexão
    private Connection con;

    public VendasDAO() {

        this.con = new ConnectionFactory().getConnection();
    }
    
    // Cadastrar venda
    
    public void cadastrarVenda(vendasClass obj){
        
        try {

            //1 passo: Criar o comando SQL
            String sql = "INSERT INTO tb_vendas (cliente_id,data_venda,total_venda,observacoes) "
                    + "values(?,?,?,?)";

            //2 passo: conectar o banco de dados e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getDataVenda());
            stmt.setDouble( 3, obj.getTotalVenda());
            stmt.setString(4, obj.getObs());

            //3 passo: Executar o comando SQL
            stmt.execute();
            stmt.close();



        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        
    }
    
    // Retorna a última venda
    
    public int retornaUltimaVenda() throws SQLException{
        
        try {
            
            int idvenda = 0;
            
            String sql = "SELECT max(id) id FROM tb_vendas";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                
                vendasClass p = new vendasClass();
                
                p.setId(rs.getInt("id"));
                
                idvenda = p.getId();
                
            }
            
            return idvenda;
        } 
        
        catch (SQLException e){
            
            throw new RuntimeException();
        }
    }
}
