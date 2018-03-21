package control;

public enum Dificultad {
	facil(6), medio(8), dificil(10);
	private int valor;

	private Dificultad(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}
