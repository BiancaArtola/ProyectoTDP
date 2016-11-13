package Niveles;

import java.awt.Point;

import Objetos.DisparoJugador;
import Tanques.Jugador;
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
		resistencia=1;
		velocidadMov=16;
		disDisponibles=1;
		velocidadDis=16;
	}

}
