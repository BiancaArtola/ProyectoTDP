package Logica;

public class GanarYPerder {

	protected General j;
	
	public GanarYPerder(General g){
		j=g;
	}
	
	public void ganar(){
		j.ganar();
	}
	
	public void perder(){
		j.gameover();
	}
}
