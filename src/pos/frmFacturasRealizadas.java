/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmFacturasRealizadas.java
 *
 * Created on 05-mar-2012, 0:49:08
 */
package pos;

import clases.clsCabecera;
import clases.clsCaja;
import clases.clsUtils;
import index.main;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author CKaiser
 */
public class frmFacturasRealizadas extends javax.swing.JInternalFrame {
    MiModelo dtmData = new MiModelo();
    clsCaja objCaja = new clsCaja();
    clsCabecera objCabecera = new clsCabecera();
    clsUtils objUtils = new clsUtils();
    
    int idCajaAbierta = 0;
    
    /** Creates new form frmFacturasRealizadas */
    public frmFacturasRealizadas() {
        initComponents();
        Double total = 0.00;
        dtmData.addColumn("N°");/*.setPreferredWidth(500)*/
        dtmData.addColumn("Codigo factura");
        dtmData.addColumn("Cliente");
        dtmData.addColumn("Hora");
        dtmData.addColumn("Término");
        dtmData.addColumn("Total");
        dtmData.addColumn("Efectivo");
        dtmData.addColumn("idCabecera");
        //tamaño
        //TableColumn columna = tblData.getColumn("Nº");
        //columna.setMinWidth(30);
        //columna.setMaxWidth(30);
        //OCULTAR
        objUtils.setOcultarColumnasJTable(this.tblData, new int[]{7});
        //ALINEAR COLUMNA
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tblData.getColumnModel().getColumn(5).setCellRenderer(tcr); 
        tblData.getColumnModel().getColumn(6).setCellRenderer(tcr); 
        
        //idCajaAbierta
        ArrayList<clases.clsCaja> dataCaja = objCaja.consultarDataCajaAbierta(main.idUser);
        idCajaAbierta = dataCaja.get(0).getIdCajaOperacion(); 
        
        ArrayList<clsCabecera> dataFacturas = objCabecera.consultaFacturasRealizadas(idCajaAbierta); 
        int maxData = dataFacturas.size();
        for(int i=0;i<maxData;i++)
        {
             Object[] nuevaFila = {i+1, 
                                    dataFacturas.get(i).getFactReferencia(),
                                    dataFacturas.get(i).getNameCompleto(),
                                    dataFacturas.get(i).getFecha(),
                                    dataFacturas.get(i).getFecha(),
                                    dataFacturas.get(i).getTotal(),
                                    dataFacturas.get(i).getEfectivo(),
                                    dataFacturas.get(i).getIdCabeceraMovi()
             };       
             total = total + dataFacturas.get(i).getEfectivo();
             dtmData.addRow(nuevaFila); 
        } 
        txtTotal.setText(""+total);
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(stinventario.STInventarioApp.class).getContext().getResourceMap(frmFacturasRealizadas.class);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
    int fila = tblData.rowAtPoint(evt.getPoint());
    int columna = tblData.columnAtPoint(evt.getPoint());
    /*int columna = 3;*/
    /*if ((fila > -1) && (columna > -1))*/
    int i = tblData.getSelectedRow();
    String idCabecera = ""+tblData.getValueAt(i,7);
    System.out.println("x:"+idCabecera + " " + fila + " " +columna);
    //if ((fila > -1) && (columna < 7)) {
        frmFacturaShow ventana = new frmFacturaShow(null, true, idCabecera);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    //}
}//GEN-LAST:event_tblDataMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
