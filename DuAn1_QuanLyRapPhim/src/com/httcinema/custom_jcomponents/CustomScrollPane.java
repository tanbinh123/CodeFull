/**
 * @author: Dinh Dat Thong
 * */

package com.httcinema.custom_jcomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import com.httcinema.custom_jcomponents.theme.Theme;

@SuppressWarnings("serial")
public class CustomScrollPane extends JScrollPane {

	@SuppressWarnings("rawtypes")
	public CustomScrollPane(JList list, int verticalState, int horizontalState) {
		super(list, verticalState, horizontalState);
		setBackground(Color.WHITE);
		getHorizontalScrollBar().setUnitIncrement(9);
		getVerticalScrollBar().setUnitIncrement(9);
		
		JPanel panel = new JPanel();
		panel.setBackground(Theme.headerBackgroundColor);
		setCorner(CustomScrollPane.UPPER_RIGHT_CORNER, panel);
		
		setComponentZOrder(getHorizontalScrollBar(), 0);
		setComponentZOrder(getVerticalScrollBar(), 0);
		setComponentZOrder(getViewport(), 1);
		
		getHorizontalScrollBar().setOpaque(false);
		getVerticalScrollBar().setOpaque(false);
		
		getHorizontalScrollBar().setUI(new MyHorizontalScrollBarUI());
		getVerticalScrollBar().setUI(new MyVerticalScrollBarUI());
	}
	
	public CustomScrollPane() {
		super();
		setBackground(Color.WHITE);
		getHorizontalScrollBar().setUnitIncrement(9);
		getVerticalScrollBar().setUnitIncrement(9);
		
		JPanel panel = new JPanel();
		panel.setBackground(Theme.headerBackgroundColor);
		setCorner(CustomScrollPane.UPPER_RIGHT_CORNER, panel);
		
		setComponentZOrder(getHorizontalScrollBar(), 0);
		setComponentZOrder(getVerticalScrollBar(), 0);
		setComponentZOrder(getViewport(), 1);
		
		getHorizontalScrollBar().setOpaque(false);
		getVerticalScrollBar().setOpaque(false);
		
		getHorizontalScrollBar().setUI(new MyHorizontalScrollBarUI());
		getVerticalScrollBar().setUI(new MyVerticalScrollBarUI());
		
	}

	private class MyVerticalScrollBarUI extends BasicScrollBarUI {
		private final Dimension d = new Dimension();

		@Override
		protected JButton createDecreaseButton(int orientation) {
			return new JButton() {
				@Override
				public Dimension getPreferredSize() {
					return d;
				}
			};
		}

		@Override
		protected JButton createIncreaseButton(int orientation) {
			return new JButton() {
				@Override
				public Dimension getPreferredSize() {
					return d;
				}
			};
		}

		@Override
		protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setPaint(new Color(0, 0, 0, 0));
//			g2.setPaint(Theme.dark);
			g2.fillRect(r.x, r.y, r.width, r.height);
		}

		@Override
		protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			Color color = null;
			JScrollBar sb = (JScrollBar) c;
			if (!sb.isEnabled()) {
				return;
			} else if (isDragging) {
				color = new Color(29, 122, 122);
			} else if (isThumbRollover()) {
				color = new Color(75, 184, 184);
			} else {
				color = Theme.green;
			}
			g2.setPaint(color);
			g2.fillRoundRect(r.x + 3, r.y, 11, r.height, 10, 10);
			g2.dispose();
		}

		@Override
		protected void setThumbBounds(int x, int y, int width, int height) {
			super.setThumbBounds(x, y, width, height);
			scrollbar.repaint();
		}
	}
	
	private class MyHorizontalScrollBarUI extends MyVerticalScrollBarUI {
		@Override
		protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			Color color = null;
			JScrollBar sb = (JScrollBar) c;
			if (!sb.isEnabled()) {
				return;
			} else if (isDragging) {
				color = new Color(29, 122, 122);
			} else if (isThumbRollover()) {
				color = new Color(75, 184, 184);
			} else {
				color = Theme.green;
			}
			g2.setPaint(color);
			
			g2.fillRoundRect(r.x, r.y + 3, r.width, 11, 10, 10);
			g2.dispose();
		}
	}
}
