package Logica;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.G;
import Objetos.GameObject;
import Obstaculos.Obstaculo;
import TDALista.PositionList;
import Tanques.Tanque;
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
	protected Tanque tanque;
	protected Mapa mapa;
	protected G gui;
	protected int nTanque;
	/**
	 * Constructor de la clase InteligenciaEnemigos
	 * @param gui 
	 * @param malos: arreglo de tipo Enemigos. Contiene los enemigos del mapa
	 * @param m: Mapa
	 */
	public InteligenciaEnemigos(Tanque malo,Mapa m, G gui){
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
		int x,y;
		JLabel j=new JLabel("Vacio");
		j.setSize(100,50);
		j.setLocation(1000,300);
		gui.getContentPane().add(j);
		JLabel j2=new JLabel("Vacio");
		j2.setSize(100,50);
		j2.setLocation(1500,100);
		gui.getContentPane().add(j2);
		boolean puede=true;
		Obstaculo go=null;
		Obstaculo o2=null;
		PositionList<GameObject> pl;
		PositionList<GameObject> pl2;
		int d;
		
		//movDisparoEnemigo disparoEnemigo;
		//Inicializar enemigo	
		while(!tanque.getMuerto()){
				d=r1.nextInt(4);
				int mov=r.nextInt(4);
				j.setText(String.valueOf(mov));
				for (int z=0;z<4;z++){
					j2.setText(String.valueOf(tanque.getPosicion().getX()/64+" "+String.valueOf(tanque.getPosicion().getY()/64)));
					switch(mov){
						case 0://Arriba
							if (tanque.getPosicion().getY()/64>0){
								if (tanque.getPosicion().getY()%64==0){ 
									go=mapa.getObjetoEn(((int)tanque.getPosicion().getX()/64),((int)tanque.getPosicion().getY()/64)-1);
									o2=mapa.getObjetoEn(((int)(tanque.getPosicion().getX()+50)/64),((int)tanque.getPosicion().getY()/64)-1);
									

									tanque.moverRectangulo(0);
									if (tanque.getRectangulo().intersects(go.getRectangulo()))
										puede= tanque.colisionar(go.getVisitor());
									
									if ((go!=o2) && (puede))
										if (o2.getRectangulo().intersects(tanque.getRectangulo()))
											puede=tanque.colisionar(o2.getVisitor());
									
									
									pl=mapa.getListaSegundaMatriz(((int)tanque.getPosicion().getX()/64),((int)tanque.getPosicion().getY()/64)-1);
									pl2=mapa.getListaSegundaMatriz((((int)(tanque.getPosicion().getX())+50)/64),((int)tanque.getPosicion().getY()/64)-1);
									if (puede){
										for(GameObject obj:pl)
											if (tanque.getRectangulo().intersects(obj.getRectangulo()))
												puede=tanque.colisionar(obj.getVisitor());
									}
									if ((puede) && (pl!=pl2))
										for(GameObject obj:pl2)
											if (tanque.getRectangulo().intersects(obj.getRectangulo()))
												puede=tanque.colisionar(obj.getVisitor());
									
									tanque.moverRectangulo(1);
									if (puede){
										pl.addLast(tanque);
										if (pl!=pl2)
											pl2.addLast(tanque);
									}
								}
								else
									tanque.mover(0);
							}
							if (puede){
								tanque.mover(0);
								if ((tanque.getPosicion().getY()+64)%64==0){
									mapa.removeTanque(tanque,(int)tanque.getPosicion().getX()/64,((int)tanque.getPosicion().getY()/64)-1);
									mapa.removeTanque(tanque,((int)tanque.getPosicion().getX()/64)+1,((int)tanque.getPosicion().getY()/64)-1);
								}
								gui.repaint();
							}
							else
								mov=r.nextInt(4);
							break;
						case 1://Abajo
							if (tanque.getPosicion().getY()/64<13){
								if (tanque.getPosicion().getY()%64==0){
									go=mapa.getObjetoEn(((int)tanque.getPosicion().getX()/64),((int)tanque.getPosicion().getY()/64)+1);
									o2=mapa.getObjetoEn((((int)tanque.getPosicion().getX()+50)/64),((int)tanque.getPosicion().getY()/64)+1);
									
									tanque.moverRectangulo(1);
									if (tanque.getRectangulo().intersects(go.getRectangulo()))
										puede= tanque.colisionar(go.getVisitor());
									if ((o2!=go) && (puede))
										if (tanque.getRectangulo().intersects(o2.getRectangulo()))
											puede=tanque.colisionar(o2.getVisitor());

									
									pl=mapa.getListaSegundaMatriz(((int)tanque.getPosicion().getX()/64),((int)tanque.getPosicion().getY()/64)+1);
									pl2=mapa.getListaSegundaMatriz((((int)tanque.getPosicion().getX()+50)/64),((int)tanque.getPosicion().getY()/64)+1);
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
								}
								else
									tanque.mover(1);
							}
							if (puede){
								tanque.mover(1);
								if (tanque.getPosicion().getY()%64==0){
									mapa.removeTanque(tanque,(int)tanque.getPosicion().getX()/64,((int)tanque.getPosicion().getY()/64)-1);
									mapa.removeTanque(tanque,((int)tanque.getPosicion().getX()/64)+1,((int)tanque.getPosicion().getY()/64)-1);
								}
									
								gui.repaint();
								}
							else
								mov=r.nextInt(4);
							break;
						case 2://Izquierda
							if (tanque.getPosicion().getX()/64>0){
								if (tanque.getPosicion().getX()%64==0){
									go=mapa.getObjetoEn(((int)tanque.getPosicion().getX()/64)-1,((int)tanque.getPosicion().getY()/64));
									puede= tanque.colisionar(go.getVisitor());

									pl=mapa.getListaSegundaMatriz(((int)tanque.getPosicion().getX()/64)-1,((int)tanque.getPosicion().getY()/64));
									for(GameObject obj:pl)
										if (tanque.getRectangulo().intersects(obj.getRectangulo()))
											tanque.colisionar(obj.getVisitor());
								}
								else
									tanque.mover(2);
							}
							if (puede){
								tanque.mover(2);
								gui.repaint();
								}
							else
								mov=r.nextInt(4);
							break;
						case 3://Derecha
							if (tanque.getPosicion().getX()/64<13){
								if (tanque.getPosicion().getX()%64==0){
									go=mapa.getObjetoEn(((int)tanque.getPosicion().getX()/64)+1,((int)tanque.getPosicion().getY()/64));
									puede= tanque.colisionar(go.getVisitor());

									pl=mapa.getListaSegundaMatriz(((int)tanque.getPosicion().getX()/64)+1,((int)tanque.getPosicion().getY()/64));
									for(GameObject obj:pl)
										if (tanque.getRectangulo().intersects(obj.getRectangulo()))
											tanque.colisionar(obj.getVisitor());
								}
								else
									tanque.mover(3);
							}
							if (puede){
								tanque.mover(3);
								gui.repaint();
								}
							else
								mov=r.nextInt(4);
							
							break;
							
							
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//if (d==3){
						//tanque.disparar();
						//disparoEnemigo=new movDisparoEnemigos();
						//Thread t=new Thread(disparoEnemigo);
						//t.run();
					//}
				
		}
			

			
		}
		


	}
}

