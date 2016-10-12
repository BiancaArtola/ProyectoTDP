


public class VisitorDisparoJugador extends VisitorDisparo{


	@Override
	public void VistarTanque(Tanque t, int x) {

	}

	@Override
	public void visitarJugador(Jugador j) {

	}

	@Override
	public void visitarEnemigo(Enemigo e) {
		e.destruir();
	}

	@Override
	public void visitarAguila() {

	}

}
}