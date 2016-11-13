package PU;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.InteraccionPU;
import Visitores.*;
public class Granada extends PowerUp {
	
	public Granada(Point m, InteraccionPU interaccion){
		//miVisitor = visitor
		miVisitor = new VisitorGranada(interaccion);
		imagen= new ImageIcon[1];
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/Images/granada.png"));
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
