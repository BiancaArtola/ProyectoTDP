package Objetos;

import javax.swing.ImageIcon;
import Visitores.*;

public abstract class Obstaculo extends GameObject {

	protected Visitor miVisitor;
	
	public void destruir(){
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/Images/vacio.png")));
	}

	public Visitor getVisitor() {
		// TODO Auto-generated method stub
		return miVisitor;
	}
}
