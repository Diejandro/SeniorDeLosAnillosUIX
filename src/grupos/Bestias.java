package grupos;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Bestias.
 */
public class Bestias extends Personajes implements DadosTirados{
	
	/**
	 * Instantiates a new bestias.
	 *
	 * @param nombre the nombre
	 * @param puntosVida the puntos vida
	 * @param armadura the armadura
	 */
	public Bestias(String nombre, int puntosVida, int armadura) {
		super(nombre, puntosVida, armadura);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Resultado dados.
	 *
	 * @return the int
	 */
	@Override
	public int resultadoDados() {
		// TODO Auto-generated method stub
		Random random = new Random();
		int dado = random.nextInt(91);
		return dado;
	}
	
	/**
	 * Fuerza.
	 *
	 * @return the int
	 */
	public final int fuerza() {
		int resultado = resultadoDados();
		
		int fuerza = (int) (resultado + (resultado*0.1));
		
		return fuerza;
	}

}
