package control;

public enum Dificultad {
	facil(2), medio(6), dificil(8);
	private int valor;

	private Dificultad(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}
