package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase Ladrillo, extiende Obstaculo.
 * Modela un tipo de obstaculo llamado Ladrillo.
 * @author Artola, Fiore, Jouglard.
 *
 */
public class Ladrillo extends Obstaculo {
	
	/**
	 * Constructor de la clase Ladrillo.
	 * @param m: indica la posicion en la cual se encuentra un determinado Ladrillo en el mapa.
	 */
	public Ladrillo(Point m){
		imagen=new ImageIcon[4];
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/Battle_City_bricks.png"));
		posicion=m;
		grafico=new JLabel(imagen[0]);
		grafico.setLocation(m);
		grafico.setSize(64,64);
	}
	
	public void colisionar() {
		// TODO Auto-generated method stub

	}

}
