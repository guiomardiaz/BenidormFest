package Modelo;

import java.util.ArrayList;

public class Ciudadano extends Thread {
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
	

			for (int i = 0; i < rango_edad[2]; i++) {
				comprobacionVotos(7, 10, 23, 30, 37, 51, 61, 88, 95, comunidad);

			} // end for
			for (int i = 0; i < rango_edad[3]; i++) {
				comprobacionVotos(14, 20, 33, 40, 46, 58, 65, 81, 90, comunidad);

			} // end for
			for (int i = 0; i < rango_edad[4]; i++) {
				comprobacionVotos(5, 15, 27, 33, 40, 54, 61, 71, 88, comunidad);

			} // end for
			for (int i = 0; i < rango_edad[5]; i++) {
				comprobacionVotos(3, 20, 25, 37, 49, 58, 65, 76, 91, comunidad);

			} // end for
			
	}// end run

	public void comprobacionVotos(int num1, int num2, int num3, int num4, int num5, int num6, int num7, int num8,
			int num9, String comunidad) {
		aleatorio = (int) (Math.random() * 101);
		if (aleatorio <= num1) {
			//artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales() + 1);
			comprobarComunidad(comunidad, 0);
			comprobarRangoEdad(num1, 0);
		} else if (aleatorio > num1 && aleatorio <= num2) {
			//artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales() + 1);
			comprobarComunidad(comunidad, 1);	
			comprobarRangoEdad(num1, 1);
		} else if (aleatorio > num2 && aleatorio <= num3) {
			//artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales() + 1);
			comprobarComunidad(comunidad, 2);
			comprobarRangoEdad(num1, 2);
		} else if (aleatorio > num3 && aleatorio <= num4) {
			//artistas.get(3).setVotosTotales(artistas.get(3).getVotosTotales() + 1);
			comprobarComunidad(comunidad, 3);	
			comprobarRangoEdad(num1, 3);
		} else if (aleatorio > num4 && aleatorio <= num5) {
			//artistas.get(4).setVotosTotales(artistas.get(4).getVotosTotales() + 1);
			comprobarComunidad(comunidad, 4);
			comprobarRangoEdad(num1, 4);
		} else if (aleatorio > num5 && aleatorio <= num6) {
			//artistas.get(5).setVotosTotales(artistas.get(5).getVotosTotales() + 1);
			comprobarComunidad(comunidad, 5);	
			comprobarRangoEdad(num1,5);
		} else if (aleatorio > num6 && aleatorio <= num7) {
			//artistas.get(6).setVotosTotales(artistas.get(6).getVotosTotales() + 1);
			comprobarComunidad(comunidad, 6);
			comprobarRangoEdad(num1, 6);
		} else if (aleatorio > num7 && aleatorio <= num8) {
			//artistas.get(7).setVotosTotales(artistas.get(7).getVotosTotales() + 1);
			comprobarComunidad(comunidad, 7);	
			comprobarRangoEdad(num1,7);
		} else if (aleatorio > num8 && aleatorio <= num9) {
			//artistas.get(8).setVotosTotales(artistas.get(8).getVotosTotales() + 1);
			comprobarComunidad(comunidad, 8);	
			comprobarRangoEdad(num1,8);
		} else if (aleatorio > num9 && aleatorio <= 100) {
			//artistas.get(9).setVotosTotales(artistas.get(9).getVotosTotales() + 1);
			comprobarComunidad(comunidad, 9);	
			comprobarRangoEdad(num1, 9);
		}
	}

	private void comprobarRangoEdad(int num1, int i) {
		if(num1 == 7) {
			artistas.get(i).setRango18_25(artistas.get(i).getRango18_25()+1);
		}else if(num1==14) {
			artistas.get(i).setRango26_40(artistas.get(i).getRango26_40()+1);
		}else if(num1 ==5) {
			artistas.get(i).setRango41_65(artistas.get(i).getRango41_65()+1);
		}else if(num1 ==3) {
			artistas.get(i).setRango66mas(artistas.get(i).getRango66mas()+1);
		}
	}

	public void comprobarComunidad(String comunidad, int num) {
		if (comunidad.equalsIgnoreCase("Andalucia")) {
			artistas.get(num).setVotosAndaluces(artistas.get(num).getVotosAndaluces() + 1);
		}else if (comunidad.equalsIgnoreCase("Aragon")) {
			artistas.get(num).setVotosAragoneses(artistas.get(num).getVotosAragoneses() + 1);
		}else if (comunidad.equalsIgnoreCase("Asturias")) {
			artistas.get(num).setVotosAsturianos(artistas.get(num).getVotosAsturianos() + 1);
		}else if (comunidad.equalsIgnoreCase("Baleares")) {
			artistas.get(num).setVotosBaleares(artistas.get(num).getVotosBaleares() + 1);
		}else if (comunidad.equalsIgnoreCase("Canarias")) {
			artistas.get(num).setVotosCanarios(artistas.get(num).getVotosCanarios() + 1);
		}else if (comunidad.equalsIgnoreCase("Cantabria")) {
			artistas.get(num).setVotosCantabricos(artistas.get(num).getVotosCantabricos() + 1);
		}else if (comunidad.equalsIgnoreCase("CLM")) {
			artistas.get(num).setVotosCLM(artistas.get(num).getVotosCLM() + 1);
		}else if (comunidad.equalsIgnoreCase("CYL")) {
			artistas.get(num).setVotosCYL(artistas.get(num).getVotosCYL() + 1);
		}else if (comunidad.equalsIgnoreCase("Catalu??a")) {
			artistas.get(num).setVotosCatalanes(artistas.get(num).getVotosCatalanes() + 1);
		}else if (comunidad.equalsIgnoreCase("Valencia")) {
			artistas.get(num).setVotosValencianos(artistas.get(num).getVotosValencianos() + 1);
		}else if (comunidad.equalsIgnoreCase("Extremadura")) {
			artistas.get(num).setVotosExtreme??os(artistas.get(num).getVotosExtreme??os() + 1);
		}else if (comunidad.equalsIgnoreCase("Galicia")) {
			artistas.get(num).setVotosGallegos(artistas.get(num).getVotosGallegos() + 1);
		}else if (comunidad.equalsIgnoreCase("Madrid")) {
			artistas.get(num).setVotosMadrile??os(artistas.get(num).getVotosMadrile??os() + 1);
		}else if (comunidad.equalsIgnoreCase("Murcia")) {
			artistas.get(num).setVotosMurcianos(artistas.get(num).getVotosMurcianos() + 1);
		}else if (comunidad.equalsIgnoreCase("Navarra")) {
			artistas.get(num).setVotosNavarra(artistas.get(num).getVotosNavarra() + 1);
		}else if (comunidad.equalsIgnoreCase("Pais Vasco")) {
			artistas.get(num).setVotosVascos(artistas.get(num).getVotosVascos() + 1);
		}else if (comunidad.equalsIgnoreCase("Rioja")) {
			artistas.get(num).setVotosRioja(artistas.get(num).getVotosRioja() + 1);
		}else if (comunidad.equalsIgnoreCase("Ceuta")) {
			artistas.get(num).setVotosCeuta(artistas.get(num).getVotosCeuta() + 1);
		}else if (comunidad.equalsIgnoreCase("Melilla")) {
			artistas.get(num).setVotosMelilla(artistas.get(num).getVotosMelilla() + 1);
		}
	}

}
