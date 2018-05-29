package lcd_refactor.LCD_PSL.lector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import lcd_refactor.LCD_PSL.procesador.ProcesadorImplement;
import lcd_refactor.LCD_PSL.util.MensajeroImplement;
import lcd_refactor.LCD_PSL.validador.ValidadorImplement;

public class LectorImplement {

	private ValidadorImplement validador;
	private MensajeroImplement mensajero;
	private ProcesadorImplement procesador;

	static final String CADENA_FINAL = "0,0";
	static final String ESPACIO_DIGITOS = "Espacio entre Digitos (0 a 5): ";
	static final String ENTRADA = "Entrada: ";
	static final String ERROR = "Error: ";

	Scanner lector = new Scanner(System.in);

	public LectorImplement() {

		validador = new ValidadorImplement();
		mensajero = new MensajeroImplement();
		procesador = new ProcesadorImplement();
	}

	public void leerConsola() {
		String comando;
		int espacioDig = 0;

		try {
			mensajero.mostrarMensaje(ESPACIO_DIGITOS);
			comando = lector.next();

			// Valida si es un numero
			if (validador.isNumeric(comando)) {
				espacioDig = Integer.parseInt(comando);
			}

			// se valida que el espaciado este entre 0 y 5
			validador.validarEspaciado(espacioDig);

			procesarLectura(comando, espacioDig);
			// Cerramos el lector
			lector.close();
		} catch (Exception ex) {
			System.out.println(ERROR + ex.getMessage());
		}

	}

	public void procesarLectura(String comando, int espacioDig) {
		// Establece los segmentos de cada numero
		List<String> listaComando = new ArrayList<>();

		do {
			mensajero.mostrarMensaje(ENTRADA);
			comando = lector.next();
			if (!comando.equalsIgnoreCase(CADENA_FINAL)) {
				listaComando.add(comando);
			}
		} while (!comando.equalsIgnoreCase(CADENA_FINAL));

		Iterator<String> iterator = listaComando.iterator();
		while (iterator.hasNext()) {
			try {
				procesador.procesar(iterator.next(), espacioDig);
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}
	}

}
