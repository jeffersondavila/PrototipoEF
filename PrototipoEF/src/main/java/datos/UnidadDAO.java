/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Unidad;
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
public class UnidadDAO {

    public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_unidad values(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_unidad SET nombre_unidad=?, medida_acronimo=?, estatus_unidad=? WHERE PK_codigo_unidad=?";

    public int insert(Unidad piso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, "0");
            stmt.setString(2, piso.getNombre());
            stmt.setString(3, piso.getMedida());
            stmt.setString(4, piso.getEstado());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public List<Unidad> select() {

        String SQL_SELECT = "SELECT * FROM tbl_unidad WHERE PK_codigo_unidad LIKE '%"+codigoAuxiliar+"%' OR PK_codigo_unidad LIKE '%"+nombreAuxiliar+"%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Unidad piso = null;
        List<Unidad> pisos = new ArrayList<Unidad>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_codigo_unidad");
                String nombre = rs.getString("nombre_unidad");
                String medida = rs.getString("medida_acronimo");
                String estado = String.valueOf(rs.getInt("estatus_unidad"));

                piso = new Unidad();
                piso.setCodigo(id);
                piso.setNombre(nombre);
                piso.setMedida(medida);
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
    
    public int update(Unidad linea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, linea.getNombre());
            stmt.setString(2, linea.getMedida());
            stmt.setString(3, linea.getEstado());
            stmt.setString(4, linea.getCodigo());

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
