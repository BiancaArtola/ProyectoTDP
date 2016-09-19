package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Ladrillo extends Obstaculo {

	
	public Ladrillo(Point m,ImageIcon i){
		imagen=new ImageIcon[4];
		posicion=m;
		imagen[0]=i;
	}
	
	public void colisionar() {
		// TODO Auto-generated method stub

	}

}
