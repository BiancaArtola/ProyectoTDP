package Tanques;

import Objetos.Disparo;
import Visitores.*;

public class TanqueRapido extends Enemigo {

	public TanqueRapido(){
		miVisitor=new VisitorObstaculoNoTransitable();
	}
	
	@Override
	public Disparo disparar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mover(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean colisionar(Visitor v) {
		v.visitarEnemigo(this);
		return false;
		
	}

}
