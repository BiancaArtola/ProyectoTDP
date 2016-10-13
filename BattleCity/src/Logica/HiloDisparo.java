package Logica;

import GUI.G;
import Objetos.*;

public class HiloDisparo implements Runnable {

	private DisparoJugador d;
	private int direccion;
	private Mapa m;
	private G gui;
	
	public HiloDisparo(DisparoJugador shot,int dir,Mapa map,G gui) {
		this.d=shot;
		direccion=dir;
		m=map;
		this.gui=gui;
	}

	@Override
	public void run() {
		boolean choco=false;
		Obstaculo o=null;
		while(!choco){
				switch(direccion){
						case 0:
							if(d.getPosicion().getY()/64>0){
								o=m.getObjetoEn((int)(d.getPosicion().getX()/64),(int)(d.getPosicion().getY()/64)-1);
								choco=o.colisionar(d.getVisitor());
								if (!choco){
									d.mover(0);
									d.getGrafico().setLocation(d.getPosicion());
								}
							}
							else
								choco=true;
						case 1:
							if(d.getPosicion().getY()/64<13){
							o=m.getObjetoEn((int)(d.getPosicion().getX()/64),(int)(d.getPosicion().getY()/64)+1);
							choco=o.colisionar(d.getVisitor());
							if (!choco){
								d.mover(1);
								d.getGrafico().setLocation(d.getPosicion());}
							}
							else
								choco=true;
							
						case 2:
							if(d.getPosicion().getX()/64>0){
							o=m.getObjetoEn((int)(d.getPosicion().getX()/64)-1,(int)(d.getPosicion().getY()/64));
							choco=o.colisionar(d.getVisitor());
							if (!choco){
								d.mover(2);
								d.getGrafico().setLocation(d.getPosicion());
								}
							}
							else
								choco=true;
						case 3:
							if(d.getPosicion().getX()/64<13){
							o=m.getObjetoEn((int)(d.getPosicion().getX()/64)+1,(int)(d.getPosicion().getY()/64));
							choco=o.colisionar(d.getVisitor());
							if (!choco){
								d.mover(3);
								d.getGrafico().setLocation(d.getPosicion());}
							}
							else
								choco=true;
					
					//d.mover(2);
					//d.getGrafico().setLocation(d.getPosicion());
				}
				if (choco){
					gui.remove(d.getGrafico());
					d.destruir();
					}

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
}

