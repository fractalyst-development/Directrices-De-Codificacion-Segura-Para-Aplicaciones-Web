package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.data.DBHandler;

public class ServiceFacade {

    public boolean login(String email, String pwd) {
        final String SQL = "select * from a2_autenticacion where nombreusuario = ? AND contrasenha = ?";
        boolean exito = false;
        DBHandler connection = null;
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            connection = new DBHandler();
            con = connection.getConnection();
            prepStmt = con.prepareStatement(SQL);
            prepStmt.setString(1, email);
            prepStmt.setString(2, pwd);
            rs = prepStmt.executeQuery();
            if (rs.next()) {
                exito = true;
            }
        } catch (Exception sqle) {
            System.out.println("SQLE: " + sqle.getLocalizedMessage());
        }
        return exito;
    }

    public boolean cambiaPassword(String email, String pwd) {
        final String SQL = "UPDATE a2_autenticacion SET contrasenha = ? WHERE nombreusuario = ?";
        boolean exito = false;
        DBHandler connection = null;
        Connection con = null;
        PreparedStatement prepStmt = null;
        int rsInt = 0;
        try {
            connection = new DBHandler();
            con = connection.getConnection();
            prepStmt = con.prepareStatement(SQL);
            prepStmt.setString(1, pwd);
            prepStmt.setString(2, email);
            rsInt = prepStmt.executeUpdate();
            if (rsInt != 0) {
                exito = true;
            }
        } catch (Exception sqle) {
            System.out.println("SQLE: " + sqle.getLocalizedMessage());
        }
        return exito;
    }

    public boolean esLaRespuesta(String email, String respuesta) {
        final String SQL = "select * from a2_autenticacion where nombreusuario = ? and respuesta_secreta = ?";
        boolean exito = false;
        DBHandler connection = null;
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;

        try {
            connection = new DBHandler();
            con = connection.getConnection();
            prepStmt = con.prepareStatement(SQL);
            prepStmt.setString(1, email);
            prepStmt.setString(2, respuesta);
            rs = prepStmt.executeQuery();
            if (rs.next()) {
                exito = true;
            }
        } catch (Exception sqle) {
            System.out.println("SQLE: " + sqle.getLocalizedMessage());
        }
        return exito;
    }

    public boolean existeUsuario(String email) {
        final String SQL = "select * from a2_autenticacion where nombreusuario = ?";
        boolean exito = false;
        DBHandler connection = null;
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            connection = new DBHandler();
            con = connection.getConnection();
            prepStmt = con.prepareStatement(SQL);
            prepStmt.setString(1, email);
            rs = prepStmt.executeQuery();
            if (rs.next()) {
                exito = true;
            }
        } catch (Exception sqle) {
            System.out.println("SQLE: " + sqle.getLocalizedMessage());
        }
        return exito;
    }

    public String obtenPregunta(String email) {
        final String SQL = "select pregunta_secreta from a2_autenticacion where nombreusuario = ?";
        String pregunta = "SIN PREGUNTA";
        DBHandler connection = null;
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            connection = new DBHandler();
            con = connection.getConnection();
            prepStmt = con.prepareStatement(SQL);
            prepStmt.setString(1, email);
            rs = prepStmt.executeQuery();
            if (rs.next()) {
                pregunta = rs.getString("pregunta_secreta");
            }
        } catch (Exception sqle) {
            System.out.println("SQLE: " + sqle.getLocalizedMessage());
        }
        return pregunta;
    }
}
