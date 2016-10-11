package Objetos;

import Visitores.VisitorDisparoEnemigo;

/**
 * Clase DisparoEnemigo, que extiende Disparo. 
 * Modela solo el disparo de los enemigos.
 * @author Artola, Fiore, Jouglard.
 *
 */
public class DisparoEnemigo extends Disparo {
	
	/**
	 * Constructor de la clase DisparoEnemigo.
	 */
	public DisparoEnemigo(){
		miVisitor=new VisitorDisparoEnemigo();
	}
}
