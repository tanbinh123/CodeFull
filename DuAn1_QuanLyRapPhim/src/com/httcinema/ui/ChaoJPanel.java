package com.httcinema.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import com.httcinema.custom_jcomponents.theme.Theme;

@SuppressWarnings("serial")
public class ChaoJPanel extends JPanel {
	
	private JProgressBar progressBar;
	/**
	 * Create the panel.
	 */
	public ChaoJPanel() {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 0));
		progressBar.setBorder(null);
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(Theme.green);
		progressBar.setStringPainted(true);
		progressBar.setBounds(0, 217, 414, 9);
		add(progressBar);
		
		JLabel lblChao = new JLabel("");
		lblChao.setIcon(new ImageIcon(ChaoJPanel.class.getResource("/com/httcinema/icon/welcome-label-2.png")));
		lblChao.setHorizontalAlignment(SwingConstants.CENTER);
		lblChao.setBounds(0, 0, 414, 190);
		add(lblChao);

	}
	
	private int i = 0;
	private Timer timer;
	public void load(JFrame owner, JFrame appearer) {
		timer = new Timer(22, new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				if (i == 100) {
					timer.stop();
					appearer.setVisible(true);
					owner.dispose();
				}
				progressBar.setValue(i);
				i++;
			}
		});
		
		timer.start();
	}
}
