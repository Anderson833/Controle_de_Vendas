package View;

import Conexao.Conexao_BD;
import Dao.ClienteDao;
import Dao.ComprovanteDao;
import Dao.ProdutoDao;
import Dao.VendaDao;
import Model.ClienteModel;
import Model.ComprovanteModel;
import Model.ProdutoModel;
import Model.VendaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ander
 */
public class Venda extends javax.swing.JFrame {

    //Para fazer guarda o resultado da subtração da quantidade em estoque com a quantida pedido pelo cliente;
    int contador = 0;

    //PARA SOMA A QTD DE PRODUTO
    double somaSemQTD = 0;

    //PARA CONTA QUANTAS VEZES FOI SELECIONADO A CAIXA DE SELEÇÃO
    int contCHEK = 0;

    //VALOR TOTAL DE TODA TABELA COMPRAR
    double valorTotalBD = 0;
    
    //variável para armazenar a data e permanecerá durante todas as vendas realizada do dia;
    private static String date="";
   
    public Venda() {
        initComponents();
        //centralizando ao centro da tela
        setLocationRelativeTo(null);

        setaDadosJcomboxProd();
        //Método para seta os nomes dos produtos;
        setaDadosJcomboxClientes();
        
        //método para armazenar o valor total de toda comprar ao abrir não zera;
        totalValorBd();
        
        // mostrar data ao abrir

        data();
        txtdata.setText(""+date);
        
    }

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
        jcomb = new javax.swing.JComboBox();
        jComboBoxCliente = new javax.swing.JComboBox();
        DIGITaSemQtd = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        txtdata = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venda");

        digitanome.setBackground(new java.awt.Color(133, 182, 139));
        digitanome.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Código venda:");

        codVenda.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        codVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codVendaActionPerformed(evt);
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
                "CodVend", "CodCli", "CodProd", "Qtd_Prod", "ValorUnit", "ValorTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        jLabel15.setText("Visualizar Todos Itens:");

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

        jcomb.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jcomb.setForeground(new java.awt.Color(0, 0, 255));
        jcomb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolha código do produto" }));
        jcomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombActionPerformed(evt);
            }
        });
        jcomb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcombKeyPressed(evt);
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

        DIGITaSemQtd.setText("Sem Quantidade");
        DIGITaSemQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DIGITaSemQtdActionPerformed(evt);
            }
        });

        jLabel17.setText("Data:");

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
                                        .addGap(8, 8, 8)
                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(digitanomeLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(visualizaItens, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(detalheItens)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1)
                                .addGap(20, 20, 20))))
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(codVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(txtValorReceb, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ValorUnit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                            .addComponent(TXTestoque, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(digitanomeLayout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtNpro)
                                                    .addGroup(digitanomeLayout.createSequentialGroup()
                                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(0, 46, Short.MAX_VALUE))))
                                            .addGroup(digitanomeLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(txtNcli)))))
                                .addGap(37, 37, 37))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(digitanomeLayout.createSequentialGroup()
                                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(digitanomeLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(Valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(127, 127, 127)))))
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(somaItens, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jcomb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtQtd, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(DIGITaSemQtd))
                .addGap(27, 27, 27))
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
                        .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(codVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jcomb, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txtNcli, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jComboBoxCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DIGITaSemQtd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(digitanomeLayout.createSequentialGroup()
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXTestoque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNpro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(digitanomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Valortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(digitanomeLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(digitanome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(digitanome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed

        //Método para adicioanr vendas no banco de dados;
        adicionarVendas();
        // realizarCompra();
        Limpar();

    }//GEN-LAST:event_AdicionarActionPerformed

    //Metodo para adicionar vendas
    public void adicionarVendas() {
        //Instânciando a classe VendaDao;
        VendaDao dao = new VendaDao();

        //Instânciando a classe VendaModel;
        VendaModel vd = new VendaModel();
        //Setando os valores ;
        vd.setCodVenda(codVenda.getText());
        //    vd.setCodProd(txtCodPro.getText());
        vd.setCodCli(String.valueOf(jComboBoxCliente.getSelectedItem()));
        vd.setQtdProd(Integer.parseInt(txtQtd.getText()));
        vd.setValorUnit(Double.parseDouble(ValorUnit.getText()));
        vd.setValorTotal(Double.parseDouble(Valortotal.getText()));

        //Passando os valores no objeto dao da classe VendaDao;
        dao.adicionaVenda(vd);

    }


    private void calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularActionPerformed

        //MÉTODO PARA SOMA TODA VENDA COM UMA UNIDADE DE ITEM
        somarItens();

    }//GEN-LAST:event_calcularActionPerformed

    private void tabelaVendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendMouseClicked

        //Seta os valores nos campos de textos ao clicar na inha da tabela;
        if (tabelaVend.getSelectedRow() != -1) {

            codVenda.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 0).toString());
            jComboBoxCliente.setSelectedItem(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 1).toString());
            jcomb.setSelectedItem(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 2).toString());
            txtQtd.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 3).toString());
            ValorUnit.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 4).toString());
            Valortotal.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(), 5).toString());


    }//GEN-LAST:event_tabelaVendMouseClicked
    }
    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed

        //Método para visualizar todos dados das vendas n o banco de dados;
        visualizaVendas();


    }//GEN-LAST:event_visualizarActionPerformed

    private void RealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RealizarActionPerformed

       
        if(txtValorReceb.getText().equals("")){
          JOptionPane.showMessageDialog(null,"Digite valor recebido ? ","Preenchar campo !",JOptionPane.WARNING_MESSAGE);
        }else{
            //Método para realizar venda;
             realizarVenda(); 
        }

    }//GEN-LAST:event_RealizarActionPerformed

    private void ValorUnitInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ValorUnitInputMethodTextChanged

    }//GEN-LAST:event_ValorUnitInputMethodTextChanged

    private void txtQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdActionPerformed
        //mÉTODO PARA PREENCHE O CAMPO DE TEXTO QUANTIDADE OBRIGATÓRIAMENTE
        preencherCampoQtd();
    }//GEN-LAST:event_txtQtdActionPerformed
    //Método para preencher o campo texto qtd obrigatóriamente
    public void preencherCampoQtd() {
        //Condição para sabe se o campos de qtd está vazio;
        if (txtQtd.getText().isEmpty()) {
            //CASO ESSA CONDIÇÃO FOR REALIZADA MOSTRAR ESSA MENSAGEM;
            JOptionPane.showMessageDialog(null, "Preenchar Campo  Quantidade ?", "Obrigatório!", JOptionPane.WARNING_MESSAGE);

        } else {

            //Método para calcular Pre venda;
            calcularPreVenda();
            //adiciona item
            addItem();
            //Ver todos itens na tabela
            visualizarItens();
            //seta valor total dois Itens pelo código da venda;
            setaValorFinalItens();
        }

    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Método para limpar os campos de textos;
        Limpar();
        //Método para limpar as linhas da tabela;
        limpalinha();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void deleatarVdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleatarVdActionPerformed

        //Variável para pergunta se usuárioque deletar pelo código da venda
        int venda = JOptionPane.showConfirmDialog(null, "Deseja deletar venda pelo código ?", "Escolha Opção:", JOptionPane.YES_NO_CANCEL_OPTION);
        //fazendo a codição
        switch (venda) {
            //opcão sim
            case JOptionPane.YES_OPTION:
                // condiçao para valida o campo de texto de código venda 
                if (codVenda.getText().equals("")) {
                    //caso seja verdade mostrar essa mensagem
                    JOptionPane.showMessageDialog(null, "Preenchar Campo do código Venda?", "Obrigatório!", JOptionPane.WARNING_MESSAGE);
                } else {
                    //Método para deletar venda pelo código da venda;
                    deletarVendasPeloCodigo();
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

        //Metodo para adicionar Itens;
        addItem();

    }//GEN-LAST:event_addItemActionPerformed

    private void visualizaItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizaItensActionPerformed

        //Método para visualizar todos itens;
        visualizarItens();
    }//GEN-LAST:event_visualizaItensActionPerformed


    private void detalheItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalheItensActionPerformed

        //Instânciando Jlabel comprovante ;
        Comprovante com = new Comprovante();
        //Passando o objeto comprovante para abrir a tela;
        com.setVisible(true);

    }//GEN-LAST:event_detalheItensActionPerformed

    private void deletarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarItemActionPerformed

        //Opcão de confirmação
        int item = JOptionPane.showConfirmDialog(null, "Deseja deletar todos Itens?", "Escolha Opção:", JOptionPane.YES_NO_CANCEL_OPTION);

        switch (item) {
            //opçao sim
            case JOptionPane.YES_OPTION:
                //Método para deletar todos itens;
                deletaTodosItens();
                //Zerando a soma de todos  itens;
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
                    deletarItem();
                }
                break;
            default:

                JOptionPane.showMessageDialog(null, "Nenhuma Opção não desejada!", "", JOptionPane.INFORMATION_MESSAGE);
                break;
        }

    }//GEN-LAST:event_deletarItemActionPerformed

    private void somaItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_somaItensActionPerformed

        // opcão para escolhe qual forma que soma os itens
        int x = JOptionPane.showConfirmDialog(null, "Deseja Fazer Pelo Código Da Venda", "Escolha Opção:", JOptionPane.YES_NO_CANCEL_OPTION);
        switch (x) {
            //opçao sim
            case JOptionPane.YES_OPTION:
                if (codVenda.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Preenchar Campo do código Venda?", "Obrigatório!", JOptionPane.WARNING_MESSAGE);
                } else {
                    //Método para seta os valores dos itens;
                    setaValorTotalDosItensPelocod();
                }
                break;
            //opcão não
            case JOptionPane.NO_OPTION:
                //método para soma todos itens
                setaValorFinalItens();
                break;
            default:
                //caso não for nenhuma dessa a cima será exibida essa mensagem;
                JOptionPane.showMessageDialog(null, "Nenhuma Opção não desejada!", "", JOptionPane.INFORMATION_MESSAGE);
                break;
        }

    }//GEN-LAST:event_somaItensActionPerformed

    private void jcombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombActionPerformed

        //condição pra saber se jcomboBox produto esta seleciona em 0 
        if (jcomb.getSelectedIndex() == 0) {
            //MOSTRAR ESSA MENSAGEM CASO ESTEJA SELECIONADO 
            JOptionPane.showMessageDialog(null, "Produto não escolhido ?");

        }else{
            //para realizar só pelo código do produto
              digitaComUmaUnidadeQtd();
        }

        
    }//GEN-LAST:event_jcombActionPerformed
   
    private void jcombKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcombKeyPressed

    }//GEN-LAST:event_jcombKeyPressed

    private void jComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClienteActionPerformed
        //Método para seta nome do cliente pelo jcomboBox
        setaNomeClientes();

    }//GEN-LAST:event_jComboBoxClienteActionPerformed

    private void codVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codVendaActionPerformed
        //Para muda opcão 
        jComboBoxCliente.requestFocus();

    }//GEN-LAST:event_codVendaActionPerformed

    private void jComboBoxClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxClienteKeyPressed
       
        //Ao Clicar no teclado da seta para o lado direito muda para seleciona código do produto; 
        if (evt.getKeyCode() == evt.VK_RIGHT) {
            
            jcomb.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxClienteKeyPressed

    private void DIGITaSemQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DIGITaSemQtdActionPerformed

        //Método para realizar soma sem qtd de produto;
        digitaComUmaUnidadeQtd();
    }//GEN-LAST:event_DIGITaSemQtdActionPerformed

    private void txtQtdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtdKeyPressed
        //Para muda para opcão de escolhe código do produto;
        if (evt.getKeyCode() == evt.VK_UP) {
            jcomb.requestFocus();
        }
    }//GEN-LAST:event_txtQtdKeyPressed

    private void txtValorRecebKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorRecebKeyPressed

    }//GEN-LAST:event_txtValorRecebKeyPressed

    private void txtValorRecebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorRecebActionPerformed
      
      // VALIDAÇÃO DO CAMPO DE TEXTO DO VALOR RECEBIDO;
        
        if(txtValorReceb.getText().equals("")){
            //MOSTRA ESSA MENSAGEM CASO ESSA CODIÇÃO SEJA REALIADA;
          JOptionPane.showMessageDialog(null,"Digite valor recebido ? ","Preenchar campo !",JOptionPane.WARNING_MESSAGE);  
        }else{
            //CASO CONTRÁRIO REALIZA ESSA MÉTODO;
            
            //Método para realizar venda;
             realizarVenda(); 
        }

        
    }//GEN-LAST:event_txtValorRecebActionPerformed
    //Método para calcular sem digita mais de uma  qtd
    public void digitaComUmaUnidadeQtd() {
          
        //condição para realiza com uma unidade 
        if (DIGITaSemQtd.isSelected()) {
           // conta para saber se está selecionado a caixa de seleção
            contCHEK++;

        
            if (contCHEK == 1) {
              //  codVenda.requestFocus();
                setaNomeClientes();
                setaDadosProduto();
                //seta uma unidade para cada produto selecionado na caixa de combinação;
                txtQtd.setText("1");
                valorTotalBD = valorTotalBD;
                //seta soma dos produtos
                somarItens();
               // add produto no banco de dados
                addItem();
                //visualizar produto 
                visualizarItens();
                //seta valor total de toda comprar
                setaValorFinalItens();

            } 
        }else if(DIGITaSemQtd.isSelected()==false) {
                 
                //caso o cantrário realizar essa escopo
               
                txtQtd.setText("");
                //Método para seta nome dos clientes   
                setaNomeClientes();
                
                //método para seta osdados do produto
                setaDadosProduto();
                    
                //condição para saber se o campo de texto qtd está vazio
                if (txtQtd.getText().equals("")) {
                    //muda para o campo e texto a seta para digita
                    txtQtd.requestFocus();
                } else {
                    
              
                    
                  //método para calcular a venda
                    calcularPreVenda();
                   //método para adicionar o produto no banco de dados
                    addItem();
                    //método para visualizar todo produto no banco de dados
                    visualizarItens();
                    //método para seta todo valor da venda
                    setaValorFinalItens();
                }
               
            }
        
            contCHEK=0;
    }

//Método paradeletar item;
    public void deletarItem() {
        //Instânciando a classe ComprovanteDao;
        ComprovanteDao dao = new ComprovanteDao();

        //Instânciando a classe ComprovanteModel;
        ComprovanteModel cp = new ComprovanteModel();
        cp.setCodVenda(codVenda.getText());
        // colocando objeto cp no método deletarItens da classe ComprovanteDao ;
        dao.deletaItens(cp);

    }

    //Método para visualizar todos itens;
    public void visualizarItens() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaVend.getModel();
        //Método para não repetir os dados na tabela de comprar;
        modelo.setNumRows(0);
        //Instânciando a classe ComprovanteDao;
        ComprovanteDao dao = new ComprovanteDao();
        //Um Laço de repetição para lista todas compras na tabela comprar no banco de dados; 
        for (ComprovanteModel item : dao.visualizarComprovante()) {
            modelo.addRow(new Object[]{
                //Passando os objetos 
                item.getCodVenda(),
                item.getCodCli(),
                item.getCodProd(),
                item.getQtdProd(),
                item.getValorUnit(),
                item.getValorTotal()

            });
        }

    }

    //Metodo para adicionar Itens na tabela comprar;
    public void addItem() {
        
      
         
        //Instânciando a classe ComprovanteModel;
        ComprovanteModel item = new ComprovanteModel();
        //Instânciando a classe ComprovanteDao;
        ComprovanteDao dao = new ComprovanteDao();
        //setando os valores
        item.setCodVenda(codVenda.getText());
        item.setCodProd(String.valueOf(jcomb.getSelectedItem()));
        item.setCodCli(String.valueOf(jComboBoxCliente.getSelectedItem()));
        item.setQtdProd(Integer.parseInt(txtQtd.getText()));
        item.setValorUnit(Double.parseDouble(ValorUnit.getText()));
        item.setValorTotal(Double.parseDouble(Valortotal.getText()));
        item.setData(txtdata.getText());
        //Passando os valores para objeto da classe ComprovanteDao;
        dao.adicionaItem(item);
        date=txtdata.getText();
        
     
    }

    //Método para deletar venda 
    public void deletarVendasPeloCodigo() {
        //Instânciando a classe VendaDao;
        VendaDao dao = new VendaDao();

        //Instânciando a classe VendaModel;
        VendaModel vd = new VendaModel();
        //setando os valores
        vd.setCodVenda(codVenda.getText());
        //Passando os valores para objeto dao
        dao.deletaVendaPeloCodigo(vd);
    }

    //Método para seta os dados dos Produtos nos campos de textos pelo código do cliente;
    public void setaDadosProduto() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //comando para seta os valores nos campos de textos pelo código do produto;
            String sql = "SELECT valorUnit,estoque,nome FROM produto where codProd like'" + jcomb.getSelectedItem() + "'";

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
    //Método para calcular a quantidade pedido pelo cliente;

    public void calcularPreVenda() {
        
        
        
        
        
        //Passando o campo de texto Qtd de String para Inteiro;
        Integer QTD = Integer.parseInt(txtQtd.getText());

        //Passando o campo de texto Estoque de String para Inteiro;
        Integer ESTOQUE = Integer.parseInt(TXTestoque.getText());

      
        
        
        
        //laço de repetição para fazer a subtração;
        for (int i = 0; i <= ESTOQUE; i++) {

            //guardando o resultado
            contador = QTD - i;
            String cvt = String.valueOf(contador);
            //setando no campo de texto estoque;
            TXTestoque.setText(cvt.replace("-", ""));

            // condição para saber se o estoque é maior do que a Quantidade ou estoque é igual a quantidade;
            if (ESTOQUE > QTD || ESTOQUE == QTD) {

                //setando no campo de texto estoque;
                TXTestoque.setText(String.valueOf(contador));
                TXTestoque.setText(cvt.replace("-", ""));

                //condição para saber ser a quantidade é maior do que o estoque; 
            } if (QTD > ESTOQUE) {

                // se essa condição for realizada será mostrado essa mensagem;
                JOptionPane.showMessageDialog(null, "Quantidade indisponível !", "Error", JOptionPane.ERROR_MESSAGE);

                //setando no campo de texto estoque;
                TXTestoque.setText(String.valueOf("0"));

                //setano o valor na label Total;
                labelTotal.setText("");
                break;
                
            }else  if(QTD>ESTOQUE){
             //guarda o resultado
        double multiplicar = 0;
        //Passando valor Unitário String para Double;
        double valorUnit = Double.parseDouble(ValorUnit.getText());

       
        if (true) {

            //guardando o resultado da multiplicação
            multiplicar = valorUnit * QTD;
            valorTotalBD = valorTotalBD + multiplicar;

            //setando o resultado na labelTotal;
            labelTotal.setText(String.valueOf(valorTotalBD));
            Valortotal.setText("" + multiplicar);
        }
         
        }

        }
        
      /*    
        if(QTD>ESTOQUE){
             //guarda o resultado
        double multiplicar = 0;
        //Passando valor Unitário String para Double;
        double valorUnit = Double.parseDouble(ValorUnit.getText());

       
        if (true) {

            //guardando o resultado da multiplicação
            multiplicar = valorUnit * QTD;
            valorTotalBD = valorTotalBD + multiplicar;

            //setando o resultado na labelTotal;
            labelTotal.setText(String.valueOf(valorTotalBD));
            Valortotal.setText("" + multiplicar);
        }
         
        }
      
       */
    }

    
    
    //Método para realizar a venda;
    public void realizarVenda() {

        double valorNegativoBD = 0;
        // Passando o valor recebido de String para double; 
        double valorReceb = Double.parseDouble(txtValorReceb.getText());

        //Fazendo a condição para sabe se o valor recebido é menor  do que o resultado da multiplicação da QTD vezes o valor Unitário;
        if (valorReceb < valorTotalBD) {
            //Exibindo a mensagem se caso essa condição seja verdadeira;
            JOptionPane.showMessageDialog(null, "Valor a baixo do Total !", "Error", JOptionPane.ERROR_MESSAGE);

            valorNegativoBD = valorReceb - valorTotalBD;

            txtTroco.setText(String.valueOf("" + valorNegativoBD));
            //Fazendo a condição para sabe se o valor recebido é igual o resultado da multiplicação da QTD vezes o valor Unitário;   
        } else if (valorReceb == valorTotalBD) {

       JOptionPane.showMessageDialog(null, "Venda Realizada Com Sucesso !", "Obrigado...!", JOptionPane.INFORMATION_MESSAGE);
            //deixando o campo vazio ;
            txtTroco.setText(String.valueOf(""));
        }
        // variável double para guarda o valor inferior da venda;
        double ValorAcima = valorReceb - valorTotalBD;

        //condição para saber se valor recebido é maior do que valor Unitário;
        if (valorReceb > valorTotalBD) {
            
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
        jcomb.setSelectedIndex(0);
        valorTotalBD = 0;

    }

    //Método para visualizar as vendas;
    public void visualizaVendas() {

        DefaultTableModel modelo = (DefaultTableModel) tabelaVend.getModel();
        //Método para não repetir os dados na tabela de venda;
        modelo.setNumRows(0);
        //Instânciando a classe VendaDao;
        VendaDao dao = new VendaDao();
        //Um Laço de repetição para lista todas vendas na de vendas no banco de dados; 
        for (VendaModel venda : dao.visualizarVenda()) {
            modelo.addRow(new Object[]{
                venda.getCodVenda(),
                venda.getCodCli(),
                venda.getCodProd(),
                venda.getQtdProd(),
                venda.getValorUnit(),
                venda.getValorTotal()

            });
        }

    }

    //Método para limpar as linhas da tabela
    public void limpalinha() {
        DefaultTableModel dm = (DefaultTableModel) tabelaVend.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }

    //Método para seta os valor total  dos itens no campo de texto e na label;
    public void setaValorTotalDosItensPelocod() {

        int codvd = Integer.parseInt(codVenda.getText());

        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "SELECT round(sum(ValorTotal),2) FROM Comprar where codVend=" + codvd + "";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {

                //Pegando o valor da soma
                double total = Rst.getDouble("round(sum(ValorTotal),2)");
                //setando o valor no campo de texto e na label; 
                labelTotal.setText("" + total);
                Valortotal.setText("" + total);

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

    //Método para seta os valor total  dos itens no campo de texto e na label;
    public void setaValorFinalItens() {

        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "SELECT round(sum(ValorTotal),2) FROM Comprar";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {

                //Pegando o valor da soma
                double total = Rst.getDouble("round(sum(ValorTotal),2)");
                //setando o valor no campo de texto e na label; 
                labelTotal.setText("" + total);
                Valortotal.setText("" + total);
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

    //Método para deletar todos itens no banco de dados da tabela comprar;
    public void deletaTodosItens() {

        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn = Conexao_BD.getConnection();

        try {

            // Comando que  Deletar todos itens da  comprar ;
            String sql = "DELETE FROM comprar";

            PreparedStatement patm = conn.prepareStatement(sql);

            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Todos Itens Deletado com Sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                //Caso de errado será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Todos itens não Deletado !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Fechando conexão PreparedStatement;
            patm.close();

            //Fechando conexão Connection;
            conn.close();

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
            JOptionPane.showMessageDialog(null, "Error ao Deletar itens  !", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    //Método para adiciona os produtos no jcombox;
    public void setaDadosJcomboxProd() {
       //Instânciando a classe PrdutoDao para criar o objeto;  
        ProdutoDao dao = new ProdutoDao();
       // laço de repetição para adicionar o produto;
        for (ProdutoModel p : dao.visualizarProduto()) {
            //adicionando os itens no campo de combinação
            jcomb.addItem(p);

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
    private javax.swing.JCheckBox DIGITaSemQtd;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcomb;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JButton somaItens;
    private javax.swing.JTable tabelaVend;
    private javax.swing.JTextField txtNcli;
    private javax.swing.JTextField txtNpro;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtTroco;
    private javax.swing.JTextField txtValorReceb;
    private javax.swing.JTextField txtdata;
    private javax.swing.JButton visualizaItens;
    private javax.swing.JButton visualizar;
    // End of variables declaration//GEN-END:variables

    //Método para zera 
    public void zeroLabel() {

        Valortotal.setText("0,00");
        labelTotal.setText("0,00");
    }

    //Método para soma itens sem digita a quantidade de produtos;
    public void somarItens() {

        double vunit = Double.parseDouble(ValorUnit.getText());

        Valortotal.setText("" + vunit);

        if (true) {

            valorTotalBD = valorTotalBD + vunit;

            labelTotal.setText("" + valorTotalBD);

        }

    }

    //MÉTODO PARA EXECUTAR QUALQUEI AÇÃO EM UM  DETERMINADO TEMPO;
    public void tempo() {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //MÉTODO  PARA  GUARDA TODO VALOR ARMAZENADO NA TABELA COMPRA DO BANCO DE DADOS;
    public double totalValorBd() {
       
        return valorTotalBD;
    }
    
    //Método para retorna a data ao iniciar sistema;
    public void data(){
      
      
        txtdata.setText(date+"");
    }
}
