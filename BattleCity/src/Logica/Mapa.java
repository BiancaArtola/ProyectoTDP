package Logica;

import java.awt.Container;
import java.awt.Point;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;



import GUI.G;
import Objetos.*;
import TDALista.*;
/**
 * Clase mapa.
 * @author Artola, Jouglard, Fiore.
 *
 */
public class Mapa {
	/**
	 * Atributos de la clase Mapa
	 */
	private Obstaculo[][] m;
	private GameObject[][] tanques;
	private PowerUp[] pu;
	private PositionList<Obstaculo> o;
	
	/**
	 * Constructor de la clase Mapa
	 * @param f: archivo
	 * @param g6: la GUI es pasada como parametro
	 */
	public Mapa(FileReader f, G g6){
		pu=new PowerUp[4];
		o=new DoubleLinkedList<Obstaculo>();
		
		m=new Obstaculo[14][14];
		tanques=new GameObject[14][14];

		try{BufferedReader file=new BufferedReader(f);
		String linea= file.readLine();
		int i=0,j=0;
		for(j=0;linea!=null; j++){
			for(i=0; i<linea.length(); i++){
				char crt= linea.charAt(i);
				switch(crt){

				case '0': //Por cada 0 que haya en el archivo, se ubicara en la matriz en el lugar correspondiente la imagen Vacio
					Point p=new Point(i*64,j*64);
					Obstaculo g=new Vacio(p);
					m[i][j]=g;
					g6.add(g.getGrafico());
					o.addLast(g);
					break;

				case 'l': //Por cada l que haya en el archivo, se ubicara en la matriz en el lugar correspondiente la imagen Ladrillo
					//ImageIcon img2=new ImageIcon(this.getClass().getResource("/Images/Battle_City_bricks.png"));
					Point p2=new Point(i*64,j*64);
					Obstaculo g2=new Ladrillo(p2);
					m[i][j]=g2;
					//JLabel obs2=new JLabel(img2);
					g6.add(g2.getGrafico());
					o.addLast(g2);

					break;

				case 'p'://Por cada p que haya en el archivo, se ubicara en la matriz en el lugar correspondiente la imagen Pasto
					Point p3=new Point(i*64,j*64);
					Obstaculo g3=new Pasto(p3);
					m[i][j]=g3;
					g6.add(g3.getGrafico());
					o.addLast(g3);
					break;

				case 'b': //Por cada b que haya en el archivo, se ubicara en la matriz en el lugar correspondiente la imagen Bloque
					Point p4=new Point(i*64,j*64);
					Obstaculo g4=new Bloque(p4);
					m[i][j]=g4;
					g6.add(g4.getGrafico());
					o.addLast(g4);
					break;

				case 'a': //Por cada a que haya en el archivo, se ubicara en la matriz en el lugar correspondiente la imagen Agua
					Point p5=new Point(i*64,j*64);
					Obstaculo g5=new Agua(p5);
					m[i][j]=g5;
					g6.add(g5.getGrafico());
					o.addLast(g5);
					break;
				}				
			}
			linea=file.readLine();
		}


		

		file.close();
		}
		catch (IOException e){}

	}

	/**
	 * Retorna el objeto ubicado en la posicion (i, j)
	 * @param i: posicion X de la matriz m
	 * @param j: posicion Y de la matriz m
	 * @return objeto encontrado en la pos pasada como parametro.
	 */
	public Obstaculo getObjetoEn(int i,int j){
			return m[i][j];
	}

	/**
	 * Elimina el objeto encontrado en la posicion pasada como parametro.
	 * @param posicion: posicion del objeto a eliminar
	 */
	public void eliminarObs(Point posicion) {
		m[(int)posicion.getX()/64][(int)posicion.getY()/64]=new Vacio(posicion);
	}

	/**
	 * 
	 * @param posicion
	 * @param x
	 * @param y
	 */
	public void moverDePunto(Point posicion, int x, int y) {
		GameObject aux= tanques[(int)posicion.getX()/64][(int)posicion.getY()/64];
		tanques[(int)posicion.getX()/64][(int)posicion.getY()/64]=tanques[x][y];
		tanques[x][y]=aux;
	}

}