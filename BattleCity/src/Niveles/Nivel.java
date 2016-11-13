package Niveles;

import java.awt.Point;
import java.awt.Rectangle;

import Objetos.DisparoJugador;
import Tanques.Jugador;

/**
 * Clase abstracta Nivel.
 * @author Artola, Fiore, Jouglard.
 *
 */
public abstract class Nivel {
	/**
	 * Atributos de la clase Nivel
	 */
	protected Jugador p;
	protected int resistencia;
	protected int velocidadMov;
	protected int velocidadDis;
	protected int disDisponibles;
	
	/**
	 * Metodo disparar: dependiendo del nivel, los disparos seran diferentes.
	 * @return Disparo.
	 */
	

	public void recibirDisparo(){
		resistencia--;
		if (resistencia==0)
			p.bajarVida();
	}

	public void moverRectangulo(int i) {
		Rectangle r=p.getRectangulo();
		
		switch(i){
			case 0:
				r.setLocation((int)r.getLocation().getX(),(int)r.getLocation().getY()-getvelocidad());
				break;
			case 1:
				r.setLocation((int)r.getLocation().getX(),(int)r.getLocation().getY()+getvelocidad());
				break;
			case 2:
				r.setLocation((int)r.getLocation().getX()-getvelocidad(),(int)r.getLocation().getY());
				break;
			case 3:
				r.setLocation((int)r.getLocation().getX()+getvelocidad(),(int)r.getLocation().getY());
				break;
		}
	}

	public int getvelocidad() {
		// TODO Auto-generated method stub
		return velocidadMov;
	}
	

	/**
	 * Metodo mover: dependiendo del nivel, la velocidad del moviemiento del jugador sera diferente.
	 * @param x: indica hacia donde debe moverse el jugador.
	 */
	public void mover(int x) {
		Point posicion=p.getPosicion();
		switch (x) {
		case 0:
			if(posicion.getY()-velocidadMov>=0){
				posicion.setLocation(posicion.getX(),posicion.getY()-velocidadMov);
				p.moverRectangulo(0);}
			p.setDireccion(0);
			break;
		case 1:
			if(posicion.getY()+velocidadMov<=832){
				posicion.setLocation(posicion.getX(),posicion.getY()+velocidadMov);
				p.moverRectangulo(1);}
			p.setDireccion(1);
			break;
		case 2:
			if(posicion.getX()-velocidadMov>=0){
				posicion.setLocation(posicion.getX()-velocidadMov,posicion.getY());
				p.moverRectangulo(2);}
			p.setDireccion(2);
			break;
		case 3:
			if(posicion.getX()+velocidadMov<=832){
				posicion.setLocation(posicion.getX()+velocidadMov,posicion.getY());
				p.moverRectangulo(3);}
			p.setDireccion(3);

		default:
			break;
		}

	}
	
	public DisparoJugador disparar() {
		//p es de tipo Jugador
		int x=(int)p.getPosicion().getX();
		int y=(int)p.getPosicion().getY();
		
		if (p.getDireccion()==0)
			y = y-32; //abajo
		else
			if (p.getDireccion()==1)
				y=y+32; //arriba
			else
				if (p.getDireccion()==2)
					x = x-32; //izquierda
				else
					x = x+32; //derecha
		DisparoJugador d=null;
		if (p.getCantidadDisparos()==0){		
			d= new DisparoJugador(velocidadDis,x,y,p.getDireccion());
			disDisponibles--;
		}
		return d;
	}

	public int getDisparosDisponibles(){
		return disDisponibles;
	}
	public void setDisparosDisponibles(int x){
		disDisponibles=x;
	}
}
	

