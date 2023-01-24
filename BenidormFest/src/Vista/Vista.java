package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField txtBienvenidoALas;
	public JButton btnEmpezar;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 btnEmpezar = new JButton("EMPEZAR");
		btnEmpezar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEmpezar.setBounds(419, 516, 214, 98);
		contentPane.add(btnEmpezar);
		
		txtBienvenidoALas = new JTextField();
		txtBienvenidoALas.setHorizontalAlignment(SwingConstants.CENTER);
		txtBienvenidoALas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBienvenidoALas.setText("Bienvenido a las votaciones de Benidorm Fest");
		txtBienvenidoALas.setBounds(293, 39, 437, 53);
		contentPane.add(txtBienvenidoALas);
		txtBienvenidoALas.setColumns(10);
	}
}
