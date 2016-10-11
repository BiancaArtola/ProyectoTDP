package Objetos;

/**
 * Clase abstracta Enemigo, extiende Tanque.
 * Modela el tanque de los enemigos.
 * @author Artola, Fiore, Jouglard.
 *
 */
public abstract class Enemigo extends Tanque {
	/**
	 * Atributos de la clase abstracta Enemigo
	 */
	protected int puntaje;
	
	/**
	 * Metodo para obtener el puntaje del enemigo.
	 * @return int: puntaje del enemigo.
	 */
	public int getPuntaje() {
		return puntaje;
	}

}
