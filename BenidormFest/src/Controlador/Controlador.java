package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Vista.Vista;



	public class Controlador implements ActionListener{
		
		public Vista vista = new Vista();

		public Controlador (Vista vista) throws IOException, ClassNotFoundException, SQLException, UnsupportedAudioFileException, LineUnavailableException {
			this.vista = vista;
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}


