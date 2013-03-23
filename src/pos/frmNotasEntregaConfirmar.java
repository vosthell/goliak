/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmFacturar.java
 *
 * Created on 23-oct-2011, 15:34:09
 */
package pos;

import clases.clsCabecera;
import clases.clsCaja;
import clases.clsCliente;
import clases.clsCuota;
import clases.clsDetalle;
import clases.clsImpuestos;
import clases.clsKardex;
import clases.clsPago;
import clases.clsPrecio;
import clases.clsProducto;
import clases.clsUtils;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import stinventario.frmPrincipal;

/**
 *
 * @author Kaiser
 */
public class frmNotasEntregaConfirmar extends javax.swing.JInternalFrame {
    clsCliente objCliente = new clsCliente();
    clsProducto objProducto = new clsProducto();
    clsPrecio objPrecio = new clsPrecio();
    clsUtils objUtils = new clsUtils();
    clsCaja objCaja = new clsCaja();
    clsCabecera objCabecera = new clsCabecera();
    clsCuota objCuota = new clsCuota();
    clsDetalle objDetalle = new clsDetalle();
    clsImpuestos objImpuestos = new clsImpuestos();
    clsKardex objKardex = new clsKardex();
    clsPago objPago = new clsPago();
    
    MiModelo dtmData = new MiModelo();
    String idCajero="";
    String idCajaAbierta = "";
       
    int filas=0;
    //CODIGO DEL CLIENTE SELECCIONADO
    public static int codigoCliente;
    //CODIGO DEL PRODUCTO SELECCIONADO 
    public static int codigoProducto;
    int idCabecera; 
    /** Creates new form frmFacturar */
    public frmNotasEntregaConfirmar(int p_idCabecera) {        
        initComponents();  
        this.setTitle(objUtils.nombreSistema + "NOTA DE ENTREGA - CONFIRMAR");
        
        idCabecera = p_idCabecera; 
        
        ArrayList <clsCabecera> dataCabecera;
        dataCabecera = objCabecera.consultarDataCabeceraCredito(idCabecera);
        
        if(dataCabecera.isEmpty())
        {
            //LA NOTA DE ENTREGA FUE A CONTADO
            dataCabecera = objCabecera.consultarDataCabeceraNotaEntrega(idCabecera);
            
            txtCedula.setText(dataCabecera.get(0).getCedula());
            txtNombreCliente.setText(dataCabecera.get(0).getNameCompleto());
            txtMonica.setText(dataCabecera.get(0).getFactReferencia());
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
            
            codigoCliente = dataCabecera.get(0).getCodigo();
            btnConfirmar.setEnabled(true);
        }
        else
        {
            //LA NOTA DE ENTREGA FUE A CREDITO
            Double cuotaInicial = 0.00;
            Double cuotaInicialAsignada = 0.00;
            
            txtCedula.setText(dataCabecera.get(0).getCedula());
            txtNombreCliente.setText(dataCabecera.get(0).getNameCompleto());
            txtMonica.setText(dataCabecera.get(0).getFactReferencia());
            txtComentario.setText(dataCabecera.get(0).getComentario());
            txtTipoCuota.setText(dataCabecera.get(0).getDescripcion());
            txtCuota.setText(""+dataCabecera.get(0).getValor());
            txtFechaVenta.setText(dataCabecera.get(0).getFecha().substring(0, 16));
            cuotaInicial = dataCabecera.get(0).getEfectivo();
            txtEfectivo.setText("" + cuotaInicial);        
            txtTotal.setText("" + dataCabecera.get(0).getTotal());         
            txtSaldo.setText(""+objUtils.redondear(dataCabecera.get(0).getSaldo()));
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
            
            //OBTENER VALOR DE PAGOS ASIGNADOS
            cuotaInicialAsignada = objUtils.redondear(objPago.obtenerValorAsignado(idCabecera));
            txtAsignado.setText("" + cuotaInicialAsignada);
            
            codigoCliente = dataCabecera.get(0).getCodigo();
            
            //if(cuotaInicial == cuotaInicialAsignada)
            if(txtEfectivo.getText().equals(txtAsignado.getText()))
            {    
                btnConfirmar.setEnabled(true);
                btnAsignar.setEnabled(false);
            }  
            
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
        //oculta
        dtmData.addColumn("Total-Descuento");
        //oculta
        dtmData.addColumn("Cantidad_sin_iva");
        dtmData.addColumn("costo");
        objUtils.setOcultarColumnasJTable(this.tblData, new int[]{9, 10, 11});
        ArrayList <clsDetalle> dataDetalle = objDetalle.consultarDataDetalleNotaEntrega(idCabecera);
        objUtils.vaciarTabla(dtmData);
        for(int i=0; i<dataDetalle.size(); i++)
        {
            
            Double cantidad = dataDetalle.get(i).getCantidad();
            Double precio = dataDetalle.get(i).getPrecio();
            Double descuento = dataDetalle.get(i).getDescuento();
            Double iva = dataDetalle.get(i).getIVA();
            
            Object[] nuevaFila = {dataDetalle.get(i).getIdProducto()
                        , i+1 
                        , dataDetalle.get(i).getCodigoProducto()
                        , dataDetalle.get(i).getDescripcionProducto()
                        , cantidad
                        , precio
                        , dataDetalle.get(i).getCantidad()*dataDetalle.get(i).getPrecio()
                        , iva
                        , descuento
                        , 0
                        , 0
                        , dataDetalle.get(i).getCosto()};
            dtmData.addRow(nuevaFila); 
        }
        
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMonica = new javax.swing.JTextField();
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
        jLabel5 = new javax.swing.JLabel();
        txtAsignado = new javax.swing.JTextField();
        btnAsignar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(stinventario.STInventarioApp.class).getContext().getResourceMap(frmNotasEntregaConfirmar.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        txtCedula.setEditable(false);
        txtCedula.setText(resourceMap.getString("txtCedula.text")); // NOI18N
        txtCedula.setName("txtCedula"); // NOI18N

        txtNombreCliente.setEditable(false);
        txtNombreCliente.setText(resourceMap.getString("txtNombreCliente.text")); // NOI18N
        txtNombreCliente.setName("txtNombreCliente"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        txtMonica.setEditable(false);
        txtMonica.setText(resourceMap.getString("txtMonica.text")); // NOI18N
        txtMonica.setName("txtMonica"); // NOI18N

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        txtComentario.setColumns(20);
        txtComentario.setEditable(false);
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
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMonica, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtVendedor))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMonica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        txtAsignado.setEditable(false);
        txtAsignado.setForeground(resourceMap.getColor("txtAsignado.foreground")); // NOI18N
        txtAsignado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtAsignado.setText(resourceMap.getString("txtAsignado.text")); // NOI18N
        txtAsignado.setName("txtAsignado"); // NOI18N

        btnAsignar.setText(resourceMap.getString("btnAsignar.text")); // NOI18N
        btnAsignar.setName("btnAsignar"); // NOI18N
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFechaCancelacion))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPlazo))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(5, 5, 5))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCuota)
                                    .addComponent(txtTipoCuota, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtEfectivo, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                .addGap(32, 32, 32))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel21)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDescuento)
                                .addComponent(txtTarifaCero)
                                .addComponent(txtTarifaIVA, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                .addComponent(txtIVA)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIVA1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(txtTarifaCero1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(txtDescuento1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(txtTotal1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(txtTarifaIVA1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel14)
                            .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtTipoCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAsignar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaCancelacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTarifaIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(txtTarifaIVA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTarifaCero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(txtTarifaCero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(txtDescuento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIVA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal)
                            .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
                            .addComponent(jLabel3)))))
        );

        btnConfirmar.setIcon(resourceMap.getIcon("btnConfirmar.icon")); // NOI18N
        btnConfirmar.setText(resourceMap.getString("btnConfirmar.text")); // NOI18N
        btnConfirmar.setEnabled(false);
        btnConfirmar.setName("btnConfirmar"); // NOI18N
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmar)
                .addContainerGap(24, Short.MAX_VALUE))
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

private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
   int idProducto;
   String cantidad, precio;
   Double costo;
   try
   {
       int maxData = dtmData.getRowCount();
       for(int i=0; i<maxData; i++)
       {  
            idProducto = Integer.parseInt(dtmData.getValueAt(i, 0).toString());
            cantidad = "" + dtmData.getValueAt(i, 4);
            precio = "" + dtmData.getValueAt(i, 5);                        
            //iva = "" + dtmData.getValueAt(i, 7);
            //descuento = "" + dtmData.getValueAt(i, 8);
            costo = Double.parseDouble("" + dtmData.getValueAt(i, 11));
            objKardex.insertarKardex(idProducto, 
                                "NOTAS DE ENTREGA, ID NOTAS ENTREGA:" + idCabecera, 
                                "-" + cantidad,
                                txtCedula.getText(),
                                txtNombreCliente.getText(),
                                precio,
                                costo,
                                "EGRESO",
                                idCabecera);
            objProducto.disminuirStock(idProducto, cantidad);
       }    
       
       objCabecera.confirmarNotaEntrega(idCabecera);
                    
       JOptionPane.showMessageDialog(this, "Nota de entrega confirmada con éxito", "Atención!", JOptionPane.INFORMATION_MESSAGE);  
   }
   catch(Exception e)
   {
       System.out.println("Error:" + e.getMessage());
       JOptionPane.showMessageDialog(this, "Error al confirmar Nota de entrega", "Atención!", JOptionPane.ERROR_MESSAGE);  
   }
   dispose();
   
}//GEN-LAST:event_btnConfirmarActionPerformed

private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
    frmPagosCuotaInicial ventana = new frmPagosCuotaInicial(null, true, codigoCliente, idCabecera);        
    ventana.setLocationRelativeTo(null);
    ventana.setVisible(true);
    this.dispose();
    frmListNotasEntrega formulario = new frmListNotasEntrega();
    mostrarJInternalCentrado(formulario); 
}//GEN-LAST:event_btnAsignarActionPerformed
    
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
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtAsignado;
    public static javax.swing.JTextField txtCedula;
    private javax.swing.JTextArea txtComentario;
    private javax.swing.JTextField txtCuota;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtDescuento1;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtFechaCancelacion;
    private javax.swing.JTextField txtFechaVenta;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtIVA1;
    private javax.swing.JTextField txtMonica;
    public static javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtPlazo;
    private javax.swing.JTextField txtSaldo;
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
