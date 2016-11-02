package Logica;

import GUI.G;
import Objetos.*;

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
			while(!choco){
				switch(direccion){
				case 0: //ARRIBA
					if(d.getPosicion().getY()/64>0){
						if(d.getPosicion().getY()/64>=1 && (d.getPosicion().getY()%64<1))
							o=m.getObjetoEn((int)(d.getPosicion().getX()/64),(int)(d.getPosicion().getY()/64)-1);

						//Si el obstaculo o puede colisionar con el visitor del disparoJugador d, choco es verdadero. Falso en caso contrario
						choco = o.colisionar(d.getVisitor());
						if (!choco){
							d.mover(0);
							d.getGrafico().setLocation(d.getPosicion());
						}
						/*else
									d.getGrafico().setLocation((int)d.getPosicion().getX(), (int)d.getPosicion().getY()-8);*/
					}
					else{
						choco=true;
					}
					break;
				case 1: //ABAJO
					if((int)d.getPosicion().getY()/64<13){
						o = m.getObjetoEn((int)(d.getPosicion().getX()/64),(int)(d.getPosicion().getY()/64)+1);
						choco=o.colisionar(d.getVisitor());
						if (!choco){
							d.mover(1);
							d.getGrafico().setLocation(d.getPosicion());
						}
					}
					else
						choco=true;
					break;
				case 2: //IZQUIERDA
					if((d.getPosicion().getX()/64>0) ){
						if(d.getPosicion().getX()/64>=1 && (d.getPosicion().getX()%64<1))
							o=m.getObjetoEn((int)(d.getPosicion().getX()/64)-1,(int)(d.getPosicion().getY()/64));
						choco=o.colisionar(d.getVisitor());
						if (!choco){
							d.mover(2);
							d.getGrafico().setLocation(d.getPosicion());
						}
					}
					else
						choco=true;

					break;
				case 3:
					if((int)d.getPosicion().getX()/64<13){
						o=m.getObjetoEn((int)(d.getPosicion().getX()/64)+1,(int)(d.getPosicion().getY()/64));
						choco=o.colisionar(d.getVisitor());
						if (!choco){
							d.mover(3);
							d.getGrafico().setLocation(d.getPosicion());
						}
					}
					else
						choco=true;
					break;
				}
				if (choco){
					gui.remove(d.getGrafico());					
					if (o.getVida()==0)
						m.eliminarObs(o.getPosicion());
					player.eliminarDisparo(d);
				}

				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}


}