package control;

import modelo.Tablero;

public class Iniciador implements Iniciable{
	private Tablero tablero;
	@Override
	public void iniciarJuego(Dificultad ParaFilaYColumna) {
		// TODO Auto-generated method stub
//		new Tablero(int fila, int columna),
//		RellenarTablero()crea una casilla por cada posicion del tablero y recibirá un número (referencia).
//		DesordenarCasillas() el tablero queda con las casillas desordenadas.,
	}
	public Tablero getTablero() {
		return tablero;
	}
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

}
