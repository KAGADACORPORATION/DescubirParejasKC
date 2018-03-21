package test;



import static org.junit.Assert.*;

import org.junit.Test;

import control.Comprobador;
import modelo.Casilla;
import modelo.Tablero;

class ComprobadorTest {

	@Test
	void testCompararCasilla() {
		
		Comprobador comprobador = new Comprobador();
		
		Casilla igualUno = new Casilla();
		igualUno.setVisible(true);
		igualUno.setIdentificador(1);
		
		Casilla igualDos = new Casilla();
		igualDos.setVisible(true);
		igualDos.setIdentificador(1);
		
		Casilla distinta = new Casilla();
		igualDos.setVisible(true);
		igualDos.setIdentificador(1);
		
		assertTrue(comprobador.CompararCasilla(igualUno, igualDos));
		assertFalse(comprobador.CompararCasilla(igualDos, distinta));
	}

	@Test
	void testComprobarGanador() {
		Comprobador comprobador = new Comprobador();
		
		Casilla visible = new Casilla();
		visible.setVisible(true);
		
		Casilla noVisible = new Casilla();
		noVisible.setVisible(false);
		
		Casilla ganador [][] = {{visible,visible},{visible,visible},{visible,visible},{visible,visible}};
		Tablero tableroGanador = new Tablero();
		tableroGanador.setCasilla(ganador);
		
		Casilla noGanadorUno [][] = {{noVisible,visible},{visible,visible},{visible,visible},{visible,visible}};
		Tablero tableroNoGanadorUno = new Tablero();
		tableroGanador.setCasilla(noGanadorUno);
		
		Casilla noGanadorDos [][] = {{visible,visible},{visible,visible},{visible,visible},{visible,noVisible}};
		Tablero tableroNoGanadorDos = new Tablero();
		tableroGanador.setCasilla(noGanadorDos);
		
		Casilla noGanadorTres [][] = {{noVisible,noVisible},{noVisible,noVisible},{noVisible,noVisible},{noVisible,noVisible}};
		Tablero tableroNoGanadorTres = new Tablero();
		tableroGanador.setCasilla(noGanadorTres);
		
		assertTrue(comprobador.ComprobarGanador(tableroGanador));
		assertFalse(comprobador.ComprobarGanador(tableroNoGanadorUno));
		assertFalse(comprobador.ComprobarGanador(tableroNoGanadorDos));
		assertFalse(comprobador.ComprobarGanador(tableroNoGanadorTres));
	}

}
