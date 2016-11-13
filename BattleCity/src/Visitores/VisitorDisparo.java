package Visitores;

import Objetos.Aguila;
import Obstaculos.Obstaculo;

public abstract class VisitorDisparo extends Visitor{

	public boolean VisitarObstaculo(Obstaculo o){
		return o.recibirDisparo();
	}
	
	public void visitarAguila(Aguila aguila){
		aguila.perder();
	}
}