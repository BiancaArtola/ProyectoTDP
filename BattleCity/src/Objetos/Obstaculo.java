package Objetos;

import javax.swing.ImageIcon;

public abstract class Obstaculo extends GameObject {

	
	
	public void destruir(){
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/Images/vacio.png")));
	}
}
