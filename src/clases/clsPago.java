/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import index.main;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kaiser
 */
public class clsPago {
    clsConexion bd = new clsConexion(); 
    String sql;
    
    private String id_cabecera_movi;
    private String cedula;
    private String referencia;
    private String fecha_pago;
    private String fecha_cobro;
    private Double valor;
    private int codigo_recibo;
    private int id_pago;
    private int id_cta_cobrar;
    private String nombre_usuario;
    private String nombre_cobrador;
    private String nombre_cliente;
    private String fecha_registro;
    private String descripcion_deuda;
    private Double valor_actual;
    private int codigo;
    private int tipo_recibo;
    
    public String getIdCabeceraMovi() {
        return id_cabecera_movi;
    }
    
    public void setIdCabeceraMovi(String idCabeceraMovi) {
        this.id_cabecera_movi = idCabeceraMovi;
    }
    
     public String getCedula() {
        return cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public String getReferencia() {
        return referencia;
    }
    
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    public String getFechaPago() {
        return fecha_pago;
    }
    
    public void setFechaPago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
    
    public String getFechaCobro() {
        return fecha_cobro;
    }
    
    public void setFechaCobro(String fecha_cobro) {
        this.fecha_cobro = fecha_cobro;
    }
    
    public String getFechaRegistro() {
        return fecha_registro;
    }
    
    public void setFechaRegistro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    public Double getValor() {
        return valor;
    }
    
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public int getCodigoRecibo() {
        return codigo_recibo;
    }
    
    public void setCodigoRecibo(int codigo_recibo) {
        this.codigo_recibo = codigo_recibo;
    }
    
    public int getIdPago() {
        return id_pago;
    }
    
    public void setIdPago(int id_pago) {
        this.id_pago = id_pago;
    }
    
    public int getIdCtaCobrar() {
        return id_cta_cobrar;
    }
    
    public void setIdCtaCobrar(int id_cta_cobrar) {
        this.id_cta_cobrar = id_cta_cobrar;
    }
    
    public String getNombreUsuario() {
        return nombre_usuario;
    }
    
    public void setNombreUsuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    
    public String getNombreCobrador() {
        return nombre_cobrador;
    }
    
    public void setNombreCobrador(String nombre_cobrador) {
        this.nombre_cobrador = nombre_cobrador;
    }
    
    
    public String getNombreCliente() {
        return nombre_cliente;
    }
    
    public void setNombreCliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }
    
    public String getDescripcionDeuda() {
        return descripcion_deuda;
    }
    
    public void setDescripcionDeuda(String descripcion_deuda) {
        this.descripcion_deuda = descripcion_deuda;
    }
    
    public Double getValorActual() {
        return valor_actual;
    }
    
    public void setValorActual(Double valor_actual) {
        this.valor_actual = valor_actual;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public int getTipoRecibo() {
        return tipo_recibo;
    }
    
    public void setTipoRecibo(int tipo_recibo) {
        this.tipo_recibo = tipo_recibo;
    }
    
    public boolean insertarRegistroHistorico(String idCtaCobrar, String idUser, String factRef, String fechaPago, String valor)
    {       
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();          
            sql = "INSERT INTO ck_pagos"
                    + " (id_cta_cobrar, id_usuario, referencia, fecha_pago, valor, id_caja_operacion, estado)"
                    + " VALUES("+idCtaCobrar+", "+idUser+", '"+factRef+"', '"+fechaPago+"', "+valor+", 0, 'A')";           
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
    
    public boolean insertarRegistroNuevo(String idCtaCobrar, String idUser, String factRef, String valor)
    {       
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();          
            sql = "INSERT INTO ck_pagos"
                    + " (id_cta_cobrar, id_usuario, referencia, fecha_pago, valor, id_caja_operacion, estado)"
                    + " VALUES("+idCtaCobrar+", "+idUser+", '"+factRef+"', NOW(), "+valor+", 0, 'P')";           
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
    public boolean insertarPagoFacturas(String idCtaCobrar, String idUser, String factRef, String fecha, String valor)
    {       
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();          
            sql = "INSERT INTO ck_pagos_factura"
                    + " (id_cta_cobrar, id_usuario, referencia, fecha_pago, valor, id_caja_operacion)"
                    + " VALUES("+idCtaCobrar+", "+idUser+", '"+factRef+"', '" + fecha+ "', "+valor+", 0)";           
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
    
    public boolean insertarPagoFacturasNuevo(String idCtaCobrar, String idUser, String factRef, String valor)
    {       
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();          
            sql = "INSERT INTO ck_pagos_factura"
                    + " (id_cta_cobrar, id_usuario, referencia, fecha_pago, valor, id_caja_operacion, estado)"
                    + " VALUES("+idCtaCobrar+", "+idUser+", '"+factRef+"', NOW(), "+valor+", 0, 'P')";           
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
    
    public boolean insertarRegistro(String idCtaCobrar, String idUser, String factRef, String valor, String idCajaOperacion)
    {       
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();          
            sql = "INSERT INTO ck_pagos"
                    + " (id_cta_cobrar, id_usuario, referencia, fecha_pago, valor, id_caja_operacion)"
                    + " VALUES("+idCtaCobrar+", "+idUser+", '"+factRef+"', now(), "+valor+", "+idCajaOperacion+")";           
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
    
    public boolean insertarRegistroReciboCobro(String idUser, String factRef, String valor, 
            String idCajaOperacion, String codigoRecibo, String idCliente, String cuotaInicial,
            String tipoRecibo, String ne_contado)
    {       
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();          
            sql = "INSERT INTO ck_pagos_recibo"
                    + " (id_usuario, referencia, fecha_pago, valor, id_caja_operacion, "
                    + " codigo_recibo, estado, codigo, cuota_inicial, tipo_recibo, ne_contado)"
                    + " VALUES(" + idUser + ", '" + factRef + "', now(), " + valor + ", " + idCajaOperacion + ", "
                    + codigoRecibo + ", 'P', " + idCliente+ ", '" + cuotaInicial + "', '" + tipoRecibo + "', '" + ne_contado + "')";           
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
    
     public ArrayList<clsPago>  consultaPagosRealizadas(int idCajaAbierta){            
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
            sql = "SELECT b.id_cabecera_movi id_cabecera_movi, a.referencia referencia, fecha_pago, a.valor valor "           
                    + " FROM ck_pagos AS a "
                    + " JOIN ck_cta_cobrar AS b ON a.id_cta_cobrar = b.id_cta_cobrar "                                           
                    + " WHERE id_caja_operacion_cobra = "+idCajaAbierta
                    + " AND a.estado='A'";
            bd.resultado = bd.sentencia.executeQuery(sql);
              System.out.println("SQL enviado:" + sql);
            while(bd.resultado.next()){
                clsPago oListaTemporal = new clsPago();
                oListaTemporal.setIdCabeceraMovi(bd.resultado.getString("id_cabecera_movi"));   
                oListaTemporal.setReferencia(bd.resultado.getString("referencia"));                
                oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                oListaTemporal.setValor(bd.resultado.getDouble("valor"));                      
                
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
     
     public ArrayList<clsPago>  consultaPagosFacturaRealizadas(int idCajaAbierta){            
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
            sql = "SELECT b.id_cabecera_movi id_cabecera_movi, a.referencia referencia, fecha_pago, a.valor valor,"
                    + " d.apellido1 || ' ' || d.nombre1 cliente "           
                    + " FROM ck_pagos_factura AS a "
                    + " JOIN ck_cta_cobrar_facturas AS b ON a.id_cta_cobrar = b.id_cta_cobrar "
                    + " JOIN ck_cabecera_movi AS c ON b.id_cabecera_movi = c.id_cabecera_movi"
                    + " JOIN ck_cliente AS d ON c.codigo = d.codigo"                                           
                    + " WHERE id_caja_operacion_cobra = "+idCajaAbierta
                    + " AND a.estado='A'";
            bd.resultado = bd.sentencia.executeQuery(sql);
            System.out.println(sql);  
            while(bd.resultado.next()){
                clsPago oListaTemporal = new clsPago();
                oListaTemporal.setIdCabeceraMovi(bd.resultado.getString("id_cabecera_movi"));   
                oListaTemporal.setReferencia(bd.resultado.getString("referencia"));                
                oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                oListaTemporal.setValor(bd.resultado.getDouble("valor"));                      
                oListaTemporal.setNombreCliente(bd.resultado.getString("cliente"));    
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
     
     public ArrayList<clsPago>  consultaPagosRecibo(int idCajaAbierta){            
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
            sql = "SELECT a.referencia referencia, fecha_pago, a.valor valor, "
                    + " b.apellido1 || ' ' || b.nombre1 cliente "           
                    + " FROM ck_pagos_recibo AS a "                                                           
                    + " JOIN ck_cliente AS b "
                    + " ON a.codigo = b.codigo"
                    + " WHERE id_caja_operacion_cobra = "+idCajaAbierta
                    + " AND a.estado='A'";
            bd.resultado = bd.sentencia.executeQuery(sql);
            System.out.println(sql);  
            while(bd.resultado.next()){
                clsPago oListaTemporal = new clsPago();                
                oListaTemporal.setReferencia(bd.resultado.getString("referencia"));                
                oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                oListaTemporal.setValor(bd.resultado.getDouble("valor"));                      
                oListaTemporal.setNombreCliente(bd.resultado.getString("cliente"));      
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
     
     public ArrayList<clsPago>  consultaRecibosGenerados(int idCajaAbierta){            
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
            sql = "SELECT a.referencia referencia, fecha_pago, a.valor valor, codigo_recibo"           
                    + " FROM ck_pagos_recibo AS a "                                           
                    + " WHERE id_caja_operacion_cobra = "+idCajaAbierta
                    + " AND a.estado='A'";
            bd.resultado = bd.sentencia.executeQuery(sql);
              
            while(bd.resultado.next()){
                clsPago oListaTemporal = new clsPago();
                oListaTemporal.setReferencia(bd.resultado.getString("referencia"));                
                oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                oListaTemporal.setValor(bd.resultado.getDouble("valor"));   
                oListaTemporal.setCodigoRecibo(bd.resultado.getInt("codigo_recibo"));     
                
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
     
     
     public ArrayList<clsPago>  consulta_entradas_no_asignadas(){            
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
            sql = "select id_pagos_recibo, cedula, b.name_completo, referencia, fecha_pago::date fecha, "
                    + "valor, c.name usu_registra, d.name usu_cobra, codigo_recibo " +
                    "from ck_pagos_recibo AS a " +
                    "JOIN ck_cliente AS b " +
                    "ON a.codigo = b.codigo " +
                    "JOIN ck_usuario AS c " +
                    "ON a.id_usuario = c.id_usuario " +
                    "JOIN ck_usuario AS d " +
                    "ON a.id_usuario_cobra = d.id_usuario " +
                    "where a.cuota_inicial='S' " +
                    "AND a.estado_asignado = 'N' " +
                    "AND a.estado ='A'";
            bd.resultado = bd.sentencia.executeQuery(sql);
              
            while(bd.resultado.next()){
                clsPago oListaTemporal = new clsPago();
                oListaTemporal.setIdPago(bd.resultado.getInt("id_pagos_recibo")); 
                oListaTemporal.setCedula(bd.resultado.getString("cedula"));
                oListaTemporal.setNombreCliente(bd.resultado.getString("name_completo"));
                oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                oListaTemporal.setValor(bd.resultado.getDouble("valor"));   
                oListaTemporal.setFechaCobro(bd.resultado.getString("fecha"));     
                oListaTemporal.setNombreUsuario(bd.resultado.getString("usu_registra"));
                oListaTemporal.setNombreCobrador(bd.resultado.getString("usu_cobra"));
                oListaTemporal.setCodigoRecibo(bd.resultado.getInt("codigo_recibo"));
                
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
     
     public ArrayList<clsPago>  consulta_entradas_asignadas(int id_cabecera, String tipo_venta){            
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
            sql = "select id_pagos_recibo, cedula, b.name_completo, referencia, fecha_pago::date fecha, "
                    + "valor, c.name usu_registra, d.name usu_cobra, codigo_recibo " +
                    "from ck_pagos_recibo AS a " +
                    "JOIN ck_cliente AS b " +
                    "ON a.codigo = b.codigo " +
                    "JOIN ck_usuario AS c " +
                    "ON a.id_usuario = c.id_usuario " +
                    "JOIN ck_usuario AS d " +
                    "ON a.id_usuario_cobra = d.id_usuario " +
                    "WHERE a.estado = 'A' ";
            if(tipo_venta.equals("CREDITO"))
            {
                sql = sql + " AND a.cuota_inicial = 'S' ";
            }
            else
            {
                sql = sql + " AND a.ne_contado = 'S' ";
            }
            
            sql =sql + "AND a.estado_asignado = 'S' " +
                    "AND a.estado ='A'" +
                    "AND id_cabecera_movi = " + id_cabecera;
            bd.resultado = bd.sentencia.executeQuery(sql);
              
            while(bd.resultado.next()){
                clsPago oListaTemporal = new clsPago();
                oListaTemporal.setIdPago(bd.resultado.getInt("id_pagos_recibo")); 
                oListaTemporal.setCedula(bd.resultado.getString("cedula"));
                oListaTemporal.setNombreCliente(bd.resultado.getString("name_completo"));
                oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                oListaTemporal.setValor(bd.resultado.getDouble("valor"));   
                oListaTemporal.setFechaCobro(bd.resultado.getString("fecha"));     
                oListaTemporal.setNombreUsuario(bd.resultado.getString("usu_registra"));
                oListaTemporal.setNombreCobrador(bd.resultado.getString("usu_cobra"));
                oListaTemporal.setCodigoRecibo(bd.resultado.getInt("codigo_recibo"));
                
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
     
     public ArrayList<clsPago>  consultarDataPagos(int idCabecera){            
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
            sql = "SELECT id_pago, "
                     + " c.id_cta_cobrar,"
                     + " a.id_usuario,"
                     + " referencia,"
                     + " fecha_pago,"                     
                     + " b.valor,"
                     + " a.name AS name,"
                     + " pass,"                     
                     + " nivel,"
                     + " c.id_cta_cobrar,"
                     + " descripcion,"                    
                     + " a.estado,"
                     + " fecha_creacion,"
                     + " fecha_cancelacion,"
                     + " valor_actual,"
                     + " id_cabecera_movi"
                + " FROM ck_usuario AS a"
                    + " INNER JOIN ck_pagos AS b ON a.id_usuario = b.id_usuario "
                    + " INNER JOIN ck_cta_cobrar AS c ON b.id_cta_cobrar = c.id_cta_cobrar "
                + " WHERE c.id_cabecera_movi = " + idCabecera
                + " AND b.estado = 'A' "
                + " ORDER BY fecha_pago";
            bd.resultado = bd.sentencia.executeQuery(sql);
              
            while(bd.resultado.next()){
                clsPago oListaTemporal = new clsPago();
                oListaTemporal.setIdPago(bd.resultado.getInt("id_pago")); 
                oListaTemporal.setNombreUsuario(bd.resultado.getString("name"));    
                oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));  
                oListaTemporal.setReferencia(bd.resultado.getString("referencia")); 
                oListaTemporal.setValor(bd.resultado.getDouble("valor")); 
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
     
    public boolean eliminarPago(int p_codigo)
    {
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();
            sql = "UPDATE ck_pagos"
                    + " SET estado = 'I'" 
                    + " WHERE id_pago = " + p_codigo;      
           
            //System.out.println("SQL enviado:" + sql);
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
    
    public boolean actualizarDataPago(int id_pago, String idCajaAbierta, String idUser)
    {
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();
            sql = "UPDATE ck_pagos"
                    + " SET estado = 'A',"
                    + " id_usuario_cobra = " + idUser + ","
                    + " id_caja_operacion_cobra = " + idCajaAbierta + ","
                    + " fecha_cobro = NOW()" 
                    + " WHERE id_pago = " + id_pago;      
           
            //System.out.println("SQL enviado:" + sql);
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
    
    public boolean actualizarDataPagoOtros(int id_pago, String idCajaAbierta, String idUser)
    {
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();
            sql = "UPDATE ck_pagos_recibo"
                    + " SET estado = 'A',"
                    + " id_usuario_cobra = " + idUser + ","
                    + " id_caja_operacion_cobra = " + idCajaAbierta + ","
                    + " fecha_cobro = NOW()" 
                    + " WHERE id_pagos_recibo = " + id_pago;      
           
            //System.out.println("SQL enviado:" + sql);
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
    
    public boolean actualizarArriendo(String codigoArriendo, int id_pago, String estado)
    {
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();
            sql = "UPDATE ck_abono_arriendo"
                    + " SET estado_pago = '" + estado+ "',"                        
                        + " fecha_cobro = NOW()" 
                    + " WHERE id_abono_Arriendo = " + codigoArriendo;            
            //System.out.println("SQL enviado:" + sql);
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
    
    public boolean actualizarArriendoPendiente(String codigoArriendo, double valorCobrado)
    {
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();
            sql = "UPDATE ck_abono_arriendo"
                    + " SET valor_abono_pendiente = valor_abono_pendiente - " + valorCobrado                         
                    + " WHERE id_abono_Arriendo = " + codigoArriendo;            
            //System.out.println("SQL enviado:" + sql);
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
    
    public boolean actualizarDataPagoFactura(int id_pago, String idCajaAbierta, String idUser)
    {
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();
            sql = "UPDATE ck_pagos_factura"
                    + " SET estado = 'A',"
                    + " id_usuario_cobra = " + idUser + ","
                    + " id_caja_operacion_cobra = " + idCajaAbierta + ","
                    + " fecha_cobro = NOW()" 
                    + " WHERE id_pago = " + id_pago;      
           
            //System.out.println("SQL enviado:" + sql);
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
    
    public ArrayList<clsPago>  consultarDataPagosFactura(int idCabecera){            
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
            sql = "SELECT id_pago, "
                     + " c.id_cta_cobrar,"
                     + " a.id_usuario,"
                     + " referencia,"
                     + " fecha_pago,"                     
                     + " b.valor,"
                     + " a.name AS name,"
                     + " pass,"                     
                     + " nivel,"
                     + " c.id_cta_cobrar,"
                     + " descripcion,"                    
                     + " a.estado,"
                     + " fecha_creacion,"
                     + " fecha_cancelacion,"
                     + " valor_actual,"
                     + " id_cabecera_movi"
                + " FROM ck_usuario AS a"
                    + " INNER JOIN ck_pagos_factura AS b ON a.id_usuario = b.id_usuario "
                    + " INNER JOIN ck_cta_cobrar_facturas AS c ON b.id_cta_cobrar = c.id_cta_cobrar "
                + " WHERE c.id_cabecera_movi = " + idCabecera
                + " AND b.estado = 'A' "
                + " ORDER BY fecha_pago";
            bd.resultado = bd.sentencia.executeQuery(sql);
              
            while(bd.resultado.next()){
                clsPago oListaTemporal = new clsPago();
                oListaTemporal.setIdPago(bd.resultado.getInt("id_pago")); 
                oListaTemporal.setNombreUsuario(bd.resultado.getString("name"));    
                oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));  
                oListaTemporal.setReferencia(bd.resultado.getString("referencia")); 
                oListaTemporal.setValor(bd.resultado.getDouble("valor")); 
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
    
    public boolean eliminarPagoFactura(int p_codigo)
    {
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();
            sql = "UPDATE ck_pagos_factura"
                    + " SET estado = 'I'" 
                    + " WHERE id_pago = " + p_codigo;      
           
            //System.out.println("SQL enviado:" + sql);
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
    
    public boolean eliminarPagoRecibo(int p_codigo)
    {
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();
            sql = "UPDATE ck_pagos_recibo"
                    + " SET estado = 'I'" 
                    + " WHERE id_pagos_recibo = " + p_codigo;      
           
            //System.out.println("SQL enviado:" + sql);
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
    
    public ArrayList<clsPago> consultaDataPagos()
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
             sql = " SELECT a.id_pago id_pago, a.id_cta_cobrar, a.id_usuario, b.name name_usuario, a.referencia referencia, "
                        + " c.descripcion  descripcion_cta_cobrar, c.valor valor_deuda, "
                        + " c.valor_actual, a.fecha_pago fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente, a.fecha_registro fecha_registro"
                    + " FROM ck_pagos AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_cta_cobrar AS c ON a.id_cta_cobrar = c.id_cta_cobrar"
                    + " JOIN ck_notas_de_entrega AS d ON c.id_cabecera_movi = d.id_cabecera_movi"
                    + " JOIN ck_cliente AS e ON e.codigo = d.codigo"
                    + " WHERE a.estado = 'A'";   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("id_pago"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
    public ArrayList<clsPago> consultaDataPagosPendientesFactura()
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
             sql = " SELECT a.id_pago idPago, a.id_cta_cobrar, a.id_usuario, b.name name_usuario, a.referencia referencia, "
                        + " c.descripcion  descripcion_cta_cobrar, c.valor valor_deuda, "
                        + " c.valor_actual, a.fecha_pago fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente, a.fecha_registro fecha_registro"
                    + " FROM ck_pagos_factura AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_cta_cobrar_facturas AS c ON a.id_cta_cobrar = c.id_cta_cobrar"
                    + " JOIN ck_cabecera_movi AS d ON c.id_cabecera_movi = d.id_cabecera_movi"
                    + " JOIN ck_cliente AS e ON e.codigo = d.codigo"
                    + " WHERE a.estado = 'P'";   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("idPago"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
    public ArrayList<clsPago> consultaDataPagosFactura()
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
             sql = " SELECT a.id_pago idPago, a.id_cta_cobrar, a.id_usuario, b.name name_usuario, a.referencia referencia, "
                        + " c.descripcion  descripcion_cta_cobrar, c.valor valor_deuda, "
                        + " c.valor_actual, a.fecha_pago fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente, a.fecha_registro fecha_registro"
                    + " FROM ck_pagos_factura AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_cta_cobrar_facturas AS c ON a.id_cta_cobrar = c.id_cta_cobrar"
                    + " JOIN ck_cabecera_movi AS d ON c.id_cabecera_movi = d.id_cabecera_movi"
                    + " JOIN ck_cliente AS e ON e.codigo = d.codigo"
                    + " WHERE a.estado = 'A'";   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("idPago"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
    public ArrayList<clsPago> consultaDataPagosPendientesOtros()
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
             sql = " SELECT a.id_pagos_recibo idPago, a.id_usuario, b.name name_usuario, "
                        + " a.referencia referencia, "
                        + " a.fecha_pago fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente, "
                        + " a.fecha_pago fecha_registro"
                    + " FROM ck_pagos_recibo AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_cliente AS e ON a.codigo = e.codigo"
                    + " WHERE a.estado = 'P'";   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("idPago"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
     public ArrayList<clsPago> consultaDataPagosOtros(String arriendo)
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
             sql = " SELECT a.id_pagos_recibo idPago, a.id_usuario, b.name name_usuario, "
                        + " a.referencia referencia, "
                        + " a.fecha_pago fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente, "
                        + " a.fecha_pago fecha_registro"
                    + " FROM ck_pagos_recibo AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_cliente AS e ON a.codigo = e.codigo"
                    + " WHERE a.estado = 'A'";   
             if(arriendo.equals("1"))
             {
                 sql = sql + " AND referencia NOT LIKE 'WEB%'";
             }
              if(arriendo.equals("2"))
             {
                 sql = sql + " AND referencia LIKE 'WEB%'";
             }
             
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("idPago"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
    //CONSULTA DE PAGOS DE CUOTAS INICIALES, NO ASIGNADOS
    public ArrayList<clsPago> consultaDataPagosCuotaInicial(int codigoCli)
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
             sql = " SELECT a.id_pagos_recibo idPago, a.id_usuario, b.name name_usuario, "
                        + " a.referencia referencia, "
                        + " a.fecha_pago fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente, "
                        + " a.fecha_pago fecha_registro"
                    + " FROM ck_pagos_recibo AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_cliente AS e ON a.codigo = e.codigo"
                    + " WHERE a.estado = 'A'"
                    + " AND a.cuota_inicial = 'S'"
                    + " AND a.estado_asignado = 'N'"
                    + " AND a.codigo = " + codigoCli;   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("idPago"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
     //CONSULTA DE PAGOS DE NE CONTADO, NO ASIGNADOS
    public ArrayList<clsPago> consultaDataPagosNEContado(int codigoCli)
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
             sql = " SELECT a.id_pagos_recibo idPago, a.id_usuario, b.name name_usuario, "
                        + " a.referencia referencia, "
                        + " a.fecha_pago fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente, "
                        + " a.fecha_pago fecha_registro"
                    + " FROM ck_pagos_recibo AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_cliente AS e ON a.codigo = e.codigo"
                    + " WHERE a.estado = 'A'"
                    + " AND a.ne_contado = 'S'"
                    + " AND a.estado_asignado = 'N'"
                    + " AND a.codigo = " + codigoCli;   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("idPago"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
    public ArrayList<clsPago> consultaDataPagosPendientes()
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
             sql = " SELECT a.id_pago idPago, a.id_cta_cobrar, a.id_usuario, b.name name_usuario, a.referencia referencia, "
                        + " c.descripcion  descripcion_cta_cobrar, c.valor valor_deuda, "
                        + " c.valor_actual, a.fecha_pago fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente, a.fecha_registro fecha_registro"
                    + " FROM ck_pagos AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_cta_cobrar AS c ON a.id_cta_cobrar = c.id_cta_cobrar"
                    + " JOIN ck_notas_de_entrega AS d ON c.id_cabecera_movi = d.id_cabecera_movi"
                    + " JOIN ck_cliente AS e ON e.codigo = d.codigo"
                    + " WHERE a.estado = 'P'";   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("idPago"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
    public ArrayList<clsPago> consultaDataPagoDetalle(int idPago)
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
             sql = " SELECT a.id_pago idPago, a.id_cta_cobrar idCtaCobrar, a.id_usuario, "
                        + "b.name name_usuario, a.referencia referencia, "
                        + " c.descripcion  descripcion_cta_cobrar, c.valor valor_deuda, "
                        + " c.valor_actual valor_actual, a.fecha_pago fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente,"
                        + " a.fecha_registro fecha_registro, fecha_cobro, f.name name_cobrador,"
                        + " c.id_cabecera_movi id_cabecera_movi, e.codigo codigo, e.cedula cedula"
                    + " FROM ck_pagos AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_usuario AS f ON a.id_usuario_cobra = f.id_usuario"                   
                    + " JOIN ck_cta_cobrar AS c ON a.id_cta_cobrar = c.id_cta_cobrar"
                    + " JOIN ck_notas_de_entrega AS d ON c.id_cabecera_movi = d.id_cabecera_movi"
                    + " JOIN ck_cliente AS e ON e.codigo = d.codigo"
                    + " WHERE a.id_pago = " + idPago;   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCobrador(bd.resultado.getString("name_cobrador"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setDescripcionDeuda(bd.resultado.getString("descripcion_cta_cobrar"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("idPago"));
                    oListaTemporal.setIdCtaCobrar(bd.resultado.getInt("idCtaCobrar"));
                    oListaTemporal.setFechaCobro(bd.resultado.getString("fecha_cobro"));
                    oListaTemporal.setValorActual(bd.resultado.getDouble("valor_actual"));
                    oListaTemporal.setIdCabeceraMovi(bd.resultado.getString("id_cabecera_movi"));
                    oListaTemporal.setCodigo(bd.resultado.getInt("codigo"));
                    oListaTemporal.setCedula(bd.resultado.getString("cedula"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
    public ArrayList<clsPago> consultaDataPagoDetalleOtros(int idPago)
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
             sql = " SELECT a.id_pagos_recibo idPago, a.id_usuario, b.name name_usuario, "
                        + " a.referencia referencia, "
                        + " a.fecha_pago fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente,"
                        + " a.fecha_pago fecha_registro, fecha_cobro, f.name name_cobrador,"
                        + " a.codigo codigo, e.cedula cedula"
                    + " FROM ck_pagos_recibo AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                     + " JOIN ck_usuario AS f ON a.id_usuario_cobra = f.id_usuario"
                    + " JOIN ck_cliente AS e ON e.codigo = a.codigo"
                    + " WHERE a.id_pagos_recibo = " + idPago;   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCobrador(bd.resultado.getString("name_cobrador"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    //oListaTemporal.setDescripcionDeuda(bd.resultado.getString("descripcion_cta_cobrar"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("idPago"));
                    //oListaTemporal.setIdCtaCobrar(bd.resultado.getInt("idCtaCobrar"));
                    oListaTemporal.setFechaCobro(bd.resultado.getString("fecha_cobro"));
                    oListaTemporal.setCodigo(bd.resultado.getInt("codigo"));
                    oListaTemporal.setCedula(bd.resultado.getString("cedula"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
    public ArrayList<clsPago> consultaDataPagoDetalleFactura(int idPago)
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
             sql = " SELECT a.id_pago idPago, a.id_cta_cobrar idCtaCobrar, a.id_usuario, "
                        + " b.name name_usuario, a.referencia referencia, "
                        + " c.descripcion  descripcion_cta_cobrar, c.valor valor_deuda, "
                        + " c.valor_actual valor_actual, a.fecha_pago fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente, "
                        + " a.fecha_registro fecha_registro, fecha_cobro, f.name name_cobrador, "
                        + " c.id_cabecera_movi id_cabecera_movi, e.codigo codigo, e.cedula cedula"
                    + " FROM ck_pagos_factura AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_usuario AS f ON a.id_usuario_cobra = f.id_usuario"
                    + " JOIN ck_cta_cobrar_facturas AS c ON a.id_cta_cobrar = c.id_cta_cobrar"
                    + " JOIN ck_cabecera_movi AS d ON c.id_cabecera_movi = d.id_cabecera_movi"
                    + " JOIN ck_cliente AS e ON e.codigo = d.codigo"
                    + " WHERE a.id_pago = " + idPago;   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setDescripcionDeuda(bd.resultado.getString("descripcion_cta_cobrar"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("idPago"));
                    oListaTemporal.setIdCtaCobrar(bd.resultado.getInt("idCtaCobrar"));
                    oListaTemporal.setFechaCobro(bd.resultado.getString("fecha_cobro"));
                    oListaTemporal.setValorActual(bd.resultado.getDouble("valor_actual"));
                    oListaTemporal.setNombreCobrador(bd.resultado.getString("name_cobrador"));
                    oListaTemporal.setIdCabeceraMovi(bd.resultado.getString("id_cabecera_movi"));
                    oListaTemporal.setCodigo(bd.resultado.getInt("codigo"));
                    oListaTemporal.setCedula(bd.resultado.getString("cedula"));
                    
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
    public ArrayList<clsPago> consultaDataPagosFecha(String fecha_inicio, String fecha_fin)
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        
        try{
            bd.conectarBaseDeDatos();
             sql = " SELECT a.id_pago id_pago, a.id_cta_cobrar, a.id_usuario, b.name name_usuario, a.referencia referencia, "
                        + " c.descripcion  descripcion_cta_cobrar, c.valor valor_deuda, "
                        + " c.valor_actual, a.fecha_pago fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente, "
                        + "a.fecha_registro fecha_registro"
                    + " FROM ck_pagos AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_cta_cobrar AS c ON a.id_cta_cobrar = c.id_cta_cobrar"
                    + " JOIN ck_notas_de_entrega AS d ON c.id_cabecera_movi = d.id_cabecera_movi"
                    + " JOIN ck_cliente AS e ON e.codigo = d.codigo"
                    + " WHERE a.estado = 'A'"
                    + " AND a.fecha_pago::date >= '" + fecha_inicio + "'"
                    + " AND a.fecha_pago::date <= '" + fecha_fin + "'"
                    + " ORDER BY a.fecha_pago ASC";   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("id_pago"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
    public ArrayList<clsPago> consultaDataPagosRegistroFecha(String fecha_inicio, String fecha_fin)
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        
        try{
            bd.conectarBaseDeDatos();
             sql = " SELECT a.id_pago id_pago, a.id_cta_cobrar, a.id_usuario, b.name name_usuario, a.referencia referencia, "
                        + " c.descripcion  descripcion_cta_cobrar, c.valor valor_deuda, "
                        + " c.valor_actual, a.fecha_pago fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente, "
                        + "a.fecha_registro fecha_registro"
                    + " FROM ck_pagos AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_cta_cobrar AS c ON a.id_cta_cobrar = c.id_cta_cobrar"
                    + " JOIN ck_notas_de_entrega AS d ON c.id_cabecera_movi = d.id_cabecera_movi"
                    + " JOIN ck_cliente AS e ON e.codigo = d.codigo"
                    + " WHERE a.estado = 'A'"
                    + " AND a.fecha_registro::date >= '" + fecha_inicio + "'"
                    + " AND a.fecha_registro::date <= '" + fecha_fin + "'"
                    + " ORDER BY a.fecha_registro ASC";   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("id_pago"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
    public ArrayList<clsPago> consultaDataPagosFacturaFecha(String fecha_inicio, String fecha_fin)
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        
        try{
             bd.conectarBaseDeDatos();
             sql = " SELECT a.id_pago id_pago, a.id_cta_cobrar, a.id_usuario, b.name name_usuario, a.referencia referencia, "
                        + " c.descripcion  descripcion_cta_cobrar, c.valor valor_deuda, "
                        + " c.valor_actual, a.fecha_pago fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente, "
                        + "a.fecha_registro fecha_registro"
                    + " FROM ck_pagos_factura AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_cta_cobrar_facturas AS c ON a.id_cta_cobrar = c.id_cta_cobrar"
                    + " JOIN ck_cabecera_movi AS d ON c.id_cabecera_movi = d.id_cabecera_movi"
                    + " JOIN ck_cliente AS e ON e.codigo = d.codigo"
                    + " WHERE a.estado = 'A'"
                    + " AND a.fecha_pago::date >= '" + fecha_inicio + "'"
                    + " AND a.fecha_pago::date <= '" + fecha_fin + "'"
                    + " ORDER BY a.fecha_pago ASC";   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("id_pago"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
    public ArrayList<clsPago> consultaDataPagosFacturaRegistroFecha(String fecha_inicio, String fecha_fin)
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        
        try{
             bd.conectarBaseDeDatos();
             sql = " SELECT a.id_pago id_pago, a.id_cta_cobrar, a.id_usuario, b.name name_usuario, a.referencia referencia, "
                        + " c.descripcion  descripcion_cta_cobrar, c.valor valor_deuda, "
                        + " c.valor_actual, a.fecha_pago fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente, "
                        + "a.fecha_registro fecha_registro"
                    + " FROM ck_pagos_factura AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_cta_cobrar_facturas AS c ON a.id_cta_cobrar = c.id_cta_cobrar"
                    + " JOIN ck_cabecera_movi AS d ON c.id_cabecera_movi = d.id_cabecera_movi"
                    + " JOIN ck_cliente AS e ON e.codigo = d.codigo"
                    + " WHERE a.estado = 'A'"
                    + " AND a.fecha_registro::date >= '" + fecha_inicio + "'"
                    + " AND a.fecha_registro::date <= '" + fecha_fin + "'"
                    + " ORDER BY a.fecha_registro ASC";   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("id_pago"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
    public ArrayList<clsPago> consultaDataPagosOtrosRegistroFecha(String fecha_inicio, String fecha_fin, String arriendo)
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        
        try{
             bd.conectarBaseDeDatos();
             
             sql = " SELECT a.id_pagos_recibo id_pago, a.id_usuario, b.name name_usuario, a.referencia referencia, "
                        + " a.fecha_cobro fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente, "
                        + "a.fecha_pago fecha_registro"
                    + " FROM ck_pagos_recibo AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_cliente AS e ON a.codigo = e.codigo"
                    + " WHERE a.estado = 'A'"
                    + " AND a.fecha_pago::date >= '" + fecha_inicio + "'"
                    + " AND a.fecha_pago::date <= '" + fecha_fin + "'";
             if(arriendo.equals("2"))
             {
                 sql = sql + "AND referencia LIKE 'WEB%'";
             }
             if(arriendo.equals("1"))
             {
                 sql = sql + "AND referencia NOT LIKE 'WEB%'";
             }
             
             sql = sql + " ORDER BY a.fecha_pago ASC";   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("id_pago"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
    
     public ArrayList<clsPago> consultaDataPagosOtrosFecha(String fecha_inicio, String fecha_fin)
    {       
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        
        try{
             bd.conectarBaseDeDatos();
             
             sql = " SELECT a.id_pagos_recibo id_pago, a.id_usuario, b.name name_usuario, a.referencia referencia, "
                        + " a.fecha_cobro fecha_pago, a.estado, "
                        + " a.valor valor_pago, a.id_caja_operacion, e.name_completo nombre_cliente, "
                        + "a.fecha_pago fecha_registro"
                    + " FROM ck_pagos_recibo AS a"
                    + " JOIN ck_usuario AS b ON a.id_usuario = b.id_usuario"
                    + " JOIN ck_cliente AS e ON a.codigo = e.codigo"
                    + " WHERE a.estado = 'A'"
                    + " AND a.fecha_cobro::date >= '" + fecha_inicio + "'"
                    + " AND a.fecha_cobro::date <= '" + fecha_fin + "'"
                    + " ORDER BY a.fecha_cobro ASC";   
            
            System.out.println(sql);
            bd.resultado = bd.sentencia.executeQuery(sql);
               
            if(bd.resultado.next())
            {   
                do 
                { 
                    clsPago oListaTemporal = new clsPago();
                   
                    oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                    oListaTemporal.setFechaPago(bd.resultado.getString("fecha_pago"));
                    oListaTemporal.setNombreUsuario(bd.resultado.getString("name_usuario"));
                    oListaTemporal.setNombreCliente(bd.resultado.getString("nombre_cliente"));
                    oListaTemporal.setValor(bd.resultado.getDouble("valor_pago"));
                    oListaTemporal.setFechaRegistro(bd.resultado.getString("fecha_registro"));
                    oListaTemporal.setIdPago(bd.resultado.getInt("id_pago"));
                    data.add(oListaTemporal);
                }
                while(bd.resultado.next()); 
                //return data;
            }
            else
            { 
                data = null;
            }            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            data = null;
        } 
        bd.desconectarBaseDeDatos();
        return data;
     }
     
     public boolean registroReimpresion(String idPago, String motivo, String tipo)
    {       
        boolean exito=false;
        try
        {           
            bd.conectarBaseDeDatos();          
            sql = "INSERT INTO ck_reimpresion"
                    + " (id_usuario, motivo, id_pago, tipo)"
                    + " VALUES("+ main.idUser +", '" + motivo + "', " + idPago + ", '" + tipo + "')";           
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
     
    public boolean asignarPago(int idCabecera, int idPago)
    {
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();
            sql = "UPDATE ck_pagos_recibo"
                    + " SET id_cabecera_movi = " + idCabecera + ", "
                    + " estado_asignado = 'S'"
                    + " WHERE id_pagos_recibo = " + idPago;      
           
            //System.out.println("SQL enviado:" + sql);
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
     
    public double obtenerValorAsignado(int idCabecera)
    {          
        double nombreCajero = 0.00; 
        try{
            bd.conectarBaseDeDatos();

            sql = "SELECT sum(valor) AS total"
                    + " FROM ck_pagos_recibo"
                    + " WHERE id_cabecera_movi = " + idCabecera;
            System.out.println(sql);        
            bd.resultado = bd.sentencia.executeQuery(sql);             
            while(bd.resultado.next()){               
                nombreCajero = bd.resultado.getDouble("total");              
            }
            //return nombreCajero;            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            nombreCajero = 0;
        }     
        bd.desconectarBaseDeDatos();
        return nombreCajero;
    }
                                                        
    public double consultaDataCuotaPendiente(String idCabeceraArriendo)
    {          
        double nombreCajero = 0.00; 
        try{
            bd.conectarBaseDeDatos();

            sql = "SELECT valor_abono_pendiente" 
                    + " FROM ck_abono_arriendo"                    
                    + "	WHERE id_abono_arriendo = " + idCabeceraArriendo;
            System.out.println(sql);        
            bd.resultado = bd.sentencia.executeQuery(sql);             
            while(bd.resultado.next()){               
                nombreCajero = bd.resultado.getDouble("valor_abono_pendiente");              
            }
            //return nombreCajero;            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            nombreCajero = 0;
        }     
        bd.desconectarBaseDeDatos();
        return nombreCajero;
    }
    
    public double consultaTotalDeudaNE(int idCliente)
    {          
        double totalDeuda = 0.00; 
        try{
            bd.conectarBaseDeDatos();

            sql = "select sum(valor_actual) actual " 
                    + " FROM ck_cta_cobrar AS a " 
                    + " JOIN ck_notas_de_entrega AS c ON a.id_cabecera_movi = c.id_cabecera_movi " 
                    + " JOIN ck_cliente AS b ON c.codigo = b.codigo" 
                    + " WHERE b.codigo = " + idCliente
                    + " AND a.estado = 'A'"
                    + " AND c.estado = 'A'"
                    + " AND estado_tramite = 'S'";
            System.out.println(sql);        
            bd.resultado = bd.sentencia.executeQuery(sql);             
            while(bd.resultado.next()){               
                totalDeuda = bd.resultado.getDouble("actual");              
            }
            //return nombreCajero;            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            totalDeuda = 0;
        }     
        bd.desconectarBaseDeDatos();
        return totalDeuda;
    }
    
     public double consultaTotalDeudaFacturas(int idCliente)
    {          
        double totalDeuda = 0.00; 
        try{
            bd.conectarBaseDeDatos();

            sql = "select sum(valor_actual) actual " 
                    + " FROM ck_cta_cobrar_facturas AS a " 
                    + " JOIN ck_cabecera_movi AS c ON a.id_cabecera_movi = c.id_cabecera_movi " 
                    + " JOIN ck_cliente AS b ON c.codigo = b.codigo" 
                    + " WHERE b.codigo = " + idCliente
                    + " AND a.estado = 'A'"
                    + " AND c.estado = 'A'";
            System.out.println(sql);        
            bd.resultado = bd.sentencia.executeQuery(sql);             
            while(bd.resultado.next()){               
                totalDeuda = bd.resultado.getDouble("actual");              
            }
            //return nombreCajero;            
        }
        catch(Exception ex)
        {
            System.out.print(ex);
            totalDeuda = 0;
        }     
        bd.desconectarBaseDeDatos();
        return totalDeuda;
    }
     
     public ArrayList<clsPago>  consultaDataPagoPendienteAsignar(String txtIdPago){            
        ArrayList<clsPago> data = new ArrayList<clsPago>(); 
        try{
            bd.conectarBaseDeDatos();
            sql = "SELECT a.id_pagos_recibo id_pagos_recibo, a.tipo_recibo tipo_recibo " +
                    "FROM ck_pagos_recibo AS a " +                   
                    //"WHERE a.ne_contado = 'N' " +
                    "WHERE a.estado_asignado = 'N' " +
                    "AND a.estado = 'A' " +
                    "AND a.codigo_recibo = " + txtIdPago;
            bd.resultado = bd.sentencia.executeQuery(sql);
              
            while(bd.resultado.next()){
                clsPago oListaTemporal = new clsPago();
                oListaTemporal.setIdPago(bd.resultado.getInt("id_pagos_recibo")); 
                oListaTemporal.setTipoRecibo(bd.resultado.getInt("tipo_recibo")); 
                /*oListaTemporal.setCedula(bd.resultado.getString("cedula"));
                oListaTemporal.setNombreCliente(bd.resultado.getString("name_completo"));
                oListaTemporal.setReferencia(bd.resultado.getString("referencia"));
                oListaTemporal.setValor(bd.resultado.getDouble("valor"));   
                oListaTemporal.setFechaCobro(bd.resultado.getString("fecha"));     
                oListaTemporal.setNombreUsuario(bd.resultado.getString("usu_registra"));
                oListaTemporal.setNombreCobrador(bd.resultado.getString("usu_cobra"));
                oListaTemporal.setCodigoRecibo(bd.resultado.getInt("codigo_recibo"));*/
                
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
     
     public boolean modificarPago(int idPago, String cuota_inicial, String ne_contado, String tipo_recibo)
    {
        boolean exito;
        try
        {           
            bd.conectarBaseDeDatos();
            sql = "UPDATE ck_pagos_recibo"
                    + " SET cuota_inicial = '" + cuota_inicial + "', "
                    + " ne_contado = '" + ne_contado + "',"
                    + " tipo_recibo = '" + tipo_recibo + "'"
                    + " WHERE id_pagos_recibo = " + idPago;      
           
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
