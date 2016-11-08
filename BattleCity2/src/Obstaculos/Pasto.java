package Obstaculos;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.G;
import Visitores.*;

/**
 * Clase Pasto, extiende Obstaculo.
 * Modela un tipo de Obstaculo llamado Pasto.
 * @author Artola, Fiore, Jouglard.
 *
 */
public class Pasto extends Obstaculo {
	/**
	 * Constructor de la clase Pasto
	 * @param m: posicion en la cual se ubicara en el mapa el Pasto.
	 */
	public Pasto(Point m){
		
		imagen=new ImageIcon[4];
		posicion=m;
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/Pasto.png"));;
		grafico=new JLabel(imagen[0]);
		grafico.setLocation(m);
		grafico.setSize(64,64);
		//g.setComponentZOrder(grafico, 1);
		miVisitor=new VisitorObstaculoAtravesable();
		r=new Rectangle();
		r.setBounds((int)m.getX(),(int)m.getY(),64,64);
	}
	

	@Override
	public boolean colisionar(Visitor visitor) {
		//grafico.setComponentZOrder(getGrafico(), 1);
		visitor.VisitarObstaculo(this);
		return false;
	}

	@Override
	public boolean recibirDisparo() {
		
		return true;
	}
	
	

}
