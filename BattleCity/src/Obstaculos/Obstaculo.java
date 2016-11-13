package Obstaculos;

import javax.swing.ImageIcon;

import Objetos.GameObject;
import Visitores.*;

/**
 * Clase abstracta Obstaculo, extiende GameObject
 * @author Artola, Fiore, Jouglard.
 *
 */
public abstract class Obstaculo extends GameObject {
	/**
	 * Atributos de la clase Obstaculo.
	 */
	
	protected int vida;
	protected boolean puedeContener;
	/**
	 * Metodo destruir: le asigna al obstaculo que recibe el mensaje la imagen de vacio.
	 */
	public void destruir(){
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/Images/vacio.png")));
		
		miVisitor=new VisitorObstaculoTransitable();
	}
	
	public abstract boolean recibirDisparo();

	public int getVida() {
		// TODO Auto-generated method stub
		return vida;
	}
	public void moverRectangulo(int x){
		
	}
	public boolean getPuedeContener(){
		return puedeContener;
	}
}
