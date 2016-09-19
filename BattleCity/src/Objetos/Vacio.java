package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Vacio extends Obstaculo {

	public Vacio(Point m,ImageIcon i){
		imagen=new ImageIcon[4]; 
		posicion=m;
		imagen[0]=i;
	}
	
	@Override
	public void colisionar() {
		// TODO Auto-generated method stub

	}

}
