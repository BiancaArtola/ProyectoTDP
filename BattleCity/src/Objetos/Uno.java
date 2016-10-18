package Objetos;

import java.awt.Point;

public class Uno extends Nivel {

	public Uno(Jugador j){
		p=j;
	}
	
	@Override
	public DisparoJugador disparar() {
		DisparoJugador d=new DisparoJugador(64,(int)p.getPosicion().getX()-64,(int)p.getPosicion().getY(),p.getDireccion());
		return d;
	}

	@Override
	public void mover(int x) {
		Point posicion=p.getPosicion();
		switch (x) {
		case 0:
			if(posicion.getY()-64>=0){
				posicion.setLocation(posicion.getX(),posicion.getY()-64);
				p.setDireccion(0);}
			break;
		case 1:
			if(posicion.getY()+64<=832){
				posicion.setLocation(posicion.getX(),posicion.getY()+64);
				p.setDireccion(1);}
			break;
		case 2:
			if(posicion.getX()-64>=0){
				posicion.setLocation(posicion.getX()-64,posicion.getY());
				p.setDireccion(2);}
			break;
		case 3:
			if(posicion.getX()+64<=832){
				posicion.setLocation(posicion.getX()+64,posicion.getY());
				p.setDireccion(3);}

		default:
			break;
		}

	}

}
