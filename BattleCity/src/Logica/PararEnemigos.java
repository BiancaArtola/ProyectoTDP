package Logica;

import Tanques.Enemigo;

public class PararEnemigos implements Runnable {

	protected Enemigo[] enemigos;
	
	public PararEnemigos(Enemigo[] e){
		enemigos=e;
	}
	
	
	public void run(){
		General.puedenMover=false;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		General.puedenMover=true;
		
	}
}
