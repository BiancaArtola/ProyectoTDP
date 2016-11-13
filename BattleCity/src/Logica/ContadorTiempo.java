package Logica;

public class ContadorTiempo implements Runnable {
	
	protected int seg;
	
	public ContadorTiempo(int s){
		seg=s;
	}
	
	public void run(){
		try {
			Thread.sleep(seg*1000);
		} catch (InterruptedException e) {
		}
	}
	
}
