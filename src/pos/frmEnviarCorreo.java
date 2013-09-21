/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import clases.clsCaja;
import clases.clsEgreso;
import clases.clsEmail;
import clases.clsUtils;
import clases.javaMail;
import index.main;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ckaiser
 */
public class frmEnviarCorreo extends javax.swing.JDialog {
    clsUtils objUtils = new clsUtils();
    clsCaja objCaja = new clsCaja();
    clsEmail objEmail = new clsEmail();
    /**
     * Creates new form frmEnviarCorreo
     */
    public frmEnviarCorreo(java.awt.Frame parent, boolean modal, int idCajaAbierta) {
        super(parent, modal);
        initComponents();
        ArrayList<clsCaja> dataCaja = objCaja.consultarDataOperacionesCajaID(idCajaAbierta); 
        javaMail mail = new javaMail();
        try{            
            String texto = "EL USUARIO: " 
                        + main.nameUser
                        + ", CERRO CAJA CON DINERO EN EFECTIVO: $ " + dataCaja.get(0).getValorContado() + "</BR>"
                        + " SISTEMA: $ " + "" + "</BR>"
                        + " OBSERVACION: DIFERENCIA:" +  dataCaja.get(0).getDiferencia() + "</BR>"
                        + "<TABLE>"
                            + "<tr><td>DESCRIPCION</td><td>VALOR</td></tr>"
                            + "<TR><TD>TOTAL FACTURADO:</TD><TD>" + objUtils.redondear(dataCaja.get(0).getTotalFacturado())+ "</TD></TR>"
                            + "<TR><TD>TOTAL ABONOS:</TD><TD>" + objUtils.redondear(dataCaja.get(0).getAbonos())+ "</TD></TR>"
                            + "<TR><TD>TOTAL ABONOS/FACT:</TD><TD>" + objUtils.redondear(dataCaja.get(0).getValorPagosFactura())+ "</TD></TR>"
                            + "<TR><TD>TOTAL ABONOS/ENTRADA:</TD><TD>" + objUtils.redondear(dataCaja.get(0).getRecibosPago())+ "</TD></TR>"
                            + "<TR><TD>TOTAL INGRESOS:</TD><TD>" + objUtils.redondear(dataCaja.get(0).getIngresos())+ "</TD></TR>"
                            + "<TR><TD>TOTAL EGRESOS:</TD><TD>" + objUtils.redondear(dataCaja.get(0).getEgresos())+ "</TD></TR>"                
                        + "</TABLE></BR>";
            //EGRESOS
            /*ArrayList<clsEgreso> dataEgresos = objEgreso.consultaEgresosRealizadas(idCajaAbierta, "E"); 
            maxData = dataEgresos.size();
            concepto = "";
            if(maxData>0)
            { 
                texto = texto + "EGRESOS";
                pw.println("----------------------------------------");
                for(int i=0;i<maxData;i++)
                {                
                    concepto = dataEgresos.get(i).getConcepto() + "                                         "; 
                    pw.println((i+1) +  " " + concepto.substring(0, 28) + " " + 
                                    objUtils.rellenar(""+df1.format(dataEgresos.get(i).getCantidadEgreso())));
                    totalEgresos = totalEgresos + dataEgresos.get(i).getCantidadEgreso();                
                }
                pw.println("TOTAL EGRESOS: " + objUtils.redondear(totalEgresos));
                pw.println(" ");
            }*/
            
            ArrayList<clsEmail> dataEmail = objEmail.consultarEmails();        
            for(int i=0;i<dataEmail.size();i=i+1)
            {
                mail.send(dataEmail.get(i).getEmail(),"CIERRE DE CAJA", texto);
            }
            /*mail.send("vosthell@hotmail.com","CIERRE DE CAJA", texto);
            mail.send("c.kaiser.a@hotmail.com","CIERRE DE CAJA", texto);
            mail.send("betsuka@hotmail.com","CIERRE DE CAJA", texto);
            mail.send("jrmsupertodo@gmail.com","CIERRE DE CAJA", texto);
            mail.send("karl02@hotmail.es","CIERRE DE CAJA", texto);   
            
            mail.send("betsy.rizzo@comisariatosupertodo.com","CIERRE DE CAJA", texto);
            mail.send("jorge.rizzo@comisariatosupertodo.com","CIERRE DE CAJA", texto);  
            mail.send("betty.rodas@comisariatosupertodo.com","CIERRE DE CAJA", texto);
            mail.send("webmaster@comisariatosupertodo.com","CIERRE DE CAJA", texto);  */
            
        }
        catch(Exception e){
            //e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al imprimir", JOptionPane.ERROR_MESSAGE);
        }
        //this.dispose();
        btnOK.setEnabled(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setName("Form"); // NOI18N
        setResizable(false);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(stinventario.STInventarioApp.class).getContext().getResourceMap(frmEnviarCorreo.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        btnOK.setText(resourceMap.getString("btnOK.text")); // NOI18N
        btnOK.setEnabled(false);
        btnOK.setName("btnOK"); // NOI18N
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel2)))
                .addContainerGap(224, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnOK)
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(btnOK)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

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
            java.util.logging.Logger.getLogger(frmEnviarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEnviarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEnviarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEnviarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmEnviarCorreo dialog = new frmEnviarCorreo(new javax.swing.JFrame(), true,0);
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
