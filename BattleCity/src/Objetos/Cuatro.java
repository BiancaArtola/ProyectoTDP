package Objetos;

import java.awt.Point;

/**
 * Clase Cuatro, extiende la clase Nivel.
 * @author Artola, Fiore, Jouglard.
 *
 */
public class Cuatro extends Nivel {

	/**
	 * Constructor de la clase Cuatro.
	 * @param j: de tipo Jugador.
	 */
	public Cuatro(Jugador j){
		p=j;
	}
	
	/**
	 * Metodo disparar
	 */
	public DisparoJugador disparar() {
		return null;
	}

	/**
	 * 
	 */
	public void mover(int x) {
		Point posicion=p.getPosicion();
		switch (x) {
		case 0:
			if(posicion.getY()-8>=0)
				posicion.setLocation(posicion.getX(),posicion.getY()-20);
			break;
		case 1:
			if(posicion.getY()+8<=832)
				posicion.setLocation(posicion.getX(),posicion.getY()+20);
			break;
		case 2:
			if(posicion.getX()-8>=0)
				posicion.setLocation(posicion.getX()-20,posicion.getY());
			break;
		case 3:
			if(posicion.getX()+8<=832)
				posicion.setLocation(posicion.getX()+20,posicion.getY());

		default:
			break;
		}

	}

}
