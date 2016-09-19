package Objetos;

import javax.swing.ImageIcon;

public abstract class Tanque extends GameObject{

	protected int resistencia;
	protected int golpesrecibidos;
	protected int velocidadmovimiento, velocidaddisparo;
	
	
	public abstract Disparo disparar();
	
	public void mover(int x){
		switch (x) {
		case 0:
			if(posicion.getY()-8>=0)
				posicion.setLocation(posicion.getX(),posicion.getY()-8);
			break;
		case 1:
			if(posicion.getY()+8<=832)
				posicion.setLocation(posicion.getX(),posicion.getY()+8);
			break;
		case 2:
			if(posicion.getX()-8>=0)
				posicion.setLocation(posicion.getX()-8,posicion.getY());
			break;
		case 3:
			if(posicion.getX()+8<=832)
				posicion.setLocation(posicion.getX()+8,posicion.getY());

		default:
			break;
		}
	}
	
	public void destruir(){}
	

	public ImageIcon actualizarImagen(int x){
		return imagen[x];
	}
}
