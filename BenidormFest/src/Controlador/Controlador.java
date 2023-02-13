package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Properties;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

import Modelo.Artista;
import Modelo.Ciudadano;
import Vista.Vista;

public class Controlador implements ActionListener {

	public Vista vista = new Vista();

	public Connection conexion;
	public int votantesAndalucia, votantesAragon, votantesAsturias, votantesBaleares, votantesCanarias,
			votantesCantabria, votantesCLM, votantesCYL, votantesCatalunia, votantesCeuta, votantesValencia,
			votantesExtremadura, votantesGalicia, votantesRioja, votantesMadrid, votantesMelilla, votantesMurcia,
			votantesNavarra, votantesVascos;

	public int[] habitantesAndalucia, habitantesAragon, habitantesAsturias, habitantesBaleares, habitantesCanarias,
			habitantesCantabria, habitantesCLM, habitantesCYL, habitantesCatalunia, habitantesCeuta, habitantesValencia,
			habitantesExtremadura, habitantesGalicia, habitantesRioja, habitantesMadrid, habitantesMelilla,
			habitantesMurcia, habitantesNavarra, habitantesVascos;

	public int numero = 5;
	public int numero2 = 0;
	public int count = 20;

	public int selector = 0;

	public ArrayList<Artista> artistas = new ArrayList<Artista>();
	public ArrayList<Artista> aux = new ArrayList<Artista>();
	public ArrayList<String> nombresColeccion = new ArrayList<String>();
	public String nombreUsuario;
	public int edadUsuario;
	public String comunidadUsuario;
	public String artistaUsuario;

	public Controlador(Vista vista) throws IOException, ClassNotFoundException, SQLException,
			UnsupportedAudioFileException, LineUnavailableException {
		this.vista = vista;
		vista.continuar.addActionListener(this);
		// vista.panelInicioSesion.setVisible(false);
		vista.btnEmpezar.addActionListener(this);
		vista.rdbtnAndalucia.addActionListener(this);
		vista.rdbtnAragon.addActionListener(this);
		vista.rdbtnAsturias.addActionListener(this);
		vista.rdbtnBaleares.addActionListener(this);
		vista.rdbtnCanarias.addActionListener(this);
		vista.rdbtnCantabria.addActionListener(this);
		vista.rdbtnCatalunya.addActionListener(this);
		vista.rdbtnCeuta.addActionListener(this);
		vista.rdbtnCLM.addActionListener(this);
		vista.rdbtnCYL.addActionListener(this);
		vista.rdbtnExtremadura.addActionListener(this);
		vista.rdbtnGalicia.addActionListener(this);
		vista.rdbtnLaRioja.addActionListener(this);
		vista.rdbtnMadrid.addActionListener(this);
		vista.rdbtnMelilla.addActionListener(this);
		vista.rdbtnMurcia.addActionListener(this);
		vista.rdbtnNavarra.addActionListener(this);
		vista.rdbtnPaisVasco.addActionListener(this);
		vista.rdbtnValencia.addActionListener(this);

		vista.btnVotarAlba.addActionListener(this);
		vista.btnVotarAmie.addActionListener(this);
		vista.btnVotarElton.addActionListener(this);
		vista.btnVotarJoel.addActionListener(this);
		vista.btnVotarJulio.addActionListener(this);
		vista.btnVotarMarc.addActionListener(this);
		vista.btnVotarNahid.addActionListener(this);
		vista.btnVotarSarah.addActionListener(this);
		vista.btnVotarThiago.addActionListener(this);
		vista.btnVotarVictoria.addActionListener(this);
		vista.btnTodo.addActionListener(this);

		this.vista.timer.addActionListener(this);
		vista.progressBar = new JProgressBar();
		vista.progressBar.setMinimum(0);
		vista.progressBar.setMaximum(100);

		vista.btnComunidad.addActionListener(this);
		vista.btnGenerales.addActionListener(this);
		vista.btnRangoEdad.addActionListener(this);
		vista.lblErrorLogin.setVisible(false);

		llenarComboBox();
		vista.panelInicioSesion.setVisible(false);
		vista.panelComunidades.setVisible(false);
		vista.panelArtistas.setVisible(false);
		vista.panelProceso.setVisible(false);
		vista.panelResultados.setVisible(false);
		//vista.btnTodo.setVisible(false);

		vista.comboFiltro.setVisible(false);

		conexion = crearConexion();

		System.out.println("Conexion realizada");
		
		//Chequeando usuarios
		nombresColeccion = recuperarNombres(conexion);

		// Creacion de artistas
		aux = recuperarArtistas(conexion);
		
		
		aux.get(0).setUrlFoto("src/Imagenes/joel.png");
		aux.get(1).setUrlFoto("src/Imagenes/marc.png");
		aux.get(2).setUrlFoto("src/Imagenes/alba.png");
		aux.get(3).setUrlFoto("src/Imagenes/thiago.png");
		aux.get(4).setUrlFoto("src/Imagenes/amie.png");
		aux.get(5).setUrlFoto("src/Imagenes/sarah.png");
		aux.get(6).setUrlFoto("src/Imagenes/nahid.png");
		aux.get(7).setUrlFoto("src/Imagenes/julio.png");
		aux.get(8).setUrlFoto("src/Imagenes/elton.png");
		aux.get(9).setUrlFoto("src/Imagenes/victoria.png");

		// ordenar artistas
		artistas.add(aux.get(0));
		artistas.add(aux.get(9));
		artistas.add(aux.get(3));
		artistas.add(aux.get(5));
		artistas.add(aux.get(8));
		artistas.add(aux.get(4));
		artistas.add(aux.get(6));
		artistas.add(aux.get(1));
		artistas.add(aux.get(2));
		artistas.add(aux.get(7));

		vista.comboFiltro.addActionListener(this);

		// recuperamos los arrays de los habitantes y sus rangos
		habitantesAndalucia = recuperarHabitantes("Andalucia", conexion);
		habitantesAragon = recuperarHabitantes("Aragon", conexion);
		habitantesAsturias = recuperarHabitantes("Asturias", conexion);
		habitantesBaleares = recuperarHabitantes("Baleares", conexion);
		habitantesCanarias = recuperarHabitantes("Canarias", conexion);
		habitantesCantabria = recuperarHabitantes("Cantabria", conexion);
		habitantesCLM = recuperarHabitantes("Castilla La Mancha", conexion);
		habitantesCYL = recuperarHabitantes("Castilla y Leon", conexion);
		habitantesCatalunia = recuperarHabitantes("Catalunia", conexion);
		habitantesCeuta = recuperarHabitantes("Ceuta", conexion);
		habitantesValencia = recuperarHabitantes("Comunidad Valenciana", conexion);
		habitantesExtremadura = recuperarHabitantes("Extremadura", conexion);
		habitantesGalicia = recuperarHabitantes("Galicia", conexion);
		habitantesRioja = recuperarHabitantes("La Rioja", conexion);
		habitantesMadrid = recuperarHabitantes("Madrid", conexion);
		habitantesMelilla = recuperarHabitantes("Melilla", conexion);
		habitantesMurcia = recuperarHabitantes("Murcia", conexion);
		habitantesNavarra = recuperarHabitantes("Navarra", conexion);
		habitantesVascos = recuperarHabitantes("Pais Vasco", conexion);

		// recuperamos el numero de votantes de cada comuinidad

		votantesAndalucia = contadorTotal(habitantesAndalucia);
		votantesAragon = contadorTotal(habitantesAragon);
		votantesAsturias = contadorTotal(habitantesAsturias);
		votantesBaleares = contadorTotal(habitantesBaleares);
		votantesCanarias = contadorTotal(habitantesCanarias);
		votantesCantabria = contadorTotal(habitantesCantabria);
		votantesCLM = contadorTotal(habitantesCLM);
		votantesCYL = contadorTotal(habitantesCYL);
		votantesCatalunia = contadorTotal(habitantesCatalunia);
		votantesCeuta = contadorTotal(habitantesCeuta);
		votantesValencia = contadorTotal(habitantesValencia);
		votantesExtremadura = contadorTotal(habitantesExtremadura);
		votantesGalicia = contadorTotal(habitantesGalicia);
		votantesRioja = contadorTotal(habitantesRioja);
		votantesMadrid = contadorTotal(habitantesMadrid);
		votantesMelilla = contadorTotal(habitantesMelilla);
		votantesMurcia = contadorTotal(habitantesMurcia);
		votantesNavarra = contadorTotal(habitantesNavarra);
		votantesVascos = contadorTotal(habitantesVascos);

		System.out.println(votantesAndalucia);
		System.out.println(votantesAragon);
		
		vista.lblNombre5.setText(artistas.get(4).getNombre() + " " + artistas.get(4).getApellidos());
		vista.lblCancion5.setText(artistas.get(4).getNombreCancion());
		
		vista.lblNombre4.setText(artistas.get(3).getNombre() + " " + artistas.get(3).getApellidos());
		vista.lblCancion4.setText(artistas.get(3).getNombreCancion());
		
		vista.lblNombre3.setText(artistas.get(2).getNombre() + " " + artistas.get(2).getApellidos());
		vista.lblCancion3.setText(artistas.get(2).getNombreCancion());
		
		vista.lblNombre2.setText(artistas.get(1).getNombre() + " " + artistas.get(1).getApellidos());
		vista.lblCancion2.setText(artistas.get(1).getNombreCancion());
		
		vista.lblNombre1.setText(artistas.get(0).getNombre() + " " + artistas.get(0).getApellidos());
		vista.lblCancion1.setText(artistas.get(0).getNombreCancion());
		
		vista.lblNombre6.setText(artistas.get(5).getNombre() + " " + artistas.get(5).getApellidos());
		vista.lblCancion6.setText(artistas.get(5).getNombreCancion());
		
		vista.lblNombre7.setText(artistas.get(6).getNombre() + " " + artistas.get(6).getApellidos());
		vista.lblCancion7.setText(artistas.get(6).getNombreCancion());
		
		vista.lblNombre8.setText(artistas.get(7).getNombre() + " " + artistas.get(7).getApellidos());
		vista.lblCancion8.setText(artistas.get(7).getNombreCancion());
		
		vista.lblNombre9.setText(artistas.get(8).getNombre() + " " + artistas.get(8).getApellidos());
		vista.lblCancion9.setText(artistas.get(8).getNombreCancion());
		
		vista.lblNombre10.setText(artistas.get(9).getNombre() + " " + artistas.get(9).getApellidos());
		vista.lblCancion10.setText(artistas.get(9).getNombreCancion());

		vista.lblIcono.setIcon(new ImageIcon("src/Imagenes/music.png"));
		vista.lblIcono2.setIcon(new ImageIcon("src/Imagenes/music.png"));
		vista.lblIcono3.setIcon(new ImageIcon("src/Imagenes/music.png"));
		vista.lblIcono4.setIcon(new ImageIcon("src/Imagenes/music.png"));
		vista.lblIcono5.setIcon(new ImageIcon("src/Imagenes/music.png"));
		vista.lblIcono6.setIcon(new ImageIcon("src/Imagenes/music.png"));
		vista.lblIcono7.setIcon(new ImageIcon("src/Imagenes/music.png"));
		vista.lblIcono8.setIcon(new ImageIcon("src/Imagenes/music.png"));
		vista.lblIcono9.setIcon(new ImageIcon("src/Imagenes/music.png"));
		vista.lblIcono10.setIcon(new ImageIcon("src/Imagenes/music.png"));
	}

	private ArrayList<String> recuperarNombres(Connection conexion2) {
		 ArrayList<String> nombres = new  ArrayList<String>();
		 String sentencia = "SELECT NOMBRE FROM USUARIO";

			Statement statement = null;
			ResultSet resultSet = null;
			try {
				statement = conexion.createStatement();
				resultSet = statement.executeQuery(sentencia);
				String nombre;
				while (resultSet.next()) {
					
					nombre = resultSet.getString("NOMBRE");
					
					nombres.add(nombre);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		return nombres;
	}

	private ArrayList<Artista> recuperarArtistas(Connection conexion) {
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		String sentencia = "SELECT DNI, NOMBRE, APELLIDOS, TELEFONO, NOMBRE_CANCION, VOTOS FROM CANTANTES";

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(sentencia);
			while (resultSet.next()) {
				Artista artista = new Artista();
				artista.setNombre(resultSet.getString("NOMBRE"));
				artista.setNombreCancion(resultSet.getString("NOMBRE_CANCION"));
				artista.setApellidos(resultSet.getString("APELLIDOS"));
				artistas.add(artista);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return artistas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vista.btnVotarAlba) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			artistaUsuario = "Alba";
			insertarUsuario();
			empezar();
		}
		if (e.getSource() == vista.btnVotarAmie) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			artistaUsuario = "Amie";
			insertarUsuario();
			empezar();
		}
		if (e.getSource() == vista.btnVotarElton) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			artistaUsuario = "Elton";
			insertarUsuario();
			empezar();
		}
		if (e.getSource() == vista.btnVotarJoel) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			artistaUsuario = "Joel";
			insertarUsuario();
			empezar();
		}
		if (e.getSource() == vista.btnVotarJulio) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			artistaUsuario = "Julio";
			insertarUsuario();
			empezar();
		}
		if (e.getSource() == vista.btnVotarMarc) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			artistaUsuario = "Marc";
			insertarUsuario();
			empezar();
		}
		if (e.getSource() == vista.btnVotarNahid) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			artistaUsuario = "Nahid";
			insertarUsuario();
			empezar();
		}
		if (e.getSource() == vista.btnVotarSarah) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			artistaUsuario = "Sarah";
			insertarUsuario();
			empezar();
		}
		if (e.getSource() == vista.btnVotarThiago) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			artistaUsuario = "Thiago";
			insertarUsuario();
			empezar();
		}
		if (e.getSource() == vista.btnVotarVictoria) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			artistaUsuario = "Victoria";
			insertarUsuario();
			empezar();
		}

		if (e.getSource() == vista.btnEmpezar) {
			vista.panelInicioSesion.setVisible(true);
			vista.PanelInicio.setVisible(false);

		} // end btn empezar

		if (e.getSource() == vista.continuar) {
			if(!vista.fieldNombre.getText().isEmpty()) {
				if(!nombresColeccion.contains(vista.fieldNombre.getText().toString())) {
			vista.panelComunidades.setVisible(true);
			vista.panelInicioSesion.setVisible(false);
			vista.lblErrorLogin.setVisible(false);
			vista.lblErrorLogin.setText("");
			nombreUsuario = vista.fieldNombre.getText().toString();
			edadUsuario = Integer.parseInt(vista.comboBox.getSelectedItem().toString());
				}else {
					vista.lblErrorLogin.setVisible(true);
					vista.lblErrorLogin.setText("ESTE USUARIO YA HA VOTADO");
				}
			}else {
				vista.lblErrorLogin.setVisible(true);
				vista.lblErrorLogin.setText("INTRODUCE UN NOMBRE");
			}
		}

		if (e.getSource() == vista.rdbtnAndalucia) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Andalucia";
		}
		if (e.getSource() == vista.rdbtnAragon) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Aragon";
		}
		if (e.getSource() == vista.rdbtnAsturias) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Asturias";
		}
		if (e.getSource() == vista.rdbtnBaleares) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Baleares";
		}
		if (e.getSource() == vista.rdbtnCanarias) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Canarias";
		}
		if (e.getSource() == vista.rdbtnCantabria) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Cantabria";
		}
		if (e.getSource() == vista.rdbtnCatalunya) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Cataluña";
		}
		if (e.getSource() == vista.rdbtnCeuta) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Ceuta";
		}
		if (e.getSource() == vista.rdbtnCLM) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Castilla-La Mancha";
		}
		if (e.getSource() == vista.rdbtnCYL) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Castilla y Leon";
		}
		if (e.getSource() == vista.rdbtnExtremadura) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Extremadura";
		}
		if (e.getSource() == vista.rdbtnGalicia) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Galicia";
		}
		if (e.getSource() == vista.rdbtnLaRioja) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "La Rioja";
		}
		if (e.getSource() == vista.rdbtnMadrid) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Madrid";
		}
		if (e.getSource() == vista.rdbtnMelilla) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Melilla";
		}
		if (e.getSource() == vista.rdbtnMurcia) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Murcia";
		}
		if (e.getSource() == vista.rdbtnNavarra) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Navarra";
		}
		if (e.getSource() == vista.rdbtnPaisVasco) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Pais Vasco";
		}
		if (e.getSource() == vista.rdbtnValencia) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			comunidadUsuario = "Valencia";
		}
		if (e.getSource() == vista.timer) {
			vista.lblTimer.setText(String.valueOf(numero));
			numero = numero - 1;
			// numero2 = numero2 + 20;
			// System.out.println(numero2);

			// vista.progressBar.setValue(numero2);

			if (numero < 0) {
				vista.timer.stop();
				vista.panelResultados.setVisible(true);
				vista.panelProceso.setVisible(false);
			}
		}

		if (e.getSource() == vista.btnComunidad) {
			selector = 1;
			if (selector == 0) {
				mostrarResultadosGenerales();
			} else if (selector == 1) {
				vista.panel3primeros.setVisible(false);
				vista.btnTodo.setVisible(false);
				vista.comboFiltro.setVisible(true);
				vista.comboFiltro.removeAllItems();
				llenarFiltrosComunidad();

			}
		}
		
		if(e.getSource()== vista.btnRangoEdad) {
			selector =2;
			if(selector == 2) {
				vista.panel3primeros.setVisible(false);
				vista.btnTodo.setVisible(false);
				vista.comboFiltro.setVisible(true);
				vista.comboFiltro.removeAllItems();
				llenarFiltrosEdad();
				
			}
		}
		
		if (e.getSource() == vista.comboFiltro) {
			String filtro;
			try {
				filtro = vista.comboFiltro.getSelectedItem().toString();
				if (filtro.equals("Andalucia")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosAndaluces).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Aragon")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosAragoneses).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Asturias")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosAsturianos).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Baleares")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosBaleares).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Canarias")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosCanarios).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Cantabria")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosCantabricos).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Castilla y Leon")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosCYL).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Castilla-La Mancha")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosCLM).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Cataluña")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosCatalanes).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Valencia")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosValencianos).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Extremadura")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosExtremeños).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Galicia")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosGallegos).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Madrid")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosMadrileños).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Murcia")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosMurcianos).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Navarra")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosNavarra).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Pais Vasco")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosVascos).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("La Rioja")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosRioja).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Ceuta")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosCeuta).reversed());
					mostrarResultadosGenerales();
				}
				if (filtro.equals("Melilla")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosMelilla).reversed());
					mostrarResultadosGenerales();
				}
				//-------------------------------------------------------
				//-------------------------------------------------------
				//-------------------------------------------------------
				//-------------------------------------------------------
				if(filtro.equals("Rango 18 a 25")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getRango18_25).reversed());
					mostrarResultadosGenerales();
				}if(filtro.equals("Rango 26 a 40")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getRango26_40).reversed());
					mostrarResultadosGenerales();
				}if(filtro.equals("Rango 41 a 65")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getRango41_65).reversed());
					mostrarResultadosGenerales();
				}if(filtro.equals("Rango 66 o mayor")) {
					Collections.sort(artistas, Comparator.comparingInt(Artista::getRango66mas).reversed());
					mostrarResultadosGenerales();
				}
			} catch (NullPointerException w) {
				filtro = "";
			}
		}
		if (e.getSource() == vista.btnGenerales) {
			selector = 0;
			if (selector == 0) {
				Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosTotales).reversed());
				mostrarResultadosGenerales();
				vista.comboFiltro.removeAllItems();
				vista.panel3primeros.setVisible(true);
				vista.comboFiltro.setVisible(false);
				vista.btnTodo.setVisible(true);
			}
		}
		if(e.getSource() == vista.btnTodo) {
			vista.panel3primeros.setVisible(false);
		}
		

	}// end action listener

	public void llenarFiltrosComunidad() {
		vista.comboFiltro.addItem("Andalucia");
		vista.comboFiltro.addItem("Aragon");
		vista.comboFiltro.addItem("Asturias");
		vista.comboFiltro.addItem("Baleares");
		vista.comboFiltro.addItem("Canarias");
		vista.comboFiltro.addItem("Cantabria");
		vista.comboFiltro.addItem("Castilla y Leon");
		vista.comboFiltro.addItem("Castilla-La Mancha");
		vista.comboFiltro.addItem("Cataluña");
		vista.comboFiltro.addItem("Valencia");
		vista.comboFiltro.addItem("Extremadura");
		vista.comboFiltro.addItem("Galicia");
		vista.comboFiltro.addItem("Madrid");
		vista.comboFiltro.addItem("Murcia");
		vista.comboFiltro.addItem("Navarra");
		vista.comboFiltro.addItem("Pais Vasco");
		vista.comboFiltro.addItem("La Rioja");
		vista.comboFiltro.addItem("Ceuta");
		vista.comboFiltro.addItem("Melilla");
	}
	
	public void llenarFiltrosEdad() {
		vista.comboFiltro.addItem("Rango 18 a 25");
		vista.comboFiltro.addItem("Rango 26 a 40");
		vista.comboFiltro.addItem("Rango 41 a 65");
		vista.comboFiltro.addItem("Rango 66 o mayor");

	}

	private int contadorTotal(int[] habitantes) {
		int contador = 0;
		for (int i = 0; i < habitantes.length; i++) {
			contador += habitantes[i];
		}
		contador = contador - habitantes[0] - habitantes[1];
		return contador;
	}

	private Connection crearConexion() throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		Properties propiedades = new Properties();
		try {
			propiedades.load(new FileReader("src/Modelo/database.properties"));
			String driver = propiedades.getProperty("database.driver");
			String url = propiedades.getProperty("database.url");
			String usuario = propiedades.getProperty("database.user");
			String contrasenia = propiedades.getProperty("database.password");
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, usuario, contrasenia);
			conexion.setAutoCommit(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conexion;
	}// end crear conexion

	private static int[] recuperarHabitantes(String comunidad, Connection conexion) {
		int[] aux = new int[7];
		double[] porcentajes = new double[6];
		int[] habitantes = new int[6];
		String sentencia = "SELECT RANGO_1_9, RANGO_10_17, RANGO_18_25, RANGO_26_40, RANGO_41_65, RANGO_MAS_66, TOTAL_HABITANTES\r\n"
				+ "FROM PORCENTAJES_RANGOEDAD\r\n" + "WHERE NOMBRE_COMUNIDAD LIKE ?";
		PreparedStatement statement = null;
		Statement statement2 = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		try {
			statement = conexion.prepareStatement(sentencia);
			statement.setString(1, comunidad);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				aux[0] = resultSet.getInt("RANGO_1_9");
				aux[1] = resultSet.getInt("RANGO_10_17");
				aux[2] = resultSet.getInt("RANGO_18_25");
				aux[3] = resultSet.getInt("RANGO_26_40");
				aux[4] = resultSet.getInt("RANGO_41_65");
				aux[5] = resultSet.getInt("RANGO_MAS_66");
				aux[6] = resultSet.getInt("TOTAL_HABITANTES");
			}
			// PARTE 2 -------------------------------------------------------
			// ---------------------------------------------------------------

			sentencia = "SELECT PORCENTAJE\r\n" + "FROM PORCENTAJE_VOTACION_RANGO";
			statement2 = conexion.createStatement();
			resultSet2 = statement2.executeQuery(sentencia);
			int contador = 0;
			while (resultSet2.next()) {
				porcentajes[contador] = resultSet2.getDouble("PORCENTAJE");
				contador++;
			}
			// PARTE 3-------------------------------------------------------
			// --------------------------------------------------------------
			for (int i = 0; i < porcentajes.length; i++) {
				habitantes[i] = (aux[i] * aux[6]) / 100;
				habitantes[i] = (int) (habitantes[i] * porcentajes[i]) / 100;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return habitantes;
	}//

	public void llenarComboBox() {
		int limite = 2005;
		for (int i = limite; i > 1930; i--) {
			vista.comboBox.addItem(String.valueOf(i));
		}
	}

	public void empezar() {

		vista.timer.start();
		// Generacion andaluces
		for (int i = 0; i < votantesAndalucia; i++) {
			Ciudadano andaluz = new Ciudadano("Andalucia", habitantesAndalucia, artistas);
			andaluz.start();
		}
		for (int i = 0; i < votantesAragon; i++) {
			Ciudadano arag = new Ciudadano("Aragon", habitantesAragon, artistas);
			arag.start();
		}
		for (int i = 0; i < votantesAsturias; i++) {
			Ciudadano ast = new Ciudadano("Asturias", habitantesAsturias, artistas);
			ast.start();
		}
		for (int i = 0; i < votantesBaleares; i++) {
			Ciudadano bal = new Ciudadano("Baleares", habitantesBaleares, artistas);
			bal.start();
		}
		for (int i = 0; i < votantesCanarias; i++) {
			Ciudadano can = new Ciudadano("Canarias", habitantesCanarias, artistas);
			can.start();
		}
		for (int i = 0; i < votantesCantabria; i++) {
			Ciudadano cant = new Ciudadano("Cantabria", habitantesCantabria, artistas);
			cant.start();
		}
		for (int i = 0; i < votantesCatalunia; i++) {
			Ciudadano cat = new Ciudadano("Cataluña", habitantesCatalunia, artistas);
			cat.start();
		}
		for (int i = 0; i < votantesCeuta; i++) {
			Ciudadano ceu = new Ciudadano("Ceuta", habitantesCeuta, artistas);
			ceu.start();
		}
		for (int i = 0; i < votantesCLM; i++) {
			Ciudadano clm = new Ciudadano("CLM", habitantesCLM, artistas);
			clm.start();
		}
		for (int i = 0; i < votantesCYL; i++) {
			Ciudadano cyl = new Ciudadano("CYL", habitantesCYL, artistas);
			cyl.start();
		}
		for (int i = 0; i < votantesExtremadura; i++) {
			Ciudadano ex = new Ciudadano("Extremadura", habitantesExtremadura, artistas);
			ex.start();
		}
		for (int i = 0; i < votantesGalicia; i++) {
			Ciudadano gal = new Ciudadano("Galicia", habitantesGalicia, artistas);
			gal.start();
		}
		for (int i = 0; i < votantesMadrid; i++) {
			Ciudadano mad = new Ciudadano("Madrid", habitantesMadrid, artistas);
			mad.start();
		}
		for (int i = 0; i < votantesMelilla; i++) {
			Ciudadano mel = new Ciudadano("Melilla", habitantesMelilla, artistas);
			mel.start();
		}
		for (int i = 0; i < votantesMurcia; i++) {
			Ciudadano mur = new Ciudadano("Murcia", habitantesMurcia, artistas);
			mur.start();
		}
		for (int i = 0; i < votantesNavarra; i++) {
			Ciudadano nav = new Ciudadano("Navarra", habitantesNavarra, artistas);
			nav.start();
		}
		for (int i = 0; i < votantesRioja; i++) {
			Ciudadano rio = new Ciudadano("Rioja", habitantesRioja, artistas);
			rio.start();
		}
		for (int i = 0; i < votantesValencia; i++) {
			Ciudadano val = new Ciudadano("Valencia", habitantesValencia, artistas);
			val.start();
		}
		for (int i = 0; i < votantesVascos; i++) {
			Ciudadano vas = new Ciudadano("Pais Vasco", habitantesVascos, artistas);
			vas.start();
		}
		
		//
		contarVotosTotales();
		
		//
		if (selector == 0) {
			Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosTotales).reversed());
			mostrarResultadosGenerales();
			vista.foto1_1.setIcon(new ImageIcon(artistas.get(0).getUrlFoto()));
			vista.foto2_1.setIcon(new ImageIcon(artistas.get(1).getUrlFoto()));
			vista.foto3_1.setIcon(new ImageIcon(artistas.get(2).getUrlFoto()));
			vista.nombre1_1.setText(artistas.get(0).getNombre());
			vista.nombre2_1.setText(artistas.get(1).getNombre());
			vista.nombre3_1.setText(artistas.get(2).getNombre());
			
		}
	}

	public void contarVotosTotales() {
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosAndaluces).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosAragoneses).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosAsturianos).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);

		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosAndaluces).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosBaleares).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosCanarios).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosCantabricos).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosCatalanes).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosCeuta).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosCLM).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosCYL).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosExtremeños).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosValencianos).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosGallegos).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosMadrileños).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosMurcianos).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosNavarra).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosVascos).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosRioja).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosMelilla).reversed());
		artistas.get(0).setVotosTotales(artistas.get(0).getVotosTotales()+15);
		artistas.get(1).setVotosTotales(artistas.get(1).getVotosTotales()+10);
		artistas.get(2).setVotosTotales(artistas.get(2).getVotosTotales()+8);
		
		
		
		
		
		
		
	}

	public void mostrarResultadosGenerales() {

		vista.nombre1.setText(artistas.get(0).getNombre());
		vista.foto1.setIcon(new ImageIcon(artistas.get(0).getUrlFoto()));
		vista.primerPuesto.setIcon(new ImageIcon("src/Imagenes/1.png"));

		vista.nombre2.setText(artistas.get(1).getNombre());
		vista.foto2.setIcon(new ImageIcon(artistas.get(1).getUrlFoto()));
		vista.segundoPuesto.setIcon(new ImageIcon("src/Imagenes/2.png"));

		vista.nombre3.setText(artistas.get(2).getNombre());
		vista.foto3.setIcon(new ImageIcon(artistas.get(2).getUrlFoto()));
		vista.tercerPuesto.setIcon(new ImageIcon("src/Imagenes/3.png"));

		vista.nombre4.setText(artistas.get(3).getNombre());
		vista.foto4.setIcon(new ImageIcon(artistas.get(3).getUrlFoto()));
		vista.cuartoPuesto.setIcon(new ImageIcon("src/Imagenes/4.png"));

		vista.nombre5.setText(artistas.get(4).getNombre());
		vista.foto5.setIcon(new ImageIcon(artistas.get(4).getUrlFoto()));
		vista.quintoPuesto.setIcon(new ImageIcon("src/Imagenes/5.png"));

		vista.nombre6.setText(artistas.get(5).getNombre());
		vista.foto6.setIcon(new ImageIcon(artistas.get(5).getUrlFoto()));
		vista.sextoPuesto.setIcon(new ImageIcon("src/Imagenes/6.png"));

		vista.nombre7.setText(artistas.get(6).getNombre());
		vista.foto7.setIcon(new ImageIcon(artistas.get(6).getUrlFoto()));
		vista.septimoPuesto.setIcon(new ImageIcon("src/Imagenes/7.png"));

		vista.nombre8.setText(artistas.get(7).getNombre());
		vista.foto8.setIcon(new ImageIcon(artistas.get(7).getUrlFoto()));
		vista.octavoPuesto.setIcon(new ImageIcon("src/Imagenes/8.png"));

		vista.nombre9.setText(artistas.get(8).getNombre());
		vista.foto9.setIcon(new ImageIcon(artistas.get(8).getUrlFoto()));
		vista.novenoPuesto.setIcon(new ImageIcon("src/Imagenes/9.png"));

		vista.nombre10.setText(artistas.get(9).getNombre());
		vista.foto10.setIcon(new ImageIcon(artistas.get(9).getUrlFoto()));
		vista.decimoPuesto.setIcon(new ImageIcon("src/Imagenes/10.png"));
		for(int i = 0; i<artistas.size();i++) {
			System.out.println(artistas.get(i).toString());
		}
		for(int i = 0; i<artistas.size(); i++) {
	updates(artistas.get(i).getVotosTotales(), artistas.get(i).getNombre(), conexion);
		}

	}//end de algo no borrar
	private void updates(int votos, String nombre, Connection conexion) {
		String sentencia = "UPDATE CANTANTES SET VOTOS = ? WHERE NOMBRE = ?";
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = conexion.prepareStatement(sentencia);
			preparedStatement.setInt(1, votos);
			preparedStatement.setString(2, nombre);
			preparedStatement.executeUpdate();

			conexion.commit();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void insertarUsuario() {
		String sentencia = "INSERT INTO USUARIO(NOMBRE, COMUNIDAD, EDAD, ARTISTA) VALUES (?,?,?,?)";
		PreparedStatement prepared = null;
		try {
			prepared = conexion.prepareStatement(sentencia);
			prepared.setString(1, nombreUsuario);
			prepared.setString(2, comunidadUsuario);
			prepared.setInt(3, edadUsuario);
			prepared.setString(4, artistaUsuario);
			prepared.executeUpdate();
			conexion.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}// end controlador
