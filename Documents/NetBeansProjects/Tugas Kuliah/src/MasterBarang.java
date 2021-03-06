import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
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
public class MasterBarang extends javax.swing.JInternalFrame {

    /**
     * Creates new form MasterBarang
     */
    public MasterBarang() {
        initComponents();
        kosongkan();
    }
    
    public void kosongkan(){
        txtkodebarang.setText("");
        txtnamabarang.setText("");
        cbosatuan.removeAllItems();
        cbojenisbarang.removeAllItems();
        txthargabeli.setText("");
        txthargajual.setText("");
        txtstok.setText("");
        txtkodebarang.requestFocus();
        tampilsatuan();
        tampiljenis();
        tampilgrid();
    }
    
    public void databaru(){
        txtnamabarang.setText("");
        cbosatuan.removeAllItems();
        cbojenisbarang.removeAllItems();
        txthargabeli.setText("");
        txthargajual.setText("");
        txtstok.setText("");
        txtnamabarang.requestFocus();
    }
    
    public void ketemu(){
        tampilsatuan();
        tampiljenis();
        try{
              Connection c = conn.getKoneksi();
              Statement s = c.createStatement();
              String sql = "select * from tblbarang where kode_barang='"+txtkodebarang.getText()+"'";
              ResultSet res = s.executeQuery(sql);
              while(res.next()){
              txtnamabarang.setText(res.getString("nama_barang"));
              txthargabeli.setText(res.getString("harga_beli"));
              txthargajual.setText(res.getString("harga_jual"));
              txtstok.setText(res.getString("stok"));
              tampilsatuan();
              tampiljenis();
              cbosatuan.setSelectedItem(res.getString("satuan").toUpperCase());
              cbosatuan.setSelectedItem(res.getString("stok").toUpperCase());
              txtnamabarang.requestFocus();}
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
            
        }
    }
    
    public void tampilgrid(){
        Object header[]={"Kode Barang","Nama Barang","Satuan","Jenis","Harga Beli","Harga Jual","Stok"};
        DefaultTableModel data = new DefaultTableModel(null, header){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;};};
        dgv.setModel(data);
        try{
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tblbarang";
            ResultSet res = s.executeQuery(sql);
            while(res.next()){
                String kolom1 = res.getString("kode_barang");
                String kolom2 = res.getString("nama_barang");
                String kolom3 = res.getString("satuan");
                String kolom4 = res.getString("jenis");
                String kolom5 = res.getString("harga_beli");
                String kolom6 = res.getString("harga_jual");
                String kolom7 = res.getString("stok");
                String kolom[] = {kolom1, kolom2, kolom3, kolom4, kolom5, kolom6, kolom7};
                data.addRow(kolom);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }               
    }
    
    public void tampilsatuan(){
         try{
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select distinct satuan from tblbarang";
            ResultSet res = s.executeQuery(sql);
            cbosatuan.removeAllItems();
            while(res.next()){
                cbosatuan.addItem(res.getString("satuan").toUpperCase());
            }
         }catch(SQLException e){
             JOptionPane.showMessageDialog(rootPane, e);
         }
            
    }
    
    public void tampiljenis(){
         try{
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select distinct jenis from tblbarang";
            ResultSet res = s.executeQuery(sql);
            cbojenisbarang.removeAllItems();
            while(res.next()){
                cbojenisbarang.addItem(res.getString("jenis").toUpperCase());
            }
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtkodebarang = new javax.swing.JTextField();
        txthargabeli = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        txtnamabarang = new javax.swing.JTextField();
        cbosatuan = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbojenisbarang = new javax.swing.JComboBox<>();
        txthargajual = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnsimpan = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btntutup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtcaribarang = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgv = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Master Barang");
        setPreferredSize(new java.awt.Dimension(493, 411));

        jLabel1.setText("Kode Barang");

        jLabel2.setText("Nama Barang");

        jLabel3.setText("Satuan");

        jLabel4.setText("Harga Beli");

        jLabel5.setText("Stok");

        txtkodebarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtkodebarangFocusLost(evt);
            }
        });
        txtkodebarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtkodebarangKeyTyped(evt);
            }
        });

        cbosatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Jenis Barang");

        jLabel7.setText("Harga Jual");

        cbojenisbarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txthargajual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txthargajualFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtkodebarang)
                        .addGap(229, 229, 229))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnamabarang)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbosatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbojenisbarang, 0, 107, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtstok)
                        .addGap(229, 229, 229))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthargabeli, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthargajual)))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbosatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbojenisbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthargabeli, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthargajual, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MasterBarang/BTNSimpan.Image.png"))); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsimpan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MasterBarang/BTNHapus.Image.png"))); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnhapus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MasterBarang/BTNBatal.Image.png"))); // NOI18N
        btnbatal.setText("Batal");
        btnbatal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbatal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btntutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MasterBarang/BTNTutup.Image.png"))); // NOI18N
        btntutup.setText("Tutup");
        btntutup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btntutup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btntutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntutupActionPerformed(evt);
            }
        });

        txtcaribarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcaribarangKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtcaribarang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btntutup, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btntutup, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        dgv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dgv.setPreferredSize(new java.awt.Dimension(477, 159));
        dgv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(dgv);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        kosongkan();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btntutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntutupActionPerformed
        this.dispose();
    }//GEN-LAST:event_btntutupActionPerformed

    private void txthargajualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txthargajualFocusLost
        int hargajual;
        int hargabeli;
        hargajual=Integer.valueOf(txthargajual.getText());
        hargabeli=Integer.valueOf(txthargabeli.getText());
        if(hargajual<=hargabeli){
            JOptionPane.showMessageDialog(rootPane, "Harga Jual Harus Lebih Besar Dari Harga Beli");
        }
    }//GEN-LAST:event_txthargajualFocusLost

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
       try{
                Connection c = conn.getKoneksi();
                Statement s = c.createStatement();
                String sql = "select * from tblbarang where kode_barang= '"+txtkodebarang.getText()+"'";
                ResultSet res = s.executeQuery(sql);
                if(res.next()){
                    String edit  = "update tblbarang set nama_barang = '"+txtnamabarang.getText()+"',satuan = '"+cbosatuan.getSelectedItem().toString().toString()+"',jenis = '"+cbojenisbarang.getSelectedItem().toString().toUpperCase()+"',harga_beli = '"+txthargabeli.getText()+"',harga_jual = '"+txthargajual.getText()+"',stok = '"+txtstok.getText()+"'where kode_barang = '"+txtkodebarang.getText()+"'";
                    PreparedStatement st=c.prepareStatement(edit);
                    st.execute();
                }else{
                    String simpan  = "insert into tblbarang values('" +txtkodebarang.getText()+ "','" +txtnamabarang.getText()+ "','"+cbosatuan.getSelectedItem().toString().toUpperCase()+"','"+cbojenisbarang.getSelectedItem().toString().toUpperCase()+"','"+txthargabeli.getText()+"','"+txthargajual.getText()+"','"+txtstok.getText()+"')";
                    PreparedStatement st=c.prepareStatement(simpan);
                    st.execute();
                }
                
            }catch(SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
                
            }
            kosongkan();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void dgvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvMouseClicked
        int row = dgv.rowAtPoint(evt.getPoint());
        String kode_barang = dgv.getValueAt(row, 0).toString();
        String nama_barang = dgv.getValueAt(row, 1).toString();
        String satuan = dgv.getValueAt(row, 2).toString();
        String jenis_barang = dgv.getValueAt(row, 3).toString();
        String harga_beli = dgv.getValueAt(row, 4).toString();
        String harga_jual = dgv.getValueAt(row, 5).toString();
        String stok = dgv.getValueAt(row, 6).toString();
        
        txtkodebarang.setText(String.valueOf(kode_barang));
        txtnamabarang.setText(String.valueOf(nama_barang));
        cbosatuan.setSelectedItem(String.valueOf(satuan).toUpperCase());
        cbojenisbarang.setSelectedItem(String.valueOf(jenis_barang).toUpperCase());
        txthargabeli.setText(String.valueOf(harga_beli));
        txthargajual.setText(String.valueOf(harga_jual));
        txtstok.setText(String.valueOf(stok));
    }//GEN-LAST:event_dgvMouseClicked

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
       if(txtkodebarang.getText()== ""){
           JOptionPane.showMessageDialog(rootPane, "Kode Barang Harus diisi");
           txtkodebarang.requestFocus();
       }
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Yakin Ingin dihapus..?", "Warning", dialogButton);
            if(dialogResult == 0) {
               try{
                Connection c = conn.getKoneksi();
                Statement s = c.createStatement();
                String hapus = "delete * from tblbarang where kode_barang= '"+txtkodebarang.getText()+"'";
                PreparedStatement st=c.prepareStatement(hapus);
                st.execute();
                kosongkan();
                }catch(SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);              
                }
            } else {
                kosongkan();
} 
    }//GEN-LAST:event_btnhapusActionPerformed

    private void txtkodebarangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtkodebarangFocusLost
        try{
                Connection c = conn.getKoneksi();
                Statement s = c.createStatement();
                String sql = "select * from tblbarang where kode_barang= '"+txtkodebarang.getText()+"'";
                ResultSet res = s.executeQuery(sql);
                if(res.next()){
                    ketemu();
                }else{
                    databaru();
                }}catch(SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);              
                }
               ketemu();
    }//GEN-LAST:event_txtkodebarangFocusLost

    private void txtcaribarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcaribarangKeyPressed
        Object header[]={"Kode Barang","Nama Barang","Satuan","Jenis","Harga Beli","Harga Jual","Stok"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        dgv.setModel(data);
        try{
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tblbarang where nama_barang like '%"+txtcaribarang.getText()+"%'";
            ResultSet res = s.executeQuery(sql);
            while(res.next()){
                String kolom1 = res.getString("kode_barang");
                String kolom2 = res.getString("nama_barang");
                String kolom3 = res.getString("satuan");
                String kolom4 = res.getString("jenis");
                String kolom5 = res.getString("harga_beli");
                String kolom6 = res.getString("harga_jual");
                String kolom7 = res.getString("stok");
                String kolom[] = {kolom1, kolom2, kolom3, kolom4, kolom5, kolom6, kolom7};
                data.addRow(kolom);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_txtcaribarangKeyPressed

    private void txtkodebarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkodebarangKeyTyped
         evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
    }//GEN-LAST:event_txtkodebarangKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntutup;
    private javax.swing.JComboBox<String> cbojenisbarang;
    private javax.swing.JComboBox<String> cbosatuan;
    private javax.swing.JTable dgv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane txtcaribarang;
    private javax.swing.JTextField txthargabeli;
    private javax.swing.JTextField txthargajual;
    private javax.swing.JTextField txtkodebarang;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables
}
