package Logica;

import GUI.G;
import Objetos.Disparo;
import Objetos.GameObject;
import Obstaculos.Obstaculo;
import TDALista.PositionList;
import Tanques.*;

public class movDisparoEnemigo implements Runnable {

	private Disparo d;
	private int direccion;
	private Mapa m;
	private G gui;
	private Enemigo enemigo;
	
	public movDisparoEnemigo(Enemigo e,Disparo d,Mapa m,G gui,int dir){
		this.m=m;
		this.d=d;
		direccion=dir;
		this.gui=gui;
		enemigo=e;
	}
	
	@Override
	public void run() {
		Obstaculo o=null;
		PositionList<GameObject> pl=null;
		boolean mato=false;
		GameObject go2=null;
		while(!d.getChoco() && !mato){
			switch(direccion){
			case 0: //ARRIBA
				if(d.getPosicion().getY()/64>0){
						o=m.getObjetoEn(((int)(d.getPosicion().getX()+28)/64),(int)(d.getPosicion().getY()/64));
						pl=m.getListaSegundaMatriz(((int)d.getPosicion().getX()+28)/64,(int)(d.getPosicion().getY()/64));
					d.moverRectangulo(0);

					//Si el obstaculo o puede colisionar con el visitor del disparoJugador d, choco es verdadero. Falso en caso contrario
					if (d.getRectangulo().intersects(o.getRectangulo()))
						d.setChoco(o.colisionar(d.getVisitor()));
				
					if (!d.getChoco()){
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
					/*else
								d.getGrafico().setLocation((int)d.getPosicion().getX(), (int)d.getPosicion().getY()-8);*/
				}
				else{
					d.setChoco(true);;
				}
				break;
			case 1: //ABAJO
				if(d.getPosicion().getY()/64<13){
					o = m.getObjetoEn(((int)(d.getPosicion().getX()+28)/64),(int)(d.getPosicion().getY()/64)+1);
					pl=m.getListaSegundaMatriz(((int)d.getPosicion().getX()+28)/64,(int)(d.getPosicion().getY()/64)+1);
					d.moverRectangulo(1);
					
					if (d.getRectangulo().intersects(o.getRectangulo()))
						d.setChoco(o.colisionar(d.getVisitor()));
					if (!d.getChoco()){
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
				else
					d.setChoco(true);;
				break;
			case 2: //IZQUIERDA
				if((d.getPosicion().getX()/64>0) ){
						o=m.getObjetoEn((int)(d.getPosicion().getX()/64),((int)(d.getPosicion().getY()+28)/64));
						pl=m.getListaSegundaMatriz(((int)d.getPosicion().getX()/64),((int)(d.getPosicion().getY()+28)/64));
						 d.moverRectangulo(2);
					
					if (d.getRectangulo().intersects(o.getRectangulo()))	 
						 d.setChoco(o.colisionar(d.getVisitor()));
					if (!d.getChoco()){
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
				else
					d.setChoco(true);;

				break;
			case 3:
				if(d.getPosicion().getX()/64<13){
						
						d.moverRectangulo(3);
						o=m.getObjetoEn((int)(d.getPosicion().getX()/64)+1,((int)(d.getPosicion().getY()+28)/64));
						pl=m.getListaSegundaMatriz(((int)d.getPosicion().getX()/64)+1,((int)(d.getPosicion().getY()+28)/64));
						
						if (o.getRectangulo().intersects(d.getRectangulo()))
							d.setChoco(o.colisionar(d.getVisitor()));
						
						if (!d.getChoco()){
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
				else
					d.setChoco(true);
				break;
			}
			if (d.getChoco()){
				gui.getContentPane().remove(d.getGrafico());					
				if (o.getVida()==0)
					m.eliminarObs(o.getPosicion());
				enemigo.chocoDisparo();
				gui.getContentPane().repaint();
			}
			if (mato){
				gui.getContentPane().remove(d.getGrafico());
				enemigo.chocoDisparo();
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
