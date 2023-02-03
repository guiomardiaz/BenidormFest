package Modelo;

public class Artista {
	String nombre;
	int votosTotales;
	int votosAndaluces;
	
	public Artista(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVotosTotales() {
		return votosTotales;
	}

	public void setVotosTotales(int votosTotales) {
		this.votosTotales = votosTotales;
	}

	public int getVotosAndaluces() {
		return votosAndaluces;
	}

	public void setVotosAndaluces(int votosAndaluces) {
		this.votosAndaluces = votosAndaluces;
	}
	
	

}
