/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Rodrigo
 */
public class produtosClass {
    
    //Atributos
    
        private int id;
        private String descricao;
        private Double preco;
        private int qtd_estoque;
        private fornecedorClass fornecedor;
        
        //Getters and setters      

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public fornecedorClass getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(fornecedorClass fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
