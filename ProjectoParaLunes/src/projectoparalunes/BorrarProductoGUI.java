package projectoparalunes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BorrarProductoGUI {

    private Controlador controlador;
    private JFrame frame;
    private JTable tablaProductos;

    public BorrarProductoGUI(Controlador controlador) {
        this.controlador = controlador;
        frame = new JFrame("Borrar producto");
        tablaProductos = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaProductos);
        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarProductoSeleccionado();
            }
        });
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(btnBorrar, BorderLayout.SOUTH);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void mostrar(List<Producto> productos) {
        Object[][] data = new Object[productos.size()][2];
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            data[i][0] = p.getNombre();
            data[i][1] = p.getPrecio();
        }
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
                data, new String[]{"Nombre", "Precio"}));
        frame.setVisible(true);
    }

    private void borrarProductoSeleccionado() {
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String nombreProducto = (String) tablaProductos.getValueAt(filaSeleccionada, 0);
            controlador.borrarProducto(nombreProducto);
            mostrar(controlador.listarProductos());
        }
    }

    public void cerrar() {
        frame.dispose();
    }
}
