/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmFacturar.java
 *
 * Created on 23-oct-2011, 15:34:09
 */
package transferencias;

import clases.clsAuditoria;
import clases.clsCabecera;
import clases.clsCaja;
import clases.clsCliente;
import clases.clsColorRegistrarTransferencia;
import clases.clsComboBox;
import clases.clsCompras;
import clases.clsCuota;
import clases.clsDetalle;
import clases.clsEmail;
import clases.clsImpuestos;
import clases.clsKardex;
import clases.clsParametros;
import clases.clsPrecio;
import clases.clsProducto;
import clases.clsReporte;
import clases.clsUtils;
import clases.javaMail;
import com.jidesoft.hints.ListDataIntelliHints;
import com.jidesoft.swing.SelectAllUtils;
import index.main;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pago.frmPagoNuevoAdd;
import reportes.frmListEntradasAsignadas2;
import stinventario.frmPrincipal;

/**
 *
 * @author Kaiser
 */
public class frmFactHistoShow_transferencia_externo extends javax.swing.JDialog {
    clsCliente objCliente = new clsCliente();
    clsProducto objProducto = new clsProducto();
    clsPrecio objPrecio = new clsPrecio();
    clsUtils objUtils = new clsUtils();
    clsCaja objCaja = new clsCaja();
    clsCabecera objCabecera = new clsCabecera();
    clsCuota objCuota = new clsCuota();
    clsDetalle objDetalle = new clsDetalle();
    clsImpuestos objImpuestos = new clsImpuestos();
    clsReporte objReporte = new clsReporte();
    clsAuditoria objAuditoria = new clsAuditoria();
    clsCompras objCompras = new clsCompras();
    clsKardex objKardex = new clsKardex();
    clsParametros objParametros = new clsParametros();
    clsEmail objEmail = new clsEmail();
    
    MiModelo dtmData = new MiModelo();
    String idCajero="";
    String idCajaAbierta = "";
    int filas=0;
    //CODIGO DEL CLIENTE SELECCIONADO
    public static int codigoEmpresa;
    //CODIGO DEL PRODUCTO SELECCIONADO 
    public static int codigoProducto;
    int idCabecera;
    int id_empresa;
    String tipo_venta = "";
    String p_ip = "";
    String nombre_empresa = "";                                                                                                                                                             
    
    /** Creates new form frmFacturar */
    public frmFactHistoShow_transferencia_externo(java.awt.Frame parent, boolean modal, int p_idCabecera, String ip) {
        super(parent, modal);
        initComponents();  
        this.setTitle(objUtils.nombreSistema + "Datos de factura");
        
        idCabecera = p_idCabecera; 
        p_ip = ip;
        //cosnulto y luego veo si es a contado o credito
        ArrayList <clsCabecera> dataCabecera;
        dataCabecera = objCabecera.consultarDataCabeceraCredito_transferencia_externo(idCabecera, p_ip);
        
        if(dataCabecera.isEmpty())
        {
            //LA NOTA DE  ENTREGA FUE A  CONTADO
            tipo_venta = "CONTADO";
            
            dataCabecera = objCabecera.consultarDataCabeceraNotaEntrega_transferencia_externo(idCabecera, p_ip);
            
            //txtCedula.setText(dataCabecera.get(0).getCedula());
            txtNombreCliente.setText(dataCabecera.get(0).getNameCompleto());
            txtFacturaReferencia.setText(dataCabecera.get(0).getFactReferencia());
            txtComentario.setText(dataCabecera.get(0).getComentario());
            txtTipoCuota.setText(dataCabecera.get(0).getDescripcion());
            txtCuota.setText("" + dataCabecera.get(0).getValor());
            txtFechaVenta.setText(dataCabecera.get(0).getFecha());
            txtEfectivo.setText("" + dataCabecera.get(0).getEfectivo());        
            txtTotal.setText("" + dataCabecera.get(0).getTotal());         
            txtSaldo.setText("" + objUtils.redondear(dataCabecera.get(0).getSaldo()));
            this.txtDescuento.setText("" + dataCabecera.get(0).getDescuento());
            this.txtTarifaCero.setText("" + dataCabecera.get(0).getTarifaCero());
            this.txtTarifaIVA.setText("" + dataCabecera.get(0).getTarifaIVA());
            txtIVA.setText("" + dataCabecera.get(0).getIVA());
            nombre_empresa = dataCabecera.get(0).getNameCompleto();
            id_empresa = dataCabecera.get(0).getIdEmpresa();
        }
        else
        {
            //LA NOTA DE  ENTREGA FUE A  CREDITO
            tipo_venta = "CREDITO";
            
            //txtCedula.setText(dataCabecera.get(0).getCedula());
            txtNombreCliente.setText(dataCabecera.get(0).getNameCompleto());
            txtFacturaReferencia.setText(dataCabecera.get(0).getFactReferencia());
            txtComentario.setText(dataCabecera.get(0).getComentario());
            txtTipoCuota.setText(dataCabecera.get(0).getDescripcion());
            txtCuota.setText(""+dataCabecera.get(0).getValor());
            txtFechaVenta.setText(dataCabecera.get(0).getFecha().substring(0, 16));
            txtEfectivo.setText(""+dataCabecera.get(0).getEfectivo());        
            txtTotal.setText("" + dataCabecera.get(0).getTotal());    
            Double cantidadAdeudada = objUtils.redondear(dataCabecera.get(0).getSaldo());
            txtSaldo.setText(""+ cantidadAdeudada);
            txtPlazo.setText(dataCabecera.get(0).getDescripcionPlazo());
            txtVendedor.setText(dataCabecera.get(0).getNombreVendedor());
            this.txtDescuento.setText(""+dataCabecera.get(0).getDescuento());
            this.txtTarifaCero.setText(""+dataCabecera.get(0).getTarifaCero());
            this.txtTarifaIVA.setText("" + dataCabecera.get(0).getTarifaIVA());
            txtIVA.setText(""+dataCabecera.get(0).getIVA());

            txtTarifaIVA1.setText(""+dataCabecera.get(0).getTarifaIVA1());
            txtTarifaCero1.setText(""+dataCabecera.get(0).getTarifaCero1());
            txtDescuento1.setText(""+dataCabecera.get(0).getDescuento());
            txtIVA1.setText("" + dataCabecera.get(0).getIVA1());
            txtTotal1.setText("" + dataCabecera.get(0).getTotal1());
            
            txtFechaCancelacion.setText(dataCabecera.get(0).getFechaCancelacionSistema().substring(0, 10));
            Double interes = dataCabecera.get(0).getPorcentajeInteres();
            
            double valorInteres = cantidadAdeudada * interes / 100;
            txtInteresPorcentaje.setText("" + interes);
            txtInteresValor.setText("" + valorInteres);
            double cantidadInteres =  cantidadAdeudada * (1 + (interes/100));
            txtSaldoMasInteres.setText("" + objUtils.redondear(cantidadInteres));
        }
        //COLUMNA OCULTA
        dtmData.addColumn("idProducto");
        //objUtils.setOcultarColumnasJTable(tblData, new int[]{6});
        dtmData.addColumn("N°");/*.setPreferredWidth(500)*/
        dtmData.addColumn("Codigo");
        dtmData.addColumn("Descripción");
        dtmData.addColumn("Cantidad");
        dtmData.addColumn("Precio Unitario");
        dtmData.addColumn("Total"); 
        dtmData.addColumn("IVA"); 
        dtmData.addColumn("Descuento"); 
        dtmData.addColumn("CREADO"); 
        
        ArrayList <clsDetalle> dataDetalle = objDetalle.consultarDataDetalleNotaEntrega_externo(idCabecera, p_ip);
        objUtils.vaciarTabla(dtmData);
        for(int i=0; i<dataDetalle.size(); i++)
        {
            
            Double cantidad = dataDetalle.get(i).getCantidad();
            Double precio = dataDetalle.get(i).getPrecio();
            Double descuento = dataDetalle.get(i).getDescuento();
            Double iva = dataDetalle.get(i).getIVA();
            
            //VERIFICAR SI EXISTE EL CODIGO
            String codigo =  dataDetalle.get(i).getCodigoProducto();
            String existe = "NO";
            if(objProducto.comprobarCodigo(codigo))
                existe = "SI";
            Object[] nuevaFila = {dataDetalle.get(i).getIdProducto()
                        , i+1 
                        , codigo
                        , dataDetalle.get(i).getDescripcionProducto()
                        , cantidad
                        , precio
                        , dataDetalle.get(i).getCantidad()*dataDetalle.get(i).getPrecio()
                        , iva
                        , descuento
                        , existe};
            dtmData.addRow(nuevaFila); 
        }
        
        tblData.setDefaultRenderer (Object.class, new clsColorRegistrarTransferencia());
    }   
    
    public class MiModelo extends DefaultTableModel
    {
            @Override
       public boolean isCellEditable (int row, int column)
       {
           // Aquí devolvemos true o false según queramos que una celda
           // identificada por fila,columna (row,column), sea o no editable
          /* if (column == 3)
              return true;*/
           
           return false;
       }
    } 

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFacturaReferencia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtFechaVenta = new javax.swing.JTextField();
        txtVendedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtEfectivo = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTarifaCero = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtTarifaIVA = new javax.swing.JTextField();
        txtTarifaIVA1 = new javax.swing.JTextField();
        txtTarifaCero1 = new javax.swing.JTextField();
        txtDescuento1 = new javax.swing.JTextField();
        txtIVA1 = new javax.swing.JTextField();
        txtTotal1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCuota = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtFechaCancelacion = new javax.swing.JTextField();
        txtPlazo = new javax.swing.JTextField();
        txtTipoCuota = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtInteresValor = new javax.swing.JTextField();
        txtInteresPorcentaje = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtSaldoMasInteres = new javax.swing.JTextField();
        btnImprimir = new javax.swing.JButton();
        btnRecibirTransferencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(stinventario.STInventarioApp.class).getContext().getResourceMap(frmFactHistoShow_transferencia_externo.class);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        txtNombreCliente.setEditable(false);
        txtNombreCliente.setText(resourceMap.getString("txtNombreCliente.text")); // NOI18N
        txtNombreCliente.setName("txtNombreCliente"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        txtFacturaReferencia.setEditable(false);
        txtFacturaReferencia.setText(resourceMap.getString("txtFacturaReferencia.text")); // NOI18N
        txtFacturaReferencia.setName("txtFacturaReferencia"); // NOI18N

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        txtComentario.setEditable(false);
        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        txtComentario.setName("txtComentario"); // NOI18N
        jScrollPane2.setViewportView(txtComentario);

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        txtFechaVenta.setEditable(false);
        txtFechaVenta.setText(resourceMap.getString("txtFechaVenta.text")); // NOI18N
        txtFechaVenta.setName("txtFechaVenta"); // NOI18N

        txtVendedor.setEditable(false);
        txtVendedor.setText(resourceMap.getString("txtVendedor.text")); // NOI18N
        txtVendedor.setName("txtVendedor"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFacturaReferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFacturaReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel2.border.title"))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblData.setModel(dtmData);
        tblData.setName("tblData"); // NOI18N
        tblData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblDataKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        txtTotal.setEditable(false);
        txtTotal.setFont(resourceMap.getFont("txtTotal.font")); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText(resourceMap.getString("txtTotal.text")); // NOI18N
        txtTotal.setDragEnabled(true);
        txtTotal.setName("txtTotal"); // NOI18N

        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N

        txtEfectivo.setEditable(false);
        txtEfectivo.setText(resourceMap.getString("txtEfectivo.text")); // NOI18N
        txtEfectivo.setName("txtEfectivo"); // NOI18N

        txtSaldo.setEditable(false);
        txtSaldo.setText(resourceMap.getString("txtSaldo.text")); // NOI18N
        txtSaldo.setName("txtSaldo"); // NOI18N

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel16.setFont(resourceMap.getFont("jLabel16.font")); // NOI18N
        jLabel16.setText(resourceMap.getString("jLabel16.text")); // NOI18N
        jLabel16.setName("jLabel16"); // NOI18N

        txtIVA.setEditable(false);
        txtIVA.setFont(resourceMap.getFont("txtIVA.font")); // NOI18N
        txtIVA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIVA.setText(resourceMap.getString("txtIVA.text")); // NOI18N
        txtIVA.setName("txtIVA"); // NOI18N

        jLabel18.setFont(resourceMap.getFont("jLabel18.font")); // NOI18N
        jLabel18.setText(resourceMap.getString("jLabel18.text")); // NOI18N
        jLabel18.setName("jLabel18"); // NOI18N

        txtDescuento.setEditable(false);
        txtDescuento.setFont(resourceMap.getFont("txtDescuento.font")); // NOI18N
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescuento.setText(resourceMap.getString("txtDescuento.text")); // NOI18N
        txtDescuento.setName("txtDescuento"); // NOI18N

        jLabel17.setFont(resourceMap.getFont("jLabel17.font")); // NOI18N
        jLabel17.setText(resourceMap.getString("jLabel17.text")); // NOI18N
        jLabel17.setName("jLabel17"); // NOI18N

        txtTarifaCero.setEditable(false);
        txtTarifaCero.setFont(resourceMap.getFont("txtTarifaCero.font")); // NOI18N
        txtTarifaCero.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTarifaCero.setText(resourceMap.getString("txtTarifaCero.text")); // NOI18N
        txtTarifaCero.setName("txtTarifaCero"); // NOI18N

        jLabel21.setFont(resourceMap.getFont("jLabel21.font")); // NOI18N
        jLabel21.setText(resourceMap.getString("jLabel21.text")); // NOI18N
        jLabel21.setName("jLabel21"); // NOI18N

        txtTarifaIVA.setEditable(false);
        txtTarifaIVA.setFont(resourceMap.getFont("txtTarifaIVA.font")); // NOI18N
        txtTarifaIVA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTarifaIVA.setText(resourceMap.getString("txtTarifaIVA.text")); // NOI18N
        txtTarifaIVA.setName("txtTarifaIVA"); // NOI18N

        txtTarifaIVA1.setEditable(false);
        txtTarifaIVA1.setFont(resourceMap.getFont("txtTarifaIVA1.font")); // NOI18N
        txtTarifaIVA1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTarifaIVA1.setText(resourceMap.getString("txtTarifaIVA1.text")); // NOI18N
        txtTarifaIVA1.setName("txtTarifaIVA1"); // NOI18N

        txtTarifaCero1.setEditable(false);
        txtTarifaCero1.setFont(resourceMap.getFont("txtTarifaCero1.font")); // NOI18N
        txtTarifaCero1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTarifaCero1.setText(resourceMap.getString("txtTarifaCero1.text")); // NOI18N
        txtTarifaCero1.setName("txtTarifaCero1"); // NOI18N

        txtDescuento1.setEditable(false);
        txtDescuento1.setFont(resourceMap.getFont("txtDescuento1.font")); // NOI18N
        txtDescuento1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescuento1.setText(resourceMap.getString("txtDescuento1.text")); // NOI18N
        txtDescuento1.setName("txtDescuento1"); // NOI18N

        txtIVA1.setEditable(false);
        txtIVA1.setFont(resourceMap.getFont("txtIVA1.font")); // NOI18N
        txtIVA1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIVA1.setText(resourceMap.getString("txtIVA1.text")); // NOI18N
        txtIVA1.setName("txtIVA1"); // NOI18N

        txtTotal1.setEditable(false);
        txtTotal1.setFont(resourceMap.getFont("txtTotal1.font")); // NOI18N
        txtTotal1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal1.setText(resourceMap.getString("txtTotal1.text")); // NOI18N
        txtTotal1.setDragEnabled(true);
        txtTotal1.setName("txtTotal1"); // NOI18N

        jLabel25.setText(resourceMap.getString("jLabel25.text")); // NOI18N
        jLabel25.setName("jLabel25"); // NOI18N

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        txtCuota.setEditable(false);
        txtCuota.setName("txtCuota"); // NOI18N

        jLabel24.setText(resourceMap.getString("jLabel24.text")); // NOI18N
        jLabel24.setName("jLabel24"); // NOI18N

        txtFechaCancelacion.setEditable(false);
        txtFechaCancelacion.setForeground(resourceMap.getColor("txtFechaCancelacion.foreground")); // NOI18N
        txtFechaCancelacion.setText(resourceMap.getString("txtFechaCancelacion.text")); // NOI18N
        txtFechaCancelacion.setDisabledTextColor(resourceMap.getColor("txtFechaCancelacion.disabledTextColor")); // NOI18N
        txtFechaCancelacion.setName("txtFechaCancelacion"); // NOI18N

        txtPlazo.setEditable(false);
        txtPlazo.setText(resourceMap.getString("txtPlazo.text")); // NOI18N
        txtPlazo.setName("txtPlazo"); // NOI18N

        txtTipoCuota.setEditable(false);
        txtTipoCuota.setText(resourceMap.getString("txtTipoCuota.text")); // NOI18N
        txtTipoCuota.setName("txtTipoCuota"); // NOI18N

        jLabel30.setText(resourceMap.getString("jLabel30.text")); // NOI18N
        jLabel30.setName("jLabel30"); // NOI18N

        txtInteresValor.setEditable(false);
        txtInteresValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtInteresValor.setText(resourceMap.getString("txtInteresValor.text")); // NOI18N
        txtInteresValor.setName("txtInteresValor"); // NOI18N

        txtInteresPorcentaje.setEditable(false);
        txtInteresPorcentaje.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtInteresPorcentaje.setText(resourceMap.getString("txtInteresPorcentaje.text")); // NOI18N
        txtInteresPorcentaje.setName("txtInteresPorcentaje"); // NOI18N

        jLabel28.setText(resourceMap.getString("jLabel28.text")); // NOI18N
        jLabel28.setName("jLabel28"); // NOI18N

        jLabel19.setText(resourceMap.getString("jLabel19.text")); // NOI18N
        jLabel19.setName("jLabel19"); // NOI18N

        txtSaldoMasInteres.setEditable(false);
        txtSaldoMasInteres.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSaldoMasInteres.setText(resourceMap.getString("txtSaldoMasInteres.text")); // NOI18N
        txtSaldoMasInteres.setName("txtSaldoMasInteres"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTipoCuota, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addComponent(txtPlazo)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFechaCancelacion, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCuota)
                                    .addComponent(txtEfectivo)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(txtInteresPorcentaje, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(14, 14, 14)))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtInteresValor, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                    .addComponent(txtSaldo))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(8, 8, 8)
                                .addComponent(txtSaldoMasInteres)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel18)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescuento)
                            .addComponent(txtTarifaCero)
                            .addComponent(txtTarifaIVA)
                            .addComponent(txtIVA)
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIVA1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(txtDescuento1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTarifaCero1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTarifaIVA1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTotal1))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTarifaIVA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTarifaCero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(txtDescuento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIVA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTarifaIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21)
                                    .addComponent(txtSaldo)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTarifaCero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel28)
                                        .addComponent(txtInteresPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel19)
                                    .addComponent(txtSaldoMasInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal)
                            .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel14)
                            .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)
                                .addComponent(jLabel30)
                                .addComponent(txtInteresValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(txtTipoCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtFechaCancelacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        btnImprimir.setIcon(resourceMap.getIcon("btnImprimir.icon")); // NOI18N
        btnImprimir.setText(resourceMap.getString("btnImprimir.text")); // NOI18N
        btnImprimir.setEnabled(false);
        btnImprimir.setName("btnImprimir"); // NOI18N
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnRecibirTransferencia.setIcon(resourceMap.getIcon("btnRecibirTransferencia.icon")); // NOI18N
        btnRecibirTransferencia.setText(resourceMap.getString("btnRecibirTransferencia.text")); // NOI18N
        btnRecibirTransferencia.setName("btnRecibirTransferencia"); // NOI18N
        btnRecibirTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecibirTransferenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRecibirTransferencia)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir)
                    .addComponent(btnRecibirTransferencia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
    boolean busquedaProducto(int codProducto)
    {
        boolean bandera=false;
        int maxData = dtmData.getRowCount();
        
        for(int i=0; i<maxData; i++)
        {
            //System.out.println("1: "+dtmData.getValueAt(i, 2)+ "2:"+codProducto);
            if(dtmData.getValueAt(i, 0).equals(codProducto))
            {
                bandera = true;
            }           
        }
        return bandera;
    }   
    
private void tblDataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDataKeyTyped
    
}//GEN-LAST:event_tblDataKeyTyped

private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
    //etso no se puede hacer porque es remoto
    objReporte.ejecutarReporteParametroInt(idCabecera, "rptNotaEntrega");         // TODO add your handling code here:
     this.dispose();
}//GEN-LAST:event_btnImprimirActionPerformed

    private void btnRecibirTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecibirTransferenciaActionPerformed
        registrar_transferencia();
        recibir_transferencia();
        
        
    }//GEN-LAST:event_btnRecibirTransferenciaActionPerformed

    public void recibir_transferencia()
    {
        int maxData = 0; 
        double cantidad = 0.00;
        int ultmFactura = objCabecera.obtenerUltimaFacturaCompras(main.idUser); 
        try
        {             
            
            if(objCompras.recibirMercaderia(ultmFactura, main.idUser))
            {
                maxData = dtmData.getRowCount();
                //int ultmFactura = objCabecera.obtenerUltimaFacturaCompras(main.idUser);
                //System.out.println("S: " + ultmFactura);
                for(int i=0; i<maxData; i++)
                {                       
                    //factura, idProducto
                    int idProducto = Integer.parseInt(dtmData.getValueAt(i, 0).toString());
                    cantidad = Double.parseDouble(""+dtmData.getValueAt(i, 4));
                    double precio = Double.parseDouble(""+dtmData.getValueAt(i, 5));
                    //String iva = ""+dtmData.getValueAt(i, 7);
                    //String descuento = ""+dtmData.getValueAt(i, 8);

                    //exito = objDetalle.insertarDetalleCompras(ultmFactura, idProducto, cantidad, precio, descuento, iva);
                    
                    //FACTURA
                    objKardex.insertarKardex(idProducto, 
                            "TRANSFERENCIA, ID FACTURA: " + ultmFactura + ", CODIGO REFERENCIA: " + txtFacturaReferencia.getText(), 
                            "+"+cantidad,
                            ""+id_empresa,
                            nombre_empresa,
                            "" + precio,
                            precio,
                            "INGRESO",
                            ultmFactura);
                     
                    objProducto.aumentarStock(idProducto, cantidad);
                    //COMPROBAR SI SE  LE SUMA IVA
                    boolean verificarIVA = objImpuestos.comprobarImpuesto(idProducto, "1");
                    if(verificarIVA)
                    {    
                        objProducto.actualizarCosto(idProducto, (precio*(1+(objImpuestos.obtenerPorcentajeIVA()/100))));
                    }
                    else
                    {
                        objProducto.actualizarCosto(idProducto, precio);
                    }                             
                }                        
                JOptionPane.showMessageDialog(this, "Compra recibida con éxito", "Atención!", JOptionPane.INFORMATION_MESSAGE);        
                objAuditoria.insertarAuditoria("frmFactHistoShow_transferencia_externo", "COMPRA RECIBIDA,  CODIGO: " + ultmFactura + ", CON VALOR: " + txtTotal.getText(), "3");                 
                dispose();
                //frmListCompras formulario = new frmListCompras();
                //mostrarJInternalCentrado(formulario); 

            }//if
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        //ENVIO DE CORREO
        String email_habilitado = objParametros.consultaValor("email_habilitado");
        if(email_habilitado.equals("1"))
        {
             try{
                  String texto = "EL USUARIO: " 
                  + main.nameUser+ ", CONFIRMO LA TRANSFERENCIA: " + ultmFactura + "</BR></BR>"
                          //+ "COMENTARIO: " + txtComentario.getText() + "</BR>"
                          + "<TABLE BORDER=\"1\">"
                                  + "<TR><TD>DESCRIPCION</TD><TD>VALOR</TD></TR>"
                                  + "<TR><TD>FECHA DE REGISTRO:</TD><TD>" + txtFechaVenta.getText() + "</TD></TR>"
                                  + "<TR><TD>FECHA DE FACTURA:</TD><TD>" + txtFechaVenta.getText() + "</TD></TR>"
                                  + "<TR><TD>EMPRESA:</TD><TD>" + nombre_empresa + "</TD></TR>"
                                  //+ "<TR><TD>CREDITO:</TD><TD>" + txtDatoCredito.getText() + "</TD></TR>"
                                  //+ "<TR><TD>DESCUENTO:</TD><TD>" + txtDescuento1.getText() + "</TD></TR>";                 
                                  + "<TR><TD>TOTAL:</TD><TD>" + txtTotal.getText() + "</TD></TR>"                  
                  //texto = texto  + "<TR><TD>VENDEDOR:</TD><TD>" + txtVendedor.getText() + "</TD></TR>"
                              + "</TABLE></BR></BR>"
                              + "<TABLE BORDER=\"1\">"
                              + "<TR><TD>PRODUCTO</TD><TD>CANTIDAD</TD></TR>" ;

                  String descripcion = "";
                  for(int i=0; i<maxData; i++)        
                  {     
                      descripcion = "" + dtmData.getValueAt(i, 3);
                      cantidad = Double.parseDouble(""+dtmData.getValueAt(i, 4));      
                      texto = texto + "<TR><TD>" + descripcion + "</TD><TD>" + cantidad + "</TD></TR>";
                  }  
                  texto = texto + "</TABLE>";

                  javaMail mail = new javaMail();
                  ArrayList<clsEmail> dataEmail = objEmail.consultarEmails("10");        
                  for(int i=0;i<dataEmail.size();i=i+1)
                  {
                      mail.send(dataEmail.get(i).getEmail(), "TRANSFERENCIA - CONFIRMACION", texto);
                  }
              }
              catch(Exception e){
                  //e.printStackTrace();
                  JOptionPane.showMessageDialog(this, e.getMessage(), "Error al enviar por correo", JOptionPane.ERROR_MESSAGE);
              }
        }
        //ENVIO DE CORREO - FIN
    }
    
    public void registrar_transferencia()
    {
        boolean exito = false;
        int idProducto = 0;
        Double cantidad = 0.00;
        Double precio = 0.00; 
        String iva = "";
        String documento = "";
        String pvp = "";
        String descuento = "";
        /*exito = objCabecera.insertarRegistroCompras(id_empresa, main.idUser, 
                txtTotal.getText(), main.idEmpresa, "0", "0", "0", 
                "0", txtFacturaReferencia.getText(), "T", 
                "0", "0", "0", txtFechaVenta.getText(),
                "", "1",);    */    // TODO add your handling code here:
        
        int maxData = 0;
        if(exito)
        {
            try
            {                          
                maxData = dtmData.getRowCount();
                int ultmFactura = objCabecera.obtenerUltimaFacturaCompras(main.idUser);
                //System.out.println("S: " + ultmFactura);
                
                for(int i=0; i<maxData; i++)
                {                       
                   
        
                //factura, idProducto
                    idProducto = Integer.parseInt(dtmData.getValueAt(i, 0).toString());
                    cantidad = Double.parseDouble(""+dtmData.getValueAt(i, 4));
                    precio = Double.parseDouble(""+dtmData.getValueAt(i, 5));
                    iva = ""+dtmData.getValueAt(i, 7);
                    descuento = ""+dtmData.getValueAt(i, 8);
                    pvp = ""+dtmData.getValueAt(i, 5);
                    
                    exito = objDetalle.insertarDetalleCompras(ultmFactura, idProducto, cantidad, precio, descuento, iva, pvp);
                                    
                }                        
                //JOptionPane.showMessageDialog(this, "Transferencia registrada con éxito", "Atención!", JOptionPane.INFORMATION_MESSAGE);        
                objAuditoria.insertarAuditoria("frmFactHistoShow_transferencia_externo", "INGRESO DE LA TRANSFERENCIA CODIGO: "+ultmFactura+ ", CON VALOR: " + txtTotal.getText(), "3");
                
                this.dispose();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                //p_exito = false;
            }
            //Vaciar Datos para facturar de nuevo
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Error al ingresar la información", "Atención!", JOptionPane.ERROR_MESSAGE);      
            //p_exito = false;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmFactHistoShow_transferencia_externo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmFactHistoShow_transferencia_externo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmFactHistoShow_transferencia_externo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmFactHistoShow_transferencia_externo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmFactHistoShow_transferencia_externo dialog = new frmFactHistoShow_transferencia_externo(new javax.swing.JFrame(), true, 0, "");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public static void mostrarJInternalCentrado(javax.swing.JInternalFrame formulario)
    {
        Dimension desktopSize = frmPrincipal.jDesktopPane1.getSize();
        Dimension jInternalFrameSize = formulario.getSize();
        formulario.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height- jInternalFrameSize.height)/2);

        frmPrincipal.jDesktopPane1.add(formulario);
        formulario.show(); 
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRecibirTransferencia;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblData;
    private javax.swing.JTextArea txtComentario;
    private javax.swing.JTextField txtCuota;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtDescuento1;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtFacturaReferencia;
    private javax.swing.JTextField txtFechaCancelacion;
    private javax.swing.JTextField txtFechaVenta;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtIVA1;
    private javax.swing.JTextField txtInteresPorcentaje;
    private javax.swing.JTextField txtInteresValor;
    public static javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtPlazo;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtSaldoMasInteres;
    private javax.swing.JTextField txtTarifaCero;
    private javax.swing.JTextField txtTarifaCero1;
    private javax.swing.JTextField txtTarifaIVA;
    private javax.swing.JTextField txtTarifaIVA1;
    private javax.swing.JTextField txtTipoCuota;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotal1;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
