package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitores.*;

public class TanqueBasico extends Enemigo {

	
	public TanqueBasico(int i, int j){
		imagen=new ImageIcon[4];
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/up2.png"));
		imagen[1]=new ImageIcon(this.getClass().getResource("/Images/down2.png"));
		imagen[2]=new ImageIcon(this.getClass().getResource("/Images/left2.png"));
		imagen[3]=new ImageIcon(this.getClass().getResource("/Images/right2.png"));
		puntaje=100;
		posicion=new Point(i,j);
		grafico=new JLabel(imagen[0]);
		grafico.setSize(64,64);
		grafico.setLocation(posicion);
		miVisitor=new VisitorObstaculoNoTransitable();
	}
	
	@Override
	public Disparo disparar() {
		return null;
	}

	@Override
	public boolean colisionar(Visitor visitor) {
		return visitor.visitarEnemigo(this);
	}

	@Override
	public void mover(int x) {
		Point posicion=this.getPosicion();
		switch (x) {
		case 0:
			if(posicion.getY()-8>=0){
				posicion.setLocation(posicion.getX(),posicion.getY()-8);
				grafico.setIcon(imagen[0]);
			}
			break;
		case 1:
			if(posicion.getY()+8<=832){
				posicion.setLocation(posicion.getX(),posicion.getY()+8);
				grafico.setIcon(imagen[1]);}
			break;
		case 2:
			if(posicion.getX()-8>=0){
				posicion.setLocation(posicion.getX()-8,posicion.getY());
				grafico.setIcon(imagen[2]);}
			break;
		case 3:
			if(posicion.getX()+8<=832){
				posicion.setLocation(posicion.getX()+8,posicion.getY());
				grafico.setIcon(imagen[3]);
				}
		default:
			break;
		}
		
	}

}
