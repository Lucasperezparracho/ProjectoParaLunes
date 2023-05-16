package projectoparalunes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private Connection conexion;

    public ProductoDAO() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:productos.db";
            this.conexion = DriverManager.getConnection(url);
            String sql = "CREATE TABLE IF NOT EXISTS productos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, precio REAL)";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarProducto(Producto producto) {
        try {
            String sql = "INSERT INTO productos (nombre, precio) VALUES (?, ?)";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, producto.getNombre());
            statement.setDouble(2, producto.getPrecio());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "SELECT id, nombre, precio FROM productos";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                float precio = resultSet.getFloat("precio");
                Producto producto = new Producto(nombre, precio);
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
    public void actualizarProducto(String nombre, float precio) {
    try {
        String sql = "UPDATE productos SET nombre = ?, precio = ? WHERE nombre = ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, nombre);
        statement.setFloat(2, precio);
        statement.setString(3, nombre);
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public void borrarProducto(String nombre) {
    try {
        String sql = "DELETE FROM productos WHERE nombre = ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, nombre);
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
