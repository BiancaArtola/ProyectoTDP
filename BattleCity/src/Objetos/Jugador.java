package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Jugador extends Tanque {

	
	public Jugador(){
		imagen=new ImageIcon[4];
		
		
		posicion=new Point(0,0);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/Images/up.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/Images/down.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/Images/left.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/Images/right.png"));
	}
	
	@Override
	
	public Disparo disparar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub
		
	}
	

}
