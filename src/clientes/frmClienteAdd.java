/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmClienteAdd.java
 *
 * Created on 25-oct-2011, 22:54:56
 */
package clientes;

import clases.clsAuditoria;
import clases.clsCiudad;
import clases.clsCliente;
import clases.clsComboBox;
import clases.clsParametros;
import clases.clsProvincia;
import clases.clsRecinto;
import clases.clsTermino;
import clases.clsUtils;
import clases.javaMail;
import java.awt.Color;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaiser
 */
public class frmClienteAdd extends javax.swing.JInternalFrame {
    clsProvincia objProvincia = new clsProvincia();
    clsTermino objTermino = new clsTermino();
    clsRecinto objRecinto = new clsRecinto();
    clsCliente objCliente = new clsCliente();
    clsUtils objUtils = new clsUtils();
    clsAuditoria objAuditoria = new clsAuditoria();
    clsCiudad objCiudad = new clsCiudad();
    clsParametros objParametros = new clsParametros();
    
    boolean exito = false;
    /** Creates new form frmClienteAdd */
    public frmClienteAdd() {
        initComponents();
        lblContador.setText("");
        //CARGAR PROVINCIAS
        ArrayList<clsComboBox> dataProvincia = objProvincia.consultarProvincias();        
        for(int i=0;i<dataProvincia.size();i=i+1)
        {
            clsComboBox oItem = new clsComboBox(dataProvincia.get(i).getCodigo(), dataProvincia.get(i).getDescripcion());
            cmbProvincia.addItem(oItem);            
        }
        cmbProvincia.setSelectedIndex(12);
        
        //CARGAR CIUDADES
        cargar_ciudades();
       
        
        //CARGAR TERMINOS
        ArrayList<clsComboBox> dataTerminos = objTermino.consultarTerminos();        
        for(int i=0;i<dataTerminos.size();i=i+1)
        {
            clsComboBox oItem = new clsComboBox(dataTerminos.get(i).getCodigo(), dataTerminos.get(i).getDescripcion());
            cmbTermino.addItem(oItem);            
        }
        
        //CARGAR RECINTOS
        ArrayList<clsComboBox> dataRecintos = objRecinto.consultarRecintos();        
        for(int i=0;i<dataRecintos.size();i=i+1)
        {
            clsComboBox oItem = new clsComboBox(dataRecintos.get(i).getCodigo(), dataRecintos.get(i).getDescripcion());
            cmbRecinto.addItem(oItem);            
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        txtNombre2 = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        lblContador = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtConvencional = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbProvincia = new javax.swing.JComboBox();
        cmbTermino = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtCredito = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cmbRecinto = new javax.swing.JComboBox();
        cmbCiudad = new javax.swing.JComboBox();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(stinventario.STInventarioApp.class).getContext().getResourceMap(frmClienteAdd.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setFrameIcon(resourceMap.getIcon("Form.frameIcon")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel1.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel1.border.titleColor"))); // NOI18N
        jPanel1.setForeground(resourceMap.getColor("jPanel1.foreground")); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        txtNombre1.setText(resourceMap.getString("txtNombre1.text")); // NOI18N
        txtNombre1.setName("txtNombre1"); // NOI18N

        txtNombre2.setText(resourceMap.getString("txtNombre2.text")); // NOI18N
        txtNombre2.setName("txtNombre2"); // NOI18N

        txtApellido1.setText(resourceMap.getString("txtApellido1.text")); // NOI18N
        txtApellido1.setName("txtApellido1"); // NOI18N

        txtApellido2.setText(resourceMap.getString("txtApellido2.text")); // NOI18N
        txtApellido2.setName("txtApellido2"); // NOI18N

        txtCedula.setText(resourceMap.getString("txtCedula.text")); // NOI18N
        txtCedula.setName("txtCedula"); // NOI18N
        txtCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaFocusLost(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulaKeyReleased(evt);
            }
        });

        lblContador.setForeground(resourceMap.getColor("lblContador.foreground")); // NOI18N
        lblContador.setText(resourceMap.getString("lblContador.text")); // NOI18N
        lblContador.setName("lblContador"); // NOI18N

        txtEmail.setText(resourceMap.getString("txtEmail.text")); // NOI18N
        txtEmail.setName("txtEmail"); // NOI18N
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N

        lblEmail.setFont(resourceMap.getFont("lblEmail.font")); // NOI18N
        lblEmail.setForeground(resourceMap.getColor("lblEmail.foreground")); // NOI18N
        lblEmail.setText(resourceMap.getString("lblEmail.text")); // NOI18N
        lblEmail.setName("lblEmail"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblContador))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtApellido1)
                            .addComponent(txtNombre1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApellido2)
                            .addComponent(txtNombre2, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lblContador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(lblEmail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel2.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel2.border.titleColor"))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        txtConvencional.setText(resourceMap.getString("txtConvencional.text")); // NOI18N
        txtConvencional.setName("txtConvencional"); // NOI18N

        txtCelular.setText(resourceMap.getString("txtCelular.text")); // NOI18N
        txtCelular.setName("txtCelular"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        txtDireccion.setColumns(20);
        txtDireccion.setRows(5);
        txtDireccion.setName("txtDireccion"); // NOI18N
        jScrollPane1.setViewportView(txtDireccion);

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        cmbProvincia.setName("cmbProvincia"); // NOI18N
        cmbProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProvinciaItemStateChanged(evt);
            }
        });

        cmbTermino.setName("cmbTermino"); // NOI18N

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        txtCredito.setText(resourceMap.getString("txtCredito.text")); // NOI18N
        txtCredito.setName("txtCredito"); // NOI18N

        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N

        cmbRecinto.setName("cmbRecinto"); // NOI18N

        cmbCiudad.setName("cmbCiudad"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel14))
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbProvincia, 0, 214, Short.MAX_VALUE)
                            .addComponent(cmbRecinto, 0, 214, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbCiudad, 0, 205, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(27, 27, 27)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtConvencional, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(txtCelular))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtConvencional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(11, 11, 11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cmbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(cmbTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRecinto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
        );

        btnGuardar.setIcon(resourceMap.getIcon("btnGuardar.icon")); // NOI18N
        btnGuardar.setText(resourceMap.getString("btnGuardar.text")); // NOI18N
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void cargar_ciudades()
    {
        clsComboBox objProvinciaSelect = (clsComboBox)cmbProvincia.getSelectedItem();
        ArrayList<clsComboBox> dataCiudad = objCiudad.consultarCiudad(objProvinciaSelect.getCodigo());        
        for(int i=0;i<dataCiudad.size();i=i+1)
        {
            clsComboBox oItem = new clsComboBox(dataCiudad.get(i).getCodigo(), dataCiudad.get(i).getDescripcion());
            cmbCiudad.addItem(oItem);            
        }
        cmbCiudad.setSelectedIndex(1);
    }
private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
     
    if(txtCedula.getText().equals("")||txtNombre1.getText().equals("")||txtApellido1.getText().equals("")||txtDireccion.getText().equals("")||txtCredito.getText().equals(""))
    {
        JOptionPane.showMessageDialog(this, objUtils.camposVacios, objUtils.tituloVentanaMensaje, JOptionPane.ERROR_MESSAGE);
    }    
    else
    {
        //String email = txtEmail.getText().toString();
        //if(objUtils.isEmail(email))
        //{
        //    JOptionPane.showMessageDialog(this, "Ingrese correctamente la información", "Atención!", JOptionPane.ERROR_MESSAGE);   
        //}
        clsComboBox objProvinciaSelect = (clsComboBox)cmbProvincia.getSelectedItem();
        clsComboBox objCiudadSelect = (clsComboBox)cmbCiudad.getSelectedItem();
        clsComboBox objTerminoSelect = (clsComboBox)cmbTermino.getSelectedItem();
        clsComboBox objRecintoSelect = (clsComboBox)cmbRecinto.getSelectedItem();
        
        String cedula       = txtCedula.getText().toString().trim();
        String nombre1      = txtNombre1.getText().toUpperCase().toString().trim();
        String nombre2      = txtNombre2.getText().toUpperCase().toString().trim();
        String apellido1    = txtApellido1.getText().toUpperCase().toString().trim();
        String apellido2    = txtApellido2.getText().toUpperCase().toString().trim();
        String email        = txtEmail.getText().toUpperCase().toString().trim();
        
        String nombre_completo = "";
        if(apellido1.length()>0)
            nombre_completo = nombre_completo + apellido1;
        if(apellido2.length()>0)
            nombre_completo = nombre_completo + " " + apellido2;
        if(nombre1.length()>0)
            nombre_completo = nombre_completo + " " + nombre1;
        if(nombre2.length()>0)
            nombre_completo = nombre_completo + " " + nombre2;
        
        exito = objCliente.insertarRegistro(cedula, 
                nombre1,
                nombre2, 
                apellido1,
                apellido2, 
                txtConvencional.getText().toString(),
                txtCelular.getText().toString(), 
                txtDireccion.getText().toString(),
                objCiudadSelect.getCodigo(), 
                txtCredito.getText().toString(),
                objProvinciaSelect.getCodigo(), 
                objTerminoSelect.getCodigo(),
                objRecintoSelect.getCodigo(), 
                email,
                nombre_completo);
        if (exito)
        {
            JOptionPane.showMessageDialog(this, objUtils.exitoGuardar, objUtils.tituloVentanaMensaje, JOptionPane.INFORMATION_MESSAGE);
            objAuditoria.insertarAuditoria("frmClienteAdd", "INGRESO DEL CLIENTE: "+
                                            cedula + " - "+
                                            apellido1 + " "+
                                            apellido2 + " "+
                                            nombre1 + " "+
                                            nombre2, "3");
            
            //enviar_correo();
                
            //dispose();
            txtCedula.setText("");
            txtNombre1.setText("");
            txtNombre2.setText("");
            txtApellido1.setText("");
            txtApellido2.setText("");
            txtConvencional.setText("");
            txtCelular.setText("");
            txtDireccion.setText("");
            txtCredito.setText("0");
            //txtCiudad.setText("BABA");
            
            //ENVIAR CORREO AL CLIENTE
            String email_habilitado = objParametros.consultaValor("email_habilitado");
            if(email_habilitado.equals("1"))
            {    
                try
                {
                    javaMail mail = new javaMail();                
                    if (email != "")
                    {
                        String texto = "";
                        texto = texto + objParametros.consultaValor("email_html_head"); 
                        texto = texto + "<BR /><BR /><BR />";
                        texto = "Saludos, " + nombre1 + " " + apellido1 + "<BR />";
                        texto = texto + "Gracias por preferirnos.";
                        texto = texto + "<BR /><BR /><BR />";
                        texto = texto + objParametros.consultaValor("email_html_foot_kolozzus");
                        texto = texto + "<BR />" + email;

                        mail.send(email, "Gracias por preferirnos", texto);       
                        mail.send("vosthell@hotmail.com", "Gracias por preferirnos", texto);       
                    }
                }
                catch(Exception e){
                    //e.printStackTrace();
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error al enviar por correo", JOptionPane.ERROR_MESSAGE);
                }     
            }
            //FIN - ENVIAR CORREO AL CLIENTE
        }
        else
        {
            JOptionPane.showMessageDialog(this, objUtils.errorGuardar, objUtils.tituloVentanaMensaje, JOptionPane.WARNING_MESSAGE);
            objAuditoria.insertarAuditoria("frmClienteAdd", "INTENTÓ INGRESAR CLIENTE: "+
                                            cedula + " - "+
                                            apellido1 + " "+
                                            apellido2 + " "+
                                            nombre1 + " "+
                                            nombre2 , "3");
        }
    }
}//GEN-LAST:event_btnGuardarActionPerformed

    

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
        int i = txtCedula.getText().length();
        if(txtCedula.getText().trim().length()<13){
            int restantes = 12 - i;
            lblContador.setText(restantes + " caracteres restantes.");
        }else{            
            String com = txtCedula.getText().substring(0, 12);
            txtCedula.setText("");            
            txtCedula.setText(com);
        }
    }//GEN-LAST:event_txtCedulaKeyPressed

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased
        String x = txtCedula.getText();
        if(!objUtils.isDouble(x)){
            txtCedula.setText("");
        }
    }//GEN-LAST:event_txtCedulaKeyReleased

    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaFocusLost
        exito = objCliente.comprobarCedula(txtCedula.getText().toString());
        if(exito)
        {
            JOptionPane.showMessageDialog(this, "Cédula ya existe", "Atención!", JOptionPane.ERROR_MESSAGE);
            txtCedula.setText("");
            lblContador.setText("13");
            txtCedula.grabFocus();
        }           
    }//GEN-LAST:event_txtCedulaFocusLost

private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
    if(objUtils.isEmail(txtEmail.getText().toString()))
    {
        lblEmail.setText("Correcto");
        lblEmail.setForeground(Color.GREEN);

    }
    else
    {
        lblEmail.setText("Incorrecto");
        lblEmail.setForeground(Color.RED);
    }
}//GEN-LAST:event_txtEmailKeyReleased

private void cmbProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProvinciaItemStateChanged
    cmbCiudad.removeAllItems();
    cargar_ciudades();
}//GEN-LAST:event_cmbProvinciaItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cmbCiudad;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JComboBox cmbRecinto;
    private javax.swing.JComboBox cmbTermino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblContador;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtConvencional;
    private javax.swing.JTextField txtCredito;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre2;
    // End of variables declaration//GEN-END:variables
}
