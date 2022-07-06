
package Model;

/**
 *
 * @author anderson
 */
public class EstoqueModel {
    
    //atributos do estoque
    private String codEstoq;
    private String codProd;
    private double entrada;
    private double saida;
    private int qtdEstoq;
    private String data;

  
    public String getCodEstoq() {
        return codEstoq;
    }

   
    public void setCodEstoq(String codEstoq) {
        this.codEstoq = codEstoq;
    }

    public String getCodProd() {
        return codProd;
    }

    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

   
    public double getEntrada() {
        return entrada;
    }

    
    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    public double getSaida() {
        return saida;
    }

   
    public void setSaida(double saida) {
        this.saida = saida;
    }

    
    public int getQtdEstoq() {
        return qtdEstoq;
    }

   
    public void setQtdEstoq(int qtdEstoq) {
        this.qtdEstoq = qtdEstoq;
    }

    
    public String getData() {
        return data;
    }

   
    public void setData(String data) {
        this.data = data;
    }
    
    
}
