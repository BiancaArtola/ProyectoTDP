package Logica;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.G;
import Objetos.*;
/**
 * Clase general del juego
 * @author Artola, Fiore, Jouglard
 *
 */
public class General {
	/**
	 * Atributos de la clase General.
	 */
	private Jugador p;
	private Enemigo[] malos;
	private int size;
	private Mapa mapa;
	private InteligenciaEnemigos ia;
	private HiloDisparo hd;
	
	/**
	 * Constructor de la clase General
	 */
	public General(){
		p=new Jugador();
		malos=new Enemigo[4];
		mapa=null;
		size=0;
	}
	
	/**
	 * Retorna el arreglo de imagenes que tiene el jugador
	 * @return el arreglo de imagenes que tiene el jugador, tipo ImageIcon[].
	 */
	public ImageIcon[] getImagenJugador(){
		return p.getImagen();
	}
	
	/**
	 * Retorna el arreglo de imagenes para el enemigo de la pos x del arreglo malos[].
	 * @param x: posicion del arreglo de malos.
	 * @return  el arreglo de imagenes para el enemigo de la pos x del arreglo malos[], de tipo ImageIcon[].
	 */
	public ImageIcon[] getImagenEnemigos(int x){
		return malos[x].getImagen();
	}

	/**
	 * Metodo para crear el mapa del juego.
	 * @param g: se pasa la GUI g por parametro(de tipo G).
	 */
	public void crearMapa(G g){
		FileReader f=null;
		try {
			f = new FileReader("mapa.txt");
		} catch (FileNotFoundException e) {
			g.add(new JLabel("Archivo no encontrado"));
		}
		mapa=new Mapa(f,g);
	}

	/**
	 * Mueve el jugador que recibe el mensaje.
	 * @param valor: indica la posicion a la cual debe moverse el jugador. Hay 4 posibilidades: arriba, abajo, derecha o izquierda.
	 * @return una imagen de tipo ImageIcon, que sera la imagen que debera tener el jugador en el mapa luego de moverse.
	 */
	public ImageIcon moverJugador(int valor) {
		int index=0;
		Obstaculo o=null;
		boolean puede = false;
		switch (valor){
		case KeyEvent.VK_UP:
				if(p.getPosicion().getY()/64>0){
					o=mapa.getObjetoEn(((int)p.getPosicion().getX()/64),((int)p.getPosicion().getY()/64)-1);
					puede= p.colisionar(o.getVisitor());
					if (puede)
						mapa.moverDePunto(p.getPosicion(),((int)p.getPosicion().getX()/64),((int)p.getPosicion().getY()/64)-1);
		}
			if (puede){
				p.mover(0);
			}
			break;
		case KeyEvent.VK_DOWN:
			if (p.getPosicion().getY()/64<13){
				o=mapa.getObjetoEn(((int)p.getPosicion().getX()/64),((int)p.getPosicion().getY()/64)+1);
				puede= p.colisionar(o.getVisitor());	
				if (puede)
					mapa.moverDePunto(p.getPosicion(),((int)p.getPosicion().getX()/64),((int)p.getPosicion().getY()/64)+1);
			}
			if (puede){
				p.mover(1);}
		    index=1; 
			break;
		case KeyEvent.VK_LEFT:
			if (p.getPosicion().getX()/64>0){
				o=mapa.getObjetoEn(((int)p.getPosicion().getX()/64)-1,((int)p.getPosicion().getY()/64));
				puede= p.colisionar(o.getVisitor());
				if (puede)
					mapa.moverDePunto(p.getPosicion(),((int)p.getPosicion().getX()/64)- 1,((int)p.getPosicion().getY()/64));
			}
			if (puede){
				p.mover(2);					
			}
			index=2;
			break;
		case KeyEvent.VK_RIGHT:
			if (p.getPosicion().getX()/64<13){
				o=mapa.getObjetoEn(((int)p.getPosicion().getX()/64)+1,((int)p.getPosicion().getY()/64));
				puede= p.colisionar(o.getVisitor());
				if (puede)	
					mapa.moverDePunto(p.getPosicion(),((int)p.getPosicion().getX()/64)+1,((int)p.getPosicion().getY()/64));
			}
			if (puede){
				p.mover(3);					
			}
			index=3;
			break;
		}
		return p.actualizarImagen(index);
	}
	
	/**
	 * Retorna la posicion(x, y) en la que se encuentra el jugador.
	 * @return la posicion(x, y) en la que se encuentra el jugador, tipo Point.
	 */
	public Point getPuntoJugador(){
		return p.getPosicion();
	}

	/**
	 * Agrega un enemigo en un lugar determinado del mapa.
	 * @param g: GUI de tipo G. 
	 */
	public void agregarEnemigo(G g) {
		/*JLabel p=new JLabel(new ImageIcon(this.getClass().getResource("/Images/Battle_City_Tank_Enemy1.png")));
		p.setSize(64,64);
		p.setLocation(414,414);
		g.add(p);
		g.setComponentZOrder(p,0);*/

		Enemigo j=new TanqueBasico(400,400);
		malos[size++]=j;
		g.add(j.getGrafico());
		g.setComponentZOrder(j.getGrafico(),0);
	}
	/**
	 * Elimina un enemigo del mapa. 
	 * @param g: GUI de tipo G
	 */
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
	
	/**
	 * Retorna el puntaje del jugador.
	 * @return puntaje del jugador, tipo String.
	 */
	public String getScore() {
		return String.valueOf(p.getScore());
	}

	/**
	 * Destruye el obstaculo ubicado en la posicion(x, y) del mapa.
	 * @param x: posicion en X
	 * @param y: posicion en Y
	 */
	public void destruirObstaculo(int x,int y) {
		Obstaculo g=(Obstaculo)mapa.getObjetoEn(x,y);
		g.destruir();  
	}
	
	/**
	 * Aumenta en 1 el nivel del jugador
	 * @return el nivel del jugador.
	 */
	public int subirNivel() {
		return p.subirNivel();
	}

	/**
	 * Crea los enemigos del mapa.
	 */
	public void creaEnemigos(G gui) {
		
		/*abel prueba=new JLabel("Prueba");
		prueba.setSize(64,64);
		prueba.setLocation(1000,1000);
		gui.add(prueba);*/

		
		//malos[0]=new TanqueBasico(400,400);
		//gui.getContentPane().add(malos[0].getGrafico());
		//gui.getContentPane().setComponentZOrder(malos[0].getGrafico(),0);
		//gui.setComponentZOrder(malos[0].getGrafico(),0);
		
		Random r=new Random();
		
		/*for (int j=1;j<5;j++){
			malos[j-1]=new TanqueBasico(r.nextInt(4)*128,r.nextInt(4)*128);
			}

		for (int i=0;i<malos.length;i++){
			gui.getContentPane().add(malos[i].getGrafico());
			gui.getContentPane().setComponentZOrder(malos[i].getGrafico(),0);
		}*/
		
		malos[0]=new TanqueBasico(250,250);
		gui.getContentPane().add(malos[0].getGrafico());
		gui.getContentPane().setComponentZOrder(malos[0].getGrafico(),0);
		ia=new InteligenciaEnemigos(malos,mapa,gui);
		Thread t=new Thread(ia);
		t.start();
	}

	public void disparaJugador(G g) {
		DisparoJugador d=p.disparar();
		g.getContentPane().add(d.getGrafico());
		d.getGrafico().setLocation(d.getPosicion());
		g.getContentPane().setComponentZOrder(d.getGrafico(),0);
		hd=new HiloDisparo(d,3,mapa,g);
		Thread t=new Thread(hd);
		t.start();
	}

	public Jugador getJugador() {
		// TODO Auto-generated method stub
		return p;
	}
}
