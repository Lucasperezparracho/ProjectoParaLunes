package projectoparalunes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipalGUI {
    private Controlador controlador;
    private JFrame frame;
    private JButton btnAgregarProducto;
    private JButton btnListarProductos;
        private JButton btnBorrarProducto;

    public VentanaPrincipalGUI(Controlador controlador) {
        this.controlador = controlador;
        frame = new JFrame("Mi aplicación");
        btnAgregarProducto = new JButton("Agregar producto");
        btnListarProductos = new JButton("Listar productos");
        btnBorrarProducto = new JButton("Borrar producto");
        btnAgregarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.mostrarAgregarProducto();
            }
        });
        btnListarProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.mostrarListarProductos();
            }
        });
         btnBorrarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.mostrarBorrarProducto();
            }
        });
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(btnAgregarProducto);
        panel.add(btnListarProductos);
        panel.add(btnBorrarProducto);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void mostrar() {
        frame.setVisible(true);
    }
}