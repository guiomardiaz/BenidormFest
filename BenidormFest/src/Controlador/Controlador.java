package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
			
			double[] numEdades = recuperar1();
			
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

		

		private double[] recuperar1() {
			double[] edades = new double[6];
			
			return edades;
		}
		
	}//end controlador


