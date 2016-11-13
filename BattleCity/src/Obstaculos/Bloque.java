package Obstaculos;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitores.*;

/**
 * Clase Bloque, extiende de la clase Obstaculo.
 * @author Artola, Fiore, Jouglard.
 *
 */
public class Bloque extends Obstaculo {

	/**
	 * Constructor de la clase Bloque.
	 * @param m: posicion en la cual se encuentra un bloque en el mapa. Tipo: Point.
	 */
	public Bloque(Point m){
		puedeContener=false;
		imagen=new ImageIcon[4];
		posicion=m;
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/Battle_City_wall.png"));;
		grafico=new JLabel(imagen[0]);
		grafico.setLocation(m);
		grafico.setSize(64,64);
		miVisitor=new VisitorObstaculoNoTransitable();
		r=new Rectangle();
		r.setBounds((int)m.getX(),(int)m.getY(),64,64);
		vida=1;
	}

	/**
	 * Metodo colisionar.
	 */
	@Override
	public boolean colisionar(Visitor visitor) {
		visitor.VisitarObstaculo(this);
		return true;
	}

	@Override
	public boolean recibirDisparo() {
		return false;	
	}

}
