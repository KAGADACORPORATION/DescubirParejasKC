package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.Iniciador;
import modelo.Tablero;

class IniciadorTest {

	@Test
	void testIniciarJuego() {
		Iniciador iniciador = new Iniciador();
		assertNotNull(iniciador);
		
		Tablero tablero = new Tablero(5,5);
		assertTrue(tablero.getCasilla().length==5);
		assertNotNull(tablero);
		
		iniciador.setTablero(tablero);
		iniciador.rellenarTablero();
		for (int i = 0; i < iniciador.getTablero().getCasilla().length; i++) {
			for (int j = 0; j < iniciador.getTablero().getCasilla()[i].length; j++) {
				assertTrue(iniciador.getTablero().getCasilla()[i][j].getIdentificador()>-1&&
						iniciador.getTablero().getCasilla()[i][j].getIdentificador()<
						(iniciador.getTablero().getCasilla().length*iniciador.getTablero().getCasilla()[i].length)/2);
			}
		}
		iniciador.desordenarCasillas();
		int contador;
		boolean masDe4Seguidas = false;
		for (int i = 0; i < iniciador.getTablero().getCasilla().length; i++) {
			for (int j = 0; j < iniciador.getTablero().getCasilla()[i].length-1; j++) {
				if(iniciador.getTablero().getCasilla()[i][j].getIdentificador()==iniciador.getTablero().getCasilla()[i][j+1].getIdentificador())
					contador++;
				if(contador>3)masDe4Seguidas=true;
			}
			contador=0;
		}
	}

}
