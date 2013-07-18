/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import clases.clsCabecera;
import clases.clsUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ckaiser
 */
public class frmReporteSemanal extends javax.swing.JInternalFrame {
    MiModelo dtmData = new MiModelo();
    clsCabecera objCabecera = new clsCabecera();
    clsUtils objUtils = new clsUtils();
    /**
     * Creates new form frmReporteSemanal
     */
    public frmReporteSemanal() {
        initComponents();
        
       dtmData.addColumn("DETALLE");//.setPreferredWidth(500)
        dtmData.addColumn("LUNES");
        dtmData.addColumn("MARTES");
        dtmData.addColumn("MIERCOLES");
        dtmData.addColumn("JUEVES");
        dtmData.addColumn("VIERNES");
        dtmData.addColumn("SABADO");
        dtmData.addColumn("DOMINGO");
        dtmData.addColumn("TOTAL SEMANAL");
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtFechaFin = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(stinventario.STInventarioApp.class).getContext().getResourceMap(frmReporteSemanal.class);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        txtFechaInicio.setDateFormatString(resourceMap.getString("txtFechaInicio.dateFormatString")); // NOI18N
        txtFechaInicio.setName("txtFechaInicio"); // NOI18N
        txtFechaInicio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtFechaInicioPropertyChange(evt);
            }
        });

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        txtFechaFin.setDateFormatString(resourceMap.getString("txtFechaFin.dateFormatString")); // NOI18N
        txtFechaFin.setName("txtFechaFin"); // NOI18N
        txtFechaFin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtFechaFinPropertyChange(evt);
            }
        });

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton1)
                .addContainerGap(306, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setName("jPanel2"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(dtmData);
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaInicioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtFechaInicioPropertyChange
        //buscar_informacion();
    }//GEN-LAST:event_txtFechaInicioPropertyChange

    private void txtFechaFinPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtFechaFinPropertyChange
        //buscar_informacion();
    }//GEN-LAST:event_txtFechaFinPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        objUtils.vaciarTabla(dtmData);
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = txtFechaInicio.getDate();
        Date fecSegCarta = txtFechaInicio.getDate();
        String fechaInicio = df1.format(date1);        
        
        Date date2 = txtFechaFin.getDate();
        String fechaFin = df1.format(date1);       
        //Date date1= new Date();
        //LE AUMENTO UN DIA
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(date1); 
        
        
        String fecha2 = "";
        Double valor = 0.00;
        
        double ingresos[] = new double[8];
        double abonos[] = new double[8];
        double entradas[] = new double[8];
        double ventasDiarias[] = new double[7];
        int i=0;
        while((fecSegCarta.before(date2))||(fecha2.equals(fechaFin)))
        //while(fecSegCarta.before(date2))
        {           
            if(i==0)
            {}
            else
            {
                fecha.add(Calendar.DAY_OF_MONTH, 1); 
            }
            fecSegCarta = fecha.getTime();
            date1 = fecSegCarta;        
            fecha2 = df1.format(fecSegCarta);
            
            ingresos[i] = objUtils.redondear(objCabecera.obtenerValorFacturado(fecha2));
            //ABONOS DE NOTA DE ENTREGA Y FACTURAS
            abonos[i] = objUtils.redondear(objCabecera.obtenerValorAbonos(fecha2)+
                    objCabecera.obtenerValorAbonosFactura(fecha2));
            entradas[i] = objUtils.redondear(objCabecera.obtenerValorEntradas(fecha2));
            i = i+1;        
        }
        //System.out.println("Valor final de i: " +i );
        Double totalIngresos = ingresos[0]+ ingresos[1]+ingresos[2]+ingresos[3]+ingresos[4]+ingresos[5]+ingresos[6];
        Double totalAbonos = abonos[0] + abonos[1] +abonos[2] +abonos[3] +abonos[4] +abonos[5]+abonos[6];
        Double totalEntradas = entradas[0] +entradas[1] +entradas[2] +entradas[3]+entradas[4] +entradas[5] +entradas[6];
        
        Object[] nuevaFila = { "INGRESOS", ingresos[0],ingresos[1], ingresos[2],ingresos[3],ingresos[4],ingresos[5],ingresos[6],totalIngresos};   
        dtmData.addRow(nuevaFila); 
        Object[] nuevaFila2 = { "VENTAS", "","","","","","","", ""};   
        dtmData.addRow(nuevaFila2); 
        Object[] nuevaFila3 = { "ABONOS", abonos[0], abonos[1], abonos[2], abonos[3], abonos[4],abonos[5],abonos[6], totalAbonos};   
        dtmData.addRow(nuevaFila3); 
        Object[] nuevaFila4 = { "ENTRADAS", entradas[0],entradas[1],entradas[2],entradas[3],entradas[4],entradas[5],entradas[6],totalEntradas};   
        dtmData.addRow(nuevaFila4); 
        Object[] nuevaFila5 = { "CANCELACIONES", "","","","","","","",""};   
        dtmData.addRow(nuevaFila5); 
        
        double ventasDiariasTotal = 0.00;
        for(int z=0; z<7;z++)
        {
            ventasDiarias[z] = ingresos[z] + abonos[z] + entradas[z];
            ventasDiariasTotal = ventasDiariasTotal + ventasDiarias[z];
        } 
        
        Object[] nuevaFila6 = { "VENTAS DIARIAS", ventasDiarias[0], ventasDiarias[1], ventasDiarias[2], ventasDiarias[3], ventasDiarias[4], ventasDiarias[5], ventasDiarias[6], ventasDiariasTotal};  
        dtmData.addRow(nuevaFila6); 
    }//GEN-LAST:event_jButton1ActionPerformed

    public Date DeStringADate(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = fecha;
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(strFecha);
                        //System.out.println(fechaDate.toString());
            return fechaDate;
        } catch (Exception ex) {
            ex.printStackTrace();
            return fechaDate;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser txtFechaFin;
    private com.toedter.calendar.JDateChooser txtFechaInicio;
    // End of variables declaration//GEN-END:variables
}
