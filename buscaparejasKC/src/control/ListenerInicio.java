package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import vista.PanelInicio;
import vista.PanelJuego;

public class ListenerInicio implements ActionListener {
	private Iniciador iniciador= new Iniciador();
	private PanelInicio panelinicio;
	private PanelJuego paneljuego;
	private ListenerJuego listenerJuego;
	private JPanel panelPrincipal;

	



	public ListenerInicio(PanelInicio panelinicio, JPanel panelPrincipal) {
		super();
		this.panelinicio = panelinicio;
		this.panelPrincipal = panelPrincipal;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		this.iniciador.iniciarJuego((Dificultad) this.panelinicio.getComboBox().getSelectedItem());
		this.paneljuego=new PanelJuego(iniciador.getTablero().getCasilla().length, iniciador.getTablero().getCasilla().length);
		this.panelPrincipal.remove(panelinicio);
		this.panelPrincipal.add(paneljuego);
		//añadir ListenerJuego a Botones.
		SwingUtilities.updateComponentTreeUI(panelPrincipal);
	}
	
	
	public Iniciador getIniciador() {
		return iniciador;
	}


	public void setIniciador(Iniciador iniciador) {
		this.iniciador = iniciador;
	}


	public PanelInicio getPanelinicio() {
		return panelinicio;
	}


	public void setPanelinicio(PanelInicio panelinicio) {
		this.panelinicio = panelinicio;
	}

	public JPanel getPaneljuego() {
		return paneljuego;
	}


	public void setPaneljuego(PanelJuego paneljuego) {
		this.paneljuego = paneljuego;
	}


	public ListenerJuego getListenerJuego() {
		return listenerJuego;
	}


	public void setListenerJuego(ListenerJuego listenerJuego) {
		this.listenerJuego = listenerJuego;
	}
}
