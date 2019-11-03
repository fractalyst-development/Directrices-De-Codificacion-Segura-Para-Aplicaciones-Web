package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.data.DBHandler;
import model.data.Usuario;

public class ServiceFacade {

    public boolean existeUsuario(String email) {
        final String SQL = "select * from a1_inyeccion where nombreusuario = ?";
        System.err.println("sql:" + SQL);
        boolean exito = false;
        DBHandler connection = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = new DBHandler();
            con = connection.getConnection();
            stmt = con.prepareStatement(SQL);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            if (rs.next()) {
                exito = true;
            }
        } catch (Exception sqle) {
            System.out.println("SQLE: " + sqle.getLocalizedMessage());
        }
        return exito;
    }

    public List<Usuario> obtenUsuario(String email) {
        final String SQL = "select * from a1_inyeccion where nombreusuario = ?";
        System.err.println("sql:" + SQL);
        List<Usuario> usuarios = new ArrayList<>();
        Usuario u = new Usuario();
        DBHandler connection = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = new DBHandler();
            con = connection.getConnection();
            stmt = con.prepareStatement(SQL);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            while (rs.next()) {
                u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombreUsuario(rs.getString("nombreusuario"));
                u.setContrasenha(rs.getString("contrasenha"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidoPaterno(rs.getString("apellido_paterno"));
                u.setApellidoMaterno(rs.getString("apellido_materno"));
                u.setPreguntaSecreta(rs.getString("pregunta_secreta"));
                u.setRespuestaSecreta(rs.getString("respuesta_secreta"));
                usuarios.add(u);
            }
        } catch (Exception sqle) {
            System.out.println("SQLE: " + sqle.getLocalizedMessage());
        }
        return usuarios;
    }

}
