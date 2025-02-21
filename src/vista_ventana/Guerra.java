package vista_ventana;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.JTextArea;

import grupos.Bestias;
import grupos.Heroes;
import personajes.Elfo;
import personajes.Hobbit;
import personajes.Orco;
import personajes.Trasgo;

// TODO: Auto-generated Javadoc
/**
 * The Class Guerra.
 */
public class Guerra {

	/**
	 * Batalla. Funciona pra ejecutar la batalla siguiendo las condiciones establecidas por el ejercicio, su diferencia racida en que
	 * en esta clase para que pueda darnos un resultado por text area, se redirije a este cambiando los System.out.println por textArea.appen
	 * y luego la ventana principal pueda mosntrarlos en el interfaz gráfico.
	 *
	 * @param luchadoresHeroes the luchadores heroes
	 * @param luchadoresBestias the luchadores bestias
	 * @param textArea the text area
	 */
	public static void batalla(List<Heroes> luchadoresHeroes, List<Bestias> luchadoresBestias, JTextArea textArea) {

		Boolean lanzador = false;
		int contador = 1;

		Queue<Heroes> colaHeroes = new LinkedList<>();
		Queue<Bestias> colaBestias = new LinkedList<>();

		while (!lanzador) {
			Iterator<Heroes> iteradorHeroes = luchadoresHeroes.iterator();
			Iterator<Bestias> iteradorBestias = luchadoresBestias.iterator();
			textArea.append("\nturno " + contador + "\n");

			while (iteradorHeroes.hasNext() && iteradorBestias.hasNext()) {
				Heroes heroe = iteradorHeroes.next();
				Bestias bestia = iteradorBestias.next();

				// presentación de combatientes enfrentados
				textArea.append("Lucha entre " + heroe.getNombre() + " (Vida = " + heroe.getPuntosVida()
						+ " Armadura = " + heroe.getArmadura() + ") y " + bestia.getNombre() + "(Vida = "
						+ bestia.getPuntosVida() + " Armadura = " + bestia.getArmadura() + ")\n");

				Guerra.calculoTotal(heroe, bestia, textArea);

				if (bestia.getPuntosVida() <= 0) {
					textArea.append("\n**** " + bestia.getNombre() + " muere.****\n\n");
					iteradorBestias.remove();

				}

				if (heroe.getPuntosVida() <= 0) {
					textArea.append("\n**** " + heroe.getNombre() + " muere.****\n\n");
					iteradorHeroes.remove();
				}

			}

			contador++;

			while (luchadoresHeroes.size() > luchadoresBestias.size()) {
				colaHeroes.add(luchadoresHeroes.remove(luchadoresHeroes.size() - 1));
			}

			while (luchadoresBestias.size() > luchadoresHeroes.size()) {
				colaBestias.add(luchadoresBestias.remove(luchadoresBestias.size() - 1));
			}
			if (!colaHeroes.isEmpty()) {
				luchadoresHeroes.add(colaHeroes.poll());
			}
			if (!colaBestias.isEmpty()) {
				luchadoresBestias.add(colaBestias.poll());
			}
			if (luchadoresHeroes.isEmpty()) {
				textArea.append("La Bestias ganan la batalla\n");
				lanzador = true;
			} else if (luchadoresBestias.isEmpty()) {
				textArea.append("Los Heroes ganan la batalla\n");
				lanzador = true;
			}

		}

	}

	/**
	 * Calculo total.
	 *
	 * @param heroe the heroe
	 * @param bestia the bestia
	 * @param textArea the text area
	 */
	public static final void calculoTotal(Heroes heroe, Bestias bestia, JTextArea textArea) {
		int dadoHeroe = Guerra.totalDadoHeroe(heroe, bestia);
		int dadoBestia = Guerra.totalDadoBestia(bestia);

		int danioBestia = Guerra.calculoDanio(dadoHeroe, bestia.getArmadura());
		int danioHeroe = Guerra.calculoDanio(dadoBestia, heroe.getArmadura());

		bestia.setPuntosVida(Math.max(bestia.getPuntosVida() - danioBestia, 0));
		textArea.append(heroe.getNombre() + " saca " + dadoHeroe + " y le quita " + danioBestia + "\n");

		heroe.setPuntosVida(Math.max(heroe.getPuntosVida() - danioHeroe, 0));
		textArea.append(bestia.getNombre() + " saca " + dadoBestia + " y le quita " + danioHeroe + "\n");

	}

	/**
	 * Total dado heroe.
	 *
	 * @param heroe the heroe
	 * @param bestia the bestia
	 * @return the int
	 */
	public static int totalDadoHeroe(Heroes heroe, Bestias bestia) {
		int dadoHeroe = 0;

		if (heroe instanceof Elfo && bestia instanceof Orco)
			dadoHeroe = heroe.rabia();
		else if (heroe instanceof Hobbit && bestia instanceof Trasgo)
			dadoHeroe = heroe.miedo();
		else
			dadoHeroe = heroe.resultadoDados();

		return dadoHeroe;
	}

	/**
	 * Total dado bestia.
	 *
	 * @param bestia the bestia
	 * @return the int
	 */
	public static int totalDadoBestia(Bestias bestia) {
		int dadoBestia = 0;
		if (bestia instanceof Orco)
			dadoBestia = bestia.fuerza();
		else
			dadoBestia = bestia.resultadoDados();

		return dadoBestia;
	}

	/**
	 * Calculo danio.
	 *
	 * @param dado the dado
	 * @param armadura the armadura
	 * @return the int
	 */
	public static int calculoDanio(int dado, int armadura) {
		return Math.max(dado - armadura, 0);

	}
}
