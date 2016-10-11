package Objetos;
import Visitores.*;

/**
 * Clase abstracta Disparo, extiende GameObject.
 * @author Artola, Fiore, Jouglard.
 *
 */
public abstract class Disparo extends GameObject {
	/**
	 * Atributos de la clase Disparo.
	 */
	protected VisitorDisparo miVisitor;

	/**
	 * Metodo colisionar
	 */
	public void colisionar() {

	}

	/**
	 * @return miVisitor de tipo Visitor.
	 */
	public Visitor getVisitor(){
		return miVisitor;
	}

}
