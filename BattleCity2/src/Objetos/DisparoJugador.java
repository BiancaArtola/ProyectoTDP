package Objetos;

import java.awt.Point;
import java.awt.Rectangle;

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
	 * Constructor de la clase DisparoJugador
	 * @param i: velocidad
	 * @param x: pos en x a disparar
	 * @param y: pos en y a disparar
	 * @param dir: direccion en la cual hay que disparar
	 */
	public DisparoJugador(int i,int x,int y,int dir){
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
		
		miVisitor=new VisitorDisparoJugador();
		velocidad=i;
		grafico.setSize(64,64);
		posicion=new Point(x,y);
		r=new Rectangle();
		r.setBounds(x+24,y+24,15,5);	
	}

	@Override
	public boolean colisionar(Visitor visitor) {
		return false;
	}

	
}