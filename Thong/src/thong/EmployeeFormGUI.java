/**
 * This program shows a window GUI
 * if any data is missing or wrong format, its text fields will be surrounded by a red border.
 * It uses many other classes to support it, those classes are located in the same project
 * 
 * @author: Dinh Dat Thong
 * @version: 1.0
 * */

package Thong;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Thong.DAO;
import thong.Employee;

public class EmployeeFormGUI extends DAO<Employee> {

	/* instance's variables */
	// windows
	private JFrame frmQuanLyNhanVien;
	
	// text fields
	private JTextField txtMaNhanVien;
	private JTextField txtHoVaTen;
	private JTextField txtTuoi;
	private JTextField txtEmail;
	private JTextField txtLuong;
	
	// labels
	private JLabel lblDongHo;
	private JLabel lblTrangThai;
	
	// buttons
	private JButton btnNew;
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnFind;
	private JButton btnOpen;
	private JButton btnExit;
	
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	
	// tables
	private JTable tblNhanVien;
	
	// general colors
	private Color overallColor = new Color(232, 242, 241);
	private Color buttonColor = new Color(12, 137, 75);
	private Color buttonTextColor = new Color(255, 255, 255);
	private Color mainLabelColor = new Color(11, 96, 93);
	
	// some strings that hold the path for saving/reading
	private String fileName;
	private String savePath;
	private String loadPath;
	
	// some values indicates the state of this state-machine
	private String errorFilePathMessage;
	private boolean newEmployee = true;
	
	//  some variables help us keep track of some restriction
	private int indexOfCurrentEmployee;
	private final int MIN_AGE = 16;
	private final int MAX_AGE = 55;
	
	/* constructors */
	public EmployeeFormGUI() {
		initializeComponents();
	}
	
	/* setters */
	public void setFileName(String fileName) {
		this.fileName = fileName;
		this.errorFilePathMessage = "Đường dẫn sai hoặc tệp tin " + this.fileName + " không tồn tại";
	}
	
	public void setSavePath(String savePath) {
		this.savePath = savePath + this.fileName;
	}
	
	public void setReadPath(String readPath) {
		this.loadPath = readPath + this.fileName;
	}
	
	/* class's methods */
	// 1 - main method
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFormGUI window = new EmployeeFormGUI();
					
					// turn on the clock
					window.clockOn(window.lblDongHo);
					
					// set the save/open path to user's desktop 
					window.setFileName("Employee_List.dat");
					window.setSavePath(System.getProperty("user.home") + "/Desktop/");
					window.setReadPath(System.getProperty("user.home") + "/Desktop/");
					
					// ask user if he/she wants to save file before exit
					window.frmQuanLyNhanVien.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							if (JOptionPane.showConfirmDialog(null, "Bạn muốn lưu file tại Desktop không?", "THÔNG BÁO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								// yes option
								window.save(window.savePath);
								System.exit(0);
							} else {
							    // no option
								System.exit(0);
							}
						}
					});
					window.frmQuanLyNhanVien.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// end of main
	
	/* instance methods */
	// 1 - this method is called by constructor of this class, it initializes GUI components in window
	private void initializeComponents() {
		/* window */
		frmQuanLyNhanVien = new JFrame();
		frmQuanLyNhanVien.getContentPane().setBackground(overallColor);
		frmQuanLyNhanVien.setTitle("Quản lý nhân viên");
		frmQuanLyNhanVien.setSize(740, 550);
		frmQuanLyNhanVien.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmQuanLyNhanVien.setLocationRelativeTo(null);
		frmQuanLyNhanVien.getContentPane().setLayout(null);
		/* end of window */
		
		/* labels */
		JLabel lblQuanLyNhanVien = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblQuanLyNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuanLyNhanVien.setForeground(mainLabelColor);
		lblQuanLyNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLyNhanVien.setBounds(10, 11, 572, 40);
		frmQuanLyNhanVien.getContentPane().add(lblQuanLyNhanVien);
		
		lblDongHo = new JLabel("00:00 AM", SwingConstants.CENTER);
		lblDongHo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDongHo.setForeground(mainLabelColor);
		lblDongHo.setBounds(625, 477, 89, 23);
		frmQuanLyNhanVien.getContentPane().add(lblDongHo);
		
		lblTrangThai = new JLabel("Record: 0 of 0");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTrangThai.setForeground(mainLabelColor);
		lblTrangThai.setBounds(352, 258, 230, 23);
		frmQuanLyNhanVien.getContentPane().add(lblTrangThai);
		
		JLabel lblMaNhanVien = new JLabel("MÃ NHÂN VIÊN", SwingConstants.RIGHT);
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaNhanVien.setBounds(10, 81, 112, 24);
		frmQuanLyNhanVien.getContentPane().add(lblMaNhanVien);
		
		JLabel lblHoVaTen = new JLabel("HỌ VÀ TÊN", SwingConstants.RIGHT);
		lblHoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoVaTen.setBounds(10, 116, 112, 24);
		frmQuanLyNhanVien.getContentPane().add(lblHoVaTen);
		
		JLabel lblTuoi = new JLabel("TUỔI", SwingConstants.RIGHT);
		lblTuoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTuoi.setBounds(10, 151, 112, 24);
		frmQuanLyNhanVien.getContentPane().add(lblTuoi);
		
		JLabel lblEmail = new JLabel("EMAIL", SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 186, 112, 24);
		frmQuanLyNhanVien.getContentPane().add(lblEmail);
		
		JLabel lblLuong = new JLabel("LƯƠNG", SwingConstants.RIGHT);
		lblLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuong.setBounds(10, 221, 112, 24);
		frmQuanLyNhanVien.getContentPane().add(lblLuong);
		/* end of labels */
		
		/* text fields */
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setBounds(132, 83, 450, 24);
		frmQuanLyNhanVien.getContentPane().add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setToolTipText("Mã nhân viên phải theo cú pháp: NV00, NV0123, NV1, ...");
		
		txtHoVaTen = new JTextField();
		txtHoVaTen.setBounds(132, 118, 450, 24);
		frmQuanLyNhanVien.getContentPane().add(txtHoVaTen);
		txtHoVaTen.setColumns(10);
		txtHoVaTen.setToolTipText("Họ tên không chứa chữ số");
		
		txtTuoi = new JTextField();
		txtTuoi.setBounds(132, 153, 450, 24);
		frmQuanLyNhanVien.getContentPane().add(txtTuoi);
		txtTuoi.setColumns(10);
		txtTuoi.setToolTipText("Độ tuổi phải theo quy định của công ty");
		
		txtEmail = new JTextField();
		txtEmail.setBounds(132, 188, 450, 24);
		frmQuanLyNhanVien.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setToolTipText("Ví dụ: abc123@gmail.com");
		
		txtLuong = new JTextField();
		txtLuong.setBounds(132, 223, 450, 24);
		frmQuanLyNhanVien.getContentPane().add(txtLuong);
		txtLuong.setColumns(10);
		txtLuong.setToolTipText("Đơn vị là triệu, lương phải trên 5 triệu");
		/* end of text fields */

		/* buttons */
		// **************************************************************************************************** BUTTON NEW
		btnNew = new JButton("New");
		btnNew.setForeground(buttonTextColor);
		btnNew.setBackground(buttonColor);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				newEmployee = true;
				clearForm();
				indexOfCurrentEmployee = -1;
				setState();
			}
		});
		btnNew.setBounds(625, 84, 89, 23);
		btnNew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frmQuanLyNhanVien.getContentPane().add(btnNew);
		
		// **************************************************************************************************** BUTTON SAVE
		btnSave = new JButton("Save");
		btnSave.setForeground(buttonTextColor);
		btnSave.setBackground(buttonColor);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// we check if user has already clicked new button 
				if (newEmployee == true) {
					
					// then we check for the wholeness and the validness of data
					if (isNotEnough() || isNotValid()) {
						return;
					}
					else {
						// we create an object to hold data
						Employee employee = new Employee();
						
						// we pass data to that object
						employee.setID(txtMaNhanVien.getText().trim());
						employee.setFullName(txtHoVaTen.getText().trim());
						employee.setAge(Integer.parseInt(txtTuoi.getText().trim()));
						employee.setEmail(txtEmail.getText().trim());
						employee.setSalary(Double.parseDouble(txtLuong.getText().trim()));
						
						// ID should not be repeated
						if (find(employee.getID()) == null) {
							list.add(employee);
						}
						else {
							JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Trùng lặp mã nhân viên\nVui lòng chọn mã khác", "CẢNH BÁO", JOptionPane.WARNING_MESSAGE);
						}
						
						// we add the object to table
						fillToTable();
						setState();
					}
				}
				else {
					// then we check for the wholeness and the validness of data
					if (isNotEnough() || isNotValid()) {
						return;
					}
					else {
						// we create an object to hold data
						Employee employee = new Employee();
						
						// we pass data to that object
						employee.setID(txtMaNhanVien.getText().trim());
						employee.setFullName(txtHoVaTen.getText().trim());
						employee.setAge(Integer.parseInt(txtTuoi.getText().trim()));
						employee.setEmail(txtEmail.getText().trim());
						employee.setSalary(Double.parseDouble(txtLuong.getText().trim()));
						
						// ID should exist
						if (find(employee.getID()) == null) {
							JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Không tìm thấy nhân viên có mã này", "CẢNH BÁO", JOptionPane.WARNING_MESSAGE);
							return;
						}
						else {
							update(employee);
						}
						
						// we add the object to table
						fillToTable();
						setState();
					}
				}
			}
		});
		btnSave.setBounds(625, 119, 89, 23);
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frmQuanLyNhanVien.getContentPane().add(btnSave);
		
		// **************************************************************************************************** BUTTON DELETE
		btnDelete = new JButton("Delete");
		btnDelete.setForeground(buttonTextColor);
		btnDelete.setBackground(buttonColor);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// set the state of new button
				newEmployee = false;
				
				// we check for the valid ID
				if (isNotID() == true) {
					return;
				}
				
				// find the employee based on his/her ID
				Employee employee = find(txtMaNhanVien.getText().trim());
				
				// check if we can not find him/her
				if (employee == null) {
					JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Không tồn tại nhân viên có mã này");
				}
				else {
					list.remove(employee);
					JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Đã xóa thành công");
					clearForm();
					indexOfCurrentEmployee = -1;
					fillToTable();
					setState();
				}
			}
		});
		btnDelete.setBounds(625, 154, 89, 23);
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frmQuanLyNhanVien.getContentPane().add(btnDelete);
		
		// **************************************************************************************************** BUTTON OPEN
		btnOpen = new JButton("Open");
		btnOpen.setForeground(buttonTextColor);
		btnOpen.setBackground(buttonColor);
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// set the state of new button
				newEmployee = false;
				
				// we load file from the pre-defined path
				try {
					load(loadPath);
					fillToTable();
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(frmQuanLyNhanVien, errorFilePathMessage);
				}
				
				// bring data of the first employee to the text fields
				if (list.size() > 0) {
					indexOfCurrentEmployee = 0;
					showDetail();
				}
				else {
					indexOfCurrentEmployee = -1;
					clearForm();
				}
				setState();
			}
		});
		btnOpen.setBounds(625, 224, 89, 23);
		btnOpen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frmQuanLyNhanVien.getContentPane().add(btnOpen);

		// **************************************************************************************************** BUTTON FIND
		btnFind = new JButton("Find");
		btnFind.setForeground(buttonTextColor);
		btnFind.setBackground(buttonColor);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// set the state of new button
				newEmployee = false;
				
				// we check for the valid ID
				if (isNotID() == true) {
					return;
				}
				
				// find the employee based on his/her ID
				Employee employee = find(txtMaNhanVien.getText().trim());
				
				// check if we can not find him/her
				if (employee == null) {
					JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Không tồn tại nhân viên có mã này");
				}
				else {
					txtMaNhanVien.setText(employee.getID());
					txtHoVaTen.setText(employee.getFullName());
					txtTuoi.setText(employee.getAge() + "");
					txtEmail.setText(employee.getEmail());
					txtLuong.setText(employee.getSalary() + "");
				}
				setState();
			}
		});
		btnFind.setBounds(625, 189, 89, 23);
		btnFind.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frmQuanLyNhanVien.getContentPane().add(btnFind);
		
		// **************************************************************************************************** BUTTON EXIT
		btnExit = new JButton("Exit");
		btnExit.setForeground(buttonTextColor);
		btnExit.setBackground(buttonColor);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (JOptionPane.showConfirmDialog(null, "Bạn muốn lưu file tại Desktop không?", "THÔNG BÁO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					// yes option
					save(savePath);
					System.exit(0);
				} else {
				    // no option
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(625, 260, 89, 23);
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frmQuanLyNhanVien.getContentPane().add(btnExit);
		
		// **************************************************************************************************** BUTTON FIRST
		btnFirst = new JButton("\u219F");
		btnFirst.setForeground(buttonTextColor);
		btnFirst.setBackground(buttonColor);
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// set the state of new button
				newEmployee = false;
				indexOfCurrentEmployee = 0;
				showDetail();
				setState();
			}
		});
		btnFirst.setBounds(352, 292, 50, 20);
		btnFirst.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frmQuanLyNhanVien.getContentPane().add(btnFirst);
		
		// **************************************************************************************************** BUTTON UP
		btnPrevious = new JButton("\u2191");
		btnPrevious.setForeground(buttonTextColor);
		btnPrevious.setBackground(buttonColor);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// set the state of new button
				newEmployee = false;
				
				if (indexOfCurrentEmployee > 0) {
					indexOfCurrentEmployee--;
					showDetail();
				}
				setState();
			}
		});
		btnPrevious.setBounds(412, 292, 50, 20);
		btnPrevious.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frmQuanLyNhanVien.getContentPane().add(btnPrevious);
		
		// **************************************************************************************************** BUTTON DOWN
		btnNext = new JButton("\u2193");
		btnNext.setForeground(buttonTextColor);
		btnNext.setBackground(buttonColor);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// set the state of new button
				newEmployee = false;
				
				if (indexOfCurrentEmployee < list.size() - 1) {
					indexOfCurrentEmployee++;
					showDetail();
				}
				setState();
			}
		});
		btnNext.setBounds(472, 292, 50, 20);
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frmQuanLyNhanVien.getContentPane().add(btnNext);
		
		// **************************************************************************************************** BUTTON LAST
		btnLast = new JButton("\u21A1");
		btnLast.setForeground(buttonTextColor);
		btnLast.setBackground(buttonColor);
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// set the state of new button
				newEmployee = false;
				indexOfCurrentEmployee = list.size() - 1;
				showDetail();
				setState();
			}
		});
		btnLast.setBounds(532, 292, 50, 20);
		btnLast.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frmQuanLyNhanVien.getContentPane().add(btnLast);
		/* end of buttons */
		
		/* tables */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 326, 572, 174);
		frmQuanLyNhanVien.getContentPane().add(scrollPane);
		
		tblNhanVien = new JTable();
		scrollPane.setViewportView(tblNhanVien);
		tblNhanVien.setColumnSelectionAllowed(true);
		tblNhanVien.setCellSelectionEnabled(true);
		tblNhanVien.setRowHeight(25);
		tblNhanVien.setGridColor(buttonColor);
		tblNhanVien.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"MÃ", "HỌ VÀ TÊN", "TUỔI", "EMAIL", "LƯƠNG"}
		) {
			// I just simply disable edit feature on all cells of table
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		});
		tblNhanVien.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent event) {
				indexOfCurrentEmployee = tblNhanVien.getSelectedRow();
				showDetail();
				setState();
			}

			@Override
			public void mouseEntered(MouseEvent event) {}

			@Override
			public void mouseExited(MouseEvent event) {}

			@Override
			public void mousePressed(MouseEvent event) {}

			@Override
			public void mouseReleased(MouseEvent event) {}
		});
		/* end of tables */
	}
	
	// 2 - this method return a right modiffied name
    public String toTitleCase(String string) {
    	/* variables */
        StringBuilder sb = new StringBuilder();
        boolean nextTitleCase = true;
        
        /* program */
        string = string.trim().replaceAll("( )+", " ");
        
        for (char c : string.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c) == false) {
                nextTitleCase = true;
            }
            else if (nextTitleCase == true) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }
            sb.append(c);
        }
        return sb.toString();
    }
	// end of toTitleCase
    
    // 3 - this method checks for the wholeness of input data
    public boolean isNotValid() {
    	// ****************************************************************************************************		
		// 1 - we check if ID is not valid
		if (isNotID()) {
			txtMaNhanVien.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return true;
		}
		txtMaNhanVien.setBorder(BorderFactory.createLineBorder(null, 0));
		
    	// ****************************************************************************************************		
		// 2 - we check if name is not valid
		if (isNotName()) {
			txtHoVaTen.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return true;
		}
		txtHoVaTen.setBorder(BorderFactory.createLineBorder(null, 0));
		
    	// ****************************************************************************************************		
		// 3 - we check if age is not valid
		if (isNotAge()) {
			txtTuoi.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return true;
		}
		txtTuoi.setBorder(BorderFactory.createLineBorder(null, 0));
		
    	// ****************************************************************************************************		
		// 4 - we check if email is not valid
		if (isNotEmail()) {
			txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return true;
		}
		txtEmail.setBorder(BorderFactory.createLineBorder(null, 0));
		
    	// ****************************************************************************************************		
		// 5 - we check if salary is not valid
		if (isNotSalary()) {
			txtLuong.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return true;
		}
		txtLuong.setBorder(BorderFactory.createLineBorder(null, 0));
    	
		return false;
    }
    // end of isNotValid
    
    // 4 - this method checks for the wholeness input data
    public boolean isNotEnough() {
    	// ****************************************************************************************************
    	// 1 - we check if user does not input ID
		if (txtMaNhanVien.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Bạn chưa nhập mã nhân viên");
			txtMaNhanVien.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return true;
		}
		txtMaNhanVien.setBorder(BorderFactory.createLineBorder(null, 1));
		
		// ****************************************************************************************************
    	// 2 - we check if user does not input name
		if (txtHoVaTen.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Bạn chưa nhập họ và tên");
			txtHoVaTen.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return true;
		}
		txtHoVaTen.setBorder(BorderFactory.createLineBorder(null, 1));
		
		// ****************************************************************************************************
    	// 3 - we check if user does not input age
		if (txtTuoi.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Bạn chưa nhập tuổi");
			txtTuoi.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return true;
		}
		txtTuoi.setBorder(BorderFactory.createLineBorder(null, 1));
		
		// ****************************************************************************************************
    	// 4 - we check if user does not input email
		if (txtEmail.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Bạn chưa nhập email");
			txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return true;
		}
		txtEmail.setBorder(BorderFactory.createLineBorder(null, 1));
		
		// ****************************************************************************************************
		// 5 - we check if user does not input salary
		if (txtLuong.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Bạn chưa nhập lương");
			txtLuong.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return true;
		}
		txtLuong.setBorder(BorderFactory.createLineBorder(null, 1));
		
		return false;
    }
    // end of isNotEnough
    
    // 5 - this method checks for the input format of ID, ID should follow the format "NV" plus one or more digits
    public boolean isNotID() {
    	if (txtMaNhanVien.getText().trim().matches("^(NV)[0-9]{1,}") == false) {			// NV0, NV001, NV000005, NV999846 are all valid
    		JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Mã nhân viên phải theo cú pháp: NV...\n... có thể thay bằng số từ 0 đến 9");
    		return true;
    	}
    	return false;
    }
    // end of isNotID
    
    // 6 - this method checks for the input format of name, name should not have any number
    public boolean isNotName() {
    	if (txtHoVaTen.getText().trim().matches(".*\\d+.*") == true) {
    		JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Tên không được chứa chữ số nào");
    		return true;
    	}
    	return false;
    }
    // end of isNotName
    
    // 7 - this method checks for the input format of age, age should be an integer and is larger than a min number and smaller than a max number 
    public boolean isNotAge() {
    	/* variables */
    	int age;
    	
    	/* program */
    	try {
    		age = Integer.parseInt(txtTuoi.getText().trim());
    	}
    	catch (Exception ex) {
    		JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Tuổi phải là số nguyên\nTuổi phải lớn hơn " + MIN_AGE + " và nhỏ hơn " + MAX_AGE);
    		return true;
    	}
    	
    	if (age < 18 || age > 60) {
    		JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Tuổi phải là số nguyên\nTuổi phải lớn hơn " + MIN_AGE + " và nhỏ hơn " + MAX_AGE);
    		return true;
    	}
    	
    	return false;
    }
    // end of isNotAge
    
    // 8 - this method checks for the input format of email, email should follow the general pattern
    public boolean isNotEmail() {
    	if (txtEmail.getText().trim().matches("^[a-z][a-z0-9_\\.]{2,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$") == false) {
    		JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Email không hợp lệ");
    		return true;
    	}
    	return false;
    }
    // end of isNotEmail
    
    // 9 - this method checks for the salary value
    public boolean isNotSalary() {
    	/* variables */
    	double salary;
    	double minSalary = 5;
    	
    	/* program */
		try {
			 salary = Double.parseDouble(txtLuong.getText().trim());
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Lương phải là số thực");
			return true;
		}
		
		if (salary < 0) {
			JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Lương phải là số thực dương");
			return true;
		}
		
		if (salary < minSalary) {
			JOptionPane.showMessageDialog(frmQuanLyNhanVien, "Lương phải trên " + minSalary + " triệu");
			return true;
		}
		
		return false;
    }
    // end of isNotSalary
        
    // 10 - this method show the data in the list to the table of the form
    private void fillToTable() {
    	/* variables */
    	DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
    	
    	/* program */
    	model.setRowCount(0);
    	for (Employee employee : list) {
    		Object[] row = new Object[] {
    				employee.getID(),
    				employee.getFullName(),
    				employee.getAge(),
    				employee.getEmail(),
    				employee.getSalary()
    		};
    		model.addRow(row);
    	}
    }
    // end of fillToTable
    
    // 11 - this method updates data of an object from the list
	@Override
	public void update(Employee employee) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID().equals(employee.getID())) {
				list.set(i, employee);
			}
		}
	}
	// end of update
	
	// 12 - this method finds an object from the list
	@Override
	public Employee find(Serializable id) {
		for (Employee employee : list) {
			if (employee.getID().equals(id)) {
				return employee;
			}
		}
		return null;
	}
	// end of find
	
	// 13 - this method turns on the clock and shows it to a JLabel object
	public void clockOn(JLabel label) {
		// we create a thread object and define run() method
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						// we get current time from system by create an object of type Date and set the pattern for time by an object of type SimpleDateFormat
						Date now = new Date();
						SimpleDateFormat formater = new SimpleDateFormat();
						
						// set the pattern for time format
						formater.applyPattern("hh:mm a");
						String time = formater.format(now);
						label.setText(time);
						
						// pause thread for 10 second
						Thread.sleep(1000);
					}
					catch (Exception ex) {}
				}
			}
		};
		
		// after having thread, we start that thread
		thread.start();
	}
	// end of clockOn
	
	// 14 - this method shows detail of employee to the text fields
	public void showDetail() {
		/* program */
		if (list.size() == 0) {
			return;
		}
		
		if (indexOfCurrentEmployee < 0) {
			return;
		}
		
		Employee employee = list.get(indexOfCurrentEmployee);
		
		// we just get data from object and show it to text fields
		txtMaNhanVien.setText(employee.getID());
		txtHoVaTen.setText(employee.getFullName());
		txtTuoi.setText(Integer.toString(employee.getAge()));
		txtEmail.setText(employee.getEmail());
		txtLuong.setText(Double.toString(employee.getSalary()));
	}
	// end of showDetail
	
	// 15 - this method clears all the text fields
	public void clearForm() {
		txtMaNhanVien.setText("");
		txtHoVaTen.setText("");
		txtTuoi.setText("");
		txtEmail.setText("");
		txtLuong.setText("");
	}	
	// end of clearForm
	
	// 16 - this method sets the state to the lblTrangThai
	public void setState() {
		lblTrangThai.setText("Record: " + (indexOfCurrentEmployee + 1) + " of " + list.size());
	}
	// end of setState
}