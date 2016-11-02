package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitores.Visitor;
import Visitores.VisitorDisparoEnemigo;
import Visitores.VisitorDisparoJugador;

/**
 * Clase DisparoEnemigo, que extiende Disparo. 
 * Modela solo el disparo de los enemigos.
 * @author Artola, Fiore, Jouglard.
 *
 */
public class DisparoEnemigo extends Disparo {
	
	/**
	 * Constructor de la clase DisparoEnemigo.
	 */
	public DisparoEnemigo(int v,int x,int y,int dir){
		direccion=dir;
		switch(direccion){
			case 0: //Ariba
				grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Images/balaArriba.png")));
				break;
			case 1: //Abajo
				grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Images/balaAbajo.png")));
				break;
			case 2: //Izquierda
				grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Images/balaIzquierda.png")));
				break;
			case 3: //Derecha
				grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Images/bala.png")));
				break;
		}
		
		velocidad=v;
		grafico.setSize(64,64);
		posicion=new Point(x,y);
		miVisitor=new VisitorDisparoEnemigo();
	}

	@Override
	public boolean colisionar(Visitor visitor) {
		return false;
	}
}
