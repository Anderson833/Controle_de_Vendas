
package Dao;

import Conexao.Conexao_BD;
import Model.RelatorioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ander
 */
public class RelatorioDao {
    
     //Método para visualizar todo Relatório;
     public List<RelatorioModel> visualizarRelatorio(){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de Relatorio;
         ArrayList<RelatorioModel> listRelatorio = new ArrayList<>();
        
         try {
             
             //Comando para selecionar toda tabela Relatório;
             String sql="SELECT * FROM relatorio";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             //Executar;
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe RelatorioModel;
                 RelatorioModel relat = new RelatorioModel();
                 //Setando os Valores;
                relat.setCodRelatorio(rst.getString("codRel"));
                relat.setCodVendas(rst.getString("codVend"));
                relat.setData(rst.getString("data"));
                relat.setValorTtlvendas(rst.getDouble("valorTtvd"));
                relat.setCodProd(rst.getString("codProd"));
                relat.setEntrada(rst.getInt("entrada"));
                relat.setSaida(rst.getInt("saida"));
                relat.setQtd_Estoque(rst.getInt("qtd_Estoque"));
                
                 //Adicionando na Lista;
               listRelatorio.add(relat);
          
             }
             
             //Fechando conexão ResultSet;
             rst.close();
             
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
             
         } catch (Exception e) {
             //Algo de error mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Visualizar Relatório!");
         }
         //Retornando uma Lista de Relatório;
        return listRelatorio;
         
     }
    
     
      //Método para adicionar relatorio ao banco de dados;
    public void adicionarRelatorio(RelatorioModel relat){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //Comando para inserir os dados do relatório no banco de dados;/,
            String sql="INSERT INTO relatorior(codRela,dhata,valorTtvd,codProd,entrada,saida,qtd_Estoque) VALUES(?,?,?,?,?,?,?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos do relatório da classe RelatorioModel;
            patm.setString(1, relat.getCodRelatorio());
            patm.setString(2, relat.getData());
            patm.setDouble(3, relat.getValorTtlvendas());
            patm.setString(4, relat.getCodProd());
            patm.setInt(5, relat.getEntrada());
            patm.setInt(6, relat.getSaida());
            patm.setInt(7, relat.getQtd_Estoque());
            
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Relatório salvo Com Sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Relatório não salvo !","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
           JOptionPane.showMessageDialog(null, "Error ao salvar Relatório  !");
        }
        
    }
    
     
     
}
