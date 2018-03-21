package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import modelo.Tablero;
import vista.PanelJuego;

public class ListenerJuego implements ActionListener {
	
	Comprobador comprobador= new Comprobador();
	PanelJuego paneljuego;
	JButton Primero;
	JLabel Marcador;
	
//	TODO generar el constructor sin incluir primero ni comprobador
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/* TODO 
		 * si el boton no está visible,pregunta si el boton Primero está nulo.
		 * en caso de NULO, asignar el casting a Jbuton de "e" a "Primero".
		 * hacer que en comprobador la casilla sea Visible(visible=true).
		 * Si no es NULO, comparamos(usando comprobador) el casting con boton "Primero" y si son iguales se quedan reveladas, 
		 * si  son distintas Pausamos un tiempo determinado y cambiamos a no visibles Primero y Casting
		 * ActualizarTablero();
		 * colocar Primero NULL(dentro del if cuando el primero no es NULL)
		 * comprobar ganador (usando comprobador)  
		 * si ganador añadir panel final al padre de panelJuego y remover panelJuego
		 */
		
		
	}

}
