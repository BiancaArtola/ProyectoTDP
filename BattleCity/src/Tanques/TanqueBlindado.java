package Tanques;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Objetos.Disparo;
import Visitores.*;

public class TanqueBlindado extends Enemigo {


	public TanqueBlindado(int x,int y){
		imagen=new ImageIcon[4];
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/TanqueEnemigo2Arriba.png"));
		imagen[1]=new ImageIcon(this.getClass().getResource("/Images/TanqueEnemigo2Abajo.png"));
		imagen[2]=new ImageIcon(this.getClass().getResource("/Images/TanqueEnemigo2Izquierda.png"));
		imagen[3]=new ImageIcon(this.getClass().getResource("/Images/TanqueEnemigo2Derecha.png"));
		puntaje=400;
		posicion=new Point(x,y);
		grafico=new JLabel(imagen[0]);
		grafico.setSize(64,64);
		grafico.setLocation(posicion);
		miVisitor=new VisitorObstaculoNoTransitable();
		resistencia=4;
		muerto=false;
		velocidadMov=4;
		velocidadDis=8;
		disparosDisponibles=1;
		r=new Rectangle();
		r.setBounds(x+4,y+4,60,60);
	}


	public void mover(int x){
		switch (x) {
		case 0:
			if(posicion.getY()-8>=0)
				posicion.setLocation(posicion.getX(),posicion.getY()-8);
			break;
		case 1:
			if(posicion.getY()+8<=832)
				posicion.setLocation(posicion.getX(),posicion.getY()+8);
			break;
		case 2:
			if(posicion.getX()-8>=0)
				posicion.setLocation(posicion.getX()-8,posicion.getY());
			break;
		case 3:
			if(posicion.getX()+8<=832)
				posicion.setLocation(posicion.getX()+8,posicion.getY());

		default:
			break;
			}
	}


	@Override
	public boolean colisionar(Visitor visitor) {
		return visitor.visitarEnemigo(this);
		
	}


	@Override
	public Tanque getNuevoTanque() {
		// TODO Auto-generated method stub
		return new TanqueBlindado((int)this.posicion.getX(),(int)this.posicion.getY());
	}

}
