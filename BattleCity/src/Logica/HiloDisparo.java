package Logica;

import GUI.G;
import Objetos.*;
import Obstaculos.Obstaculo;
import TDALista.PositionList;
import Tanques.Jugador;
import Tanques.*;

/**
 * Clase HiloDisparo, implementa Runnable.
 * @author Artola, Fiore, Jouglard.
 *
 */
public class HiloDisparo implements Runnable {

	/**
	 * Atributos de la clase HiloDisparo
	 */
	private DisparoJugador d;
	private int direccion;
	private Mapa m;
	private G gui;
	private int cantDisparos;
	private Jugador player;
	
	/**
	 * Constructor
	 * @param shot: disparoJugador(velocidadDisparo, x, y, posicion de la bala)
	 * @param dir: direccion del disparo
	 * @param map: mapa
	 * @param gui: interfaz grafica
	 */
	public HiloDisparo(DisparoJugador shot,int dir,Mapa map,G gui,Jugador j) {
		player=j;
		this.d=shot;
		direccion=dir;
		m=map;
		this.gui=gui;
		cantDisparos=0;
	}

	public void run() {
			boolean choco=false;
			Obstaculo o=null;
			boolean fueradeRango=false;
			PositionList<GameObject> pl=null;
			boolean mato=false;
			GameObject go2=null;
			while(!d.getChoco() && !mato && General.corriendo){
				switch(direccion){
				case 0: //ARRIBA
					if((d.getPosicion().getY()/64)>0){
						o=m.getObjetoEn(((int)(d.getPosicion().getX()+28)/64),(int)(d.getPosicion().getY()/64));
						pl=m.getListaSegundaMatriz(((int)d.getPosicion().getX()+28)/64,(int)(d.getPosicion().getY()/64));
						d.moverRectangulo(0);

						//Si el obstaculo o puede colisionar con el visitor del disparoJugador d, choco es verdadero. Falso en caso contrario
						if (d.getRectangulo().intersects(o.getRectangulo()))
							d.setChoco(o.colisionar(d.getVisitor()));
					
						if (!choco){
							for(GameObject go:pl)
								if (go.getRectangulo().intersects(d.getRectangulo())){
									mato=go.colisionar(d.getVisitor());
									if (mato){
										go2=go;
										break;
									}
								}
								
							d.moverRectangulo(1);
							if (!mato){
								d.mover(0);
							}
						}
						
					}
					else{
						d.setChoco(true);;
					}
					break;
				case 1: //ABAJO
					if((d.getPosicion().getY()/64)<13){
						o = m.getObjetoEn(((int)(d.getPosicion().getX()+28)/64),(int)(d.getPosicion().getY()/64)+1);
						pl=m.getListaSegundaMatriz(((int)d.getPosicion().getX()+28)/64,(int)(d.getPosicion().getY()/64)+1);
						d.moverRectangulo(1);
						
						if (d.getRectangulo().intersects(o.getRectangulo()))
							d.setChoco(o.colisionar(d.getVisitor()));
						if (!choco){
							for(GameObject go:pl){
								if (go.getRectangulo().intersects(d.getRectangulo()))
									mato=go.colisionar(d.getVisitor());
								if (mato){
									go2=go;
									break;
								}
							}
							d.moverRectangulo(0);
							if (!mato){
								d.mover(1);
							}
						}
					}
					else{
						d.setChoco(true);
					}
					break;
				case 2: //IZQUIERDA
					if((d.getPosicion().getX()/64>0) ){
							o=m.getObjetoEn((int)(d.getPosicion().getX()/64),((int)(d.getPosicion().getY()+28)/64));
							pl=m.getListaSegundaMatriz(((int)d.getPosicion().getX()/64),((int)(d.getPosicion().getY()+28)/64));
							 d.moverRectangulo(2);
						
						if (d.getRectangulo().intersects(o.getRectangulo()))	 
							d.setChoco(o.colisionar(d.getVisitor()));
						if (!choco){
							for(GameObject go:pl){
								if (go.getRectangulo().intersects(d.getRectangulo()))
									mato=go.colisionar(d.getVisitor());
								if (mato){
									go2=go;
									break;
								}
							}
							d.moverRectangulo(3);
							if (!mato){
								d.mover(2);
							}
						}
					}
					else{
						d.setChoco(true);;
					}

					break;
				case 3:
					if(d.getPosicion().getX()/64<13){
							d.moverRectangulo(3);
							o=m.getObjetoEn((int)(d.getPosicion().getX()/64)+1,((int)(d.getPosicion().getY()+28)/64));
							pl=m.getListaSegundaMatriz(((int)d.getPosicion().getX()/64)+1,((int)(d.getPosicion().getY()+28)/64));
							
							if (o.getRectangulo().intersects(d.getRectangulo()))
								d.setChoco(o.colisionar(d.getVisitor()));
							
							if (!choco){
								for(GameObject go:pl){
									if (go.getRectangulo().intersects(d.getRectangulo()))
										mato=go.colisionar(d.getVisitor());
									if (mato){
										go2=go;
										break;
									}
								} 
								d.moverRectangulo(2);
								if (!mato){
									d.mover(3);
								}
							}
						
						else
							d.mover(3);
					}
					else{
						d.setChoco(true);;
					}
					break;
				}
				
				if (d.getChoco()){
					gui.remove(d.getGrafico());					
					if (o.getVida()==0)
						m.eliminarObs(o.getPosicion());
					player.chocoDisparo();
					
				}
				if (mato){
					gui.remove(d.getGrafico());
					if (((Enemigo)go2).getMuerto()){
						player.aumentarPuntos(((Enemigo)go2).getPuntaje());
						player.destruyoEnemigo();
						gui.remove(go2.getGrafico());
						m.removeTanque(go2,(int)go2.getPosicion().getX()/64,(int)go2.getPosicion().getY()/64);
						m.removeTanque(go2,(int)go2.getPosicion().getX()/64,((int)go2.getPosicion().getY()/64)+1);
						m.removeTanque(go2,((int)go2.getPosicion().getX()/64)+1,(int)go2.getPosicion().getY()/64);
						m.removeTanque(go2,((int)go2.getPosicion().getX()/64)+1,((int)go2.getPosicion().getY()/64)+1);
						m.removeTanque(go2,((int)go2.getPosicion().getX()/64)+2,((int)go2.getPosicion().getY()/64)+1);
						m.removeTanque(go2,((int)go2.getPosicion().getX()/64)+2,((int)go2.getPosicion().getY()/64));
						m.removeTanque(go2,((int)go2.getPosicion().getX()/64)-1,((int)go2.getPosicion().getY()/64));
						m.removeTanque(go2,((int)go2.getPosicion().getX()/64)-1,((int)go2.getPosicion().getY()/64)-1);
						m.removeTanque(go2,((int)go2.getPosicion().getX()/64),((int)go2.getPosicion().getY()/64)-1);
						
					}
					player.chocoDisparo();
				}
				
				gui.repaint();
					
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}


}