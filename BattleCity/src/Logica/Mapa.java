package Logica;

import java.awt.Container;
import java.awt.Point;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;



import GUI.G;
import Objetos.*;
import Obstaculos.Agua;
import Obstaculos.Bloque;
import Obstaculos.Ladrillo;
import Obstaculos.Obstaculo;
import Obstaculos.Pasto;
import Obstaculos.Vacio;
import PU.PowerUp;
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
	private PositionList<GameObject>[][] tanques;
	private PositionList<Obstaculo> o;
	
	/**
	 * Constructor de la clase Mapa
	 * @param f: archivo
	 * @param g6: la GUI es pasada como parametro
	 */
	public Mapa(FileReader f, G g6){
		o=new DoubleLinkedList<Obstaculo>();

		m=new Obstaculo[14][14];
		tanques=new DoubleLinkedList[14][14];

		for (int i=0;i<14;i++)
			for (int j=0;j<14;j++)
				tanques[i][j]=new DoubleLinkedList<GameObject>();

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
					g6.getContentPane().add(g.getGrafico());
					o.addLast(g);
					break;

				case 'l': //Por cada l que haya en el archivo, se ubicara en la matriz en el lugar correspondiente la imagen Ladrillo
					Point p2=new Point(i*64,j*64);
					Obstaculo g2=new Ladrillo(p2);
					m[i][j]=g2;
					g6.getContentPane().add(g2.getGrafico());
					o.addLast(g2);

					break;

				case 'p'://Por cada p que haya en el archivo, se ubicara en la matriz en el lugar correspondiente la imagen Pasto
					Point p3=new Point(i*64,j*64);
					Obstaculo g3=new Pasto(p3);
					m[i][j]=g3;
					//g6.add(g3.getGrafico());
					g6.getContentPane().add(g3.getGrafico());
					o.addLast(g3);
					break;

				case 'b': //Por cada b que haya en el archivo, se ubicara en la matriz en el lugar correspondiente la imagen Bloque
					Point p4=new Point(i*64,j*64);
					Obstaculo g4=new Bloque(p4);
					m[i][j]=g4;
					//g6.add(g4.getGrafico());
					g6.getContentPane().add(g4.getGrafico());
					o.addLast(g4);
					break;

				case 'a': //Por cada a que haya en el archivo, se ubicara en la matriz en el lugar correspondiente la imagen Agua
					Point p5=new Point(i*64,j*64);
					Obstaculo g5=new Agua(p5);
					m[i][j]=g5;
					//g6.add(g5.getGrafico());
					g6.getContentPane().add(g5.getGrafico());
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
		if (i>=0 && i<14 && j>=0 && j<14)	
			return m[i][j];
		else
			return null;
	}

	/**
	 * Elimina el objeto encontrado en la posicion pasada como parametro.
	 * @param posicion: posicion del objeto a eliminar
	 */
	public void eliminarObs(Point posicion) {
		m[(int)posicion.getX()/64][(int)posicion.getY()/64]=new Vacio(posicion);
	}


	public PositionList<GameObject> getListaSegundaMatriz(int i,int j){
		if (i>=0 && i<14 && j>=0 && j<14)	
			return tanques[i][j];
		else
			return null;
	}

	public void removeTanque(GameObject go,int i, int j) {
		try{
			if (!tanques[i][j].isEmpty()){
				Position<GameObject> p=tanques[i][j].first();
				while (true){
					if (go==p.element())
						tanques[i][j].remove(p);
					else
						if (p==tanques[i][j].last())
							break;
						else	
							p=tanques[i][j].next(p);
				}
			}
		}
		catch(EmptyListException e){
			
		}
		catch(BoundaryViolationException e){
			
		}
		catch(InvalidPositionException e){
			
		}		
	}

	public void protegerBase(G gui) {
		Thread t=new Thread(new ProtegerBase(this,gui));
		t.start();
		/*m[5][13]=new Bloque(m[5][13].getPosicion());
		m[5][12]=new Bloque(m[5][12].getPosicion());
		m[7][13]=new Bloque(m[7][13].getPosicion());
		m[7][12]=new Bloque(m[7][13].getPosicion());
		m[6][12]=new Bloque(m[6][12].getPosicion());*/		
	}

	public void desbloquearBase() {
		m[5][13]=new Ladrillo(m[5][13].getPosicion());
		m[5][12]=new Ladrillo(m[5][12].getPosicion());
		m[7][13]=new Ladrillo(m[7][13].getPosicion());
		m[7][12]=new Ladrillo(m[7][12].getPosicion());
		m[6][12]=new Ladrillo(m[6][12].getPosicion());	
	}

	public void setObstaculo(Obstaculo obs1, int i, int j) {
		m[i][j]=obs1;
		
	}
}