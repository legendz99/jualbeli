
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import koneksi.conn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class TransaksiReturPenjualan extends javax.swing.JInternalFrame {

    String TXTkode;

    /**
     * Creates new form TransaksiPenjualan
     */

    
    public TransaksiReturPenjualan() {//CONSTRUCTOR

        initComponents();
        tampilfakturjual();
  
    }
    
  
           

    public void tampilfakturjual(){
        Date date = new Date();
        dtptanggal.setDate(date);
         try{
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tblpenjualan order by faktur_jual DESC";
            ResultSet res = s.executeQuery(sql);
            cbofakturjual.removeAllItems();
            while(res.next()){
                cbofakturjual.addItem(res.getString("faktur_jual").toUpperCase());
            }
         }catch(SQLException e){
             JOptionPane.showMessageDialog(rootPane, e);
         }       
    }
    
    public void kosongkan(){                
        lbljumlahretur.setText("");
        lblcarajual.setText("");
        lblsisapiutang.setText("");
        lbljatuhtempo.setText("");
        lblstatusjual.setText("");
        lblnamacustomer.setText("");
        lbltanggaljual.setText("");
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
        cbofakturjual = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lblnamacustomer = new javax.swing.JLabel();
        lblstatusjual = new javax.swing.JLabel();
        lbltanggaljual = new javax.swing.JLabel();
        txtnomorretur = new javax.swing.JTextField();
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
        lblcarajual = new javax.swing.JLabel();
        lblsisapiutang = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbljatuhtempo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(970, 438));

        jLabel1.setText("No Retur Jual");
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel2.setText("Tanggal Retur Jual");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 20));

        dtptanggal.setDateFormatString("dd/MM/yyyy");
        dtptanggal.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel3.setText("No Faktur Jual");
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel4.setText("Status Jual");
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 20));

        cbofakturjual.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbofakturjual.setMinimumSize(new java.awt.Dimension(206, 20));
        cbofakturjual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbofakturjualFocusLost(evt);
            }
        });

        jLabel5.setText("Tanggal Jual");
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 20));

        lblnamacustomer.setPreferredSize(new java.awt.Dimension(100, 20));

        lblstatusjual.setPreferredSize(new java.awt.Dimension(100, 20));

        lbltanggaljual.setPreferredSize(new java.awt.Dimension(100, 20));

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
                    .addComponent(txtnomorretur)
                    .addComponent(dtptanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbofakturjual, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblnamacustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblstatusjual, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltanggaljual, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(261, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnomorretur, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbofakturjual, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblnamacustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtptanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblstatusjual, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltanggaljual, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
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

        jLabel8.setText("Sisa Piutang");
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 20));

        lbljumlahretur.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel10.setText("Cara Jual");
        jLabel10.setPreferredSize(new java.awt.Dimension(100, 20));

        lblcarajual.setPreferredSize(new java.awt.Dimension(100, 20));

        lblsisapiutang.setPreferredSize(new java.awt.Dimension(100, 20));

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
                    .addComponent(lblsisapiutang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbljatuhtempo, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcarajual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                                    .addComponent(lblcarajual, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(lblsisapiutang, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        if (cbofakturjual.getSelectedItem().toString().equals("") || lbljumlahretur.getText().equals("")){
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

                String simpan1  = "insert into tblreturpenjualan values(?,?,?,?,?)";
                    PreparedStatement ps = c.prepareStatement(simpan1);
                    ps.setString(1, txtnomorretur.getText());
                    ps.setTimestamp(2, dtptgl);
                    ps.setString(3, cbofakturjual.getSelectedItem().toString());
                    ps.setInt(4, Integer.parseInt(lbljumlahretur.getText()));
                    ps.setString(5, TXTkode);
                    ps.executeUpdate();

                int baris;
                for(baris = 0; baris <= dgv.getRowCount()-1; baris++){
                String simpan2  = "insert into tbldetailreturjual values(?,?,?,?)";
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
                Logger.getLogger(TransaksiReturPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            }
            kosongkan();
        DefaultTableModel model = (DefaultTableModel)dgv.getModel();

    while (model.getRowCount() > 0){
        for (int i = 0; i < model.getRowCount(); ++i){
            model.removeRow(i);
        }
    }
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void cbofakturjualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbofakturjualFocusLost
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
              String sql = "select * from tblpenjualan where faktur_jual= '"+cbofakturjual.getSelectedItem().toString()+"'";
              ResultSet res = s.executeQuery(sql);
              if(res.next()){
                  Date jatuh = sdfinput.parse(res.getString("jth_tempo_jual"));
                  Date tglbeli = sdfinput.parse(res.getString("tgl_jual"));
                  lblstatusjual.setText(res.getString("status_jual"));
                  lblcarajual.setText(res.getString("cara_jual"));
                  lblsisapiutang.setText(res.getString("sisa_piutang"));
                  lbljatuhtempo.setText(sdfoutput.format(jatuh));
                  lbltanggaljual.setText(sdfoutput.format(tglbeli));
                  lbljumlahretur.setText("0");
              }else{
                  JOptionPane.showMessageDialog(rootPane, "Nomor Faktur Tidak Terdaftar");
              }
              
              res = s.executeQuery("select Nama_customer from tblcustomer,"
                      + "tblpenjualan where tblpenjualan.kode_customer=tblcustomer.kode_customer "
                      + "and faktur_jual='"+cbofakturjual.getSelectedItem().toString()+"'");
              if(res.next()){
                  lblnamacustomer.setText(res.getString("nama_customer"));
              }else{
                  JOptionPane.showMessageDialog(rootPane, "Nomor Faktur Tidak Terdaftar");
              }
              
              DefaultTableModel model = (DefaultTableModel)dgv.getModel();
        while (model.getRowCount() > 0){
            for (int i = 0; i < model.getRowCount(); ++i){
                model.removeRow(i);
            }
        }
        
        String datadgv = "select TBLdetailJual.Kode_barang as [Kode Barang],"
                + "TblBarang.nama_Barang as [Nama Barang],Qty_Jual as Jumlah from tblPenjualan,"
                + "tbldetailJual,tblbarang where tbldetailJual.faktur_Jual=tblPenjualan.faktur_Jual and "
                + "tbldetailJual.kode_barang=tblbarang.kode_barang and tbldetailJual.faktur_Jual= '"
                +cbofakturjual.getSelectedItem().toString()+"'";
        res = s.executeQuery(datadgv);
        while(res.next()){
             
                String kolom1 = res.getString("Kode Barang");
                String kolom2 = res.getString("Nama Barang");
                String kolom3 = res.getString("Jumlah");
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
            Logger.getLogger(TransaksiReturPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbofakturjualFocusLost

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
    private javax.swing.JComboBox<String> cbofakturjual;
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
    private javax.swing.JLabel lblcarajual;
    private javax.swing.JLabel lbljatuhtempo;
    private javax.swing.JLabel lbljumlahretur;
    private javax.swing.JLabel lblnamacustomer;
    private javax.swing.JLabel lblsisapiutang;
    private javax.swing.JLabel lblstatusjual;
    private javax.swing.JLabel lbltanggaljual;
    private javax.swing.JTextField txtnomorretur;
    // End of variables declaration//GEN-END:variables

}
