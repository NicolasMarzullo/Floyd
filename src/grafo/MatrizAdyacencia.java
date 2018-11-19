package grafo;

public class MatrizAdyacencia {
	private int[][] matriz;

	public MatrizAdyacencia(int cantidadNodos) {
		this.matriz = new int[cantidadNodos][cantidadNodos];

		// Para floyd necesito tener 0 en la diagonal princial
		for (int i = 0; i < cantidadNodos; i++) {
			for (int j = 0; j < cantidadNodos; j++) {
				this.matriz[i][j] = Grafo.INFINITO;
			}
		}

	}

	public void setValor(int fila, int columna, int peso) {
		this.matriz[fila][columna] = peso;
	}

	public int getValor(int fila, int columna) {
		return this.matriz[fila][columna];
	}
}
