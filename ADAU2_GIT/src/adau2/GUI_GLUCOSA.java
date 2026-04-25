package ada_glucosa;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;

public class GUI_GLUCOSA extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1; // Valor glucosa
	private JTextField textField_2; // Nombre
	private JTextField textField;   // Fecha
	
	// Lista general de datos
	ArrayList<Manejoregistro> datos = new ArrayList<>();
	
	// --- VARIABLES AGREGADAS POR ESTUDIANTE 2 ---
	JToolBar barraSuperior;
	JButton btnHistorial;
	JList listaResultados;
	DefaultListModel modeloLista;
	JScrollPane scrollResultados;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_GLUCOSA frame = new GUI_GLUCOSA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI_GLUCOSA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 450); // Aumenté un poco el alto para que quepa la lista
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// --- CÓDIGO DEL PUNTO 1 (Registro) ---
		JLabel lblNewLabel = new JLabel("Nuevo registro");
		lblNewLabel.setBounds(208, 35, 125, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresa el nombre:");
		lblNewLabel_1.setBounds(86, 78, 114, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField(); // Nombre
		textField_2.setBounds(316, 75, 114, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_2 = new JLabel("valor de la glucosa:");
		lblNewLabel_2.setBounds(86, 115, 114, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField(); // Glucosa
		textField_1.setBounds(316, 112, 114, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de registro:");
		lblNewLabel_3.setBounds(208, 165, 125, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField((java.time.LocalDate.now().toString()));
		textField.setBounds(208, 202, 86, 20);
		contentPane.add(textField);
		
		JButton btnNewButton_1 = new JButton("REGISTRAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String fecha = textField.getText();
					String nombre = textField_2.getText();
					float glucosa = Float.parseFloat(textField_1.getText());
					datos.add(new Manejoregistro(nombre, glucosa, fecha));
					JOptionPane.showMessageDialog(null, "Registrado correctamente");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error al guardar");
				}
			}
		});
		btnNewButton_1.setBounds(196, 246, 125, 23);
		contentPane.add(btnNewButton_1);

		barraSuperior = new JToolBar();
		barraSuperior.setBounds(0, 0, 533, 30);
		contentPane.add(barraSuperior);
		
		btnHistorial = new JButton("HISTORIAL");
		barraSuperior.add(btnHistorial);

		
		modeloLista = new DefaultListModel();
		listaResultados = new JList(modeloLista);
		scrollResultados = new JScrollPane(listaResultados);
		scrollResultados.setBounds(40, 300, 450, 80);
		contentPane.add(scrollResultados);

	
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (datos.size() == 0) {
					JOptionPane.showMessageDialog(null, "Lista vacía.");
				} else {
				
					Collections.sort(datos, new Comparator<Manejoregistro>() {
						
						public int compare(Manejoregistro r1, Manejoregistro r2) {
							return r1.getNombre().toLowerCase().compareTo(r2.getNombre().toLowerCase());
						}
					});

					
					modeloLista.removeAllElements();
					for (int i = 0; i < datos.size(); i++) {
						Manejoregistro aux = datos.get(i);
						String info = aux.getNombre() + " - " + aux.getGlucosa() + " mg - " + aux.getFecha();
						modeloLista.addElement(info);
					}
				}
			}
		});
	}
}
