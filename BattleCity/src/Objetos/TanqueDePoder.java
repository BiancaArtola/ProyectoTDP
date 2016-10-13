package Objetos;

import Visitores.*;

public class TanqueDePoder extends Enemigo {

	public TanqueDePoder(){
		miVisitor=new VisitorObstaculoNoTransitable();
	}
	
	@Override
	public Disparo disparar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean colisionar(Visitor visitor) {
		return visitor.visitarEnemigo(this);

	}

	@Override
	public void mover(int x) {
		// TODO Auto-generated method stub
		
	}

}
