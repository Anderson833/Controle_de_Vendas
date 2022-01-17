
package Model;

/**
 *
 * @author ander
 */
public class ComprovanteModel extends VendaModel {
    
    private int idComprar;
    private String data;
    private String idVenda;
    private int idExcluir;
    
    public int getIdComprar() {
        return idComprar;
    }

   
    public void setIdComprar(int idComprar) {
        this.idComprar = idComprar;
    }

    
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
    
}
