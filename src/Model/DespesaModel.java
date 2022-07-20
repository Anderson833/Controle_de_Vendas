/*
  ESSE CLASSE SERÁ PARA REALIZAR A CRIAÇÃO DOS ATRIBUTOS E MÉTODOS DA DESPESA
 */
package Model;

/**
 *
 * @author ander
 */
public class DespesaModel {
    //atributos de despesa
    private int codDespesa;
    private String descricao;
    private double total;
    private String data;

    //Métodos getters e setters
    public int getCodDespesa() {
        return codDespesa;
    }

  
    public void setCodDespesa(int codDespesa) {
        this.codDespesa = codDespesa;
    }

  
    public String getDescricao() {
        return descricao;
    }

   
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getTotal() {
        return total;
    }

   
    public void setTotal(double total) {
        this.total = total;
    }

    public String getData() {
        return data;
    }

   
    public void setData(String data) {
        this.data = data;
    }
}
