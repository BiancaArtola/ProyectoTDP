package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;

public class TanqueBasico extends Enemigo {

	
	public TanqueBasico(int i, int j){
		imagen=new ImageIcon[4];
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/Battle_City_Tank_Enemy1.png"));
		puntaje=100;
		posicion=new Point(400,400);
	}
	
	@Override
	public Disparo disparar() {
		return null;
	}

	@Override
	public void colisionar() {


	}

}
