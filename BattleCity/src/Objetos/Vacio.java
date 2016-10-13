package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitores.*;

public class Vacio extends Obstaculo {

	public Vacio(Point m){
		imagen=new ImageIcon[4]; 
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/vacio.png"));
		posicion=m;
		grafico=new JLabel(imagen[0]);
		grafico.setLocation(m);
		grafico.setSize(64,64);
		miVisitor=new VisitorObstaculoTransitable();
	}
	
	@Override
	public boolean colisionar(Visitor visitor) {
		return false;

	}
	
	public void destruir(){
		
	}

	@Override
	public boolean recibirDisparo() {
		return false;		
	}

}
