package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Models.ListaOrdenada;
import Models.Listas;
import Models.ListasPokemon;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pokedex {

	private JFrame frame;
	private JTextField txtComentarios;
	private JTextField txtNombre;
	private JTextField txtNumero;
	private JTextField txtNivel;
	private JTextField txtRegion;
	private JLabel lblPokedex;
	private JLabel lblNombre ;
	private JLabel lblNumero;
	private JLabel lblNivelDeEvolucion ;
	private JLabel lblRegion ;
	private JLabel lblTipo;
	private JLabel lblComentarios;
	private JList listTipo;
	private JComboBox comboBox ;
	private JButton btnInsertarnuevo;
	private JButton btnBuscar;
	private JButton btnAtras ;
	private JButton btnDelante;
	private JLabel lblNumList;
	//Variables Almacenar Nombres,Numero,etc...
	private String Nombre;
	private String Numero;
	private String Nivel;
	private String Region;
	private String Tipo;
	private String Comentarios;
	
	private int indicePokemon;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pokedex window = new Pokedex();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pokedex() {
		initialize();
		setContents();
		setEventos();
	}

	//Inicio de Contenidos del Frame
	 
	private void initialize() {
		frame = new JFrame();
		
		lblPokedex = new JLabel("POKEDEX");
		lblNombre = new JLabel("Nombre");
		lblNumero = new JLabel("Numero");
		lblNivelDeEvolucion = new JLabel("Nivel de Evolucion");
		lblRegion = new JLabel("Region");
		lblTipo = new JLabel("Tipo");
		lblComentarios = new JLabel("Comentarios");
		txtComentarios = new JTextField();
		listTipo = new JList();
		txtNombre = new JTextField();
		txtNumero = new JTextField();
		txtNivel = new JTextField();
		txtRegion = new JTextField();
		comboBox = new JComboBox();
		btnInsertarnuevo = new JButton("Insertar Nuevo Pokemon");
		
		btnBuscar = new JButton("Buscar Pokemon");
	
		btnAtras = new JButton("<");
	
		btnDelante = new JButton(">");
		lblNumList = new JLabel("0/0");
		ModoLeer();
	}
	
	//Contenidos (tamaño,posicionamiento,etc...)
	
	private void setContents(){
		
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 606, 338);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblPokedex.setFont(new Font("Trebuchet MS", Font.PLAIN, 26));
		lblPokedex.setBounds(223, 11, 143, 43);
		frame.getContentPane().add(lblPokedex);
		
		lblNombre.setBounds(28, 70, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		lblNumero.setBounds(28, 112, 46, 14);
		frame.getContentPane().add(lblNumero);

		lblNivelDeEvolucion.setBounds(28, 153, 105, 14);
		frame.getContentPane().add(lblNivelDeEvolucion);

		lblRegion.setBounds(28, 192, 46, 14);
		frame.getContentPane().add(lblRegion);

		lblTipo.setBounds(307, 65, 46, 14);
		frame.getContentPane().add(lblTipo);

		lblComentarios.setBounds(246, 128, 77, 14);
		frame.getContentPane().add(lblComentarios);
		
		listTipo.setBounds(365, 69, 1, 1);
		frame.getContentPane().add(listTipo);

		txtComentarios.setBounds(335, 128, 143, 91);
		frame.getContentPane().add(txtComentarios);
		txtComentarios.setColumns(10);

		txtNombre.setBounds(83, 67, 86, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		txtNivel.setColumns(10);
		txtNivel.setBounds(142, 150, 86, 20);
		frame.getContentPane().add(txtNivel);
		
		txtRegion.setColumns(10);
		txtRegion.setBounds(142, 189, 86, 20);
		frame.getContentPane().add(txtRegion);

		txtNumero.setColumns(10);
		txtNumero.setBounds(83, 109, 86, 20);
		frame.getContentPane().add(txtNumero);


		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tierra", "Aire", "Fuego", "Agua"}));
		comboBox.setBounds(346, 65, 132, 20);
		frame.getContentPane().add(comboBox);

		btnInsertarnuevo.setBounds(80, 239, 184, 50);
		frame.getContentPane().add(btnInsertarnuevo);

		btnBuscar.setBounds(330, 239, 184, 50);
		frame.getContentPane().add(btnBuscar);

		btnDelante.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelante.setToolTipText("");
		btnDelante.setBounds(491, 11, 89, 23);
		frame.getContentPane().add(btnDelante);
		
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtras.setToolTipText("");
		btnAtras.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnAtras);

		lblNumList.setForeground(Color.BLUE);
		lblNumList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumList.setBounds(412, 11, 33, 17);
		frame.getContentPane().add(lblNumList);
		
	}
	//Eventos para botones, listas,etc...
	
	private void setEventos(){
		
		//Boton Atras accion recorre el indice
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				prevPokemon();
			}
		});
		
		//Boton Delante accion recorre el indice
		btnDelante.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				nextPokemon();
			}
		});
		//Insertar Valor
		btnInsertarnuevo.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				ModoInsertar();
				//Guardamos valores en Strings
				String Nombre=txtNombre.getText();
				String Numero=txtNumero.getText();
				String Nivel=txtNivel.getText();
				String Region=txtRegion.getText();
				String Tipo=comboBox.getToolTipText();
				String Comentarios=txtComentarios.getText();
				
				if (!Nombre.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Pokemon ya está en la BBDD",
							"Pokemon registrado en la BBDD",JOptionPane.INFORMATION_MESSAGE );
					
					// Recorremos Clase ListasPokemon
					for (ListasPokemon Pok : Contenedor.Contenedor.LPokemon ) {
						if (Pok.getNombre().equals(Nombre)) {
							JOptionPane.showMessageDialog(frame,
									"El Pokemon " + Nombre + " ya esta en la Lista.",
									"[Error] Pokemon Existente", JOptionPane.ERROR_MESSAGE);
							break;
							
			}
			}
					//Guardamos los valores en un Auxiliar para despues añadirlo al contenedor de LPokemon(ListaPokemon) 
					ListasPokemon Auxiliar = new ListasPokemon(Nombre, Numero,Nivel,Region,Tipo,Comentarios);
					Contenedor.Contenedor.LPokemon .add(Auxiliar);
			}
			}
		});
		//Botton Buscar
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ModoBuscar();
				
				
				String Numero = txtNumero.getText();
				if (!Numero.isEmpty()) {
					for (ListasPokemon Po : Contenedor.Contenedor.LPokemon ) {
						if (Po.getNumero().equals(Numero)){
							txtNumero.setText(Po.getNumero());
							txtNivel.setText(Po.getNivelEvolucion());
							txtRegion.setText(Po.getRegion());
							comboBox.setToolTipText(Po.getTipo());
							txtComentarios.setText(Po.getTipo());
				}
			}
				}
			}
		});
	}
	//Arrancará por defecto en el Modo Leer, todo aparecerá deshabilitado, menos los botones insertar y buscar
	private void ModoLeer(){
		lblPokedex.setEnabled(false);
		lblNombre.setEnabled(false);
		lblNumero .setEnabled(false);
		lblNivelDeEvolucion .setEnabled(false);
		lblRegion .setEnabled(false);
		lblTipo .setEnabled(false);
		lblComentarios.setEnabled(false);
		txtComentarios .setEnabled(false);
		listTipo.setEnabled(false);
		txtNombre .setEnabled(false);
		txtNumero .setEnabled(false);
		txtNivel .setEnabled(false);
		txtRegion .setEnabled(false);
		comboBox .setEnabled(false);
		btnAtras .setEnabled(false);
		btnDelante .setEnabled(false);
		lblNumList .setEnabled(true);
	}
	
	//Modo Busqueda, cuando ejecutemos La opcion Buscar Habilitar el modo buscar
	private void ModoBuscar(){
		lblPokedex.setEnabled(false);
		lblNombre.setEnabled(true);
		txtNombre.setEnabled(true);
		lblNumero .setEnabled(false);
		lblNivelDeEvolucion .setEnabled(false);
		lblRegion .setEnabled(false);
		lblTipo .setEnabled(false);
		lblComentarios.setEnabled(false);
		txtComentarios .setEnabled(false);
		listTipo.setEnabled(false);
		txtNumero .setEnabled(false);
		txtNivel .setEnabled(false);
		txtRegion .setEnabled(false);
		comboBox .setEnabled(false);
		btnAtras .setEnabled(true);
		btnDelante .setEnabled(true);
		lblNumList .setEnabled(false);
		lblNumList.setVisible(false);
	}
	//Modo Insertar, Cuando ejecutemos la opcion Insertar habilitara las opciones de Insertar
	private void ModoInsertar(){
		lblPokedex.setEnabled(false);
		lblNombre.setEnabled(true);
		lblNumero .setEnabled(true);
		lblNivelDeEvolucion .setEnabled(true);
		lblRegion .setEnabled(true);
		lblTipo .setEnabled(true);
		lblComentarios.setEnabled(false);
		txtComentarios .setEnabled(true);
		listTipo.setEnabled(true);
		txtNombre .setEnabled(true);
		txtNumero .setEnabled(true);
		txtNivel .setEnabled(true);
		txtRegion .setEnabled(true);
		comboBox .setEnabled(true);
		btnAtras .setEnabled(false);
		btnDelante .setEnabled(false);
		lblNumList .setEnabled(false);
	}
	
	//Crear Pokemon
		public void crearPokemon() {

			int indice =Listas.ListasPokemon.size() - 1;

			Listas.ListasPokemon.get(indice).setNombre(Nombre);
			Listas.ListasPokemon.get(indice).setNumero(Numero);
			Listas.ListasPokemon.get(indice).setNivelEvolucion(Nivel);
			Listas.ListasPokemon.get(indice).setRegion(Region);
			Listas.ListasPokemon.get(indice).setTipo(Tipo);
			Listas.ListasPokemon.get(indice).setComentarios(Comentarios);
			
			indicePokemon = indice;
		}
		
		
		//Busca y muestra Todo
		public void mostrarPokemon() {
			if (!Listas.ListasPokemon.isEmpty()) {
				ListasPokemon Po = Listas.ListasPokemon.get(indicePokemon);

				txtNombre.setText(Po.getNombre());
				txtNumero.setText(Po.getNumero());
				txtNivel.setText(Po.getNivelEvolucion());
				txtRegion.setText(Po.getRegion());
				comboBox.setToolTipText(Po.getTipo());
				txtComentarios.setText(Po.getComentarios());
				
			}
		}
		//Indice de Pokemon
		//Proximo Pokemon
		private int nextPokemon() {
			++indicePokemon;
			if (indicePokemon == Listas.ListasPokemon.size()) {
				indicePokemon = 0;
			}
			return indicePokemon;
		}
		//Primer Pokemon
		private int prevPokemon() {
			--indicePokemon;
			if (indicePokemon < 0) {
				indicePokemon = Listas.ListasPokemon.size() - 1;
			}
			return indicePokemon;
		}
}
