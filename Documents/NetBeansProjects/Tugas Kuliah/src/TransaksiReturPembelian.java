
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import koneksi.conn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class TransaksiReturPembelian extends javax.swing.JInternalFrame {

    String TXTkode;

    /**
     * Creates new form TransaksiPembelian
     */

    
    public TransaksiReturPembelian() {//CONSTRUCTOR

        initComponents();
        nomorotomatis();
        tampilfakturbeli();
  
    }
    
    public void nomorotomatis(){
        Date date = new Date();
        dtptanggal.setDate(date);
        try{
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tblreturpembelian where No_Retur_beli in(select max(No_retur_beli) from tblreturpembelian)";
            ResultSet res = s.executeQuery(sql);
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
            if(res.next()){
                String fj = res.getString("No_retur_beli").substring(2, 8);
                String dtp = sdf.format(date);
                if(fj.equals(dtp)){
                    int faktur = Integer.parseInt(res.getString("No_retur_beli").substring(2, 10))+1;
                    txtnomorretur.setText(Integer.toString(faktur));
                    txtnomorretur.setText("RB"+txtnomorretur.getText());         
                }else{
                    txtnomorretur.setText("RB"+dtp+"01");
                }
            }else{
                txtnomorretur.setText("RB"+sdf.format(date)+"01");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }  
    }
           

    public void tampilfakturbeli(){
        Date date = new Date();
        dtptanggal.setDate(date);
         try{
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tblpembelian";
            ResultSet res = s.executeQuery(sql);
            cbofakturbeli.removeAllItems();
            while(res.next()){
                cbofakturbeli.addItem(res.getString("faktur_beli").toUpperCase());
            }
         }catch(SQLException e){
             JOptionPane.showMessageDialog(rootPane, e);
         }       
    }
    
    public void kosongkan(){                
        lbljumlahretur.setText("");
        lblcarabeli.setText("");
        lblsisahutang.setText("");
        lbljatuhtempo.setText("");
        lblstatusbeli.setText("");
        lblnamasupplier.setText("");
        lbltanggalbeli.setText("");
        txtnomorretur.setText("");
        txtnomorretur.requestFocus();
    }
    
    public void hitungtransaksi(){
        int x = 0;
        
        for(int baris = 0; baris <= dgv.getRowCount()-1; baris++){
            x = x + (Integer.parseInt(dgv.getValueAt(baris, 3).toString()));
            lbljumlahretur.setText(Integer.toString(x));
                }          
     }

     
    public void cetakinvoice() throws JRException{
         JasperReport jr;
         JasperPrint jp;
         JasperDesign jd;
         try{
             HashMap param = new HashMap();
             param.put("nofaktur", txtnomorretur.getText());
             
             Connection c = conn.getKoneksi();
             Statement s = c.createStatement();
             String fakturjual = "src/Report/FakturReturPembelian.jasper";
             File report = new File(fakturjual);
             jr = (JasperReport)JRLoader.loadObject(report);
             jp = JasperFillManager.fillReport(jr, param, c);
             JasperViewer.viewReport(jp,false);
         }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        } 
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dtptanggal = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbofakturbeli = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lblnamasupplier = new javax.swing.JLabel();
        lblstatusbeli = new javax.swing.JLabel();
        txtnomorretur = new javax.swing.JLabel();
        lbltanggalbeli = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgv = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnsimpan = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btntutup = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbljumlahretur = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblcarabeli = new javax.swing.JLabel();
        lblsisahutang = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbljatuhtempo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(970, 438));

        jLabel1.setText("No Retur Beli");
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel2.setText("Tanggal Retur Beli");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 20));

        dtptanggal.setDateFormatString("dd/MM/yyyy");
        dtptanggal.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel3.setText("No Faktur Beli");
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel4.setText("Status Beli");
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 20));

        cbofakturbeli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbofakturbeli.setMinimumSize(new java.awt.Dimension(206, 20));
        cbofakturbeli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbofakturbeliFocusLost(evt);
            }
        });

        jLabel5.setText("Tanggal Beli");
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 20));

        lblnamasupplier.setPreferredSize(new java.awt.Dimension(100, 20));

        lblstatusbeli.setPreferredSize(new java.awt.Dimension(100, 20));

        txtnomorretur.setText("jLabel13");

        lbltanggalbeli.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtnomorretur, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dtptanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbofakturbeli, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblnamasupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblstatusbeli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltanggalbeli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbofakturbeli, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnamasupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnomorretur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtptanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblstatusbeli, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltanggalbeli, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        dgv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Jumlah Beli", "Jumlah Retur", "Alasan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgv.setEditingColumn(0);
        dgv.setEditingRow(0);
        dgv.setPreferredSize(new java.awt.Dimension(648, 235));
        dgv.getTableHeader().setReorderingAllowed(false);
        dgv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dgvKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(dgv);

        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/TransaksiPembelian/btnsimpan.Image.png"))); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsimpan.setPreferredSize(new java.awt.Dimension(65, 73));
        btnsimpan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/TransaksiPembelian/btnbatal.Image.png"))); // NOI18N
        btnbatal.setText("Batal");
        btnbatal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbatal.setPreferredSize(new java.awt.Dimension(65, 73));
        btnbatal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btntutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/TransaksiPembelian/btntutup.Image.png"))); // NOI18N
        btntutup.setText("Tutup");
        btntutup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btntutup.setPreferredSize(new java.awt.Dimension(65, 73));
        btntutup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btntutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntutupActionPerformed(evt);
            }
        });

        jLabel7.setText("Jumlah Barang Retur");
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel8.setText("Sisa (Hutang)");
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 20));

        lbljumlahretur.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel10.setText("Cara Beli");
        jLabel10.setPreferredSize(new java.awt.Dimension(100, 20));

        lblcarabeli.setPreferredSize(new java.awt.Dimension(100, 20));

        lblsisahutang.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel13.setText("Jatuh Tempo");
        jLabel13.setPreferredSize(new java.awt.Dimension(100, 20));

        lbljatuhtempo.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btntutup, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbljumlahretur, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(lblsisahutang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbljatuhtempo, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcarabeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(196, 196, 196))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btntutup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsimpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblcarabeli, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbljatuhtempo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbljumlahretur, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblsisahutang, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntutupActionPerformed
        this.dispose();
    }//GEN-LAST:event_btntutupActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        DefaultTableModel model = (DefaultTableModel)dgv.getModel();
        while (model.getRowCount() > 0){
            for (int i = 0; i < model.getRowCount(); ++i){
                model.removeRow(i);
            }
        }
        kosongkan();
        nomorotomatis();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        if (cbofakturbeli.getSelectedItem().toString().equals("") || lbljumlahretur.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Transaksi Belum Lengkap");
        }else{
        
        try{
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dtp = dtptanggal.getDate();
            Timestamp dtptgl = new Timestamp(sdf.parse(sdf.format(dtp)).getTime());

            Date jatuh = sdf.parse(lbljatuhtempo.getText());
            Timestamp jatuhtempo = new Timestamp (sdf.parse(sdf.format(jatuh)).getTime());

                String simpan1  = "insert into tblreturpembelian values(?,?,?,?,?)";
                    PreparedStatement ps = c.prepareStatement(simpan1);
                    ps.setString(1, txtnomorretur.getText());
                    ps.setTimestamp(2, dtptgl);
                    ps.setString(3, cbofakturbeli.getSelectedItem().toString());
                    ps.setInt(4, Integer.parseInt(lbljumlahretur.getText()));
                    ps.setString(5, TXTkode);
                    ps.executeUpdate();

                int baris;
                for(baris = 0; baris <= dgv.getRowCount()-1; baris++){
                String simpan2  = "insert into tbldetailreturbeli values(?,?,?,?)";
                ps = c.prepareStatement(simpan2);
                ps.setString(1, txtnomorretur.getText());
                ps.setString(2, dgv.getValueAt(baris, 0).toString());
                ps.setInt(3, Integer.parseInt(dgv.getValueAt(baris, 3).toString()));
                ps.setString(4, dgv.getValueAt(baris, 4).toString().toUpperCase());
                ps.executeUpdate(); 
            }               
                
            }catch(SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
                
            } catch (ParseException ex) {
            Logger.getLogger(TransaksiPembelian.class.getName()).log(Level.SEVERE, null, ex);
        } int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Cetak Faktur ?", "Warning", dialogButton);
            if(dialogResult == 0) {
            try {
                cetakinvoice();
            } catch (JRException ex) {
                Logger.getLogger(TransaksiPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            kosongkan();
            nomorotomatis();
        DefaultTableModel model = (DefaultTableModel)dgv.getModel();

    while (model.getRowCount() > 0){
        for (int i = 0; i < model.getRowCount(); ++i){
            model.removeRow(i);
        }
    }
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void cbofakturbeliFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbofakturbeliFocusLost
        try{
            DefaultTableModel data = (DefaultTableModel) dgv.getModel();
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            dgv.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
            dgv.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
            dgv.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
            SimpleDateFormat sdfinput = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdfoutput = new SimpleDateFormat("dd/MM/yyyy");
              Connection c = conn.getKoneksi();
              Statement s = c.createStatement();
              String sql = "select * from tblpembelian where faktur_beli= '"+cbofakturbeli.getSelectedItem().toString()+"'";
              ResultSet res = s.executeQuery(sql);
              if(res.next()){
                  Date jatuh = sdfinput.parse(res.getString("jth_tempo_beli"));
                  Date tglbeli = sdfinput.parse(res.getString("tgl_beli"));
                  lblstatusbeli.setText(res.getString("status_beli"));
                  lblcarabeli.setText(res.getString("cara_beli"));
                  lblsisahutang.setText(res.getString("sisa_hutang"));
                  lbljatuhtempo.setText(sdfoutput.format(jatuh));
                  lbltanggalbeli.setText(sdfoutput.format(tglbeli));
                  lbljumlahretur.setText("0");
              }else{
                  JOptionPane.showMessageDialog(rootPane, "Nomor Faktur Tidak Terdaftar");
              }
              
              res = s.executeQuery("select Nama_Supplier from tblsupplier,"
                      + "tblpembelian where tblpembelian.kode_supplier=tblsupplier.kode_supplier "
                      + "and faktur_beli='"+cbofakturbeli.getSelectedItem().toString()+"'");
              if(res.next()){
                  lblnamasupplier.setText(res.getString("nama_supplier"));
              }else{
                  JOptionPane.showMessageDialog(rootPane, "Nomor Faktur Tidak Terdaftar");
              }
              
              DefaultTableModel model = (DefaultTableModel)dgv.getModel();
        while (model.getRowCount() > 0){
            for (int i = 0; i < model.getRowCount(); ++i){
                model.removeRow(i);
            }
        }
        
        String datadgv = "select TBLdetailBeli.Kode_barang as [Kode Barang],"
                + "TblBarang.nama_Barang as [Nama Barang],Qty_beli as [Jml Beli] from tblpembelian,"
                + "tbldetailbeli,tblbarang where tbldetailbeli.faktur_beli=tblpembelian.faktur_beli "
                + "and tbldetailbeli.kode_barang=tblbarang.kode_barang and tbldetailbeli.faktur_beli= '"+cbofakturbeli.getSelectedItem().toString()+"'";
        res = s.executeQuery(datadgv);
        while(res.next()){
             
                String kolom1 = res.getString("Kode Barang");
                String kolom2 = res.getString("Nama Barang");
                String kolom3 = res.getString("Jml Beli");
                String kolom4 = "";
                String kolom5 = "";
                
                String kolom[] = {kolom1, kolom2, kolom3, kolom4, kolom5};
                data.addRow(kolom);
                
                
            }
       dgv.changeSelection(0, 3, false, false);
       dgv.editCellAt(dgv.getSelectedRow(), 3);
       dgv.getEditorComponent().requestFocus();
              
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
                
            } catch (ParseException ex) {
            Logger.getLogger(TransaksiReturPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbofakturbeliFocusLost

    private void dgvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dgvKeyPressed
       if (evt.getKeyChar() == KeyEvent.VK_DELETE){
                 DefaultTableModel data = (DefaultTableModel) dgv.getModel();
        dgv.setModel(data);
        data.setRowCount(dgv.getRowCount());
        data.removeRow(dgv.getSelectedRow());
        evt.setKeyCode(KeyEvent.VK_DOWN);
            }
       if (evt.getKeyChar() == KeyEvent.VK_ENTER){
           evt.consume();
           dgv.changeSelection(dgv.getSelectedRow(), dgv.getSelectedColumn(), false, false);
           dgv.editCellAt(dgv.getSelectedRow(),dgv.getSelectedColumn());
           dgv.getEditorComponent().requestFocus();
           try{
           Integer jmlbeli = Integer.parseInt(dgv.getValueAt(dgv.getSelectedRow(), 2).toString());
           Integer jmlretur = Integer.parseInt(dgv.getValueAt(dgv.getSelectedRow(), 3).toString());
           if(dgv.getSelectedColumn()==3){
           if(jmlretur > jmlbeli){
               JOptionPane.showMessageDialog(null, "Jumlah Retur Melebihi Jumlah Beli");
               dgv.setValueAt(0, dgv.getSelectedRow(), 3);
               dgv.editCellAt(dgv.getSelectedRow(),3);
               dgv.getEditorComponent().requestFocus();
               hitungtransaksi();
           }else{
               dgv.changeSelection(dgv.getSelectedRow(), 4, false, false);
               dgv.editCellAt(dgv.getSelectedRow(), 4);
               dgv.getEditorComponent().requestFocus();
               hitungtransaksi();

           }
           }else
               if(dgv.getSelectedColumn()==4){
               dgv.changeSelection(dgv.getSelectedRow()+1, 3, false, false);
               dgv.editCellAt(dgv.getSelectedRow(), 3);
               dgv.getEditorComponent().requestFocus();
           }
       }catch(NumberFormatException ex){}
       }
    }//GEN-LAST:event_dgvKeyPressed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntutup;
    private javax.swing.JComboBox<String> cbofakturbeli;
    private javax.swing.JTable dgv;
    private com.toedter.calendar.JDateChooser dtptanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblcarabeli;
    private javax.swing.JLabel lbljatuhtempo;
    private javax.swing.JLabel lbljumlahretur;
    private javax.swing.JLabel lblnamasupplier;
    private javax.swing.JLabel lblsisahutang;
    private javax.swing.JLabel lblstatusbeli;
    private javax.swing.JLabel lbltanggalbeli;
    private javax.swing.JLabel txtnomorretur;
    // End of variables declaration//GEN-END:variables

}
