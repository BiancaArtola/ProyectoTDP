package Visitores;

import Logica.ContadorTiempo;
import Objetos.Aguila;
import Obstaculos.Obstaculo;
import Tanques.Enemigo;
import Tanques.Jugador;
import Tanques.Tanque;

public class VisitorCasco extends Visitor {

	public VisitorCasco(){
		
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
		j.setIndestructible(true);
		Thread t=new Thread(new ContadorTiempo(5));
		t.start();
		j.setIndestructible(false);
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
