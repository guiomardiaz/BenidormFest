package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class Vista extends JFrame {

	public JPanel contentPane;
	public JPanel PanelInicio, panelInicioSesion, panelComunidades, panelArtistas, panelProceso, panelResultados;
	public JButton btnEmpezar, continuar, btnVotarJoel, btnVotarVictoria, btnVotarThiago, btnVotarSarah, btnVotarElton,
			btnVotarAmie, btnVotarNahid, btnVotarMarc, btnVotarAlba, btnVotarJulio;
	public JLabel lblFoto, lblTimer;
	public JLabel lblBienvenido;
	public JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	public JTextField fieldNombre;
	public JComboBox comboBox;
	private JLabel lblEspana;
	public JRadioButton rdbtnAsturias, rdbtnMelilla, rdbtnCantabria, rdbtnPaisVasco, rdbtnNavarra, rdbtnAragon,
			rdbtnCatalunya, rdbtnCYL, rdbtnMadrid, rdbtnCLM, rdbtnExtremadura, rdbtnValencia, rdbtnAndalucia,
			rdbtnMurcia, rdbtnLaRioja, rdbtnBaleares, rdbtnCanarias, rdbtnCeuta, rdbtnGalicia;
	private JLabel lblFondo;
	private JLabel lblLogin;
	private JLabel lblFondo2;
	private JLabel lblFondo3;
	public JLabel lblLoading;
	public Timer timer;
	private JLabel lblNewLabel_2;
	public JLabel foto1;
	public JLabel nombre1;
	public JLabel primerPuesto;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 673);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 		
		 				 panelResultados = new JPanel();
		 				 panelResultados.setBounds(0, 0, 1138, 636);
		 				 contentPane.add(panelResultados);
		 				 panelResultados.setLayout(null);
		 				 
		 				 lblNewLabel_2 = new JLabel("RESULTADOS DE LAS VOTACIONES");
		 				 lblNewLabel_2.setBounds(30, 47, 234, 54);
		 				 panelResultados.add(lblNewLabel_2);
		 				 
		 				 foto1 = new JLabel("New label");
		 				 foto1.setBounds(85, 209, 133, 116);
		 				 panelResultados.add(foto1);
		 				 
		 				 nombre1 = new JLabel("New label");
		 				 nombre1.setBounds(133, 169, 85, 30);
		 				 panelResultados.add(nombre1);
		 				 
		 				 primerPuesto = new JLabel("1");
		 				 primerPuesto.setBounds(78, 158, 45, 41);
		 				 panelResultados.add(primerPuesto);
		 
		 		panelProceso = new JPanel();
		 		panelProceso.setBackground(new Color(22, 20, 28));
		 		panelProceso.setBounds(0, 0, 1138, 636);
		 		contentPane.add(panelProceso);
		 		panelProceso.setLayout(null);
		 		
		 				lblLoading = new JLabel("");
		 				lblLoading.setBounds(307, 68, 532, 470);
		 				panelProceso.add(lblLoading);
		 				lblLoading.setIcon(new ImageIcon("src/Imagenes/loading2.gif"));
		 				
		 				 lblTimer = new JLabel("5");
		 				lblTimer.setBounds(26, 21, 45, 13);
		 				panelProceso.add(lblTimer);

		PanelInicio = new JPanel();
		PanelInicio.setBackground(new Color(0, 0, 0));
		PanelInicio.setBounds(0, 0, 1138, 636);
		contentPane.add(PanelInicio);
		PanelInicio.setLayout(null);

		btnEmpezar = new JButton("EMPEZAR");
		btnEmpezar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEmpezar.setBounds(430, 505, 214, 98);
		PanelInicio.add(btnEmpezar);

		lblFoto = new JLabel("");
		lblFoto.setBounds(399, 163, 264, 120);
		PanelInicio.add(lblFoto);
		lblFoto.setIcon(new ImageIcon("src/Imagenes/benidorm.png"));

		lblBienvenido = new JLabel("Bienvenido a las votaciones de Benidorm Fest");
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblBienvenido.setBounds(217, 47, 666, 74);
		PanelInicio.add(lblBienvenido);

		lblNewLabel = new JLabel("Aquí podrás ver en tiempo real los votos realizados");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(285, 341, 531, 37);
		PanelInicio.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("por los votantes de cada Comunidad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(365, 388, 397, 26);
		PanelInicio.add(lblNewLabel_1);

		panelArtistas = new JPanel();
		panelArtistas.setBounds(0, 0, 1138, 626);
		contentPane.add(panelArtistas);
		panelArtistas.setLayout(null);

		JLabel lblFotoJoel = new JLabel("New label");
		lblFotoJoel.setBounds(83, 53, 90, 103);
		panelArtistas.add(lblFotoJoel);
		lblFotoJoel.setIcon(new ImageIcon("src/Imagenes/joel.png"));

		JLabel lblFotoVictoria = new JLabel("New label");
		lblFotoVictoria.setBounds(266, 53, 90, 103);
		panelArtistas.add(lblFotoVictoria);
		lblFotoVictoria.setIcon(new ImageIcon("src/Imagenes/victoria.png"));

		JLabel lblFotoThiago = new JLabel("New label");
		lblFotoThiago.setBounds(460, 53, 90, 103);
		panelArtistas.add(lblFotoThiago);
		lblFotoThiago.setIcon(new ImageIcon("src/Imagenes/thiago.png"));

		JLabel lblFotoSarah = new JLabel("New label");
		lblFotoSarah.setBounds(683, 53, 90, 103);
		panelArtistas.add(lblFotoSarah);
		lblFotoSarah.setIcon(new ImageIcon("src/Imagenes/sarah.png"));

		JLabel lblFotoElton = new JLabel("New label");
		lblFotoElton.setBounds(890, 53, 90, 103);
		panelArtistas.add(lblFotoElton);
		lblFotoElton.setIcon(new ImageIcon("src/Imagenes/elton.png"));

		btnVotarJoel = new JButton("VOTAR");
		btnVotarJoel.setBounds(83, 210, 85, 21);
		panelArtistas.add(btnVotarJoel);

		btnVotarVictoria = new JButton("VOTAR");
		btnVotarVictoria.setBounds(271, 210, 85, 21);
		panelArtistas.add(btnVotarVictoria);

		btnVotarThiago = new JButton("VOTAR");
		btnVotarThiago.setBounds(465, 210, 85, 21);
		panelArtistas.add(btnVotarThiago);

		btnVotarSarah = new JButton("VOTAR");
		btnVotarSarah.setBounds(688, 210, 85, 21);
		panelArtistas.add(btnVotarSarah);

		btnVotarElton = new JButton("VOTAR");
		btnVotarElton.setBounds(895, 210, 85, 21);
		panelArtistas.add(btnVotarElton);

		JLabel lblFotoAmie = new JLabel("New label");
		lblFotoAmie.setBounds(83, 325, 90, 103);
		panelArtistas.add(lblFotoAmie);
		lblFotoAmie.setIcon(new ImageIcon("src/Imagenes/amie.png"));

		JLabel lblFotoNahid = new JLabel("New label");
		lblFotoNahid.setBounds(266, 325, 90, 103);
		panelArtistas.add(lblFotoNahid);
		lblFotoNahid.setIcon(new ImageIcon("src/Imagenes/nahid.png"));

		JLabel lblFotoMarc = new JLabel("New label");
		lblFotoMarc.setBounds(460, 325, 90, 103);
		panelArtistas.add(lblFotoMarc);
		lblFotoMarc.setIcon(new ImageIcon("src/Imagenes/marc.png"));

		JLabel lblFotoAlba = new JLabel("New label");
		lblFotoAlba.setBounds(683, 325, 90, 103);
		panelArtistas.add(lblFotoAlba);
		lblFotoAlba.setIcon(new ImageIcon("src/Imagenes/alba.png"));

		JLabel lblFotoJulio = new JLabel("New label");
		lblFotoJulio.setBounds(890, 325, 90, 103);
		panelArtistas.add(lblFotoJulio);
		lblFotoJulio.setIcon(new ImageIcon("src/Imagenes/julio.png"));

		btnVotarAmie = new JButton("VOTAR");
		btnVotarAmie.setBounds(83, 507, 85, 21);
		panelArtistas.add(btnVotarAmie);

		btnVotarNahid = new JButton("VOTAR");
		btnVotarNahid.setBounds(266, 507, 85, 21);
		panelArtistas.add(btnVotarNahid);

		btnVotarMarc = new JButton("VOTAR");
		btnVotarMarc.setBounds(460, 507, 85, 21);
		panelArtistas.add(btnVotarMarc);

		btnVotarAlba = new JButton("VOTAR");
		btnVotarAlba.setBounds(683, 507, 85, 21);
		panelArtistas.add(btnVotarAlba);

		btnVotarJulio = new JButton("VOTAR");
		btnVotarJulio.setBounds(890, 507, 85, 21);
		panelArtistas.add(btnVotarJulio);

		lblFondo3 = new JLabel("");
		lblFondo3.setForeground(new Color(255, 255, 255));
		lblFondo3.setBounds(0, 0, 1138, 638);
		lblFondo3.setIcon(new ImageIcon("src/Imagenes/fondo2.jpg"));
		panelArtistas.add(lblFondo3);

		panelComunidades = new JPanel();
		panelComunidades.setBounds(0, 0, 1138, 636);
		contentPane.add(panelComunidades);
		panelComunidades.setLayout(null);

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

		panelInicioSesion = new JPanel();
		panelInicioSesion.setBounds(0, 0, 1138, 636);
		contentPane.add(panelInicioSesion);
		panelInicioSesion.setLayout(null);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Recuerdame en este diapositivo");
		chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox.setBackground(new Color(0, 115, 170));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxNewCheckBox.setBounds(408, 271, 268, 21);
		panelInicioSesion.add(chckbxNewCheckBox);

		lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLogin.setBounds(514, 120, 79, 23);
		panelInicioSesion.add(lblLogin);

		JLabel lblNombre = new JLabel("Username");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setBounds(398, 177, 96, 23);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelInicioSesion.add(lblNombre);

		fieldNombre = new JTextField();
		fieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fieldNombre.setBounds(584, 179, 96, 23);
		fieldNombre.setColumns(10);
		fieldNombre.setToolTipText("Introduce tu nombre");
		panelInicioSesion.add(fieldNombre);

		JLabel lblContrasea = new JLabel("Año nacimiento");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setBounds(355, 220, 183, 23);
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelInicioSesion.add(lblContrasea);

		continuar = new JButton("INICIAR SESION");
		continuar.setBackground(new Color(189, 219, 233));
		continuar.setBounds(453, 331, 202, 33);
		continuar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelInicioSesion.add(continuar);

		comboBox = new JComboBox();
		comboBox.setBounds(584, 221, 96, 23);
		panelInicioSesion.add(comboBox);

		JLabel lblErrorLogin = new JLabel("");
		lblErrorLogin.setBounds(603, 425, 191, 23);
		lblErrorLogin.setForeground(new Color(128, 64, 64));
		panelInicioSesion.add(lblErrorLogin);

		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 1128, 626);
		panelInicioSesion.add(lblFondo);
		lblFondo.setIcon(new ImageIcon("src/Imagenes/fondo.jpg"));
		
		timer = new Timer(1000, null);
	}
}
