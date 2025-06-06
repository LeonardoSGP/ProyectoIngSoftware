package vista;

import conexion.Conexion;
import controlador.ClienteJpaController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;

public class InterGestionarCliente extends javax.swing.JInternalFrame {

    private int idCliente = 0;

    public InterGestionarCliente() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar Clientes");
        this.CargarTablaClientes();

        // Insertar imagen en nuestro JLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();

        // Configurar evento de clic en la tabla
        configurarEventoTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_clientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar Clientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_clientes.getTableHeader().setResizingAllowed(false);
        jTable_clientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable_clientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

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
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Teléfono:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Apellido:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Dirección:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Cedula:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, -1));

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        jPanel3.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        txt_apellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyTyped(evt);
            }
        });
        jPanel3.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        txt_direccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 170, -1));

        txt_cedula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
// Lista de errores
        StringBuilder errores = new StringBuilder();

// Validaciones específicas con colores
        if (txt_nombre.getText().trim().isEmpty()) {
            errores.append("• El nombre es obligatorio.\n");
            txt_nombre.setBackground(Color.RED);
        } else if (txt_nombre.getText().length() > 50) {
            errores.append("• El nombre no debe superar los 50 caracteres.\n");
            txt_nombre.setBackground(Color.RED);
        } else {
            txt_nombre.setBackground(Color.GREEN);
        }

        if (txt_apellido.getText().trim().isEmpty()) {
            errores.append("• El apellido es obligatorio.\n");
            txt_apellido.setBackground(Color.RED);
        } else if (txt_apellido.getText().length() > 50) {
            errores.append("• El apellido no debe superar los 50 caracteres.\n");
            txt_apellido.setBackground(Color.RED);
        } else {
            txt_apellido.setBackground(Color.GREEN);
        }

        if (!txt_cedula.getText().matches("\\d{5}")) {
            errores.append("• La cédula debe tener exactamente 5 dígitos.\n");
            txt_cedula.setBackground(Color.RED);
        } else {
            txt_cedula.setBackground(Color.GREEN);
        }

        if (!txt_telefono.getText().matches("\\d{10}")) {
            errores.append("• El teléfono debe tener exactamente 10 dígitos.\n");
            txt_telefono.setBackground(Color.RED);
        } else {
            txt_telefono.setBackground(Color.GREEN);
        }

        if (txt_direccion.getText().trim().isEmpty() || txt_direccion.getText().length() < 10) {
            errores.append("• La dirección debe tener al menos 10 caracteres.\n");
            txt_direccion.setBackground(Color.RED);
        } else {
            txt_direccion.setBackground(Color.GREEN);
        }

// Si hay errores, mostrar todos juntos y salir
        if (errores.length() > 0) {
            JOptionPane.showMessageDialog(null, errores.toString(), "Errores de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Si todas las validaciones pasan, guardar los datos
        Cliente cliente = new Cliente();
        ClienteJpaController controlCliente = new ClienteJpaController();

        cliente.setNombre(txt_nombre.getText().trim());
        cliente.setApellido(txt_apellido.getText().trim());
        cliente.setCedula(txt_cedula.getText().trim());
        cliente.setTelefono(txt_telefono.getText().trim());
        cliente.setDireccion(txt_direccion.getText().trim());
        cliente.setEstado(1); // Asegurar que el estado sea 1 al actualizar

        if (controlCliente.actualizar(cliente, idCliente)) {
            JOptionPane.showMessageDialog(null, "¡Datos del cliente actualizados!");
            // Limpiar y dejar los campos en blanco
            this.Limpiar();
            CargarTablaClientes();
        } else {
            JOptionPane.showMessageDialog(null, "¡Error al actualizar!");
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        ClienteJpaController controlCliente = new ClienteJpaController();

        if (idCliente <= 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un cliente!");
            return;
        }

// Mensaje de confirmación antes de eliminar
        int confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que desea eliminar este cliente?",
                "Confirmación de eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmacion == JOptionPane.YES_OPTION) { // Solo si el usuario acepta
            if (controlCliente.eliminar(idCliente)) {
                JOptionPane.showMessageDialog(null, "¡Cliente eliminado exitosamente!");
                this.CargarTablaClientes();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar el cliente!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Eliminación cancelada.");
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_clientes;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

    private void Limpiar() {
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_cedula.setText("");
        txt_telefono.setText("");
        txt_direccion.setText("");

        // Restaurar colores por defecto
        Color defaultColor = Color.WHITE;
        txt_nombre.setBackground(defaultColor);
        txt_apellido.setBackground(defaultColor);
        txt_cedula.setBackground(defaultColor);
        txt_telefono.setBackground(defaultColor);
        txt_direccion.setBackground(defaultColor);

        // Limpia id seleccionado
        idCliente = 0;
    }

    private void configurarEventoTabla() {
        jTable_clientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_clientes.rowAtPoint(e.getPoint());
                if (fila_point > -1) {
                    idCliente = (int) jTable_clientes.getValueAt(fila_point, 0); // Primera columna
                    EnviarDatosClienteSeleccionado(idCliente);
                }
            }
        });
    }

    private void CargarTablaClientes() {
        Connection con = Conexion.conectar();

        // Creamos un modelo de tabla que impida la edición
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Ninguna celda será editable
            }
        };

        String sql = "SELECT * FROM tb_cliente";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Asignar el modelo a la tabla antes de llenarla
            InterGestionarCliente.jTable_clientes.setModel(model);
            InterGestionarCliente.jScrollPane1.setViewportView(InterGestionarCliente.jTable_clientes);

            // Agregar columnas
            model.addColumn("N°"); // ID
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Cedula");
            model.addColumn("Telefono");
            model.addColumn("Direccion");
          //  model.addColumn("Estado");

            // Llenar la tabla con datos de la BD
            while (rs.next()) {
                Object fila[] = new Object[7];
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla clientes: " + e);
        }

        // Evento para actualizar el ID del cliente seleccionado y cargar sus datos
        jTable_clientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_clientes.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    // Actualizar el ID del cliente seleccionado
                    idCliente = (int) model.getValueAt(fila_point, columna_point);
                    // Enviar los datos del cliente a los campos de texto
                    EnviarDatosClienteSeleccionado(idCliente);
                }
            }
        });
    }

    private void EnviarDatosClienteSeleccionado(int idCliente) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_cliente where idCliente = ?");
            pst.setInt(1, idCliente);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txt_nombre.setText(rs.getString("nombre"));
                txt_apellido.setText(rs.getString("apellido"));
                txt_cedula.setText(rs.getString("cedula"));
                txt_telefono.setText(rs.getString("telefono"));
                txt_direccion.setText(rs.getString("direccion"));
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar cliente: " + e);
        }
    }

}
