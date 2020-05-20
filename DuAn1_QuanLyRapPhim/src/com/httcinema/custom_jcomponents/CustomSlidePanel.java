/**
 * @author: Dinh Dat Thong
 * */

package com.httcinema.custom_jcomponents;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class CustomSlidePanel extends JPanel {
	private CardLayout cardLayout = new CardLayout(0, 0);

	public CustomSlidePanel() {
		this.setLayout(cardLayout);
		this.setBorder(null);
	}

	private Timer timerNextComponentSlide;

	public void nextPanel(Component panel) {
		if (timerNextComponentSlide != null) {
			timerNextComponentSlide.stop();
			timerNextComponentSlide = null;
		}

		cardLayout.show(CustomSlidePanel.this, panel.getName());
		int oldWidth = panel.getWidth();

		panel.setBounds(0, panel.getLocation().y, 0, panel.getHeight());

		timerNextComponentSlide = new Timer(0, new ActionListener() {
			int width = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (width >= oldWidth) {
					timerNextComponentSlide.stop();
					timerNextComponentSlide = null;
				}

				panel.setSize(width, panel.getHeight());

				CustomSlidePanel.this.repaint();
				width += 15;
			}
		});
		timerNextComponentSlide.start();
	}

	public void refresh() {
		this.repaint();
		this.revalidate();
	}
}