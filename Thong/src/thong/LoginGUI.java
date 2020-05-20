package Thong;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Thong.Account;
import Thong.EmployeeFormGUI;
import Thong.DAO;

public class LoginGUI extends DAO<Account> {

	/* instance's variables */
	private JFrame frame;
	private JTextField txtTenTaiKhoan;
	private JPasswordField pwMatKhau;
	private JButton btnDangNhap;
	Map<String, Account> accountHashMap = new HashMap<String, Account>(); // we should user hash map because of searching frequency and we do not care about the order of account
	
	// some strings that hold the path for saving/reading
	private String fileName;
	private String savePath;
	private String loadPath;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath + this.fileName;
	}

	public String getLoadPath() {
		return loadPath;
	}

	public void setLoadPath(String loadPath) {
		this.loadPath = loadPath + this.fileName;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		// set the save/open path to user's desktop 
		setFileName("Account_HashMap.dat");
		setSavePath(System.getProperty("user.home") + "/Desktop/");
		setLoadPath(System.getProperty("user.home") + "/Desktop/");
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		/* we create an default account */
		Account admin = new Account("admin", "123");
		accountHashMap.put(admin.getUsername(), admin);
		this.save(savePath);
		this.load(loadPath);
		
		frame = new JFrame("Quản lý nhân viên");
		frame.setBounds(100, 100, 450, 183);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Đăng nhập", SwingConstants.CENTER);
		lblTitle.setForeground(new Color(34, 139, 34));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblTitle.setBounds(10, 11, 414, 29);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblTenTaiKhoan = new JLabel("Tên tài khoản");
		lblTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenTaiKhoan.setBounds(10, 52, 99, 14);
		frame.getContentPane().add(lblTenTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMatKhau.setBounds(10, 83, 99, 14);
		frame.getContentPane().add(lblMatKhau);
		
		txtTenTaiKhoan = new JTextField();
		txtTenTaiKhoan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					btnDangNhap.doClick();
				}
			}
		});
		txtTenTaiKhoan.setBounds(119, 51, 305, 20);
		frame.getContentPane().add(txtTenTaiKhoan);
		txtTenTaiKhoan.setColumns(10);
		
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// we get the password array of characters and build them to a whole string
				char[] passwordArray = pwMatKhau.getPassword();
				StringBuilder passwordUnited = new StringBuilder();
				
				for (int i = 0; i < passwordArray.length; i++) {
					passwordUnited.append(passwordArray[i]);
				}
				
				// we store username string and password string into variables
				String username = txtTenTaiKhoan.getText();
				String password = passwordUnited.toString();
				
				// then we search in the map by key value (which is username)				
				if (accountHashMap.containsKey(username)) {
					// if we find the key, then we search for the password
					if (accountHashMap.get(username).doesPasswordEqual(password)) {
						JOptionPane.showMessageDialog(frame, "Đăng nhập thành công");
						
						// after successfully login, we open the EmployeeFormGUI from package ps08464_form_gui, then release memory for this form 
						EmployeeFormGUI managerWindow = new EmployeeFormGUI();
						managerWindow.main(null);
						frame.dispose();
					}
					// we inform user if password is wrong
					else {
						JOptionPane.showMessageDialog(frame, "Mật khẩu sai");
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Không tồn tại tài khoản này");
				}
			}
		});
		btnDangNhap.setBackground(new Color(0, 100, 0));
		btnDangNhap.setForeground(new Color(230, 230, 250));
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDangNhap.setBounds(288, 113, 136, 23);
		frame.getContentPane().add(btnDangNhap);
		
		pwMatKhau = new JPasswordField();
		pwMatKhau.setBounds(119, 82, 305, 20);
		pwMatKhau.setEchoChar('*');
		pwMatKhau.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					btnDangNhap.doClick();
				}
			}
		});
		frame.getContentPane().add(pwMatKhau);
	}

	@Override
	public void save(String path) {
		ObjectOutputStream oos;

		/* program */
		try {
			oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(accountHashMap);
			oos.close();
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	// end of save 
	
	@Override
	public void load(String path) {
		/* variables */
		ObjectInputStream ois;
		
		/* program */
		try {
			ois = new ObjectInputStream(new FileInputStream(path));
			accountHashMap = (HashMap<String, Account>) ois.readObject();
			ois.close();
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	// end of load
	
	@Override
	public void update(Account entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account find(Serializable username) {
		return null;
	}
}
