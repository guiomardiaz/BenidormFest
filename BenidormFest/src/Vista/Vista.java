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
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class Vista extends JFrame {

	public JPanel contentPane;
	public JPanel PanelInicio, panelInicioSesion,  panelComunidades;
	public JButton btnEmpezar, continuar;
	public JLabel lblFoto;
	public JLabel lblBienvenido;
	public JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	public JTextField fieldNombre;
	public JComboBox comboBox;
	private JLabel lblEspana;
	private JRadioButton rdbtnAsturias;
	private JRadioButton rdbtnCantabria;
	private JRadioButton rdbtnPaisVasco;
	private JRadioButton rdbtnNavarra;
	private JRadioButton rdbtnNavarra_1;
	private JRadioButton rdbtnCatalunya;
	private JRadioButton rdbtnCYL;
	private JRadioButton rdbtnMadrid;
	private JRadioButton rdbtnCLM;
	private JRadioButton rdbtnExtremadura;
	private JRadioButton rdbtnValencia;
	private JRadioButton rdbtnAndalucia;
	private JRadioButton rdbtnMurcia;
	private JRadioButton rdbtnMurcia_1;
	private JRadioButton rdbtnBaleares;
	private JRadioButton rdbtnCanarias;
	private JRadioButton rdbtnCeuta;

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
		   
		   panelComunidades = new JPanel();
		   panelComunidades.setBounds(0, 0, 1138, 636);
		   contentPane.add(panelComunidades);
		   panelComunidades.setLayout(null);
		   
		   JRadioButton rdbtnMelilla = new JRadioButton("MELILLA");
		   rdbtnMelilla.setBackground(Color.PINK);
		   rdbtnMelilla.setBounds(562, 502, 70, 15);
		   panelComunidades.add(rdbtnMelilla);
		   
		   rdbtnCeuta = new JRadioButton("CEUTA");
		   rdbtnCeuta.setBackground(Color.PINK);
		   rdbtnCeuta.setBounds(502, 472, 70, 15);
		   panelComunidades.add(rdbtnCeuta);
		   
		   rdbtnCanarias = new JRadioButton("");
		   rdbtnCanarias.setBackground(Color.PINK);
		   rdbtnCanarias.setBounds(765, 466, 21, 15);
		   panelComunidades.add(rdbtnCanarias);
		   
		   rdbtnBaleares = new JRadioButton("");
		   rdbtnBaleares.setBackground(Color.PINK);
		   rdbtnBaleares.setBounds(804, 283, 21, 15);
		   panelComunidades.add(rdbtnBaleares);
		   
		   rdbtnMurcia_1 = new JRadioButton("");
		   rdbtnMurcia_1.setBackground(Color.PINK);
		   rdbtnMurcia_1.setBounds(596, 160, 21, 21);
		   panelComunidades.add(rdbtnMurcia_1);
		   
		   rdbtnMurcia = new JRadioButton("");
		   rdbtnMurcia.setBackground(Color.PINK);
		   rdbtnMurcia.setBounds(641, 364, 21, 21);
		   panelComunidades.add(rdbtnMurcia);
		   
		   rdbtnAndalucia = new JRadioButton("");
		   rdbtnAndalucia.setBackground(Color.PINK);
		   rdbtnAndalucia.setBounds(539, 380, 21, 21);
		   panelComunidades.add(rdbtnAndalucia);
		   
		   rdbtnValencia = new JRadioButton("");
		   rdbtnValencia.setBackground(Color.PINK);
		   rdbtnValencia.setBounds(673, 304, 21, 21);
		   panelComunidades.add(rdbtnValencia);
		   
		   rdbtnExtremadura = new JRadioButton("");
		   rdbtnExtremadura.setBackground(Color.PINK);
		   rdbtnExtremadura.setBounds(474, 303, 21, 21);
		   panelComunidades.add(rdbtnExtremadura);
		   
		   rdbtnCLM = new JRadioButton("");
		   rdbtnCLM.setBackground(Color.PINK);
		   rdbtnCLM.setBounds(596, 303, 21, 21);
		   panelComunidades.add(rdbtnCLM);
		   
		   rdbtnMadrid = new JRadioButton("");
		   rdbtnMadrid.setBackground(Color.PINK);
		   rdbtnMadrid.setBounds(559, 248, 21, 21);
		   panelComunidades.add(rdbtnMadrid);
		   
		   rdbtnCYL = new JRadioButton("");
		   rdbtnCYL.setBackground(Color.PINK);
		   rdbtnCYL.setBounds(508, 180, 21, 21);
		   panelComunidades.add(rdbtnCYL);
		   
		   rdbtnCatalunya = new JRadioButton("");
		   rdbtnCatalunya.setBackground(Color.PINK);
		   rdbtnCatalunya.setBounds(752, 191, 21, 21);
		   panelComunidades.add(rdbtnCatalunya);
		   
		   rdbtnNavarra_1 = new JRadioButton("");
		   rdbtnNavarra_1.setBackground(Color.PINK);
		   rdbtnNavarra_1.setBounds(673, 193, 21, 21);
		   panelComunidades.add(rdbtnNavarra_1);
		   
		   rdbtnNavarra = new JRadioButton("");
		   rdbtnNavarra.setBackground(Color.PINK);
		   rdbtnNavarra.setBounds(629, 146, 21, 21);
		   panelComunidades.add(rdbtnNavarra);
		   
		   rdbtnPaisVasco = new JRadioButton("");
		   rdbtnPaisVasco.setBackground(Color.PINK);
		   rdbtnPaisVasco.setBounds(596, 125, 21, 21);
		   panelComunidades.add(rdbtnPaisVasco);
		   
		   JRadioButton rdbtnGalicia = new JRadioButton("");
		   rdbtnGalicia.setBackground(Color.PINK);
		   rdbtnGalicia.setBounds(397, 135, 28, 21);
		   panelComunidades.add(rdbtnGalicia);
		   
		   rdbtnAsturias = new JRadioButton("");
		   rdbtnAsturias.setBackground(Color.PINK);
		   rdbtnAsturias.setBounds(467, 104, 28, 21);
		   panelComunidades.add(rdbtnAsturias);
		   
		   rdbtnCantabria = new JRadioButton("");
		   rdbtnCantabria.setBackground(Color.PINK);
		   rdbtnCantabria.setBounds(539, 115, 21, 21);
		   panelComunidades.add(rdbtnCantabria);
		   
		   lblEspana = new JLabel("");
		   lblEspana.setHorizontalAlignment(SwingConstants.CENTER);
		   lblEspana.setBounds(202, 10, 830, 621);
		   panelComunidades.add(lblEspana);
		   lblEspana.setIcon(new ImageIcon("src/Imagenes/espana.png"));
		   
		   
		   
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
		  
		   panelInicioSesion = new JPanel();
		   panelInicioSesion.setBounds(0, 0, 1138, 636);
		   contentPane.add(panelInicioSesion);
		   panelInicioSesion.setLayout(null);
		   
		   JLabel lblNombre = new JLabel("Nombre");
		   lblNombre.setBounds(258, 151, 67, 23);
		   lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		   lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 19));
		   panelInicioSesion.add(lblNombre);
		   
		   fieldNombre = new JTextField();
		   fieldNombre.setBounds(368, 157, 96, 19);
		   fieldNombre.setColumns(10);
		   panelInicioSesion.add(fieldNombre);
		   
		   JLabel lblContrasea = new JLabel("Año de nacimiento");
		   lblContrasea.setBounds(175, 201, 183, 23);
		   lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		   lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 19));
		   panelInicioSesion.add(lblContrasea);
		   
		    continuar = new JButton("CONTINUAR");
		    continuar.setBounds(522, 156, 111, 21);
		    continuar.setFont(new Font("Tahoma", Font.BOLD, 10));
		    panelInicioSesion.add(continuar);
		    
		     comboBox = new JComboBox();
		     comboBox.setBounds(368, 206, 96, 18);
		     panelInicioSesion.add(comboBox);
		     
		     
		     JLabel lblErrorLogin = new JLabel("");
		     lblErrorLogin.setBounds(474, 201, 191, 23);
		     lblErrorLogin.setForeground(new Color(128, 64, 64));
		     panelInicioSesion.add(lblErrorLogin);
		     
		     JLabel lblFondoIS = new JLabel("");
		     lblFondoIS.setBounds(165, 139, 500, 110);
		     lblFondoIS.setOpaque(true);
		     lblFondoIS.setBorder(BorderFactory.createLineBorder(Color.black));
		     lblFondoIS.setBackground(new Color(251, 254, 231));
		     panelInicioSesion.add(lblFondoIS);
		
		JPanel panelArtistas = new JPanel();
		panelArtistas.setBounds(0, 0, 10, 10);
		contentPane.add(panelArtistas);
	}
}
