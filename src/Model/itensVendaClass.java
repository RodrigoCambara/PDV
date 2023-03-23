/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class itensVendaClass {
    
    // Atributos
    
    private int id;
    private vendasClass venda;
    private produtosClass produto;
    private int qtd;
    private double subtotal;
    
    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public vendasClass getVenda() {
        return venda;
    }

    public void setVenda(vendasClass venda) {
        this.venda = venda;
    }

    public produtosClass getProduto() {
        return produto;
    }

    public void setProduto(produtosClass produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
       
}
