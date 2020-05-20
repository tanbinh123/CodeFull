/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinema.controll;

import cinema.QuanLyNhanVien;
import com.cinema.dao.TaiKhoanDAO;
import com.cinema.helper.FileHelper;
import com.cinema.helper.SonOptionPane;
import com.cinema.helper.StringHelper;
import com.cinema.model.TaiKhoan;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author thanh
 */
public class NhanVienControllInsert extends javax.swing.JDialog {

    TaiKhoanDAO dao = new TaiKhoanDAO();
    private QuanLyNhanVien jpanel;
    private String avatar = null;
    private static final String FOLDER_AVATAR = "src\\com\\cinema\\avatar\\";

    public NhanVienControllInsert(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.jpanel = jpanel;
        initComponents();
        setLocationRelativeTo(null);
        rdoNam.setSelected(true);
    }

    TaiKhoan getModel() {
        TaiKhoan tk = new TaiKhoan();
        tk.setMaTaiKhoan(txtMaTaiKhoan.getText());
        tk.setTenDangNhap(txtTenDangNhap.getText());
        tk.setMatKhau(txtMatKhau.getText());
        tk.setHoTen(txtHoTen.getText());
        tk.setGioiTinh(rdoNam.isSelected());
        tk.setSDT(txtSDT.getText());
        tk.setEmail(txtEmail.getText());
        tk.setHinh(avatar);
        tk.setVaiTro(1);
        return tk;
    }

    private void insertNhanVien() {
        TaiKhoan tk = getModel();
        try {
            dao.insert(tk);
            this.dispose();
            this.jpanel.fillToTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private boolean check(){
        boolean kiemTra = false;
        String maTaiKhoan = txtMaTaiKhoan.getText();
        String tenDangNhap = txtTenDangNhap.getText();
        String matKhau = txtMatKhau.getText();
        String hoTen = txtHoTen.getText();
        String sdt = txtSDT.getText();
        String email = txtEmail.getText();
        String regexInt = "^\\d+";
        String regexEmail = "^\\w+[a-z0-9]*@{1}\\w+mail.com$";
        
        if(maTaiKhoan.isEmpty() || tenDangNhap.isEmpty() || matKhau.isEmpty() || hoTen.isEmpty() || sdt.isEmpty() || email.isEmpty()){
            SonOptionPane.showMessage(super.getParent(), "KHÔNG ĐƯỢC ĐỂ TRỐNG!", SonOptionPane.WARNING);
            kiemTra = false;
        }else if(!sdt.matches(regexInt)){
            SonOptionPane.showMessage(super.getParent(), "SỐ ĐIỆN THOẠI CHỈ ĐƯỢC NHẬP SỐ!", SonOptionPane.INFO);
            txtSDT.setText("");
            txtSDT.requestFocus();
            kiemTra = false;
        }else if(sdt.trim().length() > 10){
            SonOptionPane.showMessage(super.getParent(), "SỐ ĐIỆN THOẠI KHÔNG QUÁ 10 SỐ!", SonOptionPane.INFO);
            txtSDT.setText("");
            txtSDT.requestFocus();
            kiemTra = false;
        }else if(sdt.trim().length() < 10){
            SonOptionPane.showMessage(super.getParent(), "SỐ ĐIỆN THOẠI PHẢI ĐỦ 10 SỐ!", SonOptionPane.INFO);
            txtSDT.setText("");
            txtSDT.requestFocus();
            kiemTra = false;
        }else if(!email.matches(regexEmail)){
            SonOptionPane.showMessage(super.getParent(), "VUI LÒNG NHẬP ĐÚNG ĐỊNH DẠNG MAIL!", SonOptionPane.INFO);
            txtEmail.setText("");
            txtEmail.requestFocus();
            kiemTra = false;
        }else{
            kiemTra = true;
        }
        return kiemTra;
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
        jTextField6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        txtMaTaiKhoan = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        txtHoTen = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnKhong1 = new keeptoo.KButton();
        btnKhong2 = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 204, 51)));

        lblHinh.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHinhMouseEntered(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Mã tài khoản: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Tên đăng nhập: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Mật khẩu: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Họ tên: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Giới tính: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Số điện thoại: ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Email:");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");
        rdoNam.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        rdoNu.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        btnKhong1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnKhong1.setText("THOÁT");
        btnKhong1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnKhong1.setkBackGroundColor(new java.awt.Color(153, 153, 153));
        btnKhong1.setkEndColor(new java.awt.Color(102, 102, 102));
        btnKhong1.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        btnKhong1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnKhong1.setkHoverStartColor(new java.awt.Color(102, 102, 102));
        btnKhong1.setkSelectedColor(new java.awt.Color(102, 102, 102));
        btnKhong1.setkStartColor(new java.awt.Color(204, 204, 204));
        btnKhong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhong1ActionPerformed(evt);
            }
        });

        btnKhong2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnKhong2.setText("THÊM");
        btnKhong2.setToolTipText("");
        btnKhong2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnKhong2.setkBackGroundColor(new java.awt.Color(153, 153, 153));
        btnKhong2.setkEndColor(new java.awt.Color(102, 102, 102));
        btnKhong2.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        btnKhong2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnKhong2.setkHoverStartColor(new java.awt.Color(102, 102, 102));
        btnKhong2.setkSelectedColor(new java.awt.Color(102, 102, 102));
        btnKhong2.setkStartColor(new java.awt.Color(204, 204, 204));
        btnKhong2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhong2ActionPerformed(evt);
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
                        .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenDangNhap))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaTaiKhoan))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMatKhau))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNu)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnKhong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKhong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKhong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKhong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhong1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKhong1ActionPerformed

    private void btnKhong2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhong2ActionPerformed
        if(this.check()){
            this.insertNhanVien();
        }
    }//GEN-LAST:event_btnKhong2ActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        JFileChooser jfc = new JFileChooser("C:\\Users\\thanh\\Pictures");
        int chooser = jfc.showOpenDialog(null);
        if (chooser == JFileChooser.APPROVE_OPTION) {
            String fullPath = jfc.getSelectedFile().getAbsolutePath();
            String extension = fullPath.substring(fullPath.lastIndexOf(".") - 1);
            try {
                avatar = FileHelper.copyFileUsingStream(jfc.getSelectedFile(), new File(FOLDER_AVATAR + StringHelper.randomAlphaNumeric(10) + extension));
                System.out.println(avatar);
                showAvatar();
                JOptionPane.showMessageDialog(this, "Thêm ảnh thành công");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi");
            }
        }
    }//GEN-LAST:event_lblHinhMouseClicked

    private void lblHinhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblHinhMouseEntered

    private void showAvatar() {
        if (avatar != null) {
            lblHinh.setIcon(new ImageIcon(new ImageIcon(FOLDER_AVATAR + avatar).getImage().getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), Image.SCALE_SMOOTH)));
        }
    }

    public QuanLyNhanVien getJpanel() {
        return jpanel;
    }

    public void setJpanel(QuanLyNhanVien jpanel) {
        this.jpanel = jpanel;
    }

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
            java.util.logging.Logger.getLogger(NhanVienControllInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienControllInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienControllInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienControllInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanVienControllInsert dialog = new NhanVienControllInsert(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton btnKhong1;
    private keeptoo.KButton btnKhong2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaTaiKhoan;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
