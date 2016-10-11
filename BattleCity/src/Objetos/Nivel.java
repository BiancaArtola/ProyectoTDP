package Objetos;

/**
 * Clase abstracta Nivel.
 * @author Artola, Fiore, Jouglard.
 *
 */
public abstract class Nivel {
	/**
	 * Atributos de la clase Nivel
	 */
	protected Jugador p;
	
	/**
	 * Metodo disparar: dependiendo del nivel, los disparos seran diferentes.
	 * @return Disparo.
	 */
	public abstract Disparo disparar();
	
	/**
	 * Metodo mover: dependiendo del nivel, la velocidad del moviemiento del jugador sera diferente.
	 * @param x: indica hacia donde debe moverse el jugador.
	 */
	public abstract void mover(int x);
	
}
