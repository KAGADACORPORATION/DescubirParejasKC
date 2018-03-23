package test;



import static org.junit.Assert.*;

import org.junit.Test;

import control.Dificultad;
import control.Iniciador;
import modelo.Tablero;

public class IniciadorTest {

	@Test
	public void testIniciarJuego() {
		
		
		Iniciador iniciador = new Iniciador();
		iniciador.iniciarJuego(Dificultad.medio);
		
		for (int i = 0; i < iniciador.getTablero().getCasilla().length; i++) {
			for (int j = 0; j < iniciador.getTablero().getCasilla()[i].length; j++) {
				assertTrue(iniciador.getTablero().getCasilla()[i][j].getIdentificador()>-1 &&
						iniciador.getTablero().getCasilla()[i][j].getIdentificador()<
						(iniciador.getTablero().getCasilla().length*iniciador.getTablero().getCasilla()[i].length)/2);
			}
		}
		int contadorPareja = 0;
		for (int i = 0; i < iniciador.getTablero().getCasilla().length; i++) {
			for (int j = 0; j < iniciador.getTablero().getCasilla().length; j++) {
				for (int k = 0; k < iniciador.getTablero().getCasilla().length; k++) {
					for (int m = 0; m < iniciador.getTablero().getCasilla().length; m++) {
						if(iniciador.getTablero().getCasilla()[i][j].getIdentificador()==iniciador.getTablero().getCasilla()[k][m].getIdentificador()) {
							contadorPareja++;
						}
					}
				}
				assertTrue(contadorPareja==2);
				contadorPareja=0;
			}
		}
		
		int contador = 0;
		boolean masDe4Seguidas = false;
		for (int i = 0; i < iniciador.getTablero().getCasilla().length; i++) {
			for (int j = 0; j < iniciador.getTablero().getCasilla()[i].length-1; j++) {
				if(iniciador.getTablero().getCasilla()[i][j].getIdentificador()==iniciador.getTablero().getCasilla()[i][j+1].getIdentificador())
					contador++;
				if(contador>3)masDe4Seguidas=true;
			}
			assertFalse(masDe4Seguidas);
			contador=0;
		}
	}

}
