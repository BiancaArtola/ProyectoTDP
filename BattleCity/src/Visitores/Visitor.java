package Visitores;

import Objetos.*;

public abstract class Visitor{

	public abstract void VistarTanque(Tanque t,int x);
	
	public abstract void VisitarObstaculo(Obstaculo o);
	
	public abstract void visitarJugador(Jugador j);
	
	public abstract void visitarEnemigo(Enemigo e);
	
	public abstract void visitarAguila();
}