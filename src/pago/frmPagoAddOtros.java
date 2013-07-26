/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmPagoAdd.java
 *
 * Created on 08-nov-2011, 10:25:57
 */
package pago;

import clases.clsAuditoria;
import clases.clsCaja;
import clases.clsCliente;
import clases.clsComboBox;
import clases.clsCtasCobrar;
import clases.clsGrupo;
import clases.clsPago;
import clases.clsReporte;
import clases.clsUtils;
import com.jidesoft.hints.ListDataIntelliHints;
import com.jidesoft.swing.SelectAllUtils;
import index.main;
import java.awt.Color;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import pos.frmFactDeudaShow;
import pos.frmFactHistoShow;
import pos.frmListClientes;

/**
 *
 * @author CKaiser
 */
public class frmPagoAddOtros extends javax.swing.JDialog {
    clsCliente objCliente = new clsCliente();
    clsCtasCobrar objCtasCobrar = new clsCtasCobrar();
    clsPago objPago = new clsPago();
    clsAuditoria objAuditoria = new clsAuditoria();
    clsUtils objUtils = new clsUtils();
    clsReporte objReporte = new clsReporte();
    clsCaja objCaja = new clsCaja();
    clsGrupo objGrupo = new clsGrupo();
    
    public static String codigoCliente;
    String idCajaAbierta = "";
    Double saldoActual;
    /** Creates new form frmPagoAdd */
    //MiModelo dtmData = new MiModelo();
    
    public frmPagoAddOtros(javax.swing.JFrame parent, boolean modal) {
         super(parent, modal);
         initComponents();
        //OBTENER IDCAJAOPERACION ACTUAL, OSEA QUE  NO ESTA CERRADA
        idCajaAbierta = objCaja.obtenerCajaAbierta(main.idUser);
        //OBTENER CAJERO
        String cajero = objCaja.obtenerCajero(main.idUser);
        lblCajero.setText(cajero);
        
        /*dtmData.addColumn("Nº");        
        dtmData.addColumn("Factura Referencia Monica");
        dtmData.addColumn("Descripcion");
        dtmData.addColumn("Valor");
        dtmData.addColumn("Saldo");
        dtmData.addColumn("idCtaCobrar");
        dtmData.addColumn("idCabecera");
        dtmData.addColumn("TIPO DE DOCUMENTO");*/
        
        List<String> dataCedula = objCliente.consultarCedulas(); 
        SelectAllUtils.install(txtCedula);
        ListDataIntelliHints intellihints = new ListDataIntelliHints(txtCedula, dataCedula);
        intellihints.setCaseSensitive(false);
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaActual = new Date();
        lblFechaActual.setText(""+df.format(fechaActual));  
        
        int idReciboDePago = objCaja.obtenerReciboPagoActual();
        txtReciboDePago.setText(""+idReciboDePago);
        
         /*clsComboBox oItem = new clsComboBox("1", "RECIBO");
         cmbTipoRecibo.addItem(oItem);     
         oItem = new clsComboBox("2", "CUOTA INICIAL");
         cmbTipoRecibo.addItem(oItem);     
         oItem = new clsComboBox("3", "ARRIENDO");
         cmbTipoRecibo.addItem(oItem);  
         oItem = new clsComboBox("4", "PLAN ACUMULATIVO");
         cmbTipoRecibo.addItem(oItem);  */
         
         //CARGAR GRUPO
         //cmbGrupo.removeAllItems();
         ArrayList<clsComboBox> dataGrupo = objGrupo.consultarTiposIngresos();  
         for(int i=0;i<dataGrupo.size();i=i+1)
         {
             clsComboBox oItem = new clsComboBox(dataGrupo.get(i).getCodigo(), dataGrupo.get(i).getDescripcion());
             cmbTipoRecibo.addItem(oItem);             
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
        jButton1 = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblFechaActual = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        cmbTipoRecibo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtValor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtReferencia = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtReciboDePago = new javax.swing.JTextField();
        btnGuardarPago = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblCajero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(stinventario.STInventarioApp.class).getContext().getResourceMap(frmPagoAddOtros.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtCedula.setText(resourceMap.getString("txtCedula.text")); // NOI18N
        txtCedula.setName("txtCedula"); // NOI18N
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        txtNombreCliente.setEditable(false);
        txtNombreCliente.setText(resourceMap.getString("txtNombreCliente.text")); // NOI18N
        txtNombreCliente.setName("txtNombreCliente"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        lblFechaActual.setText(resourceMap.getString("lblFechaActual.text")); // NOI18N
        lblFechaActual.setName("lblFechaActual"); // NOI18N

        btnBuscarCliente.setText(resourceMap.getString("btnBuscarCliente.text")); // NOI18N
        btnBuscarCliente.setName("btnBuscarCliente"); // NOI18N
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        cmbTipoRecibo.setName("cmbTipoRecibo"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCedula)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCliente))
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblFechaActual, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addGap(79, 79, 79))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipoRecibo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lblFechaActual)
                    .addComponent(jLabel3)
                    .addComponent(btnBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbTipoRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        txtValor.setBackground(resourceMap.getColor("txtValor.background")); // NOI18N
        txtValor.setFont(resourceMap.getFont("txtValor.font")); // NOI18N
        txtValor.setText(resourceMap.getString("txtValor.text")); // NOI18N
        txtValor.setName("txtValor"); // NOI18N
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        txtReferencia.setColumns(20);
        txtReferencia.setRows(5);
        txtReferencia.setName("txtReferencia"); // NOI18N
        txtReferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReferenciaKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txtReferencia);

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        txtReciboDePago.setEditable(false);
        txtReciboDePago.setText(resourceMap.getString("txtReciboDePago.text")); // NOI18N
        txtReciboDePago.setName("txtReciboDePago"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValor))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtReciboDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, 0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtReciboDePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)))
        );

        btnGuardarPago.setIcon(resourceMap.getIcon("btnGuardarPago.icon")); // NOI18N
        btnGuardarPago.setText(resourceMap.getString("btnGuardarPago.text")); // NOI18N
        btnGuardarPago.setName("btnGuardarPago"); // NOI18N
        btnGuardarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPagoActionPerformed(evt);
            }
        });

        jLabel10.setFont(resourceMap.getFont("jLabel10.font")); // NOI18N
        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        lblCajero.setFont(resourceMap.getFont("lblCajero.font")); // NOI18N
        lblCajero.setText(resourceMap.getString("lblCajero.text")); // NOI18N
        lblCajero.setName("lblCajero"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCajero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 533, Short.MAX_VALUE)
                        .addComponent(btnGuardarPago)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblCajero)
                    .addComponent(btnGuardarPago))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
private void btnGuardarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPagoActionPerformed
    //String idCtaCobrar = txtIdCuentaCobrar.getText();
    String factRef = txtReferencia.getText();
    
    if(txtValor.getText().equals("")||factRef.equals(""))
    {
       JOptionPane.showMessageDialog(this, "Ingrese correctamente la información", "Atención!", JOptionPane.ERROR_MESSAGE);
    }
    else
    {
        Double valor = Double.parseDouble(txtValor.getText());
        /*Double diferencia;
        diferencia = saldoActual - valor;
        if(diferencia<0)
        {
            JOptionPane.showMessageDialog(this, "Valor del pago excede saldo de la deuda", "Atención!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {*/
            
            clsComboBox objGrupoSelect = (clsComboBox)cmbTipoRecibo.getSelectedItem();
            objGrupoSelect.getCodigo();
            String cuotaIni = "";
            if(objGrupoSelect.getCodigo().equals("2"))
                cuotaIni = "S";
            else
                cuotaIni = "N";
            //INSERTAR PAGO
            objPago.insertarRegistroReciboCobro(main.idUser, factRef, ""+objUtils.redondear(valor), 
                    idCajaAbierta, txtReciboDePago.getText(), codigoCliente, cuotaIni, objGrupoSelect.getCodigo());
            //ACTUALIZAR RECIBO ACTUAL
            objCaja.actualizarReciboPago();
            JOptionPane.showMessageDialog(this, "Pago ingresado con éxito", "Atención!", JOptionPane.INFORMATION_MESSAGE);
            //AUDITORIA
            objAuditoria.insertarAuditoria("frmPagoAdd", "INGRESO DEL PAGO POR LA  CUENTA: -", "3");
            //dispose();
            txtValor.setText("");
            txtReferencia.setText("");
            
            //objUtils.limpiarJTable(dtmData);
            dispose();
            //llenarTablaDeudas();                 
        //}
    }
}//GEN-LAST:event_btnGuardarPagoActionPerformed

    public class colorFilaTable extends DefaultTableCellRenderer { 
        @Override 
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column ) 
        { 
            setEnabled(table == null || table.isEnabled());        

            if(String.valueOf(table.getValueAt(row,7)).equals("NOTA DE ENTREGA")) 
                setBackground(Color.green); 
            else if(String.valueOf(table.getValueAt(row,7)).equals("FACTURA")) 
                setBackground(Color.PINK); 
            else setBackground(null); 

            super.getTableCellRendererComponent(table, value, selected, focused, row, column); 
            return this; 
        } 
    }  
    
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    frmListClientes ventana = new frmListClientes(null, true, "13");
    //new inventariopdf.JDEscoger(this, true);
    ventana.setLocationRelativeTo(null);
    ventana.setVisible(true);
}//GEN-LAST:event_jButton1ActionPerformed

private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
    ArrayList<clsCliente> dataCliente = objCliente.consultarDataCliente(txtCedula.getText().toString());
    if(dataCliente.isEmpty())
    {
        JOptionPane.showMessageDialog(this, "Cédula no existe!!!", "Atención!", JOptionPane.ERROR_MESSAGE);
    }
    else
    {
        codigoCliente = ""+dataCliente.get(0).getCodigo();
        //objUtils.limpiarJTable(dtmData);
        this.txtNombreCliente.setText(dataCliente.get(0).getNameCompleto());
        
        if(dataCliente.get(0).getVerificadoDeudas().equals("N"))
        {
            getContentPane().setBackground(new java.awt.Color(255,0,0));
            jPanel1.setBackground(new java.awt.Color(255,0,0));            
            jPanel3.setBackground(new java.awt.Color(255,0,0));
        }
        else
        {
            getContentPane().setBackground(new java.awt.Color(240,240,240));
            jPanel1.setBackground(new java.awt.Color(240,240,240));            
            jPanel3.setBackground(new java.awt.Color(240,240,240));            
        }               
    }
}//GEN-LAST:event_btnBuscarClienteActionPerformed

   

private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
    if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.focusNextComponent();  
    }
}//GEN-LAST:event_txtCedulaKeyTyped

private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
    if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.focusNextComponent();  
    }
}//GEN-LAST:event_txtValorKeyTyped

private void txtReferenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReferenciaKeyTyped
    if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.focusNextComponent();  
    }
}//GEN-LAST:event_txtReferenciaKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnGuardarPago;
    private javax.swing.JComboBox cmbTipoRecibo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCajero;
    private javax.swing.JLabel lblFechaActual;
    public static javax.swing.JTextField txtCedula;
    public static javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtReciboDePago;
    private javax.swing.JTextArea txtReferencia;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
