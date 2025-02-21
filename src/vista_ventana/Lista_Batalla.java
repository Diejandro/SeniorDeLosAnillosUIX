package vista_ventana;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import grupos.Bestias;
import grupos.Heroes;
import personajes.Elfo;
import personajes.Hobbit;
import personajes.Humano;
import personajes.Orco;
import personajes.Trasgo;
import grupos.Enlace;

// TODO: Auto-generated Javadoc
/**
 * The Class Ejecucion_Batalla. Clase que se encargará de mostrar los guerreros en sus respectiva lista.
 */
public final class Lista_Batalla {

	/** The modelo lista. */
	private DefaultListModel<String> modeloLista;
	
	/** The lista. */
	private JList<String> lista;

	/** The orco. */
	private Orco orco;
	
	/** The trasgo. */
	private Trasgo trasgo;
	
	/** The humano. */
	private Humano humano;
	
	/** The elfo. */
	private Elfo elfo;
	
	/** The hobbit. */
	private Hobbit hobbit;

	/** The luchadores heroes. */
	private List<Heroes> luchadoresHeroes = new ArrayList<>();
	
	/** The luchadores bestias. */
	private List<Bestias> luchadoresBestias = new ArrayList<>();

	/** The desarrollo combate. */
	JTextArea desarrolloCombate = new JTextArea();

	/**
	 * Instantiates a new ejecucion batalla. necesario para poder mostrar el los guerreros en la lista.
	 */
	public Lista_Batalla() {
		modeloLista = new DefaultListModel<>();
		lista = new JList<>(modeloLista);
	}

	/**
	 * Agregar inf lista. Se crea la parte de las listas visibles de heroes y bestias y se les da un orden y un formato con el botón para 
	 * poder eliminar algún guerrero antes de la batalla.
	 *
	 * @return the j panel
	 */
	JPanel agregarInfLista() {
		JButton eliminar = new JButton("Eliminar");

		JPanel listaVisible = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		JScrollPane scrollPane = new JScrollPane(lista);
		scrollPane.setPreferredSize(new Dimension(150, 100));
		gbc.gridx = 0; // Columna 0
		gbc.gridy = 1; // Fila 1
		gbc.anchor = GridBagConstraints.CENTER; // Alinear a la derecha
		listaVisible.add(scrollPane, gbc);

		// se añaden los grupos de botones.
		JPanel grupoBotones = new JPanel(new GridLayout(1, 3));
		grupoBotones.add(eliminar);
		gbc.gridx = 0; // Columna 0
		gbc.gridy = 2; // Fila 2
		gbc.anchor = GridBagConstraints.CENTER; // Alinear a la derecha
		listaVisible.add(grupoBotones, gbc);

		eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int itemSeleccionado = lista.getSelectedIndex();
				if (itemSeleccionado != -1) {
					modeloLista.remove(itemSeleccionado);
				}
			}
		});

		return listaVisible;
	}

	/**
	 * Agregar personaje. Método que se encarga. Por un lado de agregar en personaje en la 
	 * lista visible y por otro lado, se encarga de identificar el tipo de guerrero y almacenarlo en su correspondiente lista de 
	 * heroes o bestias.
	 *
	 * @param personaje the personaje
	 */
	public void agregarPersonaje(Enlace personaje) {

		switch (personaje.getTipo().toLowerCase()) {
		case "orco":
			orco = new Orco(personaje.getNombre(), personaje.getPuntosVida(), personaje.getArmadura());
			luchadoresBestias.add(orco);
			break;
		case "trasgo":
			trasgo = new Trasgo(personaje.getNombre(), personaje.getPuntosVida(), personaje.getArmadura());
			luchadoresBestias.add(trasgo);
			break;
		case "humano":
			humano = new Humano(personaje.getNombre(), personaje.getPuntosVida(), personaje.getArmadura());
			luchadoresHeroes.add(humano);
			break;
		case "elfo":
			elfo = new Elfo(personaje.getNombre(), personaje.getPuntosVida(), personaje.getArmadura());
			luchadoresHeroes.add(elfo);
			break;
		case "hobbit":
			hobbit = new Hobbit(personaje.getNombre(), personaje.getPuntosVida(), personaje.getArmadura());
			luchadoresHeroes.add(hobbit);
			break;
		}

		modeloLista.addElement(personaje.toString());
	}

	/**
	 * Lista heroes. Devuelve el cotenido de la lista de heroes completo.
	 *
	 * @return the list
	 */
	public List<Heroes> listaHeroes() {

		return luchadoresHeroes;
	}

	/**
	 * Lista bestias. Devuelve el contenido de la lista de bestias completo.
	 *
	 * @return the list
	 */
	public List<Bestias> listaBestias() {

		return luchadoresBestias;
	}


}
