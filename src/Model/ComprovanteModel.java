
package Model;


public class ComprovanteModel extends VendaModel {
    
    private String codDetalhe;
    private String data;
    private String idVenda;
    private int idExcluir;
    
   

    
    public String getData() {
        return data;
    }

    
    public void setData(String data) {
        this.data = data;
    }

    
    public String getIdVenda() {
        return idVenda;
    }

   
    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }

    
    public int getIdExcluir() {
        return idExcluir;
    }

    
    public void setIdExcluir(int idExcluir) {
        this.idExcluir = idExcluir;
    }

   
    public String getCodDetalhe() {
        return codDetalhe;
    }

   
    public void setCodDetalhe(String codDetalhe) {
        this.codDetalhe = codDetalhe;
    }
    
}
