package projectoparalunes;

import java.util.List;
import javax.swing.JTable;

public class Controlador {

    private ProductoDAO productoDAO;
    private VentanaPrincipalGUI ventanaPrincipalGUI;
    private AgregarProductoGUI agregarProductoGUI;
    private ListarProductosGUI listarProductosGUI;
    private BorrarProductoGUI borrarProductoGUI;

    public Controlador() {
        this.productoDAO = new ProductoDAO();
        this.ventanaPrincipalGUI = new VentanaPrincipalGUI(this);
        this.agregarProductoGUI = new AgregarProductoGUI(this);
        this.listarProductosGUI = new ListarProductosGUI(this);
        this.borrarProductoGUI = new BorrarProductoGUI(this);
    }

    public void mostrarVentanaPrincipal() {
        ventanaPrincipalGUI.mostrar();
    }

    public void mostrarAgregarProducto() {
        agregarProductoGUI.mostrar();
    }

    public void mostrarListarProductos() {
        List<Producto> productos = productoDAO.listarProductos();
        listarProductosGUI.mostrar(productos);
    }

    public void mostrarBorrarProducto() {
        List<Producto> productos = productoDAO.listarProductos();
        borrarProductoGUI.mostrar(productos);
    }

    public List<Producto> listarProductos() {
        return productoDAO.listarProductos();
    }

    public void agregarProducto(String nombre, float precio) {
        Producto producto = new Producto(nombre, precio);
        productoDAO.agregarProducto(producto);
        agregarProductoGUI.cerrar();
        mostrarListarProductos();
    }

    public void actualizarProducto(String nombre, float precio) {
        Producto producto = new Producto(nombre, precio);
        productoDAO.actualizarProducto(nombre, precio);
        mostrarListarProductos();
    }

    public void borrarProducto(String nombre) {
        productoDAO.borrarProducto(nombre);
        borrarProductoGUI.cerrar();
        mostrarListarProductos();
    }

   
}
