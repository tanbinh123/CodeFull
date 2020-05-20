/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_java3;

import Student.Student;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thanh
 */
public class Form_Quan_Ly_Diem extends javax.swing.JFrame {

    //Create Connection String
    String user = "sa";
    String pass = "songlong";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=ASSIGNMENT_JAVA";
    int current = 0;

    //Create ArrayList for Student
    ArrayList<Student> list = new ArrayList<Student>();

    public Form_Quan_Ly_Diem() {
        initComponents();
        setLocationRelativeTo(null);
        loadData();
        filltotable();
        Display(current);
    }

    public void loadData() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, user, pass);

            String sql = "select STUDENT.*,GRADE.TiengAnh,GRADE.TinHoc,GRADE.GDTC,((GRADE.Tienganh+GRADE.Tinhoc+GRADE.GDTC)/3)as diemtb from STUDENT,GRADE  where STUDENT.MASV = GRADE.MASV";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            list.clear();
            while (rs.next()) {
                list.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getFloat(8), rs.getFloat(9), rs.getFloat(10), rs.getFloat(11)));
            }
            rs.close();
            stm.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void Display(int i) {
        Student st = list.get(i);
        lblhoten.setText(st.getTenSinhVien());
        txtmasinhVien.setText(st.getMaSinhVien());
        txttienganh.setText(String.valueOf(st.getTiengAnh()));
        txttinhoc.setText(String.valueOf(st.getTinHoc()));
        txtgiaoductc.setText(String.valueOf(st.getGiaoDucTC()));
        lbldiemtb.setText(String.valueOf(st.getDiemTrungBinh()));

    }

    public void filltotable() {
        DefaultTableModel model = (DefaultTableModel) tblSinhvien.getModel();
        model.setRowCount(0);

        for (Student st : list) {
            Object[] row = {st.getMaSinhVien(), st.getTenSinhVien(), st.getTiengAnh(), st.getTinHoc(), st.getGiaoDucTC(), st.getDiemTrungBinh()};
            model.addRow(row);
        }
    }

    public void Save() {
        Student st = new Student();
        st.setMaSinhVien(txtmasinhVien.getText());
        //st.setTenSinhVien(user);
        st.setTenSinhVien(txttienganh.getText());

    }

    public boolean kiemTra() {
        boolean check = true;

        String maSV = txtmasinhVien.getText().trim();
        String tiengAnh = txttienganh.getText().trim();

        if (maSV.length() == 0) {
            JOptionPane.showMessageDialog(this, "Hãy nhập mã sinh viên", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else if (tiengAnh.length() == 0) {
            JOptionPane.showMessageDialog(this, "Hãy nhập điểm", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }

        return check;
    }

    public void showDetail() {
        int index = tblSinhvien.getSelectedRow();
        Student st = list.get(index);

        String maSinhVien = st.getMaSinhVien();
        txtmasinhVien.setText(maSinhVien);

        String tiengAnh = String.valueOf(st.getTiengAnh());
        txttienganh.setText(tiengAnh);

        String tinHoc = String.valueOf(st.getTiengAnh());
        txttinhoc.setText(tinHoc);

        String GDTC = String.valueOf(st.getGiaoDucTC());
        txtgiaoductc.setText(GDTC);

        lbldiemtb.setText(String.valueOf(list.get(index).getDiemTrungBinh()));
        lblhoten.setText(list.get(index).getTenSinhVien());

    }

    public void delete(int i) {
        try {
            String index = String.valueOf(tblSinhvien.getValueAt(i, 0));
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement a1 = con.prepareStatement("delete from GRADE where MASV=?");
            PreparedStatement a2 = con.prepareStatement("delete from STUDENT where MASV=?");
            a1.setString(1, index);
            a2.setString(1, index);
            a1.executeUpdate();
            a2.executeUpdate();
            list.remove(i);
            filltotable();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void update() {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            String maSV = txtmasinhVien.getText();
            String sql = "update GRADE set  Tienganh =?, Tinhoc = ?, GDTC =? where MASV =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, Float.valueOf(txttienganh.getText()));
            ps.setFloat(2, Float.valueOf(txttinhoc.getText()));

            ps.setFloat(3, Float.valueOf(txtgiaoductc.getText()));
            ps.setString(4, maSV);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void SearchST(String a) {
        DefaultTableModel o = (DefaultTableModel) tblSinhvien.getModel();
        o.setRowCount(0);
        for (Student i : list) {
            System.out.println(a);
            System.out.println(i.getMaSinhVien());
            System.out.println(a.contains(i.getMaSinhVien()));
            if (i.getMaSinhVien().contains(a)) {

                Object[] row = new Object[]{i.getMaSinhVien(), i.getTenSinhVien(), i.getTiengAnh(), i.getTinHoc(), i.getGiaoDucTC(), i.getDiemTrungBinh()};
                o.addRow(row);

            }
        }
    }

    private void autoScroll(int index) {
        tblSinhvien.scrollRectToVisible(new Rectangle(tblSinhvien.getCellRect(index, 0, true)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txttimkiem = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblhoten = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtmasinhVien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txttienganh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txttinhoc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtgiaoductc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lbldiemtb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSinhvien = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ ĐIỂM SINH VIÊN");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 17))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel2.setText("Mã Sinh Viên: ");

        txttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemActionPerformed(evt);
            }
        });
        txttimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttimkiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttimkiem)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel3.setText("Họ Và Tên: ");

        lblhoten.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblhoten.setForeground(new java.awt.Color(0, 153, 102));
        lblhoten.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 204, 153), new java.awt.Color(255, 102, 51)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel5.setText("Mã Sinh Viên: ");

        txtmasinhVien.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel6.setText("Tiếng anh: ");

        txttienganh.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel7.setText("Tin học: ");

        txttinhoc.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel8.setText("Giáo dục TC: ");

        txtgiaoductc.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel9.setText("Điểm TB: ");

        lbldiemtb.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        lbldiemtb.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 51, 0), new java.awt.Color(204, 255, 204)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblhoten, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(txtmasinhVien)
                    .addComponent(txttienganh)
                    .addComponent(txttinhoc)
                    .addComponent(txtgiaoductc)
                    .addComponent(lbldiemtb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(lblhoten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtmasinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttienganh, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttinhoc, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtgiaoductc, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbldiemtb, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\thanh\\Documents\\NetBeansProjects\\ASSIGNMENT_JAVA3\\src\\Image\\iconnew.png")); // NOI18N
        jButton1.setText(" NEW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\thanh\\Documents\\NetBeansProjects\\ASSIGNMENT_JAVA3\\src\\Image\\icondelete.png")); // NOI18N
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\thanh\\Documents\\NetBeansProjects\\ASSIGNMENT_JAVA3\\src\\Image\\iconUpdate.png")); // NOI18N
        jButton4.setText("UPDATE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\thanh\\Documents\\NetBeansProjects\\ASSIGNMENT_JAVA3\\src\\Image\\first.png")); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\thanh\\Documents\\NetBeansProjects\\ASSIGNMENT_JAVA3\\src\\Image\\left.png")); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\thanh\\Documents\\NetBeansProjects\\ASSIGNMENT_JAVA3\\src\\Image\\right.png")); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon("C:\\Users\\thanh\\Documents\\NetBeansProjects\\ASSIGNMENT_JAVA3\\src\\Image\\last.png")); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblSinhvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã SV", "Họ Tên", "Tiếng anh", "Tin học", "Giáo Dục TC", "Điểm TB"
            }
        ));
        tblSinhvien.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                tblSinhvienAncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblSinhvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhvienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSinhvien);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\thanh\\Documents\\NetBeansProjects\\ASSIGNMENT_JAVA3\\src\\Image\\hoa.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8)
                                .addGap(84, 84, 84))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                                .addGap(0, 50, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton6)
                                .addComponent(jButton7)
                                .addComponent(jButton8))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int index = tblSinhvien.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hàng cần cập nhật", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            list.remove(index);
            this.update();
            loadData();
            this.filltotable();
            lbldiemtb.setText(String.valueOf(list.get(index).getDiemTrungBinh()));
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tblSinhvienAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblSinhvienAncestorMoved

    }//GEN-LAST:event_tblSinhvienAncestorMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txttimkiem.setText("");
        txtmasinhVien.setText("");
        txttinhoc.setText("");
        txttienganh.setText("");
        txtgiaoductc.setText("");
        lbldiemtb.setText("");
        lblhoten.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblSinhvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhvienMouseClicked
        this.showDetail();
    }//GEN-LAST:event_tblSinhvienMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int i = tblSinhvien.getSelectedRow();
        if (i != -1) {
            this.delete(i);
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hàng để xóa", "thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txttimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimkiemKeyReleased
        SearchST(txttimkiem.getText());
    }//GEN-LAST:event_txttimkiemKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        current = 0;
        Display(current);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        current--;
        if (current < 0) {
            JOptionPane.showMessageDialog(this, "Đang ở đầu danh sách");
            return;
        }
        Display(current);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        current++;
        if (current > list.size() - 1) {
            JOptionPane.showMessageDialog(this, "Đang ở cuối danh sách");
            return;

        }
        Display(current);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        current = list.size() - 1;
        Display(current);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Quan_Ly_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Quan_Ly_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Quan_Ly_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Quan_Ly_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Quan_Ly_Diem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbldiemtb;
    private javax.swing.JLabel lblhoten;
    private javax.swing.JTable tblSinhvien;
    private javax.swing.JTextField txtgiaoductc;
    private javax.swing.JTextField txtmasinhVien;
    private javax.swing.JTextField txttienganh;
    private javax.swing.JTextField txttimkiem;
    private javax.swing.JTextField txttinhoc;
    // End of variables declaration//GEN-END:variables

    private void scrollToSelectedRow(JTable tblSinhvien) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
