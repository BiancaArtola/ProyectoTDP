package Logica;

import javax.swing.JLabel;

public class ActualizarInfo implements Runnable {

	protected General juego;
	protected JLabel[] labels;
	
	public ActualizarInfo(General j,JLabel p,JLabel v,JLabel i){
		juego=j;
		labels=new JLabel[3];
		labels[0]=p;
		labels[1]=v;
		labels[2]=i;
	}
	
	@Override
	public void run() {

		while (General.corriendo){
			labels[0].setText("Puntaje: "+juego.getScore());
			labels[1].setText("Vidas: "+juego.getJugador().getVidas());
			if (juego.getJugador().getIndetructibles())
				labels[2].setText("Indestructibles: Si");
			else
				labels[2].setText("Indestructibles: No");
			}

	}

}
