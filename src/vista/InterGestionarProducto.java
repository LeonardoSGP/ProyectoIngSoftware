package vista;

import conexion.Conexion;
import controlador.CategoriaJpaController;
import controlador.ProductoJpaController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.WIDTH;
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
import modelo.Categoria;
import modelo.Producto;

public class InterGestionarProducto extends javax.swing.JInternalFrame {

    private int idProducto;
    int obtenerIdCategoriaCombo = 0;

    public InterGestionarProducto() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar Productos");
        //Cargar tabla
        this.CargarTablaProductos();
        this.CargarComboCategoria();
        
        //insertar imagen en nuestro JLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
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
        jLabel7 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        jComboBox_iva = new javax.swing.JComboBox<>();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_productos);

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
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cantidad:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Precio:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Codigo:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Ganancia:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Categoria:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 90, -1));

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cantidad.setEnabled(false);
        txt_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidadActionPerformed(evt);
            }
        });
        jPanel3.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        txt_precio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_descripcion.setEnabled(false);
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 170, -1));

        jComboBox_iva.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_iva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Ganancia:", "No grava", "30%", "14%" }));
        jPanel3.add(jComboBox_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 150, -1));

        jComboBox_categoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione categoria:", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBox_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 150, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        Producto producto = new Producto();
        ProductoJpaController controlProducto = new ProductoJpaController();
        String iva = jComboBox_iva.getSelectedItem().toString().trim();
        String categoria = jComboBox_categoria.getSelectedItem().toString().trim();

        boolean validado = true;
        StringBuilder mensajeError = new StringBuilder(); // Para acumular errores

// Reiniciar colores
        txt_nombre.setBackground(Color.white);
        txt_cantidad.setBackground(Color.white);
        txt_precio.setBackground(Color.white);
        txt_descripcion.setBackground(Color.white);
        jComboBox_iva.setBackground(Color.white);
        jComboBox_categoria.setBackground(Color.white);

// Validación de campos vacíos
        if (txt_nombre.getText().trim().isEmpty()) {
            txt_nombre.setBackground(Color.RED);
            mensajeError.append("- El nombre es obligatorio.\n");
            validado = false;
        }
        if (txt_cantidad.getText().trim().isEmpty()) {
            txt_cantidad.setBackground(Color.RED);
            mensajeError.append("- La cantidad es obligatoria.\n");
            validado = false;
        }
        if (txt_precio.getText().trim().isEmpty()) {
            txt_precio.setBackground(Color.RED);
            mensajeError.append("- El precio es obligatorio.\n");
            validado = false;
        }
        if (txt_descripcion.getText().trim().isEmpty()) {
            txt_descripcion.setBackground(Color.RED);
            mensajeError.append("- La descripción es obligatoria.\n");
            validado = false;
        }

// Validación del nombre (solo letras)
        if (!txt_nombre.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            txt_nombre.setBackground(Color.RED);
            mensajeError.append("- El nombre solo debe contener letras.\n");
            validado = false;
        } else {
            txt_nombre.setBackground(Color.GREEN);
        }

// Validación del precio (solo números y punto decimal)
        try {
            String precioTXT = txt_precio.getText().trim().replace(",", ".");
            Double.parseDouble(precioTXT);
            txt_precio.setBackground(Color.GREEN);
        } catch (NumberFormatException e) {
            txt_precio.setBackground(Color.RED);
            mensajeError.append("- El precio debe ser un número válido.\n");
            validado = false;
        }

// Validación de la descripción (solo números)
        if (!txt_descripcion.getText().matches("\\d+")) {
            txt_descripcion.setBackground(Color.RED);
            mensajeError.append("- La descripción solo debe contener números.\n");
            validado = false;
        } else {
            txt_descripcion.setBackground(Color.GREEN);
        }

// Validación del IVA
        if (iva.equalsIgnoreCase("Seleccione Ganancia:") || iva.isEmpty()) {
            jComboBox_iva.setBackground(Color.RED);
            mensajeError.append("- Debe seleccionar un tipo de Ganancia.\n");
            validado = false;
        } else {
            jComboBox_iva.setBackground(Color.GREEN);
        }

// Validación de la Categoría
        if (categoria.equalsIgnoreCase("Seleccione categoria:") || categoria.isEmpty()) {
            jComboBox_categoria.setBackground(Color.RED);
            mensajeError.append("- Debe seleccionar una categoría.\n");
            validado = false;
        } else {
            jComboBox_categoria.setBackground(Color.GREEN);
        }

// Mostrar un solo mensaje con todos los errores
        if (!validado) {
            JOptionPane.showMessageDialog(null, "Corrija los siguientes errores:\n" + mensajeError.toString());
            return;
        }

// Si todas las validaciones pasaron, proceder con el registro
        try {
            producto.setNombre(txt_nombre.getText().trim());
            producto.setCantidad(Integer.parseInt(txt_cantidad.getText().trim()));

            // Convertir el precio
            double precio = Double.parseDouble(txt_precio.getText().trim().replace(",", "."));
            producto.setPrecio(precio);

            producto.setDescripcion(txt_descripcion.getText().trim());

            // Asignar porcentaje de IVA
            if (iva.equalsIgnoreCase("No grava")) {
                producto.setPorcentajeIva(0);
            } else if (iva.equalsIgnoreCase("30%")) {
                producto.setPorcentajeIva(12);
            } else if (iva.equalsIgnoreCase("14%")) {
                producto.setPorcentajeIva(14);
            }

            // Obtener ID de la categoría
            this.IdCategoria();
            producto.setIdCategoria(obtenerIdCategoriaCombo);
            producto.setEstado(1);

            if (controlProducto.actualizar(producto, idProducto)) {
                JOptionPane.showMessageDialog(null, "Registro Actualizado");

                // Restablecer colores y valores después de guardar
                txt_nombre.setBackground(Color.white);
                txt_cantidad.setBackground(Color.white);
                txt_precio.setBackground(Color.white);
                txt_descripcion.setBackground(Color.white);
                jComboBox_iva.setBackground(Color.white);
                jComboBox_categoria.setBackground(Color.white);

                this.CargarComboCategoria();
                this.CargarTablaProductos();

                // Limpiar los campos y restablecer combos
                this.jComboBox_iva.setSelectedIndex(0);  // Poner en "Seleccione IVA:"
                this.jComboBox_categoria.setSelectedIndex(0); // Poner en "Seleccione categoria:"
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println("Error en: " + e);
        }


    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
   ProductoJpaController controlProducto = new ProductoJpaController();
    
    // Verificar si se ha seleccionado un producto
    if (idProducto == 0) {
        JOptionPane.showMessageDialog(null, "¡Seleccione un Producto!");
    } else {
        // Mostrar un cuadro de confirmación
        int confirmacion = JOptionPane.showConfirmDialog(
            null, 
            "¿Está seguro de que desea eliminar este producto?", 
            "Confirmar Eliminación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.WARNING_MESSAGE
        );
        
        // Si el usuario selecciona 'Sí'
        if (confirmacion == JOptionPane.YES_OPTION) {
            if (controlProducto.eliminar(idProducto)) {
                JOptionPane.showMessageDialog(null, "¡Producto Eliminado!");
                this.CargarTablaProductos();
                this.CargarComboCategoria();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar producto!");
            }
        }
    }
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void txt_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
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
        jComboBox_iva.setSelectedItem("Seleccione IVA:");
        jComboBox_categoria.setSelectedItem("Seleccione categoria:");
        // Restaurar colores
        txt_nombre.setBackground(Color.WHITE);
        txt_cantidad.setBackground(Color.WHITE);
        txt_precio.setBackground(Color.WHITE);
        txt_descripcion.setBackground(Color.WHITE);
    }

    private void CargarComboCategoria() {
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
            System.out.println("¡Error al cargar categorias!");
        }
    }
    String descripcionCategoria = "";
    double precio = 0.0;
    int porcentajeIva = 0;
    double IVA = 0;

    private void CargarTablaProductos() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select p.idProducto, p.nombre, p.cantidad, p.precio, p.descripcion, p.porcentajeIva, c.descripcion, p.estado from tb_producto As p, tb_categoria As c where p.idCategoria = c.idCategoria;";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarProducto.jTable_productos = new JTable(model);
            InterGestionarProducto.jScrollPane1.setViewportView(InterGestionarProducto.jTable_productos);

            model.addColumn("N°");//ID
            model.addColumn("Nombre");
            model.addColumn("Cantidad");
            model.addColumn("Precio");
            model.addColumn("Codigo");
            model.addColumn("Ganancia");
            model.addColumn("Categoria");
          //  model.addColumn("Estado");

            while (rs.next()) {

                double precio = rs.getDouble("precio");
                int porcentajeIva = rs.getInt("porcentajeIva");

                Object fila[] = new Object[8];
                for (int i = 0; i < 8; i++) {

                    if (i == 5) {
                        this.calcularIva(precio, porcentajeIva); // metodo
                        fila[i] = IVA;
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla productos: " + e);
        }

        // Bloquear la tabla para que no sea editable
        jTable_productos.setDefaultEditor(Object.class, null);

        // Evento para obtener campo al cual el usuario da click
        // y obtener la interfaz que mostrará la información general
        jTable_productos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_productos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idProducto = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosProductoSeleccionado(idProducto); // metodo
                }
            }
        });
    }
    private void EnviarDatosProductoSeleccionado(int idProducto) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_producto where idProducto = ?"); // Evitamos concatenar SQL para mayor seguridad
            pst.setInt(1, idProducto);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_nombre.setText(rs.getString("nombre"));
                txt_cantidad.setText(rs.getString("cantidad"));
                txt_precio.setText(rs.getString("precio"));
                txt_descripcion.setText(rs.getString("descripcion"));

                int iva = rs.getInt("porcentajeIva");

                // Debugging: Verificar qué valor se está obteniendo
                System.out.println("IVA recuperado: " + iva);

                // Aseguramos que el combo se actualiza correctamente
                jComboBox_iva.setSelectedItem(null); // Limpia la selección previa
                switch (iva) {
                    case 0:
                        jComboBox_iva.setSelectedItem("No grava");
                        break;
                    case 12:
                        jComboBox_iva.setSelectedItem("30%");
                        break;
                    case 14:
                        jComboBox_iva.setSelectedItem("14%");
                        break;
                    default:
                        jComboBox_iva.setSelectedItem("Seleccione Ganancia:"); // Valor por defecto
                        break;
                }

                int idCate = rs.getInt("idCategoria");
                jComboBox_categoria.setSelectedItem(relacionarCategoria(idCate));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar producto: " + e);
        }
    }



    private double calcularIva(double precio, int iva) {
        int p_iva = iva;
        switch (p_iva) {
            case 0:
                IVA = 0.0;
                break;
            case 12:
                IVA = precio * 0.30;
                break;
            case 14:
                IVA = precio * 0.14;
                break;
            default:
                break;
        }
        //redondear decimales
        IVA = (double) Math.round(IVA * 100) / 100;
        return IVA;
    }
    private String relacionarCategoria(int idCategoria) {

        String sql = "select descripcion from tb_categoria where idCategoria = '" + idCategoria + "'";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                descripcionCategoria = rs.getString("descripcion");
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("¡Error al obtener el id de la categoria!");
        }
        return descripcionCategoria;
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
