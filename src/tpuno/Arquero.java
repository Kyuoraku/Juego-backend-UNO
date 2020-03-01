package tpuno;

/**
 * Esta clase permite crear arqueros, cuyas estadisticas iniciales son 50 de salud, 5 de ataque, 20 flechas y
 * un rango de ataque minimo de 2 y máximo de 5.
 * @author kyuoraku
 *
 */

public class Arquero extends Personaje {

	private static final Integer DANIO=5; 
	private Integer flechas = 20; //Cantidad de flechas.
	

	public Arquero(Punto posicion){
		super (50, posicion);
	}
	
	Integer getFlechas() {
		return flechas;
	}

	public Integer getDanio() {
		return DANIO;
	}

	
	
	/**
	 * Este método permite conocer de manera rápida si el arquero al que se refiere, tiene aún flechas, para una rápida autenticación en la posibilidad de ataque frente a otro personaje.
	 * @return: devuelve true si tiene al menos una flecha.
	 */
	public Boolean tieneFlechas(){
		if (this.flechas > 0) return true;
		return false;
	}
	/**
	 * Este método permite a cualquier objeto de tipo arquero, recibir un paquete de flechas.
	 */
	public void getPaqueteFlechas() {
		this.flechas +=6;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public Boolean atacar(Personaje oponente){
		Double aux = this.distancia(oponente.posicion); 		
		if(this.getSalud()>0) {											//Se verifica que aún esté vivo.
			if(aux>1&&aux<=5){											//Se verifica que el enemigo está dentro del rango.
				if (this.tieneFlechas() == true) {
					this.flechas -=1;									//Se verifica que hay flechas disponibles para usar.
					oponente.setSalud(oponente.getSalud()-this.DANIO);	//Si todo lo anterior se cumple, se ataca al enemigo.
					return true;	
				}return false;					//Como el ataque fue posible, devuelve true.
			}
		}
		return false;
	}

}
