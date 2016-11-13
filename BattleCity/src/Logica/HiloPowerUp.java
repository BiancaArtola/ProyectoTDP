package Logica;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.G;
import Objetos.GameObject;
import PU.Casco;
import PU.Estrella;
import PU.Granada;
import PU.Pala;
import PU.PowerUp;
import PU.TanquePU;
import PU.Timer;
import TDALista.PositionList;
import Visitores.*;

public class HiloPowerUp implements Runnable{
	private Mapa m;
	private G g;
	private InteraccionPU interaccion;
	
	public HiloPowerUp(Mapa mapa, G gui, InteraccionPU iPU){
		m= mapa;
		g= gui;
		interaccion=iPU;		
	}
	
	public void run(){
		
		Random r=new Random();
		Random x=new Random();
		Random y=new Random();
		int d, dx, dy, pu;
		int count=0;
		PowerUp power = null;
		while(General.corriendo){
			d=r.nextInt(2);
			if(d==1){
				dx=r.nextInt(14);
				dy=r.nextInt(14);
				pu=r.nextInt(6);
				switch(pu){
				case 0: 
					power= new Granada(new Point(dx*64,dy*64),interaccion);
					break;
				case 1:
					power= new Casco(new Point(dx*64,dy*64));
					break;
				case 2:
					power= new Pala(new Point(dx*64,dy*64),interaccion);
					break;
				case 3:
					power= new Estrella(new Point(dx*64,dy*64));
					break;
				case 4:
					power= new TanquePU(new Point(dx*64,dy*64));
					break;
				case 5:
					power= new Timer(new Point(dx*64,dy*64),interaccion);
					break;
				}
				if (m.getObjetoEn(dx,dy).getPuedeContener() && (dx!=6 || dy!=13)){
					PositionList<GameObject> pl=m.getListaSegundaMatriz((int)power.getPosicion().getX()/64,(int)power.getPosicion().getY()/64);
					pl.addLast(power);
					g.getContentPane().add(power.getGrafico());
					g.getContentPane().setComponentZOrder(power.getGrafico(), 0);
					while(count<5){
						count++;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					count=0;
					g.getContentPane().remove(power.getGrafico());
					m.removeTanque(power,(int)power.getPosicion().getX()/64,(int)power.getPosicion().getY()/64);
					g.repaint();
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			

		}
	}
}
