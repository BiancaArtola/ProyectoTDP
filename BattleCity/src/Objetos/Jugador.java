package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitores.Visitor;

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
		direccion=0;
		
		posicion=new Point(0,0);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/Images/TanqueNuevo.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/Images/TanqueNuevoAbajo.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/Images/TanqueNuevoIzquierda.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/Images/TanqueNuevoDerecha.png"));
		grafico=new JLabel();
		grafico.setIcon(imagen[0]);
		grafico.setLocation(posicion);
		grafico.setSize(64,64);
	}
	
	
	public void mover(int x){
		lvl.mover(x);
	}
	
	@Override
	
	public DisparoJugador disparar() {
		return lvl.disparar();
	}


	public boolean colisionar(Visitor visitor) {
		return visitor.visitarJugador(this);
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
