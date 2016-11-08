package Visitores;

import Obstaculos.Obstaculo;
import Tanques.Enemigo;
import Tanques.Jugador;
import Tanques.Tanque;

public class VisitorEstrella extends Visitor {

	@Override
	public boolean VisitarTanque(Tanque t) {
		return true;

	}

	@Override
	public boolean VisitarObstaculo(Obstaculo o) {
		return true;
	}

	@Override
	public boolean visitarJugador(Jugador j) {
		j.subirNivel();
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
