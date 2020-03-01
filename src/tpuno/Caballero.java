package tpuno;

/**
 * Esta clase permite crear personajes de tipo caballero, con una vida inicial de 200, un daño de 50 y
 * un caballo que enloquece después de 3 ataques (revertible si se recibe la poción de agua).
 * Implementa la interfaz Energizable para omitir la creación del objeto "poción de agua". 
 * De esta forma, simplemente llamando al objeto de tipo caballero junto a su función pocionar,
 * se estaría otorgando una poción de agua.
 * @author kyuoraku
 *
 */

public class Caballero extends Personaje implements Energizable{

	private static final Integer DANIO=50;
	private Boolean caballo_locazo = false;
	private Integer contador_ataques = 0;
	
	
	public Integer getDanio() {
		return DANIO;
	}
	public Caballero(Punto posicion) {
		super(200, posicion);
	}
	public Boolean getCaballoLoco() {
		return this.caballo_locazo;
	}
		@SuppressWarnings("static-access")
		@Override
	public Boolean atacar(Personaje oponente) {
		Double aux = this.distancia(oponente.posicion);
		if (this.contador_ataques > 2) {
			this.caballo_locazo = true;
			return false;
		}
		if(this.getSalud()>0) {
			if(aux>0&&aux<=2){
				if(this.caballo_locazo==false)				//Se verifica que el caballo aún está cuerdo para pelear
					oponente.setSalud(oponente.getSalud()-this.DANIO);
					this.contador_ataques ++;
					return true;
			}
			return false;
		}
			return false;
	}
	@Override
	public void pocionar() {
		this.caballo_locazo = false;
		this.contador_ataques = 0;
	}
	

}
