package modelo;

public class Tablero {
	private Casilla[][] casilla;
	

	public Tablero(int filas, int columnas) {
		casilla = new Casilla[filas][columnas];
	}

	public Casilla[][] getCasilla() {
		return casilla;
	}

	public void setCasilla(Casilla[][] casilla) {
		this.casilla = casilla;
	}
	
}
