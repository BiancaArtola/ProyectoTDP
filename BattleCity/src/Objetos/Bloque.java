package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Bloque extends Obstaculo {

	
	public Bloque(Point m,ImageIcon[] i){
		posicion=m;
		imagen=i;
	}
	@Override
	public void colisionar() {
		// TODO Auto-generated method stub

	}

}
