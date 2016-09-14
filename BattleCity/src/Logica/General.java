package Logica;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.G;
import Objetos.*;

public class General {

	private Jugador p;
	private Enemigo[] malos;
	private Mapa mapa;
	
	
	public General(){
		p=new Jugador();
		malos=new Enemigo[4];
		for (int i=0;i<4;i++){
			malos[i]=new TanqueBasico();
		}
		mapa=null;
	}
	
	public ImageIcon[] getImagenJugador(){
		return p.getImagen();
	}
	
	public ImageIcon[] getImagenEnemigos(int x){
		return malos[x].getImagen();
	}
	
	public void crearMapa(G container){
		FileReader f=null;
		try {
			f = new FileReader("mapa.txt");
		} catch (FileNotFoundException e) {
			container.add(new JLabel("Archivo no encontrado"));
		}
		mapa=new Mapa(f,container);
	}

	public ImageIcon moverTanque(int valor) {
		int index=0;
		switch (valor){
			case KeyEvent.VK_UP:
				p.mover(0);
				break;
			case KeyEvent.VK_DOWN:
				p.mover(1);
				index=1;
				break;
			case KeyEvent.VK_LEFT:
				p.mover(2);
				index=2;
				break;
			case KeyEvent.VK_RIGHT:
				p.mover(3);
				index=3;
				break;
		}
		return p.actualizarImagen(index);
	}
	
	public Point getPuntoJugador(){
		return p.getPosicion();
	}
}
