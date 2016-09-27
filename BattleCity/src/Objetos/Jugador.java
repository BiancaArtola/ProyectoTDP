package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Jugador extends Tanque {

	
	private Disparo[] disparos;
	private int cantDestruidos,score,disparossimultaneos,nivel,daire;
	
	public Jugador(){
		imagen=new ImageIcon[4];
		
		disparos=new Disparo[4];
		cantDestruidos=score=daire=0;
		disparossimultaneos=nivel=1;
		
		posicion=new Point(0,0);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/Images/up.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/Images/down.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/Images/left.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/Images/right.png"));
	}
	
	@Override
	
	public Disparo disparar() {
		disparos[daire]=new Disparo();
		return disparos[daire];
	}

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub
		
	}

	public void aumentarPuntos(int puntaje) {
		score+=puntaje;
	}
	

}
