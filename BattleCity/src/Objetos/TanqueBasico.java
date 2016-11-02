package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitores.*;

public class TanqueBasico extends Enemigo {

	
	public TanqueBasico(int i, int j){
		imagen=new ImageIcon[4];
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/EnemigoArriba.png"));
		imagen[1]=new ImageIcon(this.getClass().getResource("/Images/EnemigoAbajo.png"));
		imagen[2]=new ImageIcon(this.getClass().getResource("/Images/EnemigoIzquierda.png"));
		imagen[3]=new ImageIcon(this.getClass().getResource("/Images/EnemigoDerecha.png"));
		puntaje=500;
		posicion=new Point(i,j);
		grafico=new JLabel(imagen[0]);
		grafico.setSize(64,64);
		grafico.setLocation(posicion);
		miVisitor=new VisitorObstaculoNoTransitable();
	}
	
	@Override
	public Disparo disparar() {
		//p es de tipo Jugador
				int x=(int)this.getPosicion().getX();
				int y=(int)this.getPosicion().getY();
				
				if (this.getDireccion()==0)
					y = y-64; //abajo
				else
					if (this.getDireccion()==1)
						y=y+64; //arriba
					else
						if (this.getDireccion()==2)
							x = x-64; //izquierda
						else
							x = x+64; //derecha
				DisparoJugador d=null;
				if (this.getCantidadDisparos()==0)		
					d= new DisparoEnemigo(64,x,y,this.getDireccion());
				return d;
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
			if(posicion.getY()-64>=0){
				posicion.setLocation(posicion.getX(),posicion.getY()-64);
				grafico.setLocation(posicion);
				grafico.setIcon(imagen[0]);
			}
			break;
		case 1:
			if(posicion.getY()+64<=832){
				posicion.setLocation(posicion.getX(),posicion.getY()+64);
				grafico.setLocation(posicion);
				grafico.setIcon(imagen[1]);}
			break;
		case 2:
			if(posicion.getX()-64>=0){
				posicion.setLocation(posicion.getX()-64,posicion.getY());
				grafico.setLocation(posicion);
				grafico.setIcon(imagen[2]);}
			break;
		case 3:
			if(posicion.getX()+64<=832){
				posicion.setLocation(posicion.getX()+64,posicion.getY());
				grafico.setLocation(posicion);
				grafico.setIcon(imagen[3]);
				}
		default:
			break;
		}
		
	}

}