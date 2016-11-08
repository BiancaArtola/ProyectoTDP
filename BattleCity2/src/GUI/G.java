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
/**
 * Clase G, extiende JFrame. 1234
 * @author Artola, Jouglard, Fiore.
 *
 */
public class G extends JFrame {	
	/**
	 * Atributos de la clase G.
	 * contentPane es el panel en el cual esta contenida la imagen del juego
	 * juego de tipo general modela el juego.
	 */
	private General juego;
	private JPanel contentPane;
	private int cantDisparos;
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
	 * Constructor de la clase G
	 */
	public G() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500,1500);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		//Inicializa la variable juego.
		juego=new General();
		//Crea el mapa y le pasa la GUI como parametro.
		juego.crearMapa(this);
		//Crea los enemigos y le pasa la GUI como parametro
		juego.creaEnemigos(this);
		juego.crearPowerUp(this);
		




		
		JLabel dri=new JLabel("Direccion");
		dri.setLocation(1000,100);
		dri.setSize(300,300);
		this.getContentPane().add(dri);
		
		//Crea un JLabel con la imagen del jugador.
		JLabel j=new JLabel(juego.getImagenJugador()[0]);

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent k) {
				if (k.getKeyCode()==KeyEvent.VK_F){
					disparaJugador();
				}
				else{	
				int valor=k.getKeyCode();
				ImageIcon i=cambiarLabel(valor);
				j.setIcon(i);
				j.setLocation(juego.getPuntoJugador());
				}
				dri.setText(String.valueOf(juego.getJugador().getDireccion()));
			}
		});

		j.setSize(64,64);
		j.setLocation(0,0);
		this.getContentPane().add(j);
		this.getContentPane().setComponentZOrder(j,0);	

		



		
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
	/**
	 * Agrega un enemigo al mapa.
	 */
	public void agregarEnemigo(){
		juego.agregarEnemigo(this);
	}

	/**
	 * Elimina un enemigo del mapa.
	 */
	public void eliminarEnemigo(){
		juego.eliminarEnemigo(this);
		this.repaint();

	}
	/**
	 * Elimina un obstraculo aleatorio del mapa.
	 */
	public void destruirObstaculo(){
		Random r=new Random();
		juego.destruirObstaculo(r.nextInt(14),r.nextInt(14));
	}
	
	/**
	 * Metodo que llama a la funcion disparaJugador de Juego cuando se apreta la tecla F.
	 */
	public void disparaJugador(){
		//juego es de tipo general
		juego.disparaJugador(this);
		this.repaint();
	}
}
