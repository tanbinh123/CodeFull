/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps09242_baibaove;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thanh
 */
public class QuanLyMuonSach extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyMuonSach
     */
    public QuanLyMuonSach() {
        initComponents();
        setLocationRelativeTo(null);
        lblState.setText("No record");
    }
    private int dem = 0;
    ArrayList<sach> list = new ArrayList<sach>();
    
    public void newsach(){
        txtMasach.setText("");
        txtTensach.setText("");
        cboTheloai.setSelectedIndex(0);
        buttonGroup1.clearSelection();
    }
    
    public void saveSach(){
        
        sach s = new sach();
        s.setMaSach(txtMasach.getText());
        s.setTenSach(txtTensach.getText());
        
        boolean hinhthuc = false;
        if (rdoTheongay.isSelected()) {
            hinhthuc = true;
        }
        s.setHinhthuc(hinhthuc);
        s.setTheLoai(cboTheloai.getSelectedItem().toString());
        list.add(s);
        
        
    }
    
    public void deleteSach(){
        try {
            int index = list.size();
            list.remove(index);
        } catch (Exception nv) {
            JOptionPane.showMessageDialog(this, "Hãy chọn người mượn");
        }

    }
    
    public void exitSach(){
        try {
            File a = new File("E:\\quanlysach.txt");
            if(!a.exists()){
                a.createNewFile();
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(a));
            oos.writeObject(list);            
            oos.close();
            JOptionPane.showMessageDialog(this, "thành công");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"lỗi");
        }
        System.exit(0);
    }
    
    public void open(){
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("E:\\quanlysach.txt"));
            list = (ArrayList) is.readObject();
            is.close();
            System.out.println(list);
            JOptionPane.showMessageDialog(this, "mở file thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi");
        }
    }
    
    
    public boolean kiemtra(){
        boolean check = true;
        String maSach = txtMasach.getText().trim();
        if (maSach.equals("")) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống");
            txtMasach.setBackground(Color.red);
            check = false;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getMaSach().equals(txtMasach)) {
                    JOptionPane.showMessageDialog(this, "trùng mã sinh viên");
                    txtMasach.setBackground(Color.red);
                } else {
                    txtMasach.setBackground(Color.white);
                }

            }

        }
        
        String hoVaTen = txtTensach.getText();
        try {
            Double so = Double.parseDouble(hoVaTen);
            JOptionPane.showMessageDialog(this, "bạn đã nhập sai định dạng");
            txtTensach.setBackground(Color.red);
            check = false;
        } catch (Exception e) {
            if (hoVaTen.length() == 0) {
                JOptionPane.showMessageDialog(this, "không được để trống họ tên");
                txtTensach.setBackground(Color.red);
                check = false;
            } else {
                txtTensach.setBackground(Color.white);
            }
        }
        
        return false;
    }
    
    public void showRecord(int dem) {

        String show = (dem + 1) + "/" + list.size();
        lblState.setText(show);
    }
    
    public void showdetail() {
        sach sv = list.get(dem);
        txtMasach.setText(sv.getMaSach());
        txtTensach.setText(sv.getTenSach());
        cboTheloai.setSelectedItem(sv.getTheLoai());
        if (sv.isHinhthuc() == true) {
            rdoTheongay.setSelected(true);
        } else {
            rdoTaicho.setSelected(true);
        }
        
    }
    
    public void first() {
        int size = list.size();
        if (size == 0) {
            JOptionPane.showMessageDialog(this, "Dữ liệu trống vui lòng thêm nhân viên");
            return;
        }

        dem = 0;
        showRecord(dem);
        showdetail();

    }

    public void last() {
        int size = list.size();
        if (size == 0) {
            JOptionPane.showMessageDialog(this, "Dữ liệu trống vui lòng thêm nhân viên");
            return;
        }
        if (dem > 0) {

            dem--;
            showRecord(dem);
        }
        showdetail();
    }

    public void next() {
        int size = list.size();
        if (size == 0) {
            JOptionPane.showMessageDialog(this, "Dữ liệu trống vui lòng thêm nhân viên");
            return;
        }
        if (dem < (list.size() - 1)) {

            dem++;
            showRecord(dem);
        }
        showdetail();
    }

    public void pre() {
        int size = list.size();
        if (size == 0) {
            JOptionPane.showMessageDialog(this, "Dữ liệu trống vui lòng thêm nhân viên");
            return;
        }

        dem = list.size() - 1;
        showRecord(dem);
        showdetail();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMasach = new javax.swing.JTextField();
        txtTensach = new javax.swing.JTextField();
        cboTheloai = new javax.swing.JComboBox();
        rdoTheongay = new javax.swing.JRadioButton();
        rdoTaicho = new javax.swing.JRadioButton();
        lblState = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnfirst = new javax.swing.JButton();
        btnlast = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btnpre = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ MƯỢN SÁCH");

        jLabel2.setText("TÊN SÁCH: ");

        jLabel3.setText("MÃ SÁCH: ");

        jLabel4.setText("HÌNH THỨC: ");

        jLabel5.setText("TỔNG SỐ ĐÃ CHO MƯỢN: ");

        jLabel6.setText("THỂ LOẠI: ");

        cboTheloai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SÁCH GIÁO KHOA", "SÁCH THAM KHẢO", "SÁCH HƯỚNG DẪN", "SÁCH TRUYỆN", " " }));

        buttonGroup1.add(rdoTheongay);
        rdoTheongay.setText("THEO NGÀY");

        buttonGroup1.add(rdoTaicho);
        rdoTaicho.setText("TẠI CHỖ");

        lblState.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblState.setForeground(new java.awt.Color(255, 51, 0));
        lblState.setText("1/1");

        lbltotal.setText("TỔNG SỐ SÁCH ĐÃ CHO MƯỢN: ");

        jButton1.setText("OPEN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("DEL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("NEW");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("EXIT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnfirst.setText("|<");
        btnfirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfirstActionPerformed(evt);
            }
        });

        btnlast.setText("<<");
        btnlast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlastActionPerformed(evt);
            }
        });

        btnnext.setText(">>");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        btnpre.setText(">|");
        btnpre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(211, 211, 211)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtMasach))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboTheloai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTensach)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rdoTheongay)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdoTaicho))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addComponent(lbltotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnfirst)
                        .addGap(18, 18, 18)
                        .addComponent(btnlast)
                        .addGap(18, 18, 18)
                        .addComponent(btnnext)
                        .addGap(18, 18, 18)
                        .addComponent(btnpre)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMasach, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTensach, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTheloai, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoTheongay)
                    .addComponent(rdoTaicho)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfirst)
                    .addComponent(btnlast)
                    .addComponent(btnnext)
                    .addComponent(btnpre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbltotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.newsach();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(this.kiemtra()){
            this.saveSach();
        };
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.deleteSach();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.open();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.exitSach();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnfirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfirstActionPerformed
        this.first();
    }//GEN-LAST:event_btnfirstActionPerformed

    private void btnlastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlastActionPerformed
        this.last();
    }//GEN-LAST:event_btnlastActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        this.next();
    }//GEN-LAST:event_btnnextActionPerformed

    private void btnpreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpreActionPerformed
        this.pre();
    }//GEN-LAST:event_btnpreActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyMuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyMuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyMuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyMuonSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyMuonSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnfirst;
    private javax.swing.JButton btnlast;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnpre;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboTheloai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JRadioButton rdoTaicho;
    private javax.swing.JRadioButton rdoTheongay;
    private javax.swing.JTextField txtMasach;
    private javax.swing.JTextField txtTensach;
    // End of variables declaration//GEN-END:variables
}
