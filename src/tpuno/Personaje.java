package tpuno;
/**
 * Esta clase permite generar diferentes tipos de personajes en un juego.
 * @author kyuoraku
 *
 */
public abstract class Personaje extends Punto{

	private Integer salud; //Este atributo contiene los puntos de salud con los que comienza cada tipo de personaje.
	private Integer danio; //Este atributo contiene los puntos de daño que inflige cada personaje por turno.
	protected void setSalud(Integer salud) {
		this.salud = salud;
	}

	protected void setDanio(Integer danio) {
		this.danio = danio;
	}

	protected void setPosicion(Punto posicion) {
		this.posicion = posicion;
	}

	public Integer getSalud() {
		return salud;
	}

	public Integer getDanio() {
		return danio;
	}

	public Punto getPosicion() {
		return posicion;
	}
	Punto posicion; //Este atributo contiene la posición del personaje en un eje imaginario.
	
	/**
	 * Este es el constructor común de todos los tipos de personaje.
	 * @param salud: ninguno recibe la salud como parámetro, esta se define dentro del cuerpo del constructor.
	 * @param posicion: este es el único argumento real al momento de construir un personaje. Se pasa un nuevo punto.
	 */
	public Personaje(Integer salud, Punto posicion){
		this.salud = salud;
		this.posicion = posicion;
	}
	
	/**
	 * Este método abstracto permite al personaje atacar a otro que esté dentro de su rango.
	 * @param oponente: nombre temporal asignado al personaje dentro del rango de ataque.
	 * @return: devuelve true si el ataque pudo realizarse sin problemas sobre su oponente.
	 */
	public abstract Boolean atacar (Personaje oponente);
	/**
	 * Este método permite saber si el personaje está vivo, ahorrando lineas de código en las autenticaciones
	 * para que otro personaje lo ataque, o para que él ataque a otro personaje.
	 * @return
	 */
	public Boolean estaVivo() {
		if (this.salud>0) return true;
		return false;
	}
}
