package Frame_Quanlynhanvien;

import Entities.NhanVien;
import Helper.FormatDouble;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author thanh
 */
public class QuanLynhanVien extends javax.swing.JFrame {

    List<NhanVien> list = new ArrayList<NhanVien>();
    Clock clock;

    public QuanLynhanVien() {
        initComponents();
        setLocationRelativeTo(null);
        init();
    }

    private void init() {
        this.clock = new Clock(jlbtime);
        this.clock.start();
        ((DefaultTableModel) tablenhanvien.getModel()).setRowCount(0);
    }

    public void saveNhanVien() {
        NhanVien nv = new NhanVien();
        nv.setMaNhanVien(txtmanhanvien.getText());
        nv.setHoVaTen(txthovaten.getText());
        nv.setTuoi(Integer.parseInt(txttuoi.getText()));
        nv.setEmail(txtemail.getText());
        nv.setLuong(Double.parseDouble(txtluong.getText().replace("", "")));
        list.add(nv);
    }

    public void deleteNhanVien() {
        try {
            int index = tablenhanvien.getSelectedRow();
            list.remove(index);
        } catch (Exception nv) {
            JOptionPane.showMessageDialog(this, "Hãy chọn nhân viên!");
        }

    }

    public void updateNhanVien() {
        int index = tablenhanvien.getSelectedRow();
        NhanVien nv = list.get(index);
        nv.setMaNhanVien(txtmanhanvien.getText());
        nv.setHoVaTen(txthovaten.getText());
        nv.setTuoi(Integer.parseInt(txttuoi.getText()));
        nv.setEmail(txtemail.getText());
        nv.setLuong(Double.parseDouble(txtluong.getText().replace(".", "")));
    }

    public void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tablenhanvien.getModel();
        model.setRowCount(0);
        for (NhanVien nv : list) {
            Object[] row = new Object[]{nv.getMaNhanVien(), nv.getHoVaTen(), nv.getTuoi(), nv.getEmail(), FormatDouble.formatPerThousand(nv.getLuong())};
            model.addRow(row);
        }
    }

    public void showDetail() {

        int index = tablenhanvien.getSelectedRow();
        NhanVien nv = list.get(index);
        txtmanhanvien.setText(nv.getMaNhanVien());
        txthovaten.setText(nv.getHoVaTen());
        txttuoi.setText(String.valueOf(nv.getTuoi()));
        txtemail.setText(nv.getEmail());
        txtluong.setText(String.valueOf(nv.getLuong()));

    }

    public void findNhanVien() {
        int index = 0;
        if (index < list.size() - 1) {
            index++;
            showDetail();
        }
    }

    public boolean xuat() {
        boolean exit = false;
        try {
            JFileChooser c = new JFileChooser();
            int rVal = c.showSaveDialog(null);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                if (!c.getSelectedFile().exists()) {
                    c.getSelectedFile().createNewFile();
                }
                FileOutputStream file = new FileOutputStream(c.getSelectedFile());
                ObjectOutputStream a = new ObjectOutputStream(file);
                a.writeObject(list);
                a.close();
                exit = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(QuanLynhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exit;
    }

    public void read() {
        try {

            JFileChooser c = new JFileChooser();
            int rVal = c.showOpenDialog(null);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                FileInputStream b = new FileInputStream(c.getSelectedFile());
                ObjectInputStream a = new ObjectInputStream(b);
                list = (ArrayList) a.readObject();
                a.close();
                fillToTable();
            }
        } catch (Exception ex) {
            Logger.getLogger(QuanLynhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean kiemTra() {
        boolean check = true;
        String maNhanvien = txtmanhanvien.getText().trim();
        if (maNhanvien.equals("")) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống");
            txtmanhanvien.setBackground(Color.red);
            check = false;
        } else {

            try {
                for (int i = 0; i < list.size(); i++) {

                    if (list.get(i).getMaNhanVien().equals(maNhanvien)) {
                        JOptionPane.showMessageDialog(this, "Trùng mã nhân viên");
                        txtmanhanvien.setBackground(Color.red);
                        check = false;
                    } else {

                        txtmanhanvien.setBackground(Color.white);
                        break;

                    }
                }
                NhanVien nv = new NhanVien();

            } catch (Exception e) {
                Logger.getLogger(QuanLynhanVien.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        String hoVaTen = txthovaten.getText();
        try {
            Double so = Double.parseDouble(hoVaTen);
            JOptionPane.showMessageDialog(this, "bạn đã nhập sai định dạng");
            txthovaten.setBackground(Color.red);
            check = false;
        } catch (Exception e) {
            if (hoVaTen.length() == 0) {
                JOptionPane.showMessageDialog(this, "không được để trống họ tên");
                txthovaten.setBackground(Color.red);
                check = false;
            } else {
                txthovaten.setBackground(Color.white);
            }
        }

        try {
            int tuoi = Integer.parseInt(txttuoi.getText());
            if (tuoi < 16) {
                JOptionPane.showMessageDialog(this, "tuổi quá nhỏ");
                txttuoi.setBackground(Color.red);
            } else {
                txttuoi.setBackground(Color.white);
            }
            if (tuoi > 55) {
                JOptionPane.showMessageDialog(this, "tuổi quá lớn");
                txttuoi.setBackground(Color.red);
            } else {
                txttuoi.setBackground(Color.white);
            }

        } catch (Exception e) {
            if (txttuoi.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "không được để trống tuổi");
                txttuoi.setBackground(Color.red);
            } else {
                txttuoi.setBackground(Color.white);
            }
        }
        String email = txtemail.getText();

        try {
            
            String regex = "^\\w+[a-z0-9]*@{1}\\w+mail.com$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (matcher.find()) {
                txtemail.setBackground(Color.white);
            } else {
                JOptionPane.showMessageDialog(this, "bạn đã nhập sai định dạng mail");
                txtemail.setBackground(Color.red);
            }
            if (email.length() == 0) {
                JOptionPane.showMessageDialog(this, "không được để trống email");
                txtemail.setBackground(Color.red);
            }
        } catch (Exception e) {
            Logger.getLogger(QuanLynhanVien.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            Double luong = Double.parseDouble(txtluong.getText());
            if (luong < 5000000) {
                JOptionPane.showMessageDialog(this, "lương phải trên 5000000");
                txtluong.setBackground(Color.red);
                check = false;
            } else {
                txtluong.setBackground(Color.white);
            }
        } catch (Exception e) {
            if (txtluong.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "không được để trống lương");
                txtluong.setBackground(Color.red);
                check = false;
            } else {
                txtluong.setBackground(Color.white);
            }
        }

        return check;
    }

    private void searchNV(String a) {
        DefaultTableModel o = (DefaultTableModel) tablenhanvien.getModel();
        o.setRowCount(0);
        for (NhanVien i : list) {
            System.out.println(a);
            System.out.println(i.getMaNhanVien());
            System.out.println(a.contains(i.getMaNhanVien()));
            if (i.getMaNhanVien().contains(a)) {

                Object[] row = new Object[]{i.getMaNhanVien(), i.getHoVaTen(), i.getTuoi(), i.getEmail(), i.getLuong()};
                o.addRow(row);

            }
        }
    }

    private void top() {
        int size = tablenhanvien.getRowCount();
        if (size == 0) {
            JOptionPane.showMessageDialog(this, "Dữ liệu trống vui lòng nhập nhân viên", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            int index = 0;
            tablenhanvien.setRowSelectionInterval(index, index);
            this.autoScroll(index);
            this.showDetail();
        }

    }

    private void last() {
        int size = tablenhanvien.getRowCount();
        if (size == 0) {
            JOptionPane.showMessageDialog(this, "Dữ liệu trống vui lòng nhập nhân viên", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            int index = size - 1;
            System.out.println(index);
            tablenhanvien.setRowSelectionInterval(index, index);
            this.autoScroll(index);
            this.showDetail();
        }

    }

    private void autoScroll(int index) {
        tablenhanvien.scrollRectToVisible(new Rectangle(tablenhanvien.getCellRect(index, 0, true)));
    }

    private void btnUp() {
        int index = tablenhanvien.getSelectedRow();

        if (tablenhanvien.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Dữ liệu trống, vui lòng thêm nhân viên mới!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else if (index == -1) {
            tablenhanvien.setRowSelectionInterval(0, 0);
        } else if (index >= 1) {
            index--;
            tablenhanvien.setRowSelectionInterval(index, index);
            scrollToSelectedRow(tablenhanvien);
            this.autoScroll(index);
            this.showDetail();
        }

    }

    private void btnDown() {
        int index = tablenhanvien.getSelectedRow();

        if (tablenhanvien.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Dữ liệu trống, vui lòng thêm nhân viên mới!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else if (index == -1) {
            tablenhanvien.setRowSelectionInterval(0, 0);
        } else if (index < tablenhanvien.getRowCount() - 1) {
            index++;
            tablenhanvien.setRowSelectionInterval(index, index);
            scrollToSelectedRow(tablenhanvien);
            this.autoScroll(index);

            this.showDetail();

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jlbquanlynhanvien = new javax.swing.JLabel();
        lblhovaten = new javax.swing.JLabel();
        lbltuoi = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        lblluong = new javax.swing.JLabel();
        lblmanhanvien = new javax.swing.JLabel();
        txtmanhanvien = new javax.swing.JTextField();
        txttuoi = new javax.swing.JTextField();
        txtluong = new javax.swing.JTextField();
        txthovaten = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        btndoubleup = new javax.swing.JButton();
        btnup = new javax.swing.JButton();
        btndow = new javax.swing.JButton();
        btndoubledow = new javax.swing.JButton();
        jbtnew = new javax.swing.JButton();
        jbtsave = new javax.swing.JButton();
        jbtdelete = new javax.swing.JButton();
        jbtopen = new javax.swing.JButton();
        jbtexit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablenhanvien = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jlbtime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Quản Lý Nhân Viên"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jlbquanlynhanvien.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jlbquanlynhanvien.setForeground(new java.awt.Color(0, 153, 51));
        jlbquanlynhanvien.setText("QUẢN LÝ NHÂN VIÊN");

        lblhovaten.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblhovaten.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblhovaten.setText("HỌ VÀ TÊN");

        lbltuoi.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbltuoi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbltuoi.setText("TUỔI");

        lblemail.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblemail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblemail.setText("EMAIL");

        lblluong.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblluong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblluong.setText("LƯƠNG");

        lblmanhanvien.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblmanhanvien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblmanhanvien.setText("MÃ NHÂN VIÊN");

        txttuoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txttuoiMousePressed(evt);
            }
        });
        txttuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttuoiActionPerformed(evt);
            }
        });
        txttuoi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttuoiKeyTyped(evt);
            }
        });

        txtluong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtluongKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtluongKeyTyped(evt);
            }
        });

        btndoubleup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoubleupActionPerformed(evt);
            }
        });

        btnup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupActionPerformed(evt);
            }
        });

        btndow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndowActionPerformed(evt);
            }
        });

        btndoubledow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoubledowActionPerformed(evt);
            }
        });

        jbtnew.setBackground(new java.awt.Color(51, 204, 0));
        jbtnew.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jbtnew.setForeground(new java.awt.Color(255, 255, 255));
        jbtnew.setText("NEW");
        jbtnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnewActionPerformed(evt);
            }
        });

        jbtsave.setBackground(new java.awt.Color(51, 204, 0));
        jbtsave.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jbtsave.setForeground(new java.awt.Color(255, 255, 255));
        jbtsave.setText("SAVE");
        jbtsave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtsaveMouseClicked(evt);
            }
        });
        jbtsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtsaveActionPerformed(evt);
            }
        });

        jbtdelete.setBackground(new java.awt.Color(51, 204, 0));
        jbtdelete.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jbtdelete.setForeground(new java.awt.Color(255, 255, 255));
        jbtdelete.setText("DELETE");
        jbtdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtdeleteActionPerformed(evt);
            }
        });

        jbtopen.setBackground(new java.awt.Color(51, 204, 0));
        jbtopen.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jbtopen.setForeground(new java.awt.Color(255, 255, 255));
        jbtopen.setText("OPEN");
        jbtopen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtopenActionPerformed(evt);
            }
        });

        jbtexit.setBackground(new java.awt.Color(51, 204, 0));
        jbtexit.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jbtexit.setForeground(new java.awt.Color(255, 255, 255));
        jbtexit.setText("EXIT");
        jbtexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtexitActionPerformed(evt);
            }
        });

        tablenhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MÃ NHÂN VIÊN", "HỌ VÀ TÊN", "TUỔI", "EMAIL", "LƯƠNG"
            }
        ));
        tablenhanvien.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                tablenhanvienAncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tablenhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablenhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablenhanvien);

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 153, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setText("   FIND");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlbtime.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jlbtime.setForeground(new java.awt.Color(255, 51, 0));
        jlbtime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbtime.setText("08:19:00 Am");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbltuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblluong, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(jlbquanlynhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 198, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtemail, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btndoubleup)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnup)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btndow)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btndoubledow)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtluong, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txttuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblmanhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblhovaten, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txthovaten)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtmanhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlbtime, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtsave, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtnew, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtexit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtopen, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbquanlynhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmanhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblmanhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txthovaten, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblhovaten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltuoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblemail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtluong, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblluong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnew)
                            .addComponent(jlbtime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtdelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtopen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtexit)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndoubleup)
                    .addComponent(btnup)
                    .addComponent(btndow)
                    .addComponent(btndoubledow)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnewActionPerformed
        txtmanhanvien.setText("");
        txthovaten.setText("");
        txttuoi.setText("");
        txtemail.setText("");
        txtluong.setText("");
        tablenhanvien.clearSelection();
        jbtsave.setText("SAVE");
    }//GEN-LAST:event_jbtnewActionPerformed

    private void jbtsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtsaveActionPerformed
        if (tablenhanvien.getSelectedRow() == -1) {
            if (this.kiemTra()) {
                this.saveNhanVien();
            }
        } else {
            this.updateNhanVien();
        }

        this.fillToTable();

        if (list.size() > 0) {
            int last = list.size() - 1;
            tablenhanvien.setRowSelectionInterval(last, last);
            this.autoScroll(last);
        }
    }//GEN-LAST:event_jbtsaveActionPerformed

    private void jbtdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtdeleteActionPerformed
        this.deleteNhanVien();
        this.fillToTable();
    }//GEN-LAST:event_jbtdeleteActionPerformed

    private void tablenhanvienAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tablenhanvienAncestorMoved

    }//GEN-LAST:event_tablenhanvienAncestorMoved

    private void tablenhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablenhanvienMouseClicked
        // TODO add your handling code here:
        int index = tablenhanvien.getSelectedRow();
        NhanVien nv = list.get(index);
        //formatPerThousand
        String manhanvien = nv.getMaNhanVien();
        txtmanhanvien.setText(manhanvien);

        String hoVaTen = nv.getHoVaTen();
        txthovaten.setText(hoVaTen);

        String tuoi = String.valueOf(nv.getTuoi());
        txttuoi.setText(tuoi);

        String email = nv.getEmail();
        txtemail.setText(email);

        String luong = FormatDouble.formatPerThousand(nv.getLuong());
        txtluong.setText(luong);

        jbtsave.setText("UPDATE");


    }//GEN-LAST:event_tablenhanvienMouseClicked

    private void jbtexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtexitActionPerformed
        if (this.xuat()) {
            System.exit(0);
        }
    }//GEN-LAST:event_jbtexitActionPerformed

    private void jbtopenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtopenActionPerformed
        this.read();
    }//GEN-LAST:event_jbtopenActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        searchNV(txtTimKiem.getText());
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btndoubledowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoubledowActionPerformed
        this.last();

    }//GEN-LAST:event_btndoubledowActionPerformed

    private void btndowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndowActionPerformed
        this.btnDown();

    }//GEN-LAST:event_btndowActionPerformed

    private void btnupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupActionPerformed
        this.btnUp();

    }//GEN-LAST:event_btnupActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btndoubleupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoubleupActionPerformed
        this.top();

    }//GEN-LAST:event_btndoubleupActionPerformed

    private void txtluongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtluongKeyReleased
        int code = evt.getKeyCode();
        if (code < 37 || code > 40) {
            String formarNum = txtluong.getText().trim().replace(".", "");
            txtluong.setText(FormatDouble.formatPerThousand(formarNum));
        }
    }//GEN-LAST:event_txtluongKeyReleased

    private void txtluongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtluongKeyTyped
        char c = evt.getKeyChar();
        int code = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
            this.getToolkit().beep();
        }
    }//GEN-LAST:event_txtluongKeyTyped

    private void txttuoiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttuoiKeyTyped
        char c = evt.getKeyChar();
        int code = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
            this.getToolkit().beep();
        }
    }//GEN-LAST:event_txttuoiKeyTyped

    private void txttuoiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttuoiMousePressed

    }//GEN-LAST:event_txttuoiMousePressed

    private void txttuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttuoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttuoiActionPerformed

    private void jbtsaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtsaveMouseClicked

    }//GEN-LAST:event_jbtsaveMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLynhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLynhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLynhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLynhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLynhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndoubledow;
    private javax.swing.JButton btndoubleup;
    private javax.swing.JButton btndow;
    private javax.swing.JButton btnup;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtdelete;
    private javax.swing.JButton jbtexit;
    private javax.swing.JButton jbtnew;
    private javax.swing.JButton jbtopen;
    private javax.swing.JButton jbtsave;
    private javax.swing.JLabel jlbquanlynhanvien;
    private javax.swing.JLabel jlbtime;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblhovaten;
    private javax.swing.JLabel lblluong;
    private javax.swing.JLabel lblmanhanvien;
    private javax.swing.JLabel lbltuoi;
    private javax.swing.JTable tablenhanvien;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthovaten;
    private javax.swing.JTextField txtluong;
    private javax.swing.JTextField txtmanhanvien;
    private javax.swing.JTextField txttuoi;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void scrollToSelectedRow(JTable tablenhanvien) {

    }

}
