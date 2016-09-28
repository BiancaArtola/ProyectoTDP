package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bloque extends Obstaculo {

	
	public Bloque(Point m){
		imagen=new ImageIcon[4];
		posicion=m;
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/Battle_City_wall.png"));;
		grafico=new JLabel(imagen[0]);
		grafico.setLocation(m);
		grafico.setSize(64,64);
	}
	@Override
	public void colisionar() {
		// TODO Auto-generated method stub

	}

}
