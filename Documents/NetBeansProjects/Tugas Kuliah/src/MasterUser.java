
import java.sql.*;
import javax.swing.JOptionPane;
import koneksi.conn;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class MasterUser extends javax.swing.JInternalFrame {

    /**
     * Creates new form MasterUser
     */
    public MasterUser() {
        initComponents();
        kosongkan();
        
    }
    
    
    public void kosongkan(){
        txtkodeuser.setText("");
        txtnamauser.setText("");
        cbostatus.removeAllItems();
        txtpassword.setText("");
        txtcaridata.setText("");
        txtkodeuser.requestFocus();
        tampilstatus();
        tampilgrid();
    }
    
    public void databaru(){
        txtnamauser.setText("");
        cbostatus.removeAllItems();
        txtpassword.setText("");
        txtcaridata.setText("");
        txtnamauser.requestFocus();
    }
    
    public void ketemu(){
        tampilstatus();
        try{
              Connection c = conn.getKoneksi();
              Statement s = c.createStatement();
              String sql = "select * from tbluser where kode_user='"+txtkodeuser.getText()+"'";
              ResultSet res = s.executeQuery(sql);
              while(res.next()){
              txtnamauser.setText(res.getString("nama_user"));
              txtpassword.setText(res.getString("pwd_user"));
              tampilstatus();
              cbostatus.setSelectedItem(res.getString("status_user").toUpperCase());
              txtnamauser.requestFocus();}
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
            
        }
    }
    
    public void tampilgrid(){
        Object header[]={"Kode User","Nama User","Password User","Status User"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        dgv.setModel(data);
        try{
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tbluser";
            ResultSet res = s.executeQuery(sql);
            while(res.next()){
                String kolom1 = res.getString("kode_user");
                String kolom2 = res.getString("nama_user");
                String kolom3 = res.getString("pwd_user");
                String kolom4 = res.getString("status_user");
                
                String kolom[] = {kolom1, kolom2, kolom3, kolom4};
                data.addRow(kolom);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }               
    }
    
    public void tampilstatus(){
         try{
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select distinct status_user from tbluser";
            ResultSet res = s.executeQuery(sql);
            cbostatus.removeAllItems();
            while(res.next()){
                cbostatus.addItem(res.getString("status_user").toUpperCase());
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
        txtkodeuser = new javax.swing.JTextField();
        txtnamauser = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbostatus = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnsimpan = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btntutup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtcaridata = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgv = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Master User");
        setPreferredSize(new java.awt.Dimension(465, 389));

        jLabel1.setText("Kode User");
        jLabel1.setPreferredSize(new java.awt.Dimension(12, 16));

        jLabel2.setText("Nama User");
        jLabel2.setPreferredSize(new java.awt.Dimension(12, 16));

        jLabel3.setText("Password");
        jLabel3.setPreferredSize(new java.awt.Dimension(12, 16));

        txtkodeuser.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        txtkodeuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtkodeuserFocusLost(evt);
            }
        });
        txtkodeuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtkodeuserKeyTyped(evt);
            }
        });

        txtnamauser.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N

        txtpassword.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N

        jLabel4.setText("Status User");
        jLabel4.setPreferredSize(new java.awt.Dimension(12, 16));

        cbostatus.setEditable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbostatus, 0, 101, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtkodeuser, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addGap(204, 204, 204))
                            .addComponent(txtnamauser, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtkodeuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnamauser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbostatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MasterUser/btnsimpan.Image.png"))); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsimpan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MasterUser/btnbatal.Image.png"))); // NOI18N
        btnbatal.setText("Batal");
        btnbatal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbatal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btnhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MasterUser/btnhapus.Image.png"))); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnhapus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btntutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MasterUser/btntutup.Image.png"))); // NOI18N
        btntutup.setText("Tutup");
        btntutup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btntutup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btntutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntutupActionPerformed(evt);
            }
        });

        txtcaridata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcaridataKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtcaridata);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnhapus, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(btnsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(btnbatal, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(btntutup, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(6, 6, 6))
        );

        dgv.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        dgv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        dgv.setPreferredSize(new java.awt.Dimension(449, 148));
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
            try{
                Connection c = conn.getKoneksi();
                Statement s = c.createStatement();
                String sql = "select * from tbluser where kode_user= '"+txtkodeuser.getText()+"'";
                ResultSet res = s.executeQuery(sql);
                if(res.next()){
                    String edit  = "update tbluser set nama_user = '"+txtnamauser.getText()+"',status_user = '"+cbostatus.getSelectedItem().toString().toUpperCase()+"',pwd_user = '"+txtpassword.getText()+"'where kode_user = '"+txtkodeuser.getText()+"'";
                    PreparedStatement st=c.prepareStatement(edit);
                    st.execute();
                }else{
                    String simpan  = "insert into tbluser values('" +txtkodeuser.getText()+ "','" +txtnamauser.getText()+ "','" +txtpassword.getText()+ "','"+cbostatus.getSelectedItem().toString().toUpperCase()+"')";
                    PreparedStatement st=c.prepareStatement(simpan);
                    st.execute();
                }
                
            }catch(SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
                
            }
            kosongkan();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void txtkodeuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtkodeuserFocusLost
               try{
                Connection c = conn.getKoneksi();
                Statement s = c.createStatement();
                String sql = "select * from tbluser where kode_user= '"+txtkodeuser.getText()+"'";
                ResultSet res = s.executeQuery(sql);
                if(res.next()){
                    ketemu();
                }else{
                    databaru();
                }}catch(SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);              
                }
               ketemu();
    }//GEN-LAST:event_txtkodeuserFocusLost

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        kosongkan();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btntutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntutupActionPerformed
        this.dispose();
    }//GEN-LAST:event_btntutupActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
       if(txtkodeuser.getText().equalsIgnoreCase("")){
           JOptionPane.showMessageDialog(rootPane, "Kode User Harus diisi");
           txtkodeuser.requestFocus();
       }else{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Yakin Ingin dihapus..?", "Warning", dialogButton);
            if(dialogResult == 0) {
               try{
                Connection c = conn.getKoneksi();
                Statement s = c.createStatement();
                String hapus = "delete * from tbluser where kode_user= '"+txtkodeuser.getText()+"'";
                PreparedStatement st=c.prepareStatement(hapus);
                st.execute();
                kosongkan();
                }catch(SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);              
                }
            } else {
                kosongkan();
}    }  
    }//GEN-LAST:event_btnhapusActionPerformed

    private void dgvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvMouseClicked
        int row = dgv.rowAtPoint(evt.getPoint());
        String kode_user = dgv.getValueAt(row, 0).toString();
        String nama_user = dgv.getValueAt(row, 1).toString();
        String pwd_user = dgv.getValueAt(row, 2).toString();
        String status_user = dgv.getValueAt(row, 3).toString();
        
        txtkodeuser.setText(String.valueOf(kode_user));
        txtnamauser.setText(String.valueOf(nama_user));
        txtpassword.setText(String.valueOf(pwd_user));
        cbostatus.setSelectedItem(String.valueOf(status_user).toUpperCase());
    }//GEN-LAST:event_dgvMouseClicked

    private void txtkodeuserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkodeuserKeyTyped
        evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
    }//GEN-LAST:event_txtkodeuserKeyTyped

    private void txtcaridataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcaridataKeyPressed
       Object header[]={"Kode User","Nama User","Password User","Status User"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        dgv.setModel(data);
        try{
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tbluser where nama_user like '%"+txtcaridata.getText()+"%'";
            ResultSet res = s.executeQuery(sql);
            while(res.next()){
                String kolom1 = res.getString("kode_user");
                String kolom2 = res.getString("nama_user");
                String kolom3 = res.getString("pwd_user");
                String kolom4 = res.getString("status_user");
                
                String kolom[] = {kolom1, kolom2, kolom3, kolom4};
                data.addRow(kolom);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_txtcaridataKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntutup;
    private javax.swing.JComboBox<String> cbostatus;
    private javax.swing.JTable dgv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane txtcaridata;
    private javax.swing.JTextField txtkodeuser;
    private javax.swing.JTextField txtnamauser;
    private javax.swing.JTextField txtpassword;
    // End of variables declaration//GEN-END:variables
}
