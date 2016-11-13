package Visitores;
import Objetos.*;
import Tanques.Enemigo;
import Tanques.Jugador;
import Tanques.Tanque;

public class VisitorDisparoJugador extends VisitorDisparo{

	public boolean VisitarTanque(Tanque t) {
		return true;
	}

	@Override
	public boolean visitarJugador(Jugador j) {
		return false;
	}

	@Override
	public boolean visitarEnemigo(Enemigo e) {
		e.recibirDisparo();
		return true;
	}

}
