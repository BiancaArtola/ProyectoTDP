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
	
	protected int velocidad;
	/**
	 * Atributos de la clase DisparoJugador.
	 * @param i 
	 */
	public DisparoJugador(int i,int x,int y){
		miVisitor=new VisitorDisparoJugador();
		velocidad=i;
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Images/bala.png")));
		grafico.setSize(64,64);
		posicion=new Point(x,y);
	}

	@Override
	public boolean colisionar(Visitor visitor) {
		return false;
	}
	

	
}
