/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Kaiser
 */
public class clsParametros {
    clsConexion bd = new clsConexion(); 
    String sql;
    
    public String consultaImgBlanco()
    {       
         String cantidad = "";
         try{
            bd.conectarBaseDeDatos();
            sql = "SELECT valor "
                    + "  FROM ck_parametros"
                    + " WHERE descripcion = 'img_blanco'";
            //System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
             
            if(bd.resultado.next())
            {               
                cantidad = bd.resultado.getString("valor");               
            }
            else
            { 
                cantidad = "";
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            cantidad = "";
        }           
        bd.desconectarBaseDeDatos();
        return cantidad;
    } 
    
    public String consultaRutaImagenes()
    {       
         String cantidad = "";
         try{
            bd.conectarBaseDeDatos();
            sql = "SELECT valor "
                    + "  FROM ck_parametros"
                    + " WHERE descripcion = 'ruta_imagenes'";
            //System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
             
            if(bd.resultado.next())
            {               
                cantidad = bd.resultado.getString("valor");               
            }
            else
            { 
                cantidad = "";
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            cantidad = "";
        }           
        bd.desconectarBaseDeDatos();
        return cantidad;
    } 
}
