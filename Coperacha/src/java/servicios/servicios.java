/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel
 */
@WebService(serviceName = "servicios")
public class servicios {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    //ELIMINAR ESTE METODO, VER COMO CONVERTIR LOS METODOS A UN WEB SERVICE. 
    @WebMethod(operationName = "AgregarRecompensa")
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
