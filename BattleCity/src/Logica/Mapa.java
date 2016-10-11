package Logica;

import java.awt.Container;
import java.awt.Point;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;



import GUI.G;
import Objetos.*;
import TDALista.*;

public class Mapa {

	private Obstaculo[][] m;
	private [][] tanques;
	private PowerUp[] pu;
	private PositionList<Obstaculo> o;
	
	public Mapa(FileReader f, G g6){
		m=new Obstaculo[50][50];
		pu=new PowerUp[4];
		o=new DoubleLinkedList<Obstaculo>();
		
		
			try{BufferedReader file=new BufferedReader(f);
			String linea= file.readLine();
			
			
			for(int j=0;linea!=null; j++){
				for(int i=0; i<linea.length(); i++){
					char crt= linea.charAt(i);
						switch(crt){
						
							case '0':
								Point p=new Point(i*64,j*64);
								Obstaculo g=new Vacio(p);
								m[i][j]=g;
								g6.add(g.getGrafico());
								o.addLast(g);
								break;
								
							case 'l':
								//ImageIcon img2=new ImageIcon(this.getClass().getResource("/Images/Battle_City_bricks.png"));
								Point p2=new Point(i*64,j*64);
								Obstaculo g2=new Ladrillo(p2);
								m[i][j]=g2;
								//JLabel obs2=new JLabel(img2);
								g6.add(g2.getGrafico());
								o.addLast(g2);
								break;
								
							case 'p':
								Point p3=new Point(i*64,j*64);
								Obstaculo g3=new Pasto(p3);
								m[i][j]=g3;
								g6.add(g3.getGrafico());
								o.addLast(g3);
								break;
								
							case 'b':
								Point p4=new Point(i*64,j*64);
								Obstaculo g4=new Bloque(p4);
								m[i][j]=g4;
								g6.add(g4.getGrafico());
								o.addLast(g4);
								break;
								
							case 'a':
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
	
	
	public Obstaculo getObjetoEn(int i,int j){
		return m[i][j];
	}


	public void eliminar(Point posicion) {
				
	}


	public void moverDePunto(Point posicion, int x, int y) {
		
		GameObject aux=tanques[(int)posicion.getX()%64][(int)posicion.getY()%64];
		tanques[(int)posicion.getX()%64][(int)posicion.getY()%64]=tanques[x][y];
		tanques[x][y]=aux;
		
	}
	
}