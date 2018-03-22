package modelo;

import control.Dificultad;

public class Tablero {
	private Casilla[][] casilla;

	public Casilla[][] getCasilla() {
		return casilla;
	}

	public Tablero(int filas, int columnas) {
		casilla = new Casilla[filas][columnas];
	}

	public void setCasilla(Casilla[][] casilla) {
		this.casilla = casilla;
	}
	
//	TODO constructor de tablero 
//	recibe numero de filas y columnas
//  el constructor asigna dimension a casilla basandose en las filas y columnas recibidas
}
