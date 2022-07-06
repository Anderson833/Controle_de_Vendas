
package Model;


public class ComprovanteModel extends VendaModel {
    //Atributos
    private String codDetalhe;
    private String pagamento;
   

    //Métodos get e set
    public String getPagamento() {
        return pagamento;
    }

    
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
   
    public String getCodDetalhe() {
        return codDetalhe;
    }

   
    public void setCodDetalhe(String codDetalhe) {
        this.codDetalhe = codDetalhe;
    }

    @Override
    public String toString() {
        return getPagamento();
    }
    
}
