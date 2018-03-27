package control;

import modelo.Casilla;
import modelo.Tablero;

public class Comprobador implements Comprobable{

	private Tablero tablero;
	
	public Comprobador(Tablero tablero) {
		this.tablero = tablero;
	}

	@Override
	public Boolean CompararCasilla(Casilla casillaUno, Casilla casillaDos) {
		assert (casillaUno.isVisible()&&casillaDos.isVisible());
		if (casillaUno.getIdentificador()==casillaDos.getIdentificador()) {
			return true;
		} else return false;
	}

	@Override
	public Boolean ComprobarGanador() {
		for (int i = 0; i < this.tablero.getCasilla().length; i++) {
			for (int j = 0; j < this.tablero.getCasilla()[i].length; j++) {
				if (!this.tablero.getCasilla()[i][j].isVisible()) {
					return false;
				}
			}
		}
		return true;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

}
