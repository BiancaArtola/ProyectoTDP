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
	protected boolean choco;

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
				if(posicion.getY()-velocidad>=0){
					posicion.setLocation(posicion.getX(),posicion.getY()+(-velocidad));
					grafico.setLocation(posicion);
					this.moverRectangulo(0);
				}
				else
					choco=true;
				break;
			case 1: //ABAJO
				if(posicion.getY()+velocidad<=832){
					posicion.setLocation(posicion.getX(),posicion.getY()+velocidad);
					grafico.setLocation(posicion);
					this.moverRectangulo(1);
				}
				else
					choco=true;
				break;
			case 2: //IZQUIERDA
				if(posicion.getX()-velocidad>=0){
					posicion.setLocation(posicion.getX()+(-velocidad),posicion.getY());
					grafico.setLocation(posicion);
					this.moverRectangulo(2);
				}
				else
					choco=true;
				break;
			case 3: //DERECHA
				if(posicion.getX()+velocidad<=832){
					posicion.setLocation(posicion.getX()+velocidad,posicion.getY());
					grafico.setLocation(posicion);
					this.moverRectangulo(3);
				}
				else
					choco=true;
		default:
			break;
		}
		

	}
	
	public void moverRectangulo(int x){
		switch(x){
			case 0:
				r.setLocation((int)r.getLocation().getX(),(int)r.getLocation().getY()-velocidad);
				break;
			case 1:
				r.setLocation((int)r.getLocation().getX(),(int)r.getLocation().getY()+velocidad);
				break;
			case 2:
				r.setLocation((int)r.getLocation().getX()-velocidad,(int)r.getLocation().getY());
				break;
			case 3:
				r.setLocation((int)r.getLocation().getX()+velocidad,(int)r.getLocation().getY());
				break;
		
		}
	}
	
	public void setChoco(boolean b){
		choco=b;
	}
	
	public boolean getChoco(){
		return choco;
	}
}