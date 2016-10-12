package Logica;

import java.util.Random;

import Objetos.Enemigo;
import Objetos.GameObject;
import Objetos.Obstaculo;

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

	/**
	 * Constructor de la clase InteligenciaEnemigos
	 * @param malos: arreglo de tipo Enemigos. Contiene los enemigos del mapa
	 * @param m: Mapa
	 */
	public InteligenciaEnemigos(Enemigo[] malos,Mapa m){
		tanques=malos;
		mapa=m;
		this.run();
	}

	/**
	 * Metodo run
	 */
	public void run(){
		Random r=new Random();
		int x,y;
		//Inicializar enemigo				
		while(true){
			for (int j=0;j<4;j++){
				int mov=r.nextInt(4);

				switch(mov){
						case 0:
							Obstaculo go=mapa.getObjetoEn((int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY()-1);
							boolean puede=tanques[j].colisionar(go.getVisitor());
							if (puede){
								tanques[j].mover(0);
								mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
							}
						case 1:
							Obstaculo go=mapa.getObjetoEn((int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY()-1);
							boolean puede=tanques[j].colisionar(go.getVisitor());
							if (puede){
								tanques[j].mover(1);
								mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
							}
						case 2:
							Obstaculo go=mapa.getObjetoEn((int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY()-1);
							boolean puede=tanques[j].colisionar(go.getVisitor());
							if (puede){
								tanques[j].mover(2);
								mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
							}
						case 3:
							Obstaculo go=mapa.getObjetoEn((int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY()-1);
							boolean puede=tanques[j].colisionar(go.getVisitor());
							if (puede){
								tanques[j].mover(3);
								mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
						}


				}

			}



		}


	}
}
