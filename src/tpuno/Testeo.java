package tpuno;


import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

/**
 * Esta clase contiene todos los testeos realizados sobre el proyecto.
 * Junto a cada test, habrá una pequeña descripción de lo que se prueba.
 * @author kyuoraku
 */

/*
 * Metodos posibles para testear:
 * assertEquals(arg1,arg2) arg1 = resultado esperado de la operación del arg2.
 * assertTrue(arg1) arg1 = operación que se espera, devuelva true.
 * assertFalse(arg1) lo mismo de arriba pero con false
 * assertNull(arg1)
 * assertNotNull(arg1) lo mismo pero diferente a null.
 * assertEquals(arg1,arg2)
 * assertSame(arg1, arg2)
 * assertNotSame(arg1,arg2) testea si los argumentos apuntan a la misma referencia.
 */

class Testeo extends TestCase{
	
//------------------------TESTS DE ARQUERO
	
	//Se prueba que el arquero inicie con la vida correspondiente.
	@Test
	void vidaArquero() {
		Arquero ashe = new Arquero(new Punto(0,0));
		assertTrue(ashe.getSalud()==50);
	}
	//Se prueba que el arquero inicie con el danio correspondiente.
	@Test
	void danioArquero() {
		Arquero ashe = new Arquero(new Punto(0,0));
		assertTrue(ashe.getDanio()==5);
	}
	//Se prueba que el descuento de flechas sea el correspondiente.
	@Test
	void flechasArquero() {
		Arquero ashe = new Arquero(new Punto(0,0));
		Caballero hecarim = new Caballero(new Punto(1,2));
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		assertTrue(ashe.getFlechas()==18);
	}
	//Se prueba que el paquete de flechas funcione correctamente.
	@Test
	void flechasArqueroII() {
		Arquero ashe = new Arquero(new Punto(0,0));
		Caballero hecarim = new Caballero(new Punto(1,2));
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.getPaqueteFlechas();
		assertTrue(ashe.getFlechas()==24);
	}
	//Se prueba que la funcion atacar funcione correctamente.
	@Test
	void flechasArqueroIII() {
		Arquero ashe = new Arquero(new Punto(0,0));
		Caballero hecarim = new Caballero(new Punto(1,2));
		//Con un ciclo for arroja un resultado erroneo.
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		ashe.atacar(hecarim);
		assertFalse(ashe.atacar(hecarim));
		//Con todos esos ataques, se deberían haber bajado 100 puntos de salud.
	}
	//Se prueba que funcione bien el sistema de ataque.
	@Test
	void testVidaCorrecta() {
		Arquero ashe = new Arquero(new Punto (1,1));
		Lancero xin  = new Lancero(new Punto (2,3));
		ashe.atacar(xin);
		assertTrue(xin.getSalud()==145);
	}
	//Se prueba el sistema de distancias.
	@Test
	void testDistanciaCorrecta() {
		Arquero ashe = new Arquero(new Punto (1,1));
		Lancero xin  = new Lancero(new Punto (2,3));
		ashe.atacar(xin);
		ashe.desplazar(new Punto(7,5));
		//La posicion de ashe seria (7,5);
		//La distancia respecto a xin seria de:
		//sqrt(pow(7-2)+pow(5-3))
		//sqrt(25+4)
		//sqrt(29)
		//5.3. Fuera de rango:
		assertFalse(ashe.atacar(xin));
	}

	
//----------------------TESTS DE CABALLERO
	
	//Se prueba que el caballero inicie con la vida correspondiente.
	@Test
	void vidaCaballero() {
		Caballero hecarim = new Caballero(new Punto(3,3));
		assertTrue(hecarim.getSalud()==200);
	}
	//Se prueba que el caballero inicie con el danio correspondiente.
	@Test
	void danioCaballero() {
		Caballero hecarim = new Caballero(new Punto(0,0));
		assertTrue(hecarim.getDanio()==50);
	}
	//Se prueba que el caballo del caballero esté cuerdo para pelear.
	@Test
	void caballoCuerdo() {
		Caballero hecarim = new Caballero(new Punto(0,0));
		assertFalse(hecarim.getCaballoLoco());
	}
	//Se prueba que el caballo cumpla su debido rol.
	//ESTO NO FUNCIONA, ARREGLAR PROXIMAMENTE Xd
	@Test
	void caballeroyCaballo() {
		Caballero hecarim = new Caballero(new Punto(1,1));
		Soldado garen = new Soldado (new Punto(2,2));
		//La distancia entre ambos es de 1.41.
		hecarim.atacar(garen);
		hecarim.atacar(garen);
		hecarim.atacar(garen);
		assertFalse(hecarim.atacar(garen));
	}
	

}
