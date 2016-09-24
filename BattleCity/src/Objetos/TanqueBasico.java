package Objetos;

import javax.swing.ImageIcon;

public class TanqueBasico extends Enemigo {

	
	public TanqueBasico(){
		imagen=new ImageIcon[4];
		imagen[0]=new ImageIcon(this.getClass().getResource("/Images/Battle_City_Tank_Enemy1.png"));
	}
	
	@Override
	public Disparo disparar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub

	}

}
