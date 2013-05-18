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
    
    //Consultar el porcentaje de la cuota inicial; si la deuda era 300 la cuota inicial es 90
    public Double consultaPorcentajeCuotaInicial()
    {       
         Double cantidad = 0.00;
         try{
            bd.conectarBaseDeDatos();
            sql = "SELECT valor "
                    + "  FROM ck_parametros"
                    + " WHERE descripcion = 'porcentaje_cuota_inicial'";
            //System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
             
            if(bd.resultado.next())
            {               
                cantidad = bd.resultado.getDouble("valor");               
            }
            else
            { 
                cantidad = 0.00;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            cantidad = 0.00;
        }           
        bd.desconectarBaseDeDatos();
        return cantidad;
    } 
    
    public Double consultaInteres3Meses()
    {       
         Double cantidad = 0.00;
         try{
            bd.conectarBaseDeDatos();
            sql = "SELECT valor "
                    + "  FROM ck_parametros"
                    + " WHERE descripcion = 'interes_3_meses'";
            //System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
             
            if(bd.resultado.next())
            {               
                cantidad = bd.resultado.getDouble("valor");               
            }
            else
            { 
                cantidad = 0.00;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            cantidad = 0.00;
        }           
        bd.desconectarBaseDeDatos();
        return cantidad;
    } 
    
    public Double consultaInteres6Meses()
    {       
         Double cantidad = 0.00;
         try{
            bd.conectarBaseDeDatos();
            sql = "SELECT valor "
                    + "  FROM ck_parametros"
                    + " WHERE descripcion = 'interes_6_meses'";
            //System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
             
            if(bd.resultado.next())
            {               
                cantidad = bd.resultado.getDouble("valor");               
            }
            else
            { 
                cantidad = 0.00;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            cantidad = 0.00;
        }           
        bd.desconectarBaseDeDatos();
        return cantidad;
    } 
    
    public Double consultaInteres9Meses()
    {       
         Double cantidad = 0.00;
         try{
            bd.conectarBaseDeDatos();
            sql = "SELECT valor "
                    + "  FROM ck_parametros"
                    + " WHERE descripcion = 'interes_9_meses'";
            //System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
             
            if(bd.resultado.next())
            {               
                cantidad = bd.resultado.getDouble("valor");               
            }
            else
            { 
                cantidad = 0.00;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            cantidad = 0.00;
        }           
        bd.desconectarBaseDeDatos();
        return cantidad;
    } 
    
    public Double consultaInteres12Meses()
    {       
         Double cantidad = 0.00;
         try{
            bd.conectarBaseDeDatos();
            sql = "SELECT valor "
                    + "  FROM ck_parametros"
                    + " WHERE descripcion = 'interes_12_meses'";
            //System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
             
            if(bd.resultado.next())
            {               
                cantidad = bd.resultado.getDouble("valor");               
            }
            else
            { 
                cantidad = 0.00;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            cantidad = 0.00;
        }           
        bd.desconectarBaseDeDatos();
        return cantidad;
    } 
}
