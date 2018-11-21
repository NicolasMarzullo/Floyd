package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	private List<Nodo> nodos;
	private int cantidadDeNodos;
	private MatrizAdyacencia matrizAdyacencia;

	static final int INFINITO = 2147483647;
	
	public Grafo(int cantidadDeNodos) {
		this.cantidadDeNodos = cantidadDeNodos;
		this.nodos = new ArrayList<>();

		for (int i = 0; i < cantidadDeNodos; i++) {
			nodos.add(new Nodo(i));
		}

		this.matrizAdyacencia = new MatrizAdyacencia(cantidadDeNodos);
	}
	
	public void setValor(int fila, int columna, int valor) {
		this.matrizAdyacencia.setValor(fila, columna, valor);
	}

	public int[][] calcularFloyd() {

		int[][] matrizCostoTotal = new int[this.cantidadDeNodos][this.cantidadDeNodos];
		int costoDeIaJ;
		int costoDeIaK;
		int costoDeKaJ;
		
		
		// duplico la matriz
		for (int i = 0; i < this.cantidadDeNodos; i++) {
			for (int j = 0; j < this.cantidadDeNodos; j++) {
				matrizCostoTotal[i][j] = this.matrizAdyacencia.getValor(i, j);
			}
		}

		for (int k = 0; k < this.cantidadDeNodos; k++) {
			for (int i = 0; i < this.cantidadDeNodos; i++) {
				for (int j = 0; j < this.cantidadDeNodos; j++) {
					if (i != k && j != k && i != j && matrizCostoTotal[i][k] != Grafo.INFINITO &&
							matrizCostoTotal[k][j] != Grafo.INFINITO) {
						// calculos
						costoDeIaJ = matrizCostoTotal[i][j];
						costoDeIaK = matrizCostoTotal[i][k];
						costoDeKaJ = matrizCostoTotal[k][j];
						
						if((costoDeIaK+ costoDeKaJ)< costoDeIaJ) {
							matrizCostoTotal[i][j] = (costoDeIaK + costoDeKaJ);
						}
					}
				}
			}
		}
		
		return matrizCostoTotal;
	}

}
