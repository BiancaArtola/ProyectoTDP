package Visitores;

import Objetos.*;

public abstract class Visitor{

	public abstract boolean VisitarTanque(Tanque t);
	
	public abstract boolean VisitarObstaculo(Obstaculo o);
	
	public abstract boolean visitarJugador(Jugador j);
	
	public abstract boolean visitarEnemigo(Enemigo e);
	
	public abstract void visitarAguila();
}