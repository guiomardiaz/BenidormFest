package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
			
		}

		

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== vista.btnEmpezar) {
				
			}//end btn empezar
		}//end action listener
		
		
		private Connection crearConexion() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}//end controlador


