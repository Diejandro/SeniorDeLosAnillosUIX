package grupos;

// TODO: Auto-generated Javadoc
/**
 * The Class Enlace.
 */
public class Enlace {
	
	/** The nombre. */
	protected String nombre;
	
	/** The tipo. */
	protected String tipo;
	
	/** The puntos vida. */
	protected int puntosVida;
	
	/** The armadura. */
	protected int armadura;
	
	/**
	 * Instantiates a new enlace.
	 *
	 * @param nombre the nombre
	 * @param tipo the tipo
	 * @param puntosVida the puntos vida
	 * @param armadura the armadura
	 */
	public Enlace(String nombre, String tipo, int puntosVida, int armadura) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.puntosVida = puntosVida;
		this.armadura = armadura;
	}
	
	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * Sets the tipo.
	 *
	 * @param tipo the new tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		return nombre + " - " + tipo + " (" + puntosVida + ", " + armadura + ")";
	};
}
