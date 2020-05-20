/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.giaodien;

import DAO.ChuyenDeDAO;
import DAO.KhoaHocDAO;
import Model.ChuyenDe;
import Model.KhoaHoc;
import Tienich.Helper.DateHelper;
import Tienich.Helper.DialogHelper;
import Tienich.Helper.ShareHelper;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DauTay
 */
public class quanlykhoahoc extends javax.swing.JFrame {

    /**
     * Creates new form quanlykhoahoc
     */
    public quanlykhoahoc() {
        initComponents();
        init();
        txtNguoiTao.setEditable(false);
    }
    int index = 0;
    KhoaHocDAO dao = new KhoaHocDAO();
    ChuyenDeDAO cddao = new ChuyenDeDAO();
    public Integer ma;
    void init() {
        setIconImage(ShareHelper.APP_ICON);
        setLocationRelativeTo(null);
        if (ShareHelper.USER != null) {
            this.fillComboBox();
           
            this.clear();
            txtNgayKG.setText("");
            this.setStatus(true);
             this.load();
        } else {
            DialogHelper.alert(this, "Vui lòng đăng nhập");
            this.tabs.removeAll();
        }
    }

    void load() {
         btnInsert.setEnabled(false);
        DefaultTableModel model = (DefaultTableModel) tblGridView.getModel();
        model.setRowCount(0);
        try {
            List<KhoaHoc> list = dao.select();
            for (KhoaHoc kh : list) {
                Object[] row = {
                    kh.getMaKH(),
                    kh.getMaCD(),
                    kh.getThoiLuong(),
                    kh.getHocPhi(),
                    DateHelper.toString(kh.getNgayKG()),
                    kh.getMaNV(),
                    DateHelper.toString(kh.getNgayTao())
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void insert() {
        KhoaHoc model = getModel();
        model.setNgayTao(new Date());
        try {
            dao.insert(model);
            this.load();
            this.clear();
            DialogHelper.alert(this, "Thêm mới thành công!");
        } catch (HeadlessException e) {
            DialogHelper.alert(this, "Thêm mới thất bại!");
        }
    }

    void update() {
        KhoaHoc model = getModel();

        try {
            dao.update(model);
            this.load();
            DialogHelper.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa khóa học này?")) {
            Integer makh = Integer.valueOf(cboChuyenDe.getToolTipText());
            try {
                dao.delete(makh);
                this.load();
                this.clear();
                DialogHelper.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                DialogHelper.alert(this, "Xóa thất bại!");
            }
        }
    }

    void clear() {
    
        KhoaHoc model = new KhoaHoc();
        ChuyenDe chuyenDe = (ChuyenDe) cboChuyenDe.getSelectedItem();
        model.setMaCD(chuyenDe.getMaCD());
        model.setMaNV(ShareHelper.USER.getMaNV());
        model.setNgayKG(DateHelper.add(30));
        model.setNgayTao(DateHelper.now());
        this.setModel(model);
    }

    void edit() {
        try {

            Integer makh = (Integer) tblGridView.getValueAt(this.index, 0);
            KhoaHoc model = dao.findById(makh);
            if (model != null) {
                this.setModel(model);
                this.setStatus(false);
              
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void setModel(KhoaHoc model) {
        cboChuyenDe.setToolTipText(String.valueOf(model.getMaKH()));
        cboChuyenDe.setSelectedItem(cddao.findById(model.getMaCD()));
        txtNgayKG.setText(DateHelper.toString(model.getNgayKG()));
        txtHocPhi.setText(String.valueOf(model.getHocPhi()));
        txtThoiLuong.setText(String.valueOf(model.getThoiLuong()));

        txtNgayTao.setText(DateHelper.toString(model.getNgayTao()));
        txtGhiChu.setText(model.getGhiChu());
    }

    KhoaHoc getModel() {
        KhoaHoc model = new KhoaHoc();
        ChuyenDe chuyenDe = (ChuyenDe) cboChuyenDe.getSelectedItem();
        model.setMaCD(chuyenDe.getMaCD());
        model.setNgayKG(DateHelper.toDate(txtNgayKG.getText()));
        model.setHocPhi(Double.valueOf(txtHocPhi.getText()));
        model.setThoiLuong(Integer.valueOf(txtThoiLuong.getText()));
        model.setGhiChu(txtGhiChu.getText());
        model.setMaNV(ShareHelper.USER.getMaNV());
        model.setNgayTao(DateHelper.toDate(txtNgayTao.getText()));
        model.setMaKH(Integer.valueOf(cboChuyenDe.getToolTipText()));

        return model;
    }

    void setStatus(boolean insertable) {
        btnInsert.setEnabled(insertable);
        btnUpdate.setEnabled(!insertable);
        btnDelete.setEnabled(!insertable);

        boolean first = this.index > 0;
        boolean last = this.index < tblGridView.getRowCount() - 1;
        btnFisrt.setEnabled(!insertable && first);
        btnPrev.setEnabled(!insertable && first);
        btnLast.setEnabled(!insertable && last);
        btnNext.setEnabled(!insertable && last);

        btnStudents.setVisible(!insertable);
    }

    void selectComboBox() {
        ChuyenDe chuyenDe = (ChuyenDe) cboChuyenDe.getSelectedItem();
        txtThoiLuong.setText(String.valueOf(chuyenDe.getThoiLuong()));
        txtHocPhi.setText(String.valueOf(chuyenDe.getHocPhi()));
    }

    void openHocVien() {
      

    }

    void fillComboBox() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboChuyenDe.getModel();
        model.removeAllElements();
        try {
            List<ChuyenDe> list = cddao.select();
            for (ChuyenDe cd : list) {
                model.addElement(cd);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
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

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboChuyenDe = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtHocPhi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNguoiTao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnFisrt = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNgayKG = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtThoiLuong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        btnStudents = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGridView = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Chuyên đề");

        cboChuyenDe.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cboChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChuyenDeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Học phí");

        txtHocPhi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Người tạo");

        txtNguoiTao.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtNguoiTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNguoiTaoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Ghi chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtGhiChu);

        btnInsert.setText("Thêm");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnFisrt.setText("|<");

        btnNext.setText(">>");

        btnLast.setText(">|");

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Ngày khai giảng:");

        txtNgayKG.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Thời lượng (giờ)");

        txtThoiLuong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Ngày tạo");

        txtNgayTao.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btnStudents.setText("Học Viên");
        btnStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear)
                        .addGap(18, 18, 18)
                        .addComponent(btnStudents)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(btnFisrt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLast))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(cboChuyenDe, 0, 240, Short.MAX_VALUE)
                            .addComponent(txtHocPhi)
                            .addComponent(txtNguoiTao))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayKG, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtThoiLuong)
                            .addComponent(txtNgayTao))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayKG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnFisrt)
                    .addComponent(btnNext)
                    .addComponent(btnLast)
                    .addComponent(btnPrev)
                    .addComponent(btnStudents))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        tabs.addTab("CẬP NHẬT", jPanel1);

        tblGridView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ KH", "CHUYÊN ĐỀ", "THỜI LƯỢNG", "HỌC PHÍ", "KHAI GIẢNG", "TẠO BỞI", "NGÀY TẠO"
            }
        ));
        tblGridView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGridViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGridView);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
        );

        tabs.addTab("DANH SÁCH", jPanel2);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("QUẢN LÝ KHÓA HỌC");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabs)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabs)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevActionPerformed

    private void txtNguoiTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNguoiTaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNguoiTaoActionPerformed

     boolean flag=false;
     void check(){
        if(txtThoiLuong.getText().equals("")||!txtHocPhi.getText().equals("")){
           checktl();
        }else if(txtNgayKG.getText().equals("")){
           DialogHelper.alert(this, "Không bỏ trống ngày khai giảng!"); 
        }
        else if(txtNgayTao.getText().equals("")){
           DialogHelper.alert(this, "Không bỏ trống ngày tạo!"); 
        }
        else{
             flag=true;
         } 
     }
    void checktl(){
     if(txtThoiLuong.getText().equals("0")||txtThoiLuong.getText().equals("")){
            DialogHelper.alert(this, "Không bỏ trống thời lượng!"); 
     }else if(txtHocPhi.getText().equals("")||txtHocPhi.getText().equals("0.0")){
           DialogHelper.alert(this, "Không bỏ trống học phí!"); 
    }else if(!txtThoiLuong.getText().equals("0")||!txtHocPhi.getText().equals("0.0")){
         String hp="java.lang.NumberFormatException: For input string: ";
         String tl2="java.lang.NumberFormatException: For input string: ";
         String tl="";
        try {
            if(!txtThoiLuong.getText().equals("0")||!txtHocPhi.getText().equals("0.0")){
            int thoiluong = Integer.parseInt(txtThoiLuong.getText());
            int hocphi = Integer.parseInt(txtHocPhi.getText());
            
            if (thoiluong <= 0) {
                DialogHelper.alert(this, "Thời lượng là số dương và phải lớn hơn 0");
            }
            else if (hocphi <= 0) {
                DialogHelper.alert(this, "Học phí là số dương và phải lớn hơn 0");
            }else{
               flag=true;
               
            }
            }
          
        } catch (Exception e) {
              System.out.println(e);
              tl+=e.toString();
              hp+="\""+(txtHocPhi.getText()).toString()+"\"";
              tl2+="\""+(txtThoiLuong.getText()).toString()+"\"";
              System.out.println(hp);
               System.out.println(tl2);
              if(tl.equals(hp)){
                   DialogHelper.alert(this, "Học phí phải truyền vào kiểu số!"); 
              }else if(tl.equals(tl2)){
                  DialogHelper.alert(this, "Thời lượng phải truyền vào kiểu số!"); 
              }
             
         
 
        }
    }}
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        check();
        if(flag==true){
           
        try {
             String ngay11 = txtNgayKG.getText();
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(ngay11);
            if(date.after(new Date())){

                DialogHelper.alert(this, "Ngày khai giảng phai sau ngày hiện tại!");
                return;}else{
        insert();}
          
        } catch (Exception e) {
            DialogHelper.alert(this, "Sai định dạng ngày!");
        }}
            // TODO add your handling code here:
    }//GEN-LAST:event_btnInsertActionPerformed

    private void tblGridViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGridViewMouseClicked
        // TODO add your handling code here:\

        if (evt.getClickCount() == 1) {

            if (this.index >= 0) {
                this.edit();
                this.index = tblGridView.rowAtPoint(evt.getPoint());
                String name = (String) tblGridView.getValueAt(this.index, 5);
                Integer ma2=(Integer) tblGridView.getValueAt(this.index, 0);
                ma=ma2;
                txtNguoiTao.setText(name);
                tabs.setSelectedIndex(0);

            }
        }
    }//GEN-LAST:event_tblGridViewMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
             check();
        if(flag==true){
           
        try {
             String ngay11 = txtNgayKG.getText();
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(ngay11);
            if(date.after(new Date())){

                DialogHelper.alert(this, "Ngày khai giảng phai sau ngày hiện tại!");
                return;}else{
        update();}
          
        } catch (Exception e) {
            DialogHelper.alert(this, "Sai định dạng ngày!");
        }}
            // TODO add your handling code here:
               // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
         btnInsert.setEnabled(true);
        txtNguoiTao.setText("");
          Date ngaymua = new Date();
           SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");
           String ngay2 = DATE_FORMATER.format(ngaymua);
           
           String [] key = ngay2.split("/");
           int ngay=Integer.parseInt(key[0]);
             int thang=Integer.parseInt(key[1]);
           String time=""+(ngay+1)+"/"+key[1]+"/"+key[2]+"";
           String time1;
           
        try {
            
            Date date= DATE_FORMATER.parse(time);
            String ngay3 = DATE_FORMATER.format(date);
            txtNgayKG.setText(ngay3);
            txtNgayTao.disable();
              txtNgayTao.setText(ngay2);
            txtNguoiTao.setText(ShareHelper.USER.getMaNV());
        } catch (ParseException ex) {
           
        }
       
       
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentsActionPerformed
    if(ma==null){
        DialogHelper.alert(this, "Chưa chọn học viên");
    }else{
        new quanlyhocvien(ma).setVisible(true);
        System.out.println(ma);}
    // TODO add your handling code here:
    }//GEN-LAST:event_btnStudentsActionPerformed

    private void cboChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChuyenDeActionPerformed
        selectComboBox();
    }//GEN-LAST:event_cboChuyenDeActionPerformed

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
            java.util.logging.Logger.getLogger(quanlykhoahoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quanlykhoahoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quanlykhoahoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quanlykhoahoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quanlykhoahoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFisrt;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnStudents;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboChuyenDe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblGridView;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtHocPhi;
    private javax.swing.JTextField txtNgayKG;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNguoiTao;
    private javax.swing.JTextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables
}
