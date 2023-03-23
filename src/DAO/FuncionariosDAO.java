/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JDBC.ConnectionFactory;
import Model.funcionarioClass;
import View.frmLogin;
import View.frmMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionariosDAO {

    //Conexão
    private Connection con;

    public FuncionariosDAO() {

        this.con = new ConnectionFactory().getConnection();
    }

    //Método cadastrar funcionário
    public void cadastrarFuncionario(funcionarioClass obj) {

        try {

            //1 passo: Criar o comando SQL
            String sql = "INSERT INTO tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //2 passo: conectar o banco de dados e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());

            //3 passo: Executar o comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Método alterar funcionário
    public void alterarFuncionario(funcionarioClass obj) {

        try {

            //1 passo: Criar o comando SQL
            String sql = "UPDATE tb_funcionarios SET nome=?,rg=?,cpf=?,email=?,senha=?,cargo=?,nivel_acesso=?,telefone=?,celular=?,cep=?,"
                    + "endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? WHERE id=?";

            //2 passo: conectar o banco de dados e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());
            stmt.setInt(17, obj.getId());

            //3 passo: Executar o comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário alterado com sucesso!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Método excluir funcionário
    public void excluirFuncionario(funcionarioClass obj) {

        try {

            //1 passo: Criar o comando SQL
            String sql = "DELETE FROM tb_funcionarios WHERE id=?";

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

    //Método listar todos os funcionários
    public List<funcionarioClass> listarFuncionario() {

        try {

            //1 passo: criar a lista
            List<funcionarioClass> lista = new ArrayList<>();

            //2 passo: criar o comando SQL
            String sql = "SELECT * FROM tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                funcionarioClass obj = new funcionarioClass();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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

    //Método buscar Funcionario Por Nome
    public List<funcionarioClass> buscaFuncionarioPorNome(String nome) {

        try {

            //1 passo: criar a lista
            List<funcionarioClass> lista = new ArrayList<>();

            //2 passo: criar o comando SQL
            String sql = "SELECT * FROM tb_funcionarios WHERE nome LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                funcionarioClass obj = new funcionarioClass();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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

    //Método efetuar login
    public void efetuaLogin(String email, String senha) {

        try {

            //1 passo SQL
            String sql = "SELECT * FROM tb_funcionarios WHERE email=? and senha = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                //Usuário logou
                JOptionPane.showMessageDialog(null, "Usuário logado!");
                frmMenu tela = new frmMenu();
                tela.usuariologado = rs.getString("nome");
                tela.setVisible(true);

            } else {

                //Dados incorretos
                JOptionPane.showMessageDialog(null, "Acesso negado! Email ou senha incorretos.");
                new frmLogin().setVisible(true);
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }
}
