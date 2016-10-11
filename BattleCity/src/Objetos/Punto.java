package Objetos;

/**
 * Clase Punto.
 * @author Artola, Fiore, Jouglard.
 *
 */
public class Punto {
	/**
	 * Atributos de la clase Punto
	 */
	private int X;
	private int Y;

	/**
	 * Constructor de la clase Punto.
	 * @param x: posicion en X
	 * @param y: posicion en Y
	 */
	public Punto(int x,int y){
		this.X=x;
		this.Y=y;
	}

	/**
	 * 
	 * @return la posicion en X, tipo int.
	 */
	public int getX(){
		return X;
	}

	/**
	 * 
	 * @return la posicion en Y, tipo int.
	 */
	public int getY(){
		return Y;
	}
}
