package interfaz;

import dao.IDAOGeneral;
import factorymetod.FactoryMethod;
import java.util.List;
import javax.swing.JOptionPane;
import pojo.Departamento;

public class DepartamentosGUI extends javax.swing.JInternalFrame {

    private static DepartamentosGUI dep = null;

    public static DepartamentosGUI getInstance() {
        if (dep == null) {
            dep = new DepartamentosGUI();
        }
        return dep;
    }

    public DepartamentosGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btoGuardar = new javax.swing.JButton();
        btoModificar = new javax.swing.JButton();
        btoEliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        clave = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();

        jToolBar1.setRollover(true);

        btoGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/salvar.png"))); // NOI18N
        btoGuardar.setToolTipText("Guardar");
        btoGuardar.setFocusable(false);
        btoGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btoGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btoGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btoGuardar);

        btoModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/editar.png"))); // NOI18N
        btoModificar.setToolTipText("Modificar");
        btoModificar.setFocusable(false);
        btoModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btoModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btoModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoModificarActionPerformed(evt);
            }
        });
        jToolBar1.add(btoModificar);

        btoEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/basura.png"))); // NOI18N
        btoEliminar.setToolTipText("Eliminar");
        btoEliminar.setFocusable(false);
        btoEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btoEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btoEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btoEliminar);

        texto.setColumns(20);
        texto.setRows(5);
        jScrollPane2.setViewportView(texto);

        jLabel1.setText("Clave");

        jLabel2.setText("Nombre");

        jLabel5.setText("Preció");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btoGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoGuardarActionPerformed

        if (clave.getText().isEmpty() || nombre.getText().isEmpty() || precio.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorio");

        } else {

            IDAOGeneral daod = FactoryMethod.create(FactoryMethod.TypeDAO.DEPARTAMENTO);
            Departamento d = new Departamento();

            d.setClave(clave.getText());
            d.setNombre(nombre.getText());
            d.setPrecio(precio.getText());

            if (daod.guardar(d)) {
                texto.append("Se ha guardado: " + 
                        "\nClave: " + d.getClave() + 
                        "\nNombre: " + d.getNombre() + 
                        "\nPrecio: " + d.getPrecio());
            } else {
                texto.append("No se han podido guardar los datos\n");
            }

        }

    }//GEN-LAST:event_btoGuardarActionPerformed

    private void btoModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoModificarActionPerformed

        if (clave.getText().isEmpty() || nombre.getText().isEmpty() || precio.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorio");

        } else {

            IDAOGeneral daod = FactoryMethod.create(FactoryMethod.TypeDAO.DEPARTAMENTO);
            Departamento d = new Departamento();

            d.setClave(clave.getText());
            d.setNombre(nombre.getText());
            d.setPrecio(precio.getText());

            if (daod.actualizar(d)) {
                JOptionPane.showMessageDialog(null, d.getClave() + " Actualizado Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible actualizar los datos " + d.getClave());
            }
        }

    }//GEN-LAST:event_btoModificarActionPerformed

    private void btoEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoEliminarActionPerformed

        if (clave.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Clave necesaria");

        } else {

            IDAOGeneral daod = FactoryMethod.create(FactoryMethod.TypeDAO.DEPARTAMENTO);
            Departamento d = new Departamento();
            String claveTemp = clave.getText();

            d.setClave(claveTemp);
            daod.borrar(d);
        }
    }//GEN-LAST:event_btoEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btoEliminar;
    private javax.swing.JButton btoGuardar;
    private javax.swing.JButton btoModificar;
    private javax.swing.JTextField clave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField precio;
    private javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables
}
