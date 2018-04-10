package control;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import modelo.Casilla;
import modelo.Tablero;
import vista.PanelFinal;
import vista.PanelJuego;

public class ListenerJuego implements ActionListener {

	private Comprobador comprobador;
	private PanelJuego paneljuego;
	private JButton primero;
	private JButton segundo;
	private PanelFinal panelFinal;
	private ListenerFinJuego listenerFinJuego;

	public ListenerJuego(PanelJuego paneljuego, Tablero tablero) {
		super();
		this.paneljuego = paneljuego;
		this.comprobador = new Comprobador(tablero);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botonPulsado = ((JButton) e.getSource());
		if (!comprobarVisible(botonPulsado)) {

			if (primero != null) {
				ponerVisibleTrue(botonPulsado);
				this.segundo = botonPulsado;
			} else {
				ponerVisibleTrue(botonPulsado);
				this.primero = botonPulsado;
			}
			//aqui se crea un objeto que debe implementar el metodo doinbackogrund
			//esto se hara cuando siempre cuando se llamada al metodo execute del objeto worker
			//como funciona como otro hilo, la secuencia de ordenes de este listener se acaban y dan paso a la
			//actualizacion del ui (por eso hay dos actulizarTablero)
			SwingWorker worker = new SwingWorker<Object, Object>() {

				@Override
				protected Object doInBackground() throws Exception {
					if (!comprobador.CompararCasilla(obtenerCasilla(primero), obtenerCasilla(segundo))) {
						try {
							Thread.sleep(700);
							ponerVisibleFalse(primero);
							ponerVisibleFalse(segundo);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
					primero = null;
					segundo = null;
					actualizarTablero();
					return null;
				}

			};
			actualizarTablero();
			worker.execute();
			if (this.comprobador.ComprobarGanador()) {
				finalizarJuego();
			}
		}
	}

	/**
	 * remueve PanelJuego y a�ado PanelFinal
	 */
	private void finalizarJuego() {
		JPanel padre = (JPanel) paneljuego.getParent();
		padre.remove(paneljuego);
		panelFinal = new PanelFinal(this.paneljuego.getPanelParaBotones().getWidth(),
				this.paneljuego.getPanelParaBotones().getHeight() - 100);
		padre.add(panelFinal);
		SwingUtilities.updateComponentTreeUI(padre);
		listenerFinJuego = new ListenerFinJuego();
		panelFinal.getBotonVolverJugar().addActionListener(listenerFinJuego);
	}

	private Casilla obtenerCasilla(JButton boton) {
		return comprobador.getTablero().getCasilla()[obtenerPosicionX(boton)][obtenerPosicionY(boton)];
	}

	/**
	 * @param botonPulsado
	 */
	private void ponerVisibleFalse(JButton botonPulsado) {
		this.comprobador.getTablero().getCasilla()[obtenerPosicionX(botonPulsado)][obtenerPosicionY(botonPulsado)]
				.setVisible(false);
	}

	/**
	 * @param botonPulsado
	 */
	private void ponerVisibleTrue(JButton botonPulsado) {
		this.comprobador.getTablero().getCasilla()[obtenerPosicionX(botonPulsado)][obtenerPosicionY(botonPulsado)]
				.setVisible(true);
	}

	/**
	 * @param botonPulsado
	 * @return
	 */
	private boolean comprobarVisible(JButton botonPulsado) {
		return this.comprobador.getTablero().getCasilla()[obtenerPosicionX(botonPulsado)][obtenerPosicionY(
				botonPulsado)].isVisible();
	}

	/**
	 * actualiza la botonera creando iconos si esta visible o una imagen vacia
	 * si no esta visible
	 */
	private void actualizarTablero() {
		for (int i = 0; i < comprobador.getTablero().getCasilla().length; i++) {
			for (int j = 0; j < comprobador.getTablero().getCasilla()[i].length; j++) {
				if (this.comprobador.getTablero().getCasilla()[i][j].isVisible()) {
					ImageIcon imagenBoton = new ImageIcon(generarRutaImagen(this.paneljuego.getBotones()[i][j]));
					imagenBoton = createScaledIcon(imagenBoton, obtenerAnchoBoton(i), obtenerAlturaBoton());
					this.paneljuego.getBotones()[i][j].setIcon(imagenBoton);
					this.paneljuego.getBotones()[i][j]
							.setMaximumSize(new Dimension(obtenerAnchoBoton(i), obtenerAlturaBoton()));
				} else {
					ImageIcon imagenVacia = new ImageIcon("img/vaciaParejas.png");
					imagenVacia = createScaledIcon(imagenVacia, obtenerAnchoBoton(i), obtenerAlturaBoton());
					this.paneljuego.getBotones()[i][j].setIcon(imagenVacia);
				}
			}
		}
	}

	/**
	 * @return
	 */
	private int obtenerAlturaBoton() {
		return this.paneljuego.getPanelParaBotones().getHeight() / (paneljuego.getBotones().length + 2);
	}

	/**
	 * @param i
	 * @return
	 */
	private int obtenerAnchoBoton(int i) {
		return this.paneljuego.getPanelParaBotones().getWidth() / (paneljuego.getBotones()[i].length + 2);
	}

	private ImageIcon createScaledIcon(ImageIcon Imagen, int width, int height) {
		return new ImageIcon(Imagen.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

	}

	private String generarRutaImagen(JButton boton) {
		return "img/imagen" + comprobador.getTablero().getCasilla()[obtenerPosicionX(boton)][obtenerPosicionY(boton)]
				.getIdentificador() + ".jpg";
	}

	private int obtenerPosicionX(JButton boton) {
		int posicionEspacio = String.valueOf(boton.getName()).indexOf(' ');
		return Integer.valueOf(String.valueOf(boton.getName()).substring(0, posicionEspacio));
	}

	private int obtenerPosicionY(JButton boton) {
		int posicionEspacio = String.valueOf(boton.getName()).indexOf(' ');
		return Integer.valueOf(String.valueOf(boton.getName()).substring(posicionEspacio + 1));
	}

	public JButton getSegundo() {
		return segundo;
	}

	public void setSegundo(JButton segundo) {
		this.segundo = segundo;
	}

	public ListenerFinJuego getListenerFinJuego() {
		return listenerFinJuego;
	}

	public void setListenerFinJuego(ListenerFinJuego listenerFinJuego) {
		this.listenerFinJuego = listenerFinJuego;
	}
}
