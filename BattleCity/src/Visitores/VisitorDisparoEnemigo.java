package Visitores;

import Objetos.Enemigo;
import Objetos.Jugador;
import Objetos.Tanque;

/**
 * Clase VisitorDisparoEnemigo, extiende VisitorDisparo.
 * @author Artola, Fiore, Jouglard.
 *
 */
public class VisitorDisparoEnemigo extends VisitorDisparo {

	

	@Override
	public boolean visitarJugador(Jugador j) {
		j.destruir();
		return false;

	}

	@Override
	public boolean visitarEnemigo(Enemigo e) {
		return false;

	}

	@Override
	public void visitarAguila() {

	}

	@Override
	public boolean VisitarTanque(Tanque t) {
		return false;
	}

}
