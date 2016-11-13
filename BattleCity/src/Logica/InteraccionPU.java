package Logica;

public class InteraccionPU {

	protected General juego;
	
	public InteraccionPU(General j){
		juego=j;
	}
	
	public void destruirTodos(){
		juego.limpiarEnemigos();
	}
	
	public void protegerBase(){
		juego.protegerBase();
	}
	public void pararEnemigos(){
		juego.pararEnemigos();
	}
}
