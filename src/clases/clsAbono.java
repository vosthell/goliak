/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kaiser
 */
public class clsAbono {
    clsConexion bd = new clsConexion(); 
    String sql;
    
    public boolean insertarAbono(int num, String fecha_abono, double valor, int id_cabecera_movi)
    {       
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();          
            sql = "INSERT INTO ck_abono"
                    + " (numero_abono, fecha_abono, valor_abono, id_cabecera_movi)"
                    + " VALUES(" + num +", '" + fecha_abono + "', " + valor+ ", " + id_cabecera_movi + ")";           
            System.out.println("SQL enviado:" + sql);
            bd.sentencia.executeUpdate(sql);
            exito = true; 
        }
        catch(SQLException e) //Captura posible error de SQL
        {
            System.out.println("Error SQL:" + e);
            exito = false;
        } 
        bd.desconectarBaseDeDatos();
        return exito;
    } 
}
