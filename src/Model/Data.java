
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Data {
    
    
    private String data;
    
    
    

    //Método para seta Data 
    public String setaData() {

        Date data = new Date();

        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/YYYY");

        String dataFormart = formatar.format(data);

        return dataFormart;

    }

    //MÉTODO PARA EXECUTAR QUALQUEI AÇÃO EM UM  DETERMINADO TEMPO;
    public void tempo() {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException ex) {

        }

    }

    
    public String getData() {
        return data;
    }

  
    public void setData(String data) {
        this.data = data;
    }

    
   
     
}
