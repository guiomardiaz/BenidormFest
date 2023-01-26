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
import java.util.Properties;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Vista.Vista;



	public class Controlador implements ActionListener{
		
		public Vista vista = new Vista();
		public Connection conexion;
		

		public Controlador (Vista vista) throws IOException, ClassNotFoundException, SQLException, UnsupportedAudioFileException, LineUnavailableException {
			this.vista = vista;
			vista.btnEmpezar.addActionListener(this);
			conexion = crearConexion();
			
			System.out.println("Conexion realizada");
			
			int[] habitantesAndalucia= recuperarHabitantes("Andalucia", conexion); 
			for(int i = 0; i<habitantesAndalucia.length; i++) {
			System.out.println(habitantesAndalucia[i]);
			}
			
		}




		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== vista.btnEmpezar) {
				
			}//end btn empezar
		}//end action listener
		
		
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
		}//end crear conexion

		
		private static int[] recuperarHabitantes(String comunidad, Connection conexion) {
			int[] aux = new int[7];
			double[] porcentajes = new double[6];
			int[] habitantes = new int[6];
			String sentencia = "SELECT RANGO_1_9, RANGO_10_17, RANGO_18_25, RANGO_26_40, RANGO_41_65, RANGO_MAS_66, TOTAL_HABITANTES\r\n"
					+ "FROM PORCENTAJES_RANGOEDAD\r\n"
					+ "WHERE NOMBRE_COMUNIDAD LIKE ?";
			PreparedStatement statement = null;
			Statement statement2 = null;
			ResultSet resultSet = null;
			ResultSet resultSet2 = null;
			try {
				statement = conexion.prepareStatement(sentencia);
				statement.setString(1, comunidad);
				resultSet = statement.executeQuery();
				if(resultSet.next()) {
					aux[0]= resultSet.getInt("RANGO_1_9");
					aux[1]= resultSet.getInt("RANGO_10_17");
					aux[2]= resultSet.getInt("RANGO_18_25");
					aux[3]= resultSet.getInt("RANGO_26_40");
					aux[4]= resultSet.getInt("RANGO_41_65");
					aux[5]= resultSet.getInt("RANGO_MAS_66");
					aux[6]= resultSet.getInt("TOTAL_HABITANTES");
				}
				//PARTE 2 -------------------------------------------------------
				//---------------------------------------------------------------
				
				sentencia = "SELECT PORCENTAJE\r\n"
						+ "FROM PORCENTAJE_VOTACION_RANGO";
				statement2 = conexion.createStatement();
				resultSet2 = statement2.executeQuery(sentencia);
				int contador=0;
				while (resultSet2.next()) {
					porcentajes[contador] = resultSet2.getDouble("PORCENTAJE");
					contador++;
				}
				//PARTE 3-------------------------------------------------------
				//--------------------------------------------------------------
				for(int i = 0; i<porcentajes.length; i++) {
					habitantes[i] =  (aux[i]*aux[6])/100;
					habitantes[i] = (int) (habitantes[i]*porcentajes[i]);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return habitantes;
		}

		
	}//end controlador


