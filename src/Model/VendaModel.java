

package Model;

/**
 *
 * @author ander
 */
public class VendaModel {
    
    //Passando os atributos da venda;
    private int  idDeleta;
    private String codVenda;
    private String codProd;
    private String codCli;
    private int qtdProd;
    private double valorUnit;
    private double valorTotal;
    private String data;
    private int Completo;
    private int vz;
    private double valorGanhor;
    private double precoDeComprar;
    
    
    // Os métodos getts e setts
    
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

    
    public String getData() {
        return data;
    }

   
    public void setData(String data) {
        this.data = data;
    }

  
    public int getIdDeleta() {
        return idDeleta;
    }

   
    public void setIdDeleta(int idDeleta) {
        this.idDeleta = idDeleta;
    }

   
    public int getCompleto() {
        return Completo;
    }

   
    public void setCompleto(int Completo) {
        this.Completo = Completo;
    }

    
    public int getVz() {
        return vz;
    }

   
    public void setVz(int vz) {
        this.vz = vz;
    }

    /**
     * @return the valorGanhor
     */
    public double getValorGanhor() {
        return valorGanhor;
    }

    /**
     * @param valorGanhor the valorGanhor to set
     */
    public void setValorGanhor(double valorGanhor) {
        this.valorGanhor = valorGanhor;
    }

    /**
     * @return the precoDeComprar
     */
    public double getPrecoDeComprar() {
        return precoDeComprar;
    }

    /**
     * @param precoDeComprar the precoDeComprar to set
     */
    public void setPrecoDeComprar(double precoDeComprar) {
        this.precoDeComprar = precoDeComprar;
    }

   
    
    
}
