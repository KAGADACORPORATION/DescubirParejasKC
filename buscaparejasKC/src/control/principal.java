package control;

import java.awt.EventQueue;

public class principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PuenteVistaControl puenteVistaControl = new PuenteVistaControl();
					puenteVistaControl.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

