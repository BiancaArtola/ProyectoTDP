package Visitores;
import Objetos.*;

public class VisitorDisparoJugador extends VisitorDisparo{

	public boolean VisitarTanque(Tanque t) {
		return false;
	}

	@Override
	public boolean visitarJugador(Jugador j) {
		return false;
	}

	@Override
	public boolean visitarEnemigo(Enemigo e) {
		e.destruir();
		return true;
	}

	@Override
	public void visitarAguila() {

	}

}
