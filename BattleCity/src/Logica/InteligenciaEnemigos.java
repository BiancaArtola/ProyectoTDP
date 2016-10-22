package Logica;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.G;
import Objetos.Tanque;
import Objetos.GameObject;
import Objetos.Obstaculo;
import Visitores.*;

/**
 * Clase InteligenciaEnemigos que implementa Runnable.
 * @author Artola, Fiore, Jouglard
 *
 */
public class InteligenciaEnemigos implements Runnable{
	/**
	 * Atributos de la clase InteligenciaEnemigos
	 */
	protected Tanque[] tanques;
	protected Mapa mapa;
	protected G gui;
	/**
	 * Constructor de la clase InteligenciaEnemigos
	 * @param gui 
	 * @param malos: arreglo de tipo Enemigos. Contiene los enemigos del mapa
	 * @param m: Mapa
	 */
	public InteligenciaEnemigos(Tanque[] malos,Mapa m, G gui){
		tanques=malos;
		mapa=m;
		this.gui=gui;
	}

	/**
	 * Metodo run
	 */
	public void run(){
		Random r=new Random();
		int x,y;
		JLabel j=new JLabel("Vacio");
		j.setSize(100,50);
		j.setLocation(1000,300);
		gui.getContentPane().add(j);
		JLabel j2=new JLabel("Vacio");
		j2.setSize(100,50);
		j2.setLocation(1500,100);
		gui.getContentPane().add(j2);
		boolean puede=true;
		Obstaculo go=null;
		ImageIcon i=null;
		
		//Inicializar enemigo	
		while(true){
			//for (int j=0;j<1;j++){
				int mov=r.nextInt(4);
				j.setText(String.valueOf(mov));
				for (int z=0;z<4;z++){
					j2.setText(String.valueOf(tanques[0].getPosicion().getX()/64+" "+String.valueOf(tanques[0].getPosicion().getY()/64)));
					switch(mov){
						case 0:
							if (tanques[0].getPosicion().getY()/64>0){
								go=mapa.getObjetoEn(((int)tanques[0].getPosicion().getX()/64),((int)tanques[0].getPosicion().getY()/64)-1);
								puede= tanques[0].colisionar(go.getVisitor());}
							if (puede){
								//j2.setText("0");
								tanques[0].mover(0);
								gui.repaint();
								//mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
							}
							else
								mov=r.nextInt(4);
							break;
						case 1:
							if (tanques[0].getPosicion().getY()/64<13){
								go=mapa.getObjetoEn(((int)tanques[0].getPosicion().getX()/64),((int)tanques[0].getPosicion().getY()/64)+1);
								puede= tanques[0].colisionar(go.getVisitor());}
							if (puede){
								//j2.setText("1");
								tanques[0].mover(1);
								gui.repaint();
								//mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
							}
							else
								mov=r.nextInt(4);
							break;
						case 2:
							if (tanques[0].getPosicion().getX()/64>0){
								go=mapa.getObjetoEn(((int)tanques[0].getPosicion().getX()/64)-1,((int)tanques[0].getPosicion().getY()/64));
								puede= tanques[0].colisionar(go.getVisitor());}
							if (puede){
								//j2.setText("2");
								tanques[0].mover(2);
								gui.repaint();
								//mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
							}
							else
								mov=r.nextInt(4);
							break;
						case 3:
							if (tanques[0].getPosicion().getX()/64<13){
								go=mapa.getObjetoEn(((int)tanques[0].getPosicion().getX()/64)+1,((int)tanques[0].getPosicion().getY()/64));
								puede= tanques[0].colisionar(go.getVisitor());}
							if (puede){
								int w=0;
								//j2.setText(String.valueOf(w++));
								tanques[0].mover(3);
								gui.repaint();
								//mapa.moverDePunto(tanques[j].getPosicion(),(int)tanques[j].getPosicion().getX(),(int)tanques[j].getPosicion().getY());
							}
							else
								mov=r.nextInt(4);
							
							break;
							
							
					}
					j2.setText(String.valueOf(tanques[0].getPosicion().getX()/64+" "+String.valueOf(tanques[0].getPosicion().getY()/64)));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
		}
			

			
		}
		


	}
}

