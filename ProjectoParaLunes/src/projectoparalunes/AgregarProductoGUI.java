package projectoparalunes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarProductoGUI {

    private Controlador controlador;
    private JFrame frame;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JButton btnAgregar;
    private JButton btnCancelar;
    private JLabel lblError;

    
    public AgregarProductoGUI(Controlador controlador) {
        this.controlador = controlador;
        frame = new JFrame("Agregar producto");
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblPrecio = new JLabel("Precio:");

        txtNombre = new JTextField(20);
        txtPrecio = new JTextField(20);
        lblError = new JLabel("");


        btnAgregar = new JButton("Agregar");
        btnCancelar = new JButton("Cancelar");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    float precio = Float.parseFloat(txtPrecio.getText());
                    controlador.agregarProducto(nombre, precio);
                    cerrar();
                } catch (NumberFormatException ex) {
                    lblError.setText("Error: Debe ingresar un número válido en el campo de ID y precio.");
                }

            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrar();
            }
        });
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblPrecio);
        panel.add(txtPrecio);
        panel.add(btnAgregar);
        panel.add(btnCancelar);
        panel.add(lblError);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void mostrar() {
        frame.setVisible(true);
    }

    public void cerrar() {
        frame.dispose();
    }
}
