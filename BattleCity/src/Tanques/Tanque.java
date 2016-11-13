package Tanques;
import javax.swing.ImageIcon;

import Objetos.Disparo;
import Objetos.GameObject;
import Visitores.Visitor;
import Visitores.VisitorObstaculoTransitable;

/**
 * Clase Tanque, extiende GameObject.
 * Es la clase que modela el tanque del jugador.
 * @author Artola, Fiore, Jouglard.
 *
 */
public abstract class Tanque extends GameObject{
	/**
	 * Atributos de la clase Tanque.
	 */
	protected Disparo[] disparos;
	protected int direccion;
	protected int golpesrecibidos;
	protected boolean muerto;
	
	/**
	 * Metodo abstracto disparar.
	 * @return Disparo
	 */
	public abstract Disparo disparar();
	
	/**
	 * Mueve el 
	 * @param x
	 */
	public abstract void mover(int x);
	
	public void destruir(){
		//this.getGrafico().setIcon(new ImageIcon(this.getClass().getResource("/Images/vacio.png")));
		muerto=true;	
		miVisitor=new VisitorObstaculoTransitable();
	}
	

	public ImageIcon actualizarImagen(int x){
		return imagen[x];
	}
	
	public boolean colisionar(Visitor visitor){
		return visitor.VisitarTanque(this);
	}
	
	public int getDireccion(){
		return direccion;
	}
	public void setDireccion(int x){
		direccion=x;
	}
	
	public int getCantidadDisparos(){
		return disparos.length;
	}

	public boolean getMuerto() {
		// TODO Auto-generated method stub
		return muerto;
	}
	public void setMuerto(boolean m){
		muerto=m;
	}
}
