package View;

import Conexao.Conexao_BD;
import Dao.ClienteDao;
import Dao.ComprovanteDao;
import Dao.DataDao;
import Dao.LucroDao;
import Dao.ProdutoDao;
import Dao.VendaDao;
import Model.ClienteModel;
import Model.ComprovanteModel;
import Model.Data;
import Model.LucroModel;
import Model.ProdutoModel;
import Model.VendaModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ander
 */
public class Venda extends javax.swing.JFrame {

    
    
    //Para  guarda o resultado da subtração da quantidade em estoque com a quantidade pedido pelo cliente;
    int contador = 0;
    
    int contaIncremento=0;
    //variaveis para armazenar os dados e saber se tem no banco de dados
    String codExclui="",codCliente="",codDVenda="",codProduto="",DATA="";
    int complet=0,vz=0,QtdProd=0;
    double valorunit=0,TOTAL=0;
    
    //VALOR TOTAL DE TODA TABELA ITEM
    double valorTotalBD = 0;
    
     //VALOR TOTAL DA VENDA PELO CÓDIGO, DA VENDA E DO CLIENTE
    double valorTotalCodBD = 0;
   
    //pega o valor do produto que o vendedor comprou;
     double valorDoVendedor=0;
     
    //método para pega o valor do investimento
     double valorDoInvestimento=0;
     
       
    //método para pega o valor de lucro
     double valorLucro=0;
     
     //Variável soma Quantidade de produto
     int QTDProduto=0;
     
     //Variável soma tota de produto
     double somaTotal=0;
     
     //Variável para armazenar O código  lucro
     String codigoLUCRO="";
     
     ///variavel para pegar os códigos da tabela venda
     String codigoVendaTvd="";
     //variável para armazenar o código item
    String codigoItem="";
    public Venda() {
        initComponents();
        //centralizando ao centro da tela
        setLocationRelativeTo(null);

        //Método para seta os nomes do cliente pelo código;
        setaDadosJcomboxClientes();
        //Método para seta o código dos produtos
        setaDadosJcomboxProd();
        //Método para mostrar opção de pagamentos
      //  setaDadosJcomboxPagamentos();
        
        //método para armazenar o valor total de toda comprar ao abrir não zera;
        totalValorBd();
   
        //Método para exibir a data ao abrir 
        DataDoDia();
      
        
         setaCodigoVendaDaTabelaItem();
         
         
         verDiferencaEntreClienteEcodVenda();
         
            setaCodigoDaVenda();
           if(codigoVendaTvd==null){
                  adicionarCodVend();
    
             }
    }

    //Para armazenar código da venda da tabela vendas no banco de dados
    String codVendar = "";
    //VARIAVEL PARA ARMAZENAR O CÓDIGO DA TABELA codVenda
    String codvenda = "";
    //Variável para armazenar o código da tabela detalhe
    String codDetalhe="";
    
    //Para pegar o id do cliente no banco de dados
    String idCli = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        digitanome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codVenda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TXTValorUnit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtValortotal = new javax.swing.JTextField();
        calcular = new javax.swing.JButton();
        visualizar = new javax.swing.JButton();
        salvarVenda = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVend = new javax.swing.JTable();
        TXTestoque = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNpro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNcli = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        deletarItem = new javax.swing.JButton();
        labelTotal = new javax.swing.JLabel();
        jcombProdutos = new javax.swing.JComboBox();
        jComboBoxCliente = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        txtdata = new javax.swing.JTextField();
        lbHora = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtValorReceb = new javax.swing.JTextField();
        txtTroco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venda");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        digitanome.setBackground(new java.awt.Color(133, 182, 139));
        digitanome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 18))); // NOI18N
        digitanome.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Código venda:");

        codVenda.setEditable(false);
        codVenda.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        codVenda.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                codVendaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        codVenda.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                codVendaMouseMoved(evt);
            }
        });
        codVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codVendaFocusLost(evt);
            }
        });
        codVenda.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                codVendaInputMethodTextChanged(evt);
            }
        });
        codVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codVendaActionPerformed(evt);
            }
        });
        codVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codVendaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codVendaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codVendaKeyTyped(evt);
            }
        });

        jLabel2.setText("Código Produto:");

        jLabel3.setText("Qtd de Produtos:");

        txtQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdActionPerformed(evt);
            }
        });
        txtQtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQtdKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtdKeyReleased(evt);
            }
        });

        jLabel4.setText("Valor Unitário:");

        TXTValorUnit.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TXTValorUnitInputMethodTextChanged(evt);
            }
        });
        TXTValorUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXTValorUnitKeyReleased(evt);
            }
        });

        jLabel5.setText("Valor Total:");

        txtValortotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtValortotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValortotalKeyReleased(evt);
            }
        });

        calcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/calculadora-de-impressao.png"))); // NOI18N
        calcular.setText("Calcular");
        calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularActionPerformed(evt);
            }
        });

        visualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/visualizador.png"))); // NOI18N
        visualizar.setText("Listar Tudo");
        visualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        visualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visualizarMouseClicked(evt);
            }
        });
        visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarActionPerformed(evt);
            }
        });
        visualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                visualizarKeyPressed(evt);
            }
        });

        salvarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/salve-.png"))); // NOI18N
        salvarVenda.setText("Salvar Venda");
        salvarVenda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        salvarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarVendaActionPerformed(evt);
            }
        });
        salvarVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                salvarVendaKeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/armazenar.png"))); // NOI18N
        jLabel8.setText("    Realizar vendas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jLabel9.setText("Código Cliente:");

        tabelaVend.setBackground(new java.awt.Color(153, 255, 153));
        tabelaVend.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        tabelaVend.setForeground(new java.awt.Color(51, 51, 255));
        tabelaVend.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CodDeleta", "CodVend", "CodCli", "CodProd", "Qtd_Prod", "ValorUnit", "ValorTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaVend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVendMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaVend);

        TXTestoque.setEditable(false);
        TXTestoque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TXTestoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTestoqueActionPerformed(evt);
            }
        });

        jLabel10.setText("Qtd Em Estoque:");

        txtNpro.setEditable(false);

        jLabel11.setText("Nome do Produto:");

        txtNcli.setEditable(false);

        jLabel12.setText("Nome Do Cliente:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/limpando-produtos.png"))); // NOI18N
        jButton2.setText("Limpar");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        label.setBackground(new java.awt.Color(255, 255, 255));
        label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label.setText("Valor Total");

        deletarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/claro.png"))); // NOI18N
        deletarItem.setText("Deletar item");
        deletarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarItemActionPerformed(evt);
            }
        });

        labelTotal.setBackground(new java.awt.Color(255, 255, 0));
        labelTotal.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N

        jcombProdutos.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jcombProdutos.setForeground(new java.awt.Color(0, 0, 255));
        jcombProdutos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolha código do produto" }));
        jcombProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombProdutosActionPerformed(evt);
            }
        });
        jcombProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcombProdutosKeyPressed(evt);
            }
        });

        jComboBoxCliente.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jComboBoxCliente.setForeground(new java.awt.Color(0, 204, 51));
        jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolha código do cliente" }));
        jComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClienteActionPerformed(evt);
            }
        });
        jComboBoxCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxClienteKeyPressed(evt);
            }
        });

        jLabel17.setText("Data:");

        txtdata.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        txtdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdataActionPerformed(evt);
            }
        });
        txtdata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdataKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdataKeyReleased(evt);
            }
        });

        lbHora.setBackground(new java.awt.Color(0, 0, 0));
        lbHora.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lbHora.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Menu:");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(133, 182, 139));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Processamento para calcular troco:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12))); // NOI18N

        jLabel6.setText("Informe o valor recebido:");

        txtValorReceb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorRecebActionPerformed(evt);
            }
        });
        txtValorReceb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorRecebKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorRecebKeyReleased(evt);
            }
        });

        txtTroco.setEditable(false);
        txtTroco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTroco.setForeground(new java.awt.Color(255, 0, 51));

        jLabel7.setText("Troco:");

        jButton3.setText("Calcular");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValorReceb, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 26, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorReceb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout digitanomeLayout = new javax.swing.GroupLayout(digitanome);
        digitanome.setLayout(digitanomeLayout);
        digitanomeLayout.setHorizontalGroup(
            digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(digitanomeLayout.createSequentialGroup()
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(digitanomeLayout.createSequentialGroup()
                                        .addComponent(deletarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(salvarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(codVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdata)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TXTValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(121, 121, 121))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(digitanomeLayout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(digitanomeLayout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(174, 174, 174)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(digitanomeLayout.createSequentialGroup()
                                                .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(48, 48, 48)
                                                .addComponent(txtNcli, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(digitanomeLayout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(digitanomeLayout.createSequentialGroup()
                                                .addComponent(txtValortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(TXTestoque, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(39, 39, 39)
                                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, digitanomeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jcombProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNpro, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(92, Short.MAX_VALUE))))
            .addGroup(digitanomeLayout.createSequentialGroup()
                .addGap(547, 547, 547)
                .addComponent(calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        digitanomeLayout.setVerticalGroup(
            digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(digitanomeLayout.createSequentialGroup()
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(codVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(txtNcli, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxCliente))
                    .addComponent(jcombProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TXTestoque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNpro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXTValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deletarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(salvarVenda)
                        .addGap(22, 22, 22))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(digitanome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(digitanome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void salvarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarVendaActionPerformed
     
         if(codVenda.getText().isEmpty()){
              codVenda.setText(codigoVendaTvd);
           // JOptionPane.showMessageDialog(null, "O campo do código da venda!","Opa... está Vazio:",JOptionPane.ERROR_MESSAGE);
        ///     codVenda.requestFocus();
         }else{
           
           //método que fazer o cadastro das vendas na tabelha detalhe
              addVendaNodetalher();
               adicionarCodVend();
              codVenda.setText("");
            //  processoLucro();
      
         }   
    }//GEN-LAST:event_salvarVendaActionPerformed
    
    //Método para realizar o calculo e mostrar atualizado o total se caso deletar algum item 
     public void ProcessoDeCalculo(){
          //Método para saber ser tem algo campo nulo
           // valorNulo();
             setaCodigoDaVenda();
           
           if(codigoVendaTvd==null){
                  adicionarCodVend();
             codVenda.setText(codigoVendaTvd);
            
             
             }
           
               setaCodigoDaVenda();
              if(codVenda.getText().equals(codigoVendaTvd)){
                
                codVenda.setText(codigoVendaTvd);
                
                //método para adicionar item
                adicionarItem();
                //Método para atualizar os produtos
                 setaAtualizacaoProduto();
               //Método para soma os itens das vendas pelo código da venda  do cliente e da venda
              somaItensPelo3codigoVendaDataCliente();
            //seta o valor total da comprar do cliente na label total
              ListarPelos3();
               processoLucro();
               //método para processa o lucro
               //  processoLucro();
         
            } else if(jComboBoxCliente.getSelectedItem()!=idCli||codVenda.getText()!=codigoVendaTvd){
                   
                 setaCodigoDaVenda();
               //   setaCodigoDaVenda();
                codVenda.setText("");
                codVenda.setText(codigoVendaTvd);
              //método para adicionar item
                adicionarItem();
                //Método para atualizar os produtos
                 setaAtualizacaoProduto();
          
             //Método para soma os itens das vendas pelo código da venda  do cliente e da venda
              somaItensPelo3codigoVendaDataCliente();
            //seta o valor total do itens do cliente na label total
              ListarPelos3();
               //método para processa o lucro
            //    processoLucro();
            processoLucro();
              }
            
        
        

     }
    
    //Metodo para adicionar itens
    public void adicionarItem() {
        //Instânciando a classe VendaDao;
        VendaDao dao = new VendaDao();

        //Instânciando a classe VendaModel;
        VendaModel vd = new VendaModel();
        //Setando os valores ;
        vd.setCodVenda(Integer.parseInt(codVenda.getText()));
        vd.setCodCli(Integer.parseInt(jComboBoxCliente.getSelectedItem().toString()));
        vd.setCodProd(Integer.parseInt(jcombProdutos.getSelectedItem().toString()));
        vd.setQtdProd(Integer.parseInt(txtQtd.getText()));
        vd.setValorUnit(Double.parseDouble(TXTValorUnit.getText()));
        vd.setValorTotal(Double.parseDouble(txtValortotal.getText()));
        vd.setData(txtdata.getText());

        //Passando os valores no objeto dao da classe VendaDao;
        dao.adicionaItens(vd);

    }


    private void calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularActionPerformed
       
          setaCodigoDaVenda();
           if(codigoVendaTvd==null){
                  adicionarCodVend();
             codVenda.setText(codigoVendaTvd);
             }
            
           codVenda.setText(codigoVendaTvd);
         
          
           // Método para verificar se tem códigos iguais
           //verificar();
           //Método buscar no banco de dados o código do cliente e da venda
           verDiferencaEntreClienteEcodVenda();
            //Condição para  adiconar os itens se o código da venda e do cliente estiver sem alteração
             if(jComboBoxCliente.getSelectedItem()!=idCli && codVenda.getText()!=codigoItem||jComboBoxCliente.getSelectedItem()==idCli && codVenda.getText()!=codigoItem|| jComboBoxCliente.getSelectedItem()!=idCli&& codVenda.getText()==codigoItem){
                  //caso seja diferente o sistema zera os dados e limpa
          //  JOptionPane.showMessageDialog(null, "O Sistema vai zera os valores,  ", "Nesse caso contém cliente ou código de venda  diferente", JOptionPane.INFORMATION_MESSAGE);
                valorTotalCodBD = 0;
             }
             somaValores();
          
          
          
      
        
    }//GEN-LAST:event_calcularActionPerformed
     //método para seta valores de comprar do vendedor, seta a soma da qtd, realizar o calculor do lucro e salva na tabela lucro
     public void processoLucro(){
            //Mostrando o valor comprado pelo vendedor;
          setaDadosProdutoValorDeCompra();
          
          //método para calcula a soma de todo  
         fazerCalculoAntesdSalvar();
          
         
         setaDadosDaQtdESoma();
          //fazendo o calculo do lucro
         fazerCalculo();
         
            //Método para verificar se existe o código na tabela lucro
         setacodigoDoLucro(); 
         
          if(String.valueOf(jcombProdutos.getSelectedItem()).equals(codigoLUCRO)){
          //  JOptionPane.showMessageDialog(null,"atualizar ");
            setaLucroeAtualizarLucror();
        }else if(codigoLUCRO==null||String.valueOf(jcombProdutos.getSelectedItem())!=codigoLUCRO){
           ///  JOptionPane.showMessageDialog(null,"vai salvar ");
             
               //Método para salvar os dados na tabela lucro
           addValoresNaTabelaLucro();
        }
      
         
     }
    
    //método para soma os valores
    public boolean somaValores(){
         boolean EstoqueBaixo=false;
       /*   if(codVenda.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Preenchar o campo do código da venda!");
             codVenda.requestFocus();
            }
         */ // condição para  poder calcular a venda
        if (txtQtd.getText().equals("")) {
          JOptionPane.showMessageDialog(null, "Preencha o campo de quantidade!");
            txtQtd.requestFocus();
        } else {

            double estoq = Double.parseDouble(TXTestoque.getText());

            double qtd = Double.parseDouble(txtQtd.getText());

            if (estoq >=qtd) {
                //Método para calcular Pre venda;
                calcularPreVenda();
                 //Método que fazer o calculor para adicionar o item em seguidar
                 ProcessoDeCalculo();
                 //metodo para realizar as operaçoes de lucro
                // processoLucro();
            } else {
                   EstoqueBaixo=true;
                // se essa condição for realizada será mostrado essa mensagem;
                JOptionPane.showMessageDialog(null, "Estoque insuficiente !", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        return true;
    }
    
    private void tabelaVendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendMouseClicked

        //Seta os valores nos campos de textos ao clicar na linha da tabela;
        if (tabelaVend.getSelectedRow() != -1) {

            codVenda.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 0).toString());
            jComboBoxCliente.setSelectedItem(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 1).toString());
            jcombProdutos.setSelectedItem(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 3).toString());
            txtQtd.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 4).toString());
             txtValortotal.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 6).toString());
            TXTValorUnit.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 5).toString());
           

        }


    }//GEN-LAST:event_tabelaVendMouseClicked
 
      // lista  toda tabela de item pela data;
     public void ListarPeladate(){
          DefaultTableModel modelo = (DefaultTableModel) tabelaVend.getModel();
            //Método para não repetir os dados na tabela de item;
            modelo.setNumRows(0);
            //Instânciando a classe VendaDao;
            VendaDao dao = new VendaDao();
            //Um Laço de repetição para lista todos itens da tabela item ; 
            for (VendaModel item : dao.visualizarPelaData(txtdata.getText())) {
                modelo.addRow(new Object[]{
                item.getIdDeleta(),
                item.getCodVenda(),
                item.getCodCli(),
                item.getCodProd(),
                item.getQtdProd(),
                item.getValorUnit(),
                item.getValorTotal(),
                item.getData() 
              
                
                });
           }
     }
     // lista  toda tabela item codigo venda cliente data
     public void ListarPelos3(){
          DefaultTableModel modelo = (DefaultTableModel) tabelaVend.getModel();
            //Método para não repetir os dados na tabela de item;
            modelo.setNumRows(0);
            //Instânciando a classe VendaDao;
            VendaDao dao = new VendaDao();
            //Um Laço de repetição para lista todos itens da tabela item ; 
            for (VendaModel item : dao.listaVendaPeloCodigoClienteData3(codVenda.getText(),jComboBoxCliente.getSelectedItem().toString(),txtdata.getText())) {
                modelo.addRow(new Object[]{
                item.getIdDeleta(),
                item.getCodVenda(),
                item.getCodCli(),
                item.getCodProd(),
                item.getQtdProd(),
                item.getValorUnit(),
                item.getValorTotal(),
                item.getData() 
              
                
                });
           }
     }

    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed
      
         //condição para saber se tem dados na tabela veendas
         if(tabelaVend.getModel().getRowCount()==0){
             //Método para pega os dados do bancos de dados
                          tabelavazia();
         }else{
             // método para lista todos itens pela data presente
           //  ListarPeladate();
            //visualizarVENDAS();
             //Método para soma os itens das vendas pelo código da venda  do cliente e da venda
              somaItensPelo3codigoVendaDataCliente();
            //seta o valor total da comprar do cliente na label total
              listacodClienteEaData2();
         }
         

        
       
    }//GEN-LAST:event_visualizarActionPerformed

    private void TXTValorUnitInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TXTValorUnitInputMethodTextChanged

    }//GEN-LAST:event_TXTValorUnitInputMethodTextChanged

    private void txtQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdActionPerformed
      
           //soma valores dos produtos
            somaValores();
     
    }//GEN-LAST:event_txtQtdActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Método para limpar os campos de textos;
        Limpar();
        //Método para limpar as linhas da tabela;
        limpalinha();
    }//GEN-LAST:event_jButton2ActionPerformed
      
      
  
    //método para adicionar a venda na tabela detalhe
    public void addVendaNodetalher() {
        ComprovanteDao DAO = new ComprovanteDao();
        ComprovanteModel modelo = new ComprovanteModel();
        modelo.setCodDetalhe(Integer.parseInt(codVenda.getText()));
        modelo.setCodVenda(Integer.parseInt(codVenda.getText()));
        modelo.setCodCli(Integer.parseInt(jComboBoxCliente.getSelectedItem().toString()));
      //  modelo.setPagamento(JcomboxPagamento.getSelectedItem().toString());
        modelo.setValorTotal(Double.parseDouble(labelTotal.getText()));
        modelo.setData(txtdata.getText());
        DAO.adicionarVendaNoDetalhe(modelo);
        

    }


    private void deletarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarItemActionPerformed
       
     
                // condiçao para valida o campo de texto de código venda 
                if (codVenda.getText().equals("")) {
                    //caso seja verdade mostrar essa mensagem
                    JOptionPane.showMessageDialog(null, "Clique na linha da tabela que você deseja deletar!", "Obrigatório!", JOptionPane.WARNING_MESSAGE);
                    
                } else if(jcombProdutos.getSelectedIndex()==0){
                    JOptionPane.showMessageDialog(null," Informe o código do Produto que deseja Deleta!");
                 jcombProdutos.requestFocus();
               
                     }else{
                    //método para deletar itens     
                   deletarVendasPeloCodigo();
                   
                setaValorTotalDaVendaPeloCodigoClienterEdata();
            //seta o valor total da comprar do cliente na label total
              listacodClienteEaData2();
                         
                }
             
       


        /*
        //Opcão de confirmação
        int item = JOptionPane.showConfirmDialog(null, "Deseja deletar todos Itens?", "Escolha Opção:", JOptionPane.YES_NO_CANCEL_OPTION);

        switch (item) {
            //opçao sim
            case JOptionPane.YES_OPTION:
                
                valorTotalBD = 0;
                //Zerando os campos labeltotal;
                zeroLabel();
                limpalinha();
                break;
            case JOptionPane.NO_OPTION:
                //Método para deletar item;
                if (codVenda.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Preenchar Campo do código Venda?", "Obrigatório!", JOptionPane.WARNING_MESSAGE);
                } else {
                    //Método para deletar item;
                     reporProd();
                    // atualizar  antes de excluir 
                    setaAtualizacaoProduto();
                    // deleta uma compra pelo codExcluir;
                      deletarItem();
                 
                    JOptionPane.showMessageDialog(null, "Procedimento realizado com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            default:

                JOptionPane.showMessageDialog(null, "Nenhuma Opção não desejada!", "", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
         */
    }//GEN-LAST:event_deletarItemActionPerformed

    private void jcombProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombProdutosActionPerformed

        //condição pra saber se jcomboBox produto esta seleciona em 0 
        if (jcombProdutos.getSelectedIndex() == 0) {
            //MOSTRAR ESSA MENSAGEM CASO ESTEJA SELECIONADO 
        //    JOptionPane.showMessageDialog(null, "Produto não escolhido ?");

        } else {

            //Método para seta nome dos clientes   
            setaNomeClientes();

            //método para seta os dados do produto
            setaDadosProduto();
            //txtQtd.setText("");
          if (txtQtd.getText().equals("")) {
                txtQtd.requestFocus();
              //  txtQtd.setText("1");
            } else {
              //   txtQtd.setText("1");
                //método para calcular a venda
            //   calcularPreVenda();
                
               
           //   somaValores();

        }


    }//GEN-LAST:event_jcombProdutosActionPerformed
    }
    private void jcombProdutosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcombProdutosKeyPressed

    }//GEN-LAST:event_jcombProdutosKeyPressed

    private void jComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClienteActionPerformed
        //Método para seta nome do cliente pelo jcomboBox
        setaNomeClientes();

    }//GEN-LAST:event_jComboBoxClienteActionPerformed

    private void codVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codVendaActionPerformed
              
        //para tabela vendas o código armazenador 
            //   adicionarCodVend();
             //  setaCodigoDaVenda();
      
        
        if (codVenda.getText().equals(codVendar)) {
           // JOptionPane.showMessageDialog(null, "JÁ TEM ESSE CÓDIGO "+codVenda.getText());
        } else {
           // JOptionPane.showMessageDialog(null, "NAO TEM ESSE CÓDIGO ");
        }

        if (codVenda.getText().isEmpty()) {
            codVenda.requestFocus();
        } else {
            //Para muda opcão 
            jComboBoxCliente.requestFocus();
        }

    }//GEN-LAST:event_codVendaActionPerformed

    private void jComboBoxClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxClienteKeyPressed

        //Ao Clicar no teclado da seta para o lado direito muda para seleciona código do produto; 
        if (evt.getKeyCode() == evt.VK_RIGHT) {

            jcombProdutos.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxClienteKeyPressed

    private void txtQtdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtdKeyPressed
        //Para muda para opcão de escolhe código do produto;
        if (evt.getKeyCode() == evt.VK_UP) {
            jcombProdutos.requestFocus();
        }
          //condição para permitir apenas números
        if(ApenasNumeros(txtQtd.getText())){
           
        }else{
            
             if(txtQtd.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           
           txtQtd.setText("");
           txtQtd.requestFocus();
         }
    }//GEN-LAST:event_txtQtdKeyPressed

    private void txtValorRecebKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorRecebKeyPressed
        //setaDadosProduto();
    }//GEN-LAST:event_txtValorRecebKeyPressed

    private void txtValorRecebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorRecebActionPerformed

    }//GEN-LAST:event_txtValorRecebActionPerformed

    private void visualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visualizarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_visualizarMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setExtendedState(MAXIMIZED_BOTH);

        Timer t = new Timer(1000, new hora());
        t.start();

    }//GEN-LAST:event_formWindowOpened

    private void TXTestoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTestoqueActionPerformed

        //método para atualizar a quantidade de produtos
        setaAtualizacaoProduto();

    }//GEN-LAST:event_TXTestoqueActionPerformed

    private void salvarVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salvarVendaKeyPressed

        valorNulo();
    }//GEN-LAST:event_salvarVendaKeyPressed

    private void txtdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdataActionPerformed
            DataDoDia();
     
    }//GEN-LAST:event_txtdataActionPerformed

    private void txtdataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdataKeyPressed
     
    }//GEN-LAST:event_txtdataKeyPressed

    private void codVendaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_codVendaInputMethodTextChanged

    }//GEN-LAST:event_codVendaInputMethodTextChanged

    private void codVendaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_codVendaAncestorAdded


    }//GEN-LAST:event_codVendaAncestorAdded

    private void codVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codVendaFocusLost


    }//GEN-LAST:event_codVendaFocusLost

    private void codVendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codVendaKeyTyped


    }//GEN-LAST:event_codVendaKeyTyped

    private void codVendaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_codVendaMouseMoved


    }//GEN-LAST:event_codVendaMouseMoved

    private void codVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codVendaKeyPressed
   
  
    }//GEN-LAST:event_codVendaKeyPressed

    private void codVendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codVendaKeyReleased
                         verificar();
  
    }//GEN-LAST:event_codVendaKeyReleased

    private void txtdataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdataKeyReleased
         //condição para permitir apenas números
        if(ApenasNumeros(txtdata.getText())){
           
        }else{
            
             if(txtdata.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           
           txtdata.setText("");
           txtdata.requestFocus();
         }
    }//GEN-LAST:event_txtdataKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaPrincipal p = new TelaPrincipal();
        p.setVisible(true);
        Venda vd = new Venda();
        vd.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void visualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_visualizarKeyPressed
        tabelavazia();
    }//GEN-LAST:event_visualizarKeyPressed

    private void TXTValorUnitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTValorUnitKeyReleased
        
          //condição para permitir apenas números
        if(ApenasNumeros(TXTValorUnit.getText())){
           
        }else{
            
             if(TXTValorUnit.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           
           TXTValorUnit.setText("");
           TXTValorUnit.requestFocus();
         }
    }//GEN-LAST:event_TXTValorUnitKeyReleased

    private void txtValortotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValortotalKeyReleased
        
          //condição para permitir apenas números
        if(ApenasNumeros(txtValortotal.getText())){
           
        }else{
            
             if(txtValortotal.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           
           txtValortotal.setText("");
           txtValortotal.requestFocus();
         }
    }//GEN-LAST:event_txtValortotalKeyReleased

    private void txtQtdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtdKeyReleased
         //condição para permitir apenas números
        if(ApenasNumeros(txtQtd.getText())){
           
        }else{
            
             if(txtQtd.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           
           txtQtd.setText("");
           txtQtd.requestFocus();
         }
    }//GEN-LAST:event_txtQtdKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          
         // class para formatar os números com casas decimais
        DecimalFormat def = new DecimalFormat("#,##0.00");
       double resultado = 0.0;

        // VALIDAÇÃO DO CAMPO DE TEXTO DO VALOR RECEBIDO;
        if (txtValorReceb.getText().equals("")) {
            //MOSTRA ESSA MENSAGEM CASO ESSA CONDIÇÃO SEJA REALIZADA;
            JOptionPane.showMessageDialog(null, "Digite valor o recebido ? ", "Preenchar campo !", JOptionPane.WARNING_MESSAGE);
         txtValorReceb.requestFocus();
        } else if(txtValortotal.getText().equals("")){
             //MOSTRA ESSA MENSAGEM CASO ESSA CONDIÇÃO SEJA REALIZADA;
            JOptionPane.showMessageDialog(null, "Digite valor o valor total ? ", "Preenchar campo !", JOptionPane.WARNING_MESSAGE);
                txtValortotal.requestFocus();
        }else{
            
            //CASO CONTRÁRIO REALIZA ESSA MÉTODO;

            //Passando valor recebido de String para double;
            double valorReb = Double.parseDouble(txtValorReceb.getText());

            //Passando valor total de String para double;
            double valorTotal = Double.parseDouble(txtValortotal.getText());

            if (valorReb < valorTotal) {
                JOptionPane.showMessageDialog(null, "Valor a Baixo do Valor Total !");
                txtValorReceb.requestFocus();
                 // realizarVenda();
                resultado = valorReb - valorTotal;
                txtTroco.setText("" + resultado);
               String troco=def.format(resultado);
               txtTroco.setText(troco);
            } else {
               // realizarVenda();
                resultado = valorReb - valorTotal;
                txtTroco.setText("" + resultado);
               String troco=def.format(resultado);
               txtTroco.setText(troco);
            }

        }
  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtValorRecebKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorRecebKeyReleased
      //condição para permitir apenas números
        if(ApenasNumeros(txtValorReceb.getText())){
           
        }else{
            
             if(txtValorReceb.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           
           txtValorReceb.setText("");
           txtValorReceb.requestFocus();
         }
    }//GEN-LAST:event_txtValorRecebKeyReleased
// VER SE TEM O CODIGO VENDA SALVO NA TABELA VENDAS 
    public void verificar() {
        boolean clik;

        //método para ver se contém o mesmo código digitado
        
        clik = (codVenda.getText().equals(codVendar) && codVenda.getText().equals(codvenda));

        if (clik) {
          //  JOptionPane.showMessageDialog(null, "Já contém esse código "+codVenda.getText()+" salvor!", "Tenter outro código diferente:", JOptionPane.INFORMATION_MESSAGE);
            codVenda.setText("");
        } else if (!clik) {
            //  JOptionPane.showMessageDialog(null,"NAO TEM ");
        } else if (codVenda.getText().isEmpty()) {
            codVenda.requestFocus();
        } else {
            //Para muda opcão 
            jComboBoxCliente.requestFocus();
        }

    }
    
    
    


  

    public void semClisoDigitando() {
        if (codVenda.getText().equalsIgnoreCase("JAVA")) {
            //  JOptionPane.showMessageDialog(null, "legal");
          //  Valortotal.setText("olá Mundo, JAVA");
           
            TXTValorUnit.setBackground(Color.red);
        } else {
            // JOptionPane.showMessageDialog(null, "Dados Errados tente novamente!");
            txtValortotal.setText("");
            TXTValorUnit.setBackground(Color.WHITE);
        }
    }
 
  




    //Método para  deletar venda;
    public void deletarVendaDoDetalhe() {
        //Instânciando a classe ComprovanteDao;
        ComprovanteDao dao = new ComprovanteDao();

        //Instânciando a classe ComprovanteModel;
        ComprovanteModel cp = new ComprovanteModel();
        cp.setCodDetalhe(Integer.parseInt(codVenda.getText()));
        // colocando objeto cp no método deletar Itens da classe ComprovanteDao ;
        dao.ExcluirUmaVendaDoDetalhe(cp);

    }

    //Método para visualizar todas Vendas;
    public void visualizarVENDAS() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaVend.getModel();
        //Método para não repetir os dados na tabela de comprar;
        modelo.setNumRows(0);
        //Instânciando a classe ComprovanteDao;
        VendaDao dao = new VendaDao();
        //Um Laço de repetição para lista todas compras na tabela comprar no banco de dados; 
        for (VendaModel item : dao.visualizarVenda()) {
            modelo.addRow(new Object[]{
                //Passando os objetos 
                item.getIdDeleta(),
                item.getCodVenda(),
                item.getCodCli(),
                item.getCodProd(),
                item.getQtdProd(),
                item.getValorUnit(),
                item.getValorTotal(),
                item.getData()

            });
        }

    }

    //Método para visualizar todas Vendas pelo código do cliente e da venda;
    public void listacodClienteEaData2() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaVend.getModel();
        //Método para não repetir os dados na tabela de vendas;
        modelo.setNumRows(0);
        //Instânciando a classe ComprovanteDao;
        VendaDao dao = new VendaDao();
        //Um Laço de repetição para lista todas comprar na tabela vendas no banco de dados; 
        for (VendaModel item : dao.listaClienteData2(jComboBoxCliente.getSelectedItem().toString(),txtdata.getText())) {
            modelo.addRow(new Object[]{
                //Passando os objetos 
                item.getIdDeleta(),
                item.getCodVenda(),
                item.getCodCli(),
                item.getCodProd(),
                item.getQtdProd(),
                item.getValorUnit(),
                item.getValorTotal(),
                item.getData()

            });
        }

    }
   
    
    //Método para deletar venda 
    public void deletarVendasPeloCodigo() {
       
        
      //Instânciando a classe VendaDao;
        VendaDao dao = new VendaDao();

        //Instânciando a classe VendaModel;
        VendaModel vd = new VendaModel();
        //setando os valores
        vd.setCodVenda(Integer.parseInt(codVenda.getText()));
        //Passando os valores para objeto dao
        //dao.deletaVendaPeloCodigo(vd);
        
        
        if(dao.deletaVendaPeloCodigo(vd)==true){
                 //Método que vai soma os produtos antes de excluir
                    reporProd();
                     //Método para atualizar produto antes de excluir
                    setaAtualizacaoProduto();
                    //Método para visualizarr vendas apos a exclusão;
                    
                    //seta o valor total da comprar do cliente na label total
                     listacodClienteEaData2();
                     //Método para soma os itens das vendas pelo código da venda  do cliente e da venda
                     somaItensPelo3codigoVendaDataCliente();
                   // codVenda.setText("");
        }else{
                    //seta o valor total da comprar do cliente na label total
                     listacodClienteEaData2();
                     //Método para soma os itens das vendas pelo código da venda  do cliente e da venda
                     somaItensPelo3codigoVendaDataCliente();
        }
       
    }

    //Método para seta os dados dos Produtos nos campos de textos pelo código do cliente;
    public void setaDadosProduto() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //comando para seta os valores nos campos de textos pelo código do produto;
            String sql = "SELECT valorUnit,estoque,nome FROM produto where codProd like'" +jcombProdutos.getSelectedItem()+"'";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            //executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //Seando os valores no campos de textos;
                txtNpro.setText(Rst.getString("nome"));
                TXTestoque.setText(String.valueOf(Rst.getInt("estoque")));
                TXTValorUnit.setText(String.valueOf(Rst.getDouble("valorUnit")));

            } else {
                //  JOptionPane.showMessageDialog(null,"Produto não existe !");
                txtNpro.setText("");
                TXTestoque.setText("");
                TXTValorUnit.setText("");
            }

            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de error exiber essa mensagem
            JOptionPane.showMessageDialog(null, "Produto não Encontrado !");
        }

    }

     
      
    //Método para atualizar  os dados dos Produtos nos campos de textos pelo código do produto;
    public void setaAtualizacaoProduto() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //comando para seta os valores nos campos de textos pelo código do produto;
            String sql = "UPDATE produto  SET estoque=? where codProd='" + jcombProdutos.getSelectedItem() + "'";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            Patm.setInt(1,Integer.parseInt( TXTestoque.getText()));
            //executar
            Patm.executeUpdate();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de error exiber essa mensagem
            JOptionPane.showMessageDialog(null, "Produto não ATUALIZADO !");
        }

    }

    //Método para seta nome dos clientes;
    public void setaNomeClientes() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //Comando para selecionar  nome do cliente pelo código do cliente em um campo de texto;
            String sql = "SELECT nome FROM cliente where codCli like'" + jComboBoxCliente.getSelectedItem() + "'";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            //Executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //setando nome
                txtNcli.setText(Rst.getString("nome"));

            } else {
                //SETA CAMPO VAZIO
                txtNcli.setText("");

            }

            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de algo errado exiber essa mensagem;
            JOptionPane.showMessageDialog(null, "Cliente não encontrado ! ");
        }

    }

    // método para  ver se tem o mesmo código do cliente e de venda para continua adicionando os itens;
    public boolean verDiferencaEntreClienteEcodVenda() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //Comando para selecionar  nome do cliente pelo código do cliente em um campo de texto;
            String sql = "SELECT codCli, codVenda FROM item";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            //Executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //setando codigo do cliente

                idCli = Rst.getString("codCli");
                codVendar = Rst.getString("codVenda");
            } else {
                //SETA CAMPO VAZIO
                txtNcli.setText("");

            }

            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de algo errado exiber essa mensagem;
            JOptionPane.showMessageDialog(null, "Cliente e código de venda não encontrado ! ");
        }
        return true;

    }
    
    
   
   // DecimalFormat df = new DecimalFormat("#,###.00");
    

    //Método para calcular a quantidade pedido pelo cliente
    public void calcularPreVenda() {

        //Passando o campo de texto Qtd de String para inteiro;
        int QTD = Integer.parseInt(txtQtd.getText());

        //Passando o campo de texto Estoque de String para int;
        int ESTOQUE = Integer.parseInt(TXTestoque.getText());

        //laço de repetição para fazer a subtração;
        for (int i=0; i <= ESTOQUE; i++) {

            //guardando o resultado
            contador = i - QTD;

            String cvt = String.valueOf(contador);
            //setando no campo de texto estoque;
            TXTestoque.setText(cvt.replace("-", ""));

            // condição para saber se o estoque é maior do que a Quantidade ou estoque é igual a quantidade;
            if (ESTOQUE >QTD || ESTOQUE==QTD) {

                //setando no campo de texto estoque;
                TXTestoque.setText(String.valueOf(contador));
                TXTestoque.setText(cvt.replace("-",""));
                
                TXTestoque.setText(String.valueOf(contador));
                //condição para saber ser a quantidade é maior do que o estoque; 
            } //condição para saber se a quantidade é maior do que o estoque de produtos
            else if (QTD > ESTOQUE) {

                // se essa condição for realizada será mostrado essa mensagem;
                JOptionPane.showMessageDialog(null, "Quantidade indisponível !", "Error", JOptionPane.ERROR_MESSAGE);

                //setano o valor na label Total;
                labelTotal.setText("");
                break;

            }
        }

        //guarda o resultado
        double multiplicar = 0;
        //Passando valor Unitário String para Double;
        double valorUnit = Double.parseDouble(TXTValorUnit.getText());

        if (true) {

            //guardando o resultado da multiplicação
            multiplicar = valorUnit * QTD;
            valorTotalBD = valorTotalBD + multiplicar;
           txtValortotal.setText(multiplicar+"");
            //setando o resultado na labelTotal;
            labelTotal.setText(String.valueOf(valorTotalBD));
        

        }

    }
    
    
    //Método para realizar a venda;
    public void realizarVenda() {

        txtValortotal.setText(" "+labelTotal.getText());
        
        double valorNegativoBD = 0;

        //Passando valor total de String para double;
        double valorTotal = Double.parseDouble(txtValortotal.getText());

        // Passando o valor recebido de String para double; 
        double valorReceb = Double.parseDouble(txtValorReceb.getText());

        //Fazendo a condição para sabe se o valor recebido é menor  do que o resultado da multiplicação da QTD vezes o valor Unitário;
        if (valorReceb < valorTotal) {
            //Exibindo a mensagem se caso essa condição seja verdadeira;
            JOptionPane.showMessageDialog(null, "Valor a baixo do Total !", "Error", JOptionPane.ERROR_MESSAGE);

            valorNegativoBD = valorReceb - valorTotal;

            txtTroco.setText(String.valueOf("" + valorNegativoBD));
            //Fazendo a condição para sabe se o valor recebido é igual o resultado da multiplicação da QTD vezes o valor Unitário;   
        } else if (valorReceb == valorTotal) {

            JOptionPane.showMessageDialog(null, "Venda Realizada Com Sucesso !", "Obrigado...!", JOptionPane.INFORMATION_MESSAGE);
            //deixando o campo vazio ;
            txtTroco.setText(String.valueOf(""));
        }
        // variável double para guarda o valor inferior da venda;
        double ValorAcima = valorReceb - valorTotal;

        //condição para saber se valor recebido é maior do que valor Unitário;
        if (valorReceb > valorTotal) {

            //setando no campo de texto o troco da venda;
            txtTroco.setText(String.valueOf(ValorAcima));
            tempo();
            JOptionPane.showMessageDialog(null, "Venda Realizada Com Sucesso !", "Obrigado...!", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    //Método para realizar  a venda pelo código;
    public void realizarPeloCodVenda() {

        double valorNegativoBD = 0;

        // Passando o valor recebido de String para double; 
        double valorReceb = Double.parseDouble(txtValorReceb.getText());

        //Fazendo a condição para sabe se o valor recebido é menor  do que o resultado da multiplicação da QTD vezes o valor Unitário;
        if (valorReceb < valorTotalCodBD) {
            //Exibindo a mensagem se caso essa condição seja verdadeira;
            JOptionPane.showMessageDialog(null, "Valor a baixo do Total !", "Error", JOptionPane.ERROR_MESSAGE);

            valorNegativoBD = valorReceb - valorTotalCodBD;

            txtTroco.setText(String.valueOf("" + valorNegativoBD));
            //Fazendo a condição para sabe se o valor recebido é igual o resultado da multiplicação da QTD vezes o valor Unitário;   
        } else if (valorReceb == valorTotalCodBD) {

            JOptionPane.showMessageDialog(null, "Venda Realizada Com Sucesso !", "Obrigado...!", JOptionPane.INFORMATION_MESSAGE);
            //deixando o campo vazio ;
            txtTroco.setText(String.valueOf(""));
        }
        // variável double para guarda o valor inferior da venda;
        double ValorAcima = valorReceb - valorTotalCodBD;

        //condição para saber se valor recebido é maior do que valor Unitário;
        if (valorReceb > valorTotalCodBD) {

            //setando no campo de texto o troco da venda;
            txtTroco.setText(String.valueOf(ValorAcima));
            tempo();
            JOptionPane.showMessageDialog(null, "Venda Realizada Com Sucesso !", "Obrigado...!", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    //Método para limpar os campos de textos e uma Jlabel;
    public void Limpar() {
        codVenda.setText("");
        jComboBoxCliente.setSelectedIndex(0);
        txtQtd.setText("");
        txtValortotal.setText("");
        txtNcli.setText("");
        txtNpro.setText("");
        TXTestoque.setText("");
        TXTValorUnit.setText("");
        txtTroco.setText("");
        txtValorReceb.setText("");
        label.setText("");
        labelTotal.setText("");
        valorTotalBD = 0;
        jcombProdutos.setSelectedIndex(0);
      

    }

    //Método para limpar as linhas da tabela
    public void limpalinha() {
        DefaultTableModel dm = (DefaultTableModel) tabelaVend.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }

    //Método para seta os valor total  dos itens no campo de texto e na label;
    public void somaItensPelo3codigoVendaDataCliente() {

        //int codvd = Integer.parseInt(codVenda.getText());
        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "SELECT round(sum(total),2) FROM item where  codVenda='" + codVenda.getText() + "' and codCli='"+jComboBoxCliente.getSelectedItem()+"'and data='"+txtdata.getText()+"'";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {

                //Pegando o valor da soma
                double total = Rst.getDouble("round(sum(total),2)");
                //setando o valor no campo de texto e na label; 
                labelTotal.setText("" + total);
               // Valortotal.setText("" + total);
                valorTotalCodBD = total;
            }
            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de error mostrar essa mensagem;
            JOptionPane.showMessageDialog(null, "Valor não setado! ");
        }

    }

    //Método para seta os valor total  das vendas no campo de texto e na label conforme o código do cliente;
    public void setaValorTotalDaVendaPeloCodigoClienterEdata() {

        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "SELECT round(sum(total),2) FROM item WHERE codCli=" + jComboBoxCliente.getSelectedItem() + " and data='" + txtdata.getText() + "'";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            //    Patm.setString(1,(String)jComboBoxCliente.getSelectedItem());
            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {

                //Pegando o valor da soma
                double total = Rst.getDouble("round(sum(total),2)");
                //setando o valor no campo de texto e na label; 
                labelTotal.setText("" + total);
               
                valorTotalBD = total;
            }
            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de error mostrar essa mensagem;
            //JOptionPane.showMessageDialog(null, "Valor não setado! ");
        }

    }

    //Método para adiciona os produtos no jcombox;
    public void setaDadosJcomboxProd() {
        //Instânciando a classe PrdutoDao para criar o objeto;  
        ProdutoDao dao = new ProdutoDao();
        // laço de repetição para adicionar o produto;
        for (ProdutoModel p : dao.listaProdutocomNome()) {
            //adicionando os itens no campo de combinação
            jcombProdutos.addItem(p);

        }

    }

    //Método para adiciona o cliente  no jcombox pelo código;
    public void setaDadosJcomboxClientes() {

        //Instânciando a classe clinteDao para criar o objeto;  
        ClienteDao dao = new ClienteDao();

        // laço de repetição para adicionar o cliente;
        for (ClienteModel cli : dao.visualizarClientes()) {
            //Adicionando os itens na caixa de combinação;
            jComboBoxCliente.addItem(cli);

        }

    }
    
    /*
      //Método para adiciona o nome de pagamento no jcomboxPagamentos;
    public void setaDadosJcomboxPagamentos() {

        //Instânciando a classe ComprovanteDao para criar o objeto;  
        ComprovanteDao dao = new ComprovanteDao();

        // laço de repetição para adicionar tipo de pagamentos;
        for (ComprovanteModel pagamentos : dao.visualizarTiposPagamentos()) {
            //Adicionando os itens na caixa de combinação;
            JcomboxPagamento.addItem(pagamentos.toString());

        }

    }
  */

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TXTValorUnit;
    private javax.swing.JTextField TXTestoque;
    private javax.swing.JButton calcular;
    private javax.swing.JTextField codVenda;
    private javax.swing.JButton deletarItem;
    private javax.swing.JPanel digitanome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBoxCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcombProdutos;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel lbHora;
    private javax.swing.JButton salvarVenda;
    private javax.swing.JTable tabelaVend;
    private javax.swing.JTextField txtNcli;
    private javax.swing.JTextField txtNpro;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtTroco;
    private javax.swing.JTextField txtValorReceb;
    private javax.swing.JTextField txtValortotal;
    private javax.swing.JTextField txtdata;
    private javax.swing.JButton visualizar;
    // End of variables declaration//GEN-END:variables

    //Método para zera 
    public void zeroLabel() {

        txtValortotal.setText("0,00");
        labelTotal.setText("0,00");
    }

    //MÉTODO PARA EXECUTAR QUALQUEI AÇÃO EM UM  DETERMINADO TEMPO;
    public void tempo() {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //MÉTODO  PARA  GUARDA TODO VALOR ARMAZENADO NA TABELA VENDA DO BANCO DE DADOS;
    public double totalValorBd() {

        return valorTotalBD;
    }

    //Método para mostrar a data ao abrir essa jFRAME venda;
    public void DataDoDia() {
        Data dt = new Data();
        txtdata.setText(dt.setaData());
       // codVenda.requestFocus();

    }
// class para implementa a hora;

    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar cl = Calendar.getInstance();

            lbHora.setText(String.format("%1$tH:%1$tM:%1$tS", cl));
        }
    }

    //Método para repor a quantidade de produtos caso excluar
    public void reporProd() {

        int estoq = Integer.parseInt(TXTestoque.getText());
         int qtd = Integer.parseInt(txtQtd.getText());

        int rest = estoq + qtd;

        TXTestoque.setText("" + rest);

    }

    //método para preencher os campos obrigatóriamente;
    public void valorNulo() {

        try {
            if (codVenda.getText().isEmpty() && codVenda.getText().length() == 0 || jComboBoxCliente.getSelectedItem().toString().trim().length() == 0 || jcombProdutos.getSelectedItem().toString().trim().length() == 0 || txtQtd.getText() == null && txtQtd.getText().length() < 1
                    || TXTValorUnit.getText().isEmpty() && TXTValorUnit.getText().length() == 0 || txtValortotal.getText().isEmpty() && txtValortotal.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Preenchar os campos corretamente!", "", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("" + e);
        }

    }
   
  
    
    

    //metodo para digita só nomes
    public boolean checkLetters(String str) {

        return str.matches("[a-zA-Z]+");
    }

    //MÉTODO PARRA EVITA LETRAS
    public void permitirNumerosFlutuantes() {

        if (checkLetters(TXTValorUnit.getText()) || checkLetters(txtValortotal.getText())) {
            TXTValorUnit.setBackground(Color.red);
            txtValortotal.setBackground(Color.red);
         
            JOptionPane.showMessageDialog(null, "Não Poder digita letras nesse campos em vermelhos !");

            TXTValorUnit.setBackground(Color.WHITE);
            txtValortotal.setBackground(Color.WHITE);
            
        }

    }

    public void adicionarCodVend() {

        VendaDao d = new VendaDao();
        d.adicionaCodVENDA();
    }
    
     //Método para seta os dados dos Produtos os valores de comprar do vendedor;
    public void setaDadosProdutoValorDeCompra() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //comando para seta os valores de comprar do produto que o vendedor investiu
            String sql = "select valorDcompra from produto where codProd='" + jcombProdutos.getSelectedItem() + "'";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            //executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //Seando os valores no campos de textos;
                valorDoVendedor=Rst.getDouble("valorDcompra");
              
               // txtValorReceb.setText(valorDoVendedor+"");

            } else {
                //  JOptionPane.showMessageDialog(null,"Produto não existe !");
              
            }

            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de error exiber essa mensagem
            JOptionPane.showMessageDialog(null, "Produto não Encontrado !");
        }

    }
    
    
     //Método para seta os códigos da tabela ;
    public void setaCodigoVendaDaTabelaItem() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //comando para seta os codigo da coluna codVenda da tabela item
            String sql = "select * from item ";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            //executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //Setando os valores no campos de textos;
                codigoItem=Rst.getString("codVenda");
              
              

            } else {
                //  JOptionPane.showMessageDialog(null,"Produto não existe !");
              
            }

            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de error exiber essa mensagem
        //    JOptionPane.showMessageDialog(null, "Código do item  não Encontrado !");
        }

    }
    
    //Método para seta a soma e a quantidade dos produtos;
    public void setaDadosDaQtdESoma() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //comando para seta os valores de soma e quantidade
            String sql = "SELECT codProd,sum(Qtd)as Quantidade,sum(total)as total from item where codProd='" + jcombProdutos.getSelectedItem() + "' and data='"+txtdata.getText()+"'";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            //executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                              //Setando os valores no campos de textos;ou variáveis
              QTDProduto=Rst.getInt("Quantidade");
                
                somaTotal= Rst.getDouble("total");
              
             

            } else {
                //  JOptionPane.showMessageDialog(null,"Produto não existe !");
              
            }

            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de error exiber essa mensagem
           // JOptionPane.showMessageDialog(null, "Produto não Encontrado !");
        }

    }
    
     //Método para faze o calculor do ganhor
    public double fazerCalculo(){
          
          //Passando valor Unitário String para Double;
        double valorUnit = Double.parseDouble(TXTValorUnit.getText());
        
        double   multiplicacao1=QTDProduto*valorUnit;
        
         valorDoInvestimento=QTDProduto*valorDoVendedor;
        
            valorLucro =multiplicacao1-valorDoInvestimento;
         
        
    //   JOptionPane.showMessageDialog(null, "lucro "+valorLucro);
        return valorLucro;
      
    }
     //Método para faze o calculor do ganho
    public double fazerCalculoAntesdSalvar(){
          
        double quantidad=Double.parseDouble(txtQtd.getText());
          //Passando valor Unitário String para Double;
        double valorUnit = Double.parseDouble(TXTValorUnit.getText());
        
        double   multiplicacao1=quantidad*valorUnit;
        
        double  multiplicacao2=quantidad*valorDoVendedor;
        
        double subtracao=multiplicacao1-multiplicacao2;
         
        
      
        
     //   JOptionPane.showMessageDialog(null, "valor do lucro "+subtracao);
        
        return subtracao;
     
    }
    
    
    
    
  //Método para adicionar os valores para saber o lucro de toda venda
    public void addValoresNaTabelaLucro(){
        
        LucroModel md = new LucroModel();
        md.setCodigoLucro(String.valueOf(jcombProdutos.getSelectedItem()));
        md.setCodigoProduto(String.valueOf(jcombProdutos.getSelectedItem()));
        md.setQuantidade(QTDProduto);
        md.setValorUnitario(Double.parseDouble(TXTValorUnit.getText()));
        md.setValorTotal(somaTotal);
        md.setValorDcomprar(valorDoVendedor);
        md.setValorInvestir(valorDoInvestimento);
        md.setValorGanhor(valorLucro);
        md.setData(txtdata.getText());
        
        LucroDao vd = new LucroDao();
        vd.adicionarDadosLucros(md);
    }

     //Método para seta a data do lucro;
    public void setacodigoDoLucro() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //comando para seta a data do lucro
            String sql = "SELECT codProd from lucro";
            PreparedStatement Patm = Conn.prepareStatement(sql);
            //executar
            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {
            //Setando o codLud 
               codigoLUCRO=Rst.getString("codProd");
                
           //   JOptionPane.showMessageDialog(null," Código do lucro é "+codigoLUCRO);

            } 

            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de error exiber essa mensagem
        //    JOptionPane.showMessageDialog(null, "data não Encontrado !");
        }

    }
  
     //Método para seta o código da tabela detalhe;
    public void setacodigoDaTabelaDetalhe() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //comando para seta o código da tabela
            String sql = "SELECT codDetalh from detalhe";
            PreparedStatement Patm = Conn.prepareStatement(sql);
            //executar
            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {
            //Setando o código
               codDetalhe=Rst.getString("codDetalh");
                
              JOptionPane.showMessageDialog(null," Código do detalhe "+codigoLUCRO);

            } 

            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de error exiber essa mensagem
            JOptionPane.showMessageDialog(null, "data não Encontrado !");
        }
    }
     
    //Método para atualizar os dados do lucro
     public void setaLucroeAtualizarLucror(){
         //Instânciando a classe LucroDao;
              LucroDao dao= new LucroDao();
              //Instânciando a classe LucroModel; 
              LucroModel prod = new LucroModel();
            //  prod.setCodigoLucro(String.valueOf(jcombProdutos.getSelectedItem()));
              prod.setCodigoProduto(String.valueOf(jcombProdutos.getSelectedItem()));
              prod.setQuantidade(QTDProduto);
              prod.setValorUnitario(Double.parseDouble(TXTValorUnit.getText()));
              prod.setValorTotal(somaTotal);
              prod.setValorDcomprar(Double.parseDouble(valorDoVendedor+""));
              prod.setValorInvestir(valorDoInvestimento);
              prod.setValorGanhor(valorLucro);
              prod.setData(txtdata.getText());
             //Passando objeto da classe lucroModel´para objeto da classe lucroDao;
                dao.atualizarLucro(prod);
   }
     
     //Método para saber se tem dados na tabela venda;
    public void verificarSetemDadosNaTabelavendas() {
        
        

        try {
            Connection Conn = Conexao_BD.getConnection();

            //Comando para selecionar  os dados da tabela vendas
            String sql = "SELECT codItem,codVenda,codCli,codProd,Qtd,valorUnit,total,data FROM item";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            //Executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //setando os dados
                codExclui=Rst.getString("codItem");
                codDVenda=Rst.getString("codVenda");
                codCliente=Rst.getString("codCli");
                codProduto=Rst.getString("codProd");
                DATA=Rst.getString("data");
                QtdProd=Rst.getInt("Qtd");
                valorunit=Rst.getDouble("valorUnit");
                TOTAL=Rst.getDouble("total");
                     
            } 

            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de algo errado exiber essa mensagem;
            JOptionPane.showMessageDialog(null, "dados não encontrado ! ");
        }
        
       
    }
    //método para ver se não tem dados na tabela vendas
    public void tabelavazia(){
         //verificar se a tabela do banco de dados estão vazia
        verificarSetemDadosNaTabelavendas();
        if(codCliente==null&&codExclui==null&&codDVenda==null&&codProduto==null&&DATA==null&&String.valueOf(QtdProd)==null&&String.valueOf(valorunit)==null&& String.valueOf(TOTAL)==null){
            JOptionPane.showMessageDialog(null,"Não contém dados salvo nessa tabela ! ");
        }
        else{
            visualizarVENDAS();
        }
        
    }
    //Método para seta os códigos da tabela venda;
    public void setaCodigoDaVenda() {
        
        

        try {
            Connection Conn = Conexao_BD.getConnection();

            //Comando para selecionar  os dados da tabela vendas
            String sql = "SELECT max(codVenda) FROM vendas";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            //Executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //setando os dados
                codigoVendaTvd=Rst.getString("max(codVenda)");
                
            } 

            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de algo errado exiber essa mensagem;
            JOptionPane.showMessageDialog(null, "dados não encontrado ! ");
        }
        
       
    }
  
    
    //métodos para aceitar somente números
      public boolean ApenasNumeros(String str){
        
         return str.matches("^[0/.-9 ]+");
        
      // return s.matches("[^0-9]+");
    }
    
    //metodo para digita só nomes
    public boolean ApenaLetras(String str) {

        return str.matches("[a-zA-Z é ê ô ó á!úûí @õ ç â~,.ã^~,.]+");
    }
    
}

    
    

