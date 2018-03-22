package control;

import modelo.Casilla;
import modelo.Tablero;

public class Iniciador implements Iniciable{
	private Tablero tablero;
	@Override
	public void iniciarJuego(Dificultad ParaFilaYColumna) {
		// TODO Auto-generated method stub
		tablero = new Tablero(ParaFilaYColumna.getValor(),ParaFilaYColumna.getValor());
		rellenarTablero(tablero);
		desordenarCasillas(tablero);
//		RellenarTablero()crea una casilla por cada posicion del tablero y recibirá un número (referencia).
//		DesordenarCasillas() el tablero queda con las casillas desordenadas.
	}
	
	public void rellenarTablero(Tablero tablero){
		Casilla casillas[][]=tablero.getCasilla();
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j]=new Casilla(i);
			}
		}
	}
	public Tablero getTablero() {
		return tablero;
	}
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public void desordenarCasillas(Tablero tablero) {
		Casilla casillas[][]=tablero.getCasilla();
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				
			}
		}
	}

}
