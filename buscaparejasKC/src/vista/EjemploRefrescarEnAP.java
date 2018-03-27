package vista;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
	
	public class EjemploRefrescarEnAP extends JFrame {
		private JLabel jlblTextLabel; private JButton jbtnStartTesting;
		private JScrollPane scrollPane1; private JList list1;
		
		public EjemploRefrescarEnAP() {
			initComponents();
		} 
		private void initComponents() {
			// Component initialization 
			jlblTextLabel = new JLabel();
			jbtnStartTesting = new JButton();
			scrollPane1 = new JScrollPane();
			list1 = new JList();
			// inner class listener for Standard test button:
			jbtnStartTesting.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jbtnStartTesting_ActionPerformed(evt); } });
			//======== this ======== 
			Container contentPane = getContentPane();
			contentPane.setLayout(null);  
			//---- jlblTextLabel ---- 
			jlblTextLabel.setText("Not Tested");
			jlblTextLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
			jlblTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(jlblTextLabel);
			jlblTextLabel.setBounds(115, 30, 150, 50);
			//---- jbtnStartTesting ---- 
			jbtnStartTesting.setText("Start Testing");
			jbtnStartTesting.setFont(new Font("Tahoma", Font.PLAIN, 18));
			contentPane.add(jbtnStartTesting);
			jbtnStartTesting.setBounds(115, 75, 150, 65);
			//======== scrollPane1 ======== 
			{ scrollPane1.setViewportView(list1); }
			contentPane.add(scrollPane1);
			scrollPane1.setBounds(25, 150, 340, scrollPane1.getPreferredSize().height);  {
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < contentPane.getComponentCount(); i++) {
					Rectangle bounds = contentPane.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					} Insets insets = contentPane.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom; contentPane.setMinimumSize(preferredSize);
					contentPane.setPreferredSize(preferredSize); }
			pack(); setLocationRelativeTo(getOwner()); 		 }
		public static void main(String[] args) {
			EjemploRefrescarEnAP frameInstance = new EjemploRefrescarEnAP();
			frameInstance.setSize(400, 350); frameInstance.setVisible(true);
			frameInstance.setSize(400, 350); }                   
		// Action Listener for button:
		private void jbtnStartTesting_ActionPerformed(ActionEvent evt) {
			System.out.println("Button Pressed");
			jlblTextLabel.validate();
			jlblTextLabel.repaint();
			this.validate();
			this.repaint();            
			// Change the test indicator, before the test is done, indicating test in progress 
			jlblTextLabel.setText("<html><font color = green>TESTING</font></html>");
			// Creating a Runnable instance here
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					// TO RUN EXECUTABLE SCRIPT:
					runCasconScript("CASCONCMD \"/U01061074C 75X00 Pod\" \"/TInterconnection\" /R");
					// END OF RUN EXECUTABLE SCRIPT
					} });             
			}       
		// Method that runs the external program script with required parameters:
		public void runCasconScript(String testScriptToRun) {
			try {
				Runtime rt = Runtime.getRuntime();
				System.out.println("Executing: " + testScriptToRun);
				Process proc = rt.exec(testScriptToRun);  
				// any error after executing process is indicated in exitVal 
				int exitVal = proc.waitFor();
				System.out.println("ExitValue: " + exitVal); 
			} catch (InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}