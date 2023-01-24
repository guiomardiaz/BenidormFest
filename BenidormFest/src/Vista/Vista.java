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

public class Vista extends JFrame {

	private JPanel contentPane;
	public JPanel PanelInicio;
	public JButton btnEmpezar;
	public JLabel lblFoto;
	public JLabel lblBienvenido;
	public JLabel lblNewLabel;

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
	}
}
