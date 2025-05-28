package vista;

import controlador.UsuarioJpaController;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class InterUsuario extends javax.swing.JInternalFrame {
    
    public InterUsuario() {
        initComponents();
        this.setSize(new Dimension(400, 300));
        this.setTitle("Nuevo Usuario");
        
        txt_password.setVisible(true);
        txt_password_visible.setVisible(false);
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
        txt_usuario = new javax.swing.JTextField();
        jButton_Guardar = new javax.swing.JButton();
        txt_telefono = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        txt_password_visible = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nuevo Usuario");
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
        jLabel4.setText("Usuario:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Password:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Telefono:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 90, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        txt_usuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 170, -1));

        jButton_Guardar.setBackground(new java.awt.Color(0, 204, 204));
        jButton_Guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 90, 30));

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 170, -1));

        txt_password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 170, -1));

        txt_password_visible.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_password_visible, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 170, -1));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed
        Usuario usuario = new Usuario();
        UsuarioJpaController controlUsuario = new UsuarioJpaController();

        // Validaciones
        boolean validado = true;
        StringBuilder mensajeError = new StringBuilder();

        if (!validarNombre(txt_nombre.getText().trim())) {
            mensajeError.append("El nombre solo debe contener letras y no puede estar vacío.\n");
            txt_nombre.setBackground(Color.red);
            txt_nombre.setText(""); // Limpia solo este campo
            validado = false;
        } else {
            txt_nombre.setBackground(Color.green);
        }

        if (!validarNombre(txt_apellido.getText().trim())) {
            mensajeError.append("El apellido solo debe contener letras y no puede estar vacío.\n");
            txt_apellido.setBackground(Color.red);
            txt_apellido.setText(""); // Limpia solo este campo
            validado = false;
        } else {
            txt_apellido.setBackground(Color.green);
        }

        if (!validarUsuario(txt_usuario.getText().trim())) {
            mensajeError.append("El usuario debe contener solo letras,números, no puede estar vacio y no debe exceder los 20 caracteres.\n");
            txt_usuario.setBackground(Color.red);
            txt_usuario.setText(""); // Limpia solo este campo
            validado = false;
        } else {
            txt_usuario.setBackground(Color.green);
        }

        if (!validarPassword(txt_password.getText().trim())) {
            mensajeError.append("La contraseña debe tener al menos una mayúscula, un número y mínimo 8 caracteres.\n");
            txt_password.setBackground(Color.red);
            txt_password.setText(""); // Limpia solo este campo
            validado = false;
        } else {
            txt_password.setBackground(Color.green);
        }

        if (!validarTelefono(txt_telefono.getText().trim(), controlUsuario)) {
            mensajeError.append("El teléfono debe contener exactamente 10 dígitos numéricos, no puede estar vacio y ser único.\n");
            txt_telefono.setBackground(Color.red);
            txt_telefono.setText(""); // Limpia solo este campo
            validado = false;
        } else {
            txt_telefono.setBackground(Color.green);
        }

        // Si hubo errores, los muestra y no guarda
        if (!validado) {
            JOptionPane.showMessageDialog(null, mensajeError.toString(), "Errores en el formulario", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Guardar usuario si todos los campos están bien
        if (!controlUsuario.existeUsuario(txt_usuario.getText().trim())) {
            usuario.setNombre(txt_nombre.getText().trim());
            usuario.setApellido(txt_apellido.getText().trim());
            usuario.setUsuario(txt_usuario.getText().trim());
            usuario.setPassword(txt_password.getText().trim());
            usuario.setTelefono(txt_telefono.getText().trim());
            usuario.setEstado(1);

            if (controlUsuario.guardar(usuario)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                this.Limpiar(); // Se limpia solo cuando todo es válido
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario ya está registrado en la Base de Datos.");
        }
    }

    private void Limpiar() {
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_usuario.setText("");
        txt_password.setText("");
        txt_telefono.setText("");

        txt_nombre.setBackground(Color.white);
        txt_apellido.setBackground(Color.white);
        txt_usuario.setBackground(Color.white);
        txt_password.setBackground(Color.white);
        txt_telefono.setBackground(Color.white);
    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
                    char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void txt_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyTyped
                    char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c< 'A') | c>'Z') evt.consume();
    }//GEN-LAST:event_txt_apellidoKeyTyped

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
                   char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c< 'A') | c>'Z') evt.consume();
    }//GEN-LAST:event_txt_nombreKeyTyped


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
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_password_visible;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
  

    // Métodos de validación
    private boolean validarNombre(String nombre) {
        return nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") && !nombre.isEmpty();
    }

    private boolean validarUsuario(String usuario) {
        return usuario.matches("[a-zA-Z0-9]{1,20}") && !usuario.isEmpty();
    }

    private boolean validarPassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{8,}$");
    }

    private boolean validarTelefono(String telefono, UsuarioJpaController controlUsuario) {
        return telefono.matches("\\d{10}") && !controlUsuario.existeTelefono(telefono);
    }
}
