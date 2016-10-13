package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitores.*;
/**
 * Clase abstracta GameObject.
 * @author Artola, Fiore, Jouglard.
 *
 */
public abstract class GameObject {
	/**
	 * Atributos de la clase abstracta GameObject.
	 */
	protected Point posicion;
	protected ImageIcon[] imagen;
	protected JLabel grafico;
	protected Visitor miVisitor;

	/**
	 * Retorna la posicion del objeto que realiza la llamada al metodo.
	 * @return la posicion del objeto que realiza la llamada al metodo, de tipo Point.
	 */
	public Point getPosicion(){
		return posicion;
	}

	/**
	 * Retorna las imagenes correspondientes al objeto que realiza la llamada al metodo
	 * @return las imagenes correspondientes al objeto que realiza la llamada al metodo, tipo ImageIcon[].
	 */
	public ImageIcon[] getImagen(){
		return imagen;
	}
	
	/**
	 * Metodo abstracto colisionar.
	 */
	public abstract boolean colisionar(Visitor visitor);
	
	/**
	 * Retorna el JLabel asociado al objeto que realiza la llamada al metodo.
	 * @return JLabel asociado al objeto que realiza la llamada al metodo.
	 */
	public JLabel getGrafico(){
		return grafico;
	}

	public Visitor getVisitor() {
		return miVisitor;
	}
}
