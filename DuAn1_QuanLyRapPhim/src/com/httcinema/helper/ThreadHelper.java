package com.httcinema.helper;

import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.SwingWorker;

import com.httcinema.ui.subpanel.WaitJDialog;

public class ThreadHelper {

	public static void showWaitDialog(Window win, Runnable block1, Runnable block2) {
		// tạo một luồng chạy dưới nền
		SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				// công việc của luồng
				block1.run();
				return null;
			}
		};

		final WaitJDialog dialog = new WaitJDialog(win);
		
		// sự kiện xảy ra khi luồng kết thúc
		mySwingWorker.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("state")) {
					if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
						dialog.fadeOut();
						block2.run();
					}
				}
			}
		});
		
		mySwingWorker.execute(); // cho luồng thực thi
		dialog.fadeIn(dialog);
	}
}
