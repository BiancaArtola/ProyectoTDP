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

	private GameObject[][] m;
	private PowerUp[] pu;
	private PositionList<GameObject> o;
	
	public Mapa(FileReader f, G g6){
		m=new GameObject[50][50];
		pu=new PowerUp[4];
		o=new DoubleLinkedList<GameObject>();
		
		
			try{BufferedReader file=new BufferedReader(f);
			String linea= file.readLine();
			
			
			for(int j=0;linea!=null; j++){
				for(int i=0; i<linea.length(); i++){
					char crt= linea.charAt(i);
						switch(crt){
						
							case '0':
								ImageIcon img=new ImageIcon(this.getClass().getResource("/Images/vacio.png"));
								Point p=new Point(i*64,j*64);
								GameObject g=new Vacio(p,img);
								m[i][j]=g;
								JLabel obs=new JLabel(img);
								g6.add(obs);
								obs.setLocation(p);
								obs.setSize(64,64);
								o.addLast(g);
								break;
								
							case 'l':
								ImageIcon img2=new ImageIcon(this.getClass().getResource("/Images/Battle_City_bricks.png"));
								Point p2=new Point(i*64,j*64);
								GameObject g2=new Ladrillo(p2,img2);
								m[i][j]=g2;
								JLabel obs2=new JLabel(img2);
								g6.add(obs2);
								obs2.setLocation(p2);
								obs2.setSize(64,64);
								o.addLast(g2);
								break;
								
							case 'p':
								ImageIcon img3=new ImageIcon(this.getClass().getResource("/Images/Battle_City_trees.png"));
								Point p3=new Point(i*64,j*64);
								GameObject g3=new Pasto(p3,img3);
								m[i][j]=g3;
								JLabel obs3=new JLabel(img3);
								g6.add(obs3);
								obs3.setLocation(p3);
								obs3.setSize(64,64);
								o.addLast(g3);
								break;
								
							case 'b':
								ImageIcon img4=new ImageIcon(this.getClass().getResource("/Images/Battle_City_wall.png"));
								Point p4=new Point(i*64,j*64);
								GameObject g4=new Bloque(p4,img4);
								m[i][j]=g4;
								JLabel obs4=new JLabel(img4);
								g6.add(obs4);
								obs4.setLocation(p4);
								obs4.setSize(64,64);
								o.addLast(g4);
								break;
								
							case 'a':
								ImageIcon img5=new ImageIcon(this.getClass().getResource("/Images/Battle_City_water.png"));
								Point p5=new Point(i*64,j*64);
								GameObject g5=new Agua(p5,img5);
								m[i][j]=g5;
								JLabel obs5=new JLabel(img5);
								g6.add(obs5);
								obs5.setLocation(p5);
								obs5.setSize(64,64);
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
	
	
	public GameObject getObjetoEn(int i,int j){
		return m[i][j];
	}
	
}