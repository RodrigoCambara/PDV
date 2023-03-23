/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JDBC.ConnectionFactory;
import Model.fornecedorClass;
import Model.produtosClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class ProdutosDAO {

    //Conexão
    private Connection con;

    public ProdutosDAO() {

        this.con = new ConnectionFactory().getConnection();
    }

    //Método cadastrar produto
    public void cadastrarProduto(produtosClass obj) {

        try {

            //1 passo: Criar o comando SQL
            String sql = "INSERT INTO tb_produtos (descricao,preco,qtd_estoque,for_id) "
                    + "values(?,?,?,?)";

            //2 passo: conectar o banco de dados e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());

            //3 passo: Executar o comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Método alterar produto
    public void alterarProduto(produtosClass obj) {

        try {

            //1 passo: Criar o comando SQL
            String sql = "UPDATE tb_produtos SET descricao=?,preco=?,qtd_estoque=?,for_id=? WHERE id=?";

            //2 passo: conectar o banco de dados e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());
            stmt.setInt(5, obj.getId());

            //3 passo: Executar o comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Método excluir produto
    public void excluirProduto(produtosClass obj) {

        try {

            //1 passo: Criar o comando SQL
            String sql = "DELETE FROM tb_produtos WHERE id=?";

            //2 passo: conectar o banco de dados e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getId());

            //3 passo: Executar o comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Método listar todos os produtos
    public List<produtosClass> listarProdutos() {

        try {

            //1 passo: criar a lista
            List<produtosClass> lista = new ArrayList<>();

            //2 passo: criar o comando SQL
            String sql = "SELECT p.id, p.descricao,p.preco, p.qtd_estoque, f.nome FROM tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id)";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                produtosClass obj = new produtosClass();
                fornecedorClass f = new fornecedorClass();

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString(("f.nome")));
                obj.setFornecedor(f);

                lista.add(obj);

            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }

    }

    //Método buscarProdutosPorNome
    public List<produtosClass> buscaProdutosPorNome(String nome) {

        try {

            //1 passo: criar a lista
            List<produtosClass> lista = new ArrayList<>();

            //2 passo: criar o comando SQL
            String sql = "SELECT p.id, p.descricao,p.preco, p.qtd_estoque, f.nome FROM tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) WHERE p.descricao like ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                produtosClass obj = new produtosClass();
                fornecedorClass f = new fornecedorClass();

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString(("f.nome")));
                obj.setFornecedor(f);

                lista.add(obj);

            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }

    }

    //Método buscarProdutosPorCodigo
    public produtosClass buscaProdutosPorCodigo(int id) {

        try {

            //1 passo: criar a lista
            String sql = "SELECT * FROM tb_produtos WHERE id like ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();          
            produtosClass obj = new produtosClass();
  

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQtd_estoque(rs.getInt("qtd_estoque"));

            }

            return obj;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Produto não encontrado.");
            return null;

        }

    }

}
