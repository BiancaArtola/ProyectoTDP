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
import Obstaculos.Obstaculo;
import TDALista.PositionList;
import Tanques.Enemigo;
import Tanques.Jugador;
import Tanques.TanqueBasico;
import Visitores.*;
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
	private HiloPowerUp ip;
	
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
		PositionList<GameObject> pl=mapa.getListaSegundaMatriz(0,0);
		pl.addLast(p); 
	}

	/**
	 * Mueve el jugador que recibe el mensaje.
	 * @param valor: indica la posicion a la cual debe moverse el jugador. Hay 4 posibilidades: arriba, abajo, derecha o izquierda.
	 * @return una imagen de tipo ImageIcon, que sera la imagen que debera tener el jugador en el mapa luego de moverse.
	 */
	public ImageIcon moverJugador(int valor) {
		int index=0;
		Obstaculo o=null;
		Obstaculo o2=null;
		boolean puede = false;
		PositionList<GameObject> pl=null;
		PositionList<GameObject> pl2=null;
		switch (valor){
		case KeyEvent.VK_UP:
				if(p.getPosicion().getY()/64>0){
					if (p.getPosicion().getY()%64==0){
						o=mapa.getObjetoEn(((int)p.getPosicion().getX()/64),((int)p.getPosicion().getY()/64)-1);
						o2=mapa.getObjetoEn((((int)p.getPosicion().getX()+56)/64),((int)p.getPosicion().getY()/64)-1);
						p.moverRectangulo(0);
						
						if (p.getRectangulo().intersects(o.getRectangulo()))
							puede=p.colisionar(o.getVisitor());
						if (puede && o2!=o && p.getRectangulo().intersects(o2.getRectangulo()))
							puede=p.colisionar(o2.getVisitor());
						
						pl=mapa.getListaSegundaMatriz(((int)p.getPosicion().getX()/64),((int)p.getPosicion().getY()/64)-1);
						pl2=mapa.getListaSegundaMatriz((((int)p.getPosicion().getX()+56)/64),((int)p.getPosicion().getY()/64)-1);
						
						if (puede){
								for (GameObject go:pl){
									if (p.getRectangulo().intersects(go.getRectangulo()))
										puede=p.colisionar(go.getVisitor());
								}
							}
						if (puede && pl2!=pl)
							for (GameObject go:pl2)
								if (p.getRectangulo().intersects(go.getRectangulo()))
									puede=p.colisionar(go.getVisitor());
							
						p.moverRectangulo(1);
						if (puede)
							pl.addLast(p);
					}
					else{
						p.mover(0);
						if ((p.getPosicion().getY()+64)%64==0)
							mapa.removeTanque(p,(int)(p.getPosicion().getX()/64),(int)(p.getPosicion().getY()/64)+1);
						}
			}
			if (puede){
				p.mover(0);
			}
			break;
		case KeyEvent.VK_DOWN:
			if (p.getPosicion().getY()/64<13){
				if (p.getPosicion().getY()%64==0){
					o=mapa.getObjetoEn(((int)p.getPosicion().getX()/64),((int)p.getPosicion().getY()/64)+1);
					o2=mapa.getObjetoEn((((int)p.getPosicion().getX()+56)/64),((int)p.getPosicion().getY()/64)+1);
					
					p.moverRectangulo(1);
					
					if (p.getRectangulo().intersects(o.getRectangulo()))
						puede=p.colisionar(o.getVisitor());
					if (puede && o2!=o && p.getRectangulo().intersects(o2.getRectangulo()))
						puede=p.colisionar(o2.getVisitor());
					
					pl=mapa.getListaSegundaMatriz(((int)p.getPosicion().getX()/64),((int)p.getPosicion().getY()/64)+1);
					pl2=mapa.getListaSegundaMatriz((((int)p.getPosicion().getX()+56)/64),((int)p.getPosicion().getY()/64)+1);
					if (puede){
							for (GameObject go:pl){
								if (p.getRectangulo().intersects(go.getRectangulo()))
									puede=p.colisionar(go.getVisitor());
							}
					}
					if (puede && pl2!=pl)
						for (GameObject go:pl2)
							if(p.getRectangulo().intersects(go.getRectangulo())){
								puede=p.colisionar(go.getVisitor());
								if (puede)
									break;
							}
					if (puede)
						pl.addLast(p);
					p.moverRectangulo(0);
				}
				else{
					p.mover(1);
					if (p.getPosicion().getY()%64==0)
						mapa.removeTanque(p,(int)p.getPosicion().getX()/64,(int)(p.getPosicion().getY()/64)-1);
				}
				
			}
			if (puede){
				p.mover(1);}
		    index=1; 
			break;
		case KeyEvent.VK_LEFT:
			if (p.getPosicion().getX()/64>0){
				if (p.getPosicion().getX()%64==0){
					o=mapa.getObjetoEn(((int)p.getPosicion().getX()/64)-1,((int)p.getPosicion().getY()/64));
					o2=mapa.getObjetoEn(((int)p.getPosicion().getX()/64)-1,((int)p.getPosicion().getY()+56)/64);
					p.moverRectangulo(2);
					if (p.getRectangulo().intersects(o.getRectangulo()))
						puede=p.colisionar(o.getVisitor());
					if ((puede) && p.getRectangulo().intersects(o2.getRectangulo()) && o2!=o)
						puede=p.colisionar(o2.getVisitor());
					
					pl=mapa.getListaSegundaMatriz(((int)p.getPosicion().getX()/64)-1,((int)p.getPosicion().getY()/64));
					pl2=mapa.getListaSegundaMatriz(((int)p.getPosicion().getX()/64)-1,(((int)p.getPosicion().getY()+56)/64));
					
					if (puede){
						for (GameObject go:pl){
							if (p.getRectangulo().intersects(go.getRectangulo()))
								puede=p.colisionar(go.getVisitor());
						}
					}
					if ((puede) && (pl2!=pl))
						for (GameObject go:pl2)
							if (p.getRectangulo().intersects(go.getRectangulo()))
								puede=p.colisionar(go.getVisitor());
					
					if (puede)
						pl.addLast(p);
					
					p.moverRectangulo(3);
				}
				else{
					p.mover(2);
					if ((p.getPosicion().getX()+64)%64==0)
						mapa.removeTanque(p,(int)(p.getPosicion().getX()/64)+1,(int)(p.getPosicion().getY()/64));
				}
			}
			else
				p.setDireccion(2);
			if (puede){
				p.mover(2);					
			}
			index=2;
			break;
		case KeyEvent.VK_RIGHT:
			if (p.getPosicion().getX()/64<13){
				if (p.getPosicion().getX()%64==0){
					o=mapa.getObjetoEn(((int)p.getPosicion().getX()/64)+1,((int)p.getPosicion().getY()/64));
					o2=mapa.getObjetoEn(((int)p.getPosicion().getX()/64)+1,(((int)p.getPosicion().getY()+56)/64));
					p.moverRectangulo(3);
					if (p.getRectangulo().intersects(o.getRectangulo()))
						puede=p.colisionar(o.getVisitor());
					
					if (puede && o2!=o && p.getRectangulo().intersects(o2.getRectangulo()))
						puede=p.colisionar(o2.getVisitor());
					
					pl=mapa.getListaSegundaMatriz(((int)p.getPosicion().getX()/64)+1,((int)p.getPosicion().getY()/64));
					pl2=mapa.getListaSegundaMatriz(((int)p.getPosicion().getX()/64)+1,(((int)p.getPosicion().getY()+56)/64));
					if (puede){
						for (GameObject go:pl){
							if (p.getRectangulo().intersects(go.getRectangulo()))
								puede=p.colisionar(go.getVisitor());
						}
					}
					if (puede && pl2!=pl)
						for (GameObject go:pl2)
							if (p.getRectangulo().intersects(go.getRectangulo()))
								puede=p.colisionar(go.getVisitor());
					if (puede)
						pl.addLast(p);
					p.moverRectangulo(2);
					}
				else{
					p.mover(3);
					if ((p.getPosicion().getX())%64==0)
						mapa.removeTanque(p,(int)(p.getPosicion().getX()/64)-1,(int)p.getPosicion().getY()/64);
				}
//				if (puede)	
//					mapa.moverDePunto(p.getPosicion(),((int)p.getPosicion().getX()/64)+1,((int)p.getPosicion().getY()/64));
//				else 
//					p.setDireccion(3);
			}
			if (puede){
				p.mover(3);					
			}
			index=3;
			break;
		}
		System.out.println(String.valueOf(puede));
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
			mapa.eliminarObs(malos[size-1].getPosicion());
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
		int x=256;
		int y=256;
		
		for (int i=0;i<2;i++){
			malos[i]=new TanqueBasico(x,y);
			y-=64;
			PositionList<GameObject> pl=mapa.getListaSegundaMatriz(((int)malos[i].getPosicion().getX()/64),((int)malos[i].getPosicion().getY()/64));
			pl.addLast(malos[i]);
			gui.getContentPane().add(malos[i].getGrafico());
			gui.getContentPane().setComponentZOrder(malos[i].getGrafico(),0);
			ia=new InteligenciaEnemigos(malos[i],mapa,gui);
			Thread t=new Thread(ia);
			t.start();
		}
	}

	/**
	 * Metodo que hace que el jugador dispare.
	 * @param g: GUI
	 */
	public void disparaJugador(G g) {
			//p es de tipo Jugador. d es de tipo disparoJugador(velocidadDisparo, x, y, posicion de la bala)
			DisparoJugador d = p.disparar();
			if (d!=null){
			//Obstaculo v contiene el obstaculo que hay en la posicion en la que se desea disparar.
			Obstaculo v= mapa.getObjetoEn((int)(d.getPosicion().getX()/64),(int)(d.getPosicion().getY()/64));
			if (!v.colisionar(d.getVisitor())){
				g.getContentPane().add(d.getGrafico());
				d.getGrafico().setLocation(d.getPosicion());
				g.getContentPane().setComponentZOrder(d.getGrafico(),0);
				hd = new HiloDisparo(d,p.getDireccion(),mapa,g,p);
				Thread t = new Thread(hd);
				t.start();
			}
			else{
				if (v.getVida()==0)
					mapa.eliminarObs(v.getPosicion());
			}
			}
	
			}
	
	public Jugador getJugador() {
		return p;
	}
	
	public void crearPowerUp(G g) {
		ip=new HiloPowerUp(mapa,g);
		Thread t=new Thread(ip);
		t.start();
	}
}