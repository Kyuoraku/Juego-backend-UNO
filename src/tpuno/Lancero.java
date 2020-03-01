package tpuno;

	/**
	 * Esta clase permite crear objetos de tipo lancero, con 150 de vida inicial, 25 de ataque, y un rango de ataque
	 * de 1 a 3.
	 * @author kyuoraku
	 *
	 */

public class Lancero extends Personaje{
	

	private static final Integer DANIO = 25;

	public Lancero(Punto posicion) {
		super(150, posicion);
	}
	@SuppressWarnings("static-access")
	@Override
	public Boolean atacar(Personaje oponente) {
		Double aux = this.distancia(oponente.posicion);
		if(this.getSalud()>0) {
			if(aux > 0 && aux <= 3) {
				oponente.setSalud(oponente.getSalud()-this.DANIO);
				return true;
			}
		}
		return false;
	}
	
	
}
