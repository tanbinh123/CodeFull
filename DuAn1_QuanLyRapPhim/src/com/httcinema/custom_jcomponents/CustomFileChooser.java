/**
 * @author: Dinh Dat Thong
 * */

package com.httcinema.custom_jcomponents;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


@SuppressWarnings("serial")
public class CustomFileChooser extends JFileChooser {
	
	public CustomFileChooser() {
		super();
	}
	
	public void setImageChooseStyle(String... extensions) {
		setDialogTitle("Chọn hình ảnh mới");
    	setCurrentDirectory(new File (System.getProperty("user.home") + "/Desktop/"));
    	setAccessory(new ImagePreview(this));
		FileFilter imageFilter = new FileNameExtensionFilter("Image files", extensions);
		
	    addChoosableFileFilter(imageFilter);
	    setAcceptAllFileFilterUsed(false);
	}
	
	/*************************************************/
	/**
	 * @author: Jeff Friesen from www.javaworld.com
	 * */
	private class ImagePreview extends JComponent implements PropertyChangeListener {
		// Dimensions of image preview's preferred size.

		final static int WIDTH = 200;
		final static int HEIGHT = 200;

		// Reference to ImageIcon whose image is displayed in accessory area. If
		// null reference, nothing is displayed in accessory area.

		private ImageIcon icon;

		// Create ImagePreview component to serve as a file chooser accessory.

		public ImagePreview(JFileChooser fc) {
			// Register a property change listener with the file chooser so that
			// the ImagePreview component is made aware of file chooser events (such
			// as a user selecting a file).

			fc.addPropertyChangeListener(this);

			// Set the ImagePreview's dimensions to accommodate image thumbnails.
			// The specified values determine the overall size of the file chooser.

			setPreferredSize(new Dimension(WIDTH, HEIGHT));
		}

		// Paint the ImagePreview component in response to a repaint() method call.

		@Override
		protected void paintComponent(Graphics g) {
			// When this method is called, the background has already been painted.
			// If icon is null, do nothing. This action causes the current image
			// thumbnail to disappear when the user selects a directory, for example.

			if (icon != null) {
				// Paint a white background behind the pixels so that a GIF image's
				// transparent pixel causes white (instead of gray or whatever color
				// is appropriate for this look and feel) to show through.

				// Paint the image -- (0, 0) is the image's upper-left corner, and
				// the upper-left corner of the accessory area.

				icon.paintIcon(this, g, ((WIDTH - icon.getIconWidth()) / 2) + 10, ((HEIGHT - icon.getIconHeight()) / 2));
			}
		}

		// Respond to property change events sent to this ImagePreview component by
		// the file chooser.

		@Override
		public void propertyChange(PropertyChangeEvent e) {
			// Extract property name from event object.

			String propName = e.getPropertyName();

			// Erase any displayed image if user moves up the directory hierarchy.

			if (JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(propName)) {
				icon = null;
				repaint();
				return;
			}

			// Display selected file. If a directory is selected, erase any
			// displayed image.

			if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(propName)) {
				// Extract selected file's File object.

				File file = (File) e.getNewValue();

				// If file is null, a directory was selected -- the user is moving
				// between directories. In response, any displayed image in the
				// accessory area must be erased.

				if (file == null) {
					icon = null;
					repaint();
					return;
				}

				// Obtain the selected file's icon.

				icon = new ImageIcon(file.getPath());

				// The ImageIcon constructor invokes a Toolkit getImage() method to
				// obtain the image identified by file.getPath(). The image is read
				// from the file unless the image (together with file path/name
				// information) has been cached (for performance reasons). Suppose
				// the user has specified the name of a file and that file does not
				// exist. Toolkit's getImage() method will return an Image with the
				// width and height each set to -1. The "image" associated with this
				// Image will be cached. Suppose the user activates the open file
				// chooser and selects the file to which the image was saved. The
				// previous ImageIcon() constructor will execute, but the image
				// will not be read from the file -- it will be read from the cache
				// (with -1 as the width and as the height). No image will appear in
				// the preview window; the user will be confused. The solution to
				// this problem is to test the Image's width for -1. If this value
				// is present, Image's flush() method is called on the Image, and a
				// new ImageIcon is created. Internally, Toolkit's getImage() method
				// will read the image from the file -- not from the cache.

				if (icon.getIconWidth() == -1) {
					icon.getImage().flush();
					icon = new ImageIcon(file.getPath());
				}

				// Scale icon to fit accessory area if icon too big.

				if (icon.getIconWidth() > WIDTH)
					icon = new ImageIcon(icon.getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH));

				// Display image.

				repaint();
			}
		}
	}
}
