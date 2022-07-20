

package Model;

/**
 *
 * @author ander
 */
public class VendaModel {
    
    //Passando os atributos da venda;
   
    private int codVenda;
    private int IdDeleta;
    private int codItens;
    private int codProd;
    private int codCli;
    private int qtdProd;
    private double valorUnit;
    private double valorTotal;
    private String data;
    private double valorGanhor;
    private double precoDeComprar;
    
    
    // Os métodos getters e setters
    
    public int getCodVenda() {
        return codVenda;
    }

   
    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

   
    public int getCodProd() {
        return codProd;
    }

    
    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

   
    public int getCodCli() {
        return codCli;
    }

    
    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public int getQtdProd() {
        return qtdProd;
    }

   
    public void setQtdProd(int qtdProd) {
        this.qtdProd = qtdProd;
    }

   
    public double getValorUnit() {
        return valorUnit;
    }

    
    public void setValorUnit(double valorUnit) {
        this.valorUnit = valorUnit;
    }

   
    public double getValorTotal() {
        return valorTotal;
    }

   
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    
    public String getData() {
        return data;
    }

   
    public void setData(String data) {
        this.data = data;
    }

  
   
    public double getValorGanhor() {
        return valorGanhor;
    }

    public void setValorGanhor(double valorGanhor) {
        this.valorGanhor = valorGanhor;
    }

   
    public double getPrecoDeComprar() {
        return precoDeComprar;
    }

   
    public void setPrecoDeComprar(double precoDeComprar) {
        this.precoDeComprar = precoDeComprar;
    }

    
    public int getCodItens() {
        return codItens;
    }

   
    public void setCodItens(int codItens) {
        this.codItens = codItens;
    }

   
     public String toString() {
        return  String.valueOf(getCodCli());
    }

    /**
     * @return the IdDeleta
     */
    public int getIdDeleta() {
        return IdDeleta;
    }

    /**
     * @param IdDeleta the IdDeleta to set
     */
    public void setIdDeleta(int IdDeleta) {
        this.IdDeleta = IdDeleta;
    }

   
}
