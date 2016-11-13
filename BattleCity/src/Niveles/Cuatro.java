package Niveles;

import java.awt.Point;

import Objetos.DisparoJugador;
import Tanques.Jugador;

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
		resistencia=4;
		velocidadMov=8;
		velocidadDis=32;
		disDisponibles=3;
	}
	
	
}