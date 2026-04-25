package adau2;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI_GLUCOSA extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    ArrayList<Manejoregistro> datos = new ArrayList<>();

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
        setBounds(100, 100, 530, 420); // ← solo cambié el alto
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        
        JLabel lblNewLabel = new JLabel("Nuevo registro");
        lblNewLabel.setBounds(210, 11, 109, 42);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nombre:");
        lblNewLabel_1.setBounds(95, 65, 61, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Nivel de glucosa:");
        lblNewLabel_2.setBounds(74, 119, 109, 14);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Fecha de registro:");
        lblNewLabel_3.setBounds(201, 161, 118, 14);
        contentPane.add(lblNewLabel_3);

        textField = new JTextField((java.time.LocalDate.now().toString()));
        textField.setBounds(201, 195, 107, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(193, 62, 126, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(193, 116, 126, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JButton btnNewButton = new JButton("REGISTRAR");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fecha = textField.getText();
                if (!fecha.contains("-")) {
                    JOptionPane.showMessageDialog(null, "Introduce con formato AAAA-MM-DD");
                    return;
                }
                String nombre = textField_1.getText(); // ← bug corregido
                float glucosa = Float.parseFloat(textField_2.getText()); // ← bug corregido
                datos.add(new Manejoregistro(nombre, glucosa, fecha));
                JOptionPane.showMessageDialog(null, "Registrado correctamente");
            }
        });
        btnNewButton.setBounds(201, 244, 118, 33);
        contentPane.add(btnNewButton);

        //Buscador Emilio
        JPanel panelBuscador = new JPanel();
        panelBuscador.setLayout(null);

        JLabel lblBuscTitulo = new JLabel("Buscar por nombre");
        lblBuscTitulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 13));
        lblBuscTitulo.setBounds(160, 20, 200, 22);
        panelBuscador.add(lblBuscTitulo);

   
        JTextField txtBuscar = new JTextField();
        txtBuscar.setBounds(135, 63, 180, 25);
        panelBuscador.add(txtBuscar);

        JButton btnBuscar = new JButton("BUSCAR");
        btnBuscar.setBounds(325, 62, 90, 27);
        panelBuscador.add(btnBuscar);

        JLabel lblTagG = new JLabel("Glucosa:");
        lblTagG.setBounds(60, 110, 70, 20);
        panelBuscador.add(lblTagG);
        JLabel lblResGlucosa = new JLabel("—");
        lblResGlucosa.setBounds(135, 110, 250, 20);
        panelBuscador.add(lblResGlucosa);

        JLabel lblTagF = new JLabel("Fecha:");
        lblTagF.setBounds(60, 141, 70, 20);
        panelBuscador.add(lblTagF);
        JLabel lblResFecha = new JLabel("—");
        lblResFecha.setBounds(135, 141, 250, 20);
        panelBuscador.add(lblResFecha);

        ActionListener buscarAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String busqueda = txtBuscar.getText().trim().toLowerCase();
                if (busqueda.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Escribe un nombre para buscar");
                    return;
                }
                boolean encontrado = false;
                for (Manejoregistro r : datos) {
                    if (r.getNombre().toLowerCase().contains(busqueda)) {
                        lblResGlucosa.setText(r.getGlucosa() + " mg/dL");
                        lblResFecha.setText(r.getFecha());
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                	
                    lblResGlucosa.setText("—");
                    lblResFecha.setText("—");
                }
            }
        };
        btnBuscar.addActionListener(buscarAction);
        txtBuscar.addActionListener(buscarAction);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Registro", contentPane);
        tabbedPane.addTab("Buscador", panelBuscador);
        
        JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
        lblNewLabel_1_1.setBounds(60, 68, 61, 14);
        panelBuscador.add(lblNewLabel_1_1);
        setContentPane(tabbedPane);
    }
}
