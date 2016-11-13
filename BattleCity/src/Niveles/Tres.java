
package Niveles;

import java.awt.Point;

import Objetos.DisparoJugador;
import Tanques.Jugador;

public class Tres extends Nivel {

	
	public Tres(Jugador j){
		p=j;
		velocidadMov=8;
		velocidadDis=16;
		disDisponibles=2;
		resistencia=2;
	}
}
