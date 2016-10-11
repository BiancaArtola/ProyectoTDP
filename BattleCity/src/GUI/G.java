package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.*;

import Logica.General;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class G extends JFrame {

	
	private General juego;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					G frame = new G();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public G() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500,1500);
		juego=new General();
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		juego.crearMapa(this);
		
		juego.creaEnemigos();
		
		JLabel puntaje=new JLabel("Puntaje");
		puntaje.setLocation(1000,700);
		puntaje.setSize(100,100);
		this.add(puntaje);
		
		JButton agregarEnemigo=new JButton("Agregar enemigo");
		JButton eliminoEnemigo=new JButton("Elimino enemigo");
		JButton eliminarObstaculo=new JButton("Eliminar obstaculo");
		
		agregarEnemigo.setFocusable(false);
		eliminoEnemigo.setFocusable(false);
		eliminarObstaculo.setFocusable(false);
		
		agregarEnemigo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				agregarEnemigo();
			}
		});
		
		eliminoEnemigo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				eliminarEnemigo();
				puntaje.setText("Puntaje: "+juego.getScore());
			}
			
		});
		
		eliminarObstaculo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				destruirObstaculo();
			}
		});
		
		agregarEnemigo.setSize(150,40);
		agregarEnemigo.setLocation(1000, 400);
		this.getContentPane().add(agregarEnemigo);
		
		eliminoEnemigo.setSize(150,40);
		eliminoEnemigo.setLocation(1000, 500);
		this.getContentPane().add(eliminoEnemigo);
		
		eliminarObstaculo.setSize(150,40);
		eliminarObstaculo.setLocation(1000,600);
		this.getContentPane().add(eliminarObstaculo);
		
		
		JLabel j=new JLabel(juego.getImagenJugador()[0]);
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent k) {
				int valor=k.getKeyCode();
				ImageIcon i=cambiarLabel(valor);
				j.setIcon(i);
				j.setLocation(juego.getPuntoJugador());
			}
		});
		
		j.setSize(64,64);
		j.setLocation(0,0);
		this.getContentPane().add(j);
		this.getContentPane().setComponentZOrder(j,0);	
		
		JButton nivel=new JButton("Subir de nivel");
		nivel.setLocation(1000,800);
		nivel.setSize(150,40);
		nivel.setFocusable(false);
		this.getContentPane().add(nivel);
		

		JLabel lvl=new JLabel("Nivel:");
		lvl.setSize(150,40);
		lvl.setLocation(1000,900);
		this.getContentPane().add(lvl);
		
		
		nivel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int l=juego.subirNivel();
				lvl.setText("Nivel: "+l);
			}
		});
		
		
	}
	
	/**
	 * Mueve al jugador segun la tecla presionada
	 * @param v Codigo de la tecla presionada
	 * @return La imagen del jugador apuntando en la direccion nueva
	 */
	private ImageIcon cambiarLabel(int v){
		ImageIcon i=juego.moverJugador(v);
		this.repaint();
		return i;
		
	}
	
	public void agregarEnemigo(){
		juego.agregarEnemigo(this);
	}
	
	public void eliminarEnemigo(){
		juego.eliminarEnemigo(this);
		this.repaint();
		
	}
	
	public void destruirObstaculo(){
		Random r=new Random();
		juego.destruirObstaculo(r.nextInt(14),r.nextInt(14));
	}
}
