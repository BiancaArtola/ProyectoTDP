package Logica;

import java.awt.Container;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

import GUI.G;
import Objetos.*;

public class Mapa {

	private Punto[][] m;
	private PowerUp[] pu;
	private Obstaculo[] o;
	
	public Mapa(FileReader f, G container){
			try{BufferedReader file=new BufferedReader(f);
			String linea;
			for(int j=0; j<14; j++){
				linea= file.readLine();
				for(int i=0; i<14; i++){
					char crt= linea.charAt(i);
						switch(crt){
							case '0':
								container.add(new JLabel(new ImageIcon(this.getClass().getResource("/Images/vacio.png"))));
								break;
							case 'l':
								container.add(new JLabel(new ImageIcon(this.getClass().getResource("/Images/Battle_City_bricks.png"))));
								break;
							case 'p':
								container.add(new JLabel(new ImageIcon(this.getClass().getResource("/Images/Battle_City_trees.png"))));
								break;
							case 'b':
								container.add(new JLabel(new ImageIcon(this.getClass().getResource("/Images/Battle_City_wall.png"))));
								break;
							case 'a':
								container.add(new JLabel(new ImageIcon(this.getClass().getResource("/Images/Battle_City_water.png"))));
								break;
						}
				}
			}
			file.close();
			}
			catch (IOException e){}

	}
	
	
}
