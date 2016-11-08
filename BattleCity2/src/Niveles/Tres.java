
package Niveles;

import java.awt.Point;

import Objetos.DisparoJugador;
import Tanques.Jugador;

public class Tres extends Nivel {

	
	public Tres(Jugador j){
		p=j;
	}
	
	@Override
	public DisparoJugador disparar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mover(int x) {
		Point posicion=p.getPosicion();
		switch (x) {
		case 0:
			if(posicion.getY()-8>=0)
				posicion.setLocation(posicion.getX(),posicion.getY()-16);
			break;
		case 1:
			if(posicion.getY()+8<=832)
				posicion.setLocation(posicion.getX(),posicion.getY()+16);
			break;
		case 2:
			if(posicion.getX()-8>=0)
				posicion.setLocation(posicion.getX()-16,posicion.getY());
			break;
		case 3:
			if(posicion.getX()+8<=832)
				posicion.setLocation(posicion.getX()+16,posicion.getY());

		default:
			break;
		}

	}

}
