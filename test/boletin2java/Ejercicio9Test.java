package boletin2java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio9Test {

	@Test
	void contarPalabrasTest() {
		assertEquals(3,Ejercicio9.contarPalabra("ATCGTTCTCGTTGATCTCGTTATCTCG", "CGTT"));
		assertEquals(5,Ejercicio9.contarPalabra("ATCGTTCTCGTTGATCTCGTTATCTCG", "CGTT"));
	}

}
