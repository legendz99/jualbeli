
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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
public class TransaksiPenjualan extends javax.swing.JInternalFrame {

    String TXTkode;

    /**
     * Creates new form TransaksiPembelian
     */

    
    public TransaksiPenjualan() {//CONSTRUCTOR

        initComponents();
        tampilcustomer();
        tampilbarang();
        nomorotomatis();
  
    }
    
    public void nomorotomatis(){
        Date date = new Date();
        dtptanggal.setDate(date);
        try{
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tblPenjualan where faktur_jual in(select max(faktur_jual) from tblPenjualan)";
            ResultSet res = s.executeQuery(sql);
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
            if(res.next()){
                String fj = res.getString("faktur_jual").substring(2, 8);
                String dtp = sdf.format(date);
                if(fj.equals(dtp)){
                    int faktur = Integer.parseInt(res.getString("faktur_jual").substring(2, 10))+1;
                    txtnofaktur.setText(Integer.toString(faktur));
                    txtnofaktur.setText("FJ"+txtnofaktur.getText());         
                }else{
                    txtnofaktur.setText("FJ"+dtp+"01");
                }
            }else{
                txtnofaktur.setText("FJ"+sdf.format(date)+"01");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }  
    }
           

    public void tampilcustomer(){
         try{
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tblcustomer";
            ResultSet res = s.executeQuery(sql);
            cbocustomer.removeAllItems();
            while(res.next()){
                cbocustomer.addItem(res.getString("nama_customer").toUpperCase());
            }
         }catch(SQLException e){
             JOptionPane.showMessageDialog(rootPane, e);
         }       
    }
    
    public void tampilbarang(){
        Object header[]={"Kode Barang","Nama Barang","Harga"};
        DefaultTableModel data = new DefaultTableModel(null, header){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        dgvbarang.setModel(data);
        
        try{
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tblbarang where stok>0";
            ResultSet res = s.executeQuery(sql);
            while(res.next()){
                String kolom1 = res.getString("kode_barang");
                String kolom2 = res.getString("nama_barang");
                String kolom3 = res.getString("harga_jual");
                
                String kolom[] = {kolom1, kolom2, kolom3};
                data.addRow(kolom);
                
                dgvbarang.getColumnModel().getColumn(2).setMinWidth(0);
                dgvbarang.getColumnModel().getColumn(2).setMaxWidth(0);
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }               
    }
    
    public void kosongkan(){
        lbljumlahbarang.setText("");
        lbltotalharga.setText("");
        lblcarajual.setText("");
        lblsisahutang.setText("");
        lbljatuhtempo.setText("");
        lblstatusjual.setText("");
        lblkodecustomer.setText("");
        lblkembali.setText("");
        txtdibayar.setText("");
        txttempo.setText("");
        txtnofaktur.setText("");
        txtnofaktur.requestFocus();
    }
    
     public void hitungtransaksi(){
        int x = 0;
        int y = 0;
        
        for(int baris = 0; baris <= dgv.getRowCount()-1; baris++){
            x = x + (Integer.parseInt(dgv.getValueAt(baris, 3).toString()));
            y = y + (Integer.parseInt(dgv.getValueAt(baris, 4).toString()));      
            lbljumlahbarang.setText(Integer.toString(x));
            lbltotalharga.setText(Integer.toString(y));
                }          
    }
     
     public void cetakfaktur() throws JRException{
         JasperReport jr;
         JasperPrint jp;
         JasperDesign jd;
         try{
             HashMap param = new HashMap();
             param.put("nofaktur", txtnofaktur.getText());
             
             Connection c = conn.getKoneksi();
             Statement s = c.createStatement();
             String fakturjual = "src/Report/FakturPenjualan.jasper";
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
        cbocustomer = new javax.swing.JComboBox<>();
        lbljumlahbarang = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblkodecustomer = new javax.swing.JLabel();
        lblstatusjual = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtcaridata = new javax.swing.JTextPane();
        txtnofaktur = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgv = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        dgvbarang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnsimpan = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btntutup = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbltotalharga = new javax.swing.JLabel();
        lblsisahutang = new javax.swing.JLabel();
        txtdibayar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblcarajual = new javax.swing.JLabel();
        lbljatuhtempo = new javax.swing.JLabel();
        txttempo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lblkembali = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(970, 438));

        jLabel1.setText("No Faktur");
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel2.setText("Tanggal");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 20));

        dtptanggal.setDateFormatString("dd/MM/yyyy");
        dtptanggal.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel3.setText("Customer");
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel4.setText("Jumlah Barang");
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 20));

        cbocustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbocustomer.setMinimumSize(new java.awt.Dimension(206, 20));
        cbocustomer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbocustomerFocusLost(evt);
            }
        });

        lbljumlahbarang.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel5.setText("Status Jual");
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 20));

        lblkodecustomer.setPreferredSize(new java.awt.Dimension(100, 20));

        lblstatusjual.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel6.setText("Cari Nama Barang");

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
        );

        txtnofaktur.setText("jLabel13");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtnofaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dtptanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbocustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbljumlahbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblstatusjual, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblkodecustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbocustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblkodecustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnofaktur))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtptanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbljumlahbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblstatusjual, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        dgv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Harga Beli", "Jumlah", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgv.setEditingColumn(0);
        dgv.setEditingRow(0);
        dgv.setPreferredSize(new java.awt.Dimension(648, 235));
        dgv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dgvKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(dgv);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(219, 239));

        dgvbarang.setModel(new javax.swing.table.DefaultTableModel(
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
        dgvbarang.setPreferredSize(new java.awt.Dimension(206, 239));
        dgvbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvbarangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(dgvbarang);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
        );

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

        jLabel7.setText("Total Harga");
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel8.setText("Dibayar");
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel9.setText("Sisa (Hutang)");
        jLabel9.setPreferredSize(new java.awt.Dimension(100, 20));

        lbltotalharga.setPreferredSize(new java.awt.Dimension(100, 20));

        lblsisahutang.setPreferredSize(new java.awt.Dimension(100, 20));

        txtdibayar.setPreferredSize(new java.awt.Dimension(100, 20));
        txtdibayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdibayarKeyPressed(evt);
            }
        });

        jLabel10.setText("Cara Jual");
        jLabel10.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel11.setText("Tempo (Hari)");
        jLabel11.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel12.setText("Jatuh Tempo");
        jLabel12.setPreferredSize(new java.awt.Dimension(100, 20));

        lblcarajual.setPreferredSize(new java.awt.Dimension(100, 20));

        lbljatuhtempo.setPreferredSize(new java.awt.Dimension(100, 20));

        txttempo.setPreferredSize(new java.awt.Dimension(100, 20));
        txttempo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttempoKeyPressed(evt);
            }
        });

        jLabel13.setText("Kembali");
        jLabel13.setPreferredSize(new java.awt.Dimension(100, 20));

        lblkembali.setPreferredSize(new java.awt.Dimension(100, 20));

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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalharga, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdibayar, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblsisahutang, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblkembali, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcarajual, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbljatuhtempo, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttempo, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(99, 99, 99))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btntutup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsimpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblcarajual, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbltotalharga, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtdibayar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttempo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbljatuhtempo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblsisahutang, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntutupActionPerformed
        this.dispose();
    }//GEN-LAST:event_btntutupActionPerformed

    private void txtcaridataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcaridataKeyPressed
        Object header[]={"Kode Barang","Nama Barang","Harga"};
        DefaultTableModel data = new DefaultTableModel(null, header){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;};};
        dgvbarang.setModel(data);
        try{
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tblbarang where nama_barang like '%"+txtcaridata.getText()+"%' and stok>0";
            ResultSet res = s.executeQuery(sql);
            while(res.next()){
                String kolom1 = res.getString("kode_barang");
                String kolom2 = res.getString("nama_barang");
                String kolom3 = res.getString("harga_jual");
                
                String kolom[] = {kolom1, kolom2, kolom3};
                data.addRow(kolom);
                
                dgvbarang.getColumnModel().getColumn(2).setMinWidth(0);
                dgvbarang.getColumnModel().getColumn(2).setMaxWidth(0);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        } 
    }//GEN-LAST:event_txtcaridataKeyPressed

    private void dgvbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvbarangMouseClicked
       Object header[]={"Kode Barang","Nama Barang","Harga","Jumlah","Total"};
        DefaultTableModel data = (DefaultTableModel) dgv.getModel();
        dgv.setModel(data);
        data.setRowCount(dgv.getRowCount()+1);
        int baris = dgv.getRowCount()-1;
        int rowbarang = dgvbarang.rowAtPoint(evt.getPoint());
        int row = dgv.getRowCount();
        String kode_barang = dgvbarang.getValueAt(rowbarang, 0).toString();
        String nama_barang = dgvbarang.getValueAt(rowbarang, 1).toString();
        String harga_beli = dgvbarang.getValueAt(rowbarang, 2).toString();

        dgv.setValueAt(kode_barang, baris, 0);
        dgv.setValueAt(nama_barang, baris, 1);
        dgv.setValueAt(harga_beli, baris, 2);
        dgv.setValueAt(+1, baris, 3);
        dgv.setValueAt(Integer.parseInt(dgv.getValueAt(baris, 2).toString()) * Integer.parseInt(dgv.getValueAt(baris, 3).toString()), baris,  4);

        txtcaridata.setText("");

        int barisatas;

        hitungtransaksi();

        for (barisatas=0; barisatas <= dgv.getRowCount() -1 ;barisatas++){
            int barisbawah;
            for(barisbawah = barisatas + 1; barisbawah <= dgv.getRowCount()-1; barisbawah++){
                if (dgv.getValueAt(barisbawah, 0) == dgv.getValueAt(barisatas, 0)){
                    dgv.setValueAt(Integer.parseInt(dgv.getValueAt(barisatas, 3).toString())+1, barisatas, 3);
                    dgv.setValueAt(Integer.parseInt(dgv.getValueAt(barisatas, 2).toString()) * Integer.parseInt(dgv.getValueAt(barisatas, 3).toString()), barisatas, 4);
                    data.removeRow(barisbawah);
                    hitungtransaksi();
                }

            }
        }
    }//GEN-LAST:event_dgvbarangMouseClicked

    private void txtdibayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdibayarKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date tgl = dtptanggal.getDate();
                if((Integer.parseInt(txtdibayar.getText())) == (Integer.parseInt(lbltotalharga.getText()))){
                    lblcarajual.setText("CASH");
                    lblsisahutang.setText("0");
                    txttempo.setText("0");
                    lblkembali.setText("0");
                    txttempo.setEnabled(false);
                    lbljatuhtempo.setText(sdf.format(tgl));
                    lblstatusjual.setText("LUNAS");
                    btnsimpan.requestFocus();
        }else{
                    if((Integer.parseInt(txtdibayar.getText())) > (Integer.parseInt(lbltotalharga.getText()))){
                        lblcarajual.setText("CASH");
                        lblsisahutang.setText("0");
                        txttempo.setText("0");
                        String kembali = String.valueOf((Integer.parseInt(txtdibayar.getText())) - (Integer.parseInt(lbltotalharga.getText())));
                        lblkembali.setText(kembali);
                        txttempo.setEnabled(false);
                        lbljatuhtempo.setText(sdf.format(tgl));
                        lblstatusjual.setText("LUNAS");
                        btnsimpan.requestFocus();
                    }else{
                    String sisahutang = String.valueOf(Integer.parseInt(lbltotalharga.getText()) - Integer.parseInt(txtdibayar.getText())) ;
                    lblcarajual.setText("KREDIT");
                    lblsisahutang.setText(sisahutang);
                    lblstatusjual.setText("BELUM LUNAS");
                    lblkembali.setText("0");
                    txttempo.setEnabled(true);
                    txttempo.requestFocus();
                    }
                }
            }
    }//GEN-LAST:event_txtdibayarKeyPressed

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

    private void txttempoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttempoKeyPressed
       if (evt.getKeyChar() == KeyEvent.VK_ENTER){
            Login login = new Login();
           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            int tambahhari = Integer.parseInt(txttempo.getText());
            Date tgl = dtptanggal.getDate();
           
           Calendar calTambah = Calendar.getInstance();
           calTambah.setTime(tgl);
           calTambah.add(Calendar.DAY_OF_MONTH, tambahhari);

            lbljatuhtempo.setText(sdf.format(calTambah.getTime()));
       }
    }//GEN-LAST:event_txttempoKeyPressed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        if (txtnofaktur.getText().equals("") || cbocustomer.getSelectedItem().toString().equals("") 
                || txtdibayar.getText().equals("") || txttempo.getText().equals("") || lbljumlahbarang.getText().equals("")
                || lbltotalharga.getText().equals("") || lblkodecustomer.getText().equals("")){
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

                String simpan1  = "insert into tblpenjualan values(?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement ps = c.prepareStatement(simpan1);
                    ps.setString(1, txtnofaktur.getText());
                    ps.setTimestamp(2, dtptgl);
                    ps.setInt(3, Integer.parseInt(lbljumlahbarang.getText()));
                    ps.setInt(4, Integer.parseInt(lbltotalharga.getText()));
                    ps.setInt(5, Integer.parseInt(txtdibayar.getText()));
                    ps.setInt(6, Integer.parseInt(lblkembali.getText()));
                    ps.setString(7, lblcarajual.getText());
                    ps.setInt(8, Integer.parseInt(lblsisahutang.getText()));
                    ps.setTimestamp(9, jatuhtempo);
                    ps.setString(10, lblstatusjual.getText());
                    ps.setString(11, lblkodecustomer.getText());
                    ps.setString(12, TXTkode);
                    ps.executeUpdate();
                    
                                        
                if(lblcarajual.getText() == "CASH"){
                    String simpanjurnal1  = "insert into tbljurnal values(?,?,?,?,?,?)";
                    ps = c.prepareStatement(simpanjurnal1);
                    ps.setString(1, txtnofaktur.getText());
                    ps.setTimestamp(2, dtptgl);
                    ps.setString(3, "100");
                    ps.setString(4, "KAS PENJUALAN TUNAI DARI "+cbocustomer.getSelectedItem().toString());
                    ps.setInt(5, Integer.parseInt(lbltotalharga.getText()));
                    ps.setInt(6, 0);

                    ps.executeUpdate();
                    
                    String simpanjurnal2  = "insert into tbljurnal values(?,?,?,?,?,?)";
                    ps = c.prepareStatement(simpanjurnal2);
                    ps.setString(1, txtnofaktur.getText());
                    ps.setTimestamp(2, dtptgl);
                    ps.setString(3, "400");
                    ps.setString(4, "PENJUALAN TUNAI KE "+cbocustomer.getSelectedItem().toString());
                    ps.setInt(5, 0);
                    ps.setInt(6, Integer.parseInt(lbltotalharga.getText()));

                    ps.executeUpdate();
                    
                }else{
                    String simpanjurnal3  = "insert into tbljurnal values(?,?,?,?,?,?)";
                    ps = c.prepareStatement(simpanjurnal3);
                    ps.setString(1, txtnofaktur.getText());
                    ps.setTimestamp(2, dtptgl);
                    ps.setString(3, "100");
                    ps.setString(4, "KAS PENJUALAN KE "+cbocustomer.getSelectedItem().toString());
                    ps.setInt(5, Integer.parseInt(txtdibayar.getText()));
                    ps.setInt(6, 0);

                    ps.executeUpdate();
                    
                    String simpanjurnal4  = "insert into tbljurnal values(?,?,?,?,?,?)";
                    ps = c.prepareStatement(simpanjurnal4);
                    ps.setString(1, txtnofaktur.getText());
                    ps.setTimestamp(2, dtptgl);
                    ps.setString(3, "101");
                    ps.setString(4, "PIUTANG PENJUALAN KE "+cbocustomer.getSelectedItem().toString());
                    ps.setInt(5, Integer.parseInt(lblsisahutang.getText()));
                    ps.setInt(6, 0);
                    
                    ps.executeUpdate();
                    
                    String simpanjurnal5  = "insert into tbljurnal values(?,?,?,?,?,?)";
                    ps = c.prepareStatement(simpanjurnal5);
                    ps.setString(1, txtnofaktur.getText());
                    ps.setTimestamp(2, dtptgl);
                    ps.setString(3, "400");
                    ps.setString(4, "PENJUALAN KE "+cbocustomer.getSelectedItem().toString());
                    ps.setInt(5, 0);
                    ps.setInt(6, Integer.parseInt(lbltotalharga.getText()));

                    ps.executeUpdate();
                
                }
                int baris;
                for(baris = 0; baris <= dgv.getRowCount()-1; baris++){
                String simpan2  = "insert into tbldetailjual values(?,?,?,?,?,?)";
                ps = c.prepareStatement(simpan2);
                ps.setString(1, txtnofaktur.getText());
                ps.setString(2, dgv.getValueAt(baris, 0).toString());
                ps.setInt(3, Integer.parseInt(dgv.getValueAt(baris, 2).toString()));
                ps.setInt(4, Integer.parseInt(dgv.getValueAt(baris, 3).toString()));
                ps.setInt(5, Integer.parseInt(dgv.getValueAt(baris, 4).toString()));
                ps.setString(6, "-");
                ps.executeUpdate(); 
 
                String tblbarang = "select * from tblbarang where kode_barang= '"+dgv.getValueAt(baris, 0)+"'";
                ResultSet res = s.executeQuery(tblbarang);
                if(res.next()){
                    String tambahstok = "update tblbarang set stok = '"+(Integer.parseInt(res.getString("stok"))-Integer.parseInt(dgv.getValueAt(baris, 3).toString()))+"'where kode_barang = '"+dgv.getValueAt(baris, 0)+"'";
                ps = c.prepareStatement(tambahstok);
                    ps.execute();
                }

            }               
                
            }catch(SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
                
            } catch (ParseException ex) {
            Logger.getLogger(TransaksiPembelian.class.getName()).log(Level.SEVERE, null, ex);
        } int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Cetak Faktur ?", "Warning", dialogButton);
            if(dialogResult == 0) {
            try {
                cetakfaktur();
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

    private void cbocustomerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbocustomerFocusLost
        try{
              Connection c = conn.getKoneksi();
              Statement s = c.createStatement();
              String sql = "select * from tblcustomer where nama_customer= '"+cbocustomer.getSelectedItem().toString()+"'";
              ResultSet res = s.executeQuery(sql);
              if(res.next()){
                  lblkodecustomer.setText(res.getString("kode_customer"));
              }
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
                
            }
    }//GEN-LAST:event_cbocustomerFocusLost

    private void dgvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dgvKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_DELETE){
                 DefaultTableModel data = (DefaultTableModel) dgv.getModel();
        dgv.setModel(data);
        data.setRowCount(dgv.getRowCount());
        data.removeRow(dgv.getSelectedRow());
        evt.setKeyCode(KeyEvent.VK_DOWN);
            }
    }//GEN-LAST:event_dgvKeyPressed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntutup;
    private javax.swing.JComboBox<String> cbocustomer;
    private javax.swing.JTable dgv;
    private javax.swing.JTable dgvbarang;
    private com.toedter.calendar.JDateChooser dtptanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblcarajual;
    private javax.swing.JLabel lbljatuhtempo;
    private javax.swing.JLabel lbljumlahbarang;
    private javax.swing.JLabel lblkembali;
    private javax.swing.JLabel lblkodecustomer;
    private javax.swing.JLabel lblsisahutang;
    private javax.swing.JLabel lblstatusjual;
    private javax.swing.JLabel lbltotalharga;
    private javax.swing.JTextPane txtcaridata;
    private javax.swing.JTextField txtdibayar;
    private javax.swing.JLabel txtnofaktur;
    private javax.swing.JTextField txttempo;
    // End of variables declaration//GEN-END:variables

}
