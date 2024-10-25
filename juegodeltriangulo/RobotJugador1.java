package juegodeltriangulo;
import uni.robot.Mundo;
import uni.robot.Robot;

public class RobotJugador1 extends Robot {
	
	//Constantes
	private static final int ANGULO_180_GRADOS = 180; 
	private static final int ANGULO_90_GRADOS = 90;
	private static final String DIRECCION_DERECHA = "r";
	private static final String DIRECCION_IZQUIERDA = "l";
	
	//Constructores
	public RobotJugador1(Mundo m) {
		super(m);	
	}
	
	public RobotJugador1(Mundo m, int fila, int columna, int dir, int capBol, int cantConos) {
	    super(m, fila, columna, dir, capBol, cantConos);   
	}
	
	
	/**
	 * Coloca conos solo en lugares pares
	 * @param cantidad recibe la cantidad de conos que se quieren colocar
	 * @author Jona
	 */
	public void conosEnLugaresPares(int cantidad) {
		int position = this.getColumna();
		while(cantidad > 0) {
			if(position%2 == 0 && cantidad != 0) {
				this.ponerCono();
				this.avanzar();
				cantidad -= 1;
			}
			else {
				this.avanzar();
			}
			position += 1;	
		}			
	}
	/**
	 * Coloca conos solo en lugares impares
	 * @param cantidad recibe la cantidad de conos que se quieren colocar
	 * @author Jona
	 */
	public void conosEnLugaresImpares(int cantidad) {
		int posicion = this.getColumna();
		while(cantidad > 0) {
			if(posicion%2 != 0) {
				this.ponerCono();
				this.avanzar();
				cantidad -= 1;
			}
			else {
				this.avanzar();
			}
			posicion += 1;
		}
	}
	/*	
	 * El robot gira y avanza en la direccion contraria
	 * @param direccion "l"(izquierda) "r" derecha, direccion hacia donde gira el robot
	 * @param pasos cantidad de pasos que da el robot antes de girar completamente
	 * @param medida elige si el robot debe seguir perpendicularmente o en sentido contrario(90, 180)
	 * @author Jona
	 */
	
	public void girar(String direccion, int pasos, int angulo) {
		switch(angulo) {
		case ANGULO_180_GRADOS:
			if(direccion.equals(DIRECCION_IZQUIERDA)) {
				this.girarIzquierda();
				for(int i = 0; i < pasos; i++ ) {
					this.avanzar();
				}
				this.girarIzquierda();
				this.avanzar();	
			}
			if(direccion.equals(DIRECCION_DERECHA)) {
				this.girarDerecha();
				for(int i = 0; i < pasos; i++ ) {
					this.avanzar();
				}
				this.girarDerecha();
				this.avanzar();	
			}	
			break;
		
		case ANGULO_90_GRADOS:
			if(direccion.equals(DIRECCION_IZQUIERDA)) {
				this.girarIzquierda();
				for(int i = 0; i < pasos; i++ ) {
					this.avanzar();
				}
			}
			if(direccion.equals(DIRECCION_DERECHA)) {
				this.girarDerecha();
				for(int i = 0; i < pasos; i++ ) {
					this.avanzar();
				}
			}
			break;
			}
	
}
	/**
	 * @param cantTriangulos cantidad de triangulos que el robot construira
	 * @param direccion la orientacion que tendran los triangulos
	 * @author Jona
	 */
	public void hacerTriangulos(int cantTriangulos, String direccion) {
	    this.conosEnLugaresPares(cantTriangulos + 1);//en lugares pares se coloca un cono de mas por la geometria del triangulo
	    this.girar(direccion, 1, 180);
	    this.conosEnLugaresImpares(cantTriangulos); 
	}

}
	
	


