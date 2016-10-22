package Objetos;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitores.*;

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
		vida=4;
		imagen=new ImageIcon[4];
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/LadrilloDibujo.png"));
		imagen[1]=new ImageIcon(this.getClass().getResource("/Images/LadrilloDibujo2.png"));
		posicion=m;
		grafico=new JLabel(imagen[0]);
		grafico.setLocation(m);
		grafico.setSize(64,64);
		miVisitor=new VisitorObstaculoNoTransitable();
	}

	@Override
	public boolean colisionar(Visitor visitor) {
		visitor.VisitarObstaculo(this);
		return true;
	}

	@Override
	public boolean recibirDisparo() {
		vida--;
		if (vida==3)
			grafico.setIcon(new ImageIcon(this.getClass().getResource("/Images/LadrilloDibujo2.png")));
		else if (vida==2)
			grafico.setIcon(new ImageIcon(this.getClass().getResource("/Images/LadrilloDibujo3.png")));
		else if (vida==1)
			grafico.setIcon(new ImageIcon(this.getClass().getResource("/Images/LadrilloDibujo4.png")));
		else if (vida==0)
			this.destruir();
		return true;
	}
	
	

}