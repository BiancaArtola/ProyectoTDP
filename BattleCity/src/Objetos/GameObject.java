package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
	public abstract void colisionar();
	
	/**
	 * Retorna el JLabel asociado al objeto que realiza la llamada al metodo.
	 * @return JLabel asociado al objeto que realiza la llamada al metodo.
	 */
	public JLabel getGrafico(){
		return grafico;
	}

	public Object getVisitor() {
		// TODO Auto-generated method stub
		return null;
	}
}
