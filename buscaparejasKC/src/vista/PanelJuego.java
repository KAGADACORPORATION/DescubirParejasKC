package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.Cursor;
import javax.swing.DebugGraphics;

public class PanelJuego extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel aciertos;
	private JLabel tiempo;
	private JPanel panelBotones;
	private JPanel panelMarcador;
	private JButton botones [][];
	private JPanel panelParaBotones;


	/**
	 * Create the panel.
	 * CONTIENE LOS BOTONES Y MARCADORES.
	 */
	public PanelJuego(int filas, int columnas) {
		setBorder(null);
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
		
		panelParaBotones = new JPanel();
		add(panelParaBotones, BorderLayout.CENTER);
		panelParaBotones.setLayout(new CardLayout(0, 0));
		
		
		
		
		panelBotones = new JPanel();
		if(filas !=0 && columnas !=0) {
			GridLayout gridBotones = new GridLayout();
			gridBotones.setRows(filas);
			gridBotones.setColumns(columnas);
			panelBotones.setLayout(gridBotones);
			this.botones= new JButton[filas][columnas];
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					
					this.botones[i][j] = new JButton("");
					this.botones[i][j].setName(i+" "+j);
					this.botones[i][j].setMinimumSize(new Dimension(0, 0));
					this.botones[i][j].setMaximumSize(new Dimension(40, 40));
					this.botones[i][j].setMargin(new Insets(0, 0, 0, 0));
					this.botones[i][j].setIcon(new ImageIcon(PanelJuego.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
					this.botones[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
					this.botones[i][j].setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
					this.botones[i][j].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					this.botones[i][j].setContentAreaFilled(false);
					this.botones[i][j].setBorder(null);
					this.botones[i][j].setAlignmentX(Component.CENTER_ALIGNMENT);
					this.panelBotones.add(botones[i][j]);
				}
			}
			panelParaBotones.add(panelBotones);
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

	public JButton[][] getBotones() {
		return botones;
	}

	public void setBotones(JButton botones[][]) {
		this.botones = botones;
	}

	public JPanel getPanelParaBotones() {
		return panelParaBotones;
	}

	public void setPanelParaBotones(JPanel panelParaBotones) {
		this.panelParaBotones = panelParaBotones;
	}
}
