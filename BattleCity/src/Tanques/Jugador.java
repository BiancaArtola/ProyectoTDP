package Tanques;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.GanarYPerder;
import Niveles.Cuatro;
import Niveles.Dos;
import Niveles.Nivel;
import Niveles.Tres;
import Niveles.Uno;
import Objetos.Disparo;
import Objetos.DisparoJugador;
import Visitores.Visitor;
import Visitores.VisitorObstaculoNoTransitable;
import Visitores.VisitorObstaculoTransitable;

public class Jugador extends Tanque {

	
	
	private int cantDestruidos,score,disparossimultaneos,nivel,daire,vidas;
	private Nivel lvl;
	private boolean indestructible;
	private GanarYPerder gyp;
	
	public Jugador(GanarYPerder ganarYPerder){
		indestructible=false;
		gyp=ganarYPerder;
		imagen=new ImageIcon[4];		
		disparos=new Disparo[4];
		cantDestruidos=daire=direccion=0;
		score=0;
		disparossimultaneos=nivel=1;
		//Le asigna el nivel en uno.
		lvl=new Uno(this);
		//Le asigna una posicion al tanque jugador en el mapa.
		posicion=new Point(0,0);
		vidas=1;
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/Images/TanqueNuevo.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/Images/TanqueNuevoAbajo.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/Images/TanqueNuevoIzquierda.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/Images/TanqueNuevoDerecha.png")); 
		//Inicialmente se le coloca la imagen de tanqueNuevo
		grafico=new JLabel();
		grafico.setIcon(imagen[0]);
		grafico.setLocation(posicion);
		grafico.setSize(64,64);
		miVisitor=new VisitorObstaculoNoTransitable();
		r=new Rectangle();
		r.setBounds(4,4,60,60);
	}
	
	
	public void mover(int x){
		lvl.mover(x);
	}
	
	@Override
	
	public DisparoJugador disparar() {		
		if (lvl.getDisparosDisponibles()>0)
			return lvl.disparar();
		else
			return null;
	}


	public boolean colisionar(Visitor visitor) {
		return visitor.visitarJugador(this);
	}

	public void aumentarPuntos(int puntaje) {
		score+=puntaje;
		if (score>=20000)
			vidas++;
	}

	public int getScore() {
		return score;
	}
	
	public int subirNivel(){
		nivel++;
		switch (nivel-1){
			case 1:
				lvl=new Dos(this);
				cargarImagenes(2);
				break;
			case 2:
				lvl=new Tres(this);
				cargarImagenes(3);
				break;
			case 3:
				lvl=new Cuatro(this);
				cargarImagenes(4);
				break;
			default:
				nivel--;
		}
		return nivel;
	}


	private void cargarImagenes(int i) {
		
		switch(i){				
			case 2:
				this.imagen[0] = new ImageIcon(this.getClass().getResource("/Images/TanqueNivel2Arriba.png"));
				this.imagen[1] = new ImageIcon(this.getClass().getResource("/Images/TanqueNivel2Abajo.png"));
				this.imagen[2] = new ImageIcon(this.getClass().getResource("/Images/TanqueNivel2Izquierda.png"));
				this.imagen[3] = new ImageIcon(this.getClass().getResource("/Images/TanqueNivel2Derecha.png"));
				break;
			case 3:
				this.imagen[0] = new ImageIcon(this.getClass().getResource("/Images/TanqueNivel3Arriba.png"));
				this.imagen[1] = new ImageIcon(this.getClass().getResource("/Images/TanqueNivel3Abajo.png"));
				this.imagen[2] = new ImageIcon(this.getClass().getResource("/Images/TanqueNivel3Izquierda.png"));
				this.imagen[3] = new ImageIcon(this.getClass().getResource("/Images/TanqueNivel3Derecha.png"));
				break;
			case 4:
				this.imagen[0] = new ImageIcon(this.getClass().getResource("/Images/TanqueNivel4Arriba.png"));
				this.imagen[1] = new ImageIcon(this.getClass().getResource("/Images/TanqueNivel4Abajo.png"));
				this.imagen[2] = new ImageIcon(this.getClass().getResource("/Images/TanqueNivel4Izquierda.png"));
				this.imagen[3] = new ImageIcon(this.getClass().getResource("/Images/TanqueNivel4Derecha.png"));
				break;
			
		
		}
		
	}


	public void eliminarDisparo(DisparoJugador d) {
		for (int i=0;i<disparos.length;i++)
			if (disparos[i]==d)
				correrDisparo(i);
	}


	private void correrDisparo(int i) {
		for (int j=i;disparos[j+1]!=null;j++)
			disparos[j]=disparos[j+1];		
	}


	public int getCantidadDisparos() {
		return 0;
	}
	
	public void UnaVidaMas(){
		vidas++;
	}
	public void bajarVida(){
		vidas--;
		if (vidas==0)
			gyp.perder();
		lvl=new Uno(this);
	}


	public void setIndestructible(boolean b) {
		indestructible=b;		
	}
	
	public void recibirDisparo(){
		if (!indestructible)
			lvl.recibirDisparo();
	}


	public void moverRectangulo(int i) {
		lvl.moverRectangulo(i);
		
	}


	public int getVelocidad() {
		return lvl.getvelocidad();
	}


	public void chocoDisparo() {
		lvl.setDisparosDisponibles(lvl.getDisparosDisponibles()+1);
	}
	
	public void destruyoEnemigo(){
		cantDestruidos++;
		if (cantDestruidos==16)
			gyp.ganar();
	}


	public void moverRectangulo(int i, int x) {
			Rectangle r=this.getRectangulo();
			
			switch(i){
				case 0:
					r.setLocation((int)r.getLocation().getX(),(int)r.getLocation().getY()-x);
					break;
				case 1:
					r.setLocation((int)r.getLocation().getX(),(int)r.getLocation().getY()+x);
					break;
				case 2:
					r.setLocation((int)r.getLocation().getX()-x,(int)r.getLocation().getY());
					break;
				case 3:
					r.setLocation((int)r.getLocation().getX()+x,(int)r.getLocation().getY());
					break;
			}
	}


	public int getVidas() {
		// TODO Auto-generated method stub
		return vidas;
	}


	public boolean getIndetructibles() {
		// TODO Auto-generated method stub
		return indestructible;
	}
		
	
}
