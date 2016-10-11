package Visitores;

import Objetos.Obstaculo;

public abstract class VisitorDisparo extends Visitor{

	public void VisitarObstaculo(Obstaculo o){
		o.destruir();
	}
	
}