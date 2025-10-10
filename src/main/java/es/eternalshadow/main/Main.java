package es.eternalshadow.main;

import javax.swing.JFrame;

public class Main {
	private String title = "EternalShadows";
	private JFrame frame = new JFrame();
	private Panel panel = new Panel();
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
	
	public void run() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setTitle(this.title);
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		panel.requestFocusInWindow();
		panel.run();
	}
}
