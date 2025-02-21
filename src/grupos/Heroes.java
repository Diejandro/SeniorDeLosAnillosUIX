package grupos;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Heroes.
 */
public class Heroes extends Personajes implements DadosTirados{

	/**
	 * Instantiates a new heroes.
	 *
	 * @param nombre the nombre
	 * @param puntosVida the puntos vida
	 * @param armadura the armadura
	 */
	public Heroes(String nombre, int puntosVida, int armadura) {
		super(nombre, puntosVida, armadura);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Resultado dados.
	 *
	 * @return the int
	 */
	@Override
	public final int resultadoDados() {
		// TODO Auto-generated method stub
		Random random = new Random();

		int dado_uno = random.nextInt(101);
		int dado_dos = random.nextInt(101);

		if (dado_uno > dado_dos)
			return dado_uno;
		else
			return dado_dos;

	}
	
	/**
	 * Rabia.
	 *
	 * @return the int
	 */
	public final int rabia() {
		
		int rabia = 10;
		
		rabia += resultadoDados();
		
		return rabia;
	}
	
	/**
	 * Miedo.
	 *
	 * @return the int
	 */
	public final int miedo() {
		
		int miedo = resultadoDados() - 5;
		
		return miedo;
		
		
	}
}
