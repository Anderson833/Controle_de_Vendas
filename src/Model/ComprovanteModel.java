
package Model;


public class ComprovanteModel extends VendaModel {
    //Atributos
    private int codDetalhe;
    private String pagamento;
   

    //Métodos get e set
    public String getPagamento() {
        return pagamento;
    }

    
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
   
    public int getCodDetalhe() {
        return codDetalhe;
    }

   
    public void setCodDetalhe(int codDetalhe) {
        this.codDetalhe = codDetalhe;
    }

   
    
}
