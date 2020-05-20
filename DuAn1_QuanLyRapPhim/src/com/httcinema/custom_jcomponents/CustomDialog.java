/**
 * A dialog that can create a glass for its parent and can fade in/out
 * 
 * author: Dinh Dat Thong
 * version: 2.0
 * */

package com.httcinema.custom_jcomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import com.httcinema.custom_jcomponents.theme.Theme;
import com.httcinema.helper.ShareHelper;

public class CustomDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1232633236007054479L;
	
	private final JPanel pnlChinh = new JPanel();
	public static final int SUCCESS = 0;
	public static final int ERROR = 1;
	public static final int WARNING = 2;
	public static final int INFORMATION = 3;
	public static final int CONFIRM = 4;
	
	public static final int YES_OPTION = 5;
	public static final int NO_OPTION = 6;
	
	private int value;
	
	private CustomButton btnDongY;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			try {
//				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//				UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 18));
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} catch (InstantiationException e) {
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			} catch (UnsupportedLookAndFeelException e) {
//				e.printStackTrace();
//			}
//			
//			CustomDialog.showDialog(null, "Câu hỏi", "Bạn có muốn thoát không", CustomDialog.CONFIRM);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public CustomDialog(Frame owner) {
		super(owner);
		setModal(true);
		setUndecorated(true);
	}
	
	public CustomDialog(Dialog owner) {
		super(owner);
		setModal(true);
		setUndecorated(true);
	}
	
	public CustomDialog(Window owner) {
		super(owner);
		setModal(true);
		setUndecorated(true);
	}
	
	public CustomDialog() {
		init(null, "Tiêu đề hiện ở đây", "Các thông báo hiện ở đây", INFORMATION);
	}
	
	public static int showDialog(Component owner, String tieuDe, String thongBao, int trangThai) {
		CustomDialog dialog;
		if (owner instanceof JDialog) {
			dialog = new CustomDialog((Dialog) owner);
		}
		else if (owner instanceof Frame) {
			dialog = new CustomDialog((Frame) owner);
		}
		else {
			dialog = new CustomDialog((Window) owner);
		}
		
		dialog.init(owner, tieuDe, thongBao, trangThai);
		dialog.setLocationRelativeTo(owner);
		dialog.fadeIn(dialog);
		return dialog.value;
	}
	
	public static int showDialog(Dialog owner, String tieuDe, String thongBao, int trangThai) {
		CustomDialog dialog = new CustomDialog(owner);
		dialog.init(owner, tieuDe, thongBao, trangThai);
		dialog.setLocationRelativeTo(owner);
		dialog.fadeIn(dialog);
		return dialog.value;
	}
	
	private int tx, ty;
	private String bieuTuong;
	
	/**
	 * Create the dialog.
	 */
	public void init(Component owner, String tieuDe, String thongBao, int trangThai) {
		if (trangThai == SUCCESS) {
			bieuTuong = "dialog_icon/dialog-icon-success.png";
		}
		else if (trangThai == ERROR) {
			bieuTuong = "dialog_icon/dialog-icon-error.png";
		}
		else if (trangThai == WARNING) {
			bieuTuong = "dialog_icon/dialog-icon-warning.png";
		}
		else if (trangThai == INFORMATION) {
			bieuTuong = "dialog_icon/dialog-icon-information.png";
		}
		else {
			bieuTuong = "dialog_icon/dialog-icon-confirm.png";
		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 394);
		getContentPane().setLayout(new BorderLayout());
		setDraggable(true);
		pnlChinh.setBackground(Color.WHITE);
		pnlChinh.setBorder(new LineBorder(new Color(46, 158, 158)));
		getContentPane().add(pnlChinh, BorderLayout.CENTER);
		pnlChinh.setLayout(null);
		
		JLabel lblBieuTuong = new JLabel("");
		lblBieuTuong.setHorizontalAlignment(SwingConstants.CENTER);
		lblBieuTuong.setIcon(new ImageIcon(CustomDialog.class.getResource(bieuTuong)));
		lblBieuTuong.setBounds(10, 11, 530, 140);
		pnlChinh.add(lblBieuTuong);
		
		JLabel lblTieuDe = new JLabel("");
		lblTieuDe.setForeground(Theme.dark);
		lblTieuDe.setFont(new Font("Calibri", Font.BOLD, 40));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setBounds(10, 162, 530, 76);
		lblTieuDe.setText(tieuDe);
		pnlChinh.add(lblTieuDe);
		
		JLabel lblThongBao = new JLabel("");
		lblThongBao.setForeground(Theme.dark);
		lblThongBao.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblThongBao.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongBao.setBounds(10, 249, 530, 45);
		lblThongBao.setText(thongBao);
		pnlChinh.add(lblThongBao);

		if (trangThai == CONFIRM) {
			CustomButton btnCo = new CustomButton("Có");
			Theme.setDefaultButtonFormat(btnCo);
			btnCo.setBackground(new Color(13, 94, 94));
			btnCo.setHoverBackground(Theme.buttonHoverBackground);
			btnCo.setBounds(110, 314, 150, 45);
			btnCo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					value = YES_OPTION;
					fadeOut();
				}
			});
			pnlChinh.add(btnCo);
			
			CustomButton btnKhong = new CustomButton("Không");
			Theme.setDefaultButtonFormat(btnKhong);
			btnKhong.setHoverBackground(Color.BLACK);
			btnKhong.setBounds(290, 314, 150, 45);
			btnKhong.setFocusable(true);
			btnKhong.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					value = NO_OPTION;
					fadeOut();
				}
			});
			pnlChinh.add(btnKhong);
			
			btnKhong.requestFocus();
		}
		else {
			btnDongY = new CustomButton("Đồng ý");
			btnDongY.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					fadeOut();
				}
			});
			Theme.setDefaultButtonFormat(btnDongY);
			btnDongY.setBounds(175, 314, 200, 45);
			btnDongY.setHoverBackground(Theme.buttonHoverBackground);
			pnlChinh.add(btnDongY);
			
			ShareHelper.addKeyBind(pnlChinh, "pressed ENTER", btnDongYClick, "btnDongY");
		}
	}
	
	/**
	 * This object is used for handles CTRL + W pressed event
	 * */
	@SuppressWarnings("serial")
	private Action btnDongYClick = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnDongY.doClick();
		}
	};
	
	/**
     * Creates an animation to fade the dialog opacity from 0 to 1.
     */
	public void fadeIn(final JDialog dialog) {
        final Timer timer = new Timer(20, null);
        timer.setRepeats(true);
        timer.addActionListener(new ActionListener() {
            private float opacity = 0;
            @Override public void actionPerformed(ActionEvent e) {
                opacity += 0.1f;
                dialog.setOpacity(Math.min(opacity, 1));
                if (opacity >= 1) timer.stop();
            }
        });

        dialog.setOpacity(0);
        timer.start();
        ((CustomDialog) dialog).disableParentFrame(true);
        dialog.setVisible(true);
    }
	
	public void setDraggable(boolean value) {
		if (value) {
			addMouseListener(mouseAdapter);
			addMouseMotionListener(mouseMotionAdapter);
		}
		else {
			removeMouseListener(mouseAdapter);
			removeMouseMotionListener(mouseMotionAdapter);
		}
	}
	
	/**
     * Creates an animation to fade the dialog opacity from 1 to 0.
     */
    public void fadeOut() {
        final Timer timer = new Timer(20, null);
        timer.setRepeats(true);
        timer.addActionListener(new ActionListener() {
            private float opacity = 1;
            @Override public void actionPerformed(ActionEvent e) {
                opacity -= 0.1f;
                setOpacity(Math.max(opacity, 0));
                if (opacity <= 0) {
                    timer.stop();
                    dispose();
                }
            }
        });

        setOpacity(1);
        getOwner().setOpacity(1);
        disableParentFrame(false);
        timer.start();
    }
    
    private JDialog pnlDisable;
    
	/**
	 * Làm mờ frame cha
	 * */
    private void disableParentFrame(boolean value) {
    	if (value == false) {
    		pnlDisable.dispose();
    		return;
    	}
    	
    	JFrame frame;
    	JDialog dialog;
    	if (getOwner() instanceof JFrame) {
    		frame = (JFrame) getOwner();
    		pnlDisable = new JDialog(frame);
    		pnlDisable.setBounds(frame.getLocation().x, frame.getLocation().y, frame.getWidth(), frame.getHeight());
    	}
    	else {
    		dialog = (JDialog) getOwner();
    		pnlDisable = new JDialog(dialog);
    		pnlDisable.setBounds(dialog.getLocation().x, dialog.getLocation().y, dialog.getWidth(), dialog.getHeight());
    	}
		pnlDisable.setUndecorated(true);
		pnlDisable.setBackground(new Color(0, 0, 0, 150));
		pnlDisable.setVisible(true);
		
	}
    
    protected void enabledCloseWhenLostFocus() {
    	setModal(false);
		addWindowFocusListener(windowListener);
    }
    
    /**
     * Các đối tượng xử lý sự kiện
     * */
    protected MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent m) {
			tx = m.getX();
			ty = m.getY();
			Cursor cursor = new Cursor(Cursor.MOVE_CURSOR);
			setCursor(cursor);
		}
		
		@Override
		public void mouseReleased(MouseEvent m) {
			Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
			setCursor(cursor);
		}

	};
	
	protected MouseMotionAdapter mouseMotionAdapter = new MouseMotionAdapter() {
		@Override
		public void mouseDragged(MouseEvent m) {
			setLocation(m.getXOnScreen() - tx, m.getYOnScreen() - ty);
		}
	};
	
	protected WindowFocusListener windowListener = new WindowFocusListener() {            
	    public void windowLostFocus(WindowEvent e) {
	        fadeOut();
	    }            
	    public void windowGainedFocus(WindowEvent e) {
	    	
	    }
	};
}
