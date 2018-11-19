package tests;

import org.junit.Test;

import grafo.Grafo;

public class testFloyd {
	@Test
	public void ejCarpeta() {
		Grafo gFloyd = new Grafo(3);
		gFloyd.setValor(0, 1, 8);
		gFloyd.setValor(0, 2, 5);
		gFloyd.setValor(1, 0, 2);
		gFloyd.setValor(1, 0, 2);
		gFloyd.setValor(2, 1, 1);
		int[][] matrizResultado = gFloyd.calcularFloyd();

		for (int i = 0; i < matrizResultado.length; i++) {
			for (int j = 0; j < matrizResultado.length; j++) {
				System.out.print(matrizResultado[i][j] + "  ");
			}
			System.out.println();
		}
	}
}