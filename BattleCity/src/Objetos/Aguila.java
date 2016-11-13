package Objetos;

import Logica.GanarYPerder;
import Visitores.Visitor;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.*;

public class Aguila extends GameObject {

	protected GanarYPerder gyp;
	
	public Aguila(GanarYPerder g){
		gyp=g;
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/Images/aguila.png")));
		r=new Rectangle();
		r.setBounds(6*64,13*64,64,64);
		posicion=new Point(6*64,13*64);
		grafico.setLocation(posicion);
		grafico.setSize(64,64);
	}
	
	
	@Override
	public boolean colisionar(Visitor visitor) {
		visitor.visitarAguila(this);
		return false;
	}

	@Override
	public void moverRectangulo(int x) {
		

	}
	
	public void perder(){
		gyp.perder();
	}

}
