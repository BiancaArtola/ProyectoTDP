package Logica;

import java.util.Random;

import Objetos.Enemigo;
import Objetos.GameObject;
import Objetos.Obstaculo;

public class InteligenciaEnemigos implements Runnable{

	protected Enemigo[] tanques;
	protected Mapa mapa;
	
	public InteligenciaEnemigos(Enemigo[] malos,Mapa m){
		tanques=malos;
		mapa=m;
	}
	
	public void run(){
		Random r=new Random();
		
		//Inicializar enemigo
				
		while(true){
			for (int j=0;j<4;j++){
				int mov=r.nextInt(4);
				
				switch(mov){
					case 0:
						Obstaculo go=mapa.getObjetoEn((int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
						boolean puede=tanques[j].colisionar(go.getVisitor());
						if (puede){
							tanques[j].mover(0);
							mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
						}
						
				
				}
				
			}
				
			
			
		}
		
		
	}
}
