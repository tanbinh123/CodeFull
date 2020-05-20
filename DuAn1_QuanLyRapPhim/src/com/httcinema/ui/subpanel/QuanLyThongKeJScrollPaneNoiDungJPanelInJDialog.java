package com.httcinema.ui.subpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

import com.httcinema.custom_jcomponents.CustomButton;
import com.httcinema.custom_jcomponents.CustomCheckBox;
import com.httcinema.custom_jcomponents.CustomDialog;
import com.httcinema.custom_jcomponents.CustomFileChooser;
import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.helper.DialogHelper;

import jxl.HeaderFooter;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.PageOrientation;
import jxl.format.PaperSize;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@SuppressWarnings("serial")
public class QuanLyThongKeJScrollPaneNoiDungJPanelInJDialog extends CustomDialog {
	
	private QuanLyThongKeJScrollPaneNoiDungJPanelInJDialog thisDialog;
	private final JPanel contentPanel = new JPanel();
	private CustomCheckBox chkThongKePhim;
	private CustomCheckBox chkThongKePhongChieu;
	private CustomCheckBox chkThongKeGioChieu;

	public static void showDialog(Component owner, JTable tblDoanhThuPhim, JTable tblDoanhThuPhongChieu, JTable tblDoanhThuGioChieu) {
		QuanLyThongKeJScrollPaneNoiDungJPanelInJDialog dialog;
		if (owner instanceof JDialog) {
			dialog = new QuanLyThongKeJScrollPaneNoiDungJPanelInJDialog((Dialog) owner);
		}
		else {
			dialog = new QuanLyThongKeJScrollPaneNoiDungJPanelInJDialog((Frame) owner);
		}
		
		dialog.init(tblDoanhThuPhim, tblDoanhThuPhongChieu, tblDoanhThuGioChieu);
		dialog.setLocationRelativeTo(owner);
		dialog.fadeIn(dialog);
	}

	public QuanLyThongKeJScrollPaneNoiDungJPanelInJDialog(Frame owner) {
		super(owner);
	}
	
	public QuanLyThongKeJScrollPaneNoiDungJPanelInJDialog(Dialog owner) {
		super(owner);
	}

	public QuanLyThongKeJScrollPaneNoiDungJPanelInJDialog() {
		setUndecorated(true);
		init(null, null, null);
	}
	/**
	 * Create the dialog.
	 */
	public void init(JTable tblDoanhThuPhim, JTable tblDoanhThuPhongChieu, JTable tblDoanhThuGioChieu) {
		thisDialog = this;
		
		setBounds(100, 100, 586, 417);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new LineBorder(Theme.dark, 3));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 85, 376, 275);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		chkThongKePhim = new CustomCheckBox("Thống kê doanh thu phim");
		chkThongKePhim.setSelectedIcon(new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanelInJDialog.class.getResource("/com/httcinema/custom_jcomponents/radio_icon/radio-button-selected.png")));
		chkThongKePhim.setIcon(new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanelInJDialog.class.getResource("/com/httcinema/custom_jcomponents/radio_icon/radio-button-normal.png")));
		chkThongKePhim.setForeground(Theme.dark);
		chkThongKePhim.setBackground(Color.WHITE);
		chkThongKePhim.setBounds(6, 7, 364, 40);
		chkThongKePhim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(chkThongKePhim);
		
		chkThongKePhongChieu = new CustomCheckBox("Thống kê doanh thu phòng chiếu");
		chkThongKePhongChieu.setForeground(Theme.dark);
		chkThongKePhongChieu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chkThongKePhongChieu.setBackground(Color.WHITE);
		chkThongKePhongChieu.setBounds(6, 50, 364, 40);
		panel.add(chkThongKePhongChieu);
		
		chkThongKeGioChieu = new CustomCheckBox("Thống kê doanh thu giờ chiếu");
		chkThongKeGioChieu.setForeground(Theme.dark);
		chkThongKeGioChieu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chkThongKeGioChieu.setBackground(Color.WHITE);
		chkThongKeGioChieu.setBounds(6, 93, 364, 40);
		panel.add(chkThongKeGioChieu);
		
		JLabel lblTieuDe = new JLabel("XUẤT BÁO CÁO");
		lblTieuDe.setIcon(new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanelInJDialog.class.getResource("/com/httcinema/icon/icon-printer-2.png")));
		lblTieuDe.setForeground(new Color(53, 60, 68));
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setBounds(10, 11, 566, 63);
		contentPanel.add(lblTieuDe);
		{
			CustomButton btnXuatFile = new CustomButton("Xuất File");
			btnXuatFile.setBounds(10, 371, 170, 35);
			contentPanel.add(btnXuatFile);
			btnXuatFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!chkThongKePhim.isSelected() && !chkThongKePhongChieu.isSelected() && !chkThongKeGioChieu.isSelected()) {
						DialogHelper.warning(thisDialog, "Bạn chưa chọn báo cáo để xuất!");
						return;
					}
					
					CustomFileChooser fc = new CustomFileChooser();
					fc.setDialogTitle("Chọn nơi lưu các báo cáo");
					fc.setCurrentDirectory(new File (System.getProperty("user.home") + "/Desktop/"));
					
					// set the selection mode to directories only
					fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

					// invoke the showsOpenDialog function to show the save dialog
					int r = fc.showSaveDialog(thisDialog);

					if (r == JFileChooser.APPROVE_OPTION) {
						// set the label to the path of the selected directory
						int success = 0;
						String location = fc.getSelectedFile().getAbsolutePath();

						if (chkThongKePhim.isSelected()) {
							success += writeToExcel(tblDoanhThuPhim, location, "Thống kê doanh thu phim");
						}
						if (chkThongKePhongChieu.isSelected()) {
							success += writeToExcel(tblDoanhThuPhongChieu, location, "Thống kê doanh thu phòng chiếu");
						}
						if (chkThongKeGioChieu.isSelected()) {
							success += writeToExcel(tblDoanhThuGioChieu, location, "Thống kê doanh thu giờ chiếu");
						}
						if (success > 0) {
							DialogHelper.success(thisDialog, "Xuất File Thành công");
						}
					}
					
					// if the user cancelled the operation
					else {
					}
				}
			});
			Theme.setDefaultButtonFormat(btnXuatFile);
			btnXuatFile.setBackground(Theme.green);
			btnXuatFile.setHoverBackground(Theme.darkGreen);
			btnXuatFile.setActionCommand("OK");
			getRootPane().setDefaultButton(btnXuatFile);
		}
		{
			CustomButton btnDong = new CustomButton("Đóng");
			btnDong.setBounds(456, 371, 120, 35);
			contentPanel.add(btnDong);
			btnDong.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fadeOut();
				}
			});
			Theme.setDefaultButtonFormat(btnDong);
			btnDong.setBackground(new Color(36, 36, 36));
			btnDong.setHoverBackground(Color.BLACK);
			btnDong.setActionCommand("Đóng");
		}
		
		JLabel lblHinh = new JLabel("");
		lblHinh.setVerticalAlignment(SwingConstants.TOP);
		lblHinh.setBounds(396, 85, 180, 275);
		contentPanel.add(lblHinh);
		lblHinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinh.setIcon(new ImageIcon(QuanLyThongKeJScrollPaneNoiDungJPanelInJDialog.class.getResource("/com/httcinema/icon/icon-excel.png")));
	}
	int writeToExcel(JTable table, String location, String fileName) {

		String fileLocation = location + "\\" + fileName + ".xls";

		try {
			WritableWorkbook workbook = Workbook.createWorkbook(new File(fileLocation));
			WritableSheet sheet1 = workbook.createSheet(fileName, 0);
			
			// set headers and footers
			HeaderFooter header = new HeaderFooter();
			header.getCentre().setFontSize(20);
			header.getCentre().toggleBold();
			header.getCentre().append("CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM");
			header.getCentre().append("\nĐộc lập - Tự do - Hạnh phúc\n");
			header.getCentre().append("\nBÁO CÁO " + fileName.toUpperCase() + "\n");

			HeaderFooter footer = new HeaderFooter();
			footer.getLeft().appendDate();
			footer.getCentre().append("Page ");
			footer.getCentre().appendPageNumber();
			footer.getCentre().append("/");
			footer.getCentre().appendTotalPages();
			footer.getRight().appendTime();
			
			// sheet setting
			SheetSettings sheet1Setting = sheet1.getSettings();
			sheet1Setting.setFitToPages(true);
			sheet1Setting.setFitWidth(1);
			sheet1Setting.setFitHeight(1);
			sheet1Setting.setHeader(header);
			sheet1Setting.setFooter(footer);
			sheet1.setPageSetup(PageOrientation.LANDSCAPE, PaperSize.A4, 0, 0);

			// define color and format of headers
			WritableFont headerFont = new WritableFont(WritableFont.TAHOMA, 15);		
			headerFont.setBoldStyle(WritableFont.BOLD);
			headerFont.setColour(Colour.WHITE);

			WritableCellFormat headerFormat = new WritableCellFormat(headerFont);
			headerFormat.setBackground(Colour.SEA_GREEN);
			headerFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			headerFormat.setBorder(Border.ALL, BorderLineStyle.THIN);

			// define color and format of cells
			WritableFont cellFont = new WritableFont(WritableFont.TAHOMA, 15);
			cellFont.setColour(Colour.BLACK);

			WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
			cellFormat.setBackground(Colour.WHITE);
			cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);

			// get table model
			TableModel model = table.getModel();

			// add headers
			for (int i = 0; i < model.getColumnCount(); i++) {
				sheet1.setColumnView(i, 60); // column's width setting
				Label column = new Label(i, 0, model.getColumnName(i), headerFormat);
				sheet1.addCell(column);
			}

			// add rows
			for (int i = 0; i < model.getRowCount(); i++) {
				for (int j = 0; j < model.getColumnCount(); j++) {
					Label row = new Label(j, i + 1, model.getValueAt(i, j).toString(), cellFormat);
					sheet1.addCell(row);
				}
			}
			workbook.write();
			workbook.close();

			return 1;
		} catch (Exception ex) {
			return 0;
		}
	}
	
}
