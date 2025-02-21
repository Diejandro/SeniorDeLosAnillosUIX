package grupos;

// TODO: Auto-generated Javadoc
/**
 * The Class Personajes.
 */
public abstract class Personajes {
	
	/** The nombre. */
	protected String nombre;
	
	/** The puntos vida. */
	protected int puntosVida;
	
	/** The armadura. */
	protected int armadura;
	
	/**
	 * Instantiates a new personajes.
	 *
	 * @param nombre the nombre
	 * @param puntosVida the puntos vida
	 * @param armadura the armadura
	 */
	public Personajes(String nombre, int puntosVida, int armadura) {
		this.nombre = nombre;
		this.puntosVida = puntosVida;
		this.armadura = armadura;
	}
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Gets the puntos vida.
	 *
	 * @return the puntos vida
	 */
	public int getPuntosVida() {
		return puntosVida;
	}
	
	/**
	 * Sets the puntos vida.
	 *
	 * @param puntosVida the new puntos vida
	 */
	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}
	
	/**
	 * Gets the armadura.
	 *
	 * @return the armadura
	 */
	public int getArmadura() {
		return armadura;
	}
	
	/**
	 * Sets the armadura.
	 *
	 * @param armadura the new armadura
	 */
	public void setArmadura(int armadura) {

		this.armadura = armadura;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Personajes [nombre=" + nombre + ", puntosVida=" + puntosVida + ", armadura=" + armadura + "]";
	};
}
