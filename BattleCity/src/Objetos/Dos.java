package Objetos;

import java.awt.Point;
/**
 * Clase Dos, extiende Nivel.
 * Modela el nivel dos del jugador.
 * @author Artola, Fiore, Jouglard.
 *
 */
public class Dos extends Nivel {

	/**
	 * Constructor de la clase Dos
	 * @param j: de tipo Jugador.
	 */
	public Dos(Jugador j){
		p=j;
	}

	@Override
	public Disparo disparar() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * En este nivel se aumenta la velocidad en la que el jugador se mueve.
	 * @param x: indica para donde mover el jugador.
	 */
	public void mover(int x) {
		Point posicion=p.getPosicion();
		switch (x) {
		case 0:
			if(posicion.getY()-8>=0)
				posicion.setLocation(posicion.getX(),posicion.getY()-12);
			break;
		case 1:
			if(posicion.getY()+8<=832)
				posicion.setLocation(posicion.getX(),posicion.getY()+12);
			break;
		case 2:
			if(posicion.getX()-8>=0)
				posicion.setLocation(posicion.getX()-12,posicion.getY());
			break;
		case 3:
			if(posicion.getX()+8<=832)
				posicion.setLocation(posicion.getX()+12,posicion.getY());

		default:
			break;
		}

	}

}
