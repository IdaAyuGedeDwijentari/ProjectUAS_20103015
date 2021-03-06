/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasi;
import static aplikasi.fmMHS.stmt;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLDataException;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
/**
 *
 * @author asus
 */
public class fmMTK extends javax.swing.JFrame {
    private DefaultTableModel model;
    static ResultSet rs;
    static Statement stmt;    
    mtkoneksi cnn = new mtkoneksi();
    loadIMG img = new loadIMG();

    /**
     * Creates new form fmMTK
     */
    public fmMTK() {
        initComponents();
        this.initTable();
        this.getdata();
        this.btTUTUP.setEnabled(true);
        this.navbar(false);
        this.btBATAL.setVisible(false);
    }
    
    private void initTable(){
        model = new DefaultTableModel();
        tbMTK.setModel(model);
        model.addColumn("Kode Matakuliah");
        model.addColumn("Nama Matakuliah");
        model.addColumn("Jumlah Matakuliah");
        model.addColumn("SKS");
        model.addColumn("Wajib/Tidak Wajib");
    }
    
    private void getdata(){
        String sql = "Select kd_m, nm_m, j_kls, sks, j_m FROM matakuliah;";
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            this.tampildata(sql);
            while(this.rs.next()){
                Object[] obj = new Object[5];
                obj[0] = this.rs.getString("kd_m");
                obj[1] = this.rs.getString("nm_m");
                obj[2] = this.rs.getString("j_kls");
                obj[3] = this.rs.getString("sks");
                String buttonGroup1 = this.rs.getString("j_m");
                if(buttonGroup1.equals("Wajib")){
                    obj[4] = "Wajib";
                }else{
                    obj[4] = "Tidak Wajib";
                }
                model.addRow(obj);
            }
            stmt.close();
            cnn.koneksi().close();
            }catch(Exception e){
        }         
    }
    
    private void tampildata(String sql){
    try {
        Statement stmt = cnn.koneksi().createStatement();
            this.rs = stmt.executeQuery(sql);
        }catch(Exception e){
            System.out.println("SALAH");
        }
    }
    
    private boolean updatedata(String sql){
        boolean hsl = false;
        try{
            Statement stmt = cnn.koneksi().createStatement();
            stmt.executeUpdate(sql);
            hsl = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Terjadi kendala pada instruksi SQL");
        }
        return hsl;
    }
    
    private void simpandata(){
        String kd_m = this.kdMK.getText();
        String nm_m = this.nmMK.getText();
        String j_kls = this.txJKLS.getText();
        String sks = this.txSKS.getSelectedItem().toString();
        String j_m = "Wajib";
            if(this.TW.isSelected()){
                j_m = "Tidak Wajib";
            }
        String sql = "INSERT INTO matakuliah (kd_m, nm_m, j_kls, sks, j_m) VALUES ('"+kd_m+"','"+nm_m+"', '"+j_kls+"', '"+sks+"', '"+j_m+"');";
        if (this.updatedata(sql)){
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }
        this.getdata();
        this.btSIMPAN.setEnabled(false);
        this.btBATAL.setVisible(false);
    }
    
    private void updatedataform(){
        String kd_m = this.kdMK.getText();
        String nm_m = this.nmMK.getText();
        String j_kls = this.txJKLS.getText();
        String sks = this.txSKS.getSelectedItem().toString();
        String j_m = "Wajib";
        if(this.TW.isSelected()){
            j_m = "Tidak Wajib";
        }
        String sql = "UPDATE matakuliah SET kd_m= '"+kd_m+"', nm_m= '"+nm_m+"', j_kls= '"+j_kls+"', sks= '"+sks+"', j_m= '"+j_m+"');";
        if (this.updatedata(sql)){
            JOptionPane.showMessageDialog(null, "Data Matakuliah "+nm_m+" telah diupdate");
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
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lbSKS = new javax.swing.JLabel();
        btBATAL = new javax.swing.JButton();
        lbJTW = new javax.swing.JLabel();
        btTUTUP = new javax.swing.JButton();
        kdMK = new javax.swing.JTextField();
        btBARU = new javax.swing.JButton();
        nmMK = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMTK = new javax.swing.JTable();
        txJKLS = new javax.swing.JTextField();
        W = new javax.swing.JRadioButton();
        lbDMTK = new javax.swing.JLabel();
        TW = new javax.swing.JRadioButton();
        lbEditMTK = new javax.swing.JLabel();
        lbKD = new javax.swing.JLabel();
        btSIMPAN = new javax.swing.JButton();
        lbNMK = new javax.swing.JLabel();
        btUPDATE = new javax.swing.JButton();
        lbJKLS = new javax.swing.JLabel();
        btHAPUS = new javax.swing.JButton();
        txSKS = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbSKS.setText("SKS");

        btBATAL.setText("Batal");
        btBATAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBATALActionPerformed(evt);
            }
        });

        lbJTW.setText("Wajib/Tidak Wajib");

        btTUTUP.setText("Tutup Data Matakuliah");
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

        tbMTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Matakuliah", "Nama Matakuliah", "Jumlah Kelas", "SKS", "Wajib/Tidak Wajib"
            }
        ));
        tbMTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMTKMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMTK);

        buttonGroup1.add(W);
        W.setText("Wajib");

        lbDMTK.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lbDMTK.setText("DATA MATAKULIAH");

        buttonGroup1.add(TW);
        TW.setText("Tidak Wajib");

        lbEditMTK.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lbEditMTK.setText("EDIT DATA MATAKULIAH");

        lbKD.setText("Kode Matkuliah");

        btSIMPAN.setText("Simpan Data");
        btSIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSIMPANActionPerformed(evt);
            }
        });

        lbNMK.setText("Nama Matakuliah");

        btUPDATE.setText("Update Data");
        btUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUPDATEActionPerformed(evt);
            }
        });

        lbJKLS.setText("Jumlah Kelas");

        btHAPUS.setText("Hapus Data");
        btHAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHAPUSActionPerformed(evt);
            }
        });

        txSKS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4" }));
        txSKS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSKSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbEditMTK, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lbKD)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbJKLS)
                                    .addComponent(lbNMK))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kdMK, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(nmMK)
                            .addComponent(txJKLS))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(lbSKS)
                                .addGap(6, 6, 6))
                            .addComponent(lbJTW, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TW)
                            .addComponent(W)
                            .addComponent(txSKS, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbDMTK)
                                .addGap(104, 104, 104)
                                .addComponent(btBARU))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btSIMPAN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btUPDATE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btHAPUS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btBATAL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btTUTUP)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDMTK)
                    .addComponent(btBARU))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbEditMTK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kdMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbKD))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nmMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNMK))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txJKLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbJKLS)))
                            .addComponent(lbSKS)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(txSKS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(W)
                            .addComponent(lbJTW))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TW)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
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

    private void btBATALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBATALActionPerformed
        this.btTUTUP.setEnabled(true);
        this.btBARU.setEnabled(true);
        this.btSIMPAN.setEnabled(false);
        this.btBATAL.setVisible(false);    // TODO add your handling code here:
    }//GEN-LAST:event_btBATALActionPerformed

    private void btTUTUPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTUTUPMouseClicked
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btTUTUPMouseClicked

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

        this.kdMK.setText("");
        this.nmMK.setText("");
        this.txJKLS.setText("");

        this.lbEditMTK.setText("Tambah data Matakuliah");    // TODO add your handling code here:
    }//GEN-LAST:event_btBARUActionPerformed

    private void tbMTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMTKMouseClicked
        this.kdMK.setText( model.getValueAt(tbMTK.getSelectedRow(), 0).toString());
        this.nmMK.setText( model.getValueAt(tbMTK.getSelectedRow(), 1).toString());
        this.txJKLS.setText(model.getValueAt(tbMTK.getSelectedRow(), 2).toString());
        this.txSKS.setSelectedItem(model.getValueAt(tbMTK.getSelectedRow(), 3).toString());
        String buttonGroup1 = model.getValueAt(tbMTK.getSelectedRow(), 4).toString();
        if(buttonGroup1.equals("Tidak Wajib")){
            this.TW.setSelected(true);
        }else{
            this.W.setSelected(true);
        }
        this.lbEditMTK.setText("Edit Data "+this.kdMK.getText());

        this.btSIMPAN.setEnabled(false);
        this.btUPDATE.setEnabled(true);
        this.btHAPUS.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbMTKMouseClicked

    private void btSIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSIMPANActionPerformed
        String kd_m = this.kdMK.getText();
        String nm_m = this.nmMK.getText();
        String j_kls = this.txJKLS.getText();
        String sks = this.txSKS.getSelectedItem().toString();
        String j_m = "Wajib";
        if(this.TW.isSelected()){
            j_m = "Tidak Wajib";
        }
        String sqlInsert = "INSERT INTO matakuliah (kd_m, nm_m, j_kls, sks, j_m) VALUES ('"+kd_m+"','"+nm_m+"', '"+j_kls+"', '"+sks+"', '"+j_m+"');";
        if(this.updatedata(sqlInsert)){
            this.getdata();
            JOptionPane.showMessageDialog(null, "Data telah di Tambahkan");
        }
        this.btSIMPAN.setEnabled(false);
        this.btBATAL.setVisible(false);
        this.btTUTUP.setEnabled(true);
        this.btBARU.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btSIMPANActionPerformed

    private void btUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUPDATEActionPerformed
        String kd_m = this.kdMK.getText();
        String nm_m = this.nmMK.getText();
        String j_kls = this.txJKLS.getText();
        String sks = this.txSKS.getSelectedItem().toString();
        String j_m = "Wajib";
        if(this.TW.isSelected()){
            j_m = "Tidak Wajib";
        }
        String sqlUpdate = "UPDATE matakuliah SET kd_m= '"+kd_m+"', nm_m= '"+nm_m+"', j_kls= '"+j_kls+"', sks= '"+sks+"', j_m= '"+j_m+"');";
        if(this.updatedata(sqlUpdate)){
            this.getdata();
            JOptionPane.showMessageDialog(null, "Data telah di Update");
        }// TODO add your handling code here:
    }//GEN-LAST:event_btUPDATEActionPerformed

    private void btHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHAPUSActionPerformed
        String kd_m = this.kdMK.getText();
        String nm_m = this.nmMK.getText();

        int opsi = JOptionPane.showConfirmDialog(null,"Data dari "+nm_m+"("+kd_m+") akan dihapus, apakah anda yakin?","Konfirmasi", JOptionPane.YES_NO_OPTION );
        if(opsi == JOptionPane.YES_OPTION){
            String sqlDelete = "DELETE FROM matakuliah WHERE kd_m ='"+kd_m+"';";
            if(this.updatedata(sqlDelete)){
                this.getdata();
                JOptionPane.showMessageDialog(null, "Data telah dihapus");
            }
        }    // TODO add your handling code here:
    }//GEN-LAST:event_btHAPUSActionPerformed

    private void txSKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSKSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSKSActionPerformed

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
            java.util.logging.Logger.getLogger(fmMTK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmMTK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmMTK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmMTK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fmMTK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton TW;
    private javax.swing.JRadioButton W;
    private javax.swing.JButton btBARU;
    private javax.swing.JButton btBATAL;
    private javax.swing.JButton btHAPUS;
    private javax.swing.JButton btSIMPAN;
    private javax.swing.JButton btTUTUP;
    private javax.swing.JButton btUPDATE;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kdMK;
    private javax.swing.JLabel lbDMTK;
    private javax.swing.JLabel lbEditMTK;
    private javax.swing.JLabel lbJKLS;
    private javax.swing.JLabel lbJTW;
    private javax.swing.JLabel lbKD;
    private javax.swing.JLabel lbNMK;
    private javax.swing.JLabel lbSKS;
    private javax.swing.JTextField nmMK;
    private javax.swing.JTable tbMTK;
    private javax.swing.JTextField txJKLS;
    private javax.swing.JComboBox<String> txSKS;
    // End of variables declaration//GEN-END:variables
}
