package Tanques;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Objetos.Disparo;
import Visitores.*;

public class TanqueRapido extends Enemigo {

	public TanqueRapido(int x,int y){
		imagen=new ImageIcon[4];
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/EnemigoArriba.png"));
		imagen[1]=new ImageIcon(this.getClass().getResource("/Images/EnemigoAbajo.png"));
		imagen[2]=new ImageIcon(this.getClass().getResource("/Images/EnemigoIzquierda.png"));
		imagen[3]=new ImageIcon(this.getClass().getResource("/Images/EnemigoDerecha.png"));
		puntaje=200;
		posicion=new Point(x,y);
		grafico=new JLabel(imagen[0]);
		grafico.setSize(64,64);
		grafico.setLocation(posicion);
		miVisitor=new VisitorObstaculoNoTransitable();
		resistencia=1;
		muerto=false;
		velocidadMov=8;
		velocidadDis=16;
		disparosDisponibles=1;
		r=new Rectangle();
		r.setBounds(x+4,y+4,60,60);
	}
	

	@Override
	public boolean colisionar(Visitor v) {
		return v.visitarEnemigo(this);
		
	}

	@Override
	public Tanque getNuevoTanque() {
		return new TanqueDePoder((int)this.posicion.getX(),(int)this.posicion.getY());
	}

}
