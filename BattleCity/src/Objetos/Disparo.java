package Objetos;
import java.awt.Point;

import javax.swing.ImageIcon;

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
	protected Visitor miVisitor;
	protected int velocidad;
	protected int direccion;

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
	
	public void destruir(){
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/Images/vacio.png")));
		miVisitor=new VisitorObstaculoTransitable();
	}
	
	public void mover(int x) {
		Point posicion=this.getPosicion();
		switch (x) {
			case 0: //ARRIBA
				if(posicion.getY()-8>=0)
					posicion.setLocation(posicion.getX(),posicion.getY()+(-8));
				break;
			case 1: //ABAJO
				if(posicion.getY()+8<=832){
					posicion.setLocation(posicion.getX(),posicion.getY()+8);}
				break;
			case 2: //IZQUIERDA
				if(posicion.getX()-8>=0){
					posicion.setLocation(posicion.getX()+(-8),posicion.getY());}
				break;
			case 3: //DERECHA
				if(posicion.getX()+8<=832){
					posicion.setLocation(posicion.getX()+8,posicion.getY());
					}
		default:
			break;
		}
		

	}
}