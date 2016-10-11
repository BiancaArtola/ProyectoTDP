package Objetos;

import Visitores.*;

public abstract class Disparo extends GameObject {

	protected VisitorDisparo miVisitor;


	@Override
	public void colisionar() {
		
	}

	public Visitor getVisitor(){
		return miVisitor;
	}

}
