package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	public ArrayList<Artista> artistas = new ArrayList<Artista>();

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
		
		this.vista.timer.addActionListener(this);
		
		
		llenarComboBox();
		vista.panelInicioSesion.setVisible(false);
		vista.panelComunidades.setVisible(false);
		vista.panelArtistas.setVisible(false);
		vista.panelProceso.setVisible(false);
		vista.panelResultados.setVisible(false);

		conexion = crearConexion();

		System.out.println("Conexion realizada");

		// Creacion de artistas
		artistas.add(new Artista("Joel"));
		artistas.add(new Artista("Victoria"));
		artistas.add(new Artista("Thiago"));
		artistas.add(new Artista("Sarah"));
		artistas.add(new Artista("Elton"));
		artistas.add(new Artista("Amie"));
		artistas.add(new Artista("Nahid"));
		artistas.add(new Artista("Marc"));
		artistas.add(new Artista("Alba"));
		artistas.add(new Artista("Julio"));

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

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == vista.btnVotarAlba) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			empezar();
		}
		if (e.getSource() == vista.btnVotarAmie) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			empezar();
		}
		if (e.getSource() == vista.btnVotarElton) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			empezar();
		}
		if (e.getSource() == vista.btnVotarJoel) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			empezar();
		}
		if (e.getSource() == vista.btnVotarJulio) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			empezar();
		}
		if (e.getSource() == vista.btnVotarMarc) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			empezar();
		}
		if (e.getSource() == vista.btnVotarNahid) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			empezar();
		}
		if (e.getSource() == vista.btnVotarSarah) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			empezar();
		}
		if (e.getSource() == vista.btnVotarThiago) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			empezar();
		}
		if (e.getSource() == vista.btnVotarVictoria) {
			vista.panelProceso.setVisible(true);
			vista.panelArtistas.setVisible(false);
			empezar();
		}
		
		if (e.getSource() == vista.btnEmpezar) {
			vista.panelInicioSesion.setVisible(true);
			vista.PanelInicio.setVisible(false);

		} // end btn empezar

		if (e.getSource() == vista.continuar) {
			vista.panelComunidades.setVisible(true);
			vista.panelInicioSesion.setVisible(false);
		}
		
		if (e.getSource()== vista.rdbtnAndalucia) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			
		}
		if (e.getSource()== vista.rdbtnAragon) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			
		}
		if (e.getSource()== vista.rdbtnAsturias) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			
		}
		if (e.getSource()== vista.rdbtnBaleares) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			
		}
		if (e.getSource()== vista.rdbtnCanarias) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
			
		}
		if (e.getSource()== vista.rdbtnCantabria) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
		}
		if (e.getSource()== vista.rdbtnCatalunya) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
		}
		if (e.getSource()== vista.rdbtnCeuta) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
		}
		if (e.getSource()== vista.rdbtnCLM) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
		}
		if (e.getSource()== vista.rdbtnCYL) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
		}
		if (e.getSource()== vista.rdbtnExtremadura) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
		}
		if (e.getSource()== vista.rdbtnGalicia) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
		}
		if (e.getSource()== vista.rdbtnLaRioja) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
		}
		if (e.getSource()== vista.rdbtnMadrid) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
		}
		if (e.getSource()== vista.rdbtnMelilla) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
		}
		if (e.getSource()== vista.rdbtnMurcia) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
		}
		if (e.getSource()== vista.rdbtnNavarra) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
		}
		if (e.getSource()== vista.rdbtnPaisVasco) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
		}
		if (e.getSource()== vista.rdbtnValencia) {
			vista.panelArtistas.setVisible(true);
			vista.panelComunidades.setVisible(false);
		}
		if (e.getSource() == vista.timer) {
            vista.lblTimer.setText(String.valueOf(numero));
            numero = numero - 1;
            if (numero < 0) {
                vista.timer.stop();
               vista.panelResultados.setVisible(true);
               vista.panelProceso.setVisible(false);
            }
            }
		
		
		
		
		
		
	}// end action listener

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
		int limite = 2023;
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
		
		mostrarResultados();
		
	}
	
	public void mostrarResultados() {
		Collections.sort(artistas, Comparator.comparingInt(Artista::getVotosTotales));
		vista.nombre1.setText(artistas.get(9).getNombre());
		for(int i = 0; i<artistas.size();i++) {
			System.out.println(artistas.get(i).toString());
		}
	}

}// end controlador
