package tpuno;

/**
 * Esta clase permite crear objetos de tipo soldado, cuyas estadisticas iniciales son
 * 200 de vida, 10 de daño y 100 de energia.
 * La energia se utiliza para efectuar un ataque (10 por turno).
 * Si se llega a 0 energia, no puede atacar más hasta que reciba una poción de agua.
 * Implementado de la misma forma que Caballero.
 * @author kyuoraku
 
 */

public class Soldado extends Personaje implements Energizable{

	private Integer energia = 100;
	
	private static final Integer DANIO=10;
	public Soldado(Punto posicion) {
		super(200, posicion);
	}
	
	public Boolean tieneEnergia(){
		if (this.energia>9) return true;
		return false;
	}
	@SuppressWarnings("static-access")
	@Override
	public Boolean atacar(Personaje oponente) {
		Double aux = this.distancia(oponente.posicion);
		if(this.getSalud()>0) {
			if (aux<=1){
				if (this.tieneEnergia()==true)
					this.energia -= 10;
					oponente.setSalud(oponente.getSalud()-this.DANIO);
					return true;
			}
		}
		return false;
	}

	@Override
	public void pocionar() {
		this.energia = 100;
		
	}

}
