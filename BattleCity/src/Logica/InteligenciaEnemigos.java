package Logica;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.G;
import Objetos.Disparo;
import Objetos.DisparoEnemigo;
import Objetos.GameObject;
import Obstaculos.Obstaculo;
import TDALista.PositionList;
import Tanques.*;
import Visitores.*;

/**
 * Clase InteligenciaEnemigos que implementa Runnable.
 * @author Artola, Fiore, Jouglard
 *
 */
public class InteligenciaEnemigos implements Runnable{
	/**
	 * Atributos de la clase InteligenciaEnemigos
	 */
	protected Enemigo tanque;
	protected Mapa mapa;
	protected G gui;
	protected int nTanque;
	/**
	 * Constructor de la clase InteligenciaEnemigos
	 * @param gui 
	 * @param malos: arreglo de tipo Enemigos. Contiene los enemigos del mapa
	 * @param m: Mapa
	 */
	public InteligenciaEnemigos(Enemigo malo,Mapa m, G gui){
		tanque=malo;
		mapa=m;
		this.gui=gui;
	}

	/**
	 * Metodo run
	 */
	public void run(){
		Random r=new Random();
		Random r1=new Random();
		Random r2=new Random();
		int x,y;
		boolean puede=false;
		Obstaculo o=null;
		Obstaculo o2=null;
		PositionList<GameObject> pl;
		PositionList<GameObject> pl2;
		int d;
		Disparo dis=null;
		int movMismaDireccion;

		//movDisparoEnemigo disparoEnemigo;
		//Inicializar enemigo	
		while(!tanque.getMuerto()){
			d=r1.nextInt(4);
			int mov=r.nextInt(4);
			movMismaDireccion=r2.nextInt(8);
			for (int z=0;z<movMismaDireccion;z++){
				switch(mov){
				case 0://Arriba
					if(tanque.getPosicion().getY()/64>0){
						if(tanque.getPosicion().getY()%64==0){
							o=mapa.getObjetoEn(((int)tanque.getPosicion().getX()/64),((int)tanque.getPosicion().getY()/64)-1);
							o2=mapa.getObjetoEn((((int)tanque.getPosicion().getX()+56)/64),((int)tanque.getPosicion().getY()/64)-1);

							tanque.moverRectangulo(0);

							if (tanque.getRectangulo().intersects(o.getRectangulo()))
								puede=tanque.colisionar(o.getVisitor());
							if (puede && o2!=o && tanque.getRectangulo().intersects(o2.getRectangulo()))
								puede=tanque.colisionar(o2.getVisitor());

							pl=mapa.getListaSegundaMatriz(((int)tanque.getPosicion().getX()/64),((int)tanque.getPosicion().getY()/64)-1);
							pl2=mapa.getListaSegundaMatriz((((int)tanque.getPosicion().getX()+56)/64),((int)tanque.getPosicion().getY()/64)-1);

							if (puede){
								for (GameObject go:pl){
									if (tanque.getRectangulo().intersects(go.getRectangulo()))
										puede=tanque.colisionar(go.getVisitor());
								}
							}
							if (puede && pl2!=pl)
								for (GameObject go:pl2)
									if (tanque.getRectangulo().intersects(go.getRectangulo()))
										puede=tanque.colisionar(go.getVisitor());

							tanque.moverRectangulo(1);
							if (puede){
								pl.addLast(tanque);
								if (pl2!=pl)
									pl2.addLast(tanque); 
							}
						}
							else{
								tanque.mover(0);
								if ((tanque.getPosicion().getY()+64)%64==0){
									mapa.removeTanque(tanque,(int)(tanque.getPosicion().getX()/64),(int)(tanque.getPosicion().getY()/64)+1);
									mapa.removeTanque(tanque,(int)(tanque.getPosicion().getX()/64)+1,(int)(tanque.getPosicion().getY()/64)+1);
								}
							}
					}
					else
						tanque.setDireccion(0);
					if (puede){
						tanque.mover(0);
						if ((tanque.getPosicion().getY()+64)%64==0){
							mapa.removeTanque(tanque,(int)(tanque.getPosicion().getX()/64),(int)(tanque.getPosicion().getY()/64)+1);
							mapa.removeTanque(tanque,(int)(tanque.getPosicion().getX()/64)+1,(int)(tanque.getPosicion().getY()/64)+1);
						}
					}
					else{
						mov=r.nextInt(4);
						tanque.setDireccion(0);
					}
					break;
				case 1://Abajo
					if (tanque.getPosicion().getY()/64<13){
						if(tanque.getPosicion().getY()%64==0){
							o=mapa.getObjetoEn(((int)tanque.getPosicion().getX()/64),((int)tanque.getPosicion().getY()/64)+1);
							o2=mapa.getObjetoEn((((int)tanque.getPosicion().getX()+56)/64),((int)tanque.getPosicion().getY()/64)+1);

							tanque.moverRectangulo(1);
							if (tanque.getRectangulo().intersects(o.getRectangulo()))
								puede= tanque.colisionar(o.getVisitor());
							if ((o2!=o) && (puede))
								if (tanque.getRectangulo().intersects(o2.getRectangulo()))
									puede=tanque.colisionar(o2.getVisitor());


							pl=mapa.getListaSegundaMatriz(((int)tanque.getPosicion().getX()/64),((int)tanque.getPosicion().getY()/64)+1);
							pl2=mapa.getListaSegundaMatriz((((int)tanque.getPosicion().getX()+56)/64),((int)tanque.getPosicion().getY()/64)+1);
							if (puede){
								for(GameObject obj:pl)
									if (tanque.getRectangulo().intersects(obj.getRectangulo()))
										puede=tanque.colisionar(obj.getVisitor());
							}
							if (puede && pl!=pl2){
								for(GameObject obj:pl2)
									if (tanque.getRectangulo().intersects(obj.getRectangulo()))
										puede=tanque.colisionar(obj.getVisitor());
							}
							tanque.moverRectangulo(0);
							if (puede){
								pl.addLast(tanque);
								if (pl2!=pl)
									pl2.addLast(tanque); 
							}
						}
						else{
							tanque.mover(1);
							if ((tanque.getPosicion().getY())%64==0){
								mapa.removeTanque(tanque,(int)(tanque.getPosicion().getX()/64),(int)(tanque.getPosicion().getY()/64)-1);
								mapa.removeTanque(tanque,(int)(tanque.getPosicion().getX()/64)+1,(int)(tanque.getPosicion().getY()/64)-1);
							}
						}
					}
					else
						tanque.setDireccion(1);
					if (puede){
						tanque.mover(1);
						if (tanque.getPosicion().getY()%64==0){
							mapa.removeTanque(tanque,(int)tanque.getPosicion().getX()/64,((int)tanque.getPosicion().getY()/64)-1);
							mapa.removeTanque(tanque,((int)tanque.getPosicion().getX()/64)+1,((int)tanque.getPosicion().getY()/64)-1);
						}
					}
					else{
						mov=r.nextInt(4);
						tanque.setDireccion(1);
						}
					break;
				case 2://Izquierda
					if (tanque.getPosicion().getX()/64>0){
						if (tanque.getPosicion().getX()%64==0){
							o=mapa.getObjetoEn(((int)tanque.getPosicion().getX()/64)-1,((int)tanque.getPosicion().getY()/64));
							o2=mapa.getObjetoEn(((int)tanque.getPosicion().getX()/64)-1,(((int)tanque.getPosicion().getY()+56)/64));
							tanque.moverRectangulo(2);

							if (tanque.getRectangulo().intersects(o.getRectangulo()))
								puede= tanque.colisionar(o.getVisitor());

							if ((puede) && (o2!=o) && tanque.getRectangulo().intersects(o2.getRectangulo()))
								puede=tanque.colisionar(o2.getVisitor());

							pl=mapa.getListaSegundaMatriz(((int)tanque.getPosicion().getX()/64)-1,((int)tanque.getPosicion().getY()/64));
							pl2=mapa.getListaSegundaMatriz(((int)tanque.getPosicion().getX()/64)-1,(((int)tanque.getPosicion().getY()+56)/64));

							if (puede)
								for(GameObject obj:pl)
									if (tanque.getRectangulo().intersects(obj.getRectangulo()))
										puede=tanque.colisionar(obj.getVisitor());

							if ((puede) && (pl2!=pl))
								for(GameObject go:pl2)
									if (tanque.getRectangulo().intersects(go.getRectangulo()))
										puede=tanque.colisionar(go.getVisitor());
							tanque.moverRectangulo(3);

							if (puede){
								pl.addLast(tanque);
								if (pl2!=pl)
									pl2.addLast(tanque); 
							}
						}
						else{
							tanque.mover(2);
							if ((tanque.getPosicion().getX()+64)%64==0){
								mapa.removeTanque(tanque,(int)(tanque.getPosicion().getX()/64)+1,(int)(tanque.getPosicion().getY()/64));
								mapa.removeTanque(tanque,(int)(tanque.getPosicion().getX()/64)+1,(int)(tanque.getPosicion().getY()/64)+1);
							}
						}
					}
					else
						tanque.setDireccion(2);
					if (puede){
						tanque.mover(2);
						if ((tanque.getPosicion().getX()+64)%64==0){
							mapa.removeTanque(tanque,(int)(tanque.getPosicion().getX()/64)+1,(int)(tanque.getPosicion().getY()/64));
							mapa.removeTanque(tanque,(int)(tanque.getPosicion().getX()/64)+1,(int)(tanque.getPosicion().getY()/64)+1);
						}
						gui.repaint();
					}
					else{
						mov=r.nextInt(4);
						tanque.setDireccion(2);
					}
					break;
				case 3://Derecha
					if (tanque.getPosicion().getX()/64<13){
						if (tanque.getPosicion().getX()%64==0){
							o=mapa.getObjetoEn(((int)tanque.getPosicion().getX()/64)+1,((int)tanque.getPosicion().getY()/64));
							o2=mapa.getObjetoEn(((int)tanque.getPosicion().getX()/64)+1,(((int)tanque.getPosicion().getY()+56)/64));

							tanque.moverRectangulo(3);

							if (tanque.getRectangulo().intersects(o.getRectangulo()))
								puede=tanque.colisionar(o.getVisitor());
							if (puede && o2!=o && tanque.getRectangulo().intersects(o2.getRectangulo()))
								puede=tanque.colisionar(o2.getVisitor());

							pl=mapa.getListaSegundaMatriz(((int)tanque.getPosicion().getX()/64)+1,((int)tanque.getPosicion().getY()/64));
							pl2=mapa.getListaSegundaMatriz(((int)tanque.getPosicion().getX()/64)+1,(((int)tanque.getPosicion().getY()+56)/64));

							if (puede)
								for(GameObject obj:pl)
									if (tanque.getRectangulo().intersects(obj.getRectangulo()))
										tanque.colisionar(obj.getVisitor());
							if (puede && pl2!=pl)
								for(GameObject go:pl2)
									if(tanque.getRectangulo().intersects(go.getRectangulo()))
										tanque.colisionar(go.getVisitor());

							tanque.moverRectangulo(2);
							if (puede){
								pl.addLast(tanque);
								if (pl2!=pl)
									pl2.addLast(tanque); 
							}
						}
						else{
							tanque.mover(3);
							if ((tanque.getPosicion().getX())%64==0){
								mapa.removeTanque(tanque,(int)(tanque.getPosicion().getX()/64)-1,(int)(tanque.getPosicion().getY()/64));
								mapa.removeTanque(tanque,(int)(tanque.getPosicion().getX()/64)-1,(int)(tanque.getPosicion().getY()/64)+1);
							}
						}
							
					}
					if (puede){
						tanque.mover(3);
						if ((tanque.getPosicion().getX())%64==0){
							mapa.removeTanque(tanque,(int)(tanque.getPosicion().getX()/64)-1,(int)(tanque.getPosicion().getY()/64));
							mapa.removeTanque(tanque,(int)(tanque.getPosicion().getX()/64)-1,(int)(tanque.getPosicion().getY()/64)+1);
						}
					}
					else{
						mov=r.nextInt(4);
						tanque.setDireccion(3);
					}
					break;


				}

				if (d==3){
					dis=tanque.disparar();
					if (dis!=null){
						gui.add(dis.getGrafico());
						gui.setComponentZOrder(dis.getGrafico(),0);
						movDisparoEnemigo disparoEnemigo=new movDisparoEnemigo(tanque,dis,mapa,gui,tanque.getDireccion());
						Thread t=new Thread(disparoEnemigo);
						t.run();
					}
				}
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}



		}



	}
}

