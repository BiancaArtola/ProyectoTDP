package Visitores;

import GUI.G;
import Obstaculos.Obstaculo;
import Tanques.Enemigo;
import Tanques.Jugador;
import Tanques.Tanque;
public class VisitorObstaculoAtravesable extends Visitor {
	//private G gui;
	public boolean VisitarTanque(Tanque t) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean VisitarObstaculo(Obstaculo o) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean visitarJugador(Jugador j) {
		//gui.getContentPane().setComponentZOrder(j.getGrafico(), 0);
		return true;
	}

	@Override
	public boolean visitarEnemigo(Enemigo e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void visitarAguila() {
		// TODO Auto-generated method stub
		
	}

}
