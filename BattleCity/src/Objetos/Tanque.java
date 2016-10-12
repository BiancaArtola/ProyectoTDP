package Objetos;
import javax.swing.ImageIcon;

/**
 * Clase Tanque, extiende GameObject.
 * Es la clase que modela el tanque del jugador.
 * @author Artola, Fiore, Jouglard.
 *
 */
public abstract class Tanque extends GameObject{
	/**
	 * Atributos de la clase Tanque.
	 */
	protected int resistencia;
	protected int golpesrecibidos;
	protected int velocidadmovimiento, velocidaddisparo;
	
	/**
	 * Metodo abstracto disparar.
	 * @return Disparo
	 */
	public abstract Disparo disparar();
	
	/**
	 * Mueve el 
	 * @param x
	 */
	public abstract void mover(int x);
	
	public void destruir(){
		grafico.setIcon();
	}
	

	public ImageIcon actualizarImagen(int x){
		return imagen[x];
	}
}
