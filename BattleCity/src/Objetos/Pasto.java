package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Pasto extends Obstaculo {

	public Pasto(Point m,ImageIcon i){
		imagen=new ImageIcon[4];
		posicion=m;
		imagen[0]=i;
	}
	
	
	
	@Override
	public void colisionar() {
		// TODO Auto-generated method stub

	}

}
