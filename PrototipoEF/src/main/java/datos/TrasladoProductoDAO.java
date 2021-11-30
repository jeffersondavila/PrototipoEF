/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.TrasladoProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jefferson Dávila
 */
public class TrasladoProductoDAO {

    public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_inventario values(?,?,?,?,?,?,?,?)";

    public int insert(TrasladoProducto piso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, "0");
            stmt.setString(2, piso.getCodigoProducto());
            stmt.setString(3, piso.getCodigoBodega());
            stmt.setString(4, piso.getCantidadProducto());
            stmt.setString(5, piso.getFechaSalida());
            stmt.setString(6, piso.getHoraSalida());
            stmt.setString(7, piso.getEstado());
            stmt.setString(8, piso.getBodegaDestino());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public List<TrasladoProducto> select() {

        String SQL_SELECT = "SELECT * FROM tbl_inventario WHERE Pk_codigo_inventario LIKE '%"+codigoAuxiliar+"%' OR Pk_codigo_bodega LIKE '%"+nombreAuxiliar+"%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TrasladoProducto piso = null;
        List<TrasladoProducto> pisos = new ArrayList<TrasladoProducto>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Pk_codigo_inventario");
                String producto = rs.getString("Pk_codigo_producto");
                String bodega = rs.getString("Pk_codigo_bodega");
                String cantidad = String.valueOf(rs.getInt("cantidad_existencia"));
                String fecha = rs.getString("fecha_salida_existencia");
                String hora = rs.getString("horario_existencia");
                String estado = rs.getString("estatus_existencia");
                String destino = String.valueOf(rs.getInt("bodega_destino"));

                piso = new TrasladoProducto();
                piso.setCodigo(id);
                piso.setCodigoProducto(producto);
                piso.setCodigoBodega(bodega);
                piso.setCantidadProducto(cantidad);
                piso.setFechaSalida(fecha);
                piso.setHoraSalida(hora);
                piso.setEstado(estado);
                piso.setBodegaDestino(destino);
                
                pisos.add(piso);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return pisos;
    }

}
