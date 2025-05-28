package vista;

import conexion.Conexion;
import controlador.ProductoJpaController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Producto;


public class InterProducto extends javax.swing.JInternalFrame {

    int obtenerIdCategoriaCombo = 0;

    public InterProducto() {
        initComponents();
        this.setSize(new Dimension(400, 300));
        this.setTitle("Nuevo Producto");

        this.CargarComboCategorias();
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
        jLabel7 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        jComboBox_iva = new javax.swing.JComboBox<>();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        jButton_Guardar = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nuevo Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cantidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Precio:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Codigo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Ganancia:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Categorias:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 90, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 170, -1));

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidadKeyTyped(evt);
            }
        });
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 170, -1));

        txt_precio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 170, -1));

        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 170, -1));

        jComboBox_iva.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_iva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Ganancia:", "No grava ", "30%", "14%" }));
        jComboBox_iva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ivaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 170, -1));

        jComboBox_categoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Categoria:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 170, -1));

        jButton_Guardar.setBackground(new java.awt.Color(0, 204, 204));
        jButton_Guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 90, 30));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed
        Producto producto = new Producto();
        ProductoJpaController controlProducto = new ProductoJpaController();
        String iva = jComboBox_iva.getSelectedItem().toString().trim();
        String categoria = jComboBox_categoria.getSelectedItem().toString().trim();

// Restablecer color de todos los campos a su estado inicial
        txt_nombre.setBackground(Color.white);
        txt_cantidad.setBackground(Color.white);
        txt_precio.setBackground(Color.white);
        txt_descripcion.setBackground(Color.white);
        jComboBox_iva.setBackground(Color.white);
        jComboBox_categoria.setBackground(Color.white);

        boolean error = false;
        StringBuilder mensajeError = new StringBuilder(); // Acumulador de mensajes de error

// Verificar los campos vacíos
        if (txt_nombre.getText().trim().isEmpty()) {
            txt_nombre.setBackground(Color.red);
            mensajeError.append("- El nombre es obligatorio.\n");
            error = true;
        } else {
            txt_nombre.setBackground(Color.green);
        }

        if (txt_cantidad.getText().trim().isEmpty()) {
            txt_cantidad.setBackground(Color.red);
            mensajeError.append("- La cantidad es obligatoria.\n");
            error = true;
        } else {
            txt_cantidad.setBackground(Color.green);
        }

        if (txt_precio.getText().trim().isEmpty()) {
            txt_precio.setBackground(Color.red);
            mensajeError.append("- El precio es obligatorio.\n");
            error = true;
        } else {
            txt_precio.setBackground(Color.green);
        }

        if (txt_descripcion.getText().trim().isEmpty()) {
            txt_descripcion.setBackground(Color.red);
            mensajeError.append("- La descripción es obligatoria.\n");
            error = true;
        } else {
            txt_descripcion.setBackground(Color.green);
        }

// Validar selección de IVA
        if (iva.equalsIgnoreCase("Seleccione Ganancia:") || iva.isEmpty()) {
            jComboBox_iva.setBackground(Color.red);
            mensajeError.append("- Debe seleccionar una opción de Ganancia.\n");
            error = true;
        } else {
            jComboBox_iva.setBackground(Color.green);
        }

// Validar selección de Categoría
        if (categoria.equalsIgnoreCase("Seleccione categoria:") || categoria.isEmpty()) {
            jComboBox_categoria.setBackground(Color.red);
            mensajeError.append("- Debe seleccionar una categoría.\n");
            error = true;
        } else {
            jComboBox_categoria.setBackground(Color.green);
        }

// Mostrar errores si existen
        if (error) {
            JOptionPane.showMessageDialog(null, "Corrija los siguientes errores:\n" + mensajeError.toString());
            return; // No continuar si hay errores
        }

// Validar que solo se ingresen letras en el nombre
        if (!txt_nombre.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            txt_nombre.setBackground(Color.red);
            mensajeError.append("- El nombre solo puede contener letras.\n");
            error = true;
        } else {
            txt_nombre.setBackground(Color.green);
        }

// Validar que solo se ingresen números en cantidad
        if (!txt_cantidad.getText().matches("\\d+")) {
            txt_cantidad.setBackground(Color.red);
            mensajeError.append("- La cantidad solo puede contener números enteros.\n");
            error = true;
        } else {
            txt_cantidad.setBackground(Color.green);
        }

// Validar que solo se ingresen números en precio
        if (!txt_precio.getText().matches("\\d+(\\.\\d{1,2})?")) {
            txt_precio.setBackground(Color.red);
            mensajeError.append("- El precio debe ser un número válido (con hasta 2 decimales).\n");
            error = true;
        } else {
            txt_precio.setBackground(Color.green);
        }

// Validar que solo se ingresen números en el código
        if (!txt_descripcion.getText().matches("\\d+")) {
            txt_descripcion.setBackground(Color.red);
            mensajeError.append("- El código solo puede contener números.\n");
            error = true;
        } else {
            txt_descripcion.setBackground(Color.green);

            // Validar código único en la base de datos
            if (controlProducto.existeCodigo(txt_descripcion.getText().trim())) {
                txt_descripcion.setBackground(Color.red);
                mensajeError.append("- El código ya está registrado. Ingrese uno diferente.\n");
                error = true;
            }
        }

// Mostrar errores si existen
        if (error) {
            JOptionPane.showMessageDialog(null, "Corrija los siguientes errores:\n" + mensajeError.toString());
            return; // No continuar si hay errores
        }

// Continuar con el proceso de guardar
        try {
            producto.setNombre(txt_nombre.getText().trim());
            producto.setCantidad(Integer.parseInt(txt_cantidad.getText().trim()));
            producto.setPrecio(Double.parseDouble(txt_precio.getText().trim()));
            producto.setDescripcion(txt_descripcion.getText().trim());

            // Asignar porcentaje de IVA
            if (iva.equalsIgnoreCase("No grava")) {
                producto.setPorcentajeIva(0);
            } else if (iva.equalsIgnoreCase("30%")) {
                producto.setPorcentajeIva(30);
            } else if (iva.equalsIgnoreCase("14%")) {
                producto.setPorcentajeIva(14);
            }

            // Obtener id categoría
            this.IdCategoria();
            producto.setIdCategoria(obtenerIdCategoriaCombo);
            producto.setEstado(1);

            if (controlProducto.guardar(producto)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");

                // Restaurar colores y limpiar campos
                txt_nombre.setBackground(Color.white);
                txt_cantidad.setBackground(Color.white);
                txt_precio.setBackground(Color.white);
                txt_descripcion.setBackground(Color.white);
                jComboBox_iva.setBackground(Color.white);
                jComboBox_categoria.setBackground(Color.white);

                this.CargarComboCategorias();
                this.jComboBox_iva.setSelectedItem("Seleccione IVA:");
                this.jComboBox_categoria.setSelectedItem("Seleccione categoria:");
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println("Error en: " + e);
        }
    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void jComboBox_ivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ivaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_ivaActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
                   char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c< 'A') | c>'Z') evt.consume();
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadKeyTyped
                     char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_txt_cantidadKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JComboBox<String> jComboBox_categoria;
    private javax.swing.JComboBox<String> jComboBox_iva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
   
    private void Limpiar() {
        txt_nombre.setText("");
        txt_cantidad.setText("");
        txt_precio.setText("");
        txt_descripcion.setText("");
        // Restablecer el combo de IVA
        jComboBox_iva.setSelectedIndex(0); // Asegúrate de que "Seleccione IVA" esté en el índice 0

        // Restablecer el combo de categoría
        jComboBox_categoria.setSelectedIndex(0); // Asegúrate de que "Seleccione categoria" esté en el índice 0

        // Restaurar colores de los campos a su estado inicial
        txt_nombre.setBackground(Color.white);
        txt_cantidad.setBackground(Color.white);
        txt_precio.setBackground(Color.white);
        txt_descripcion.setBackground(Color.white);
    }

    private void CargarComboCategorias() {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_categoria";
        Statement st;

        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_categoria.removeAllItems();
            jComboBox_categoria.addItem("Seleccione categoria:");
            while (rs.next()) {
                jComboBox_categoria.addItem(rs.getString("descripcion"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar categorias");
        }
    }

    private int IdCategoria() {
        String sql = "select * from tb_categoria where descripcion = '" + this.jComboBox_categoria.getSelectedItem() + "'";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obtenerIdCategoriaCombo = rs.getInt("idCategoria");
            }
        } catch (SQLException e) {
            System.out.println("Error al obener id categoria");
        }
        return obtenerIdCategoriaCombo;
    }
}