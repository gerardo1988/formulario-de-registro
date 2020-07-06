/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularioRegistro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Comodore
 */
public class Conexion {

    Connection conexion = null;
    PreparedStatement ps = null;

    public PreparedStatement llenaDatos(String nombres, String apellido,String sexo, int edad,String correo, String usuario, String contraseña) {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/formulariojava", "root", "");

            String sql = "INSERT INTO registro(nombres,apellido,sexo,edad,correo,usuario,contrasena)VALUES(?,?,?,?,?,?,?)";

            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombres);
            ps.setString(2, apellido);
            ps.setString(3, sexo);
            ps.setInt(4, edad);
            ps.setString(5, correo);
            ps.setString(6, usuario);
            ps.setString(7, contraseña);

            ps.execute();

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            try {

                if (conexion != null) {

                    conexion.close();

                }
            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }
        }

        return ps;

    }

}
