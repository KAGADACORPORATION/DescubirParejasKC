package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import vista.PanelInicio;
import vista.PanelJuego;
import vista.VistaPrincipal;

public class ListenerInicio implements ActionListener {
Iniciador iniciador;
PanelInicio panelinicio;
VistaPrincipal vistaprincipal;
PanelJuego paneljuego;
//ComboBox combobox
//TODO crear constructor cuando tengamos informacion.
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Remueve PanelInicio de PanelPrincipal
		//Asignar Filas y Columnas a la Logica
		//crear botonera.
		//añadir PanelJuego a PanelPrincipal
		//añadir ListenerJuego a Botones.
		//Iniciador tiene que tener un un método "IniciarJuego" que tiene que recibir un Casting Dificultad del ComboBox getItemsSelected
		//
	}

}
