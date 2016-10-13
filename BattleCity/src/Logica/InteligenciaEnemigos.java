package Logica;

import java.util.Random;

import javax.swing.ImageIcon;

import GUI.G;
import Objetos.Enemigo;
import Objetos.GameObject;
import Objetos.Obstaculo;
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
	protected Enemigo[] tanques;
	protected Mapa mapa;
	protected G gui;
	/**
	 * Constructor de la clase InteligenciaEnemigos
	 * @param gui 
	 * @param malos: arreglo de tipo Enemigos. Contiene los enemigos del mapa
	 * @param m: Mapa
	 */
	public InteligenciaEnemigos(Enemigo[] malos,Mapa m, G gui){
		tanques=malos;
		mapa=m;
		this.gui=gui;
	}

	/**
	 * Metodo run
	 */
	public void run(){
		Random r=new Random();
		int x,y;
		boolean puede=true;
		Obstaculo go=null;
		ImageIcon i=null;
		
		//Inicializar enemigo	
		while(true){
			for (int j=0;j<1;j++){
				int mov=r.nextInt(4);

			for (int z=0;z<4;z++){
				switch(mov){
						case 0:
							//go=mapa.getObjetoEn((int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY()-1);
							//puede=tanques[j].colisionar(go.getVisitor());
							if (puede){
								tanques[j].mover(0);
								tanques[j].getGrafico().setLocation(tanques[j].getPosicion());
								i=tanques[j].actualizarImagen(0);
								tanques[j].getGrafico().setIcon(i);
								//mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
							}
						case 1:
							//go=mapa.getObjetoEn((int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY()-1);
							//puede=tanques[j].colisionar(go.getVisitor());
							if (puede){
								tanques[j].mover(1);
								tanques[j].getGrafico().setLocation(tanques[j].getPosicion());
								i=tanques[j].actualizarImagen(1);
								tanques[j].getGrafico().setIcon(i);
								gui.repaint();
								//mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
							}
						case 2:
							//go=mapa.getObjetoEn((int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY()-1);
							//puede=tanques[j].colisionar(go.getVisitor());
							if (puede){
								tanques[j].mover(2);
								tanques[j].getGrafico().setLocation(tanques[j].getPosicion());
								i=tanques[j].actualizarImagen(2);
								tanques[j].getGrafico().setIcon(i);
								//mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
							}
						case 3:
							//go=mapa.getObjetoEn((int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY()-1);
							//puede=tanques[j].colisionar(go.getVisitor());
							if (puede){
								tanques[j].mover(3);
								tanques[j].getGrafico().setLocation(tanques[j].getPosicion());
								i=tanques[j].actualizarImagen(3);
								tanques[j].getGrafico().setIcon(i);
								gui.repaint();
								//mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
							} 


				}
				}
			gui.validate();
			gui.repaint();
			}

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		


	}
}
