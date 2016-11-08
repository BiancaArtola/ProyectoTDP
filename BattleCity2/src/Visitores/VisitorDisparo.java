package Visitores;

import Obstaculos.Obstaculo;

public abstract class VisitorDisparo extends Visitor{

	public boolean VisitarObstaculo(Obstaculo o){
		return o.recibirDisparo();
	}
	
}