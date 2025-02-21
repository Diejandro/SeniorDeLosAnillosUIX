package vista_ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class Ventana_Principal. Aquí se agurparán todos los elementos visibles y
 * se dará funcionalidad a la batalla.
 */
public class Ventana_Principal {

	/** The lista heroes. */
	Lista_Batalla listaHeroes = new Lista_Batalla();

	/** The lista bestias. */
	Lista_Batalla listaBestias = new Lista_Batalla();

	/** The desarrollo combate. */
	JTextArea desarrolloCombate = new JTextArea();

	/** The heroes. */
	Creador_Personajes heroes = new Creador_Personajes();

	/** The bestias. */
	Creador_Personajes bestias = new Creador_Personajes();

	/** The etiqueta heroe. */
	JLabel etiquetaHeroe = new JLabel("Heroes: ");

	/** The etiqueta bestia. */
	JLabel etiquetaBestia = new JLabel("Bestias: ");

	/** The opciones heroe. */
	String[] opcionesHeroe = new String[] { "Humano", "Elfo", "Hobbit" };

	/** The opciones bestia. */
	String[] opcionesBestia = new String[] { "Orco", "Trasgo" };

	/**
	 * Instantiates a new ventana principal. Se dará forma a la ventana, se situará
	 * justo en el centro de la pantalla
	 */
	public Ventana_Principal() {
		// Se crea el Frame
		JFrame ventanaPpal = new JFrame("Batalla por la Tierra Media");
		ventanaPpal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaPpal.setResizable(false);
		ventanaPpal.setSize(580, 720);

		// Obtengo el tamaño de la pantalla
		Dimension tamanioPantalla = Toolkit.getDefaultToolkit().getScreenSize();

		// calculo den centro de la pantalla
		int x = (int) ((tamanioPantalla.getWidth() - ventanaPpal.getWidth()) / 2);
		int y = (int) ((tamanioPantalla.getHeight() - ventanaPpal.getHeight()) / 2);

		// establecemos en qué pocision de la pantalla se abre la ventana.
		ventanaPpal.setLocation(x, y);

		// Añado los paneles al Frame
		ventanaPpal.add(agregarGrupoNorte(), BorderLayout.NORTH);
		ventanaPpal.add(agregaGrupoSur(), BorderLayout.CENTER);

		ventanaPpal.setVisible(true);

	}

	/**
	 * Agregar grupo norte. se añade en la ventana los dos formularios, situados uno
	 * a cada lado para crear el grupo de heroes y bestias.
	 *
	 * @return the j panel
	 */
	private JPanel agregarGrupoNorte() {
		JPanel grupoNorte = new JPanel();

		grupoNorte.add(heroes.agregarCrearPersonaje(etiquetaHeroe, opcionesHeroe, listaHeroes), BorderLayout.WEST);
		grupoNorte.add(bestias.agregarCrearPersonaje(etiquetaBestia, opcionesBestia, listaBestias), BorderLayout.EAST);

		return grupoNorte;

	}

	/**
	 * Agrega grupo sur. se añadirán en la parte sus los dos listados
	 * coresopndientes con el botón eliminar. Además, se añare un botón ue ejecutará
	 * el combate y un text area que imprimiá el resultado de la batalla.
	 *
	 * @return the j panel
	 */
	private JPanel agregaGrupoSur() {

		JPanel grupo = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0; // columna 0
		gbc.gridy = 0; // fila 0
		gbc.insets = new Insets(20, 0, 20, 10);
		gbc.anchor = GridBagConstraints.WEST;

		grupo.add(listaHeroes.agregarInfLista(), gbc);

		gbc.gridx = 1;
		gbc.insets = new Insets(20, 10, 20, 0);
		gbc.anchor = GridBagConstraints.EAST;

		grupo.add(listaBestias.agregarInfLista(), gbc);

		/*
		 * Botón que se encarga de ejecutar la batalla una vez ambas listas estén
		 * completas.
		 */
		JButton lucha = new JButton("A luhar!");
		lucha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Guerra.batalla(listaHeroes.listaHeroes(), listaBestias.listaBestias(), desarrolloCombate);

			}
		});
		gbc.gridx = 0; // Columna
		gbc.gridy = 1; // Fila
		gbc.gridwidth = 2; // Número de columnas que ocupa
		gbc.insets = new Insets(0, 0, 20, 0);
		gbc.anchor = GridBagConstraints.CENTER; // Posición del botón
		grupo.add(lucha, gbc);

		/*
		 * se instancia el Text area con un scrollPane, se le fa un formato y se añade
		 * al panel sur.
		 */
		JPanel panelCombate = new JPanel();
		JScrollPane scrollPane = new JScrollPane(desarrolloCombate);
		scrollPane.setPreferredSize(new Dimension(500, 200));
		panelCombate.add(scrollPane);
		gbc.gridx = 0; // Columna
		gbc.gridy = 2; // Fila
		gbc.gridwidth = 2; // Número de columnas que ocupa
		gbc.insets = new Insets(0, 0, 20, 0);
		gbc.anchor = GridBagConstraints.CENTER; // Posición del botón
		grupo.add(panelCombate, gbc);
		// grupo.add(batalla.agregarCombate(), gbc);

		EmptyBorder margen = new EmptyBorder(20, 20, 20, 20);
		LineBorder linea = new LineBorder(Color.BLACK);
		CompoundBorder bordCompuesto = new CompoundBorder(margen, linea);

		grupo.setBorder(bordCompuesto);
		return grupo;
	}
}

/*
 * JTextArea para poder mostrar el contenido debe recibir un String pero el
 * método guerra no devolvía nada en el proyecto anterior. La clase
 * TextAreaOutputStream permite redirigir la salida de un OutputStream a un
 * componente JTextArea, para mostrar mensajes de una interfaz gráfica de usuario.
 */
class TextAreaOutputStream extends OutputStream {

	private final JTextArea textArea;

	public TextAreaOutputStream(JTextArea textArea) {
		this.textArea = textArea;
	}

	@Override
	public void write(int b) {
		textArea.append(String.valueOf((char) b));
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

	@Override
	public void write(byte[] b, int off, int len) {
		textArea.append(new String(b, off, len));
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

}