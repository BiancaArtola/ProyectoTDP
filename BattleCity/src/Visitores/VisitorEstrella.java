package Visitores;

import Objetos.Aguila;
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
		j.aumentarPuntos(500);
		return true;

	}

	@Override
	public boolean visitarEnemigo(Enemigo e) {
		return true;

	}

	@Override
	public void visitarAguila(Aguila aguila) {
		// TODO Auto-generated method stub
		
	}

}
