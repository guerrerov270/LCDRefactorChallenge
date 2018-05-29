package lcd_refactor.LCD_PSL.validador;

public class ValidadorImplement {

	/**
	 * Metodo encargado de validar si una cadena es numerica
	 * 
	 * @param cadena
	 *            Cadena
	 */
	public boolean isNumeric(String cadena) {
		boolean respuesta;
		try {
			Integer.parseInt(cadena);
			respuesta = true;
		} catch (NumberFormatException ex) {
			respuesta = false;
			throw new IllegalArgumentException("Cadena " + cadena
					+ " no es un entero");
		}
		return respuesta;
	}

	/**
	 * Método que valida que el espaciado esté entre 0 y 5
	 * 
	 * @param espacioDig
	 *            : Valor numérico para el espacio ingresado por el usuario
	 */
	public boolean validarEspaciado(int espacioDig) {
		boolean respuesta;
		// se valida que el espaciado este entre 0 y 5
		if (espacioDig < 0 || espacioDig > 5) {
			respuesta = false;
			throw new IllegalArgumentException("El espacio entre "
					+ "digitos debe estar entre 0 y 5");
		} else {
			respuesta = true;
		}
		return respuesta;
	}

}
