package View;

import Conexao.Conexao_BD;
import Dao.ClienteDao;
import Dao.ComprovanteDao;
import Dao.DataDao;
import Dao.LucroDao;
import Dao.ProdutoDao;
import Dao.VendaDao;
import Model.ApenasNumeros;
import Model.ClienteModel;
import Model.ComprovanteModel;
import Model.Data;
import Model.IDvenda;
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

    
    
    //Para fazer guarda o resultado da subtração da quantidade em estoque com a quantida pedido pelo cliente;
    int contador = 0;

    int cont = 0;

    //VALOR TOTAL DE TODA TABELA COMPRAR
    double valorTotalBD = 0;

    double valorTotalCodBD = 0;
   
    //pega o valor do produto que o vendedor comprou;
     double valorDoVendedor=0;
    //método para pega o valor de lucro
     double valorLucro=0;
     
     //Variável soma Quantidade de produto
     int QTDProduto=0;
     //Variável soma tota de produto
     double somaTotal=0;
     
     //Variável para armazenar O código  lucro
     String codigoLUCRO="";
     
     //variável para armazenar a data salva na tabela vendas;
     String data ="";
    public Venda() {
        initComponents();
        //centralizando ao centro da tela
        setLocationRelativeTo(null);

        //Método para seta os nomes dos produtos;
        setaDadosJcomboxClientes();

        setaDadosJcomboxProd();

        //método para armazenar o valor total de toda comprar ao abrir não zera;
        totalValorBd();

        //Método para exibir a data ao abrir 
        DataDoDia();

        //método para digita somente números
        soNumeros();

        veriguar();
        //Método para saber se a data já contém salvar na tabela vendas
       // distinguiData();
       
       //Método para salvar caso não tenha a data salvar
       setaDataDoBancoDeDados();
    }

    //Para armazenar o id da venda no banco de dados
    String nom = "";

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
        ValorUnit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Valortotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValorReceb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTroco = new javax.swing.JTextField();
        calcular = new javax.swing.JButton();
        visualizar = new javax.swing.JButton();
        Adicionar = new javax.swing.JButton();
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
        Realizar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        deleatarVd = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        addItem = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        deletarItem = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        visualizaItens = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        detalheItens = new javax.swing.JButton();
        labelTotal = new javax.swing.JLabel();
        somaItens = new javax.swing.JButton();
        jcombProdutos = new javax.swing.JComboBox();
        jComboBoxCliente = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        txtdata = new javax.swing.JTextField();
        lbHora = new javax.swing.JLabel();
        txtComplet = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtVZ = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtvalorCompleto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venda");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        digitanome.setBackground(new java.awt.Color(133, 182, 139));
        digitanome.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Código venda:");

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
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                codVendaInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
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
        });

        jLabel4.setText("Valor Unitário:");

        ValorUnit.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                ValorUnitInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        jLabel5.setText("Valor Total:");

        Valortotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setText("Valor Recebido:");

        txtValorReceb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorRecebActionPerformed(evt);
            }
        });
        txtValorReceb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorRecebKeyPressed(evt);
            }
        });

        jLabel7.setText("Troco:");

        txtTroco.setEditable(false);
        txtTroco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTroco.setForeground(new java.awt.Color(255, 0, 51));

        calcular.setText("Calcular");
        calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularActionPerformed(evt);
            }
        });

        visualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/visualizador.png"))); // NOI18N
        visualizar.setText("Visualizar");
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

        Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/salve-.png"))); // NOI18N
        Adicionar.setText("Adicionar");
        Adicionar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
            }
        });
        Adicionar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AdicionarKeyPressed(evt);
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
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
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
                "CodDeleta", "CodVend", "CodCli", "CodProd", "Qtd_Prod", "Completo", "Vazilhame", "ValorUnit", "ValorTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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

        Realizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/venda-rapida.png"))); // NOI18N
        Realizar.setText("Realizar");
        Realizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Realizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RealizarActionPerformed(evt);
            }
        });

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

        deleatarVd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/claro.png"))); // NOI18N
        deleatarVd.setText("Excluir");
        deleatarVd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleatarVd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleatarVdActionPerformed(evt);
            }
        });

        jLabel13.setText("Add Item:");

        addItem.setText("+");
        addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemActionPerformed(evt);
            }
        });

        jLabel14.setText("Deletar Item:");

        deletarItem.setText("-");
        deletarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarItemActionPerformed(evt);
            }
        });

        jLabel15.setText("Visualizar Pelo Código Vd:");

        visualizaItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/visualizador.png"))); // NOI18N
        visualizaItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizaItensActionPerformed(evt);
            }
        });

        jLabel16.setText("Comprovante:");

        detalheItens.setText("Clique aqui");
        detalheItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalheItensActionPerformed(evt);
            }
        });

        labelTotal.setBackground(new java.awt.Color(255, 255, 0));
        labelTotal.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N

        somaItens.setText("Somar Itens");
        somaItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                somaItensActionPerformed(evt);
            }
        });

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

        jLabel18.setText("Completo:");

        jLabel19.setText("Vz:");

        txtvalorCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalorCompletoActionPerformed(evt);
            }
        });

        jLabel20.setText("Valor Completo:");

        javax.swing.GroupLayout digitanomeLayout = new javax.swing.GroupLayout(digitanome);
        digitanome.setLayout(digitanomeLayout);
        digitanomeLayout.setHorizontalGroup(
            digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(digitanomeLayout.createSequentialGroup()
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(digitanomeLayout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(addItem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(58, 58, 58)
                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(digitanomeLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(deletarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(digitanomeLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(visualizaItens, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)
                                        .addComponent(detalheItens))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, digitanomeLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)))
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane1)
                                .addGap(20, 20, 20))))
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorReceb, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, digitanomeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, digitanomeLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(digitanomeLayout.createSequentialGroup()
                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(114, 114, 114)
                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(digitanomeLayout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(digitanomeLayout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(digitanomeLayout.createSequentialGroup()
                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jComboBoxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(TXTestoque, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                            .addComponent(Valortotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(digitanomeLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(txtNcli))
                                            .addGroup(digitanomeLayout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtNpro)
                                                    .addGroup(digitanomeLayout.createSequentialGroup()
                                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                                .addGap(8, 8, 8))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(digitanomeLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 280, Short.MAX_VALUE)))
                                .addGap(127, 127, 127)))))
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, digitanomeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(somaItens, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtQtd, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(digitanomeLayout.createSequentialGroup()
                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtComplet)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtVZ, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtvalorCompleto)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jcombProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(20, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, digitanomeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleatarVd, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Realizar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        digitanomeLayout.setVerticalGroup(
            digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(digitanomeLayout.createSequentialGroup()
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(codVenda)
                    .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNcli, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcombProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxCliente))
                .addGap(27, 27, 27)
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXTestoque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNpro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtComplet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVZ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(digitanomeLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(digitanomeLayout.createSequentialGroup()
                                        .addComponent(txtvalorCompleto)
                                        .addGap(29, 29, 29)))
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(digitanomeLayout.createSequentialGroup()
                                        .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(somaItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(8, 8, 8))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18))
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addComponent(ValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(txtValorReceb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addComponent(visualizaItens, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addItem))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addComponent(detalheItens)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deletarItem)))
                        .addGap(29, 29, 29)))
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Realizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleatarVd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(digitanome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(digitanome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
     
        //método para ver se tem so letras no campo do código da venda
        if (checkLetters(codVenda.getText())) {
            codVenda.setBackground(Color.BLUE);
            JOptionPane.showMessageDialog(null, "Nesse Campo em Azul não poder digita só Letras! ");
            codVenda.setBackground(Color.WHITE);
            codVenda.setText("");
            codVenda.requestFocus();

        } else {
            //Método para saber ser tem algo campo nulo
            valorNulo();
              //Método para adicionar um código na tabela codVendar depois passar 
             //para tabela vendas o código armazenador 
            adicionarCodVenda();
            //MÉTODO PARA ADICIONAR A VENDA NO BANCO DE DADOS
            adicionarVendas();
            //assim que salvar mostrar todos produtos vendidos
            visualizarVENDAS();
             tempo();
             //Método para seta os dados da tabela vendas para fazer o calculor do lucro
         setaDadosDaQtdESoma();
         tempo();
         //método para fazer o calculor do lucro 
         fazerCalculo();
         tempo();
         
            //Método para verificar se existe o código na tabela lucro
         setacodigoDoLucro(); 
         
          if(String.valueOf(jcombProdutos.getSelectedItem()).equals(codigoLUCRO)){
            JOptionPane.showMessageDialog(null,"tem esse código ");
            setaLucroeAtualizarLucro();
        }else{
             JOptionPane.showMessageDialog(null,"Não tem essa data ");
             JOptionPane.showMessageDialog(null,"Aí vai salvar  ");
               //Método para salvar os dados na tabela lucro
           addValoresNaTabelaLucro();
        }
        
         
       
        }


    }//GEN-LAST:event_AdicionarActionPerformed

    //Metodo para adicionar vendas
    public void adicionarVendas() {
        //Instânciando a classe VendaDao;
        VendaDao dao = new VendaDao();

        //Instânciando a classe VendaModel;
        VendaModel vd = new VendaModel();
        //Setando os valores ;
        vd.setCodVenda(codVenda.getText());
        vd.setCodCli(String.valueOf(jComboBoxCliente.getSelectedItem()));
        vd.setCodProd(String.valueOf(jcombProdutos.getSelectedItem()));
        vd.setQtdProd(Integer.parseInt(txtQtd.getText()));
        vd.setCompleto(Integer.parseInt(txtComplet.getText()));
        vd.setVz(Integer.parseInt(txtVZ.getText()));
        vd.setValorUnit(Double.parseDouble(ValorUnit.getText()));
        vd.setValorTotal(Double.parseDouble(Valortotal.getText()));
        vd.setData(txtdata.getText());

        //Passando os valores no objeto dao da classe VendaDao;
        dao.adicionaVenda(vd);

    }


    private void calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularActionPerformed

        permitirNumerosFlutuantes();
           //soma valores dos produtos
            somaValores();
            //Mostrando o valor comprado pelo vendedor;
          setaDadosProdutoValorDeCompra();
          
          //método para calcula a soma de todo  
          fazerCalculoAntesdSalvar();
        //  setaDadosDaQtdESoma();
          //fazendo o calculo do lucro
        // fazerCalculo();
          //salvando no banco de dados na tabela lucro
         // addValores();
    
    }//GEN-LAST:event_calcularActionPerformed

    //método para soma os valores
    public void somaValores(){
          // condição para  poder calcular a venda
        if (txtQtd.getText().equals("")) {
            txtQtd.requestFocus();
        } else {

            int estoq = Integer.parseInt(TXTestoque.getText());

            int qtd = Integer.parseInt(txtQtd.getText());

            if (estoq > qtd) {
                
               
                //Método para calcular Pre venda;
                calcularPreVenda();

            } else {

                // se essa condição for realizada será mostrado essa mensagem;
                JOptionPane.showMessageDialog(null, "Quantidade insuficiente !", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
    
    private void tabelaVendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendMouseClicked

        //Seta os valores nos campos de textos ao clicar na inha da tabela;
        if (tabelaVend.getSelectedRow() != -1) {

            codVenda.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 0).toString());
            jComboBoxCliente.setSelectedItem(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 1).toString());
            jcombProdutos.setSelectedItem(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 2).toString());
            txtQtd.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 3).toString());
            ValorUnit.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 4).toString());
            Valortotal.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 5).toString());

        }


    }//GEN-LAST:event_tabelaVendMouseClicked


    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed

        //Método para visualizarr vendas;
        visualizarVENDAS();
    }//GEN-LAST:event_visualizarActionPerformed

    private void RealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RealizarActionPerformed

        //condição para saber se o campo de texto de recebimento está vazio; 
        if (txtValorReceb.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite valor recebido ? ", "Preenchar campo !", JOptionPane.WARNING_MESSAGE);
        } else {

            //método para verificar se tem algun campo vario
            valorNulo();
            //método para adicionar a venda no banco de dados  
            adicionarVendas();
            //Método para realizar venda;
            realizarVenda();
        }

    }//GEN-LAST:event_RealizarActionPerformed

    private void ValorUnitInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ValorUnitInputMethodTextChanged

    }//GEN-LAST:event_ValorUnitInputMethodTextChanged

    private void txtQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdActionPerformed


    }//GEN-LAST:event_txtQtdActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Método para limpar os campos de textos;
        Limpar();
        //Método para limpar as linhas da tabela;
        limpalinha();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void deleatarVdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleatarVdActionPerformed

        //Variável para pergunta se usuárioque deletar pelo código da venda
        int venda = JOptionPane.showConfirmDialog(null, "Deseja deletar venda ?", "Escolha Opção:", JOptionPane.YES_NO_CANCEL_OPTION);
        //fazendo a codição
        switch (venda) {
            //opcão sim
            case JOptionPane.YES_OPTION:
                // condiçao para valida o campo de texto de código venda 
                if (codVenda.getText().equals("")) {
                    //caso seja verdade mostrar essa mensagem
                    JOptionPane.showMessageDialog(null, "Preenchar Campo do código Venda Com Código Deleta!", "Obrigatório!", JOptionPane.WARNING_MESSAGE);
                } else {
                    //Método para deletar venda pelo código da venda;
                    deletarVendasPeloCodigo();
                    //Método para visualizarr vendas apos a exclusão;
                    visualizarVENDAS();
                    codVenda.setText("");

                }
                break;
            //opção não
            case JOptionPane.NO_OPTION:
                //Instânciando a classe VendaDao;
                VendaDao dao = new VendaDao();
                //Método para deletar toda venda
                dao.deletaTodaVenda();
                break;
            //opcãp cancelar
            case JOptionPane.CANCEL_OPTION:
                //mostrar ess mensagem caso cancelar a opção
                JOptionPane.showMessageDialog(null, "Opção Cancelada!", "", JOptionPane.INFORMATION_MESSAGE);

                break;
            default:
                //caso não for nenhuma dessa a cima será exibida essa mensagem;
                JOptionPane.showMessageDialog(null, "Tenter Novamente...", "Opção Invalida!", JOptionPane.INFORMATION_MESSAGE);
                break;
        }


    }//GEN-LAST:event_deleatarVdActionPerformed

    private void addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemActionPerformed
        //adicionarCodVenda();

        addItem();

    }//GEN-LAST:event_addItemActionPerformed

    public void addItem() {
        ComprovanteDao DAO = new ComprovanteDao();
        ComprovanteModel modelo = new ComprovanteModel();

        modelo.setCodDetalhe(codVenda.getText());
        modelo.setIdVenda(codVenda.getText());
        modelo.setCodCli(String.valueOf(jComboBoxCliente.getSelectedItem()));
        modelo.setValorTotal(Double.parseDouble(Valortotal.getText()));
        modelo.setData(txtdata.getText());
        DAO.adicionaItem(modelo);

    }

    private void visualizaItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizaItensActionPerformed

        Detalhe dt = new Detalhe();
        dt.setVisible(true);

        /*
        //Verificar se campo está vázio;
        if(codVenda.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Preenchar código da venda !","Por favor:",JOptionPane.WARNING_MESSAGE);
             codVenda.requestFocus();
             //para mostrar toda venda
             visualizarVENDAS();
        }else{
            // caso ao contrário exiber essa mensagem;
        JOptionPane.showMessageDialog(null, "Visualizando a venda pelo código "+codVenda.getText());
        visualizarPeloCodigoVenda();
        }
         */
    }//GEN-LAST:event_visualizaItensActionPerformed


    private void detalheItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalheItensActionPerformed

        //Instânciando Jlabel comprovante ;
        Comprovante com = new Comprovante();
        //Passando o objeto comprovante para abrir a tela;
        com.setVisible(true);

    }//GEN-LAST:event_detalheItensActionPerformed

    private void deletarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarItemActionPerformed

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

    private void somaItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_somaItensActionPerformed

        // opcão para escolhe qual maneira que somar a venda
        int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja Fazer A somar ", "Escolha Opção:", JOptionPane.YES_NO_CANCEL_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {

            int opcao = JOptionPane.showConfirmDialog(null, "Deseja fazer pelo código do Cliente ? ", "Escolha Opção:", JOptionPane.YES_NO_CANCEL_OPTION);

            if (opcao == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Valor á ser mostrado será pelo código do cliente do Nome " + txtNcli.getText(), "Informações: ", JOptionPane.INFORMATION_MESSAGE);
                //método para soma todas vendas
                setaValorTotalDaVendaPeloCodigoCliente();
            } else {

                if (opcao == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Nesse caso vai fazer a somar pelo código da venda !");

                    if (codVenda.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Preenchar Campo do código Venda,tente novamente!", "Obrigatório!", JOptionPane.WARNING_MESSAGE);
                        codVenda.requestFocus();
                    } else {
                        //Método para seta os valores da VENDA;
                        setaValorTotalDaVENDAPelocod();

                    }
                } else if (opcao == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(null, "Opção Invalida !");
                }
            }
        }


    }//GEN-LAST:event_somaItensActionPerformed

    private void jcombProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombProdutosActionPerformed

        //condição pra saber se jcomboBox produto esta seleciona em 0 
        if (jcombProdutos.getSelectedIndex() == 0) {
            //MOSTRAR ESSA MENSAGEM CASO ESTEJA SELECIONADO 
            JOptionPane.showMessageDialog(null, "Produto não escolhido ?");

        } else {

            //Método para seta nome dos clientes   
            setaNomeClientes();

            //método para seta os dados do produto
            setaDadosProduto();
            txtQtd.setText("");
            if (txtQtd.getText().equals("")) {
                txtQtd.requestFocus();
            } else {

                //método para calcular a venda
                calcularPreVenda();

            }

        }


    }//GEN-LAST:event_jcombProdutosActionPerformed

    private void jcombProdutosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcombProdutosKeyPressed

    }//GEN-LAST:event_jcombProdutosKeyPressed

    private void jComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClienteActionPerformed
        //Método para seta nome do cliente pelo jcomboBox
        setaNomeClientes();

    }//GEN-LAST:event_jComboBoxClienteActionPerformed

    private void codVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codVendaActionPerformed

        //método para ver se contém o mesmo id digitado
        veriguar();

        if (codVenda.getText().equals(nom)) {
            JOptionPane.showMessageDialog(null, "jÁ TEM ESSE ID");
        } else {
            JOptionPane.showMessageDialog(null, "NAO TEM ");
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
    }//GEN-LAST:event_txtQtdKeyPressed

    private void txtValorRecebKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorRecebKeyPressed

    }//GEN-LAST:event_txtValorRecebKeyPressed

    private void txtValorRecebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorRecebActionPerformed

        double resultado = 0;

        // VALIDAÇÃO DO CAMPO DE TEXTO DO VALOR RECEBIDO;
        if (txtValorReceb.getText().equals("")) {
            //MOSTRA ESSA MENSAGEM CASO ESSA CONDIÇÃO SEJA REALIZADA;
            JOptionPane.showMessageDialog(null, "Digite valor recebido ? ", "Preenchar campo !", JOptionPane.WARNING_MESSAGE);
        } else {
            //CASO CONTRÁRIO REALIZA ESSA MÉTODO;

            //Passando valor recebido de String para double;
            double valorReb = Double.parseDouble(txtValorReceb.getText());

            //Passando valor total de String para double;
            double valorTotal = Double.parseDouble(Valortotal.getText());

            if (valorReb < valorTotal) {
                JOptionPane.showMessageDialog(null, "Valor a Baixo do SubTotal !");
                txtValorReceb.requestFocus();
            } else {
                realizarVenda();
                resultado = valorReb - valorTotal;
                txtTroco.setText("" + resultado);

            }

        }
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

    private void AdicionarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdicionarKeyPressed

        valorNulo();
    }//GEN-LAST:event_AdicionarKeyPressed

    private void txtdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdataActionPerformed

        int opcao = JOptionPane.showConfirmDialog(null, "Deseja adicionar a Data", "", JOptionPane.YES_NO_CANCEL_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
         //  distinguiData();
                   salvarData();

        } else if (opcao == JOptionPane.NO_OPTION) {

            int opcaoo = JOptionPane.showConfirmDialog(null, "Tem Certeza que deseja excluir a data?", "Confimar:", JOptionPane.YES_NO_CANCEL_OPTION);

            if (opcaoo == JOptionPane.YES_OPTION) {
              
                String dat=JOptionPane.showInputDialog(null,"Deseja deletar todas datas");
                if(dat.equalsIgnoreCase("sim")){
                   DataDao dt = new DataDao();
                dt.deletaTodaData();  
                
            }else{
                     deletadat(); 
                }

          }
        }
    }//GEN-LAST:event_txtdataActionPerformed

    private void txtdataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdataKeyPressed
      
    }//GEN-LAST:event_txtdataKeyPressed

    private void txtvalorCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalorCompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalorCompletoActionPerformed

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
        // TODO add your handling code here:
  
    }//GEN-LAST:event_codVendaKeyReleased

    private void txtdataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdataKeyReleased
       
    }//GEN-LAST:event_txtdataKeyReleased
// VER SE TEM O ID SALVO NA TABELA VENDAS 
    public void verificar() {
        boolean clik;

        //método para ver se contém o mesmo id digitado
        veriguar();
        clik = (codVenda.getText().equals(nom));

        if (clik) {
            JOptionPane.showMessageDialog(null, "Já contém esse código salvor!", "Tenter outro código diferente:", JOptionPane.INFORMATION_MESSAGE);
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
    
    //método para ver se existe data salvar no banco de dados vendas
     public void distinguiData() {
        boolean clik;

        //método para ver se contém a mesma data
         verificaData();
        clik = (txtdata.getText().equals(data));

        if (clik) {
            JOptionPane.showMessageDialog(null, "Já contém essa data salvar!", "Tenter outra data diferente:", JOptionPane.INFORMATION_MESSAGE);
            txtdata.setText(""+data);
        } else if (!clik) {
              JOptionPane.showMessageDialog(null,"NAO TEM ESSA DATA AINDA SALVAR!");
              //VAI SALVAR A DATA NO BANCO DE DADOS
              salvarData();
        } else if (txtdata.getText().isEmpty()) {
            txtdata.requestFocus();
        } 

    }


    // ver se tem cliente distinto
    public void verificarClienteDiferente() {
        

        //método para ver se contém o mesmo id digitado
        veriguar();
       
        
        
        if (idCli!=idCli) {
           //caso seja diferente o sistema zera os dados e limpa
            JOptionPane.showMessageDialog(null, "O Sistema vai zera os valores,  ", "Nesse caso contém cliente diferente", JOptionPane.INFORMATION_MESSAGE);
            Limpar();

        } else {
        
           
        }

    }

    public void semClisoDigitando() {
        if (codVenda.getText().equalsIgnoreCase("JAVA")) {
            //  JOptionPane.showMessageDialog(null, "legal");
            Valortotal.setText("olá Mundo, JAVA");
            txtvalorCompleto.setVisible(true);
            ValorUnit.setBackground(Color.red);
        } else {
            // JOptionPane.showMessageDialog(null, "Dados Errados tente novamente!");
            Valortotal.setText("");
            ValorUnit.setBackground(Color.WHITE);
        }
    }
 //método para deleta a data
    public void deletadat() {
        DataDao dt = new DataDao();

        Data data = new Data();

        data.setData(txtdata.getText());

        dt.deletaData(data);
    }
  


//Método para  deletar idComprar da tabela idvenda;
    public void deletaridComprar() {
        //Instânciando a classe ComprovanteDao;
        ComprovanteDao dao = new ComprovanteDao();

        //Instânciando a classe ComprovanteModel;
        ComprovanteModel cp = new ComprovanteModel();
        cp.setIdVenda(codVenda.getText());
        // colocando objeto cp no método deletar Itens da classe ComprovanteDao ;
        dao.deletaIdComprar(cp);

    }

    //Método para  deletar item;
    public void deletarItem() {
        //Instânciando a classe ComprovanteDao;
        ComprovanteDao dao = new ComprovanteDao();

        //Instânciando a classe ComprovanteModel;
        ComprovanteModel cp = new ComprovanteModel();
        cp.setIdExcluir(Integer.parseInt(codVenda.getText()));
        // colocando objeto cp no método deletar Itens da classe ComprovanteDao ;
        dao.ExcluirItem(cp);

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
                item.getCompleto(),
                item.getVz(),
                item.getValorUnit(),
                item.getValorTotal(),
                item.getData()

            });
        }

    }

    //Método para visualizar todas Vendas;
    public void visualizarPeloCodigoVenda() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaVend.getModel();
        //Método para não repetir os dados na tabela de comprar;
        modelo.setNumRows(0);
        //Instânciando a classe ComprovanteDao;
        VendaDao dao = new VendaDao();
        //Um Laço de repetição para lista todas compras na tabela comprar no banco de dados; 
        for (VendaModel item : dao.visualizarPeloCodVenda(codVenda.getText())) {
            modelo.addRow(new Object[]{
                //Passando os objetos 
                item.getIdDeleta(),
                item.getCodVenda(),
                item.getCodCli(),
                item.getCodProd(),
                item.getQtdProd(),
                item.getCompleto(),
                item.getVz(),
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
        vd.setIdDeleta(Integer.parseInt(codVenda.getText()));
        //Passando os valores para objeto dao
        dao.deletaVendaPeloCodigo(vd);
    }

    //Método para seta os dados dos Produtos nos campos de textos pelo código do cliente;
    public void setaDadosProduto() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //comando para seta os valores nos campos de textos pelo código do produto;
            String sql = "SELECT valorUnit,estoque,nome FROM produto where codProd like'" + jcombProdutos.getSelectedItem() + "'";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            //executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //Seando os valores no campos de textos;
                txtNpro.setText(Rst.getString("nome"));
                TXTestoque.setText(String.valueOf(Rst.getInt("estoque")));
                ValorUnit.setText(String.valueOf(Rst.getDouble("valorUnit")));

            } else {
                //  JOptionPane.showMessageDialog(null,"Produto não existe !");
                txtNpro.setText("");
                TXTestoque.setText("");
                ValorUnit.setText("");
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
            Patm.setString(1, TXTestoque.getText());
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

    // método para  ver se tem o mesmo id digitado 
    public boolean veriguar() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //Comando para selecionar  nome do cliente pelo código do cliente em um campo de texto;
            String sql = "SELECT codVendar FROM vendas where codVendar like '" + codVenda.getText() + "'";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            //Executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //setando codigo venda

                nom = Rst.getString("codVendar");
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
        return true;

    }
    
    
    // método para  ver se tem a data salvar;
    public boolean verificaData() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //Comando para seleciona a data salvar na tabela de vendas
            String sql = "SELECT data FROM vendas ";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            //Executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //setando a data

                data = Rst.getString("data");
            } 
            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de algo errado exiber essa mensagem;
            JOptionPane.showMessageDialog(null, "data não encontrada ! ");
        }
        return true;

    }


    // método para  ver se tem o mesmo id do cliente ao continua adicionando os itens;
    public boolean verDiferenca() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //Comando para selecionar  nome do cliente pelo código do cliente em um campo de texto;
            String sql = "SELECT codCli FROM vendas where codCli like '" + jComboBoxCliente.getSelectedItem() + "'";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            //Executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //setando codigo do cliente

                idCli = Rst.getString("codCli");
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
        return true;

    }

    //Método para calcular a quantidade pedido pelo cliente
    public void calcularPreVenda() {

        //Passando o campo de texto Qtd de String para Inteiro;
        Integer QTD = Integer.parseInt(txtQtd.getText());

        //Passando o campo de texto Estoque de String para Inteiro;
        Integer ESTOQUE = Integer.parseInt(TXTestoque.getText());

        //laço de repetição para fazer a subtração;
        for (int i = 0; i <= ESTOQUE; i++) {

            //guardando o resultado
            contador = i - QTD;

            String cvt = String.valueOf(contador);
            //setando no campo de texto estoque;
            TXTestoque.setText(cvt.replace("-", ""));

            // condição para saber se o estoque é maior do que a Quantidade ou estoque é igual a quantidade;
            if (ESTOQUE > QTD || ESTOQUE == QTD) {

                //setando no campo de texto estoque;
                TXTestoque.setText(String.valueOf(contador));
                TXTestoque.setText(cvt.replace("-", ""));
                TXTestoque.setText("" + contador);
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
        double valorUnit = Double.parseDouble(ValorUnit.getText());

        //guarda o valor completo do produto e passando de String para double;
        double valorCompleto = Double.parseDouble(txtvalorCompleto.getText());

        if (true) {

            //guardando o resultado da multiplicação
            multiplicar = valorUnit * QTD;
            valorTotalBD = valorTotalBD + multiplicar + valorCompleto;
           Valortotal.setText(multiplicar+"");
            //setando o resultado na labelTotal;
            labelTotal.setText(String.valueOf(valorTotalBD));
        

        }

    }

    //Método para realizar a venda;
    public void realizarVenda() {

        double valorNegativoBD = 0;

        //Passando valor total de String para double;
        double valorTotal = Double.parseDouble(Valortotal.getText());

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
        Valortotal.setText("");
        txtNcli.setText("");
        txtNpro.setText("");
        TXTestoque.setText("");
        ValorUnit.setText("");
        txtTroco.setText("");
        txtValorReceb.setText("");
        label.setText("");
        labelTotal.setText("");
        txtVZ.setText("");
        txtvalorCompleto.setText("");
        txtComplet.setText("");
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
    public void setaValorTotalDaVENDAPelocod() {

        //int codvd = Integer.parseInt(codVenda.getText());
        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "SELECT round(sum(total),2) FROM vendas where codVenda=" + codVenda.getText() + " and data='" + txtdata.getText() + "'";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {

                //Pegando o valor da soma
                double total = Rst.getDouble("round(sum(total),2)");
                //setando o valor no campo de texto e na label; 
                labelTotal.setText("" + total);
                Valortotal.setText("" + total);
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
    public void setaValorTotalDaVendaPeloCodigoCliente() {

        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "SELECT round(sum(total),2) FROM vendas WHERE codCli=" + jComboBoxCliente.getSelectedItem() + " and data='" + txtdata.getText() + "'";

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
            JOptionPane.showMessageDialog(null, "Valor não setado! ");
        }

    }

    //Método para adiciona os produtos no jcombox;
    public void setaDadosJcomboxProd() {
        //Instânciando a classe PrdutoDao para criar o objeto;  
        ProdutoDao dao = new ProdutoDao();
        // laço de repetição para adicionar o produto;
        for (ProdutoModel p : dao.visualizarProduto()) {
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

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JButton Realizar;
    private javax.swing.JTextField TXTestoque;
    private javax.swing.JTextField ValorUnit;
    private javax.swing.JTextField Valortotal;
    private javax.swing.JButton addItem;
    private javax.swing.JButton calcular;
    private javax.swing.JTextField codVenda;
    private javax.swing.JButton deleatarVd;
    private javax.swing.JButton deletarItem;
    private javax.swing.JButton detalheItens;
    private javax.swing.JPanel digitanome;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBoxCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcombProdutos;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel lbHora;
    private javax.swing.JButton somaItens;
    private javax.swing.JTable tabelaVend;
    private javax.swing.JTextField txtComplet;
    private javax.swing.JTextField txtNcli;
    private javax.swing.JTextField txtNpro;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtTroco;
    private javax.swing.JTextField txtVZ;
    private javax.swing.JTextField txtValorReceb;
    private javax.swing.JTextField txtdata;
    private javax.swing.JTextField txtvalorCompleto;
    private javax.swing.JButton visualizaItens;
    private javax.swing.JButton visualizar;
    // End of variables declaration//GEN-END:variables

    //Método para zera 
    public void zeroLabel() {

        Valortotal.setText("0,00");
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
        codVenda.requestFocus();

    }
// class para implemena a hora;

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
                    || ValorUnit.getText().isEmpty() && ValorUnit.getText().length() == 0 || Valortotal.getText().isEmpty() && Valortotal.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Preenchar os campos corretamente!", "", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("" + e);
        }

    }
    //método para salvar a data 

    public void salvarData() {

        Data dt = new Data();

        // fazendo a instância da classe dataDao para passar  objeto da classe data;
        DataDao d = new DataDao();
        // setando a data no objeto da classe data;
        dt.setData(txtdata.getText());
        dt.getData();
        //passando objeto para a classe dataDao
        d.adicionaData(dt);

    }
    //Método para cer se contém a data no banco para salvar caso não tenha;
     public void setaDataDoBancoDeDados(){
         
         DataDao dt = new DataDao();
     
           
          if(txtdata.getText().equals(dt.setaDATA())){
                   JOptionPane.showMessageDialog(null, "tem essa data  "+dt.setaDATA());
            }else{
                   JOptionPane.showMessageDialog(null, "Não tem essa data "+dt.setaDATA()); 
                   //Vai salvar a data
                  salvarData();
            }
            
     }
    
    

    //metodo para digita só nomes
    public boolean checkLetters(String str) {

        return str.matches("[a-zA-Z]+");
    }

    //metodo para digita só números
    public void soNumeros() {

        //  codVenda.setDocument(new ApenasNumeros());
        TXTestoque.setDocument(new ApenasNumeros());
        //  txtComplet.setDocument(new ApenasNumeros());
        txtQtd.setDocument(new ApenasNumeros());
        //  txtValorReceb.setDocument(new ApenasNumeros());
        //   txtvalorCompleto.setDocument(new ApenasNumeros());
        txtVZ.setDocument(new ApenasNumeros());
        txtTroco.setDocument(new ApenasNumeros());
        //   ValorUnit.setDocument(new ApenasNumeros());
        //   Valortotal.setDocument(new ApenasNumeros());

        // Para deixa esses campos abaixo em 0 
        txtComplet.setText("0");
        txtVZ.setText("0");
        txtvalorCompleto.setText("0");
    }

    //MÉTODO PARRA EVITA LETRAS
    public void permitirNumerosFlutuantes() {

        if (checkLetters(ValorUnit.getText()) || checkLetters(Valortotal.getText()) || checkLetters(txtvalorCompleto.getText())) {
            ValorUnit.setBackground(Color.red);
            Valortotal.setBackground(Color.red);
            txtvalorCompleto.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Não Poder digita letras nesse campos em vermelhos !");

            ValorUnit.setBackground(Color.WHITE);
            Valortotal.setBackground(Color.WHITE);
            txtvalorCompleto.setBackground(Color.WHITE);

        }

    }

    public void adicionarCodVenda() {

        VendaDao d = new VendaDao();

        IDvenda idvd = new IDvenda();
        idvd.setIdVendar(codVenda.getText());
        d.adicionaCodVENDA(idvd);
    }
    
     //Método para seta os dados dos Produtos os valores de comprar do vendedor;
    public void setaDadosProdutoValorDeCompra() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //comando para seta os valores de comprar do produto que o vendedor investiu
            String sql = "select ValorDComprar from produto where codProd='" + jcombProdutos.getSelectedItem() + "'";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            //executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //Seando os valores no campos de textos;
                valorDoVendedor=Rst.getDouble("ValorDComprar");
              
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
    
    //Método para seta a soma e a quantidade dos produtos;
    public void setaDadosDaQtdESoma() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //comando para seta os valores de soma e quantidade
            String sql = "SELECT codProd,sum(Qtd)as Quantidade,sum(total)as total from vendas where codProd='" + jcombProdutos.getSelectedItem() + "' and data='"+txtdata.getText()+"'";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            //executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                
                
                
                //Setando os valores no campos de textos;ou variáveis
              QTDProduto=Rst.getInt("Quantidade");
                
                somaTotal= Rst.getDouble("total");
              
               // txtComplet.setText(QTDProduto+"");
               // txtVZ.setText(somaTotal+"");

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
    
     //Método para faze o calculor do ganhor
    public double fazerCalculo(){
          
          //Passando valor Unitário String para Double;
        double valorUnit = Double.parseDouble(ValorUnit.getText());
        
        double   multiplicacao1=QTDProduto*valorUnit;
        
        double  multiplicacao2=QTDProduto*valorDoVendedor;
        
            valorLucro =multiplicacao1-multiplicacao2;
         
        
       JOptionPane.showMessageDialog(null, "lucro "+valorLucro);
        return valorLucro;
      
    }
     //Método para faze o calculor do ganho
    public double fazerCalculoAntesdSalvar(){
          
        int quantidad=Integer.parseInt(txtQtd.getText());
          //Passando valor Unitário String para Double;
        double valorUnit = Double.parseDouble(ValorUnit.getText());
        
        double   multiplicacao1=quantidad*valorUnit;
        
        double  multiplicacao2=quantidad*valorDoVendedor;
        
        double subtracao=multiplicacao1-multiplicacao2;
         
        
      
        
        JOptionPane.showMessageDialog(null, "valor do lucro "+subtracao);
        
        return subtracao;
     
    }
    
    
    
    
  //Método para adicionar os valores para saber o lucro de toda venda
    public void addValoresNaTabelaLucro(){
         Data dt = new Data();

        // fazendo a instância da classe dataDao para passar  objeto da classe data;
        DataDao d = new DataDao();
        // setando a data no objeto da classe data;
        dt.setData(dt.setaData());
        
        LucroModel md = new LucroModel();
        md.setCodigoLucro(String.valueOf(jcombProdutos.getSelectedItem()));
        md.setCodigoProduto(String.valueOf(jcombProdutos.getSelectedItem()));
        md.setQuantidade(QTDProduto);
        md.setValorUnitario(Double.parseDouble(ValorUnit.getText()));
        md.setValorTotal(somaTotal);
        md.setValorDcomprar(valorDoVendedor);
        md.setValorGanhor(valorLucro);
        md.setData(dt.getData());
        
        LucroDao vd = new LucroDao();
        vd.adicionarDadosLucros(md);
    }

     //Método para seta a data do lucro;
    public void setacodigoDoLucro() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //comando para seta a data do lucro
            String sql = "SELECT codLuc from lucro";
            PreparedStatement Patm = Conn.prepareStatement(sql);
            //executar
            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {
            //Setando o codLud 
               codigoLUCRO=Rst.getString("codLuc");
                
              JOptionPane.showMessageDialog(null," Código do lucro é "+codigoLUCRO);

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
     public void setaLucroeAtualizarLucro(){
         //Instânciando a classe LucroDao;
              LucroDao dao= new LucroDao();
              //Instânciando a classe LucroModel; 
              LucroModel prod = new LucroModel();
              prod.setCodigoLucro(String.valueOf(jcombProdutos.getSelectedItem()));
              prod.setCodigoProduto(String.valueOf(jcombProdutos.getSelectedItem()));
              prod.setQuantidade(QTDProduto);
              prod.setValorUnitario(Double.parseDouble(ValorUnit.getText()));
              prod.setValorTotal(somaTotal);
              prod.setValorDcomprar(Double.parseDouble(valorDoVendedor+""));
              prod.setValorGanhor(valorLucro);
              prod.setData(txtdata.getText());
             //Passando objeto da classe lucroModel´para objeto da classe lucroDao;
                dao.atualizarLucro(prod);
   }
}
