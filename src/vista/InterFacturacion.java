package vista;

import conexion.Conexion;
import controlador.Venta;
import controlador.VentaPDF;
import java.awt.Dimension;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CabeceraVenta;
import modelo.DetalleVenta;
import static vista.InterFacturacion.jTable_productos;
import static vista.InterFacturacion.txt_total_pagar;

public class InterFacturacion extends javax.swing.JInternalFrame {

    //Modelo de los datos
    private DefaultTableModel modeloDatosProductos;
    //lista para el detalle de venta de los productos
    ArrayList<DetalleVenta> listaProductos = new ArrayList<>();
    private DetalleVenta producto;

    private int idCliente = 0;//id del cliente sleccionado

    private int idProducto = 0;
    private String nombre = "";
    private int cantidadProductoBBDD = 0;
    private double precioUnitario = 0.0;
    private int porcentajeIva = 0;

    private int cantidad = 0;//cantidad de productos a comprar
    private double subtotal = 0.0;//cantidad por precio
    private double descuento = 0.0;
    private double iva = 0.0;
    private double totalPagar = 0.0;

    //variables para calculos globales
    private double subtotalGeneral = 0.0;
    private double descuentoGeneral = 0.0;
    private double ivaGeneral = 0.0;
    private double totalPagarGeneral = 0.0;
    //fin de variables de calculos globales

    private int auxIdDetalle = 1;//id del detalle de venta

    public InterFacturacion() {
        initComponents();
        this.setSize(new Dimension(800, 600));
        this.setTitle("Facturacion");

        //Cargar lo Clientes en la vista - cargar productos
        this.CargarComboClientes();
        this.CargarComboProductos();

        this.inicializarTablaProducto();

        txt_efectivo.setEnabled(false);
        // jButton_calcular_cambio.setEnabled(false);

        txt_subtotal.setText("0.0");
        txt_iva.setText("0.0");
        txt_descuento.setText("0.0");
        txt_total_pagar.setText("0.0");

        //insertar imagen en nuestro JLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(800, 600, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();
        jComboBox_producto.setEnabled(false);
        txt_cantidad.setEnabled(false);
        jButton_añadir_producto.setEnabled(false);
    }

    //metodo para inicializar la tabla de los productos
    private void inicializarTablaProducto() {
        modeloDatosProductos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Ninguna celda es editable
            }
        };
        //añadir columnas
        modeloDatosProductos.addColumn("N");
        modeloDatosProductos.addColumn("Nombre");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("P. Unitario");
        modeloDatosProductos.addColumn("SubTotal");
        modeloDatosProductos.addColumn("Descuento");
        modeloDatosProductos.addColumn("Ganancia");
        modeloDatosProductos.addColumn("Total Pagar");
        modeloDatosProductos.addColumn("Accion");
        //agregar los datos del modelo a la tabla
        this.jTable_productos.setModel(modeloDatosProductos);
    }

    //metodo para presentar la informacion de la tavla DetalleVenta
    private void listaTablaProductos() {
        this.modeloDatosProductos.setRowCount(listaProductos.size());
        for (int i = 0; i < listaProductos.size(); i++) {
            this.modeloDatosProductos.setValueAt(i + 1, i, 0);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getNombre(), i, 1);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getCantidad(), i, 2);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getPrecioUnitario(), i, 3);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getSubTotal(), i, 4);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getDescuento(), i, 5);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getIva(), i, 6);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getTotalPagar(), i, 7);
            this.modeloDatosProductos.setValueAt("Eliminar", i, 8);//aqui luego poner un boton de eliminar
        }
        //añadir al Jtable
        jTable_productos.setModel(modeloDatosProductos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_cliente = new javax.swing.JComboBox<>();
        jComboBox_producto = new javax.swing.JComboBox<>();
        txt_cliente_buscar = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        jButton_busca_cliente = new javax.swing.JButton();
        jButton_añadir_producto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_descuento = new javax.swing.JTextField();
        txt_iva = new javax.swing.JTextField();
        txt_total_pagar = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        txt_cambio = new javax.swing.JTextField();
        jButton_RegistrarVenta = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto:");

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Facturación");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 80, -1));

        jComboBox_cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 170, -1));

        jComboBox_producto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 170, -1));

        txt_cliente_buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_cliente_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 150, -1));

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 60, -1));

        jButton_busca_cliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_busca_cliente.setText("Buscar");
        jButton_busca_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_busca_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_busca_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 80, -1));

        jButton_añadir_producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_añadir_producto.setText("Añadir Productos");
        jButton_añadir_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_añadir_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_añadir_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 150, -1));

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_productos.getTableHeader().setResizingAllowed(false);
        jTable_productos.getTableHeader().setReorderingAllowed(false);
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 740, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 760, 210));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Subtotal:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Descuento:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Iva:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Total a pagar:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Efectivo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Cambio:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_subtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_subtotal.setEnabled(false);
        jPanel2.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 120, -1));

        txt_descuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_descuento.setEnabled(false);
        jPanel2.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 120, -1));

        txt_iva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_iva.setEnabled(false);
        jPanel2.add(txt_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 120, -1));

        txt_total_pagar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_total_pagar.setEnabled(false);
        jPanel2.add(txt_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 120, -1));

        txt_efectivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_efectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_efectivoActionPerformed(evt);
            }
        });
        txt_efectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_efectivoKeyTyped(evt);
            }
        });
        jPanel2.add(txt_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 120, -1));

        txt_cambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_cambio.setEnabled(false);
        jPanel2.add(txt_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 120, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 380, 210));

        jButton_RegistrarVenta.setBackground(new java.awt.Color(51, 255, 255));
        jButton_RegistrarVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_RegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora.png"))); // NOI18N
        jButton_RegistrarVenta.setText("Registrar Venta");
        jButton_RegistrarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_RegistrarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_RegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 170, 100));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_busca_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_busca_clienteActionPerformed
        String clienteBuscar = txt_cliente_buscar.getText().trim();
        Connection cn = Conexion.conectar();
        String sql = "select nombre, apellido from tb_cliente where cedula = '" + clienteBuscar + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                jComboBox_cliente.setSelectedItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            } else {
                jComboBox_cliente.setSelectedItem("Seleccione cliente:");
                JOptionPane.showMessageDialog(null, "¡Cedula de cliente incorrecta o no encontrada!");
            }
            txt_cliente_buscar.setText("");
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al buscar cliente!, " + e);
        }
    }//GEN-LAST:event_jButton_busca_clienteActionPerformed

    private void jButton_añadir_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_añadir_productoActionPerformed
// VALIDACIÓN PARA CLIENTE ANTES DE TODO
        Object clienteSeleccionado = jComboBox_cliente.getSelectedItem();
        if (clienteSeleccionado == null || clienteSeleccionado.toString().equalsIgnoreCase("Seleccione cliente")) {
            JOptionPane.showMessageDialog(null, "Primero seleccione un cliente antes de añadir productos");
            return; // Detiene el método si no hay cliente válido
        }
        String combo = this.jComboBox_producto.getSelectedItem().toString();
// Validar que se seleccione un producto
        if (combo.equalsIgnoreCase("Seleccione producto:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        } else {
            // Validar que se ingrese una cantidad
            if (!txt_cantidad.getText().isEmpty()) {
                // Validar que el usuario no ingrese caracteres no numéricos
                boolean validacion = validar(txt_cantidad.getText());
                if (validacion == true) {
                    // Validar que la cantidad sea mayor a cero
                    if (Integer.parseInt(txt_cantidad.getText()) > 0) {
                        cantidad = Integer.parseInt(txt_cantidad.getText());
                        // Ejecutar método para obtener datos del producto
                        this.DatosDelProducto();

                        // Verificar cantidad total en la lista y si no excede el stock
                        int cantidadTotal = cantidad; // Inicializamos la cantidad con la ingresada
                        for (DetalleVenta p : listaProductos) {
                            if (p.getIdProducto() == idProducto) {
                                cantidadTotal += p.getCantidad(); // Si el producto ya existe, sumamos la cantidad
                            }
                        }

                        // Validar que la cantidad total no supere el stock disponible
                        if (cantidadTotal <= cantidadProductoBBDD) {

                            // Calcular el subtotal basado en la cantidad actual
                            subtotal = precioUnitario * cantidad;

                            // Calcular el IVA basado en la cantidad y el subtotal
                            switch (porcentajeIva) {
                                case 0:
                                    iva = 0.0;  // No tiene IVA
                                    break;
                                case 12:
                                    iva = subtotal * 0.30;  // IVA al 16%
                                    break;
                                case 14:
                                    iva = subtotal * 0.14;  // IVA al 14%
                                    break;
                                default:
                                    iva = 0.0;  // Si no es ninguno de los casos anteriores
                                    break;
                            }

                            // Recalcular el total a pagar
                            totalPagar = subtotal + iva + descuento;

                            // Redondear los valores
                            subtotal = (double) Math.round(subtotal * 100) / 100;
                            iva = (double) Math.round(iva * 100) / 100;
                            descuento = (double) Math.round(descuento * 100) / 100;
                            totalPagar = (double) Math.round(totalPagar * 100) / 100;

                            // Verificar si el producto ya está en la lista
                            boolean productoExiste = false;
                            for (DetalleVenta p : listaProductos) {
                                if (p.getIdProducto() == idProducto) {
                                    // Si el producto ya existe, actualizar la cantidad y recalcular
                                    p.setCantidad(p.getCantidad() + cantidad);
                                    p.setSubTotal(p.getPrecioUnitario() * p.getCantidad());

                                    // Actualizar IVA y total a pagar según el porcentaje de IVA
                                    switch (porcentajeIva) {
                                        case 0:
                                            p.setIva(0.0);  // No tiene IVA
                                            break;
                                        case 12:
                                            p.setIva(p.getSubTotal() * 0.30);  // IVA al 16%
                                            break;
                                        case 14:
                                            p.setIva(p.getSubTotal() * 0.14);  // IVA al 14%
                                            break;
                                        default:
                                            p.setIva(0.0);  // Si no es ninguno de los casos anteriores
                                            break;
                                    }

                                    p.setTotalPagar(p.getSubTotal() + p.getIva() + p.getDescuento());

                                    // Redondear los valores nuevamente
                                    p.setSubTotal((double) Math.round(p.getSubTotal() * 100) / 100);
                                    p.setIva((double) Math.round(p.getIva() * 100) / 100);
                                    p.setDescuento((double) Math.round(p.getDescuento() * 100) / 100);
                                    p.setTotalPagar((double) Math.round(p.getTotalPagar() * 100) / 100);

                                    productoExiste = true;
                                    JOptionPane.showMessageDialog(null, "Cantidad actualizada");
                                    break;
                                }
                            }
                            CabeceraVenta cabecera = new CabeceraVenta();
                            cabecera.setIdCabeceraventa(1);

                            // Si el producto no existe, agregarlo a la lista
                            if (!productoExiste) {
                                producto = new DetalleVenta(auxIdDetalle, // idDetalleVenta
                                        1, // idCabecera
                                        idProducto,
                                        nombre,
                                        cantidad,
                                        precioUnitario,
                                        subtotal,
                                        descuento,
                                        iva,
                                        totalPagar,
                                        1 // estado
                                );
                                listaProductos.add(producto);
                                JOptionPane.showMessageDialog(null, "Producto Agregado");
                                auxIdDetalle++;
                            }
                            jComboBox_cliente.setEnabled(false);
                            txt_cliente_buscar.setEnabled(false);
                            jButton_busca_cliente.setEnabled(false);

                            txt_cantidad.setText(""); // Limpiar el campo
                            // Volver a cargar combo productos
                            this.CargarComboProductos();
                            this.CalcularTotalPagar();
                            txt_efectivo.setEnabled(true);
                            // jButton_calcular_cambio.setEnabled(true);

                        } else {
                            JOptionPane.showMessageDialog(null, "La cantidad total supera el stock disponible");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero (0), ni negativa");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "En la cantidad no se admiten caracteres no numéricos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingresa la cantidad de productos");
            }
        }
// Llamar al método
        this.listaTablaProductos();


    }//GEN-LAST:event_jButton_añadir_productoActionPerformed
    int idArrayList = 0;

    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked
        int fila_point = jTable_productos.rowAtPoint(evt.getPoint());
        int columna_point = 0;
        if (fila_point > -1) {
            idArrayList = (int) modeloDatosProductos.getValueAt(fila_point, columna_point);
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Eliminar Producto?");
        //opciones de confir dialog - (si = 0; no = 1; cancel = 2; close = -1)
        switch (opcion) {
            case 0: //presione si
                listaProductos.remove(idArrayList - 1);
                this.CalcularTotalPagar();
                this.listaTablaProductos();
                break;
            case 1: //presione no
                break;
            default://sea que presione cancel (2) o close (-1)
                break;
        }
    }//GEN-LAST:event_jTable_productosMouseClicked

    private void jButton_RegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarVentaActionPerformed
        CabeceraVenta cabeceraVenta = new CabeceraVenta();
        DetalleVenta detalleVenta = new DetalleVenta();
        Venta controlVenta = new Venta();

        String fechaActual = "";
        Date date = new Date();
        fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);

        if (!jComboBox_cliente.getSelectedItem().equals("Seleccione cliente:")) {
            if (listaProductos.size() > 0) {

                // ✅ Validar efectivo antes de continuar
                String efectivoStr = txt_efectivo.getText().trim();
                if (efectivoStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese la cantidad de efectivo.");
                    return;
                }

                double efectivo;
                try {
                    efectivo = Double.parseDouble(efectivoStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El valor ingresado en efectivo no es válido.");
                    return;
                }

                double totalPagar = Double.parseDouble(txt_total_pagar.getText());
                if (efectivo < totalPagar) {
                    JOptionPane.showMessageDialog(null, "El efectivo ingresado no es suficiente para cubrir el total a pagar.");
                    return;
                }

                // 1. Obtener el ID del cliente
                this.ObtenerIdCliente();

                // 2. Registrar cabecera
                cabeceraVenta.setIdCabeceraventa(0);
                cabeceraVenta.setIdCliente(idCliente);
                cabeceraVenta.setValorPagar(totalPagar);
                cabeceraVenta.setFechaVenta(fechaActual);
                cabeceraVenta.setEstado(1);

                if (controlVenta.guardar(cabeceraVenta)) {
                    JOptionPane.showMessageDialog(null, "¡Venta Registrada!");
                    jComboBox_cliente.setEnabled(true);
                    txt_cliente_buscar.setEnabled(true);
                    jButton_busca_cliente.setEnabled(true);

                    // 3. Generar factura PDF
                    VentaPDF pdf = new VentaPDF();
                    pdf.DatosCliente(idCliente);
                    pdf.generarFacturaPDF();

                    // 4. Guardar detalle
                    for (DetalleVenta elemento : listaProductos) {
                        detalleVenta.setIdDetalleVenta(0);
                        detalleVenta.setIdCabeceraVenta(0); // deberías obtener el ID generado si lo tienes disponible
                        detalleVenta.setIdProducto(elemento.getIdProducto());
                        detalleVenta.setCantidad(elemento.getCantidad());
                        detalleVenta.setPrecioUnitario(elemento.getPrecioUnitario());
                        detalleVenta.setSubTotal(elemento.getSubTotal());
                        detalleVenta.setDescuento(elemento.getDescuento());
                        detalleVenta.setIva(elemento.getIva());
                        detalleVenta.setTotalPagar(elemento.getTotalPagar());
                        detalleVenta.setEstado(1);

                        if (controlVenta.guardarDetalle(detalleVenta)) {
                            // Limpieza de campos
                            txt_subtotal.setText("0.0");
                            txt_iva.setText("0.0");
                            txt_descuento.setText("0.0");
                            txt_total_pagar.setText("0.0");
                            txt_efectivo.setText("");
                            txt_cambio.setText("0.0");
                            auxIdDetalle = 1;

                            this.CargarComboClientes();

                            // Restar stock
                            this.RestarStockProductos(elemento.getIdProducto(), elemento.getCantidad());
                        } else {
                            JOptionPane.showMessageDialog(null, "¡Error al guardar detalle de venta!");
                        }
                    }

                    // 5. Limpiar lista y tabla
                    listaProductos.clear();
                    listaTablaProductos();

                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al guardar cabecera de venta!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "¡Seleccione un producto!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Seleccione un cliente!");
        }

    }//GEN-LAST:event_jButton_RegistrarVentaActionPerformed

    private void txt_efectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_efectivoActionPerformed
        // Llamar a la función que calcula el cambio cuando el usuario presione "Enter" o termine de escribir
        calcularCambio();
    }//GEN-LAST:event_txt_efectivoActionPerformed

    private void txt_efectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_efectivoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_txt_efectivoKeyTyped

    private void jComboBox_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_clienteActionPerformed
        jComboBox_producto.setEnabled(true);
        txt_cantidad.setEnabled(true);
        jButton_añadir_producto.setEnabled(true);

        if (jComboBox_cliente.getSelectedIndex() == 0) {
            jComboBox_producto.setEnabled(false);
            txt_cantidad.setEnabled(false);
            jButton_añadir_producto.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBox_clienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_RegistrarVenta;
    private javax.swing.JButton jButton_añadir_producto;
    private javax.swing.JButton jButton_busca_cliente;
    private javax.swing.JComboBox<String> jComboBox_cliente;
    private javax.swing.JComboBox<String> jComboBox_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    public javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cliente_buscar;
    private javax.swing.JTextField txt_descuento;
    public javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_iva;
    private javax.swing.JTextField txt_subtotal;
    public static javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables

    /*
    Metodo para cargar los clientes en el jComboBox
     */
    private void CargarComboClientes() {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_cliente";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_cliente.removeAllItems();
            jComboBox_cliente.addItem("Seleccione cliente:");
            while (rs.next()) {
                jComboBox_cliente.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al cargar clientes, !" + e);
        }
    }

    /*
    Metodo para cargar los productos en el jComboBox
     */
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
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al cargar productos, !" + e);
        }
    }

    /*
        Metodo para validar que el usuario no ingrese caracteres no numericos
     */
    private boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
        Metodo para validar que el usuario no ingrese caracteres no numericos
     */
    private boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
        Metodo para mostrar los datos del producto seleccionado
     */
    private void DatosDelProducto() {
        try {
            String sql = "select * from tb_producto where nombre = '" + this.jComboBox_producto.getSelectedItem() + "'";
            Connection cn = Conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idProducto = rs.getInt("idProducto");
                nombre = rs.getString("nombre");
                cantidadProductoBBDD = rs.getInt("cantidad");
                precioUnitario = rs.getDouble("precio");
                porcentajeIva = rs.getInt("porcentajeIva");

                // Verificar el valor del porcentajeIva
                System.out.println("Porcentaje IVA recuperado: " + porcentajeIva);

                // Calcular IVA según el porcentaje recuperado
                iva = this.CalcularIva(precioUnitario, porcentajeIva); // Calcula y retorna el IVA
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto, " + e);
        }
    }

    /*
    Metodo para calcular iva
     */
    private double CalcularIva(double precio, int porcentajeIva) {
        // Variable para el IVA
        double ivaCalculado = 0.0;

        // Verifica y ajusta el cálculo del IVA según el porcentaje recuperado
        switch (porcentajeIva) {
            case 0: // Si no tiene IVA
                ivaCalculado = 0.0;
                break;
            case 12: // Si el valor en la base de datos es 12, calcula el IVA al 16%
                ivaCalculado = (precio * cantidad) * 0.30; // Calcula el IVA con 16%
                break;
            case 14: // Si el valor en la base de datos es 14, calcula el IVA al 14%
                ivaCalculado = (precio * cantidad) * 0.14; // Calcula el IVA con 14%
                break;
            default:
                // Si el porcentaje no es uno de los esperados, se asigna 0
                ivaCalculado = 0.0;
                break;
        }

        return ivaCalculado;
    }

    /*
    Metodo para calcular el total a pagar de todos los productos agregados
     */
    private void CalcularTotalPagar() {
        subtotalGeneral = 0;
        descuentoGeneral = 0;
        ivaGeneral = 0;
        totalPagarGeneral = 0;

        for (DetalleVenta elemento : listaProductos) {
            subtotalGeneral += elemento.getSubTotal();
            descuentoGeneral += elemento.getDescuento();
            ivaGeneral += elemento.getIva();
            totalPagarGeneral += elemento.getTotalPagar();
        }
        //redondear decimales
        subtotalGeneral = (double) Math.round(subtotalGeneral * 100) / 100;
        ivaGeneral = (double) Math.round(ivaGeneral * 100) / 100;
        descuentoGeneral = (double) Math.round(descuentoGeneral * 100) / 100;
        totalPagarGeneral = (double) Math.round(totalPagarGeneral * 100) / 100;

        //enviar datos a la vista
        txt_subtotal.setText(String.valueOf(subtotalGeneral));
        txt_iva.setText(String.valueOf(ivaGeneral));
        txt_descuento.setText(String.valueOf(descuentoGeneral));
        txt_total_pagar.setText(String.valueOf(totalPagarGeneral));
    }

    /*
    Metodo para obtener id del cliente
     */
    private void ObtenerIdCliente() {
        try {
            String sql = "select * from tb_cliente where concat(nombre,' ',apellido) = '" + this.jComboBox_cliente.getSelectedItem() + "'";
            Connection cn = Conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener id del cliente, " + e);
        }
    }

    //metodo para restar la cantidad (stock) de los productos vendidos
// Método para restar la cantidad (stock) de los productos vendidos y devolver la cantidad restante
// Método para restar la cantidad (stock) de los productos vendidos y devolver la cantidad restante
    private int RestarStockProductos(int idProducto, int cantidad) {
        int cantidadProductosBaseDeDatos = 0;
        int cantidadRestante = 0;
        String nombreProducto = "";  // Variable para almacenar el nombre del producto

        try {
            Connection cn = Conexion.conectar();
            String sql = "select idProducto, cantidad, nombre from tb_producto where idProducto = ?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, idProducto);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cantidadProductosBaseDeDatos = rs.getInt("cantidad");
                nombreProducto = rs.getString("nombre");  // Obtener el nombre del producto
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 1, " + e);
        }

        try {
            Connection cn = Conexion.conectar();
            String sqlUpdate = "update tb_producto set cantidad=? where idProducto = ?";
            PreparedStatement consulta = cn.prepareStatement(sqlUpdate);
            int cantidadNueva = cantidadProductosBaseDeDatos - cantidad;
            consulta.setInt(1, cantidadNueva);
            consulta.setInt(2, idProducto);
            if (consulta.executeUpdate() > 0) {
                cantidadRestante = cantidadNueva;  // Asigna la cantidad restante después de la actualización
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 2, " + e);
        }

        // Verificar si la cantidad restante es 15 o menor y mostrar el nombre del producto en el mensaje
        if (cantidadRestante <= 15) {
            JOptionPane.showMessageDialog(null, "¡Advertencia! El stock de " + nombreProducto + " es bajo. Quedan " + cantidadRestante + " unidades.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

        return cantidadRestante;  // Retorna la cantidad restante después de actualizar el stock
    }

    public double calcularIva(double subtotal, double porcentajeIva) {
        // Calcular el IVA con el porcentaje correcto
        return subtotal * (porcentajeIva / 100.0);
    }
    // Función para calcular el cambio

    private void calcularCambio() {
        // Verificamos que el campo de efectivo no esté vacío
        if (!txt_efectivo.getText().isEmpty()) {
            // Validamos que el usuario no ingrese caracteres no numéricos
            boolean validacion = validarDouble(txt_efectivo.getText());
            if (validacion) {
                // Validar que el efectivo sea mayor a cero
                double efc = Double.parseDouble(txt_efectivo.getText().trim());
                double top = Double.parseDouble(txt_total_pagar.getText().trim());

                if (efc < top) {
                    txt_cambio.setText("Dinero insuficiente");
                } else {
                    // Calcular el cambio
                    double cambio = efc - top;
                    double cambi = (double) Math.round(cambio * 100d) / 100;
                    String camb = String.valueOf(cambi);
                    txt_cambio.setText(camb);
                }
            } else {
                txt_cambio.setText("Caracteres no válidos");
            }
        } else {
            txt_cambio.setText(""); // Si el campo de efectivo está vacío, dejar vacío el campo de cambio
        }
    }

}
