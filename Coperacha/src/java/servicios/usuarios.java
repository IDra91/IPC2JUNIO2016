package servicios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import servicios.conexion;
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
public class usuarios {
    public Connection conexion = null;
    public ResultSet rs = null;
    public Statement s = null;
    
    public usuarios(){
        
    }
    
   
    
    public void EliminarPropuesta(String codigo){
            Connection conexion1 = null;
            Statement s = null;
            PreparedStatement ps = null;
            String eliminarRecompensa = "DELETE FROM propuesta where cod_propuesta = (?)";
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la propuesta?","Confirmar Eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(confirmacion == 0){
                try{
                    conexion1 = new conexion().AbrirConexion();
                    ps = conexion1.prepareStatement(eliminarRecompensa);
                    ps.setString(1, codigo);
                    ps.executeUpdate();
                    conexion1.close();
                    JOptionPane.showMessageDialog(null, "Eliminado correctamente :D");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error en la eliminación D:");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Se han conservado los datos");
            }
        }
    
    public void EliminarRecompensa(String codigo){
            Connection conexion1 = null;
            Statement s = null;
            PreparedStatement ps = null;
            String eliminarRecompensa = "DELETE FROM recompensa where cod_recompensa = (?)";
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la recompensa?","Confirmar Eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(confirmacion == 0){
                try{
                    conexion1 = new conexion().AbrirConexion();
                    ps = conexion1.prepareStatement(eliminarRecompensa);
                    ps.setString(1, codigo);
                    ps.executeUpdate();
                    conexion1.close();
                    JOptionPane.showMessageDialog(null, "Eliminado correctamente :D");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error en la eliminación D:");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Se han conservado los datos");
            }
        }
    
    public void ActualizarPerfil(String cod_usuario, String username, String password, String nombre, String apellido, String no_teléfono, String no_tarjeta){
            Connection conexion1 = null;
            Statement s = null;
            PreparedStatement ps = null;
            String modificar = "UPDATE usuario SET username = (?), password = (?), nombre = (?), apellido = (?), no_teléfono = (?), no_tarjeta = (?)  where cod_usuario = (?);";
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea modificar la cuenta?","Confirmar Modificacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(confirmacion == 0){
                try{
                    conexion1 = new conexion().AbrirConexion();
                    ps = conexion1.prepareStatement(modificar);
                    ps.setString(1, username);
                    ps.setString(2, password);
                    ps.setString(3, apellido);
                    ps.setString(4, no_teléfono);
                    ps.setString(5, no_tarjeta);
                    ps.setString(6, cod_usuario);
                    ps.executeUpdate();
                    conexion1.close();
                    JOptionPane.showMessageDialog(null, "Modificado correctamente :D");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error en la actualizacion D:");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Se han conservado los datos");
            }
        }
    
    
    
    public void ModificarComentario(String no_comentario, String Titulo, String Descripcion){
            Connection conexion1 = null;
            Statement s = null;
            PreparedStatement ps = null;
            String modificar = "UPDATE comentario SET titulo = (?), descripcion = (?)  where no_comentario = (?);";
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea modificar el comentario?","Confirmar Modificacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(confirmacion == 0){
                try{
                    conexion1 = new conexion().AbrirConexion();
                    ps = conexion1.prepareStatement(modificar);
                    ps.setString(1, Titulo);
                    ps.setString(2, Descripcion);
                    ps.setString(3, no_comentario);
                    ps.executeUpdate();
                    conexion1.close();
                    JOptionPane.showMessageDialog(null, "Modificado correctamente :D");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error en la actualizacion D:");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Se han conservado los datos");
            }
        }
    
    public void ModificarPropuesta(String NoPropuesta, String Titulo, String Descripcion, String Blog, String estado, String fechal){
            Connection conexion1 = null;
            Statement s = null;
            PreparedStatement ps = null;
            String modificar = "UPDATE propuesta SET titulo = (?), descripcion = (?), blog = (?), estado = (?), fecha_límite = (?)  where cod_propuesta = (?);";
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea modificar la recompensa?","Confirmar Modificacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(confirmacion == 0){
                try{
                    conexion1 = new conexion().AbrirConexion();
                    ps = conexion1.prepareStatement(modificar);
                    ps.setString(1, Titulo);
                    ps.setString(2, Descripcion);
                    ps.setString(3, Blog);
                    ps.setString(4, estado);
                    ps.setString(5, fechal);
                    ps.setString(6, NoPropuesta);
                    ps.executeUpdate();
                    conexion1.close();
                    JOptionPane.showMessageDialog(null, "Modificado correctamente :D");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error en la actualizacion D:");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Se han conservado los datos");
            }
        }
    
     public void ModificarRecompensa(String Codigo, String NoPropuesta, String Tipo, String Estado, Integer precioI, Integer precioF){
            Connection conexion1 = null;
            Statement s = null;
            PreparedStatement ps = null;
            String modificar = "UPDATE recompensa SET cod_propuesta = (?), tipo = (?), estado = (?), precio_inicial = (?), monto_recaudado = (?)  where cod_recompensa = (?);";
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea modificar la recompensa?","Confirmar Eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(confirmacion == 0){
                try{
                    conexion1 = new conexion().AbrirConexion();
                    ps = conexion1.prepareStatement(modificar);
                    ps.setString(1, NoPropuesta);
                    ps.setString(2, Tipo);
                    ps.setString(3, Estado);
                    ps.setInt(4, precioI);
                    ps.setInt(5, precioF);
                    ps.setString(6, Codigo);
                    ps.executeUpdate();
                    conexion1.close();
                    JOptionPane.showMessageDialog(null, "Modificado correctamente :D");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error en la actualizacion D:");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Se han conservado los datos");
            }
        }
    
     public void InsertarPropuesta(String NoPropuesta, String CodSub, String CodCategoria, String CodUser, String CodStaff, String Titulo, String Descripcion, String Blog, String estado, Boolean situacion, String fecha_i, String fecha_l){
            Connection conexion1 = null;
            Statement s = null;
            PreparedStatement ps = null;
            String insertarRecompensa = "INSERT INTO Propuesta(cod_propuesta, cod_sub, cod_categoria, cod_usuario, cod_staff, titulo, descripcion, blog, estado, situacion, fecha_inicio, fecha_límite) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            try{
                conexion1 = new conexion().AbrirConexion() ;
                ps = conexion1.prepareStatement(insertarRecompensa);
                ps.setString(1, NoPropuesta);
                ps.setString(2, CodSub);
                ps.setString(3, CodCategoria);
                ps.setString(4, CodUser);
                ps.setString(5, CodStaff);
                ps.setString(6, Titulo);
                ps.setString(7, Descripcion);
                ps.setString(8, Blog);
                ps.setString(9, estado);
                ps.setBoolean(10, situacion);
                ps.setString(11, fecha_i);
                ps.setString(12, fecha_l);
                ps.executeUpdate();
                conexion1.close();
                JOptionPane.showMessageDialog(null, "Se ha agregado exitosamente :D");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error de inserción D:");
            }
            
        }
    
     public void InsertarComentarios(String No_Comentario, String NoPropuesta, String Titulo, String Descripcion, String fecha){
            Connection conexion1 = null;
            Statement s = null;
            PreparedStatement ps = null;
            String insertarRecompensa = "INSERT INTO comentarios(no_comentario, cod_propuesta, titulo, descripcion, fecha_posteado) VALUES (?, ?, ?, ?, ?);";
            try{
                conexion1 = new conexion().AbrirConexion() ;
                ps = conexion1.prepareStatement(insertarRecompensa);
                ps.setString(1, No_Comentario);
                ps.setString(2, NoPropuesta);
                ps.setString(3, Titulo);
                ps.setString(4, Descripcion);
                ps.setString(5, fecha);
                ps.executeUpdate();
                conexion1.close();
                JOptionPane.showMessageDialog(null, "Se ha agregado exitosamente :D");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error de inserción D:");
            }
            
        }
        
    
     public void InsertarRecompensa(String Codigo, String NoPropuesta, String Tipo, String Estado, Integer precioI, Integer precioF){
            Connection conexion1 = null;
            Statement s = null;
            PreparedStatement ps = null;
            String insertarRecompensa = "INSERT INTO recompensa(cod_recompensa, cod_propuesta, tipo, estado, precio_inicial, monto_recaudado) VALUES (?, ?, ?, ?, ?, ?);";
            try{
                conexion1 = new conexion().AbrirConexion() ;
                ps = conexion1.prepareStatement(insertarRecompensa);
                ps.setString(1, Codigo);
                ps.setString(2, NoPropuesta);
                ps.setString(3, Tipo);
                ps.setString(4, Estado);
                ps.setInt(5, precioI);
                ps.setInt(6, precioF);
                ps.executeUpdate();
                conexion1.close();
                JOptionPane.showMessageDialog(null, "Se ha agregado exitosamente :D");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error de inserción D:");
            }
            
        }
        
}
