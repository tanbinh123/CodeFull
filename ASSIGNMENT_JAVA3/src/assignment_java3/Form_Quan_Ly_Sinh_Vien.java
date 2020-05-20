/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_java3;

import Student.Student;
import java.awt.Color;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thanh
 */
public class Form_Quan_Ly_Sinh_Vien extends javax.swing.JFrame {

    /**
     * Creates new form Form_Giao_Vien
     */
    //Create Connection String
    String user = "sa";
    String pass = "songlong";
    String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=ASSIGNMENT_JAVA";

    //Create ArrayList Student
    ArrayList<Student> list = new ArrayList<Student>();

    public Form_Quan_Ly_Sinh_Vien() {
        initComponents();
        setLocationRelativeTo(null);
        this.fillToTable();
    }

    public void LoadData() {
        try {
            list.clear();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();
            String sql = "select STUDENT.*,GRADE.TiengAnh,GRADE.TinHoc,GRADE.GDTC,((GRADE.Tienganh+GRADE.Tinhoc+GRADE.GDTC)/3)as diemtb from STUDENT,GRADE  where STUDENT.MASV = GRADE.MASV";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                list.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getFloat(8), rs.getFloat(9), rs.getFloat(10), rs.getFloat(11)));
            }
            con.close();
            stm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void fillToTable() {
        LoadData();
        DefaultTableModel model = (DefaultTableModel) tblsinhvien.getModel();
        model.setRowCount(0);

        for (Student st : list) {
            Object[] row = new Object[]{st.getMaSinhVien(), st.getTenSinhVien(), st.getEmail(), st.getSDT(), st.isGioiTinh(), st.getDiaChi(), st.getHinh()};
            if(st.isGioiTinh()==true){
            }
            model.addRow(row);
        }
        
    }

//Bắt lỗi
    public boolean validateData() {
        // tất cả không được bỏ trống
        String maSv = txtmasinhvien.getText().trim();
        String hoTen = txthoten.getText().trim();
        String email = txtemail.getText().trim();
        String dienThoai = txtsodt.getText().trim();
        String diaChi = txtdiachi.getText().trim();

        try {
                for (int i = 0; i < list.size(); i++) {

                    if (list.get(i).getMaSinhVien().equals(maSv)) {
                        JOptionPane.showMessageDialog(this, "Trùng mã nhân viên");
                        return false;
                    } 
                }
                Student nv = new Student();

            } catch (Exception e) {
                Logger.getLogger(Form_Quan_Ly_Sinh_Vien.class.getName()).log(Level.SEVERE, null, e);
            }
//        for (int i = 0; i < list.size(); i++) {
//
//            if (list.get(i).getMaSinhVien().equals(maSv)) {
//                JOptionPane.showMessageDialog(this, "Trùng mã nhân viên");
//
//                return false;
//            }
//        }

        if (maSv.equals("") || maSv.equals("") || maSv.equals("") || maSv.equals("") || maSv.equals("") || diaChi.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            return false;
        }
        // họ tên chỉ bằng chữ
        if (!hoTen.matches("^\\D+$")) {
            JOptionPane.showMessageDialog(this, "Họ Tên không chứa số");
            return false;
        }
        if (!email.matches("^[a-z][a-z0-9_\\.]{2,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")) {
            JOptionPane.showMessageDialog(this, "Định dạng email không hợp lệ");
            return false;
        }
        // sdt phải bằng 10 kí tự
        if (!dienThoai.matches("\\d{10,}")) {
            JOptionPane.showMessageDialog(this, "Số diện thoại phải là số và bằng 10 kí tự");
            return false;
        }

        return true;

    }

    //save Student
    public void Save() {

        try {
            Student st = new Student();
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement az = con.prepareStatement("INSERT INTO [dbo].[GRADE]\n"
                    + "           ([MASV]\n"
                    + "           ,[Tienganh]\n"
                    + "           ,[Tinhoc]\n"
                    + "           ,[GDTC])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,null\n"
                    + "           ,null\n"
                    + "           ,null)");

            PreparedStatement a2 = con.prepareStatement("INSERT INTO [dbo].[STUDENT]\n"
                    + "           ([MASV]\n"
                    + "           ,[Hoten]\n"
                    + "           ,[Email]\n"
                    + "           ,[SoDT]\n"
                    + "           ,[Gioitinh]\n"
                    + "           ,[Diachi]\n"
                    + "           ,[Hinh])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,N'AvatarImg\\user.png')");
            System.out.println("so1");
            az.setString(1, txtmasinhvien.getText());
            a2.setString(1, txtmasinhvien.getText());
            a2.setString(2, txthoten.getText());
            a2.setString(3, txtemail.getText());
            a2.setString(4, txtsodt.getText());

            if (rdonam.isSelected()) {
                a2.setBoolean(5, true);
                System.out.println("so3");
            } else {
                a2.setBoolean(5, false);

            }
            a2.setString(6, txtdiachi.getText());
            a2.executeUpdate();
            az.executeQuery();
            LoadData();
            list.add(st);
            this.fillToTable();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //delete Student
    public void delete(int i) {
        try {
            String index = String.valueOf(tblsinhvien.getValueAt(i, 0));
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement a1 = con.prepareStatement("delete from GRADE where MASV=?");
            PreparedStatement a2 = con.prepareStatement("delete from STUDENT where MASV=?");
            a1.setString(1, index);
            a2.setString(1, index);
            a1.executeUpdate();
            a2.executeUpdate();
            list.remove(i);
            fillToTable();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void update() {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            int index = tblsinhvien.getSelectedRow();
            Student st = list.get(index);
            PreparedStatement a1 = con.prepareStatement("update STUDENT set Hoten = ?,Email = ?,SoDT =?, Gioitinh =?, Diachi =?, Hinh =null where MASV=?");
            a1.setString(1, txthoten.getText());
            a1.setString(2, txtemail.getText());
            a1.setString(3, txtsodt.getText());
            a1.setBoolean(4, rdonam.isSelected());
            a1.setString(5, txtdiachi.getText());
            a1.setString(6, st.getMaSinhVien());

            a1.executeUpdate();
            LoadData();
            fillToTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hãy chọn sinh viên");
        }

    }

    public void showDetail() {
        int index = tblsinhvien.getSelectedRow();
        Student st = list.get(index);
        txtmasinhvien.setText(st.getMaSinhVien());
        txthoten.setText(st.getTenSinhVien());
        txtemail.setText(st.getEmail());
        txtsodt.setText(String.valueOf(st.getSDT()));
        txtdiachi.setText(st.getDiaChi());
        boolean gioiTinh = st.isGioiTinh();
        if (gioiTinh) {
            rdonam.setSelected(true);
        } else {
            rdonu.setSelected(true);
        }
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement sta = con.createStatement();
            ResultSet re = sta.executeQuery("select hinh from STUDENT where MASV='" + tblsinhvien.getValueAt(index, 0) + "'");
            String link = "AvatarImg\\user.png";
            while (re.next()) {
                link = re.getString(1);

            }
            ImageIcon ii = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(lblhinh.getWidth(), lblhinh.getHeight(), Image.SCALE_SMOOTH));
            lblhinh.setIcon(ii);
        } catch (Exception e) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtmasinhvien = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txthoten = new javax.swing.JTextField();
        txtsodt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblhinh = new javax.swing.JLabel();
        rdonam = new javax.swing.JRadioButton();
        rdonu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdiachi = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblsinhvien = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Sinh Viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Mã sinh viên:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Email: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Số ĐT: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Giới tính: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Địa chỉ: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Họ tên: ");

        txtsodt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsodtActionPerformed(evt);
            }
        });

        lblhinh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblhinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(lblhinh, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblhinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        buttonGroup1.add(rdonam);
        rdonam.setSelected(true);
        rdonam.setText("Nam");

        buttonGroup1.add(rdonu);
        rdonu.setText("Nữ");

        txtdiachi.setColumns(20);
        txtdiachi.setRows(5);
        jScrollPane1.setViewportView(txtdiachi);

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\thanh\\Documents\\NetBeansProjects\\ASSIGNMENT_JAVA3\\src\\Image\\iconnew.png")); // NOI18N
        jButton1.setText("NEW ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\thanh\\Documents\\NetBeansProjects\\ASSIGNMENT_JAVA3\\src\\Image\\iconsave.jpg")); // NOI18N
        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\thanh\\Documents\\NetBeansProjects\\ASSIGNMENT_JAVA3\\src\\Image\\icondelete.png")); // NOI18N
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\thanh\\Documents\\NetBeansProjects\\ASSIGNMENT_JAVA3\\src\\Image\\iconUpdate.png")); // NOI18N
        jButton4.setText("UPDATE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tblsinhvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã SV", "Họ Tên", "Email", "Số ĐT", "Giới tính", "Địa chỉ"
            }
        ));
        tblsinhvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsinhvienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblsinhvien);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtsodt, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmasinhvien, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdonam)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdonu))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(0, 66, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtmasinhvien)
                                .addGap(2, 2, 2)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsodt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdonam)
                            .addComponent(rdonu))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsodtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsodtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsodtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        txtmasinhvien.setText("");
        txthoten.setText("");
        txtemail.setText("");
        txtsodt.setText("");
        txtsodt.setText("");
        txtdiachi.setText("");
        buttonGroup1.clearSelection();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int i = tblsinhvien.getSelectedRow();
        if (i != -1) {
            this.delete(i);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (validateData()) {
            this.Save();
            this.fillToTable();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.update();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tblsinhvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsinhvienMouseClicked
        this.showDetail();

    }//GEN-LAST:event_tblsinhvienMouseClicked

    private void lblhinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhinhMouseClicked
        int in = tblsinhvien.getSelectedRow();
        if (in != -1) {
            JFileChooser jfc = new JFileChooser();
            int cv = jfc.showOpenDialog(null);
            if (cv == 0) {
                File f = jfc.getSelectedFile();
                String filename = f.getAbsolutePath();
                ImageIcon ii = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblhinh.getWidth(), lblhinh.getHeight(), Image.SCALE_SMOOTH));
                lblhinh.setIcon(ii);
                try {
                    FileInputStream fis = new FileInputStream(filename);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] im = new byte[1024];
                    for (int Num; (Num = fis.read(im)) != -1;) {
                        bos.write(im, 0, Num);
                    }
                    int index = tblsinhvien.getSelectedRow();
                    if (index != -1) {
                        File img = new File("AvatarImg\\" + (String) tblsinhvien.getValueAt(index, 0) + ".jpg");
                        if (!img.exists()) {
                            img.createNewFile();
                        }
                        FileOutputStream imz = new FileOutputStream(img);
                        imz.write(bos.toByteArray());
                        Connection con = DriverManager.getConnection(url, user, pass);
                        PreparedStatement pr = con.prepareStatement("update STUDENT set hinh = ? where MASV=?");
                        pr.setString(1, "AvatarImg\\" + (String) tblsinhvien.getValueAt(index, 0) + ".jpg");
                        pr.setString(2, (String) tblsinhvien.getValueAt(index, 0));
                        pr.executeUpdate();
                        fillToTable();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

    }//GEN-LAST:event_lblhinhMouseClicked

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
            java.util.logging.Logger.getLogger(Form_Quan_Ly_Sinh_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Quan_Ly_Sinh_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Quan_Ly_Sinh_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Quan_Ly_Sinh_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Quan_Ly_Sinh_Vien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel lblhinh;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JRadioButton rdonu;
    private javax.swing.JTable tblsinhvien;
    private javax.swing.JTextArea txtdiachi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtmasinhvien;
    private javax.swing.JTextField txtsodt;
    // End of variables declaration//GEN-END:variables
}
