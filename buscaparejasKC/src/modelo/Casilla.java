package modelo;

public class Casilla {
private boolean visible = false;
private int identificador;



	public Casilla(int identificador) {
	super();
	this.identificador = identificador;
}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
}