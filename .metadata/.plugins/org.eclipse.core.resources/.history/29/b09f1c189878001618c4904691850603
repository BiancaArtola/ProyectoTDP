package Logica;

import javax.swing.ImageIcon;

import Objetos.*;

public class General {

	private Jugador p;
	private Enemigo[] malos;
	private Mapa mapa;
	
	
	public General(Mapa m){
		mapa=m;
		p=new Jugador();
		malos=(Enemigo[]) new Object[4];
		for (int i=0;i<4;i++){
			malos[i]=new TanqueBasico();
		}
	}
	
	public ImageIcon getImagenJugador(){
		return p.getImagen();
	}
	
	public ImageIcon[] getImagenEnemigos(){
		ImageIcon[] i=(ImageIcon[])new Object[4];
		for (int j=0;j<4;j++)
			i[j]=malos[j].getImagen();
		return i;
	}
	
}
