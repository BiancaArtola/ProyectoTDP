package Objetos;

import javax.swing.ImageIcon;
import Visitores.*;

/**
 * Clase abstracta Obstaculo, extiende GameObject
 * @author Artola, Fiore, Jouglard.
 *
 */
public abstract class Obstaculo extends GameObject {
	/**
	 * Atributos de la clase Obstaculo.
	 */
	
	/**
	 * Metodo destruir: le asigna al obstaculo que recibe el mensaje la imagen de vacio.
	 */
	public void destruir(){
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/Images/vacio.png")));
	}

	public Visitor getVisitor() {
		// TODO Auto-generated method stub
		return miVisitor;
	}
}
