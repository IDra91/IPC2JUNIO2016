package servicios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneLayout;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Manuel
 */
public class nuevos {
    public Connection conexion = null;
    public ResultSet rs = null;
    public Statement s = null;
    
    
    public nuevos(){
        
    }
    
    public boolean loginAdmin(String codigo, String username, String password){
        Connection conexion1 = null;
        Statement s = null;
        PreparedStatement ps = null;
        String buscarUsuario = "SELECT cod_usuario from staff where username = (?) and password = (?)";
        try{
            conexion1 = new conexion().AbrirConexion();
            ps = conexion1.prepareStatement(buscarUsuario);
            ps.setString(1, username);
            ps.setString(2, password);
            conexion1.close();
            if(ps != null){
                return true;
                
            } else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de búsqueda D:");
        } return false;
    }
    
    public boolean loginUser(String codigo, String username, String password){
        Connection conexion1 = null;
        Statement s = null;
        PreparedStatement ps = null;
        String buscarUsuario = "SELECT cod_usuario from usuario where username = (?) and password = (?)";
        try{
            conexion1 = new conexion().AbrirConexion();
            ps = conexion1.prepareStatement(buscarUsuario);
            ps.setString(1, username);
            ps.setString(2, password);
            conexion1.close();
            if(ps != null){
                return true;
                
            } else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de búsqueda D:");
        } return false;
    }
    
    public void Registrarse(String Codigo, String Username, String Password, String Nombre, String Apellido, String no_teléfono, String no_tarjeta, Boolean comportamiento){
            Connection conexion1 = null;
            Statement s = null;
            PreparedStatement ps = null;
            String insertarRecompensa = "INSERT INTO usuario(cod_usuario, username, password, nombre, apellido, no_teléfono, no_tarjeta, comportamiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            try{
                conexion1 = new conexion().AbrirConexion() ;
                ps = conexion1.prepareStatement(insertarRecompensa);
                ps.setString(1, Codigo);
                ps.setString(2, Username);
                ps.setString(3, Password);
                ps.setString(4, Nombre);
                ps.setString(5, Apellido);
                ps.setString(6, no_teléfono);
                ps.setString(7, no_tarjeta);
                ps.setBoolean(8, comportamiento);
                ps.executeUpdate();
                conexion1.close();
                JOptionPane.showMessageDialog(null, "Se ha agregado exitosamente :D");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error de inserción D:");
            }
            
        }
    
    
}
