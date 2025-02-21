package vista_ventana;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import grupos.Enlace;

// TODO: Auto-generated Javadoc
/**
 * The Class Creador_Personajes. Esta clase se encara de la creación de las ventanas de formularios para heroes y bestias
 */
public final class Creador_Personajes {

	/** The text nombre. */
	private JTextField textNombre;
	
	/** The lista tipos. */
	private JComboBox<String> listaTipos;
	
	/** The text vida. */
	private JTextField textVida;
	
	/** The text armadura. */
	private JTextField textArmadura;
	
	/** The aniade personajes. */
	Lista_Batalla aniadePersonajes;

	/** The personaje. */
	Enlace personaje;

	/** The nombre. */
	private String nombre;
	
	/** The tipo. */
	private String tipo;
	
	/** The vida. */
	private int vida;
	
	/** The armadura. */
	private int armadura;

	/**
	 * Agregar crear personaje. método que crea ventana de formulario.
	 *
	 * @param etiquetaPersonaje the etiqueta personaje
	 * @param opciones the opciones
	 * @param listaPersonajes the lista personajes
	 * @return the j panel
	 */
	JPanel agregarCrearPersonaje(JLabel etiquetaPersonaje, String[] opciones, Lista_Batalla listaPersonajes) {
		// this.aniadePersonajes = aniadePersonajes;

		JPanel panelAgrupado = new JPanel();

		//creo un panel con un gridbaglayout para que sea más flexible y un gridbagconstrains 
		//para darle a los elemenos más precisión al colocarlos
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		/*
		 * este bucle for va colocando las etiquedas al lado izquierdo y situando los campos de texto
		 * y combobox a la exquierda.
		 */
		String[] etiquetas = { "Nombre", "Tipo", "Vida", "Armadura" };
		for (int i = 0; i < etiquetas.length; i++) {
			// Añadir la etiqueta
			JLabel etiqueta = new JLabel(etiquetas[i] + ": ");
			gbc.gridx = 0; // Columna 0
			gbc.gridy = i; // Fila i
			gbc.anchor = GridBagConstraints.EAST; // Alinear a la derecha
			panel.add(etiqueta, gbc); // Añadir el JTextField

			//llegado al punto del tipo se pondrá en vez de un campo de texto un ComboBox con los tipos 
			//pasados por parámetros
			if (etiquetas[i].equals("Tipo")) {
				listaTipos = new JComboBox<String>(opciones);
				gbc.gridx = 1; // Columna 1
				gbc.gridy = i; // Fila i
				gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
				panel.add(listaTipos, gbc);

			} else {
				JTextField campoTexto = new JTextField(7);
				if (etiquetas[i].equals("Nombre")) {
					textNombre = campoTexto;
				} else if (etiquetas[i].equals("Vida")) {
					textVida = campoTexto;
				} else if (etiquetas[i].equals("Armadura")) {
					textArmadura = campoTexto;
				}
				gbc.gridx = 1; // Columna 1
				gbc.gridy = i; // Fila i
				gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
				panel.add(campoTexto, gbc);
			}
		}

		/*
		 * Este boñon se encarga de, una vez completado el formulario, si este contiene campos inválidos nos salta una ventana emergente
		 * informando de la falta de datos o el tipo que debe incluirse y se añadirá a la lista que se encuentra en la clase
		 * Lista_Batalla
		 */
		JButton boton = new JButton("Añadir");
		gbc.gridx = 0; // Columna
		gbc.gridy = etiquetas.length; // Fila
		gbc.gridwidth = 2; // Número de columnas que ocupa
		gbc.anchor = GridBagConstraints.CENTER; // Posición del botón
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					nombre = textNombre.getText().trim();
					tipo = (String) listaTipos.getSelectedItem();
					String vidaTexto = textVida.getText().trim();
					String armaduraTexto = textArmadura.getText().trim();
					if (nombre.isEmpty() || vidaTexto.isEmpty() || armaduraTexto.isEmpty() || tipo == null) {
						throw new IllegalArgumentException("Todos los campos deben estar llenos.");
					}
					vida = Integer.parseInt(vidaTexto);
					armadura = Integer.parseInt(armaduraTexto);

					/*
					 * Crear el objeto correspondiente basado en el tipo.
					 * 
					 * Hago uso de la clase enlace como intermediario para poder pasarselo a Lista_Batalla
					 */
					personaje = new Enlace(nombre, tipo, vida, armadura);
					listaPersonajes.agregarPersonaje(personaje);

					// Limpiar los campos después de añadir
					textNombre.setText("");
					listaTipos.setSelectedIndex(0);
					textVida.setText("");
					textArmadura.setText("");
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Por favor ingrese valores numéricos válidos para Vida y Armadura.", "Error de Formato",
							JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de Entrada", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//Se añaden los elementos al panel, se les da un margen y un borde.
		panel.add(boton, gbc);

		panelAgrupado.add(etiquetaPersonaje);
		panelAgrupado.add(panel);

		EmptyBorder margen = new EmptyBorder(30, 30, 30, 30);
		LineBorder linea = new LineBorder(Color.BLACK);
		CompoundBorder bordCompuesto = new CompoundBorder(margen, linea);

		panelAgrupado.setBorder(bordCompuesto);

		return panelAgrupado;

	}

}
