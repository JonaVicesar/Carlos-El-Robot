package juegodeltriangulo;

import uni.robot.*;

public class Main {
	public static void main(String[] args) {
		Mundo jona = new Mundo("Hello World", 16, 15);
		RobotJugador1 sonic = new RobotJugador1(jona, 8, 1, Robot.ESTE, 90, 20);
		RobotJugador2 mario = new RobotJugador2(jona, 9, 1, Robot.ESTE, 90, 20);
		//El robot sonic hace 5 triangulos invertidos
		sonic.hacerTriangulos(5, "r");
		//El robot sonic se dirige a su lugar original
		sonic.avanzar();
		//sonic.girar("r", 5, 90);
		sonic.girar("r", 1, 90);
		//El robot mario recoge las puntas de los triangulos y los invierte
		mario.reHacerTriangulos(5, "l");
		//El robot mario se dirige a su lugar original
		mario.avanzar();
		mario.girar("l", 2, 90);
		//mario.girar("l", 2, 180);
	}
}
