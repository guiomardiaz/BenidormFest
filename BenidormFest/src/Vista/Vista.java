package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JLabel;
import javax.print.attribute.AttributeSetUtilities;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {

	public JPanel contentPane, PanelInicio, panelInicioSesion, panelComunidades, panelArtistas, panelProceso,
			panelResultados;
	public JButton btnEmpezar, continuar, btnVotarJoel, btnVotarVictoria, btnVotarThiago, btnVotarSarah, btnVotarElton,
			btnVotarAmie, btnVotarNahid, btnVotarMarc, btnVotarAlba, btnVotarJulio, btnGenerales, btnComunidad,
			btnRangoEdad;
	public JLabel lblTimer, lblNewLabel, lblNewLabel_1, lblNombre5, lblEspana, lblFondo, lblLogin, lblFondo2, lblFondo3,
			lblLoading, lblNewLabel_2, foto1, nombre1, primerPuesto, nombre2, foto2, tercerPuesto, nombre3, foto3,
			cuartoPuesto, nombre4, foto4, nombre5, quintoPuesto, foto5, segundoPuesto, sextoPuesto, nombre6, foto6,
			septimoPuesto, foto7, nombre7, octavoPuesto, nombre8, foto8, novenoPuesto, nombre9, foto9, nombre10,
			lblNewLabel_5, decimoPuesto, foto10, lblNewLabel_3, lblBorde2, lblBorde3, lblNewLabel_4, lblFondoFinal,
			lblNombre4, lblNombre3, lblCancion3, lblNombre2, lblCancion2, lblCancion5, lblCancion4, lblCancion1,
			lblNombre1, lblNombre6, lblCancion6, lblNombre7, lblCancion7, lblNombre8, lblCancion8, lblNombre9,
			lblIcono3, lblIcono4, lblIcono5, lblIcono6, lblIcono7, lblIcono8, lblIcono9, lblIcono10, lblCancion9,
			lblNombre10, lblCancion10, lblIcono, lblIcono2, lblErrorLogin;
	public JTextField fieldNombre;
	public JComboBox comboBox, comboFiltro;
	public JRadioButton rdbtnAsturias, rdbtnMelilla, rdbtnCantabria, rdbtnPaisVasco, rdbtnNavarra, rdbtnAragon,
			rdbtnCatalunya, rdbtnCYL, rdbtnMadrid, rdbtnCLM, rdbtnExtremadura, rdbtnValencia, rdbtnAndalucia,
			rdbtnMurcia, rdbtnLaRioja, rdbtnBaleares, rdbtnCanarias, rdbtnCeuta, rdbtnGalicia;

	public Timer timer;
	public JProgressBar progressBar;
	private JLabel lblIconoP4;
	private JLabel lblIconoP3;
	private JLabel lblIconoP5;
	private JLabel lblIconoP2;
	private JLabel lblIconoP1;
	private JLabel lblIconoP10;
	private JLabel lblIconoP8;
	private JLabel lblIconoP9;
	private JLabel lblIconoP7;
	private JLabel lblIconoP6;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
					Controlador controlador = new Controlador(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 673);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				panelInicioSesion = new JPanel();
				panelInicioSesion.setBounds(0, 0, 1138, 636);
				contentPane.add(panelInicioSesion);
				panelInicioSesion.setLayout(null);
						
								 lblErrorLogin = new JLabel("");
								lblErrorLogin.setBounds(418, 342, 301, 31);
								lblErrorLogin.setForeground(new Color(128, 64, 64));
								panelInicioSesion.add(lblErrorLogin);
				
						JLabel lblBorde = new JLabel("");
						lblBorde.setBounds(309, 57, 491, 471);
						Border border15 =  BorderFactory.createLineBorder(Color.WHITE, 2);
						lblBorde.setBorder(border15);
						panelInicioSesion.add(lblBorde);
						
								JCheckBox chckbxNewCheckBox = new JCheckBox("Recuerdame en este diapositivo");
								chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
								chckbxNewCheckBox.setBackground(new Color(0, 115, 170));
								chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
								chckbxNewCheckBox.setBounds(408, 313, 286, 23);
								panelInicioSesion.add(chckbxNewCheckBox);
								
										lblLogin = new JLabel("LOGIN");
										lblLogin.setForeground(new Color(255, 255, 255));
										lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
										lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 26));
										lblLogin.setBounds(488, 103, 136, 40);
										panelInicioSesion.add(lblLogin);
										
												JLabel lblNombre = new JLabel("Username");
												lblNombre.setForeground(new Color(255, 255, 255));
												lblNombre.setBounds(398, 213, 96, 31);
												lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
												lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 19));
												panelInicioSesion.add(lblNombre);
												
														fieldNombre = new JTextField();
														fieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
														fieldNombre.setBounds(584, 213, 145, 31);
														fieldNombre.setColumns(10);
														fieldNombre.setToolTipText("Introduce tu nombre");
														panelInicioSesion.add(fieldNombre);
														
																JLabel lblContrasea = new JLabel("Año nacimiento");
																lblContrasea.setForeground(new Color(255, 255, 255));
																lblContrasea.setBounds(355, 254, 183, 31);
																lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
																lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 19));
																panelInicioSesion.add(lblContrasea);
																
																		continuar = new JButton("INICIAR SESION");
																		continuar.setBackground(new Color(189, 219, 233));
																		continuar.setBounds(453, 432, 202, 46);
																		continuar.setFont(new Font("Tahoma", Font.BOLD, 16));
																		panelInicioSesion.add(continuar);
																		
																				comboBox = new JComboBox();
																				comboBox.setBounds(584, 254, 145, 31);
																				panelInicioSesion.add(comboBox);
																						
																								lblFondo = new JLabel("");
																								lblFondo.setBounds(0, 0, 1128, 626);
																								panelInicioSesion.add(lblFondo);
																								lblFondo.setIcon(new ImageIcon("src/Imagenes/fondo.jpg"));

		panelArtistas = new JPanel();
		panelArtistas.setBounds(0, 0, 1138, 626);
		contentPane.add(panelArtistas);
		panelArtistas.setLayout(null);
		
		lblIconoP7 = new JLabel("");
		lblIconoP7.setBounds(271, 305, 45, 34);
		lblIconoP7.setIcon(new ImageIcon("src/Imagenes/m.png"));
		panelArtistas.add(lblIconoP7);
		
		lblIconoP6 = new JLabel("");
		lblIconoP6.setBounds(42, 305, 45, 34);
		lblIconoP6.setIcon(new ImageIcon("src/Imagenes/m.png"));
		panelArtistas.add(lblIconoP6);
		
		lblIconoP8 = new JLabel("");
		lblIconoP8.setBounds(506, 305, 45, 34);
		lblIconoP8.setIcon(new ImageIcon("src/Imagenes/h.png"));
		panelArtistas.add(lblIconoP8);
		
		lblIconoP10 = new JLabel("");
		lblIconoP10.setBounds(940, 305, 45, 34);
		lblIconoP10.setIcon(new ImageIcon("src/Imagenes/h.png"));
		panelArtistas.add(lblIconoP10);
		
		lblIconoP9 = new JLabel("");
		lblIconoP9.setBounds(721, 305, 45, 34);
		lblIconoP9.setIcon(new ImageIcon("src/Imagenes/m.png"));
		panelArtistas.add(lblIconoP9);
		
		
		lblIconoP5 = new JLabel("");
		lblIconoP5.setBounds(940, 15, 45, 34);
		panelArtistas.add(lblIconoP5);
		lblIconoP5.setIcon(new ImageIcon("src/Imagenes/h.png"));
		
		lblIconoP3 = new JLabel("");
		lblIconoP3.setBounds(495, 15, 45, 34);
		panelArtistas.add(lblIconoP3);
		lblIconoP3.setIcon(new ImageIcon("src/Imagenes/h.png"));
		
		lblIconoP4 = new JLabel("");
		lblIconoP4.setBounds(721, 15, 45, 34);
		panelArtistas.add(lblIconoP4);
		lblIconoP4.setIcon(new ImageIcon("src/Imagenes/m.png"));
		
		lblIconoP2 = new JLabel("");
		lblIconoP2.setBounds(271, 15, 45, 34);
		panelArtistas.add(lblIconoP2);
		lblIconoP2.setIcon(new ImageIcon("src/Imagenes/m.png"));
		
		lblIconoP1 = new JLabel("");
		lblIconoP1.setBounds(47, 15, 45, 34);
		panelArtistas.add(lblIconoP1);
		lblIconoP1.setIcon(new ImageIcon("src/Imagenes/h.png"));

		lblIcono10 = new JLabel("");
		lblIcono10.setBounds(945, 456, 45, 34);
		panelArtistas.add(lblIcono10);

		lblIcono7 = new JLabel("");
		lblIcono7.setBounds(259, 456, 45, 34);
		panelArtistas.add(lblIcono7);

		lblIcono6 = new JLabel("");
		lblIcono6.setBounds(21, 456, 45, 34);
		panelArtistas.add(lblIcono6);

		lblIcono9 = new JLabel("");
		lblIcono9.setBounds(709, 456, 45, 34);
		panelArtistas.add(lblIcono9);

		lblIcono8 = new JLabel("");
		lblIcono8.setBounds(483, 456, 45, 34);
		panelArtistas.add(lblIcono8);

		lblIcono4 = new JLabel("");
		lblIcono4.setBounds(697, 166, 45, 34);
		panelArtistas.add(lblIcono4);

		lblIcono3 = new JLabel("");
		lblIcono3.setBounds(471, 166, 45, 34);
		panelArtistas.add(lblIcono3);

		lblIcono5 = new JLabel("");
		lblIcono5.setBounds(921, 166, 45, 34);
		panelArtistas.add(lblIcono5);

		lblIcono2 = new JLabel("");
		lblIcono2.setBounds(247, 166, 45, 34);
		panelArtistas.add(lblIcono2);

		lblIcono = new JLabel("");
		lblIcono.setBounds(10, 166, 45, 34);
		panelArtistas.add(lblIcono);

		lblNombre8 = new JLabel("");
		lblNombre8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre8.setForeground(Color.WHITE);
		lblNombre8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre8.setBounds(515, 312, 124, 21);
		panelArtistas.add(lblNombre8);

		lblCancion9 = new JLabel("");
		lblCancion9.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancion9.setForeground(Color.WHITE);
		lblCancion9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCancion9.setBounds(719, 456, 157, 34);
		panelArtistas.add(lblCancion9);

		lblCancion10 = new JLabel("");
		lblCancion10.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancion10.setForeground(Color.WHITE);
		lblCancion10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCancion10.setBounds(946, 456, 157, 34);
		panelArtistas.add(lblCancion10);

		lblNombre10 = new JLabel("");
		lblNombre10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre10.setForeground(Color.WHITE);
		lblNombre10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre10.setBounds(960, 312, 124, 21);
		panelArtistas.add(lblNombre10);

		lblCancion8 = new JLabel("");
		lblCancion8.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancion8.setForeground(Color.WHITE);
		lblCancion8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCancion8.setBounds(501, 456, 157, 34);
		panelArtistas.add(lblCancion8);

		lblNombre9 = new JLabel("");
		lblNombre9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre9.setForeground(Color.WHITE);
		lblNombre9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre9.setBounds(733, 312, 124, 21);
		panelArtistas.add(lblNombre9);

		lblCancion7 = new JLabel("");
		lblCancion7.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancion7.setForeground(Color.WHITE);
		lblCancion7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCancion7.setBounds(279, 456, 157, 34);
		panelArtistas.add(lblCancion7);

		lblNombre7 = new JLabel("");
		lblNombre7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre7.setForeground(Color.WHITE);
		lblNombre7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre7.setBounds(293, 312, 124, 21);
		panelArtistas.add(lblNombre7);

		lblCancion6 = new JLabel("");
		lblCancion6.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancion6.setForeground(Color.WHITE);
		lblCancion6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCancion6.setBounds(47, 456, 157, 34);
		panelArtistas.add(lblCancion6);

		lblNombre6 = new JLabel("");
		lblNombre6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre6.setForeground(Color.WHITE);
		lblNombre6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre6.setBounds(61, 312, 124, 21);
		panelArtistas.add(lblNombre6);

		lblCancion1 = new JLabel("");
		lblCancion1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancion1.setForeground(Color.WHITE);
		lblCancion1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCancion1.setBounds(40, 166, 189, 34);
		panelArtistas.add(lblCancion1);

		lblNombre1 = new JLabel("");
		lblNombre1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre1.setForeground(Color.WHITE);
		lblNombre1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre1.setBounds(68, 22, 124, 21);
		panelArtistas.add(lblNombre1);

		lblCancion2 = new JLabel("");
		lblCancion2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancion2.setForeground(Color.WHITE);
		lblCancion2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCancion2.setBounds(279, 166, 157, 34);
		panelArtistas.add(lblCancion2);

		lblNombre2 = new JLabel("");
		lblNombre2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre2.setForeground(Color.WHITE);
		lblNombre2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre2.setBounds(293, 22, 124, 21);
		panelArtistas.add(lblNombre2);

		lblCancion3 = new JLabel("");
		lblCancion3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancion3.setForeground(Color.WHITE);
		lblCancion3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCancion3.setBounds(501, 166, 157, 34);
		panelArtistas.add(lblCancion3);

		lblNombre3 = new JLabel("");
		lblNombre3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre3.setForeground(Color.WHITE);
		lblNombre3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre3.setBounds(515, 22, 124, 21);
		panelArtistas.add(lblNombre3);

		lblNombre4 = new JLabel("");
		lblNombre4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre4.setForeground(Color.WHITE);
		lblNombre4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre4.setBounds(733, 22, 124, 21);
		panelArtistas.add(lblNombre4);

		lblCancion4 = new JLabel("");
		lblCancion4.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancion4.setForeground(Color.WHITE);
		lblCancion4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCancion4.setBounds(719, 166, 157, 34);
		panelArtistas.add(lblCancion4);

		lblCancion5 = new JLabel("");
		lblCancion5.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancion5.setForeground(Color.WHITE);
		lblCancion5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCancion5.setBounds(946, 166, 157, 34);
		panelArtistas.add(lblCancion5);

		lblNombre5 = new JLabel("");
		lblNombre5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre5.setForeground(new Color(255, 255, 255));
		lblNombre5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre5.setBounds(960, 22, 124, 21);
		panelArtistas.add(lblNombre5);

		JLabel lblFotoJoel = new JLabel("");
		lblFotoJoel.setBounds(83, 53, 90, 103);
		panelArtistas.add(lblFotoJoel);
		lblFotoJoel.setIcon(new ImageIcon("src/Imagenes/joel.png"));

		JLabel lblFotoVictoria = new JLabel("");
		lblFotoVictoria.setBounds(310, 53, 90, 103);
		panelArtistas.add(lblFotoVictoria);
		lblFotoVictoria.setIcon(new ImageIcon("src/Imagenes/victoria.png"));

		JLabel lblFotoThiago = new JLabel("");
		lblFotoThiago.setBounds(531, 53, 90, 103);
		panelArtistas.add(lblFotoThiago);
		lblFotoThiago.setIcon(new ImageIcon("src/Imagenes/thiago.png"));

		JLabel lblFotoSarah = new JLabel("");
		lblFotoSarah.setBounds(751, 53, 90, 103);
		panelArtistas.add(lblFotoSarah);
		lblFotoSarah.setIcon(new ImageIcon("src/Imagenes/sarah.png"));

		JLabel lblFotoElton = new JLabel("");
		lblFotoElton.setBounds(979, 53, 90, 103);
		panelArtistas.add(lblFotoElton);
		lblFotoElton.setIcon(new ImageIcon("src/Imagenes/elton.png"));

		btnVotarJoel = new JButton("VOTAR");
		btnVotarJoel.setBounds(88, 210, 85, 21);
		panelArtistas.add(btnVotarJoel);

		btnVotarVictoria = new JButton("VOTAR");
		btnVotarVictoria.setBounds(315, 210, 85, 21);
		panelArtistas.add(btnVotarVictoria);

		btnVotarThiago = new JButton("VOTAR");
		btnVotarThiago.setBounds(536, 210, 85, 21);
		panelArtistas.add(btnVotarThiago);

		btnVotarSarah = new JButton("VOTAR");
		btnVotarSarah.setBounds(756, 210, 85, 21);
		panelArtistas.add(btnVotarSarah);

		btnVotarElton = new JButton("VOTAR");
		btnVotarElton.setBounds(979, 210, 85, 21);
		panelArtistas.add(btnVotarElton);

		JLabel lblFotoAmie = new JLabel("");
		lblFotoAmie.setBounds(83, 341, 90, 103);
		panelArtistas.add(lblFotoAmie);
		lblFotoAmie.setIcon(new ImageIcon("src/Imagenes/amie.png"));

		JLabel lblFotoNahid = new JLabel("");
		lblFotoNahid.setBounds(310, 341, 90, 103);
		panelArtistas.add(lblFotoNahid);
		lblFotoNahid.setIcon(new ImageIcon("src/Imagenes/nahid.png"));

		JLabel lblFotoMarc = new JLabel("");
		lblFotoMarc.setBounds(531, 341, 90, 103);
		panelArtistas.add(lblFotoMarc);
		lblFotoMarc.setIcon(new ImageIcon("src/Imagenes/marc.png"));

		JLabel lblFotoAlba = new JLabel("");
		lblFotoAlba.setBounds(751, 341, 90, 103);
		panelArtistas.add(lblFotoAlba);
		lblFotoAlba.setIcon(new ImageIcon("src/Imagenes/alba.png"));

		JLabel lblFotoJulio = new JLabel("");
		lblFotoJulio.setBounds(979, 341, 90, 103);
		panelArtistas.add(lblFotoJulio);
		lblFotoJulio.setIcon(new ImageIcon("src/Imagenes/julio.png"));

		btnVotarAmie = new JButton("VOTAR");
		btnVotarAmie.setBounds(83, 507, 85, 21);
		panelArtistas.add(btnVotarAmie);

		btnVotarNahid = new JButton("VOTAR");
		btnVotarNahid.setBounds(315, 507, 85, 21);
		panelArtistas.add(btnVotarNahid);

		btnVotarMarc = new JButton("VOTAR");
		btnVotarMarc.setBounds(536, 507, 85, 21);
		panelArtistas.add(btnVotarMarc);

		btnVotarAlba = new JButton("VOTAR");
		btnVotarAlba.setBounds(756, 507, 85, 21);
		panelArtistas.add(btnVotarAlba);

		btnVotarJulio = new JButton("VOTAR");
		btnVotarJulio.setBounds(984, 507, 85, 21);
		panelArtistas.add(btnVotarJulio);

		lblFondo3 = new JLabel("");
		lblFondo3.setForeground(new Color(255, 255, 255));
		lblFondo3.setBounds(0, 0, 1138, 638);
		lblFondo3.setIcon(new ImageIcon("src/Imagenes/fondo2.jpg"));
		panelArtistas.add(lblFondo3);

		panelResultados = new JPanel();
		panelResultados.setBounds(0, 0, 1138, 636);
		contentPane.add(panelResultados);
		panelResultados.setLayout(null);

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(48, 140, 1035, 455);
		Border border8 = BorderFactory.createLineBorder(Color.WHITE, 2);

		comboFiltro = new JComboBox();
		comboFiltro.setBounds(830, 93, 115, 26);
		panelResultados.add(comboFiltro);
		lblNewLabel_5.setBorder(border8);
		panelResultados.add(lblNewLabel_5);

		btnRangoEdad = new JButton("Rango Edad");
		btnRangoEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRangoEdad.setBounds(652, 85, 121, 34);
		panelResultados.add(btnRangoEdad);

		btnComunidad = new JButton("Comunidad");
		btnComunidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComunidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnComunidad.setBounds(496, 85, 121, 34);
		panelResultados.add(btnComunidad);

		btnGenerales = new JButton("Generales");
		btnGenerales.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGenerales.setBounds(338, 85, 115, 34);
		panelResultados.add(btnGenerales);

		lblNewLabel_2 = new JLabel("RESULTADOS DE LAS VOTACIONES");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 28));
		lblNewLabel_2.setBounds(172, 21, 773, 54);
		panelResultados.add(lblNewLabel_2);

		foto1 = new JLabel("");
		foto1.setBounds(85, 209, 133, 116);
		panelResultados.add(foto1);

		nombre1 = new JLabel("");
		nombre1.setForeground(new Color(255, 255, 255));
		nombre1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nombre1.setBounds(133, 158, 85, 41);
		panelResultados.add(nombre1);

		primerPuesto = new JLabel("");
		primerPuesto.setBounds(78, 158, 45, 41);
		primerPuesto.setIcon(new ImageIcon("src/Imagenes/1.png"));
		panelResultados.add(primerPuesto);

		segundoPuesto = new JLabel("");
		segundoPuesto.setBounds(279, 158, 45, 41);
		primerPuesto.setIcon(new ImageIcon("src/Imagenes/2.png"));
		panelResultados.add(segundoPuesto);

		nombre2 = new JLabel("");
		nombre2.setForeground(new Color(255, 255, 255));
		nombre2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nombre2.setBounds(338, 158, 85, 41);
		panelResultados.add(nombre2);

		foto2 = new JLabel("");
		foto2.setBounds(290, 209, 133, 116);
		panelResultados.add(foto2);

		tercerPuesto = new JLabel("");
		tercerPuesto.setBounds(465, 158, 45, 41);
		primerPuesto.setIcon(new ImageIcon("src/Imagenes/3.png"));
		panelResultados.add(tercerPuesto);

		nombre3 = new JLabel("");
		nombre3.setForeground(new Color(255, 255, 255));
		nombre3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nombre3.setBounds(526, 158, 85, 41);
		panelResultados.add(nombre3);

		foto3 = new JLabel("");
		foto3.setBounds(478, 209, 133, 116);
		panelResultados.add(foto3);

		cuartoPuesto = new JLabel("");
		cuartoPuesto.setBounds(682, 158, 45, 41);
		primerPuesto.setIcon(new ImageIcon("src/Imagenes/4.png"));
		panelResultados.add(cuartoPuesto);

		nombre4 = new JLabel("");
		nombre4.setForeground(new Color(255, 255, 255));
		nombre4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nombre4.setBounds(730, 158, 85, 41);
		panelResultados.add(nombre4);

		foto4 = new JLabel("");
		foto4.setBounds(682, 209, 133, 116);
		panelResultados.add(foto4);

		nombre5 = new JLabel("");
		nombre5.setForeground(new Color(255, 255, 255));
		nombre5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nombre5.setBounds(948, 158, 85, 41);
		panelResultados.add(nombre5);

		quintoPuesto = new JLabel("");
		quintoPuesto.setBounds(900, 158, 45, 41);
		primerPuesto.setIcon(new ImageIcon("src/Imagenes/5.png"));
		panelResultados.add(quintoPuesto);

		foto5 = new JLabel("");
		foto5.setBounds(900, 209, 133, 116);
		panelResultados.add(foto5);

		sextoPuesto = new JLabel("");
		sextoPuesto.setBounds(85, 388, 45, 41);
		primerPuesto.setIcon(new ImageIcon("src/Imagenes/6.png"));
		panelResultados.add(sextoPuesto);

		nombre6 = new JLabel("");
		nombre6.setForeground(new Color(255, 255, 255));
		nombre6.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nombre6.setBounds(133, 388, 85, 41);
		panelResultados.add(nombre6);

		foto6 = new JLabel("");
		foto6.setBounds(85, 439, 133, 116);
		panelResultados.add(foto6);

		septimoPuesto = new JLabel("");
		septimoPuesto.setBounds(290, 388, 45, 41);
		primerPuesto.setIcon(new ImageIcon("src/Imagenes/7.png"));
		panelResultados.add(septimoPuesto);

		foto7 = new JLabel("");
		foto7.setBounds(290, 439, 133, 116);
		panelResultados.add(foto7);

		nombre7 = new JLabel("");
		nombre7.setForeground(new Color(255, 255, 255));
		nombre7.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nombre7.setBounds(338, 388, 85, 41);
		panelResultados.add(nombre7);

		octavoPuesto = new JLabel("");
		octavoPuesto.setBounds(478, 388, 45, 41);
		primerPuesto.setIcon(new ImageIcon("src/Imagenes/8.png"));
		panelResultados.add(octavoPuesto);

		nombre8 = new JLabel("");
		nombre8.setForeground(new Color(255, 255, 255));
		nombre8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nombre8.setBounds(526, 388, 85, 41);
		panelResultados.add(nombre8);

		foto8 = new JLabel("");
		foto8.setBounds(478, 439, 133, 116);
		panelResultados.add(foto8);

		novenoPuesto = new JLabel("");
		novenoPuesto.setBounds(682, 388, 45, 41);
		primerPuesto.setIcon(new ImageIcon("src/Imagenes/9.png"));
		panelResultados.add(novenoPuesto);

		nombre9 = new JLabel("");
		nombre9.setForeground(new Color(255, 255, 255));
		nombre9.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nombre9.setBounds(730, 388, 85, 41);
		panelResultados.add(nombre9);

		foto9 = new JLabel("");
		foto9.setBounds(682, 439, 133, 116);
		panelResultados.add(foto9);

		nombre10 = new JLabel("");
		nombre10.setForeground(new Color(255, 255, 255));
		nombre10.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nombre10.setBounds(948, 388, 85, 41);
		panelResultados.add(nombre10);

		decimoPuesto = new JLabel("");
		decimoPuesto.setBounds(900, 388, 45, 41);
		primerPuesto.setIcon(new ImageIcon("src/Imagenes/10.png"));
		panelResultados.add(decimoPuesto);

		foto10 = new JLabel("");
		foto10.setBounds(900, 439, 133, 116);
		panelResultados.add(foto10);

		lblFondoFinal = new JLabel("");
		lblFondoFinal.setBounds(0, 0, 1138, 636);
		lblFondoFinal.setIcon(new ImageIcon("src/Imagenes/fondo2.jpg"));
		panelResultados.add(lblFondoFinal);

		panelProceso = new JPanel();
		panelProceso.setBackground(new Color(22, 20, 28));
		panelProceso.setBounds(0, 0, 1138, 636);
		contentPane.add(panelProceso);
		panelProceso.setLayout(null);

		lblLoading = new JLabel("");
		lblLoading.setBounds(355, 104, 532, 470);
		panelProceso.add(lblLoading);
		lblLoading.setIcon(new ImageIcon("src/Imagenes/loading2.gif"));

		lblTimer = new JLabel("5");
		lblTimer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTimer.setForeground(new Color(255, 255, 255));
		lblTimer.setBounds(760, 24, 189, 49);
		panelProceso.add(lblTimer);

		lblNewLabel_4 = new JLabel("Procesando Las Votaciones:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(373, 24, 344, 49);
		panelProceso.add(lblNewLabel_4);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(20);
		progressBar.setBounds(499, 584, 146, 21);
		panelProceso.add(progressBar);

		PanelInicio = new JPanel();
		PanelInicio.setBackground(new Color(0, 0, 0));
		PanelInicio.setBounds(0, 0, 1138, 636);
		contentPane.add(PanelInicio);
		PanelInicio.setLayout(null);

		lblBorde3 = new JLabel("");
		lblBorde3.setBounds(255, 43, 562, 106);
		Border border4 = BorderFactory.createLineBorder(Color.WHITE, 3);
		lblBorde3.setBorder(border4);
		PanelInicio.add(lblBorde3);

		btnEmpezar = new JButton("ENTRAR");
		btnEmpezar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEmpezar.setBounds(431, 520, 214, 64);
		PanelInicio.add(btnEmpezar);

		lblNewLabel = new JLabel("Aquí podrás ver en tiempo real los votos realizados");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(285, 43, 531, 37);
		PanelInicio.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("por los votantes de cada Comunidad y votar tú");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(310, 78, 467, 26);
		PanelInicio.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("mismo a quien tú quieras");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(292, 107, 467, 26);
		PanelInicio.add(lblNewLabel_1_1);

		JLabel lblFondoInicio = new JLabel("New label");
		lblFondoInicio.setBounds(0, 0, 1138, 636);
		lblFondoInicio.setIcon(new ImageIcon("src/Imagenes/ben.jpg"));
		PanelInicio.add(lblFondoInicio);
		Border border5 = BorderFactory.createLineBorder(Color.WHITE, 3);
		Border border3 = BorderFactory.createLineBorder(Color.WHITE, 2);
		Border border2 = BorderFactory.createLineBorder(Color.WHITE, 2);

		panelComunidades = new JPanel();
		panelComunidades.setBounds(0, 0, 1138, 636);
		contentPane.add(panelComunidades);
		panelComunidades.setLayout(null);

		lblBorde2 = new JLabel("");
		Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
		lblBorde2.setBorder(border);
		lblBorde2.setBounds(209, 24, 768, 570);

		panelComunidades.add(lblBorde2);

		lblNewLabel_3 = new JLabel("Introduce Tu Comunidad Autónoma A Traves De Los Botones");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblNewLabel_3.setBounds(317, 30, 586, 27);
		panelComunidades.add(lblNewLabel_3);

		rdbtnMelilla = new JRadioButton("MELILLA");
		rdbtnMelilla.setBackground(Color.PINK);
		rdbtnMelilla.setBounds(562, 502, 70, 15);
		panelComunidades.add(rdbtnMelilla);

		rdbtnCeuta = new JRadioButton("CEUTA");
		rdbtnCeuta.setBackground(Color.PINK);
		rdbtnCeuta.setBounds(502, 472, 70, 15);
		panelComunidades.add(rdbtnCeuta);

		rdbtnCanarias = new JRadioButton("");
		rdbtnCanarias.setBackground(new Color(1, 45, 92));
		rdbtnCanarias.setBounds(774, 450, 21, 15);
		panelComunidades.add(rdbtnCanarias);

		rdbtnBaleares = new JRadioButton("");
		rdbtnBaleares.setBackground(new Color(232, 227, 187));
		rdbtnBaleares.setBounds(804, 283, 21, 15);
		panelComunidades.add(rdbtnBaleares);

		rdbtnLaRioja = new JRadioButton("");
		rdbtnLaRioja.setBackground(new Color(235, 188, 233));
		rdbtnLaRioja.setBounds(596, 160, 21, 21);
		panelComunidades.add(rdbtnLaRioja);

		rdbtnMurcia = new JRadioButton("");
		rdbtnMurcia.setBackground(new Color(202, 233, 188));
		rdbtnMurcia.setBounds(641, 364, 21, 21);
		panelComunidades.add(rdbtnMurcia);

		rdbtnAndalucia = new JRadioButton("");
		rdbtnAndalucia.setBackground(new Color(232, 188, 188));
		rdbtnAndalucia.setBounds(539, 380, 21, 21);
		panelComunidades.add(rdbtnAndalucia);

		rdbtnValencia = new JRadioButton("");
		rdbtnValencia.setBackground(new Color(232, 188, 188));
		rdbtnValencia.setBounds(673, 304, 21, 21);
		panelComunidades.add(rdbtnValencia);

		rdbtnExtremadura = new JRadioButton("");
		rdbtnExtremadura.setBackground(new Color(197, 188, 235));
		rdbtnExtremadura.setBounds(474, 303, 21, 21);
		panelComunidades.add(rdbtnExtremadura);

		rdbtnCLM = new JRadioButton("");
		rdbtnCLM.setBackground(new Color(235, 188, 233));
		rdbtnCLM.setBounds(596, 303, 21, 21);
		panelComunidades.add(rdbtnCLM);

		rdbtnMadrid = new JRadioButton("");
		rdbtnMadrid.setBackground(new Color(197, 188, 235));
		rdbtnMadrid.setBounds(559, 248, 21, 21);
		panelComunidades.add(rdbtnMadrid);

		rdbtnCYL = new JRadioButton("");
		rdbtnCYL.setBackground(new Color(189, 219, 233));
		rdbtnCYL.setBounds(508, 180, 21, 21);
		panelComunidades.add(rdbtnCYL);

		rdbtnCatalunya = new JRadioButton("");
		rdbtnCatalunya.setBackground(new Color(232, 227, 187));
		rdbtnCatalunya.setBounds(752, 191, 21, 21);
		panelComunidades.add(rdbtnCatalunya);

		rdbtnAragon = new JRadioButton("");
		rdbtnAragon.setBackground(new Color(202, 233, 188));
		rdbtnAragon.setBounds(673, 193, 21, 21);
		panelComunidades.add(rdbtnAragon);

		rdbtnNavarra = new JRadioButton("");
		rdbtnNavarra.setBackground(new Color(232, 188, 188));
		rdbtnNavarra.setBounds(629, 146, 21, 21);
		panelComunidades.add(rdbtnNavarra);

		rdbtnPaisVasco = new JRadioButton("");
		rdbtnPaisVasco.setBackground(new Color(232, 227, 187));
		rdbtnPaisVasco.setBounds(596, 125, 21, 21);
		panelComunidades.add(rdbtnPaisVasco);

		rdbtnGalicia = new JRadioButton("");
		rdbtnGalicia.setBackground(new Color(232, 188, 188));
		rdbtnGalicia.setBounds(397, 135, 28, 21);
		panelComunidades.add(rdbtnGalicia);

		rdbtnAsturias = new JRadioButton("");
		rdbtnAsturias.setBackground(new Color(202, 233, 188));
		rdbtnAsturias.setBounds(467, 110, 28, 21);
		panelComunidades.add(rdbtnAsturias);

		rdbtnCantabria = new JRadioButton("");
		rdbtnCantabria.setBackground(new Color(197, 188, 235));
		rdbtnCantabria.setBounds(539, 115, 21, 21);
		panelComunidades.add(rdbtnCantabria);

		lblEspana = new JLabel("");
		lblEspana.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspana.setBounds(202, 10, 830, 621);
		panelComunidades.add(lblEspana);
		lblEspana.setIcon(new ImageIcon("src/Imagenes/espana.png"));

		lblFondo2 = new JLabel("");
		lblFondo2.setBounds(0, 0, 1138, 636);
		lblFondo2.setIcon(new ImageIcon("src/Imagenes/fondo2.jpg"));
		panelComunidades.add(lblFondo2);

		timer = new Timer(1000, null);
	}
}
