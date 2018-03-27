package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;

public class VistaPrincipal extends JFrame {

	protected JPanel vistaPrincipal;
	protected JPanel panelPrincipal;
	protected PanelInicio panelInicio;

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		vistaPrincipal = new JPanel();
		vistaPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(vistaPrincipal);
		vistaPrincipal.setLayout(new BoxLayout(vistaPrincipal, BoxLayout.Y_AXIS));
		
		JLabel lblDescubrirParejas = new JLabel("Descubrir Parejas");
		lblDescubrirParejas.setVerticalAlignment(SwingConstants.TOP);
		vistaPrincipal.add(lblDescubrirParejas);
		lblDescubrirParejas.setFont(new Font("Snap ITC", Font.PLAIN, 19));
		lblDescubrirParejas.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelPrincipal = new JPanel();
		vistaPrincipal.add(panelPrincipal);
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.X_AXIS));
		panelInicio = new PanelInicio();
		panelPrincipal.add(panelInicio);
	}

}
