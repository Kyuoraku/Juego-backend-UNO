package tpuno;

/**
 * Esta clase permite "emular" un sistema de posiciones en un plano, para hacer posibles el sistema de ataque y las
 * existencias de los personajes en un terreno.
 * @author kyuoraku
 *
 */
public class Punto{	
	private Double x; //El sistema depende de estas dos variables, donde una es un eje vertical y el otro horizontal.
	private Double y;

	public Punto(double x, double y){   
		setX(x);
		setY(y);
	}
	public Punto(){	
		this (0,0) ;
	}
	protected  double getX(){	
		return x;
	}
	protected final void setX(double x)	{
		this.x = x;
	}
	protected final double getY(){
		return y;
	}
	protected final void setY(double y){ 
		this.y = y;
	}
	/**
	 * 
	 * @param oponente: se envia como parámetro un objeto de tipo personaje para calcular la distancia que hay entre ellos.
	 * @return: devuelve el valor exacto de distancia entre ambos personajes.
	 */
	public double distancia(Object oponente){
		Punto p = (Punto) oponente;
		return Math.sqrt( Math.pow(this.getX()-p.x,2) +  Math.pow(this.getY()-p.y,2) );
	}
	/**
	 * 
	 * @param punto: se ingresan los puntos respectivos a los ejes X e Y que se deseen desplazar. 
	 */
	public void desplazar(Object punto){
		Punto p = (Punto) punto;
		this.x+=p.x;
		this.y+=p.y;
		return;
	}
	public String toString(){
		return "("+this.getX()+";"+this.getY()+")" ;
	}
	public boolean equals(Object obj){ 
	if (this == obj) return true;
	if (obj == null) return false;
	if (getClass() != obj.getClass()) return false;
	Punto otro = (Punto) obj;
	if (Double.doubleToLongBits(y) != Double
			.doubleToLongBits(otro.y)) return false;
	if (Double.doubleToLongBits(x) != Double
			.doubleToLongBits(otro.x)) return false;
	return true;
	}
	public Punto clone(){	
		return new Punto(x, y);
	}

}