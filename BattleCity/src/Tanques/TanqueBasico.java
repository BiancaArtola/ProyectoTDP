package Tanques;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Objetos.Disparo;
import Objetos.DisparoEnemigo;
import Visitores.*;

public class TanqueBasico extends Enemigo {

	
	public TanqueBasico(int i, int j){
		imagen=new ImageIcon[4];
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/TanquePoderosoArriba.png"));
		imagen[1]=new ImageIcon(this.getClass().getResource("/Images/TanquePoderosoAbajo.png"));
		imagen[2]=new ImageIcon(this.getClass().getResource("/Images/TanquePoderosoIzquierda.png"));
		imagen[3]=new ImageIcon(this.getClass().getResource("/Images/TanquePoderosoDerecha.png"));
		puntaje=100;
		posicion=new Point(i,j);
		grafico=new JLabel(imagen[0]);
		grafico.setSize(64,64);
		grafico.setLocation(posicion);
		miVisitor=new VisitorObstaculoNoTransitable();
		muerto=false;
		disparos=new Disparo[1];
		r=new Rectangle();
		r.setBounds(i+4,j+4, 60,60);
		velocidadMov=4;
		disparosDisponibles=1;
		resistencia=1;
		velocidadDis=8;
	}

	@Override
	public boolean colisionar(Visitor visitor) {
		return visitor.visitarEnemigo(this);
	}

	@Override
	public Tanque getNuevoTanque() {
		return new TanqueRapido((int)this.getPosicion().getX(),(int)this.getPosicion().getY());
	}
	
	

}