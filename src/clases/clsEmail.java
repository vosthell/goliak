/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Kaiser
 */
public class clsEmail {
    clsConexion bd = new clsConexion(); 
    String sql;
    
    private String email;
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public ArrayList<clsEmail>  consultarEmails(){            
        ArrayList<clsEmail> data = new ArrayList<clsEmail>();   
        try{
            bd.conectarBaseDeDatos();
            sql = "SELECT email"
                    + " FROM ck_email"
                    + " WHERE estado = 'A'";
            System.out.print(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
            
            while(bd.resultado.next()){
                clsEmail oListaTemporal = new clsEmail();
                oListaTemporal.setEmail(bd.resultado.getString("email"));
                data.add(oListaTemporal);
            }
            //return data;            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
    }
}
