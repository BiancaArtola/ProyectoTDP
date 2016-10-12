package Visitores;

import Objetos.Enemigo;
import Objetos.Jugador;
import Objetos.Obstaculo;
import Objetos.Tanque;

public class VisitorObstaculoTransitable extends Visitor {



	@Override
	public boolean VisitarTanque(Tanque t) {
		return true;

	}

	@Override
	public void VisitarObstaculo(Obstaculo o) {

	}

	@Override
	public void visitarJugador(Jugador j) {

	}

	@Override
	public void visitarEnemigo(Enemigo e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitarAguila() {
		// TODO Auto-generated method stub

	}

}
