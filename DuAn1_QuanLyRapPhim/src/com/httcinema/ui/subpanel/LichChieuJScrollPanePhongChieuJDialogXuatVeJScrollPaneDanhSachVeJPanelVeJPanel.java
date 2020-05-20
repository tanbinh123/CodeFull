package com.httcinema.ui.subpanel;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.httcinema.custom_jcomponents.CustomComboBox;
import com.httcinema.dao.GiaVeDAO;
import com.httcinema.helper.DateHelper;
import com.httcinema.model.Ghe;
import com.httcinema.model.GiaVe;

@SuppressWarnings("serial")
public class LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPaneDanhSachVeJPanelVeJPanel extends JPanel {
	private CustomComboBox<GiaVe> cboGiaVe;

	public CustomComboBox<GiaVe> getCboGiaVe() {
		return cboGiaVe;
	}

	public void setCboGiaVe(CustomComboBox<GiaVe> cboGiaVe) {
		this.cboGiaVe = cboGiaVe;
	}
	
	/**
	 * Create the panel.
	 */
	public LichChieuJScrollPanePhongChieuJDialogXuatVeJScrollPaneDanhSachVeJPanelVeJPanel(Ghe ghe) {
		
		setBorder(null);
		setBackground(Color.WHITE);
		
		JPanel pnlVe = new JPanel();
		pnlVe.setBackground(Color.WHITE);
		pnlVe.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlVe, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlVe, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblGhe = new JLabel("Ghế:");
		lblGhe.setForeground(new Color(53, 60, 68));
		lblGhe.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblGiaVe = new JLabel("Giá vé:");
		lblGiaVe.setForeground(new Color(53, 60, 68));
		lblGiaVe.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblGiaTriGhe = new JLabel(ghe.getMaGhe());
		lblGiaTriGhe.setForeground(new Color(53, 60, 68));
		lblGiaTriGhe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		cboGiaVe = new CustomComboBox<GiaVe>();
		cboGiaVe.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		GroupLayout gl_pnlVe = new GroupLayout(pnlVe);
		gl_pnlVe.setHorizontalGroup(
			gl_pnlVe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlVe.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_pnlVe.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlVe.createSequentialGroup()
							.addComponent(lblGhe, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblGiaTriGhe, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
						.addGroup(gl_pnlVe.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblGiaVe, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cboGiaVe, 0, 225, Short.MAX_VALUE)))
					.addGap(9))
		);
		gl_pnlVe.setVerticalGroup(
			gl_pnlVe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlVe.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_pnlVe.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGhe, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGiaTriGhe, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlVe.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblGiaVe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cboGiaVe, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
					.addContainerGap())
		);
		pnlVe.setLayout(gl_pnlVe);
		setLayout(groupLayout);
		
		fillComboBoxGiaVe();
	}
	
	private void fillComboBoxGiaVe() {
		DefaultComboBoxModel<GiaVe> model = (DefaultComboBoxModel<GiaVe>) cboGiaVe.getModel();
		model.removeAllElements();
		List<GiaVe> list = new GiaVeDAO().select();
		
		String ngayTrongTuan = DateHelper.toString(LichChieuJScrollPanePhongChieuJDialog.lichChieu.getNgayChieu(), "EEE");
		for (GiaVe gv : list) {
			// nếu ngày chiếu là chủ nhật, và giá vé hiện tại là ngày thường thì bỏ qua
			if (ngayTrongTuan.equals("Sun") && gv.getMoTa().equals("Ngày thường")) {
				continue;
			}
			
			// nếu ngày chiếu không phải chủ nhật, và giá vé hiện tại là cuối tuần thì bỏ qua
			if (!ngayTrongTuan.equals("Sun") && gv.getMoTa().equals("Cuối tuần")) {
				continue;
			}
			
			// nếu ngày chiếu là Happy day (thứ tư), và giá vé hiện tại là ngày thường thì bỏ qua
			if (ngayTrongTuan.equals("Wed") && gv.getMoTa().equals("Ngày thường")) {
				continue;
			}
			
			// nếu ngày chiếu không phải Happy day (thứ tư), và giá vé hiện tại là Happy day thì bỏ qua
			if (!ngayTrongTuan.equals("Wed") && gv.getMoTa().equals("Happy day")) {
				continue;
			}
			
			// nếu giá vé hiện tại là trẻ em, và phim trên 16 tuổi thì bỏ qua
			if (gv.getMoTa().equals("Dưới 16 tuổi") && LichChieuJScrollPanePhongChieuJDialog.phim.getDoTuoi() >= 16) {
				continue;
			}
			
			model.addElement(gv);
		}
		cboGiaVe.setSelectedIndex(0);
	}
}
