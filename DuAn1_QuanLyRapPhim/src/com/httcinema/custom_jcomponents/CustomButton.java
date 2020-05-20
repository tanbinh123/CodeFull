/**
 * A button with hover transition color foreground and background
 * 
 * @author: Dinh Dat Thong
 * @version: 3
 * */

package com.httcinema.custom_jcomponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class CustomButton extends JButton {
	
	public CustomButton() {
		super.setContentAreaFilled(false);
	}
	
	public CustomButton(String str) {
		super(str);
		super.setContentAreaFilled(false);
		setFocusable(false);
	}
	
	public CustomButton(Icon icon) {
		super(icon);
		super.setContentAreaFilled(false);
		setFocusable(false);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(getBackground());
        } else if (getModel().isRollover()) {
            g.setColor(getBackground());
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
	
	private Timer timerForeground;
	private Color oldForeground;
	
	private void transitionForeground(Color color, boolean state) {
		if (timerForeground != null) {
			timerForeground.stop();
			timerForeground = null;
		}
		
		timerForeground = new Timer(5, new ActionListener() {
			double diff = 60; // step
			double range = 60;
			
			Color from = getForeground();
			Color to = state ? color : oldForeground;
			
			public void actionPerformed(ActionEvent arg0) {
				if (diff == 0) {
					timerForeground.stop();
					timerForeground = null;
				}
				
				double ratio = diff / range; // goes from 1 to 0
				int red = (int) Math.abs((ratio * from.getRed()) + ((1 - ratio) * to.getRed()));
				int green = (int) Math.abs((ratio * from.getGreen()) + ((1 - ratio) * to.getGreen()));
				int blue = (int) Math.abs((ratio * from.getBlue()) + ((1 - ratio) * to.getBlue()));
				
				setForeground(new Color(red, green, blue));
				diff--;
				
			}
		});
		timerForeground.start();
	}
	
	private Timer timerBackground;
	private Color oldBackground;

	private void transitionBackground(Color color, boolean state) {
		if (timerBackground != null) {
			timerBackground.stop();
			timerBackground = null;
		}
		
		timerBackground = new Timer(5, new ActionListener() {
			double diff = 60; // step
			double range = 60;
			
			Color from = getBackground();
			Color to = state ? color : oldBackground;
			
			public void actionPerformed(ActionEvent arg0) {
				if (diff == 0) {
					timerBackground.stop();
					timerBackground = null;
				}
				
				double ratio = diff / range; // goes from 1 to 0
				int red = (int) Math.abs((ratio * from.getRed()) + ((1 - ratio) * to.getRed()));
				int green = (int) Math.abs((ratio * from.getGreen()) + ((1 - ratio) * to.getGreen()));
				int blue = (int) Math.abs((ratio * from.getBlue()) + ((1 - ratio) * to.getBlue()));
				
				setBackground(new Color(red, green, blue));
				diff--;
				
			}
		});
		timerBackground.start();
	}
	
	
	/*
	 * user's methods. These three methods should be called after setForeground/setBackground
	 * */
	
	/**
	 * Only foreground color will change
	 * */
	public void setHoverForeground(Color color) {
		oldForeground = getForeground();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				transitionForeground(color, true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				transitionForeground(color, false);
			}
		});
	}
	
	/**
	 * Only background color will change
	 * */
	public void setHoverBackground(Color color) {
		oldBackground = getBackground();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				transitionBackground(color, true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				transitionBackground(color, false);
			}
		});
	}
	
	/**
	 * Both foreground and background color will change
	 * */
	public void setHoverForeAndBackground(Color colorFore, Color colorBack) {
		oldForeground = getForeground();
		oldBackground = getBackground();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				transitionForeground(colorFore, true);
				transitionBackground(colorBack, true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				transitionForeground(colorFore, false);
				transitionBackground(colorBack, false);
			}
		});
	}
	
	private Color activeLineBorderColor;
	
	public Color getActiveLineBorderColor() {
		return activeLineBorderColor;
	}

	public void setActiveLineBorderColor(Color activeLineBorder) {
		this.activeLineBorderColor = activeLineBorder;
	}
	
	private boolean active;
	private Timer timerActive;
	private Timer timerInActive;
	private int activeSpeed = 50;
	private int activeLineBorderWidth = 5;
	private int inactiveLineBorderWidth = 0;
	
	public boolean isActive() {
		return this.active;
	}
	
	/**
	 * Set active state of this button
	 * */
	public void setActive(boolean state) {
		if (timerActive != null && active == true) {
			timerActive.stop();
			setBorder(new LineBorder(activeLineBorderColor, activeLineBorderWidth));
		}
		if (timerInActive != null && active == false) {
			timerInActive.stop();
			setBorder(new LineBorder(activeLineBorderColor, inactiveLineBorderWidth));
		}
		
		if (state == true) {
			timerActive = new Timer(activeSpeed, new ActionListener() {
				int width = inactiveLineBorderWidth;
				
				public void actionPerformed(ActionEvent arg0) {
					if (width == activeLineBorderWidth) {
						timerActive.stop();
						timerActive = null;
					}
					
					setBorder(new LineBorder(activeLineBorderColor, width));
					width++;
				}
			});
			
			if (active == false) {
				timerActive.start();
				active = true;
			}
			
		}
		else {
			timerInActive = new Timer(activeSpeed, new ActionListener() {
				int width = activeLineBorderWidth;
				
				public void actionPerformed(ActionEvent arg0) {
					if (width == inactiveLineBorderWidth) {
						timerInActive.stop();
						timerInActive = null;
					}
					
					setBorder(new LineBorder(activeLineBorderColor, width));
					width--;
				}
			});
			
			if (active == true) {
				timerInActive.start();
				active = false;
			}
		}
	}
}
