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
	protected VisitorDisparo miVisitor;
	protected int velocidad;

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
	}
	
	public void mover(int x) {
		Point posicion=this.getPosicion();
		switch (x) {
		case 0:
			if(posicion.getY()-8>=0){
				posicion.setLocation(posicion.getX(),posicion.getY()-8);
				
			}
			break;
		case 1:
			if(posicion.getY()+8<=832){
				posicion.setLocation(posicion.getX(),posicion.getY()+8);}
			break;
		case 2:
			if(posicion.getX()-8>=0){
				posicion.setLocation(posicion.getX()-8,posicion.getY());}
			break;
		case 3:
			if(posicion.getX()+8<=832){
				posicion.setLocation(posicion.getX()+8,posicion.getY());
				}
		default:
			break;
		}
		

	}
}