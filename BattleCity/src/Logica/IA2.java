package Logica;

import java.util.Random;

import GUI.G;
import Objetos.Disparo;
import Objetos.GameObject;
import Obstaculos.Obstaculo;
import TDALista.PositionList;
import Tanques.Enemigo;
import Tanques.Tanque;

public class IA2 implements Runnable {

	protected Mapa mapa;
	protected Tanque e;
	protected G gui;
	
	public IA2(Mapa mapa,G g,Enemigo t){
		this.mapa=mapa;
		gui=g;
		e=t;
	}
	
	public void run(){
		Obstaculo o=null;
		Obstaculo o2=null;
		PositionList<GameObject> pl=null;
		PositionList<GameObject> pl2=null;
		Random movimiento=new Random();
		Random disparo=new Random();
		int mov;
		int dis;
		int cantidadMovimientos=0;
		boolean puede=false;
		while (General.puedenMover && General.corriendo){
			System.out.println(e);
			puede=false;
			mov=movimiento.nextInt(4);
			while (cantidadMovimientos<7)
				cantidadMovimientos=movimiento.nextInt(15);
			for (int i=0;i<cantidadMovimientos;i++){
				dis=disparo.nextInt(5);
				switch(mov){
				case 0:
					if (e.getPosicion().getY()>0){
						if (e.getPosicion().getY()%64==0){
							o=mapa.getObjetoEn((int)e.getPosicion().getX()/64,(int)e.getPosicion().getY()/64-1);
							o2=mapa.getObjetoEn(((int)e.getPosicion().getX()/64)+1,((int)e.getPosicion().getY()/64)-1);

							if (o==null || o2==null)
								puede=false;
							
							e.moverRectangulo(0);

							if (e.getRectangulo().intersects(o.getRectangulo()))
								puede=e.colisionar(o.getVisitor());

							if (puede && o!=o2 && e.getRectangulo().intersects(o2.getRectangulo()))
								puede=e.colisionar(o2.getVisitor());

							pl=mapa.getListaSegundaMatriz((int)e.getPosicion().getX()/64,(int)e.getPosicion().getY()/64-1);
							pl2=mapa.getListaSegundaMatriz(((int)e.getPosicion().getX()/64)+1,((int)e.getPosicion().getY()/64)-1);

							if (puede)
								for(GameObject go:pl)
									if (e.getRectangulo().intersects(go.getRectangulo()))
										puede=e.colisionar(go.getVisitor());

							if (puede && pl!=pl2)
								for(GameObject go:pl2)
									if (e.getRectangulo().intersects(go.getRectangulo()))
										puede=e.colisionar(go.getVisitor());

							e.moverRectangulo(1);
							
							if (puede){
								e.mover(0);
								pl.addLast(e);
								if (pl!=pl2)
									pl2.addLast(e);
								if ((e.getPosicion().getY()+64)%64==0){
									mapa.removeTanque(e,(int)e.getPosicion().getX()/64,((int)e.getPosicion().getY()/64)+1);
									mapa.removeTanque(e,((int)e.getPosicion().getX()/64)+1,((int)e.getPosicion().getY()/64)+1);
								}
							}
							else{
								e.setDireccion(0);
								mov=movimiento.nextInt(4);
							}
						}
						else{
							e.mover(0);
							if ((e.getPosicion().getY()+64)%64==0){
								mapa.removeTanque(e,(int)e.getPosicion().getX()/64,((int)e.getPosicion().getY()/64)+1);
								mapa.removeTanque(e,((int)e.getPosicion().getX()/64)+1,((int)e.getPosicion().getY()/64)+1);
							}
						}

					}
					else{
						e.setDireccion(0);
						mov=movimiento.nextInt(4);
					}
					break;
				case 1:
					if (e.getPosicion().getY()/64<13){
						if (e.getPosicion().getY()%64==0){
							o=mapa.getObjetoEn((int)e.getPosicion().getX()/64,(int)e.getPosicion().getY()/64+1);
							o2=mapa.getObjetoEn(((int)e.getPosicion().getX()/64)+1,((int)e.getPosicion().getY()/64)+1);

							if (o==null || o2==null)
								puede=false;
							
							e.moverRectangulo(1);

							if (e.getRectangulo().intersects(o.getRectangulo()))
								puede=e.colisionar(o.getVisitor());

							if (puede && o!=o2 && e.getRectangulo().intersects(o2.getRectangulo()))
								puede=e.colisionar(o2.getVisitor());

							pl=mapa.getListaSegundaMatriz((int)e.getPosicion().getX()/64,(int)e.getPosicion().getY()/64+1);
							pl2=mapa.getListaSegundaMatriz(((int)e.getPosicion().getX()/64)+1,((int)e.getPosicion().getY()/64)+1);

							if (puede)
								for(GameObject go:pl)
									if (e.getRectangulo().intersects(go.getRectangulo()))
										puede=e.colisionar(go.getVisitor());

							if (puede && pl!=pl2)
								for(GameObject go:pl2)
									if (e.getRectangulo().intersects(go.getRectangulo()))
										puede=e.colisionar(go.getVisitor());

							e.moverRectangulo(0);
							
							if (puede){
								e.mover(1);
								pl.addLast(e);
								if (pl!=pl2)
									pl2.addLast(e);
								if ((e.getPosicion().getY())%64==0){
									mapa.removeTanque(e,(int)e.getPosicion().getX()/64,((int)e.getPosicion().getY()/64)-1);
									mapa.removeTanque(e,((int)e.getPosicion().getX()/64)+1,((int)e.getPosicion().getY()/64)-1);
								}
							}
							else{
								e.setDireccion(1);
								mov=movimiento.nextInt(4);
							}
						}
						else{
							e.mover(1);
							if ((e.getPosicion().getY())%64==0){
								mapa.removeTanque(e,(int)e.getPosicion().getX()/64,((int)e.getPosicion().getY()/64)-1);
								mapa.removeTanque(e,((int)e.getPosicion().getX()/64)+1,((int)e.getPosicion().getY()/64)-1);
							}
						}
					}
					else{
						mov=movimiento.nextInt(4);
						e.setDireccion(1);
					}
					break;
				case 2:
					if (e.getPosicion().getX()>0){
						if (e.getPosicion().getX()%64==0){
							o=mapa.getObjetoEn((int)e.getPosicion().getX()/64-1,(int)e.getPosicion().getY()/64);
							o2=mapa.getObjetoEn(((int)e.getPosicion().getX()/64)-1,((int)e.getPosicion().getY()/64)+1);

							if (o==null || o2==null)
								puede=false;
							
							e.moverRectangulo(2);
							if (e.getRectangulo().intersects(o.getRectangulo())){
								puede=e.colisionar(o.getVisitor());
								
							}

							if (puede && o!=o2 && e.getRectangulo().intersects(o2.getRectangulo()))
								puede=e.colisionar(o2.getVisitor());

							pl=mapa.getListaSegundaMatriz(((int)e.getPosicion().getX()/64)-1,(int)e.getPosicion().getY()/64);
							pl2=mapa.getListaSegundaMatriz(((int)e.getPosicion().getX()/64)-1,((int)e.getPosicion().getY()/64)+1);

							if (puede)
								for(GameObject go:pl)
									if (e.getRectangulo().intersects(go.getRectangulo()))
										puede=e.colisionar(go.getVisitor());

							if (puede && pl!=pl2)
								for(GameObject go:pl2)
									if (e.getRectangulo().intersects(go.getRectangulo()))
										puede=e.colisionar(go.getVisitor());

							e.moverRectangulo(3);
							
							if (puede){
								e.mover(2);
								pl.addLast(e);
								if (pl!=pl2)
									pl2.addLast(e);
								if ((e.getPosicion().getX()+64)%64==0){
									mapa.removeTanque(e,((int)e.getPosicion().getX()/64)+1,((int)e.getPosicion().getY()/64));
									mapa.removeTanque(e,((int)e.getPosicion().getX()/64)+1,((int)e.getPosicion().getY()/64)+1);
								}
							}
							else{
								e.setDireccion(2);
								mov=movimiento.nextInt(4);
							}
						}
						else{
							e.mover(2);
							if ((e.getPosicion().getX()+64)%64==0){
								mapa.removeTanque(e,((int)e.getPosicion().getX()/64)+1,((int)e.getPosicion().getY()/64));
								mapa.removeTanque(e,((int)e.getPosicion().getX()/64)+1,((int)e.getPosicion().getY()/64)+1);
							}
						}
					}
					else{
						e.setDireccion(2);
						mov=movimiento.nextInt(4);
					}
					break;
				case 3:
					if ((e.getPosicion().getX()/64)<13){
						if (e.getPosicion().getX()%64==0){
							o=mapa.getObjetoEn(((int)e.getPosicion().getX()/64)+1,(int)e.getPosicion().getY()/64);
							o2=mapa.getObjetoEn(((int)e.getPosicion().getX()/64)+1,((int)e.getPosicion().getY()/64)+1);

							if (o==null || o2==null)
								puede=false;
							
							e.moverRectangulo(3);

							if (e.getRectangulo().intersects(o.getRectangulo()))
								puede=e.colisionar(o.getVisitor());

							if (puede && o!=o2 && e.getRectangulo().intersects(o2.getRectangulo()))
								puede=e.colisionar(o2.getVisitor());

							pl=mapa.getListaSegundaMatriz(((int)e.getPosicion().getX()/64)+1,(int)e.getPosicion().getY()/64);
							pl2=mapa.getListaSegundaMatriz(((int)e.getPosicion().getX()/64)+1,((int)e.getPosicion().getY()/64)+1);

							if (puede)
								for(GameObject go:pl)
									if (e.getRectangulo().intersects(go.getRectangulo()))
										puede=e.colisionar(go.getVisitor());

							if (puede && pl!=pl2)
								for(GameObject go:pl2)
									if (e.getRectangulo().intersects(go.getRectangulo()))
										puede=e.colisionar(go.getVisitor());

							e.moverRectangulo(2);
							
							if (puede){
								e.mover(3);
								pl.addLast(e);
								if (pl!=pl2)
									pl2.addLast(e);
								if ((e.getPosicion().getX())%64==0){
									mapa.removeTanque(e,(int)e.getPosicion().getX()/64-1,((int)e.getPosicion().getY()/64));
									mapa.removeTanque(e,((int)e.getPosicion().getX()/64)-1,((int)e.getPosicion().getY()/64)+1);
								}
							}
							else{
								e.setDireccion(3);
								mov=movimiento.nextInt(4);
							}
						}
						else{
							e.mover(3);
							if ((e.getPosicion().getX())%64==0){
								mapa.removeTanque(e,(int)e.getPosicion().getX()/64-1,((int)e.getPosicion().getY()/64));
								mapa.removeTanque(e,((int)e.getPosicion().getX()/64)-1,((int)e.getPosicion().getY()/64)+1);
							}
						}
					}
					else{
						e.setDireccion(3);
						mov=movimiento.nextInt(4);
					}
					break;
				}

				try {
					Thread.sleep(75);
				} catch (InterruptedException e1) {}
			if (dis==3){
				Disparo d=e.disparar();
				if (d!=null){
					if (d.getPosicion().getX()>0 && d.getPosicion().getX()<832){
						if (d.getPosicion().getY()>0 && d.getPosicion().getY()<832){
							gui.getContentPane().add(d.getGrafico());
							gui.getContentPane().setComponentZOrder(d.getGrafico(),0);
							movDisparoEnemigo mv=new movDisparoEnemigo((Enemigo)e,d,mapa,gui,((Enemigo)e).getDireccion());
							Thread t=new Thread(mv);
							t.start();
						}
					}
					
				}
			}
			
			
			}
		if (e.getMuerto()){
			e=((Enemigo)e).getNuevoTanque();
			mapa.getListaSegundaMatriz((int)e.getPosicion().getX()/64,(int)e.getPosicion().getY()/64).addLast(e);
			mapa.getListaSegundaMatriz((((int)e.getPosicion().getX()+63)/64),(int)e.getPosicion().getY()/64).addLast(e);
			mapa.getListaSegundaMatriz((int)e.getPosicion().getX()/64,(((int)e.getPosicion().getY()+63)/64)).addLast(e);
			mapa.getListaSegundaMatriz(((int)e.getPosicion().getX()+63)/64,((int)e.getPosicion().getY()+63)/64).addLast(e);
			gui.getContentPane().add(e.getGrafico());
			gui.setComponentZOrder(e.getGrafico(),0);
		}
		System.out.println(puede);
		
		}//Fin While(noMuerto)
	}
}
