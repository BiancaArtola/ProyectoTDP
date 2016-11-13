package Logica;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.G;
import Objetos.GameObject;
import Obstaculos.Bloque;
import Obstaculos.Ladrillo;
import Obstaculos.Obstaculo;

public class ProtegerBase implements Runnable{
	private Mapa m;
	private G g;
	
	public ProtegerBase(Mapa mapa, G gui){
		m= mapa;
		g= gui;		
	}
	
	public void run(){
		Point p1= new Point(320,832);
		Point p2= new Point(320,768);
		Point p3= new Point(384,768);
		Point p4= new Point(448,768);
		Point p5= new Point(448,832);
		Obstaculo obs1=new Bloque(p1);
		Obstaculo obs2=new Bloque(p2);
		Obstaculo obs3=new Bloque(p3);
		Obstaculo obs4=new Bloque(p4);
		Obstaculo obs5=new Bloque(p5);
		g.getContentPane().remove(m.getObjetoEn(5, 13).getGrafico());
		g.getContentPane().remove(m.getObjetoEn(5, 12).getGrafico());
		g.getContentPane().remove(m.getObjetoEn(6, 12).getGrafico());
		g.getContentPane().remove(m.getObjetoEn(7, 12).getGrafico());
		g.getContentPane().remove(m.getObjetoEn(7, 13).getGrafico());
		g.repaint();
		g.getContentPane().add(obs1.getGrafico());
		g.getContentPane().add(obs2.getGrafico());
		g.getContentPane().add(obs3.getGrafico());
		g.getContentPane().add(obs4.getGrafico());
		g.getContentPane().add(obs5.getGrafico());
		m.setObstaculo(obs1, 5, 13);
		m.setObstaculo(obs2, 5, 12);
		m.setObstaculo(obs3, 6, 12);
		m.setObstaculo(obs4, 7, 12);
		m.setObstaculo(obs5, 7, 13);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		obs1=new Ladrillo(p1);
		obs2=new Ladrillo(p2);
		obs3=new Ladrillo(p3);
		obs4=new Ladrillo(p4);
		obs5=new Ladrillo(p5);
		g.getContentPane().remove(m.getObjetoEn(5, 13).getGrafico());
		g.getContentPane().remove(m.getObjetoEn(5, 12).getGrafico());
		g.getContentPane().remove(m.getObjetoEn(6, 12).getGrafico());
		g.getContentPane().remove(m.getObjetoEn(7, 12).getGrafico());
		g.getContentPane().remove(m.getObjetoEn(7, 13).getGrafico());
		g.repaint();
		g.getContentPane().add(obs1.getGrafico());
		g.getContentPane().add(obs2.getGrafico());
		g.getContentPane().add(obs3.getGrafico());
		g.getContentPane().add(obs4.getGrafico());
		g.getContentPane().add(obs5.getGrafico());
		m.setObstaculo(obs1, 5, 13);
		m.setObstaculo(obs2, 5, 12);
		m.setObstaculo(obs3, 6, 12);
		m.setObstaculo(obs4, 7, 12);
		m.setObstaculo(obs5, 7, 13);
		g.repaint();
	}
}
