package boletin2java;

import java.util.Arrays;

public class EntrandoEnPeloton {

	public static void main(String[] args) {
		System.out.println(transformarASegundos("01:01:01"));
		String[] tiempoStrings= {"01:03:00","01:00:59","01:01:01","01:01:00"};
		
		print(darPosicion(tiempoStrings));
	}

	public static String[][] darPosicion(String[] tiempos){
		String[][]resultado=new String[tiempos.length][2];
		
		int[] tiemposSegundo=transformarTiempoASegundo(tiempos);
		
		Arrays.sort(tiemposSegundo);
		int rankingPeloton=0;
		
		for (int i=0;i<tiemposSegundo.length;i++) {
			if(i!=0 && tiemposSegundo[i]-tiemposSegundo[i-1]<=1) {
				resultado[i][0]=transformarSegundoATiempo(tiemposSegundo[i]);
				resultado[i][1]=Integer.toString(rankingPeloton);
			}else {
				resultado[i][0]=transformarSegundoATiempo(tiemposSegundo[i]);
				resultado[i][1]=Integer.toString(i+1);
				rankingPeloton=i+1;
			}
		}
		
		return resultado;
	}
	
	public static String transformarSegundoATiempo(int segundosTotales) {
		int hora=0;
		while (segundosTotales>=3600) {
			hora++;
			segundosTotales=segundosTotales-3600;
		}
		int minuto=0;
		while (segundosTotales>=60) {
			minuto++;
			segundosTotales=segundosTotales-60;
		}
		String tiempoString="";
		
		if (hora<10) {
			tiempoString+="0"+hora+":";
		}else {
			tiempoString+=hora+":";
		}
		
		if (minuto<10) {
			tiempoString+="0"+minuto+":";
		}else {
			tiempoString+=minuto+":";
		}
		
		if (segundosTotales<10) {
			tiempoString+="0"+segundosTotales;
		}else {
			tiempoString+=segundosTotales;
		}
		
		return tiempoString;
	}
	
	public static int[] transformarTiempoASegundo(String[] tiempos) {
		int[] tiemposSegundo=new int[tiempos.length];
		for (int i=0;i<tiempos.length;i++) {
			tiemposSegundo[i]=transformarASegundos(tiempos[i]);
		}
		
		return tiemposSegundo;
	}
	
	
	public static int transformarASegundos(String tiempo) {
		int resultado=0;
		
		String[] tiempoArray =tiempo.split(":");
		int [] tiempoArrayInt=new int[3];
		
		if (tiempoArray.length==3) {
			for (int i=0;i<tiempoArray.length;i++) {
				tiempoArrayInt[i]=Integer.valueOf(tiempoArray[i]);
			}
			
			if (tiempoArrayInt[0]>=0 &&  tiempoArrayInt[0]<24 &&  tiempoArrayInt[1]>=0 &&  tiempoArrayInt[1]<60 &&  tiempoArrayInt[2]>=0 &&  tiempoArrayInt[2]<60) {
				resultado=tiempoArrayInt[2]+tiempoArrayInt[1]*60+tiempoArrayInt[0]*60*60;
			}
		}
		
		return resultado;
	}
	
	public static void print(String[][] cadenas) {
		for (String[]cadenas1:cadenas) {
			for (String cadena:cadenas1) {
				System.out.println(cadena);
			}
		}
	}
}
