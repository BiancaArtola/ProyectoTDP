package Logica;

import java.awt.Container;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
	public void crearMapa(G container){
		FileReader f=null;
		try {
			f = new FileReader("mapa.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mapa=new Mapa(f,container);
	}
}