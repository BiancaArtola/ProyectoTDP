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
import Tanques.TanqueDePoder;
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
	private IA2 ia;
	private HiloDisparo hd;
	private G gui;
	public static boolean corriendo=true;
	public static boolean puedenMover=true;
	
	/**
	 * Constructor de la clase General
	 */
	public General(G g){
		
		p=new Jugador(new GanarYPerder(this));
		malos=new Enemigo[4];
		mapa=null;
		size=0;
		gui=g;
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
		Aguila a=new Aguila(new GanarYPerder(this));
		mapa.getListaSegundaMatriz(6,13).addLast(a);
		g.getContentPane().add(a.getGrafico());
		g.getContentPane().setComponentZOrder(a.getGrafico(),0);
	}

	/**
	 * Mueve el jugador que recibe el mensaje.
	 * @param valor: indica la posicion a la cual debe moverse el jugador. Hay 4 posibilidades: arriba, abajo, derecha o izquierda.
	 * @return una imagen de tipo ImageIcon, que sera la imagen que debera tener el jugador en el mapa luego de moverse.
	 */
	public ImageIcon moverJugador(int valor) {
		if (corriendo){
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
						int x=p.getVelocidad();
						if (p.getRectangulo().intersects(o.getRectangulo()))
							puede=p.colisionar(o.getVisitor());
						if (puede && o2!=o && p.getRectangulo().intersects(o2.getRectangulo()))
							puede=p.colisionar(o2.getVisitor());

						pl=mapa.getListaSegundaMatriz(((int)p.getPosicion().getX()/64),((int)p.getPosicion().getY()/64)-1);
						pl2=mapa.getListaSegundaMatriz((((int)p.getPosicion().getX()+56)/64),((int)p.getPosicion().getY()/64)-1);

						if (puede){
							for (GameObject go:pl){
								if (p.getRectangulo().intersects(go.getRectangulo())){
									puede=p.colisionar(go.getVisitor());
									if (puede){
										gui.remove(go.getGrafico());
										mapa.removeTanque(go,(int)go.getPosicion().getX()/64,(int)go.getPosicion().getY()/64);
									}
								}

							}
						}
						if (puede && pl2!=pl)
							for (GameObject go:pl2)
								if (p.getRectangulo().intersects(go.getRectangulo())){
									puede=p.colisionar(go.getVisitor());
									if (puede){
										gui.remove(go.getGrafico());
										mapa.removeTanque(go,(int)go.getPosicion().getX()/64,(int)go.getPosicion().getY()/64);
									}
								}

						p.moverRectangulo(1,x);
						if (puede){
							pl.addLast(p);
							if (pl2!=pl)
								pl2.addLast(p); 
						}
					}
					else{
						p.mover(0);
						if ((p.getPosicion().getY()+64)%64==0){
							mapa.removeTanque(p,(int)(p.getPosicion().getX()/64),(int)(p.getPosicion().getY()/64)+1);
							mapa.removeTanque(p,(int)(p.getPosicion().getX()/64)+1,(int)(p.getPosicion().getY()/64)+1);
						}
					}

				}
				else
					p.setDireccion(0);
				if (puede){
					p.mover(0);
					if ((p.getPosicion().getY()+64)%64==0){
						mapa.removeTanque(p,(int)(p.getPosicion().getX()/64),(int)(p.getPosicion().getY()/64)+1);
						mapa.removeTanque(p,(int)(p.getPosicion().getX()/64)+1,(int)(p.getPosicion().getY()/64)+1);
					}

				}
				else
					p.setDireccion(0);
				break;
			case KeyEvent.VK_DOWN:
				if (p.getPosicion().getY()/64<13){
					if (p.getPosicion().getY()%64==0){
						o=mapa.getObjetoEn(((int)p.getPosicion().getX()/64),((int)p.getPosicion().getY()/64)+1);
						o2=mapa.getObjetoEn((((int)p.getPosicion().getX()+56)/64),((int)p.getPosicion().getY()/64)+1);

						p.moverRectangulo(1);
						int x=p.getVelocidad();
						if (p.getRectangulo().intersects(o.getRectangulo()))
							puede=p.colisionar(o.getVisitor());
						if (puede && o2!=o && p.getRectangulo().intersects(o2.getRectangulo()))
							puede=p.colisionar(o2.getVisitor());

						pl=mapa.getListaSegundaMatriz(((int)p.getPosicion().getX()/64),((int)p.getPosicion().getY()/64)+1);
						pl2=mapa.getListaSegundaMatriz((((int)p.getPosicion().getX()+56)/64),((int)p.getPosicion().getY()/64)+1);
						if (puede){
							for (GameObject go:pl){
								if (p.getRectangulo().intersects(go.getRectangulo())){
									puede=p.colisionar(go.getVisitor());
									if (puede){
										gui.remove(go.getGrafico());
										mapa.removeTanque(go,(int)go.getPosicion().getX()/64,(int)go.getPosicion().getY()/64);
									}
								}
							}
						}
						if (puede && pl2!=pl)
							for (GameObject go:pl2)
								if(p.getRectangulo().intersects(go.getRectangulo())){
									puede=p.colisionar(go.getVisitor());
									if (puede){
										gui.remove(go.getGrafico());
										mapa.removeTanque(go,(int)go.getPosicion().getX()/64,(int)go.getPosicion().getY()/64);
									}	
								}
						if (puede){
							pl.addLast(p);
							if (pl2!=pl)
								pl2.addLast(p);
						}
						p.moverRectangulo(0,x);
					}
					else{
						p.mover(1);
						if ((p.getPosicion().getY())%64==0){
							mapa.removeTanque(p,(int)(p.getPosicion().getX()/64),(int)(p.getPosicion().getY()/64)-1);
							mapa.removeTanque(p,(int)(p.getPosicion().getX()/64)+1,(int)(p.getPosicion().getY()/64)-1);
						}
					}

				}
				else
					p.setDireccion(1);
				if (puede){
					p.mover(1);
					if ((p.getPosicion().getY()+64)%64==0){
						mapa.removeTanque(p,(int)(p.getPosicion().getX()/64),(int)(p.getPosicion().getY()/64)-1);
						mapa.removeTanque(p,(int)(p.getPosicion().getX()/64)+1,(int)(p.getPosicion().getY()/64)-1);
					}
				}
				else
					p.setDireccion(1);
				index=1; 
				break;
			case KeyEvent.VK_LEFT:
				if (p.getPosicion().getX()/64>0){
					if (p.getPosicion().getX()%64==0){
						o=mapa.getObjetoEn(((int)p.getPosicion().getX()/64)-1,((int)p.getPosicion().getY()/64));
						o2=mapa.getObjetoEn(((int)p.getPosicion().getX()/64)-1,((int)p.getPosicion().getY()+56)/64);
						p.moverRectangulo(2);
						int x=p.getVelocidad();
						if (p.getRectangulo().intersects(o.getRectangulo()))
							puede=p.colisionar(o.getVisitor());
						if ((puede) && p.getRectangulo().intersects(o2.getRectangulo()) && o2!=o)
							puede=p.colisionar(o2.getVisitor());

						pl=mapa.getListaSegundaMatriz(((int)p.getPosicion().getX()/64)-1,((int)p.getPosicion().getY()/64));
						pl2=mapa.getListaSegundaMatriz(((int)p.getPosicion().getX()/64)-1,(((int)p.getPosicion().getY()+56)/64));

						if (puede){
							for (GameObject go:pl){
								if (p.getRectangulo().intersects(go.getRectangulo())){
									puede=p.colisionar(go.getVisitor());
									if (puede){
										gui.remove(go.getGrafico());
										mapa.removeTanque(go,(int)go.getPosicion().getX()/64,(int)go.getPosicion().getY()/64);
									}
								}
							}
						}
						if ((puede) && (pl2!=pl))
							for (GameObject go:pl2)
								if (p.getRectangulo().intersects(go.getRectangulo())){
									puede=p.colisionar(go.getVisitor());
									if (puede){
										gui.remove(go.getGrafico());
										mapa.removeTanque(go,(int)go.getPosicion().getX()/64,(int)go.getPosicion().getY()/64);
									}
								}

						if (puede){
							pl.addLast(p);
							if (pl2!=pl)
								pl2.addLast(p);
						}

						p.moverRectangulo(3,x);
					}
					else{
						p.mover(2);
						if ((p.getPosicion().getX()+64)%64==0){
							mapa.removeTanque(p,(int)(p.getPosicion().getX()/64)+1,(int)(p.getPosicion().getY()/64));
							mapa.removeTanque(p,(int)(p.getPosicion().getX()/64)+1,(int)(p.getPosicion().getY()/64)+1);
						}
					}
				}
				else
					p.setDireccion(2);
				if (puede){
					p.mover(2);		
					if ((p.getPosicion().getX()+64)%64==0){
						mapa.removeTanque(p,((int)(p.getPosicion().getX())/64)+1,(int)(p.getPosicion().getY()/64));
						mapa.removeTanque(p,((int)(p.getPosicion().getX()/64))+1,(int)(p.getPosicion().getY()/64)+1);
					}
				}
				else
					p.setDireccion(2);
				index=2;
				break;
			case KeyEvent.VK_RIGHT:
				if (p.getPosicion().getX()/64<13){
					if (p.getPosicion().getX()%64==0){
						o=mapa.getObjetoEn(((int)p.getPosicion().getX()/64)+1,((int)p.getPosicion().getY()/64));
						o2=mapa.getObjetoEn(((int)p.getPosicion().getX()/64)+1,(((int)p.getPosicion().getY()+56)/64));
						p.moverRectangulo(3);
						int x=p.getVelocidad();
						if (p.getRectangulo().intersects(o.getRectangulo()))
							puede=p.colisionar(o.getVisitor());

						if (puede && o2!=o && p.getRectangulo().intersects(o2.getRectangulo()))
							puede=p.colisionar(o2.getVisitor());

						pl=mapa.getListaSegundaMatriz(((int)p.getPosicion().getX()/64)+1,((int)p.getPosicion().getY()/64));
						pl2=mapa.getListaSegundaMatriz(((int)p.getPosicion().getX()/64)+1,(((int)p.getPosicion().getY()+56)/64));
						if (puede){
							for (GameObject go:pl){
								if (p.getRectangulo().intersects(go.getRectangulo())){
									puede=p.colisionar(go.getVisitor());
									if (puede){
										gui.remove(go.getGrafico());
										mapa.removeTanque(go,(int)go.getPosicion().getX()/64,(int)go.getPosicion().getY()/64);
									}
								}
							}
						}
						if (puede && pl2!=pl)
							for (GameObject go:pl2)
								if (p.getRectangulo().intersects(go.getRectangulo())){
									puede=p.colisionar(go.getVisitor());
									if (puede){
										gui.remove(go.getGrafico());
										mapa.removeTanque(go,(int)go.getPosicion().getX()/64,(int)go.getPosicion().getY()/64);
									}
								}
						if (puede){
							pl.addLast(p);
							if (pl2!=pl)
								pl2.addLast(p);
						}
						p.moverRectangulo(2,x);
					}
					else{
						p.mover(3);
						if ((p.getPosicion().getX())%64==0){
							mapa.removeTanque(p,(int)(p.getPosicion().getX()/64)-1,(int)(p.getPosicion().getY()/64));
							mapa.removeTanque(p,(int)(p.getPosicion().getX()/64)-1,(int)(p.getPosicion().getY()/64)+1);
						}
					} 
				}
				else
					p.setDireccion(3);
				if (puede){
					p.mover(3);	
					if ((p.getPosicion().getX())%64==0){
						mapa.removeTanque(p,(int)(p.getPosicion().getX()/64)-1,(int)(p.getPosicion().getY()/64));
						mapa.removeTanque(p,(int)(p.getPosicion().getX()/64)-1,(int)(p.getPosicion().getY()/64)+1);
					}
				}
				else
					p.setDireccion(3);
				index=3;
				break;
			}
			return p.actualizarImagen(index);
		}
		else
			return null;
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
		
		Random r=new Random();
		
		
		int x=256;
		int y=256;
		
		for (int i=0;i<4;i++){
			malos[i]=new TanqueBasico(x,y);
			y-=64;
			x+=64;
			PositionList<GameObject> pl=mapa.getListaSegundaMatriz(((int)malos[i].getPosicion().getX()/64),((int)malos[i].getPosicion().getY()/64));
			pl.addLast(malos[i]);
			gui.getContentPane().add(malos[i].getGrafico());
			gui.getContentPane().setComponentZOrder(malos[i].getGrafico(),0);
			ia=new IA2(mapa,gui,malos[i]);
			Thread t=new Thread(ia);
			t.start();
		}
	}

	/**
	 * Metodo que hace que el jugador dispare.
	 * @param g: GUI
	 */
	public void disparaJugador() {
			//p es de tipo Jugador. d es de tipo disparoJugador(velocidadDisparo, x, y, posicion de la bala)
			DisparoJugador d = p.disparar();
			boolean choco=true;
			Obstaculo v=null;
			PositionList<GameObject> pl=null;
			//Obstaculo v contiene el obstaculo que hay en la posicion en la que se desea disparar.
			if (d!=null){
				if(d.getPosicion().getX()>0 && d.getPosicion().getX()<832){
					if (d.getPosicion().getY()>0 && d.getPosicion().getY()<832){
						v= mapa.getObjetoEn((int)(d.getPosicion().getX()/64),(int)(d.getPosicion().getY()/64));
						pl=mapa.getListaSegundaMatriz((int)(d.getPosicion().getX()/64),(int)(d.getPosicion().getY()/64));
						if (v!=null)
							choco=v.colisionar(d.getVisitor());

						if (!choco && pl!=null)
							for(GameObject go:pl)
								if(go.getRectangulo().intersects(d.getRectangulo()))
									choco=go.colisionar(d.getVisitor());
					
					}
					else{
						p.chocoDisparo();
						choco=true;
					}
				}
				else{
					p.chocoDisparo();
					choco=true;
				}
				
				if (!choco){
					gui.getContentPane().add(d.getGrafico());
					d.getGrafico().setLocation(d.getPosicion());
					gui.getContentPane().setComponentZOrder(d.getGrafico(),0);
					hd = new HiloDisparo(d,p.getDireccion(),mapa,gui,p);
					Thread t = new Thread(hd);
					t.start();
				}
				else{
					if (v!=null){
						if (v.getVida()==0)
							mapa.eliminarObs(v.getPosicion());
						p.chocoDisparo();
						
					}
					else
						p.chocoDisparo();
				}
				if (choco)
					p.chocoDisparo();
				
			}
	}
	
	public Jugador getJugador() {
		return p;
	}

	public void crearPU(G g) {
		HiloPowerUp hp=new HiloPowerUp(mapa,g,new InteraccionPU(this));
		Thread t=new Thread(hp);
		t.start();		
	}

	public void ganar() {
		JLabel ganaste=new JLabel();
		ganaste.setSize(800,800);
		ganaste.setLocation(0,0);
		gui.getContentPane().removeAll();
		gui.setSize(1000,1000);
		gui.add(ganaste);
		gui.setComponentZOrder(ganaste,0);
		ganaste.setIcon(new ImageIcon(this.getClass().getResource("/Images/ganaste.png")));
		corriendo=false;
		Thread t=new Thread(new ContadorTiempo(5));
		t.run();
		gui.hide();
		
	}

	public void gameover() {
		JLabel perdiste=new JLabel(new ImageIcon(this.getClass().getResource("/Images/gameover.png")));
		perdiste.setSize(800,800);
		perdiste.setLocation(0,0);
		gui.getContentPane().removeAll();
		gui.setSize(1000,1000);
		gui.add(perdiste);
		gui.setComponentZOrder(perdiste,0);	
		corriendo=false;
		Thread t=new Thread(new ContadorTiempo(5));
		t.run();
		gui.hide();
	}

	public void limpiarEnemigos() {
		for(int i=0;i<malos.length;i++){
			malos[i].destruir();
			gui.getContentPane().remove(malos[i].getGrafico());
			mapa.removeTanque(malos[i],(int)malos[i].getPosicion().getX()/64,(int)malos[i].getPosicion().getY()/64);
		}
		
		
	}
	

	public void protegerBase() {
		mapa.protegerBase(gui);
	}

	public void pararEnemigos() {
		Thread t=new Thread(new PararEnemigos(malos));
		t.start();
	}
}