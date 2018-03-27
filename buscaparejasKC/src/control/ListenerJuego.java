package control;

import java.awt.PageAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ActionMapUIResource;
import javax.swing.text.IconView;

import modelo.Casilla;
import modelo.Tablero;
import vista.PanelJuego;

public class ListenerJuego implements ActionListener {
	
	private Comprobador comprobador;
	private PanelJuego paneljuego;
	private JButton primero;
	private JButton segundo;

	
	public ListenerJuego(PanelJuego paneljuego, Tablero tablero) {
		super();
		this.paneljuego = paneljuego;
		this.comprobador = new Comprobador(tablero);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botonPulsado = ((JButton) e.getSource());
		if(!comprobarVisible(botonPulsado)) {
			
			if(primero!=null) {
				ponerVisibleTrue(botonPulsado);
				this.segundo=botonPulsado;
				ponerImagenBoton(segundo);
			}
			if(segundo!=null) {
				if(!comprobador.CompararCasilla(obtenerCasilla(primero), obtenerCasilla(segundo))) {
					try {
						Thread.sleep(700);
						ponerVisibleFalse(primero);
						ponerVisibleFalse(segundo);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				quitarImagenBoton(primero);
				quitarImagenBoton(segundo);
				this.primero=null;
				this.segundo=null;
			}
			else {
				ponerVisibleTrue(botonPulsado);
				this.primero=botonPulsado;
				ponerImagenBoton(primero);
			}
		}
		actualizarTablero();
	}

	private void quitarImagenBoton(JButton boton) {
		ImageIcon icono = new ImageIcon("img/vaciaParejas.png");
		boton.setIcon(icono);
		boton.validate();
		boton.repaint();
		
	}

	private void ponerImagenBoton(JButton boton) {
		ImageIcon icono = new ImageIcon(generarRutaImagen(boton));
		boton.setIcon(icono);
		boton.validate();
		boton.repaint();
	}

	private Casilla obtenerCasilla(JButton boton) {
		return comprobador.getTablero().getCasilla()[obtenerPosicionX(boton)][obtenerPosicionY(boton)];
	}

	/**
	 * @param botonPulsado
	 */
	private void ponerVisibleFalse(JButton botonPulsado) {
		this.comprobador.getTablero().getCasilla()[obtenerPosicionX(botonPulsado)][obtenerPosicionY(botonPulsado)].setVisible(false);
	}

	/**
	 * @param botonPulsado
	 */
	private void ponerVisibleTrue(JButton botonPulsado) {
		this.comprobador.getTablero().getCasilla()[obtenerPosicionX(botonPulsado)][obtenerPosicionY(botonPulsado)].setVisible(true);
	}


	/**
	 * @param botonPulsado
	 * @return
	 */
	private boolean comprobarVisible(JButton botonPulsado) {
		return this.comprobador.getTablero().getCasilla()[obtenerPosicionX(botonPulsado)][obtenerPosicionY(botonPulsado)].isVisible();
	}
	
	private void actualizarTablero() {
		for (int i = 0; i < comprobador.getTablero().getCasilla().length; i++) {
			for (int j = 0; j < comprobador.getTablero().getCasilla().length; j++) {
				this.paneljuego.getBotones()[i][j].removeAll();
				if(this.comprobador.getTablero().getCasilla()[i][j].isVisible()) {
					this.paneljuego.getBotones()[i][j].setIcon(new ImageIcon(generarRutaImagen(this.paneljuego.getBotones()[i][j])));
					
				}
				else{
					ImageIcon imagenVacia = new ImageIcon("img/vaciaParejas.png");
					this.paneljuego.getBotones()[i][j].setIcon(imagenVacia);
				}
				 
			}
		}
	}

	private String generarRutaImagen(JButton boton) {
		return "img/imagen"+comprobador.getTablero().getCasilla()[obtenerPosicionX(boton)][obtenerPosicionY(boton)].getIdentificador()+".jpg";
	}


	private int obtenerPosicionX(JButton boton) {
		int posicionEspacio=String.valueOf(boton.getName()).indexOf(' ');
		return Integer.valueOf(String.valueOf(boton.getName()).substring(0,posicionEspacio));
	}

	private int obtenerPosicionY(JButton boton) {
		int posicionEspacio=String.valueOf(boton.getName()).indexOf(' ');
		return Integer.valueOf(String.valueOf(boton.getName()).substring(posicionEspacio+1));
	}

	public JButton getSegundo() {
		return segundo;
	}

	public void setSegundo(JButton segundo) {
		this.segundo = segundo;
	}
}
