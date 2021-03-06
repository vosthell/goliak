/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmReporteSector.java
 *
 * Created on 29-oct-2011, 14:00:13
 */
package clientes;

import clases.clsComboBox;
import clases.clsRecinto;
import clases.clsReporte;
import clases.clsTermino;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CKaiser
 */
public class frmReporteSector extends javax.swing.JInternalFrame {
    clsRecinto objRecinto = new clsRecinto();
    clsReporte objReporte = new clsReporte();
    clsTermino objTermino = new clsTermino();
    
    MiModelo dtmData = new MiModelo();
    
    /** Creates new form frmReporteSector */
    public frmReporteSector() {
        initComponents();
        
        //CARGAR RECINTOS
        ArrayList<clsComboBox> dataRecintos = objRecinto.consultarRecintos();        
        for(int i=0;i<dataRecintos.size();i=i+1)
        {
            clsComboBox oItem = new clsComboBox(dataRecintos.get(i).getCodigo(), dataRecintos.get(i).getDescripcion());
            cmbRecinto.addItem(oItem);            
        }
        
        //CARGAR SECTORES
        ArrayList<clsComboBox> dataSectores = objRecinto.consultarSectores();        
        for(int i=0;i<dataSectores.size();i=i+1)
        {
            clsComboBox oItem = new clsComboBox(dataSectores.get(i).getCodigo(), dataSectores.get(i).getDescripcion());
            cmbSector.addItem(oItem);            
        }
        
        //CARGAR TERMINOS        
        ArrayList<clsComboBox> dataTerminos = objTermino.consultarTerminos();        
        for(int i=0;i<dataTerminos.size();i=i+1)
        {
            clsComboBox oItem = new clsComboBox(dataTerminos.get(i).getCodigo(), dataTerminos.get(i).getDescripcion());
            cmbTermino1.addItem(oItem);     
            cmbTermino2.addItem(oItem); 
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

        grupoOpciones = new javax.swing.ButtonGroup();
        grupoOpcionesSector = new javax.swing.ButtonGroup();
        jideTabbedPane1 = new com.jidesoft.swing.JideTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbRecinto = new javax.swing.JComboBox();
        btnReporteRecinto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        rbtn4 = new javax.swing.JRadioButton();
        rbtn6 = new javax.swing.JRadioButton();
        rbtn5 = new javax.swing.JRadioButton();
        chkTermino = new javax.swing.JCheckBox();
        cmbTermino1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbSector = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        rbtn1 = new javax.swing.JRadioButton();
        rbtn3 = new javax.swing.JRadioButton();
        rbtn2 = new javax.swing.JRadioButton();
        chkTermino2 = new javax.swing.JCheckBox();
        cmbTermino2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(stinventario.STInventarioApp.class).getContext().getResourceMap(frmReporteSector.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jideTabbedPane1.setName("jideTabbedPane1"); // NOI18N

        jPanel2.setName("jPanel2"); // NOI18N

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        cmbRecinto.setName("cmbRecinto"); // NOI18N

        btnReporteRecinto.setIcon(resourceMap.getIcon("btnReporteRecinto.icon")); // NOI18N
        btnReporteRecinto.setText(resourceMap.getString("btnReporteRecinto.text")); // NOI18N
        btnReporteRecinto.setName("btnReporteRecinto"); // NOI18N
        btnReporteRecinto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteRecintoActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        grupoOpciones.add(rbtn4);
        rbtn4.setSelected(true);
        rbtn4.setText(resourceMap.getString("rbtn4.text")); // NOI18N
        rbtn4.setName("rbtn4"); // NOI18N

        grupoOpciones.add(rbtn6);
        rbtn6.setText(resourceMap.getString("rbtn6.text")); // NOI18N
        rbtn6.setName("rbtn6"); // NOI18N

        grupoOpciones.add(rbtn5);
        rbtn5.setText(resourceMap.getString("rbtn5.text")); // NOI18N
        rbtn5.setName("rbtn5"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(rbtn4)
                .addGap(26, 26, 26)
                .addComponent(rbtn5)
                .addGap(18, 18, 18)
                .addComponent(rbtn6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtn4)
                    .addComponent(rbtn5)
                    .addComponent(rbtn6))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        chkTermino.setFont(resourceMap.getFont("chkTermino.font")); // NOI18N
        chkTermino.setText(resourceMap.getString("chkTermino.text")); // NOI18N
        chkTermino.setName("chkTermino"); // NOI18N
        chkTermino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkTerminoItemStateChanged(evt);
            }
        });

        cmbTermino1.setEnabled(false);
        cmbTermino1.setName("cmbTermino1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblData.setModel(dtmData);
        tblData.setName("tblData"); // NOI18N
        jScrollPane1.setViewportView(tblData);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbRecinto, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(chkTermino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTermino1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                        .addComponent(btnReporteRecinto)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbRecinto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkTermino)
                    .addComponent(cmbTermino1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnReporteRecinto)
                        .addGap(15, 15, 15)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jideTabbedPane1.addTab(resourceMap.getString("jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        cmbSector.setName("cmbSector"); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel4.border.title"))); // NOI18N
        jPanel4.setName("jPanel4"); // NOI18N

        grupoOpcionesSector.add(rbtn1);
        rbtn1.setSelected(true);
        rbtn1.setText(resourceMap.getString("rbtn1.text")); // NOI18N
        rbtn1.setName("rbtn1"); // NOI18N

        grupoOpcionesSector.add(rbtn3);
        rbtn3.setText(resourceMap.getString("rbtn3.text")); // NOI18N
        rbtn3.setName("rbtn3"); // NOI18N

        grupoOpcionesSector.add(rbtn2);
        rbtn2.setText(resourceMap.getString("rbtn2.text")); // NOI18N
        rbtn2.setName("rbtn2"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(rbtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                .addComponent(rbtn2)
                .addGap(45, 45, 45)
                .addComponent(rbtn3)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtn2)
                    .addComponent(rbtn3)
                    .addComponent(rbtn1))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        chkTermino2.setFont(resourceMap.getFont("chkTermino2.font")); // NOI18N
        chkTermino2.setText(resourceMap.getString("chkTermino2.text")); // NOI18N
        chkTermino2.setName("chkTermino2"); // NOI18N
        chkTermino2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkTermino2ItemStateChanged(evt);
            }
        });

        cmbTermino2.setEnabled(false);
        cmbTermino2.setName("cmbTermino2"); // NOI18N

        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(41, 41, 41))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chkTermino2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbTermino2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbSector, 0, 315, Short.MAX_VALUE))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(166, 166, 166))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTermino2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkTermino2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jideTabbedPane1.addTab(resourceMap.getString("jPanel1.TabConstraints.tabTitle"), jPanel1); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jideTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jideTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnReporteRecintoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteRecintoActionPerformed
    clsComboBox objRecintoSelect = (clsComboBox)cmbRecinto.getSelectedItem();
    String reporte = "";
    int recinto = Integer.parseInt(objRecintoSelect.getCodigo());
    if(this.chkTermino.isSelected())        
    {
        clsComboBox objTerminoSelect = (clsComboBox)cmbTermino1.getSelectedItem();
        int termino = Integer.parseInt(objTerminoSelect.getCodigo());
        if(this.rbtn4.isSelected())
            reporte = "rptClientesTerminoRecinto";
        else if(this.rbtn5.isSelected())               
            reporte = "N"; 
        
        objReporte.ejecutarReporte2ParametrosInt(recinto, termino, reporte);
    } 
    else
    {    
        if(this.rbtn4.isSelected())
            reporte = "rptClientesAllRecinto";
        else if(this.rbtn5.isSelected())               
            reporte = "N";  
        objReporte.ejecutarReporteParametroInt(recinto, reporte);
    }
}//GEN-LAST:event_btnReporteRecintoActionPerformed

private void chkTerminoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkTerminoItemStateChanged
    if(this.chkTermino.isSelected())        
    {    
        this.cmbTermino1.setEnabled(true);          
    }
    else
    {
        this.cmbTermino1.setEnabled(false); 
    }
}//GEN-LAST:event_chkTerminoItemStateChanged

private void chkTermino2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkTermino2ItemStateChanged
    if(this.chkTermino2.isSelected())        
    {    
        this.cmbTermino2.setEnabled(true);          
    }
    else
    {
        this.cmbTermino2.setEnabled(false); 
    }
}//GEN-LAST:event_chkTermino2ItemStateChanged
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
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    clsComboBox objSectorSelect = (clsComboBox)cmbSector.getSelectedItem();
    String reporte="";
    int sector = Integer.parseInt(objSectorSelect.getCodigo());
    if(this.chkTermino.isSelected())        
    {
        clsComboBox objTerminoSelect = (clsComboBox)cmbTermino1.getSelectedItem();
        int termino = Integer.parseInt(objTerminoSelect.getCodigo());
        if(this.rbtn1.isSelected())
            reporte = "rptClientesTerminoSector";
        else if(this.rbtn2.isSelected())               
            reporte = "N";         
        objReporte.ejecutarReporte2ParametrosInt(sector, termino, reporte);
    } 
    else
    {
        if(this.rbtn1.isSelected())
            reporte = "rptClientesAllSector";
        else if(this.rbtn2.isSelected())               
            reporte = "N";
        objReporte.ejecutarReporteParametroInt(sector, reporte);
    }
}//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporteRecinto;
    private javax.swing.JCheckBox chkTermino;
    private javax.swing.JCheckBox chkTermino2;
    private javax.swing.JComboBox cmbRecinto;
    private javax.swing.JComboBox cmbSector;
    private javax.swing.JComboBox cmbTermino1;
    private javax.swing.JComboBox cmbTermino2;
    private javax.swing.ButtonGroup grupoOpciones;
    private javax.swing.ButtonGroup grupoOpcionesSector;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.jidesoft.swing.JideTabbedPane jideTabbedPane1;
    private javax.swing.JRadioButton rbtn1;
    private javax.swing.JRadioButton rbtn2;
    private javax.swing.JRadioButton rbtn3;
    private javax.swing.JRadioButton rbtn4;
    private javax.swing.JRadioButton rbtn5;
    private javax.swing.JRadioButton rbtn6;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables
}
