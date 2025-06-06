package vista;

import controlador.ClienteJpaController;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import modelo.Cliente;

public class InterCliente extends javax.swing.JInternalFrame {

    public InterCliente() {
        initComponents();
        this.setSize(new Dimension(400, 300));
        this.setTitle("Nuevo Cliente");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        jButton_Guardar = new javax.swing.JButton();
        txt_direccion = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nuevo Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellido:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cédula:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Teléfono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Dirección:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 90, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 170, -1));

        txt_apellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 170, -1));

        txt_cedula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 170, -1));

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 170, -1));

        jButton_Guardar.setBackground(new java.awt.Color(0, 204, 204));
        jButton_Guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 90, 30));

        txt_direccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 170, -1));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed

        Cliente cliente = new Cliente();
        ClienteJpaController controlCliente = new ClienteJpaController();

        StringBuilder errores = new StringBuilder();

        String nombre = txt_nombre.getText().trim();
        String apellido = txt_apellido.getText().trim();
        String cedula = txt_cedula.getText().trim();
        String telefono = txt_telefono.getText().trim();
        String direccion = txt_direccion.getText().trim();

        // Validar Nombre
        if (!validarNombre(nombre)) {
            errores.append("El nombre solo debe contener letras y no puede estar vacío.\n");
            txt_nombre.setBackground(Color.RED);
        } else {
            txt_nombre.setBackground(Color.GREEN);
        }

        // Validar Apellido
        if (!validarNombre(apellido)) {
            errores.append("El apellido solo debe contener letras y no puede estar vacío.\n");
            txt_apellido.setBackground(Color.RED);
        } else {
            txt_apellido.setBackground(Color.GREEN);
        }

        // Validar Cédula (formato y unicidad)
        if (!validarCedula(cedula)) {
            errores.append("La cédula debe contener exactamente 5 dígitos.\n");
            txt_cedula.setBackground(Color.RED);
        } else if (controlCliente.existeCliente(cedula)) {
            errores.append("La cédula ya está registrada en la base de datos.\n");
            txt_cedula.setBackground(Color.RED);
        } else {
            txt_cedula.setBackground(Color.GREEN);
        }

        // Validar Teléfono (formato y unicidad)
        if (!validarTelefono(telefono, controlCliente)) {
            errores.append("El teléfono debe ser único, contener solo números y tener exactamente 10 dígitos.\n");
            txt_telefono.setBackground(Color.RED);
        } else {
            txt_telefono.setBackground(Color.GREEN);
        }

        // Validar Dirección
        if (!validarDireccion(direccion)) {
            errores.append("La dirección debe tener al menos 10 caracteres.\n");
            txt_direccion.setBackground(Color.RED);
        } else {
            txt_direccion.setBackground(Color.GREEN);
        }

        // Mostrar errores si existen
        if (errores.length() > 0) {
            JOptionPane.showMessageDialog(null, errores.toString(), "Errores de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Guardar cliente
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCedula(cedula);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        cliente.setEstado(1);

        if (controlCliente.guardar(cliente)) {
            JOptionPane.showMessageDialog(null, "Registro Guardado");

            // Limpiar colores
            txt_nombre.setBackground(Color.WHITE);
            txt_apellido.setBackground(Color.WHITE);
            txt_cedula.setBackground(Color.WHITE);
            txt_telefono.setBackground(Color.WHITE);
            txt_direccion.setBackground(Color.WHITE);

            this.Limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al Guardar");
        }

    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_txt_apellidoKeyTyped

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
     /**
     *
     * Metodo para limpiar campos
     */
    private void Limpiar() {
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_cedula.setText("");
        txt_telefono.setText("");
        txt_direccion.setText("");
        txt_nombre.setBackground(Color.white);
        txt_apellido.setBackground(Color.white);
        txt_cedula.setBackground(Color.white);
        txt_telefono.setBackground(Color.white);
        txt_direccion.setBackground(Color.white);
    }

// Métodos de validación
    private boolean validarNombre(String nombre) {
        return nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") && !nombre.isEmpty();
    }

    private boolean validarCedula(String cedula) {
        return cedula.matches("\\d{5}"); // Exactamente 5 dígitos
    }

    private boolean validarTelefono(String telefono, ClienteJpaController controlCliente) {
        return telefono.matches("\\d{10}") && !controlCliente.existeTelefono(telefono);
    }

    private boolean validarDireccion(String direccion) {
        return direccion.length() >= 10;
    }
}
