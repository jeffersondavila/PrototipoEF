/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Marca;
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
public class MarcaDAO {

    public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_marca values(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_marca SET nombre_marca=?, estatus_marca=? WHERE PK_codigo_marca=?";

    public int insert(Marca piso) {
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

    public List<Marca> select() {

        String SQL_SELECT = "SELECT * FROM tbl_marca WHERE PK_codigo_marca LIKE '%"+codigoAuxiliar+"%' OR PK_codigo_marca LIKE '%"+nombreAuxiliar+"%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Marca piso = null;
        List<Marca> pisos = new ArrayList<Marca>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_codigo_marca");
                String nombre = rs.getString("nombre_marca");
                String estado = String.valueOf(rs.getInt("estatus_marca"));

                piso = new Marca();
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
    
    public int update(Marca linea) {
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
