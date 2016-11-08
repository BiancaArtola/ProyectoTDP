package Visitores;

import Obstaculos.Obstaculo;
import Tanques.Enemigo;
import Tanques.Jugador;
import Tanques.Tanque;

public class VisitorObstaculoTransitable extends Visitor {



	@Override
	public boolean VisitarTanque(Tanque t) {
		return true;
	}

	@Override
	public boolean VisitarObstaculo(Obstaculo o) {
		return false;
	}

	@Override
	public boolean visitarJugador(Jugador j) {
		return true;
	}

	@Override
	public boolean visitarEnemigo(Enemigo e) {
		return true;

	}

	@Override
	public void visitarAguila() {
		// TODO Auto-generated method stub

	}

}
