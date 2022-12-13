package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class VentanaOperaciones extends JFrame implements ActionListener {

	private JPanel Ventana;
	private JTextField txtNombre;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JButton btnCalcular;
	private JLabel lblResPromedio;
	private JLabel lblCantEstudiantes;

	ArrayList<Double> ListaNotasFinales;
	//ArrayList<ArrayList<Double>> listaNotas;
	ArrayList<String> listaEstudiantes;
	int cantGanan = 0, cantPierdenSinRecuperar = 0, cantPuedenRecuperar = 0, cantPierden = 0,
			cantEstudiantesValidados = 0;
	double promedioNotasFinales = 0;
	private JLabel lblCantEstudiantesRes;
	private JLabel lblCantGanan;
	private JLabel lblCantGananRes;
	private JLabel lblCantidadPierden;
	private JLabel lblCantPierdenRes;
	private JLabel lblCantidadRecuperan;
	private JLabel lblCantRecuperanRes;
	private JLabel lblPromedioTotal;
	private JLabel lblPromedioTotalRes;

	public VentanaOperaciones() {
//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(546, 486);
		setTitle("Calculo de promedio");
		setLocationRelativeTo(null);
		setResizable(false);
		iniciarComponentes();

	}

	private void iniciarComponentes() {

		Ventana = new JPanel();
		Ventana.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Ventana);
		Ventana.setLayout(null);

		JLabel lblTitulo = new JLabel("Promedio");
		lblTitulo.setBackground(new Color(255, 255, 255));
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTitulo.setBounds(0, 0, 531, 54);
		Ventana.add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre : ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(10, 77, 86, 22);
		Ventana.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(255, 255, 255));
		txtNombre.setBounds(88, 81, 119, 20);
		Ventana.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNota1 = new JLabel("Nota 1 :");
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNota1.setBounds(10, 125, 86, 22);
		Ventana.add(lblNota1);

		txtNota1 = new JTextField();
		txtNota1.setBackground(new Color(255, 255, 255));
		txtNota1.setColumns(10);
		txtNota1.setBounds(88, 127, 54, 22);
		txtNota1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Ventana.add(txtNota1);

		JLabel lblNota2 = new JLabel("Nota 2 :");
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNota2.setBounds(10, 158, 86, 22);
		Ventana.add(lblNota2);

		txtNota2 = new JTextField();
		txtNota2.setBackground(new Color(255, 255, 255));
		txtNota2.setColumns(10);
		txtNota2.setBounds(84, 158, 54, 24);
		txtNota2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Ventana.add(txtNota2);

		JLabel lblNota3 = new JLabel("Nota 3 :");
		lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNota3.setBounds(7, 191, 86, 22);
		Ventana.add(lblNota3);

		txtNota3 = new JTextField();
		txtNota3.setBackground(new Color(255, 255, 255));
		txtNota3.setColumns(10);
		txtNota3.setBounds(88, 191, 54, 24);
		txtNota3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Ventana.add(txtNota3);

		btnCalcular = new JButton("Calcular");
		btnCalcular.setBackground(SystemColor.activeCaption);
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCalcular.setBounds(195, 154, 120, 31);
		btnCalcular.addActionListener(this);
		Ventana.add(btnCalcular);

		JLabel lblPromedio = new JLabel("Promedio : ");
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPromedio.setBounds(10, 222, 105, 22);
		Ventana.add(lblPromedio);

		lblCantEstudiantes = new JLabel("cantidad estudiantes");
		lblCantEstudiantes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantEstudiantes.setBounds(10, 255, 173, 24);
		Ventana.add(lblCantEstudiantes);

		lblResPromedio = new JLabel("");
		lblResPromedio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblResPromedio.setBounds(110, 222, 412, 22);
		Ventana.add(lblResPromedio);
		lblCantEstudiantesRes = new JLabel("");
		lblCantEstudiantesRes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantEstudiantesRes.setBounds(195, 257, 154, 22);
		Ventana.add(lblCantEstudiantesRes);
		lblCantGanan = new JLabel("cantidad Ganan");
		lblCantGanan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantGanan.setBounds(10, 294, 173, 24);
		Ventana.add(lblCantGanan);
		lblCantGananRes = new JLabel("");
		lblCantGananRes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantGananRes.setBounds(195, 290, 154, 22);
		Ventana.add(lblCantGananRes);
		lblCantidadPierden = new JLabel("cantidad Pierden");
		lblCantidadPierden.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidadPierden.setBounds(10, 329, 173, 24);
		Ventana.add(lblCantidadPierden);
		lblCantPierdenRes = new JLabel("");
		lblCantPierdenRes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantPierdenRes.setBounds(195, 331, 154, 22);
		Ventana.add(lblCantPierdenRes);
		lblCantidadRecuperan = new JLabel("cantidad Recuperan");
		lblCantidadRecuperan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidadRecuperan.setBounds(10, 364, 173, 24);
		Ventana.add(lblCantidadRecuperan);
		lblCantRecuperanRes = new JLabel("");
		lblCantRecuperanRes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantRecuperanRes.setBounds(195, 364, 154, 22);
		Ventana.add(lblCantRecuperanRes);
		lblPromedioTotal = new JLabel("Promedio Total");
		lblPromedioTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPromedioTotal.setBounds(10, 400, 173, 24);
		Ventana.add(lblPromedioTotal);
		lblPromedioTotalRes = new JLabel("");
		lblPromedioTotalRes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPromedioTotalRes.setBounds(193, 397, 154, 22);
		Ventana.add(lblPromedioTotalRes);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCalcular) {
			iniciar();

		}

	}

	private void iniciar() {
		ingresarDatos();
		validarNota();
		imprimirListas();
		imprimirEstudianteNota();
		imprimirResultados();
	}

	private void ingresarDatos() {
		listaEstudiantes = new ArrayList<String>();
		String nombre = txtNombre.getText();
		listaEstudiantes.add(nombre);

	}

	public void imprimirEstudianteNota() {

		for (int i = 0; i < listaEstudiantes.size(); i++) {
			System.out.println(listaEstudiantes.get(i) + " : " + ListaNotasFinales.get(i));
		}
	}

	private void imprimirResultados() {
		lblCantEstudiantesRes.setText(String.valueOf(listaEstudiantes.size()));
		lblCantGananRes.setText(String.valueOf(cantGanan));
		lblCantPierdenRes.setText(String.valueOf(cantPierden));
		lblCantRecuperanRes.setText(String.valueOf(cantPuedenRecuperar));
		lblPromedioTotalRes.setText(String.valueOf(promedioNotasFinales));

	}

	private void imprimirListas() {
		System.out.println(listaEstudiantes);
		System.out.println(ListaNotasFinales);

	}

	private void validarNota() {
		double n1 = 0;
		double n2 = 0;
		double n3 = 0;
		ListaNotasFinales = new ArrayList<Double>();

		
			n1 = Double.parseDouble(txtNota1.getText());
			if (n1 < 0 || n1 > 5) {
				JOptionPane.showMessageDialog(null, "La nota esta fuera del rango permitido", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		


			n2 = Double.parseDouble(txtNota2.getText());
			if (n2 < 0 || n2 > 5) {
				JOptionPane.showMessageDialog(null, "La nota esta fuera del rango permitido", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		

		
			n3 = Double.parseDouble(txtNota3.getText());
			if (n3 < 0 || n3 > 5) {
				JOptionPane.showMessageDialog(null, "La nota esta fuera del rango permitido", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
	

		double promedio = (n1 + n2 + n3) / 3;
		ListaNotasFinales.add(promedio);
		System.out.println(ListaNotasFinales);

		if (promedio >= 3.5) {
			lblCantEstudiantes.setText("Resultado : aprobo con un promedio de  " + promedio);
			lblCantEstudiantes.setForeground(Color.green);

		} else {
			lblCantEstudiantes.setText("Resultado : reprobo con un promedio de  " + promedio);
			lblCantEstudiantes.setForeground(Color.red);
			cantPierdenSinRecuperar++;
		}

		for (int i = 0; i < ListaNotasFinales.size(); i++) {
			if (ListaNotasFinales.get(i) >= 3.5) {
				cantGanan++;
			} else {
				cantPierden++;
				if (ListaNotasFinales.get(i) > 2) {
					cantPuedenRecuperar++;
				} else {
					cantPierdenSinRecuperar++;
				}
			}
		}

		int suma = 0;
		for (int i = 0; i < ListaNotasFinales.size(); i++) {
			suma += ListaNotasFinales.get(i);
		}
		promedioNotasFinales = suma / ListaNotasFinales.size();

	}

}