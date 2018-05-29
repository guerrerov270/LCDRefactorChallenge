package lcd_refactor.LCD_PSL.creador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lcd_refactor.LCD_PSL.impresor.ImpresorImplement;

public class CreadorImplement {

	private ImpresorImplement impresor;
	static final String POSICION_X = "X";

	public CreadorImplement() {
		// impresor = new ImpresorImplement();
	}

	/**
	 *
	 * Metodo encargado de definir los segmentos que componen un digito y a
	 * partir de los segmentos adicionar la representacion del digito a la
	 * matriz
	 *
	 * @param numero
	 *            Digito
	 */
	public void adicionarDigito(int numero) {

		// Establece los segmentos de cada numero
		List<Integer> segList = new ArrayList<>();

		switch (numero) {
		case 1:
			segList.add(3);
			segList.add(4);
			break;
		case 2:
			segList.add(5);
			segList.add(3);
			segList.add(6);
			segList.add(2);
			segList.add(7);
			break;
		case 3:
			segList.add(5);
			segList.add(3);
			segList.add(6);
			segList.add(4);
			segList.add(7);
			break;
		case 4:
			segList.add(1);
			segList.add(6);
			segList.add(3);
			segList.add(4);
			break;
		case 5:
			segList.add(5);
			segList.add(1);
			segList.add(6);
			segList.add(4);
			segList.add(7);
			break;
		case 6:
			segList.add(5);
			segList.add(1);
			segList.add(6);
			segList.add(2);
			segList.add(7);
			segList.add(4);
			break;
		case 7:
			segList.add(5);
			segList.add(3);
			segList.add(4);
			break;
		case 8:
			segList.add(1);
			segList.add(2);
			segList.add(3);
			segList.add(4);
			segList.add(5);
			segList.add(6);
			segList.add(7);
			break;
		case 9:
			segList.add(1);
			segList.add(3);
			segList.add(4);
			segList.add(5);
			segList.add(6);
			segList.add(7);
			break;
		case 0:
			segList.add(1);
			segList.add(2);
			segList.add(3);
			segList.add(4);
			segList.add(5);
			segList.add(7);
			break;
		default:
			break;
		}

		Iterator<Integer> iterator = segList.iterator();

		while (iterator.hasNext()) {
			impresor.adicionarSegmento(iterator.next());
		}
	}

	/**
	 *
	 * Metodo encargado de añadir una linea a la matriz de Impresion
	 *
	 * @param matriz
	 *            Matriz Impresion
	 * @param punto
	 *            Punto Pivote
	 * @param posFija
	 *            Posicion Fija
	 * @param size
	 *            Tamaño Segmento
	 * @param caracter
	 *            Caracter Segmento
	 */
	public void adicionarLinea(String[][] matriz, int[] punto, String posFija,
			int size, String caracter) {

		if (posFija.equalsIgnoreCase(POSICION_X)) {
			for (int y = 1; y <= size; y++) {
				int valor = punto[1] + y;
				matriz[punto[0]][valor] = caracter;
			}
		} else {
			for (int i = 1; i <= size; i++) {
				int valor = punto[0] + i;
				matriz[valor][punto[1]] = caracter;
			}
		}
	}

}
