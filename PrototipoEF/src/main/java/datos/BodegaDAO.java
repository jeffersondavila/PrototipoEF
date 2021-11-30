/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Bodega;
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
public class BodegaDAO {

    public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_bodega values(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_bodega SET nombre_bodega=?, estatus_bodega=? WHERE PK_codigo_bodega=?";

    public int insert(Bodega piso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, "0");
            stmt.setString(2, piso.getNombre());
            stmt.setString(3, piso.getEstado());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public List<Bodega> select() {

        String SQL_SELECT = "SELECT * FROM tbl_bodega WHERE PK_codigo_bodega LIKE '%"+codigoAuxiliar+"%' OR PK_codigo_bodega LIKE '%"+nombreAuxiliar+"%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Bodega piso = null;
        List<Bodega> pisos = new ArrayList<Bodega>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_codigo_bodega");
                String nombre = rs.getString("nombre_bodega");
                String estado = String.valueOf(rs.getInt("estatus_bodega"));

                piso = new Bodega();
                piso.setCodigo(id);
                piso.setNombre(nombre);
                piso.setEstado(estado);
                
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
    
    public int update(Bodega linea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, linea.getNombre());
            stmt.setString(2, linea.getEstado());
            stmt.setString(3, linea.getCodigo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
}
