package boletin2java;

public class Ejercicio9 {

	public static void main(String[] args) {
		System.out.println(3==contarPalabra("ATCGTTCTCGTTGATCTCGTTATCTCG", "CGTT"));
		System.out.println(0==contarPalabra("ATCGTTCTCGTTGATCTCGTTATCTCG", "CGAA"));
		System.out.println(0==contarPalabra("ATCGTTCTCGTTGATCTCGTTATCTCG", ""));
		System.out.println(0==contarPalabra("", "CGTT"));
		System.out.println("-------------------------------------------");
		System.out.println(descomprimeADN("T22A3G2C3"));
		System.out.println(descomprimeADN("A3G2T1C3").equals("AAAGGTCCC"));
		System.out.println(descomprimeADN("A3G2T10C3").equals("AAAGGTTTTTTTTTTCCC"));
	}
	
	public static int contarPalabra(String cadena,String palabra) {
		int contPalabra=0;
		int contLetra=0;
		if (!palabra.isEmpty()) {
			for (char cadenaChar:cadena.toCharArray()) {
				if (cadenaChar==palabra.charAt(contLetra)) {
					contLetra++;
					if (contLetra==palabra.length()) {
						contPalabra++;
						contLetra=0;
					}
				}else {
					contLetra=0;
				}
			}
		}
		return contPalabra;
	}
	
	public static String descomprimeADN(String cadenaComprimida) {
		String cadenaDescomprimidad="";
		int i=0;
		int numLetra=0;
		char letra='-';
		boolean siguieteEsNumero=false;
		while (i<cadenaComprimida.length()) {
			if (Character.isDigit(cadenaComprimida.charAt(i))) {
				if (siguieteEsNumero) {
					numLetra=numLetra*10;
				}
				numLetra+=Integer.valueOf(Character.toString(cadenaComprimida.charAt(i)));
				if ((i+1)<cadenaComprimida.length()) {
					 if (Character.isDigit(cadenaComprimida.charAt(i+1))) {
						 siguieteEsNumero=true;
					 }else {
						for (int j=0;j<numLetra;j++) {
							cadenaDescomprimidad+=letra;
						}
					 }
				}else {
					for (int j=0;j<numLetra;j++) {
						cadenaDescomprimidad+=letra;
					}
				}
			}else {
				siguieteEsNumero=false;
				numLetra=0;
				letra=cadenaComprimida.charAt(i);
			}
			i++;
		}
		
		return cadenaDescomprimidad;
	}
}
