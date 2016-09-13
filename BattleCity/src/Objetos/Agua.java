package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Agua extends Obstaculo {

	public Agua(Point m,ImageIcon[] i){
		posicion=m;
		imagen=i;
	}
	
	@Override
	public void colisionar() {
		// TODO Auto-generated method stub

	}

}
