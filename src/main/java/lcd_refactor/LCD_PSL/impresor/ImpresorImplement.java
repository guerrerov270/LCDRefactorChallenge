package lcd_refactor.LCD_PSL.impresor;

import lcd_refactor.LCD_PSL.creador.CreadorImplement;

public class ImpresorImplement {

	private CreadorImplement creador;
	private int size;

	static final String CARACTER_VERTICAL = "|";
	static final String CARACTER_HORIZONTAL = "-";
	static final String POSICION_X = "X";
	static final String POSICION_Y = "Y";

	// Calcula el numero de filasDig
	private int filasDig;
	private int columDig;
	private int totalFilas;
	private int totalColum;
	private String[][] matrizImpr;

	// Puntos fijos
	private final int[] pf1;
	private final int[] pf2;
	private final int[] pf3;
	private final int[] pf4;
	private final int[] pf5;

	public ImpresorImplement() {
		// Inicializa variables
		this.pf1 = new int[2];
		this.pf2 = new int[2];
		this.pf3 = new int[2];
		this.pf4 = new int[2];
		this.pf5 = new int[2];
		creador = new CreadorImplement();
	}

	/**
	 *
	 * Metodo encargado de un segmento a la matriz de Impresion
	 *
	 * @param segmento
	 *            Segmento a adicionar
	 */
	public void adicionarSegmento(int segmento) {

		switch (segmento) {
		case 1:
			creador.adicionarLinea(this.matrizImpr, this.pf1, POSICION_Y,
					this.size, CARACTER_VERTICAL);
			break;
		case 2:
			creador.adicionarLinea(this.matrizImpr, this.pf2, POSICION_Y,
					this.size, CARACTER_VERTICAL);
			break;
		case 3:
			creador.adicionarLinea(this.matrizImpr, this.pf5, POSICION_Y,
					this.size, CARACTER_VERTICAL);
			break;
		case 4:
			creador.adicionarLinea(this.matrizImpr, this.pf4, POSICION_Y,
					this.size, CARACTER_VERTICAL);
			break;
		case 5:
			creador.adicionarLinea(this.matrizImpr, this.pf1, POSICION_X,
					this.size, CARACTER_HORIZONTAL);
			break;
		case 6:
			creador.adicionarLinea(this.matrizImpr, this.pf2, POSICION_X,
					this.size, CARACTER_HORIZONTAL);
			break;
		case 7:
			creador.adicionarLinea(this.matrizImpr, this.pf3, POSICION_X,
					this.size, CARACTER_HORIZONTAL);
			break;
		default:
			break;
		}
	}

	/**
	 *
	 * Metodo encargado de imprimir un numero
	 *
	 * @param size
	 *            Tamaño Segmento Digitos
	 * @param numeroImp
	 *            Numero a Imprimir
	 * @param espacio
	 *            Espacio Entre digitos
	 */
	public void imprimirNumero(int size, String numeroImp, int espacio) {
		int pivotX = 0;
		char[] digitos;

		this.size = size;

		// Calcula el numero de filas cada digito
		this.filasDig = (2 * this.size) + 3;

		// Calcula el numero de columna de cada digito
		this.columDig = this.size + 2;

		// Calcula el total de filas de la matriz en la que se almacenaran los
		// digitos
		this.totalFilas = this.filasDig;

		// Calcula el total de columnas de la matriz en la que se almacenaran
		// los digitos
		this.totalColum = (this.columDig * numeroImp.length())
				+ (espacio * numeroImp.length());

		// crea matriz para almacenar los numero a imprimir
		this.matrizImpr = new String[this.totalFilas][this.totalColum];

		// crea el arreglo de digitos
		digitos = numeroImp.toCharArray();

		// Inicializa matriz
		for (int i = 0; i < this.totalFilas; i++) {
			for (int j = 0; j < this.totalColum; j++) {
				this.matrizImpr[i][j] = " ";
			}
		}

		for (char digito : digitos) {

			// Valida que el caracter sea un digito
			if (!Character.isDigit(digito)) {
				throw new IllegalArgumentException("Caracter " + digito
						+ " no es un digito");
			}

			int numero = Integer.parseInt(String.valueOf(digito));

			// Calcula puntos fijos
			this.pf1[0] = 0;
			this.pf1[1] = 0 + pivotX;

			this.pf2[0] = (this.filasDig / 2);
			this.pf2[1] = 0 + pivotX;

			this.pf3[0] = (this.filasDig - 1);
			this.pf3[1] = 0 + pivotX;

			this.pf4[0] = (this.columDig - 1);
			this.pf4[1] = (this.filasDig / 2) + pivotX;

			this.pf5[0] = 0;
			this.pf5[1] = (this.columDig - 1) + pivotX;

			pivotX = pivotX + this.columDig + espacio;

			creador.adicionarDigito(numero);
		}

		// Imprime matriz
		for (int i = 0; i < this.totalFilas; i++) {
			for (int j = 0; j < this.totalColum; j++) {
				System.out.print(this.matrizImpr[i][j]);
			}
			System.out.println();
		}
	}

}
