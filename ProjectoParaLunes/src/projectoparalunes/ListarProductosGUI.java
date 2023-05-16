package projectoparalunes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListarProductosGUI {
    private Controlador controlador;
    private JFrame frame;
    private JTable tablaProductos;

    public ListarProductosGUI(Controlador controlador) {
        this.controlador = controlador;
        frame = new JFrame("Lista de Productos");
        tablaProductos = new JTable();
        

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(tablaProductos), BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void mostrar(List<Producto> productos) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Precio");
        
        for (Producto producto : productos) {
            Object[] row = {producto.getNombre(), producto.getPrecio()};
            model.addRow(row);
        }

        tablaProductos.setModel(model);

        frame.setVisible(true);
    }
}
