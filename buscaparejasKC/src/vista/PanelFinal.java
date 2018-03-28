package vista;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JButton;

public class PanelFinal extends JPanel{
	private JButton botonVolverJugar;
	private JLabel labelImagenGanador;
	private JPanel panelImagenGanador;
	public PanelFinal(int anchoPantalla,int altoPanelImagen) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel tituloFin = new JLabel("WINNER");
		tituloFin.setHorizontalAlignment(SwingConstants.CENTER);
		tituloFin.setHorizontalTextPosition(SwingConstants.LEADING);
		tituloFin.setPreferredSize(new Dimension(400, 40));
		tituloFin.setMinimumSize(new Dimension(40, 30));
		tituloFin.setMaximumSize(new Dimension(5400, 40));
		tituloFin.setForeground(Color.ORANGE);
		tituloFin.setFont(new Font("Snap ITC", Font.PLAIN, 30));
		panel.add(tituloFin);
		
		panelImagenGanador = new JPanel();
		add(panelImagenGanador, BorderLayout.CENTER);
		panelImagenGanador.setLayout(new BoxLayout(panelImagenGanador, BoxLayout.X_AXIS));
		
		labelImagenGanador = new JLabel("");
		labelImagenGanador.setHorizontalTextPosition(SwingConstants.LEADING);
		panelImagenGanador.add(labelImagenGanador);
		ImageIcon imagenGanador = new ImageIcon("img/imagenGanador.jpg");
		imagenGanador=createScaledIcon(imagenGanador,anchoPantalla, altoPanelImagen);
		labelImagenGanador.setIcon(imagenGanador);
		
		JPanel panelBotonVolverJugar = new JPanel();
		add(panelBotonVolverJugar, BorderLayout.SOUTH);
		panelBotonVolverJugar.setLayout(new BoxLayout(panelBotonVolverJugar, BoxLayout.X_AXIS));
		
		botonVolverJugar = new JButton("VOLVER A JUGAR");
		botonVolverJugar.setPreferredSize(new Dimension(117, 50));
		botonVolverJugar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonVolverJugar.setMinimumSize(new Dimension(40, 50));
		botonVolverJugar.setMaximumSize(new Dimension(5117, 50));
		panelBotonVolverJugar.add(botonVolverJugar);
	}

	public JButton getBotonVolverJugar() {
		return botonVolverJugar;
	}

	public void setBotonVolverJugar(JButton botonVolverJugar) {
		this.botonVolverJugar = botonVolverJugar;
	}

	public JLabel getLabelImagenGanador() {
		return labelImagenGanador;
	}

	public void setLabelImagenGanador(JLabel labelImagenGanador) {
		this.labelImagenGanador = labelImagenGanador;
	}

	public JPanel getPanelImagenGanador() {
		return panelImagenGanador;
	}

	public void setPanelImagenGanador(JPanel panelImagenGanador) {
		this.panelImagenGanador = panelImagenGanador;
	}

	private ImageIcon createScaledIcon(ImageIcon Imagen, int width, int height) {
		return new ImageIcon(Imagen.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));

	}
}
