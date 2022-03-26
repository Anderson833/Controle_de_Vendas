/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Anderson
 */
public class ProdutoModel {
    
    //Atributos do Produto
    private String codProd;
    private String nome;
    private String descricao;
    private double valorUnit;
    private double valorDeComprar;
    
    private int estoque;

  
    public String getCodProd() {
        return codProd;
    }

    
    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

   
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getDescricao() {
        return descricao;
    }

   
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

  
    public double getValorUnit() {
        return valorUnit;
    }

   
    public void setValorUnit(double valorUnit) {
        this.valorUnit = valorUnit;
    }

   
    public int getEstoque() {
        return estoque;
    }

   
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return getCodProd();
    }

    /**
     * @return the valorDeComprar
     */
    public double getValorDeComprar() {
        return valorDeComprar;
    }

    /**
     * @param valorDeComprar the valorDeComprar to set
     */
    public void setValorDeComprar(double valorDeComprar) {
        this.valorDeComprar = valorDeComprar;
    }
    
}
