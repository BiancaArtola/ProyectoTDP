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
			//for (int j=0;j<1;j++){
				int mov=1;

				for (int z=0;z<4;z++){
					switch(mov){
						case 0:
							//go=mapa.getObjetoEn((int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY()-1);
							//puede=tanques[j].colisionar(go.getVisitor());
							if (puede){
								tanques[0].mover(0);
								gui.repaint();
								//mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
							}
						case 1:
							//go=mapa.getObjetoEn((int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY()-1);
							//puede=tanques[j].colisionar(go.getVisitor());
							if (puede){
								tanques[0].mover(0);
								gui.repaint();
								//mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
							}
						case 2:
							//go=mapa.getObjetoEn((int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY()-1);
							//puede=tanques[j].colisionar(go.getVisitor());
							if (puede){
								tanques[0].mover(2);
								gui.repaint();
								//mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
							}
						case 3:
							//go=mapa.getObjetoEn((int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY()-1);
							//puede=tanques[j].colisionar(go.getVisitor());
							if (puede){
								tanques[0].mover(2);
								gui.repaint();
								//mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
							} 


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
