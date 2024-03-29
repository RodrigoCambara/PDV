/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JDBC.ConnectionFactory;
import Model.clienteClass;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClientesDAO {

    //Conexão
    private Connection con;

    public ClientesDAO() {

        this.con = new ConnectionFactory().getConnection();
    }

    //Método cadastrar cliente
    public void cadastrarCliente(clienteClass obj) {

        try {

            //1 passo: Criar o comando SQL
            String sql = "INSERT INTO tb_clientes (nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //2 passo: conectar o banco de dados e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());

            //3 passo: Executar o comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Método alterar cliente
    public void alterarCliente(clienteClass obj) {

        try {

            //1 passo: Criar o comando SQL
            String sql = "UPDATE tb_clientes SET nome=?,rg=?,cpf=?,email=?,telefone=?,celular=?,cep=?,"
                    + "endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? WHERE id=?";

            //2 passo: conectar o banco de dados e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            stmt.setInt(14, obj.getId());

            //3 passo: Executar o comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Método excluir cliente
    public void excluirCliente(clienteClass obj) {

        try {

            //1 passo: Criar o comando SQL
            String sql = "DELETE FROM tb_clientes WHERE id=?";

            //2 passo: conectar o banco de dados e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getId());

            //3 passo: Executar o comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Método listar todos os clientes
    public List<clienteClass> listarClientes() {

        try {

            //1 passo: criar a lista
            List<clienteClass> lista = new ArrayList<>();

            //2 passo: criar o comando SQL
            String sql = "SELECT * FROM tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                clienteClass obj = new clienteClass();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                lista.add(obj);

            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }

    }

    //Método buscarClientePorNome
    public List<clienteClass> buscaClientePorNome(String nome) {

        try {

            //1 passo: criar a lista
            List<clienteClass> lista = new ArrayList<>();

            //2 passo: criar o comando SQL
            String sql = "SELECT * FROM tb_clientes WHERE nome LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                clienteClass obj = new clienteClass();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                lista.add(obj);

            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }
    }
     
        //metodo busca Cliente por Cpf
    public clienteClass buscaporcpf(String cpf) {
        try {
            //1 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_clientes where cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();
            clienteClass obj = new clienteClass();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }
    
    
    

}