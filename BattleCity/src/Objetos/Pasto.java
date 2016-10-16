package Objetos;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
		miVisitor=new VisitorObstaculoTransitable();
	}

	@Override
	public boolean colisionar(Visitor visitor) {
		visitor.VisitarObstaculo(this);
		return false;
	}

	@Override
	public boolean recibirDisparo() {
		return false;
		
	}
	
	

}
