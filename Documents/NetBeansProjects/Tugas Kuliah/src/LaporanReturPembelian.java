
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class LaporanReturPembelian extends javax.swing.JInternalFrame {

    String namafileaccess = "tblreturpembelian";
    String namafileexcel;

    /**
     * Creates new form TransaksiReturPembelian
     */

    
    public LaporanReturPembelian() {//CONSTRUCTOR

        initComponents();
        tampilfaktur();
        tampilsupplier();
        
    }
    
    public void tampilsupplier(){
        try{
             DefaultListModel listModel = new DefaultListModel();
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tblsupplier";
            ResultSet res = s.executeQuery(sql);
            listModel.clear();
            while(res.next()){
               listModel.addElement(res.getString("nama_supplier").toUpperCase());
                listsupplier.setModel(listModel);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }  
    }
           

    public void tampilfaktur(){
         try{
            DefaultListModel listModel = new DefaultListModel();
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tblreturpembelian ORDER BY no_retur_beli DESC";
            ResultSet res = s.executeQuery(sql);
            listModel.clear();
            while(res.next()){
               listModel.addElement(res.getString("no_retur_beli").toUpperCase());
                listfaktur.setModel(listModel);
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
        panelharian = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dtpharian = new com.toedter.calendar.JDateChooser();
        btnharian = new javax.swing.JButton();
        panelharian1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dtpawal = new com.toedter.calendar.JDateChooser();
        btnperiodik = new javax.swing.JButton();
        dtpakhir = new com.toedter.calendar.JDateChooser();
        panelharian3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listfaktur = new javax.swing.JList<>();
        panelharian4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listsupplier = new javax.swing.JList<>();
        panelharian7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnexport = new javax.swing.JButton();
        txtexport = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgv = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(692, 438));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(panelharian);
        jLabel1.setText("Harian");
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 20));

        dtpharian.setDateFormatString("dd/MM/yyyy");
        dtpharian.setPreferredSize(new java.awt.Dimension(100, 20));

        btnharian.setText("Preview");
        btnharian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnharianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelharianLayout = new javax.swing.GroupLayout(panelharian);
        panelharian.setLayout(panelharianLayout);
        panelharianLayout.setHorizontalGroup(
            panelharianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtpharian, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelharianLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnharian, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelharianLayout.setVerticalGroup(
            panelharianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelharianLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dtpharian, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnharian)
                .addContainerGap())
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setLabelFor(panelharian);
        jLabel2.setText("Periodik");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 20));

        dtpawal.setDateFormatString("dd/MM/yyyy");
        dtpawal.setPreferredSize(new java.awt.Dimension(100, 20));

        btnperiodik.setText("Preview");
        btnperiodik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnperiodikActionPerformed(evt);
            }
        });

        dtpakhir.setDateFormatString("dd/MM/yyyy");
        dtpakhir.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout panelharian1Layout = new javax.swing.GroupLayout(panelharian1);
        panelharian1.setLayout(panelharian1Layout);
        panelharian1Layout.setHorizontalGroup(
            panelharian1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtpawal, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dtpakhir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelharian1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnperiodik)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelharian1Layout.setVerticalGroup(
            panelharian1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelharian1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dtpawal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtpakhir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnperiodik)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setLabelFor(panelharian);
        jLabel9.setText("Nomor Faktur");
        jLabel9.setPreferredSize(new java.awt.Dimension(100, 20));

        listfaktur.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listfakturValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listfaktur);

        javax.swing.GroupLayout panelharian3Layout = new javax.swing.GroupLayout(panelharian3);
        panelharian3.setLayout(panelharian3Layout);
        panelharian3Layout.setHorizontalGroup(
            panelharian3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelharian3Layout.setVerticalGroup(
            panelharian3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelharian3Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setLabelFor(panelharian);
        jLabel11.setText("Supplier");
        jLabel11.setPreferredSize(new java.awt.Dimension(100, 20));

        listsupplier.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listsupplierValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listsupplier);

        javax.swing.GroupLayout panelharian4Layout = new javax.swing.GroupLayout(panelharian4);
        panelharian4.setLayout(panelharian4Layout);
        panelharian4Layout.setHorizontalGroup(
            panelharian4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelharian4Layout.setVerticalGroup(
            panelharian4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelharian4Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setLabelFor(panelharian);
        jLabel15.setText("Export Ke Excel");
        jLabel15.setPreferredSize(new java.awt.Dimension(100, 20));

        btnexport.setText("Preview");
        btnexport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexportActionPerformed(evt);
            }
        });

        txtexport.setText("Ketik Nama File Konversi");
        txtexport.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtexportKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelharian7Layout = new javax.swing.GroupLayout(panelharian7);
        panelharian7.setLayout(panelharian7Layout);
        panelharian7Layout.setHorizontalGroup(
            panelharian7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addComponent(btnexport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtexport, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelharian7Layout.setVerticalGroup(
            panelharian7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelharian7Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnexport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtexport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelharian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelharian1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelharian3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelharian4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelharian7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelharian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelharian1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(panelharian3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelharian4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelharian7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dgv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        dgv.setEditingColumn(0);
        dgv.setEditingRow(0);
        dgv.setPreferredSize(new java.awt.Dimension(648, 235));
        dgv.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(dgv);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnharianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnharianActionPerformed
        JasperReport jr;
         JasperPrint jp;
         JasperDesign jd;
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          Date dtp = dtpharian.getDate();
          
         try{
            
             HashMap param = new HashMap();
             param.put("tglreturbeli", sdf.parse(sdf.format(dtp)));

             Connection c = conn.getKoneksi();
             Statement s = c.createStatement();
             String fakturjual = "src/Report/ReturPembelianUmum.jasper";
             File report = new File(fakturjual);
             jr = (JasperReport)JRLoader.loadObject(report);
             jp = JasperFillManager.fillReport(jr, param, c);
             JasperViewer.viewReport(jp,false);
         }catch (ParseException | SQLException | JRException ex) {
            Logger.getLogger(LaporanReturPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
         try{
             SimpleDateFormat sdfinput = new SimpleDateFormat("yyyy-MM-dd");
             Date dtphari = sdf.parse(sdf.format(dtp));
             Timestamp dtptgl = new Timestamp(sdf.parse(sdf.format(dtphari)).getTime());
             Object header[]={"No Faktur","Tanggal Retur","Nomor Beli","Tanggal Beli","Nama Supplier","Contact Person","Jumlah Retur"};
                DefaultTableModel data = new DefaultTableModel(null, header){
                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
            }
        };
                dgv.setModel(data);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            dgv.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
            dgv.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
            dgv.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
            dgv.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
            dgv.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
            dgv.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
            dgv.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
             Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tblsupplier inner join tblpembelian on tblsupplier.kode_supplier=tblpembelian.kode_supplier inner join"
                    + " tblreturpembelian on tblpembelian.faktur_beli=tblreturpembelian.faktur_beli where tblreturpembelian.tgl_retur_beli = ? ";
            PreparedStatement st=c.prepareStatement(sql);
            st.setTimestamp(1, dtptgl);
            ResultSet res = st.executeQuery();
            while(res.next()){
                Date tglbeli = sdfinput.parse(res.getString("tgl_beli"));
                Date tglreturbeli = sdfinput.parse(res.getString("tgl_retur_beli"));
                String kolom1 = res.getString("no_retur_beli");
                String kolom2 = sdf.format(tglreturbeli);
                String kolom3 = res.getString("faktur_beli");
                String kolom4 = sdf.format(tglbeli);
                String kolom5 = res.getString("nama_supplier");
                String kolom6 = res.getString("person_supplier");
                String kolom7 = res.getString("item_retur_beli");

                String kolom[] = {kolom1, kolom2, kolom3, kolom4, kolom5, kolom6, kolom7};
                data.addRow(kolom);
                
    }//GEN-LAST:event_btnharianActionPerformed
    }   catch (SQLException | ParseException ex) {
            Logger.getLogger(LaporanReturPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnperiodikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnperiodikActionPerformed
       JasperReport jr;
         JasperPrint jp;
         JasperDesign jd;
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
             Date tglawal = dtpawal.getDate();
             Date tglakhir = dtpakhir.getDate();
         try{
             
             HashMap param = new HashMap();
             param.put("tglreturbeliawal", sdf.parse(sdf.format(tglawal)));
             param.put("tglreturbeliakhir", sdf.parse(sdf.format(tglakhir)));
             
             Connection c = conn.getKoneksi();
             Statement s = c.createStatement();
             String fakturjual = "src/Report/ReturPembelianUmum.jasper";
             File report = new File(fakturjual);
             jr = (JasperReport)JRLoader.loadObject(report);
             jp = JasperFillManager.fillReport(jr, param, c);
             JasperViewer.viewReport(jp,false);
        } catch (ParseException | SQLException | JRException ex) {
            Logger.getLogger(LaporanReturPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }try{
             SimpleDateFormat sdfinput = new SimpleDateFormat("yyyy-MM-dd");
             Date dtptawal= sdf.parse(sdf.format(tglawal));
             Date dtptakhir = sdf.parse(sdf.format(tglakhir));
             Timestamp dtptglawal = new Timestamp(sdf.parse(sdf.format(dtptawal)).getTime());
             Timestamp dtptglakhir = new Timestamp(sdf.parse(sdf.format(dtptakhir)).getTime());
             Object header[]={"No Faktur","Tanggal Retur","Nomor Beli","Tanggal Beli","Nama Supplier","Contact Person","Jumlah Retur"};
                DefaultTableModel data = new DefaultTableModel(null, header){
                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
            }
        };
                dgv.setModel(data);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            dgv.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
            dgv.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
            dgv.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
            dgv.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
            dgv.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
            dgv.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
            dgv.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
             Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql =  "select * from tblsupplier inner join tblpembelian on tblsupplier.kode_supplier=tblpembelian.kode_supplier inner join"
                    + " tblreturpembelian on tblpembelian.faktur_beli=tblreturpembelian.faktur_beli where tblreturpembelian.tgl_retur_beli between ? and ? ";
            PreparedStatement st=c.prepareStatement(sql);
            st.setTimestamp(1, dtptglawal);
            st.setTimestamp(2, dtptglakhir);
            ResultSet res = st.executeQuery();
           while(res.next()){
                Date tglbeli = sdfinput.parse(res.getString("tgl_beli"));
                Date tglreturbeli = sdfinput.parse(res.getString("tgl_retur_beli"));
                String kolom1 = res.getString("no_retur_beli");
                String kolom2 = sdf.format(tglreturbeli);
                String kolom3 = res.getString("faktur_beli");
                String kolom4 = sdf.format(tglbeli);
                String kolom5 = res.getString("nama_supplier");
                String kolom6 = res.getString("person_supplier");
                String kolom7 = res.getString("item_retur_beli");

                String kolom[] = {kolom1, kolom2, kolom3, kolom4, kolom5, kolom6, kolom7};
                data.addRow(kolom);
    }                                         
    }   catch (SQLException | ParseException ex) {
            Logger.getLogger(LaporanReturPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnperiodikActionPerformed

    private void listfakturValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listfakturValueChanged
          JasperReport jr;
         JasperPrint jp;
         JasperDesign jd;
        try{
             HashMap param = new HashMap();
             param.put("nofakturretur", listfaktur.getSelectedValue());
             
             Connection c = conn.getKoneksi();
             Statement s = c.createStatement();
             String fakturjual = "src/Report/ReturPembelianFaktur.jasper";
             File report = new File(fakturjual);
             jr = (JasperReport)JRLoader.loadObject(report);
             jp = JasperFillManager.fillReport(jr, param, c);
             JasperViewer.viewReport(jp,false);
            
                         
             
        } catch (SQLException | JRException ex) {
            Logger.getLogger(LaporanReturPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }try{
             Object header[]={"Nama Barang","Jumlah Retur","Alasan"};
                DefaultTableModel data = new DefaultTableModel(null, header){
                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
            }
        };
                dgv.setModel(data);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            dgv.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
            dgv.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
            Connection c = conn.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tblpembelian inner join tblsupplier on tblpembelian.kode_supplier = tblsupplier.kode_supplier"
                    + " inner join tblreturpembelian on tblpembelian.faktur_beli = tblreturpembelian.faktur_beli"
                    + " inner join tbldetailreturbeli on tblreturpembelian.no_retur_beli = tbldetailreturbeli.no_retur_beli"
                    + " inner join tblbarang on tbldetailreturbeli.kode_barang = tblbarang.kode_barang where tblreturpembelian.no_retur_beli = '"+listfaktur.getSelectedValue()+"'";
            ResultSet res = s.executeQuery(sql);
            while(res.next()){
                String kolom1 = res.getString("tblbarang.nama_barang");
                String kolom2 = res.getString("tbldetailreturbeli.qty_retur_beli");
                String kolom3 = res.getString("tbldetailreturbeli.alasan_retur_beli");

                String kolom[] = {kolom1, kolom2, kolom3};
                data.addRow(kolom);
                
    }}  catch (SQLException ex) {                   
            Logger.getLogger(LaporanReturPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }listfaktur.setSelectedIndex(listfaktur.getSelectedIndex());
    }//GEN-LAST:event_listfakturValueChanged

    private void listsupplierValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listsupplierValueChanged
         JasperReport jr;
         JasperPrint jp;
         JasperDesign jd;
         
         DefaultTableModel data = new DefaultTableModel();
         dgv.setModel(data);
         dgv.setVisible(false);
        try{
             HashMap param = new HashMap();
             param.put("namasupplier", listsupplier.getSelectedValue());
             
             Connection c = conn.getKoneksi();
             Statement s = c.createStatement();
             String fakturjual = "src/Report/ReturPembelianSupplier.jasper";
             File report = new File(fakturjual);
             jr = (JasperReport)JRLoader.loadObject(report);
             jp = JasperFillManager.fillReport(jr, param, c);
             JasperViewer.viewReport(jp,false);
            
                         
             
        } catch (SQLException | JRException ex) {
            Logger.getLogger(LaporanReturPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listsupplierValueChanged

    private void txtexportKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtexportKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER){
        
        FileWriter fileWriter;
        String userDirLocation = System.getProperty("user.dir");
        File userDir = new File(userDirLocation);
        String excel = userDirLocation + File.separator + "src" + File.separator + "excel";
        File exc = new File(excel);
        JFileChooser chooser = new JFileChooser();
        File file = new File(txtexport.getText());
        
        chooser.setSelectedFile(file);
        chooser.setCurrentDirectory(exc);
        
            try{
                
                TableModel tModel = dgv.getModel();

                fileWriter = new FileWriter(new File(chooser.getCurrentDirectory()+ File.separator + chooser.getSelectedFile()+".xls"));           

            // write header

                for(int i = 0; i < tModel.getColumnCount(); i++){

                fileWriter.write(tModel.getColumnName(i).toUpperCase() + "\t");

            }

                fileWriter.write("\n");

            // write record

                for(int i=0; i < tModel.getRowCount(); i++) {

                for(int j=0; j < tModel.getColumnCount(); j++) {

                fileWriter.write(tModel.getValueAt(i,j).toString() + "\t");

            }

                fileWriter.write("\n");

            }

                fileWriter.close();

            }catch(IOException e){

                JOptionPane.showMessageDialog(null, e);

            }
            
            JOptionPane.showMessageDialog(rootPane, "File Telah di Export ke "+chooser.getCurrentDirectory());
        
        }
    }//GEN-LAST:event_txtexportKeyPressed

    private void btnexportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexportActionPerformed
       try{
        FileWriter fileWriter;
        String userDirLocation = System.getProperty("user.dir");
        File userDir = new File(userDirLocation);
        String excel = userDirLocation + File.separator + "src" + File.separator + "excel";
        File exc = new File(excel);
        JFileChooser chooser = new JFileChooser();
        File file = new File(txtexport.getText());
        
        chooser.setSelectedFile(file);
        chooser.setCurrentDirectory(exc);
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+chooser.getCurrentDirectory()+ File.separator +chooser.getSelectedFile()+".xls");
       } catch (IOException ex) {
            Logger.getLogger(LaporanReturPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnexportActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexport;
    private javax.swing.JButton btnharian;
    private javax.swing.JButton btnperiodik;
    private javax.swing.JTable dgv;
    private com.toedter.calendar.JDateChooser dtpakhir;
    private com.toedter.calendar.JDateChooser dtpawal;
    private com.toedter.calendar.JDateChooser dtpharian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listfaktur;
    private javax.swing.JList<String> listsupplier;
    private javax.swing.JPanel panelharian;
    private javax.swing.JPanel panelharian1;
    private javax.swing.JPanel panelharian3;
    private javax.swing.JPanel panelharian4;
    private javax.swing.JPanel panelharian7;
    private javax.swing.JTextField txtexport;
    // End of variables declaration//GEN-END:variables

}
