package PU;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitores.Visitor;
import Visitores.VisitorCasco;

public class Casco extends PowerUp {

	public Casco(Point m){
		miVisitor = new VisitorCasco();
		imagen= new ImageIcon[1];
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/Images/casco.png"));
		grafico= new JLabel(imagen[0]);
		posicion= m;
		grafico.setLocation(m);
		grafico.setSize(64,64);
		r=new Rectangle();
		r.setBounds((int)m.getX()+4,(int)m.getY()+4,60,60);
	}
	@Override
	public boolean colisionar(Visitor visitor) {
		// TODO Auto-generated method stub
		return false;
	}

}
