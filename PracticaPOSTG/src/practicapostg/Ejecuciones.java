/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapostg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel
 */
public class Ejecuciones {
    public Connection conexion = null;
    public ResultSet rs = null;
    public Statement s = null;
    
    
    public Ejecuciones(){
        
    }
    
    
    public void Conexion(){
        if(conexion != null){
            return;
        }
        
        String url ="jdbc:postgresql://localhost:5432/CoperachaSA";
        
	String password ="manuel123";
        try{
            Class.forName("org.postgresql.Driver");
            
            conexion = DriverManager.getConnection(url, "CoperachaSA", password);
            
            if(conexion != null){
               JOptionPane.showMessageDialog(null, "Conexión realizada :D.");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Conexión fallida.");
        }
    }
}
