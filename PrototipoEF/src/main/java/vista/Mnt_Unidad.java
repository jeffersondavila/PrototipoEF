package vista;

import datos.GuardarBitacora;
import datos.UnidadDAO;
import dominio.ProcesosRepetidos;
import dominio.Unidad;
import java.awt.Color;
import java.util.List;


/**
 *
 * @author Jeff
 */
public class Mnt_Unidad extends javax.swing.JInternalFrame {

    ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
    Unidad pisos = new Unidad();
    GuardarBitacora bitacora = new GuardarBitacora();

    public Mnt_Unidad() {
        initComponents();
        diseño();
        actualizarTabla("");
        jLabel1.setVisible(false);
    }

    public void diseño() {
        this.setTitle("Mantenimiento de Unidad");
        txtnombre.setBorder(null);
        txtnombre1.setBorder(null);
        Txt_buscar.setBorder(null);
        Rdb_Limpiar2.setVisible(false);
        prcs_repetidos.Cursor(Btn_ayuda, Btn_cancelar, Btn_guardar, Btn_modificar, Btn_reporte, Btn_buscar);
    }

    public void actualizarTabla(String codigo) {
        ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
        UnidadDAO.codigoAuxiliar = codigo;
        UnidadDAO.nombreAuxiliar = codigo;
        String columnas[] = {"ID", "NOMBRE DE UNIDAD", "MEDIDA", "ESTADO"};
        int cantidadcolumnas = columnas.length;
        prcs_repetidos.llenarColumnas(columnas, cantidadcolumnas, Tbl_Datos);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {75, 250, 100, 75};
        UnidadDAO pisosdao = new UnidadDAO();
        List<Unidad> piso = pisosdao.select();
        for (Unidad listaServicio : piso) {
            datos[0] = String.valueOf(listaServicio.getCodigo());
            datos[1] = String.valueOf(listaServicio.getNombre());
            datos[2] = String.valueOf(listaServicio.getMedida());
            if (String.valueOf(listaServicio.getEstado()).equals("1")) {
                datos[3] = "Activo";
            } else {
                datos[3] = "Inactivo";
            }
            prcs_repetidos.llenarFilas(datos, tamaño, Tbl_Datos);
        }
    }

    public void Limpiar() {
        prcs_repetidos.Limpiar(txtnombre, txtnombre1, Txt_buscar);
        Rdb_Limpiar2.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGp_tipo = new javax.swing.ButtonGroup();
        BtnGp_estado = new javax.swing.ButtonGroup();
        Pnl_ingresoDatos = new javax.swing.JPanel();
        Lbl_id = new javax.swing.JLabel();
        Lbl_estado = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        Rdb_Activo = new javax.swing.JRadioButton();
        Rdb_Limpiar2 = new javax.swing.JRadioButton();
        Rdb_Inactivo = new javax.swing.JRadioButton();
        Btn_fondoGuardar = new javax.swing.JPanel();
        Btn_guardar = new javax.swing.JLabel();
        Btn_fondo_modificar = new javax.swing.JPanel();
        Btn_modificar = new javax.swing.JLabel();
        Btn_fondo_reporte = new javax.swing.JPanel();
        Btn_reporte = new javax.swing.JLabel();
        Btn_fondo_ayuda = new javax.swing.JPanel();
        Btn_ayuda = new javax.swing.JLabel();
        Btn_fondo_cancelar = new javax.swing.JPanel();
        Btn_cancelar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Lbl_id1 = new javax.swing.JLabel();
        txtnombre1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        Pnl_datos = new javax.swing.JPanel();
        Lbl_codigoNombre = new javax.swing.JLabel();
        Txt_buscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_Datos = new javax.swing.JTable();
        Btn_fondo_buscar = new javax.swing.JPanel();
        Btn_buscar = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(36, 47, 65));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setVisible(true);

        Pnl_ingresoDatos.setBackground(new java.awt.Color(36, 47, 65));
        Pnl_ingresoDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESO DE DATOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        Lbl_id.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id.setText("NOMBRE:");

        Lbl_estado.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_estado.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_estado.setText("ESTADO:");

        txtnombre.setBackground(new java.awt.Color(36, 47, 65));
        txtnombre.setForeground(new java.awt.Color(255, 255, 255));
        txtnombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        BtnGp_estado.add(Rdb_Activo);
        Rdb_Activo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        Rdb_Activo.setForeground(new java.awt.Color(255, 255, 255));
        Rdb_Activo.setText("Activo");

        BtnGp_estado.add(Rdb_Limpiar2);

        BtnGp_estado.add(Rdb_Inactivo);
        Rdb_Inactivo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        Rdb_Inactivo.setForeground(new java.awt.Color(255, 255, 255));
        Rdb_Inactivo.setText("Inactivo");

        Btn_fondoGuardar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_guardar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_guardar.setText("Insertar");
        Btn_guardar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_guardar.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_guardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_guardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_guardarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoGuardarLayout = new javax.swing.GroupLayout(Btn_fondoGuardar);
        Btn_fondoGuardar.setLayout(Btn_fondoGuardarLayout);
        Btn_fondoGuardarLayout.setHorizontalGroup(
            Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
        );
        Btn_fondoGuardarLayout.setVerticalGroup(
            Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        Btn_fondo_modificar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_modificar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_modificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_modificar.setText("Modificar");
        Btn_modificar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_modificar.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_modificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_modificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_modificarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_modificarLayout = new javax.swing.GroupLayout(Btn_fondo_modificar);
        Btn_fondo_modificar.setLayout(Btn_fondo_modificarLayout);
        Btn_fondo_modificarLayout.setHorizontalGroup(
            Btn_fondo_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondo_modificarLayout.setVerticalGroup(
            Btn_fondo_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Btn_fondo_reporte.setBackground(new java.awt.Color(97, 212, 195));

        Btn_reporte.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_reporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_reporte.setText("Reporte");
        Btn_reporte.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_reporte.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_reporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_reporteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_reporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_reporteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_reporteLayout = new javax.swing.GroupLayout(Btn_fondo_reporte);
        Btn_fondo_reporte.setLayout(Btn_fondo_reporteLayout);
        Btn_fondo_reporteLayout.setHorizontalGroup(
            Btn_fondo_reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondo_reporteLayout.setVerticalGroup(
            Btn_fondo_reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondo_ayuda.setBackground(new java.awt.Color(253, 255, 182));

        Btn_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_ayuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_ayuda.setText("Ayuda");
        Btn_ayuda.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_ayuda.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_ayudaLayout = new javax.swing.GroupLayout(Btn_fondo_ayuda);
        Btn_fondo_ayuda.setLayout(Btn_fondo_ayudaLayout);
        Btn_fondo_ayudaLayout.setHorizontalGroup(
            Btn_fondo_ayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        Btn_fondo_ayudaLayout.setVerticalGroup(
            Btn_fondo_ayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondo_cancelar.setBackground(new java.awt.Color(255, 128, 115));

        Btn_cancelar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_cancelar.setText("Cancelar");
        Btn_cancelar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_cancelar.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_cancelarLayout = new javax.swing.GroupLayout(Btn_fondo_cancelar);
        Btn_fondo_cancelar.setLayout(Btn_fondo_cancelarLayout);
        Btn_fondo_cancelarLayout.setHorizontalGroup(
            Btn_fondo_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        Btn_fondo_cancelarLayout.setVerticalGroup(
            Btn_fondo_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Lbl_id1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id1.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id1.setText("Medida:");

        txtnombre1.setBackground(new java.awt.Color(36, 47, 65));
        txtnombre1.setForeground(new java.awt.Color(255, 255, 255));
        txtnombre1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout Pnl_ingresoDatosLayout = new javax.swing.GroupLayout(Pnl_ingresoDatos);
        Pnl_ingresoDatos.setLayout(Pnl_ingresoDatosLayout);
        Pnl_ingresoDatosLayout.setHorizontalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Lbl_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addComponent(txtnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondoGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_fondo_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                            .addComponent(Lbl_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(54, 54, 54)
                            .addComponent(Rdb_Activo)
                            .addGap(18, 18, 18)
                            .addComponent(Rdb_Limpiar2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                            .addComponent(Rdb_Inactivo))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_ingresoDatosLayout.createSequentialGroup()
                            .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGap(54, 54, 54)
                            .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator1)
                                .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        Pnl_ingresoDatosLayout.setVerticalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_id))
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_id1))
                .addGap(3, 3, 3)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbl_estado)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Rdb_Limpiar2)
                            .addComponent(Rdb_Activo)
                            .addComponent(Rdb_Inactivo))))
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_fondoGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_fondo_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Pnl_datos.setBackground(new java.awt.Color(36, 47, 65));
        Pnl_datos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        Lbl_codigoNombre.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_codigoNombre.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_codigoNombre.setText("Código:");

        Txt_buscar.setBackground(new java.awt.Color(36, 47, 65));
        Txt_buscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Txt_buscar.setForeground(new java.awt.Color(255, 255, 255));
        Txt_buscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Tbl_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tbl_Datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_DatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tbl_Datos);

        Btn_fondo_buscar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_buscar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_buscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_buscar.setText("Buscar");
        Btn_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_buscarLayout = new javax.swing.GroupLayout(Btn_fondo_buscar);
        Btn_fondo_buscar.setLayout(Btn_fondo_buscarLayout);
        Btn_fondo_buscarLayout.setHorizontalGroup(
            Btn_fondo_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );
        Btn_fondo_buscarLayout.setVerticalGroup(
            Btn_fondo_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Pnl_datosLayout = new javax.swing.GroupLayout(Pnl_datos);
        Pnl_datos.setLayout(Pnl_datosLayout);
        Pnl_datosLayout.setHorizontalGroup(
            Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addGroup(Pnl_datosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Lbl_codigoNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7)
                            .addComponent(Txt_buscar))
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        Pnl_datosLayout.setVerticalGroup(
            Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_datosLayout.createSequentialGroup()
                .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_fondo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Pnl_datosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Txt_buscar)
                                .addComponent(Lbl_codigoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_ingresoDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Pnl_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Pnl_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pnl_ingresoDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_reporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseEntered
        Btn_fondo_reporte.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_reporteMouseEntered

    private void Btn_reporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseExited
        Btn_fondo_reporte.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_reporteMouseExited

    private void Btn_guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseEntered
        Btn_fondoGuardar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_guardarMouseEntered

    private void Btn_modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseEntered
        Btn_fondo_modificar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_modificarMouseEntered

    private void Btn_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseExited
        Btn_fondoGuardar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_guardarMouseExited

    private void Btn_modificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseExited
        Btn_fondo_modificar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_modificarMouseExited

    private void Btn_ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseEntered
        Btn_fondo_ayuda.setBackground(new Color(255, 255, 63));
    }//GEN-LAST:event_Btn_ayudaMouseEntered

    private void Btn_ayudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseExited
        Btn_fondo_ayuda.setBackground(new Color(253, 255, 182));
    }//GEN-LAST:event_Btn_ayudaMouseExited

    private void Btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseEntered
        Btn_fondo_cancelar.setBackground(new Color(255, 52, 31));
    }//GEN-LAST:event_Btn_cancelarMouseEntered

    private void Btn_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseExited
        Btn_fondo_cancelar.setBackground(new Color(255, 128, 115));
    }//GEN-LAST:event_Btn_cancelarMouseExited

    private void Btn_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseEntered
        Btn_fondo_buscar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_buscarMouseEntered

    private void Btn_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseExited
        Btn_fondo_buscar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_buscarMouseExited

    private void Btn_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseClicked
        if (prcs_repetidos.isNoneEmpty(txtnombre, txtnombre1)) {
            if (prcs_repetidos.isSelected(Rdb_Activo, Rdb_Inactivo)) {
                UnidadDAO pisosdao = new UnidadDAO();
                pisos.setNombre(txtnombre.getText());
                pisos.setMedida(txtnombre1.getText());
                if (Rdb_Activo.isSelected()) {
                    pisos.setEstado("1");
                } else if (Rdb_Inactivo.isSelected()) {
                    pisos.setEstado("0");
                }
                pisosdao.insert(pisos);
                actualizarTabla("");
                prcs_repetidos.AlertaMensaje("guardada", "Unidad", "exitosamente");
                Limpiar();
                bitacora.GuardarEnBitacora("Guardar", "2004");
            } else {
            }

        }
    }//GEN-LAST:event_Btn_guardarMouseClicked

    private void Btn_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseClicked
        if (prcs_repetidos.isNoneEmpty(txtnombre, txtnombre1)) {
            if (prcs_repetidos.isSelected(Rdb_Activo, Rdb_Inactivo)) {
                UnidadDAO pisosdao = new UnidadDAO();
                pisos.setCodigo(jLabel1.getText());
                pisos.setNombre(txtnombre.getText());
                pisos.setNombre(txtnombre1.getText());
                if (Rdb_Activo.isSelected()) {
                    pisos.setEstado("1");
                } else if (Rdb_Inactivo.isSelected()) {
                    pisos.setEstado("0");
                }
                pisosdao.update(pisos);
                actualizarTabla("");
                prcs_repetidos.AlertaMensaje("modificada", "Unidad", "exitosamente");
                Limpiar();
                bitacora.GuardarEnBitacora("Modificar", "2004");
            } else {
            }
        }
    }//GEN-LAST:event_Btn_modificarMouseClicked

    private void Tbl_DatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_DatosMouseClicked
        if (evt.getClickCount() == 2) {
            jLabel1.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 0).toString());
            txtnombre.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 1).toString());
            txtnombre1.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 2).toString());
            if (Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 3).toString().equals("Activo")) {
                Rdb_Activo.setSelected(true);
            } else {
                Rdb_Inactivo.setSelected(true);
            }
            bitacora.GuardarEnBitacora("Buscar", "2004");
        }
    }//GEN-LAST:event_Tbl_DatosMouseClicked

    private void Btn_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseClicked
        Limpiar();
    }//GEN-LAST:event_Btn_cancelarMouseClicked

    private void Btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseClicked
        actualizarTabla(Txt_buscar.getText());
    }//GEN-LAST:event_Btn_buscarMouseClicked

    private void Btn_ayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseClicked
        prcs_repetidos.imprimirAyuda("AyudaMantenimientoPisos.chm");
    }//GEN-LAST:event_Btn_ayudaMouseClicked

    private void Btn_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseClicked
        prcs_repetidos.imprimirReporte("Rpt_MantPisos.jrxml", "Reporte Pisos");
    }//GEN-LAST:event_Btn_reporteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnGp_estado;
    private javax.swing.ButtonGroup BtnGp_tipo;
    private javax.swing.JLabel Btn_ayuda;
    private javax.swing.JLabel Btn_buscar;
    private javax.swing.JLabel Btn_cancelar;
    private javax.swing.JPanel Btn_fondoGuardar;
    private javax.swing.JPanel Btn_fondo_ayuda;
    private javax.swing.JPanel Btn_fondo_buscar;
    private javax.swing.JPanel Btn_fondo_cancelar;
    private javax.swing.JPanel Btn_fondo_modificar;
    private javax.swing.JPanel Btn_fondo_reporte;
    private javax.swing.JLabel Btn_guardar;
    private javax.swing.JLabel Btn_modificar;
    private javax.swing.JLabel Btn_reporte;
    private javax.swing.JLabel Lbl_codigoNombre;
    private javax.swing.JLabel Lbl_estado;
    private javax.swing.JLabel Lbl_id;
    private javax.swing.JLabel Lbl_id1;
    private javax.swing.JPanel Pnl_datos;
    private javax.swing.JPanel Pnl_ingresoDatos;
    private javax.swing.JRadioButton Rdb_Activo;
    private javax.swing.JRadioButton Rdb_Inactivo;
    private javax.swing.JRadioButton Rdb_Limpiar2;
    private javax.swing.JTable Tbl_Datos;
    private javax.swing.JTextField Txt_buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnombre1;
    // End of variables declaration//GEN-END:variables
}
