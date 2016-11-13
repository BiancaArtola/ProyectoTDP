package Tanques;

import java.awt.Point;

import Objetos.Disparo;
import Objetos.DisparoEnemigo;

/**
 * Clase abstracta Enemigo, extiende Tanque.
 * Modela el tanque de los enemigos.
 * @author Artola, Fiore, Jouglard.
 *
 */
public abstract class Enemigo extends Tanque {
	/**
	 * Atributos de la clase abstracta Enemigo
	 */
	protected int puntaje;
	protected int velocidadMov,velocidadDis;
	protected int resistencia;
	protected int disparosDisponibles;
	protected boolean choco;
	
	/**
	 * Metodo para obtener el puntaje del enemigo.
	 * @return int: puntaje del enemigo.
	 */
	public int getPuntaje() {
		return puntaje;
	}

	public void moverRectangulo(int x){
			switch(x){
				case 0:
					r.setLocation((int)r.getLocation().getX(),(int)r.getLocation().getY()-velocidadMov);
					break;
				case 1:
					r.setLocation((int)r.getLocation().getX(),(int)r.getLocation().getY()+velocidadMov);
					break;
				case 2:
					r.setLocation((int)r.getLocation().getX()-velocidadMov,(int)r.getLocation().getY());
					break;
				case 3:
					r.setLocation((int)r.getLocation().getX()+velocidadMov,(int)r.getLocation().getY());
					break;
			
			}
	}
	
	public void mover(int x) {
		if (!muerto){
			Point posicion=this.getPosicion();
			switch (x) {
			case 0:
				if(posicion.getY()-velocidadMov>=0){
					posicion.setLocation(posicion.getX(),posicion.getY()-velocidadMov);
					grafico.setLocation(posicion);
					grafico.setIcon(imagen[0]);
					r.setLocation((int)r.getLocation().getX(),(int)r.getLocation().getY()-velocidadMov);
				}
				this.setDireccion(0);
				break;
			case 1:
				if(posicion.getY()+velocidadMov<=832){
					posicion.setLocation(posicion.getX(),posicion.getY()+velocidadMov);
					grafico.setLocation(posicion);
					grafico.setIcon(imagen[1]);
					r.setLocation((int)r.getLocation().getX(),(int)r.getLocation().getY()+velocidadMov);
				}
				this.setDireccion(1);
				break;
			case 2:
				if(posicion.getX()-velocidadMov>=0){
					posicion.setLocation(posicion.getX()-velocidadMov,posicion.getY());
					grafico.setLocation(posicion);
					grafico.setIcon(imagen[2]);
					r.setLocation((int)r.getLocation().getX()-velocidadMov,(int)r.getLocation().getY());
				}
				this.setDireccion(2);
				break;
			case 3:
				if(posicion.getX()+velocidadMov<=832){
					posicion.setLocation(posicion.getX()+velocidadMov,posicion.getY());
					grafico.setLocation(posicion);
					grafico.setIcon(imagen[3]);
					r.setLocation((int)r.getLocation().getX()+velocidadMov,(int)r.getLocation().getY());
				}
				this.setDireccion(3);
			default:
				break;
			}

		}
	}
	
	
	public void chocoDisparo(){
		disparosDisponibles++;
	}
	
	public Disparo disparar() {
		//p es de tipo Jugador
				int x=(int)this.getPosicion().getX();
				int y=(int)this.getPosicion().getY();
				
				if (this.getDireccion()==0)
					y = y-32; //abajo
				else
					if (this.getDireccion()==1)
						y=y+32; //arriba
					else
						if (this.getDireccion()==2)
							x = x-32; //izquierda
						else
							x = x+32; //derecha
				Disparo d=null;	
				if (disparosDisponibles>0){
					d= new DisparoEnemigo(velocidadDis,x,y,this.getDireccion());
					disparosDisponibles--;
				}
				return d;
	}

	public void recibirDisparo() {
		resistencia--;
		if (resistencia==0)
			this.destruir();
	}
	public abstract Tanque getNuevoTanque();
}
	

