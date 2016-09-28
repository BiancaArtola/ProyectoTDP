package Logica;

import java.awt.Point;
import java.awt.event.ActionListener;
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
	private int size;
	private Mapa mapa;
	
	
	public General(){
		p=new Jugador();
		malos=new Enemigo[4];
		mapa=null;
		size=0;
	}
	
	public ImageIcon[] getImagenJugador(){
		return p.getImagen();
	}
	
	public ImageIcon[] getImagenEnemigos(int x){
		return malos[x].getImagen();
	}
	
	public void crearMapa(G g){
		FileReader f=null;
		try {
			f = new FileReader("mapa.txt");
		} catch (FileNotFoundException e) {
			g.add(new JLabel("Archivo no encontrado"));
		}
		mapa=new Mapa(f,g);
	}

	public ImageIcon moverJugador(int valor) {
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

	public void agregarEnemigo(G g) {
		/*JLabel p=new JLabel(new ImageIcon(this.getClass().getResource("/Images/Battle_City_Tank_Enemy1.png")));
		p.setSize(64,64);
		p.setLocation(450,450);
		g.add(p);
		g.setComponentZOrder(p,0);*/
		
		Enemigo j=new TanqueBasico(400,400);
		malos[size++]=j;
		g.add(j.getGrafico());
		j.getGrafico().setLocation(400,400);
		j.getGrafico().setSize(64,64);
		g.setComponentZOrder(j.getGrafico(),0);
	}

	public void eliminarEnemigo(G g) {
		if (malos[size-1]!=null){
			mapa.eliminar(malos[size-1].getPosicion());
			p.aumentarPuntos(malos[size-1].getPuntaje());
			malos[size-1].getGrafico().setIcon(null);
			g.remove(malos[size-1].getGrafico());
			malos[size-1]=null;
			size--;
		}
	}

	public String getScore() {
		return String.valueOf(p.getScore());
	}

	public void destruirObstaculo(int x,int y) {
		Obstaculo g=(Obstaculo)mapa.getObjetoEn(x,y);
		g.destruir();
	}
}
