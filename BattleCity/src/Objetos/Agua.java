package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Agua extends Obstaculo {

	public Agua(Point m){
		imagen=new ImageIcon[4];
		posicion=m;
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/Battle_City_water.png"));
		grafico=new JLabel(imagen[0]);
		grafico.setLocation(m);
		grafico.setSize(64,64);
	}
	
	@Override
	public void colisionar() {
		// TODO Auto-generated method stub

	}

}
