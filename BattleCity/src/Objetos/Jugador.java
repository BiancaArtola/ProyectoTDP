package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Jugador extends Tanque {

	
	private Disparo[] disparos;
	private int cantDestruidos,score,disparossimultaneos,nivel,daire;
	private Nivel lvl;
	
	public Jugador(){
		imagen=new ImageIcon[4];
		
		disparos=new Disparo[4];
		cantDestruidos=score=daire=0;
		disparossimultaneos=nivel=1;
		
		lvl=new Uno(this);
		
		posicion=new Point(0,0);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/Images/up.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/Images/down.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/Images/left.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/Images/right.png"));
	}
	
	
	public void mover(int x){
		lvl.mover(x);
	}
	
	@Override
	
	public Disparo disparar() {
		disparos[daire]=new DisparoJugador();
		return disparos[daire];
	}

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub
		
	}

	public void aumentarPuntos(int puntaje) {
		score+=puntaje;
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return score;
	}
	
	public int subirNivel(){
		nivel++;
		switch (nivel-1){
			case 1:
				lvl=new Dos(this);
				break;
			case 2:
				lvl=new Tres(this);
				break;
			case 3:
				lvl=new Cuatro(this);
				break;
			default:
				nivel--;
		}
		return nivel;
	}

}
