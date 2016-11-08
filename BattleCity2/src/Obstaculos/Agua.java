package Obstaculos;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitores.*;
/**
 * Clase Agua, que extiende a la clase Obstaculo.
 * @author Artola, Fiore, Jouglard.
 *
 */
public class Agua extends Obstaculo {

	/**
	 * Constructor de la clase Agua
	 * @param m: indica la posicion en la cual se encuentra el Agua en el mapa. Tipo: Point/
	 */
	public Agua(Point m){
		imagen=new ImageIcon[4];
		posicion=m;
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/Agua.png"));
		grafico=new JLabel(imagen[0]);
		grafico.setLocation(m);
		grafico.setSize(64,64);
		miVisitor=new VisitorObstaculoNoTransitable();
		r=new Rectangle();
		r.setBounds((int)m.getX(),(int)m.getY(),64,64);
	}
	
	/**
	 * Metodo colisionar.
	 */
	public boolean colisionar(Visitor visitor) {
		return false;

	}

	@Override
	public boolean recibirDisparo() {
		return false;
		
	}

}
