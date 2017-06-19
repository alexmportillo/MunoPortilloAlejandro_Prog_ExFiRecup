package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class Pokedex {

	private JFrame frame;
	private JTextField txtComentarios;
	private JTextField txtNombre;
	private JTextField txtNumero;
	private JTextField txtNivel;
	private JTextField txtRegion;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 606, 338);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPokedex = new JLabel("POKEDEX");
		lblPokedex.setFont(new Font("Trebuchet MS", Font.PLAIN, 26));
		lblPokedex.setBounds(210, 11, 143, 43);
		frame.getContentPane().add(lblPokedex);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(28, 70, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(28, 112, 46, 14);
		frame.getContentPane().add(lblNumero);
		
		JLabel lblNivelDeEvolucion = new JLabel("Nivel de Evolucion");
		lblNivelDeEvolucion.setBounds(28, 153, 105, 14);
		frame.getContentPane().add(lblNivelDeEvolucion);
		
		JLabel lblRegion = new JLabel("Region");
		lblRegion.setBounds(28, 192, 46, 14);
		frame.getContentPane().add(lblRegion);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(307, 65, 46, 14);
		frame.getContentPane().add(lblTipo);
		
		JLabel lblComentarios = new JLabel("Comentarios");
		lblComentarios.setBounds(246, 128, 77, 14);
		frame.getContentPane().add(lblComentarios);
		
		txtComentarios = new JTextField();
		txtComentarios.setBounds(335, 128, 143, 91);
		frame.getContentPane().add(txtComentarios);
		txtComentarios.setColumns(10);
		
		JList listTipo = new JList();
		listTipo.setBounds(365, 69, 1, 1);
		frame.getContentPane().add(listTipo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(83, 67, 86, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(83, 109, 86, 20);
		frame.getContentPane().add(txtNumero);
		
		txtNivel = new JTextField();
		txtNivel.setColumns(10);
		txtNivel.setBounds(142, 150, 86, 20);
		frame.getContentPane().add(txtNivel);
		
		txtRegion = new JTextField();
		txtRegion.setColumns(10);
		txtRegion.setBounds(142, 189, 86, 20);
		frame.getContentPane().add(txtRegion);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tierra", "Aire", "Fuego", "Agua"}));
		comboBox.setBounds(346, 65, 132, 20);
		frame.getContentPane().add(comboBox);
	}
}
