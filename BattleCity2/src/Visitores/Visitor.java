package Visitores;

import GUI.G;
import Objetos.*;
import Obstaculos.Obstaculo;
import Tanques.Enemigo;
import Tanques.Jugador;
import Tanques.Tanque;

public abstract class Visitor{
	//protected G gui;
	public abstract boolean VisitarTanque(Tanque t);
	
	public abstract boolean VisitarObstaculo(Obstaculo o);
	
	public abstract boolean visitarJugador(Jugador j);
	
	public abstract boolean visitarEnemigo(Enemigo e);
	
	public abstract void visitarAguila();
}