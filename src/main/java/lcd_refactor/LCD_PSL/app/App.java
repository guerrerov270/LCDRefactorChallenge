package lcd_refactor.LCD_PSL.app;

import lcd_refactor.LCD_PSL.lector.LectorImplement;


public class App {

	
	private static LectorImplement lector;
	
	public static void main(String[] args) {
		
		lector= new LectorImplement();
		lector.leerConsola();

	}

}
