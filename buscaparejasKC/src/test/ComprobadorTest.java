package test;



import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import control.Comprobador;
import modelo.Casilla;
import modelo.Tablero;

public class ComprobadorTest {

	@Test
	public void testCompararCasilla() {
		
		Comprobador comprobador = new Comprobador(null);
		
		Casilla igualUno = new Casilla(1);
		igualUno.setVisible(true);
		
		Casilla igualDos = new Casilla(1);
		igualDos.setVisible(true);
		
		Casilla distinta = new Casilla(2);
		distinta.setVisible(true);
		
		assertTrue(comprobador.CompararCasilla(igualUno, igualDos));
		assertFalse(comprobador.CompararCasilla(igualDos, distinta));
	}

	@Ignore
	void testComprobarGanador() {
		
		
		Casilla visible = new Casilla(1);
		visible.setVisible(true);
		
		Casilla noVisible = new Casilla(2);
		noVisible.setVisible(false);
		
		Casilla ganador [][] = {{visible,visible},{visible,visible},{visible,visible},{visible,visible}};
		Tablero tableroGanador = new Tablero(0,0);
		tableroGanador.setCasilla(ganador);
		
		Casilla noGanadorUno [][] = {{noVisible,visible},{visible,visible},{visible,visible},{visible,visible}};
		Tablero tableroNoGanadorUno = new Tablero(0,0);
		tableroGanador.setCasilla(noGanadorUno);
		
		Casilla noGanadorDos [][] = {{visible,visible},{visible,visible},{visible,visible},{visible,noVisible}};
		Tablero tableroNoGanadorDos = new Tablero(0,0);
		tableroGanador.setCasilla(noGanadorDos);
		
		Casilla noGanadorTres [][] = {{noVisible,noVisible},{noVisible,noVisible},{noVisible,noVisible},{noVisible,noVisible}};
		Tablero tableroNoGanadorTres = new Tablero(0,0);
		tableroGanador.setCasilla(noGanadorTres);
		
		Comprobador comprobador = new Comprobador(tableroGanador);
		assertTrue(comprobador.ComprobarGanador());
		comprobador = new Comprobador(tableroNoGanadorUno);
		assertFalse(comprobador.ComprobarGanador());
		comprobador = new Comprobador(tableroNoGanadorDos);
		assertFalse(comprobador.ComprobarGanador());
		comprobador = new Comprobador(tableroNoGanadorTres);
		assertFalse(comprobador.ComprobarGanador());
	}

}
