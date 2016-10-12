package Objetos;

public class TanqueBlindado extends Enemigo {


	public TanqueBlindado(int x,int y){
			posicion=new Point(x,y);
	}


	public void mover(int x){
		switch (x) {
		case 0:
			if(posicion.getY()-8>=0)
				posicion.setLocation(posicion.getX(),posicion.getY()-8);
			break;
		case 1:
			if(posicion.getY()+8<=832)
				posicion.setLocation(posicion.getX(),posicion.getY()+8);
			break;
		case 2:
			if(posicion.getX()-8>=0)
				posicion.setLocation(posicion.getX()-8,posicion.getY());
			break;
		case 3:
			if(posicion.getX()+8<=832)
				posicion.setLocation(posicion.getX()+8,posicion.getY());

		default:
			break;
	}

	@Override
	public Disparo disparar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub

	}

}
