/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmPagosRealizados.java
 *
 * Created on 05-mar-2012, 9:46:37
 */
package pos;

import clases.clsAuditoria;
import clases.clsCaja;
import clases.clsEgreso;
import clases.clsPago;
import clases.clsReporte;
import clases.clsUtils;
import index.main;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CKaiser
 */
public class frmIngresosRealizados extends javax.swing.JInternalFrame {
    MiModelo dtmData = new MiModelo();
    clsReporte objReporte = new clsReporte(); 
    clsCaja objCaja = new clsCaja();
    clsPago objPago = new clsPago();
    clsUtils objUtils = new clsUtils();
    clsEgreso objEgreso = new clsEgreso();
    clsAuditoria objAuditoria = new clsAuditoria();
    String idCajaAbierta = "";
    JInternalFrame frameNuevo;
    /** Creates new form frmPagosRealizados */
    public frmIngresosRealizados(JInternalFrame e) {
        initComponents();      
        frameNuevo = e;
        dtmData.addColumn("N°");/*.setPreferredWidth(500)*/
        dtmData.addColumn("Concepto");
        dtmData.addColumn("Fecha");
        dtmData.addColumn("Valor");        
        dtmData.addColumn("idIngreso");
        //ALINEAR COLUMNA
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tblData.getColumnModel().getColumn(3).setCellRenderer(tcr);       
        //OCULTAR
        objUtils.setOcultarColumnasJTable(this.tblData, new int[]{4});
        
        llenarTabla();
    }
    
    private void llenarTabla()
    {
        objUtils.vaciarTabla(dtmData);
        Double total = 0.00;
        DecimalFormat df1 = new DecimalFormat("###0.00"); 
        //idCajaAbierta
        ArrayList<clases.clsCaja> dataCaja = objCaja.consultarDataCajaAbierta(main.idUser);
        idCajaAbierta = dataCaja.get(0).getIdCajaOperacion(); 
        
        ArrayList<clsEgreso> dataEgresos = objEgreso.consultaEgresosRealizadas(idCajaAbierta, "I"); 
        int maxData = dataEgresos.size();
        for(int i=0;i<maxData;i++)
        {
             Object[] nuevaFila = {i+1,                                     
                                    dataEgresos.get(i).getConcepto(),                                    
                                    dataEgresos.get(i).getFecha().substring(0, 16),
                                    dataEgresos.get(i).getCantidadEgreso(),
                                    dataEgresos.get(i).getIdEgreso()
             };       
             total = total + dataEgresos.get(i).getCantidadEgreso();
             dtmData.addRow(nuevaFila); 
        } 
        txtTotal.setText(df1.format(objUtils.redondear(total)));    
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(stinventario.STInventarioApp.class).getContext().getResourceMap(frmIngresosRealizados.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblData.setModel(dtmData);
        tblData.setName("tblData"); // NOI18N
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        txtTotal.setFont(resourceMap.getFont("txtTotal.font")); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText(resourceMap.getString("txtTotal.text")); // NOI18N
        txtTotal.setName("txtTotal"); // NOI18N

        btnEliminar.setIcon(resourceMap.getIcon("btnEliminar.icon")); // NOI18N
        btnEliminar.setText(resourceMap.getString("btnEliminar.text")); // NOI18N
        btnEliminar.setName("btnEliminar"); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(63, 63, 63)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
    //int fila = tblData.rowAtPoint(evt.getPoint());
    //int columna = tblData.columnAtPoint(evt.getPoint());
    /*int columna = 3;*/
    /*if ((fila > -1) && (columna > -1))*/    
    //System.out.println("x:" + idCabecera + " " + fila + " " + columna);
    /*int i = tblData.getSelectedRow();
    int idCabecera = Integer.parseInt(""+tblData.getValueAt(i, 4));
    objReporte.ejecutarReporteParametroInt(idCabecera, "rptPagosFactura");*/    
}//GEN-LAST:event_tblDataMouseClicked

private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    int fila = tblData.getSelectedRow();
    boolean exito = false;
    if(fila<0)
    {
        JOptionPane.showMessageDialog(this, "No ha seleccionado ningún registro", "Atención", JOptionPane.ERROR_MESSAGE);
    }
    else
    {
        int idIngreso = Integer.parseInt("" + tblData.getValueAt(fila, 4));
        int seleccion = JOptionPane.showOptionDialog(
                                        this, // Componente padre
                                        "¿Desea eliminar el ingreso Nº: " + tblData.getValueAt(fila, 0) + "?", //Mensaje
                                        "Seleccione una opción", // Título
                                        JOptionPane.YES_NO_CANCEL_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,    // null para icono por defecto.
                                        new Object[] { "Si", "No"},    // null para YES, NO y CANCEL
                                        "Si");
        if (seleccion != -1)
        {
            if((seleccion + 1)==1)
            {
                try
                {   
                    exito = objEgreso.eliminarEgreso(idIngreso);
                    if (exito)
                    {
                        JOptionPane.showMessageDialog(this, "Datos eliminados con éxito", "Atención!", JOptionPane.INFORMATION_MESSAGE);                
                        objAuditoria.insertarAuditoria("frmIngresosRealizados", "ELIMINO INGRESO ID: "
                                                + idIngreso + ", VALOR: $ " + tblData.getValueAt(fila, 3), "3");
                        llenarTabla();
                         
                        frameNuevo.dispose();
                        
                        /*frmCerrarCaja_ form = new frmCerrarCaja_();
                        form.setVisible(true);*/
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Error al ingresar la información", "Atención!", JOptionPane.ERROR_MESSAGE);
                        objAuditoria.insertarAuditoria("frmPagosEliminar","ELIMINO INGRESO ID: "
                                                + idIngreso + ", VALOR: $ " + tblData.getValueAt(fila, 3), "3");
                    }
                }
                catch(Exception e)
                {
                    System.out.println("ERROR: " + e.toString());
                }
            }
            else
            {
                //JOptionPane.showMessageDialog(this, "NO", "Atención!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}//GEN-LAST:event_btnEliminarActionPerformed
    
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
