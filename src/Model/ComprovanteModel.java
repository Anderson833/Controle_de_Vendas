
package Model;

/**
 *
 * @author ander
 */
public class ComprovanteModel extends VendaModel {
    
    private int idComprar;
    private String data;
   
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
    
}
