package vista;

import conexion.Conexion;
import controlador.ProductoJpaController;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Producto;

public class InterActualizarStock extends javax.swing.JInternalFrame {

    int idProducto = 0;
    int cantidad = 0;

    public InterActualizarStock() {
        initComponents();
        setTitle("Actualizar Stock de los Productos");
        setSize(new Dimension(400, 300));

        this.CargarComboProductos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_cantidad_actual = new javax.swing.JTextField();
        txt_cantidad_nueva = new javax.swing.JTextField();
        jComboBox_producto = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Actualizar Stock de Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Producto:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 110, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Stock Actual:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 110, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Comprados:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 110, -1));

        txt_cantidad_actual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_cantidad_actual.setEnabled(false);
        txt_cantidad_actual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidad_actualKeyTyped(evt);
            }
        });
        getContentPane().add(txt_cantidad_actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 170, -1));

        txt_cantidad_nueva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_cantidad_nueva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidad_nuevaKeyTyped(evt);
            }
        });
        getContentPane().add(txt_cantidad_nueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 170, -1));

        jComboBox_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 170, -1));

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 170, 30));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_productoActionPerformed
        this.MostrarStock();
    }//GEN-LAST:event_jComboBox_productoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean camposValidos = true;
        StringBuilder mensajeError = new StringBuilder(); // Acumulador de mensajes de error

// Validamos selección del producto
        if (jComboBox_producto.getSelectedItem().equals("Seleccione producto:")) {
            mensajeError.append("- Seleccione un producto.\n");
            jComboBox_producto.setBackground(Color.RED);
            camposValidos = false;
        } else {
            jComboBox_producto.setBackground(Color.GREEN);
        }

// Validamos campos vacíos
        if (txt_cantidad_nueva.getText().isEmpty()) {
            mensajeError.append("- Ingrese una nueva cantidad para sumar al stock del producto.\n");
            txt_cantidad_nueva.setBackground(Color.RED);
            camposValidos = false;
        } else {
            // Validamos que el usuario no ingrese caracteres no numéricos
            boolean validacion = validar(txt_cantidad_nueva.getText().trim());
            if (!validacion) {
                mensajeError.append("- La cantidad solo puede contener números enteros.\n");
                txt_cantidad_nueva.setBackground(Color.RED);
                txt_cantidad_nueva.setText(""); // Limpia solo si es incorrecto
                camposValidos = false;
            } else {
                // Validar que la cantidad sea mayor que cero
                int cantidadNueva = Integer.parseInt(txt_cantidad_nueva.getText().trim());
                if (cantidadNueva <= 0) {
                    mensajeError.append("- La cantidad no puede ser cero ni negativa.\n");
                    txt_cantidad_nueva.setBackground(Color.RED);
                    txt_cantidad_nueva.setText(""); // Limpia solo si es incorrecto
                    camposValidos = false;
                } else {
                    txt_cantidad_nueva.setBackground(Color.GREEN);
                }
            }
        }

// Mostrar errores si existen
        if (!camposValidos) {
            JOptionPane.showMessageDialog(null, "Corrija los siguientes errores:\n" + mensajeError.toString());
            return; // No continuar si hay errores
        }

// Si todos los campos son válidos, actualizar stock
        Producto producto = new Producto();
        ProductoJpaController controlProducto = new ProductoJpaController();
        int stockActual = Integer.parseInt(txt_cantidad_actual.getText().trim());
        int stockNuevo = stockActual + Integer.parseInt(txt_cantidad_nueva.getText().trim());

        producto.setCantidad(stockNuevo);
        if (controlProducto.actualizarStock(producto, idProducto)) {
            JOptionPane.showMessageDialog(null, "Stock Actualizado");

            // Restaurar colores y limpiar campos
            jComboBox_producto.setBackground(Color.WHITE);
            txt_cantidad_nueva.setBackground(Color.WHITE);
            txt_cantidad_actual.setText("");
            txt_cantidad_nueva.setText("");
            jComboBox_producto.setSelectedItem("Seleccione producto:");
            this.CargarComboProductos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al Actualizar Stock");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_cantidad_actualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidad_actualKeyTyped
           char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_txt_cantidad_actualKeyTyped

    private void txt_cantidad_nuevaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidad_nuevaKeyTyped
           char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_txt_cantidad_nuevaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JTextField txt_cantidad_actual;
    private javax.swing.JTextField txt_cantidad_nueva;
    // End of variables declaration//GEN-END:variables

    //Metodo para caragar los productos en el jComboBox
    private void CargarComboProductos() {

        Connection cn = Conexion.conectar();
        String sql = "select * from tb_producto";
        Statement st;
        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_producto.removeAllItems();
            jComboBox_producto.addItem("Seleccione producto:");
            while (rs.next()) {
                jComboBox_producto.addItem(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar los productos en: " + e);
        }

    }
    //metodo para mostrar stock del producto seleccionado
    private void MostrarStock() {
        try {

            Connection cn = Conexion.conectar();
            String sql = "select * from tb_producto where nombre = '" + this.jComboBox_producto.getSelectedItem() + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                idProducto = rs.getInt("idProducto");
                cantidad = rs.getInt("cantidad");
                txt_cantidad_actual.setText(String.valueOf(cantidad));
            } else {
                txt_cantidad_actual.setText("");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener stock del producto en: " + e);
        }
    }

    //metodo de validacion de caracteres no numericos
    private boolean validar(String valor) {
        int num;
        try {
            num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
