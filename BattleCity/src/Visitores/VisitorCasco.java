package Visitores;

import Objetos.Enemigo;
import Objetos.Jugador;
import Objetos.Obstaculo;
import Objetos.Tanque;

public class VisitorCasco extends Visitor {

	@Override
	public boolean VisitarTanque(Tanque t) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean VisitarObstaculo(Obstaculo o) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitarJugador(Jugador j) {
		j.setIndestructible(true);
		return true;
	}

	@Override
	public boolean visitarEnemigo(Enemigo e) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void visitarAguila() {
		// TODO Auto-generated method stub

	}

}
