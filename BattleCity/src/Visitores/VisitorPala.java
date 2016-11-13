package Visitores;

import Logica.InteraccionPU;
import Objetos.Aguila;
import Obstaculos.Obstaculo;
import Tanques.Enemigo;
import Tanques.Jugador;
import Tanques.Tanque;

public class VisitorPala extends Visitor {

	protected InteraccionPU i;
	
	public VisitorPala(InteraccionPU interaccion){
		i=interaccion;
	}
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
		i.protegerBase();
		j.aumentarPuntos(500);		
		return true;
	}

	@Override
	public boolean visitarEnemigo(Enemigo e) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void visitarAguila(Aguila aguila) {
		// TODO Auto-generated method stub
		
	}

}
