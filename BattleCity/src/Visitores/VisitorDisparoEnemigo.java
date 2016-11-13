package Visitores;

import Tanques.Enemigo;
import Tanques.Jugador;
import Tanques.Tanque;

/**
 * Clase VisitorDisparoEnemigo, extiende VisitorDisparo.
 * @author Artola, Fiore, Jouglard.
 *
 */
public class VisitorDisparoEnemigo extends VisitorDisparo {

	

	@Override
	public boolean visitarJugador(Jugador j) {
		j.recibirDisparo();
		return true;

	}

	@Override
	public boolean visitarEnemigo(Enemigo e) {
		return false;

	}

	@Override
	public boolean VisitarTanque(Tanque t) {
		return false;
	}

}
