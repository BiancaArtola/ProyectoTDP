package Tanques;

/**
 * Clase abstracta Enemigo, extiende Tanque.
 * Modela el tanque de los enemigos.
 * @author Artola, Fiore, Jouglard.
 *
 */
public abstract class Enemigo extends Tanque {
	/**
	 * Atributos de la clase abstracta Enemigo
	 */
	protected int puntaje;
	protected int velocidadMov,velocidadDis;
	protected int resistencia;
	
	/**
	 * Metodo para obtener el puntaje del enemigo.
	 * @return int: puntaje del enemigo.
	 */
	public int getPuntaje() {
		return puntaje;
	}

	public void moverRectangulo(int x){
			switch(x){
				case 0:
					r.setLocation((int)r.getLocation().getX(),(int)r.getLocation().getY()-velocidadMov);
					break;
				case 1:
					r.setLocation((int)r.getLocation().getX(),(int)r.getLocation().getY()+velocidadMov);
					break;
				case 2:
					r.setLocation((int)r.getLocation().getX()-velocidadMov,(int)r.getLocation().getY());
					break;
				case 3:
					r.setLocation((int)r.getLocation().getX()+velocidadMov,(int)r.getLocation().getY());
					break;
			
			}
	}

}
	

