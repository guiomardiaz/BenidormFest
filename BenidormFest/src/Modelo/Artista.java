package Modelo;

public class Artista {
	String dni;
	String nombre;
	String nombreCancion;
	String apellidos;
	String urlFoto;
	int votosTotales;
	int votosAndaluces, votosAragoneses, votosAsturianos , votosBaleares ,votosCanarios ,
	votosCantabricos, votosCLM ,votosCYL ,votosCatalanes ,votosValencianos ,votosExtremeños,
	votosGallegos, votosMadrileños, votosMurcianos, votosNavarra, votosVascos, votosRioja,
	votosCeuta, votosMelilla;
	
	public Artista() {
		super();

	}
	

	
	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getUrlFoto() {
		return urlFoto;
	}


	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
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

	public int getVotosAragoneses() {
		return votosAragoneses;
	}

	public void setVotosAragoneses(int votosAragoneses) {
		this.votosAragoneses = votosAragoneses;
	}

	public int getVotosAsturianos() {
		return votosAsturianos;
	}

	public void setVotosAsturianos(int votosAsturianos) {
		this.votosAsturianos = votosAsturianos;
	}

	public int getVotosBaleares() {
		return votosBaleares;
	}

	public void setVotosBaleares(int votosBaleares) {
		this.votosBaleares = votosBaleares;
	}

	public int getVotosCanarios() {
		return votosCanarios;
	}

	public void setVotosCanarios(int votosCanarios) {
		this.votosCanarios = votosCanarios;
	}

	public int getVotosCantabricos() {
		return votosCantabricos;
	}

	public void setVotosCantabricos(int votosCantabricos) {
		this.votosCantabricos = votosCantabricos;
	}

	public int getVotosCLM() {
		return votosCLM;
	}

	public void setVotosCLM(int votosCLM) {
		this.votosCLM = votosCLM;
	}

	public int getVotosCYL() {
		return votosCYL;
	}

	public void setVotosCYL(int votosCYL) {
		this.votosCYL = votosCYL;
	}

	public int getVotosCatalanes() {
		return votosCatalanes;
	}

	public void setVotosCatalanes(int votosCatalanes) {
		this.votosCatalanes = votosCatalanes;
	}

	public int getVotosValencianos() {
		return votosValencianos;
	}

	public void setVotosValencianos(int votosValencianos) {
		this.votosValencianos = votosValencianos;
	}

	public int getVotosExtremeños() {
		return votosExtremeños;
	}

	public void setVotosExtremeños(int votosExtremeños) {
		this.votosExtremeños = votosExtremeños;
	}

	public int getVotosGallegos() {
		return votosGallegos;
	}

	public void setVotosGallegos(int votosGallegos) {
		this.votosGallegos = votosGallegos;
	}

	public int getVotosMadrileños() {
		return votosMadrileños;
	}

	public void setVotosMadrileños(int votosMadrileños) {
		this.votosMadrileños = votosMadrileños;
	}

	public int getVotosMurcianos() {
		return votosMurcianos;
	}

	public void setVotosMurcianos(int votosMurcianos) {
		this.votosMurcianos = votosMurcianos;
	}

	public int getVotosNavarra() {
		return votosNavarra;
	}

	public void setVotosNavarra(int votosNavarra) {
		this.votosNavarra = votosNavarra;
	}

	public int getVotosVascos() {
		return votosVascos;
	}

	public void setVotosVascos(int votosVascos) {
		this.votosVascos = votosVascos;
	}

	public int getVotosRioja() {
		return votosRioja;
	}

	public void setVotosRioja(int votosRioja) {
		this.votosRioja = votosRioja;
	}

	public int getVotosCeuta() {
		return votosCeuta;
	}

	public void setVotosCeuta(int votosCeuta) {
		this.votosCeuta = votosCeuta;
	}

	public int getVotosMelilla() {
		return votosMelilla;
	}

	public void setVotosMelilla(int votosMelilla) {
		this.votosMelilla = votosMelilla;
	}

	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombreCancion() {
		return nombreCancion;
	}


	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}


	@Override
	public String toString() {
		return "Artista [nombre=" + nombre + ", urlFoto=" + urlFoto + ", votosTotales=" + votosTotales
				+ ", votosAndaluces=" + votosAndaluces + ", votosAragoneses=" + votosAragoneses + ", votosAsturianos="
				+ votosAsturianos + ", votosBaleares=" + votosBaleares + ", votosCanarios=" + votosCanarios
				+ ", votosCantabricos=" + votosCantabricos + ", votosCLM=" + votosCLM + ", votosCYL=" + votosCYL
				+ ", votosCatalanes=" + votosCatalanes + ", votosValencianos=" + votosValencianos + ", votosExtremeños="
				+ votosExtremeños + ", votosGallegos=" + votosGallegos + ", votosMadrileños=" + votosMadrileños
				+ ", votosMurcianos=" + votosMurcianos + ", votosNavarra=" + votosNavarra + ", votosVascos="
				+ votosVascos + ", votosRioja=" + votosRioja + ", votosCeuta=" + votosCeuta + ", votosMelilla="
				+ votosMelilla + "]";
	}
	
	

}
