
package Model;

/**
 *
 * @author ander
 */
public class RelatorioModel {
    
    //Passsando os atributos
    private String codRelatorio;
    private String codVendas;
    private String data;
    private double valorTtlvendas;
    private String codProd;
    private double entrada;
    private double saida;
    private double Qtd_Estoque;

   
    public String getCodRelatorio() {
        return codRelatorio;
    }

    public void setCodRelatorio(String codRelatorio) {
        this.codRelatorio = codRelatorio;
    }

   
    public String getCodVendas() {
        return codVendas;
    }

   
    public void setCodVendas(String codVendas) {
        this.codVendas = codVendas;
    }

  
    public String getData() {
        return data;
    }

   
    public void setData(String data) {
        this.data = data;
    }

    public double getValorTtlvendas() {
        return valorTtlvendas;
    }

   
    public void setValorTtlvendas(double valorTtlvendas) {
        this.valorTtlvendas = valorTtlvendas;
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

   
    public double getQtd_Estoque() {
        return Qtd_Estoque;
    }

    public void setQtd_Estoque(double Qtd_Estoque) {
        this.Qtd_Estoque = Qtd_Estoque;
    }
    
    
    
}
