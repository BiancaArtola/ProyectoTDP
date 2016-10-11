package Objetos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class GameObject {

	
	protected Point posicion;
	protected ImageIcon[] imagen;
	protected JLabel grafico;
	
	public Point getPosicion(){
		return posicion;
	}
	
	public ImageIcon[] getImagen(){
		return imagen;
	}
	
	public abstract void colisionar();
	
	public JLabel getGrafico()
	{
		return grafico;
	}
}
