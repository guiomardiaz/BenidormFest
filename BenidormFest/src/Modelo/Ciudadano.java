package Modelo;

import java.util.ArrayList;

public class Ciudadano extends Thread{
	String comunidad;
	int[] rango_edad;
	ArrayList<Artista> artistas;
	int aleatorio;
	




	public Ciudadano(String comunidad, int[] rango_edad, ArrayList<Artista> artistas) {
		super();
		this.comunidad = comunidad;
		this.rango_edad = rango_edad;
		this.artistas = artistas;
	}






	public void run() {
		if(comunidad.equalsIgnoreCase("Andalucia")) {
		for(int i = 0; i<rango_edad[2]; i++) {
			aleatorio = (int)(Math.random()*101);
			if(aleatorio<7) {
				artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+1);
				artistas.get(0).setVotosAndaluces(artistas.get(0).getVotosAndaluces()+1);
			}
			
		}//end for
		}//end ANDALUCIA
	}//end run

}
