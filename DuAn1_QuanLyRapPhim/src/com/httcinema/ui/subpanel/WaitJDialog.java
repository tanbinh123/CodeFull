package com.httcinema.ui.subpanel;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.httcinema.custom_jcomponents.CustomDialog;
import com.httcinema.custom_jcomponents.theme.Theme;

@SuppressWarnings("serial")
public class WaitJDialog extends CustomDialog {

	private JLabel lblTieuDe;
	
	public WaitJDialog(Frame owner) {
		super(owner);
		init();
		setLocationRelativeTo(owner);
	}
	
	public WaitJDialog(Dialog owner) {
		super(owner);
		init();
		setLocationRelativeTo(owner);
	}
	
	public WaitJDialog(Window owner) {
		super(owner);
		init();
		setLocationRelativeTo(owner);
	}
	
	public WaitJDialog() {
		setUndecorated(true);
		init();
		setLocationRelativeTo(null);
	}
	
	/**
	 * Create the dialog.
	 */
	public void init() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 335, 190);
		getContentPane().setLayout(null);
		setUndecorated(true);
		
		JPanel pnlChinh = new JPanel();
		pnlChinh.setBorder(new LineBorder(Color.WHITE));
		pnlChinh.setBackground(Theme.white);
		pnlChinh.setBounds(0, 0, 335, 190);
		getContentPane().add(pnlChinh);
		pnlChinh.setLayout(null);
		
		lblTieuDe = new JLabel("Vui lòng chờ .......");
		lblTieuDe.setForeground(Theme.dark);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setBounds(10, 32, 315, 30);
		pnlChinh.add(lblTieuDe);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(WaitJDialog.class.getResource("/com/httcinema/icon/icon-wait.gif")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 73, 315, 106);
		pnlChinh.add(label);
	}
}
