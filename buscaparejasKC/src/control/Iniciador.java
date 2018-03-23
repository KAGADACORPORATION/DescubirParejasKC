package control;

import modelo.Casilla;
import modelo.Tablero;

public class Iniciador implements Iniciable{
	private Tablero tablero;

	
	/**
	 * obtiene un enum con el valor de las filas y las columnas ( tablero cuadrado)
	 * y crea el tablero, lo rellena de casillas y desordena las casillas,
	 */
	@Override
	public void iniciarJuego(Dificultad ParaFilaYColumna) {
		this.tablero = new Tablero(ParaFilaYColumna.getValor(),ParaFilaYColumna.getValor());
		rellenarTablero();
		desordenarCasillas();
	}
	
	/**
	 * genera parejas de casillas con el mismo identificador
	 */
	private void rellenarTablero(){
		int idCasilla = 0;
		for (int i = 0,i2=this.tablero.getCasilla().length/2; i < this.tablero.getCasilla().length/2; i++,i2++) {
			for (int j = 0;j<this.tablero.getCasilla().length; j++) {
				this.tablero.getCasilla()[i][j]=new Casilla(idCasilla);
				this.tablero.getCasilla()[i2][j]=new Casilla(idCasilla);
				idCasilla++;
			}
		}
	}
	
	/**
	 * recorre la matriz de principio a fin un numero de veces determinado por 
	 * el producto de la longitud del tablero y cambia de posicion la casilla correspondiente
	 * al indice j y j2 por otra aleatoria
	 */
	private void desordenarCasillas() {
		Casilla casillaAuxiliar;
		for (int i = 0; i < this.tablero.getCasilla().length*this.tablero.getCasilla().length; i++) {
			for (int j = 0; j < this.tablero.getCasilla().length; j++) {
				for (int j2 = 0; j2 < this.tablero.getCasilla().length; j2++) {
					int posicionJ= crearRandom(0, this.tablero.getCasilla().length-1);
					int posicionJ2= crearRandom(0,  this.tablero.getCasilla().length-1);
					casillaAuxiliar=this.tablero.getCasilla()[posicionJ][posicionJ2];
					this.tablero.getCasilla()[posicionJ][posicionJ2]=this.tablero.getCasilla()[j][j2];
					this.tablero.getCasilla()[j][j2]=casillaAuxiliar;
				}
			}
		}
	}
	
	/**
	 * crea un numero random
	 * @param min numero minimo
	 * @param max numero maximo
	 * @return numero aleatorio comprendido entre min y max
	 */
	private int crearRandom(int min,int max) {
		int numeroAleatorio=((int)(Math.random()*((max-min)+1)))+min;
		return numeroAleatorio;
	}
	
	public Tablero getTablero() {
		return tablero;
	}
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
}
