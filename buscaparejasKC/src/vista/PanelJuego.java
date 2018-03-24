package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class PanelJuego extends JPanel {
	private JLabel aciertos;
	private JLabel tiempo;
	private JPanel panelBotones;
	private JPanel panelMarcador;
	/**
	 * Create the panel.
	 * CONTIENE LOS BOTONES Y MARCADORES.
	 */
	public PanelJuego(int filas, int columnas) {
		setLayout(new BorderLayout(0, 0));
		
		panelMarcador = new JPanel();
		add(panelMarcador, BorderLayout.NORTH);
		panelMarcador.setLayout(new BoxLayout(panelMarcador, BoxLayout.X_AXIS));
		
		JLabel lblAciertos = new JLabel("ACIERTOS");
		lblAciertos.setPreferredSize(new Dimension(135, 40));
		lblAciertos.setMinimumSize(new Dimension(135, 40));
		lblAciertos.setMaximumSize(new Dimension(500, 60));
		lblAciertos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAciertos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAciertos.setForeground(new Color(34, 139, 34));
		lblAciertos.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 15));
		panelMarcador.add(lblAciertos);
		
		aciertos = new JLabel("0");
		aciertos.setPreferredSize(new Dimension(75, 40));
		aciertos.setMaximumSize(new Dimension(444, 60));
		aciertos.setMinimumSize(new Dimension(75, 40));
		aciertos.setHorizontalAlignment(SwingConstants.CENTER);
		aciertos.setFont(new Font("Tahoma", Font.BOLD, 15));
		aciertos.setForeground(new Color(34, 139, 34));
		panelMarcador.add(aciertos);
		
		JLabel lblTiempo = new JLabel("TIEMPO");
		lblTiempo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTiempo.setMinimumSize(new Dimension(100, 40));
		lblTiempo.setMaximumSize(new Dimension(500, 60));
		lblTiempo.setPreferredSize(new Dimension(135, 40));
		lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempo.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 15));
		panelMarcador.add(lblTiempo);
		
		tiempo = new JLabel("00:00:00");
		tiempo.setHorizontalTextPosition(SwingConstants.CENTER);
		tiempo.setPreferredSize(new Dimension(80, 40));
		tiempo.setMinimumSize(new Dimension(80, 40));
		tiempo.setMaximumSize(new Dimension(400, 60));
		tiempo.setHorizontalAlignment(SwingConstants.CENTER);
		tiempo.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelMarcador.add(tiempo);
		
		panelBotones = new JPanel();
		if(filas !=0 && columnas !=0) {
			GridLayout gridBotones = new GridLayout();
			gridBotones.setRows(filas);
			gridBotones.setColumns(columnas);
			panelBotones.setLayout(gridBotones);
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					JButton boton = new JButton(" ");
					boton.setName(i+" "+j);
					panelBotones.add(boton);
				}
			}
			add(panelBotones,BorderLayout.CENTER);
		}
		
	}

	public JLabel getAciertos() {
		return aciertos;
	}

	public void setAciertos(JLabel aciertos) {
		this.aciertos = aciertos;
	}

	public JLabel getTiempo() {
		return tiempo;
	}

	public void setTiempo(JLabel tiempo) {
		this.tiempo = tiempo;
	}

	public JPanel getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}

	public JPanel getPanelMarcador() {
		return panelMarcador;
	}

	public void setPanelMarcador(JPanel panelMarcador) {
		this.panelMarcador = panelMarcador;
	}
	
	
}
