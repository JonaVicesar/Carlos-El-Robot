package juegodeltriangulo;

import uni.robot.*; 

public class RobotJugador2 extends RobotJugador1 {
	private static final int MAX_EMPTY_STEPS = 2;

	public RobotJugador2(Mundo m) {
		super(m);	
	}
	public RobotJugador2(Mundo m, int fila, int columna, int dir, int capBol, int cantConos) {
	    super(m, fila, columna, dir, capBol, cantConos);   
	}
	/**
	 * Guarda todos los conos alineados,
	 * El robot debe estar en la fila de los conos que se desean quitar.
	 * Si el robot no encuentra conos hasta dos pasos despues se detiene.
	 * @author Jona
	 */
	public void guardarConosAlineados() {
		boolean hayConos = true;
		while(hayConos) {
			int pasos = 0;
			while(!hayCono() && pasos < MAX_EMPTY_STEPS) {
				this.avanzar();
				pasos++;
			}
			if(hayCono()) {
				this.guardarCono();
				this.avanzar();
			}
			else {
				hayConos = false;
			}
		}
	}
	/**
	 * @param cantidad la cantidad de triangulos que se van a reconstruir
	 * @param direccion direccion contraria a los conos existentes
	 * @author Jona
	 */
	public void reHacerTriangulos(int cantidad, String direccion){
		this.guardarConosAlineados();
		this.girar(direccion, 2, 180);
		this.avanzar();
		this.conosEnLugaresImpares(cantidad);
	}
}
	
