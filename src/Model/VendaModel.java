

package Model;

/**
 *
 * @author ander
 */
public class VendaModel {
    
    //Passando os atributos da venda;
    private String codVenda;
    private String codProd;
    private String codCli;
    private int qtdProd;
    private double valorUnit;
    private double valorTotal;

    
    public String getCodVenda() {
        return codVenda;
    }

   
    public void setCodVenda(String codVenda) {
        this.codVenda = codVenda;
    }

   
    public String getCodProd() {
        return codProd;
    }

    
    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

   
    public String getCodCli() {
        return codCli;
    }

    
    public void setCodCli(String codCli) {
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
    
    
}
