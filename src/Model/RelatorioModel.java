
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
    private int entrada;
    private int saida;
    private int Qtd_Estoque;

   
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

   
    public int getEntrada() {
        return entrada;
    }

   
    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    
    public int getSaida() {
        return saida;
    }

    public void setSaida(int saida) {
        this.saida = saida;
    }

   
    public int getQtd_Estoque() {
        return Qtd_Estoque;
    }

    public void setQtd_Estoque(int Qtd_Estoque) {
        this.Qtd_Estoque = Qtd_Estoque;
    }
    
    
    
}
