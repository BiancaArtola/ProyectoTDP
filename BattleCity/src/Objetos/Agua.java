package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/Battle_City_water.png"));
		grafico=new JLabel(imagen[0]);
		grafico.setLocation(m);
		grafico.setSize(64,64);
	}
	
	/**
	 * Metodo colisionar.
	 */
	public void colisionar() {
		// TODO Auto-generated method stub

	}

}
