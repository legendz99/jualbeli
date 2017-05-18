
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
public class MenuUtama extends javax.swing.JFrame {
    
    public JLabel txtkodeuser(){
        return this.TXTkodeuser;
    }
    
    public JLabel txtnamauser(){
        return TXTnamauser;
    }
    
    public JLabel txtstatususer(){
        return TXTstatususer;
    }
    
    public JMenuItem btnuser(){
        return btnuser;
    }
 

    /**
     * Creates new form MenuUtama
     */
    public MenuUtama() {
        initComponents();
        msk();
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TXTkodeuser = new javax.swing.JLabel();
        TXTnamauser = new javax.swing.JLabel();
        TXTstatususer = new javax.swing.JLabel();
        Desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnuser = new javax.swing.JMenuItem();
        btnbarang = new javax.swing.JMenuItem();
        btnperkiraan = new javax.swing.JMenuItem();
        btnsupplier = new javax.swing.JMenuItem();
        btncustomer = new javax.swing.JMenuItem();
        btnprofil = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        btnlogoff = new javax.swing.JMenuItem();
        btnexit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Jual Beli");
        setBackground(new java.awt.Color(51, 0, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(MAXIMIZED_BOTH);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(1280, 720));

        TXTkodeuser.setText("jLabel1");
        TXTkodeuser.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        TXTnamauser.setText("jLabel1");
        TXTnamauser.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        TXTstatususer.setText("jLabel1");
        TXTstatususer.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );

        jMenu1.setText("Master Data");
        jMenu1.setNextFocusableComponent(jMenu1);

        btnuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnuser.Image.png"))); // NOI18N
        btnuser.setText("User");
        btnuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuserActionPerformed(evt);
            }
        });
        jMenu1.add(btnuser);

        btnbarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnbarang.Image.png"))); // NOI18N
        btnbarang.setText("Barang");
        btnbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbarangActionPerformed(evt);
            }
        });
        jMenu1.add(btnbarang);

        btnperkiraan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnperkiraan.Image.png"))); // NOI18N
        btnperkiraan.setText("Perkiraan");
        btnperkiraan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnperkiraanActionPerformed(evt);
            }
        });
        jMenu1.add(btnperkiraan);

        btnsupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnsupplier.Image.png"))); // NOI18N
        btnsupplier.setText("Supplier");
        btnsupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsupplierActionPerformed(evt);
            }
        });
        jMenu1.add(btnsupplier);

        btncustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btncustomer.Image.png"))); // NOI18N
        btncustomer.setText("Customer");
        btncustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncustomerActionPerformed(evt);
            }
        });
        jMenu1.add(btncustomer);

        btnprofil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnprofil.Image.png"))); // NOI18N
        btnprofil.setText("Profil Perusahaan");
        btnprofil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprofilActionPerformed(evt);
            }
        });
        jMenu1.add(btnprofil);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Transaksi");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnpembelian.Image.png"))); // NOI18N
        jMenuItem7.setText("Pembelian");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnreturbeli.Image.png"))); // NOI18N
        jMenuItem8.setText("Retur Beli");
        jMenu2.add(jMenuItem8);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnpenjualan.Image.png"))); // NOI18N
        jMenuItem9.setText("Penjualan");
        jMenu2.add(jMenuItem9);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnreturjual.Image.png"))); // NOI18N
        jMenuItem10.setText("Retur Jual");
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Laporan");

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnlapmaster.Image.png"))); // NOI18N
        jMenuItem11.setText("Master");
        jMenu3.add(jMenuItem11);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnlappembelian.Image.png"))); // NOI18N
        jMenuItem12.setText("Pembelian");
        jMenu3.add(jMenuItem12);

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnlapreturbeli.Image.png"))); // NOI18N
        jMenuItem13.setText("Retur Beli");
        jMenu3.add(jMenuItem13);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnlappenjualan.Image.png"))); // NOI18N
        jMenuItem14.setText("Penjualan");
        jMenu3.add(jMenuItem14);

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnlapreturjual.Image.png"))); // NOI18N
        jMenuItem15.setText("Retur Jual");
        jMenu3.add(jMenuItem15);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Keluar");

        btnlogoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnlogoff.Image.png"))); // NOI18N
        btnlogoff.setText("Log Off");
        btnlogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoffActionPerformed(evt);
            }
        });
        jMenu4.add(btnlogoff);

        btnexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/MenuUtama/btnexit.Image.png"))); // NOI18N
        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        jMenu4.add(btnexit);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TXTkodeuser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXTnamauser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXTstatususer)
                .addContainerGap(652, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Desktop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTkodeuser)
                    .addComponent(TXTnamauser)
                    .addComponent(TXTstatususer))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void msk(){
       try{
        Login login = new Login();
        Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tbluser where nama_user='"+login.txtuser().getText()+"'";
            ResultSet res = s.executeQuery(sql);
        TXTkodeuser.setText(res.getString("kode_user"));}
       catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Kesalahan Saat Mengakses Database : "+e);
        }
    }
    
    private void btnuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuserActionPerformed
        MasterUser mUser = new MasterUser();
        Dimension desktopSize = Desktop.getSize();
        Dimension mUserSize = mUser.getSize();
        Desktop.add(mUser);
        mUser.show();
        mUser.setLocation((desktopSize.width - mUserSize.width)/2, (desktopSize.height - mUserSize.height)/2);// TODO add your handling code here:
    }//GEN-LAST:event_btnuserActionPerformed

    private void btnbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbarangActionPerformed
        MasterBarang mBarang = new MasterBarang();
        Dimension desktopSize = Desktop.getSize();
        Dimension mBarangSize = mBarang.getSize();
        Desktop.add(mBarang);
        mBarang.show();
        mBarang.setLocation((desktopSize.width - mBarangSize.width)/2, (desktopSize.height - mBarangSize.height)/2);// TODO add your handling code here:
    }//GEN-LAST:event_btnbarangActionPerformed

    private void btnlogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoffActionPerformed
        Login login = new Login();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_btnlogoffActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnperkiraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnperkiraanActionPerformed
        MasterPerkiraan mPerkiraan = new MasterPerkiraan();
        Dimension desktopSize = Desktop.getSize();
        Dimension mPerkiraanSize = mPerkiraan.getSize();
        Desktop.add(mPerkiraan);
        mPerkiraan.show();
        mPerkiraan.setLocation((desktopSize.width - mPerkiraanSize.width)/2, (desktopSize.height - mPerkiraanSize.height)/2);
    }//GEN-LAST:event_btnperkiraanActionPerformed

    private void btnsupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsupplierActionPerformed
         MasterSupplier mSupplier = new MasterSupplier();
        Dimension desktopSize = Desktop.getSize();
        Dimension mSupplierSize = mSupplier.getSize();
        Desktop.add(mSupplier);
        mSupplier.show();
        mSupplier.setLocation((desktopSize.width - mSupplierSize.width)/2, (desktopSize.height - mSupplierSize.height)/2);
    }//GEN-LAST:event_btnsupplierActionPerformed

    private void btncustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncustomerActionPerformed
        MasterCustomer mCustomer = new MasterCustomer();
        Dimension desktopSize = Desktop.getSize();
        Dimension mCustomerSize = mCustomer.getSize();
        Desktop.add(mCustomer);
        mCustomer.show();
        mCustomer.setLocation((desktopSize.width - mCustomerSize.width)/2, (desktopSize.height - mCustomerSize.height)/2);
    }//GEN-LAST:event_btncustomerActionPerformed

    private void btnprofilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprofilActionPerformed
        MasterProfil mProfil = new MasterProfil();
        Dimension desktopSize = Desktop.getSize();
        Dimension mProfilSize = mProfil.getSize();
        Desktop.add(mProfil);
        mProfil.show();
        mProfil.setLocation((desktopSize.width - mProfilSize.width)/2, (desktopSize.height - mProfilSize.height)/2);
    }//GEN-LAST:event_btnprofilActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        MenuUtama mUtama = new MenuUtama();
        TransaksiPembelian tPembelian = new TransaksiPembelian();
        Dimension desktopSize = Desktop.getSize();
        Dimension tPembelianSize = tPembelian.getSize();
        Desktop.add(tPembelian);
        tPembelian.show();
        tPembelian.setLocation((desktopSize.width - tPembelianSize.width)/2, (desktopSize.height - tPembelianSize.height)/2);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuUtama().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JLabel TXTkodeuser;
    private javax.swing.JLabel TXTnamauser;
    private javax.swing.JLabel TXTstatususer;
    private javax.swing.JMenuItem btnbarang;
    private javax.swing.JMenuItem btncustomer;
    private javax.swing.JMenuItem btnexit;
    private javax.swing.JMenuItem btnlogoff;
    private javax.swing.JMenuItem btnperkiraan;
    private javax.swing.JMenuItem btnprofil;
    private javax.swing.JMenuItem btnsupplier;
    private javax.swing.JMenuItem btnuser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables

    void txtkode(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
