/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasi;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLDataException;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
/**
 *
 * @jentari
 */
public class DTDOSEN extends javax.swing.JFrame {
    
    private DefaultTableModel model;
    static ResultSet rs;
    static Statement stmt;    
    dskoneksi dss = new dskoneksi();
    loadIMG img = new loadIMG();
    /**
     * Creates new form fmMHS
     */
    
    public DTDOSEN() {
        initComponents();
        this.TabelDS();
        this.getdata();
        this.btTUTUP.setEnabled(true);
        this.navbar(false);
        this.btBATAL.setVisible(false);
    }

    private void TabelDS(){
        model = new DefaultTableModel();
        tbDS.setModel(model);
        model.addColumn("NIDN");
        model.addColumn("Nama");
        model.addColumn("NO HP");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Tanggal Lahir");
    }
    private void getdata(){
        String sql = "Select NIDN, Nama, NoHP, J_Kelamin, T_Lahir FROM data_dosen;";
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            this.tampildata(sql);
            while(this.rs.next()){
                Object[] obj = new Object[5];
                obj[0] = this.rs.getString("NIDN");
                obj[1] = this.rs.getString("Nama");
                obj[2] = this.rs.getString("NoHP");
                obj[4] = this.rs.getString("T_Lahir");
                String buttonGroup1 = this.rs.getString("J_Kelamin");
                if(buttonGroup1.equals("Laki - Laki")){
                    obj[3] = "Laki-Laki";
                }else{
                    obj[3] = "Perempuan";
                }
                model.addRow(obj);
            }
            stmt.close();
            dss.koneksi().close();
            
            
        }catch(Exception e){
        }         
           
    }
    private void tampildata(String sql){
    try {
        Statement stmt = dss.koneksi().createStatement();
            this.rs = stmt.executeQuery(sql);
        }catch(Exception e){
            System.out.println("SALAH");
        }
    }
    private boolean updatedata(String sql){
    boolean hsl = false;
        try{
            Statement stmt = dss.koneksi().createStatement();
            stmt.executeUpdate(sql);
            hsl = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Terjadi kendala pada instruksi SQL");
        }
        return hsl;
    }
    private void simpandata(){
        String NIDN = this.txNIDN.getText();
        String Nama = this.txNAMA.getText();
        String NoHP = this.txNHP.getText();
        String J_Kelamin = "Perempuan";
        if(this.L.isSelected()){
            J_Kelamin = "Laki - Laki";
        }
        String T_Lahir = this.txTGLLH.getText();
        String sql = "INSERT INTO data_dosen (NIDN, Nama, NoHP, J_Kelamin, T_Lahir) VALUES ('"+NIDN+"','"+Nama+"', '"+NoHP+"', '"+J_Kelamin+"', '"+T_Lahir+"');";
        if (this.updatedata(sql)){
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }
        this.getdata();
        this.btSIMPAN.setEnabled(false);
        this.btBATAL.setVisible(false);
    }
    
    private void updatedataform(){
        String NIDN = this.txNIDN.getText();
        String Nama = this.txNAMA.getText();
        String NoHP = this.txNHP.getText();
        String J_Kelamin = "Perempuan";
        if(this.L.isSelected()){
            J_Kelamin = "Laki - Laki";
        }
        String T_Lahir = this.txTGLLH.getText();
        String sql = "UPDATE data_dosen SET NIDN= '"+NIDN+"', Nama= '"+Nama+"', NoHP= '"+NoHP+"', J_Kelamin= '"+J_Kelamin+"', T_Lahir= '"+T_Lahir+"');";
        if (this.updatedata(sql)){
            JOptionPane.showMessageDialog(null, "Data Dosen"+Nama+" telah diupdate");
        }
        this.getdata();
        this.btSIMPAN.setEnabled(false);
        this.btBATAL.setVisible(false);
    }
    
    private void navbar(Boolean tf){
        this.btSIMPAN.setEnabled(tf);
        this.btUPDATE.setEnabled(tf);
        this.btHAPUS.setEnabled(tf);
        this.btTUTUP.setEnabled(tf);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDS = new javax.swing.JTable();
        lbDS = new javax.swing.JLabel();
        lbEditDT = new javax.swing.JLabel();
        lbNIDN = new javax.swing.JLabel();
        lbNM = new javax.swing.JLabel();
        lbNHP = new javax.swing.JLabel();
        lbJK = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txNIDN = new javax.swing.JTextField();
        txNAMA = new javax.swing.JTextField();
        txNHP = new javax.swing.JTextField();
        L = new javax.swing.JRadioButton();
        P = new javax.swing.JRadioButton();
        txTGLLH = new javax.swing.JTextField();
        btSIMPAN = new javax.swing.JButton();
        btUPDATE = new javax.swing.JButton();
        btHAPUS = new javax.swing.JButton();
        btBATAL = new javax.swing.JButton();
        btTUTUP = new javax.swing.JButton();
        btBARU = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbDS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIDN", "NAMA", "NOMOR HP", "JENIS KELAMIN", "TGL LAHIR"
            }
        ));
        tbDS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDS);

        lbDS.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lbDS.setText("DATA DOSEN");

        lbEditDT.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lbEditDT.setText("EDIT DATA DOSEN");

        lbNIDN.setText("NIDN");

        lbNM.setText("NAMA");

        lbNHP.setText("NO HP");

        lbJK.setText("JENIS KELAMIN");

        jLabel7.setText("TANGGAL LAHIR");

        buttonGroup1.add(L);
        L.setText("Laki - Laki");

        buttonGroup1.add(P);
        P.setText("Perempuan");

        btSIMPAN.setText("Simpan Data");
        btSIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSIMPANActionPerformed(evt);
            }
        });

        btUPDATE.setText("Update Data");
        btUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUPDATEActionPerformed(evt);
            }
        });

        btHAPUS.setText("Hapus Data");
        btHAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHAPUSActionPerformed(evt);
            }
        });

        btBATAL.setText("Batal");
        btBATAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBATALActionPerformed(evt);
            }
        });

        btTUTUP.setText("Tutup Data Dosen");
        btTUTUP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btTUTUPMouseClicked(evt);
            }
        });
        btTUTUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTUTUPActionPerformed(evt);
            }
        });

        btBARU.setText("Data Baru");
        btBARU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBARUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbDS)
                        .addGap(148, 148, 148)
                        .addComponent(btBARU))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSIMPAN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btUPDATE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btHAPUS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(btBATAL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btTUTUP)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbEditDT, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNIDN)
                            .addComponent(lbNM)
                            .addComponent(lbNHP))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txNIDN, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txNAMA)
                            .addComponent(txNHP))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(lbJK)
                                .addGap(6, 6, 6))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(L)
                            .addComponent(P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txTGLLH))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDS)
                    .addComponent(btBARU))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbEditDT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txNIDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNIDN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txNHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbJK)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(L)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(P)
                                .addComponent(lbNM))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbNHP)
                                .addComponent(txTGLLH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSIMPAN)
                    .addComponent(btUPDATE)
                    .addComponent(btHAPUS)
                    .addComponent(btBATAL)
                    .addComponent(btTUTUP))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btTUTUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTUTUPActionPerformed
dispose();   // TODO add your handling code here:
    }//GEN-LAST:event_btTUTUPActionPerformed

    private void btBARUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBARUActionPerformed
    this.btBARU.setEnabled(false);
        this.btUPDATE.setEnabled(false);
        this.btHAPUS.setEnabled(false);
        this.btTUTUP.setEnabled(false);
        this.btSIMPAN.setEnabled(true);
        this.btBATAL.setVisible(true);
        
        this.txNIDN.setText("");
        this.txNAMA.setText("");
        this.txTGLLH.setText("");
        this.txNHP.setText("");
        
        this.lbEditDT.setText("Tambah data Dosen");    // TODO add your handling code here:
    }//GEN-LAST:event_btBARUActionPerformed

    private void btSIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSIMPANActionPerformed
        String NIDN = this.txNIDN.getText();
        String Nama = this.txNAMA.getText();
        String NoHP = this.txNHP.getText();
        String T_Lahir = this.txTGLLH.getText();
        String J_Kelamin = "Laki - Laki";
        if(this.P.isSelected()){
            J_Kelamin = "Perempuan";
        }
        String sqlInsert = "INSERT INTO data_dosen (NIDN, Nama, NoHP, J_Kelamin, T_Lahir) VALUES ('"+NIDN+"','"+Nama+"','"+NoHP+"','"+J_Kelamin+"', '"+T_Lahir+"');";
        if(this.updatedata(sqlInsert)){
            this.getdata();
            JOptionPane.showMessageDialog(null, "Data telah di Tambahkan");
        }
        this.btSIMPAN.setEnabled(false);
        this.btBATAL.setVisible(false);
        this.btTUTUP.setEnabled(true);
        this.btBARU.setEnabled(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btSIMPANActionPerformed

    private void btUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUPDATEActionPerformed
        String NIDN = this.txNIDN.getText();
        String Nama = this.txNAMA.getText();
        String NoHP = this.txNHP.getText();
        String T_Lahir = this.txTGLLH.getText();
        String J_Kelamin = "Laki - Laki";
        if(this.P.isSelected()){
            J_Kelamin = "Perempuan";
        }
        String sqlUpdate = "UPDATE data_dosen SET Nama= '"+Nama+"', N_HP= '"+NoHP+"', J_Kelamin= '"+J_Kelamin+"', T_Lahir= '"+T_Lahir+"' WHERE NIDN= '"+NIDN+"';";
        if(this.updatedata(sqlUpdate)){
            this.getdata();
            JOptionPane.showMessageDialog(null, "Data telah di Update");
        }// TODO add your handling code here:
    }//GEN-LAST:event_btUPDATEActionPerformed

    private void btHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHAPUSActionPerformed
    String NIDN = this.txNIDN.getText();
    String Nama = this.txNAMA.getText();
        
    int opsi = JOptionPane.showConfirmDialog(null,"Data dari "+Nama+"("+NIDN+") akan dihapus, apakah anda yakin?","Konfirmasi", JOptionPane.YES_NO_OPTION );
    if(opsi == JOptionPane.YES_OPTION){
        String sqlDelete = "DELETE FROM data_dosen WHERE NIDN='"+NIDN+"';";
        if(this.updatedata(sqlDelete)){
            this.getdata();
            JOptionPane.showMessageDialog(null, "Data telah dihapus");
            }
        }    // TODO add your handling code here:
    }//GEN-LAST:event_btHAPUSActionPerformed

    private void btBATALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBATALActionPerformed
        this.btTUTUP.setEnabled(true);
        this.btBARU.setEnabled(true);
        this.btSIMPAN.setEnabled(false);
        this.btBATAL.setVisible(false);    // TODO add your handling code here:
    }//GEN-LAST:event_btBATALActionPerformed

    private void tbDSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDSMouseClicked
        this.txNIDN.setText( model.getValueAt(tbDS.getSelectedRow(), 0).toString());
        this.txNAMA.setText( model.getValueAt(tbDS.getSelectedRow(), 1).toString());
        this.txNHP.setText(model.getValueAt(tbDS.getSelectedRow(), 2).toString());
        this.txTGLLH.setText( model.getValueAt(tbDS.getSelectedRow(), 4).toString());
        String buttonGroup1 = model.getValueAt(tbDS.getSelectedRow(), 3).toString();
        if(buttonGroup1.equals("Perempuan")){
            this.P.setSelected(true);
        }else{
        this.L.setSelected(true);
        } 
        this.lbEditDT.setText("Edit Data "+this.txNIDN.getText());
    
        this.btSIMPAN.setEnabled(false);
        this.btUPDATE.setEnabled(true);
        this.btHAPUS.setEnabled(true);  
// TODO add your handling code here:
    }//GEN-LAST:event_tbDSMouseClicked

    private void btTUTUPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTUTUPMouseClicked
       // TODO add your handling code here:
    }//GEN-LAST:event_btTUTUPMouseClicked

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
            java.util.logging.Logger.getLogger(DTDOSEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DTDOSEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DTDOSEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DTDOSEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DTDOSEN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton L;
    private javax.swing.JRadioButton P;
    private javax.swing.JButton btBARU;
    private javax.swing.JButton btBATAL;
    private javax.swing.JButton btHAPUS;
    private javax.swing.JButton btSIMPAN;
    private javax.swing.JButton btTUTUP;
    private javax.swing.JButton btUPDATE;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDS;
    private javax.swing.JLabel lbEditDT;
    private javax.swing.JLabel lbJK;
    private javax.swing.JLabel lbNHP;
    private javax.swing.JLabel lbNIDN;
    private javax.swing.JLabel lbNM;
    private javax.swing.JTable tbDS;
    private javax.swing.JTextField txNAMA;
    private javax.swing.JTextField txNHP;
    private javax.swing.JTextField txNIDN;
    private javax.swing.JTextField txTGLLH;
    // End of variables declaration//GEN-END:variables
}
