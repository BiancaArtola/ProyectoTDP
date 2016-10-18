package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitores.*;
/**
 * Clase DisparoJugador, extiende Disparo.
 * Modela solo el disparo del jugador.
 * @author Artola, Fiore, Jouglard.
 *
 */
public class DisparoJugador extends Disparo {
	
	/**
	 * Atributos de la clase DisparoJugador.
	 * @param i 
	 */
	public DisparoJugador(int i,int x,int y,int dir){
		direccion=dir;
		switch(direccion){
			case 0:
				grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Images/balaArriba.png")));
				break;
			case 1:
				grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Images/balaAbajo.png")));
				break;
			case 2:
				grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Images/balaIzquierda.png")));
				break;
			case 3:
				grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Images/bala.png")));
				break;
		}
		miVisitor=new VisitorDisparoJugador();
		velocidad=i;
		//grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Images/bala.png")));
		grafico.setSize(64,64);
		posicion=new Point(x,y);
	}

	@Override
	public boolean colisionar(Visitor visitor) {
		return false;
	}
	

	
}
