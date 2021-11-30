/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.formdev.flatlaf.FlatLightLaf;
import datos.GuardarBitacora;
import dominio.ProcesosRepetidos;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login_LD;

/**
 *
 * @author Herbert Leonel Dominguez Chavez
 */
public class Hoteleria_MDI extends javax.swing.JFrame {

    private Mnt_Linea form_Mant_Pisos;
    private Mnt_Marca form_Mant_Horarios;
    private Mnt_Bodega form_Mant_Bodega;
    private Mnt_Unidad form_Mant_Unidad;

    ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
    public static JLabel Jl_logo = new JLabel();
    GuardarBitacora bitacora = new GuardarBitacora();

    /**
     * Creates new form Hoteleria_MDI
     */
    public Hoteleria_MDI() {
        initComponents();

        this.setTitle("Usuario: " + "[" + Login_LD.usuario + "]" + " \t" + "FECHA: [" + prcs_repetidos.getFecha() + "]");
        GenerarPermisos generarPermisos = new GenerarPermisos();
        var usuario = Login_LD.usuario;
        var modulo = "Hotelero";
        generarPermisos.getPermisos(modulo, usuario);

        Diseño();
    }

    public void Diseño() {
        Jdp_contenedor.setBackground(new Color(228, 68, 68));
        prcs_repetidos.Cursor(Mnb_menu);
        ImageIcon icono = new ImageIcon("src/main/java/assets/hotel.png");
        this.setIconImage(icono.getImage());
        logo();
        Jdp_contenedor.add(Jl_logo);
    }

    public void logo() {
        ImageIcon icon = new ImageIcon("src/main/java/assets/logo_hotel.png");
        Jl_logo.setSize(300, 300);
        if (icon != null) {
            Jl_logo.setIcon(icon);
        } else {
            //No existe imagen.
        }
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = Jl_logo.getSize();
        Jl_logo.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jdp_contenedor = new javax.swing.JDesktopPane();
        Mnb_menu = new javax.swing.JMenuBar();
        Sbm_archivos = new javax.swing.JMenu();
        Sbm_catalogo = new javax.swing.JMenu();
        Mnu_mantenimientos = new javax.swing.JMenu();
        MnI_piso = new javax.swing.JMenuItem();
        MnI_horario = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Sbm_procesos = new javax.swing.JMenu();
        Sbm_herramientas = new javax.swing.JMenu();
        Sbm_ayuda = new javax.swing.JMenu();
        Btn_cerrarSesion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        javax.swing.GroupLayout Jdp_contenedorLayout = new javax.swing.GroupLayout(Jdp_contenedor);
        Jdp_contenedor.setLayout(Jdp_contenedorLayout);
        Jdp_contenedorLayout.setHorizontalGroup(
            Jdp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        Jdp_contenedorLayout.setVerticalGroup(
            Jdp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 727, Short.MAX_VALUE)
        );

        Sbm_archivos.setText("Archivos");
        Sbm_archivos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_archivos);

        Sbm_catalogo.setText("Catalogo");
        Sbm_catalogo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        Mnu_mantenimientos.setText("Mantenimientos");

        MnI_piso.setText("Mant. Pisos");
        MnI_piso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_pisoActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_piso);

        MnI_horario.setText("Mant. Marca");
        MnI_horario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_horarioActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_horario);

        jMenuItem1.setText("Mant. Bodega");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(jMenuItem1);

        jMenuItem2.setText("Mant. Unidad");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(jMenuItem2);

        Sbm_catalogo.add(Mnu_mantenimientos);

        Mnb_menu.add(Sbm_catalogo);

        Sbm_procesos.setText("Procesos");
        Sbm_procesos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        Mnu_procesos.setText("Procesos");
        Sbm_procesos.add(Mnu_procesos);

        Mnb_menu.add(Sbm_procesos);

        Sbm_herramientas.setText("Herramientas");
        Sbm_herramientas.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_herramientas);

        Sbm_ayuda.setText("Ayuda");
        Sbm_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_ayuda);

        Btn_cerrarSesion.setText("Cerrar Sesión");
        Btn_cerrarSesion.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Btn_cerrarSesion);

        setJMenuBar(Mnb_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jdp_contenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jdp_contenedor)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        logo();
    }//GEN-LAST:event_formComponentResized

    private void MnI_pisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_pisoActionPerformed
        form_Mant_Pisos = new Mnt_Linea();

        Jdp_contenedor.add(form_Mant_Pisos);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Mant_Pisos.getSize();
        form_Mant_Pisos.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Mant_Pisos.setVisible(true);
        form_Mant_Pisos.toFront();
        bitacora.GuardarEnBitacora("log", "2003");
    }//GEN-LAST:event_MnI_pisoActionPerformed

    private void MnI_horarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_horarioActionPerformed
        form_Mant_Horarios = new Mnt_Marca();

        Jdp_contenedor.add(form_Mant_Horarios);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Mant_Horarios.getSize();
        form_Mant_Horarios.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Mant_Horarios.setVisible(true);
        form_Mant_Horarios.toFront();
        bitacora.GuardarEnBitacora("log", "2002");
    }//GEN-LAST:event_MnI_horarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        form_Mant_Bodega = new Mnt_Bodega();

        Jdp_contenedor.add(form_Mant_Bodega);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Mant_Bodega.getSize();
        form_Mant_Bodega.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Mant_Bodega.setVisible(true);
        form_Mant_Bodega.toFront();
        bitacora.GuardarEnBitacora("log", "2001");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        form_Mant_Unidad = new Mnt_Unidad();

        Jdp_contenedor.add(form_Mant_Unidad);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Mant_Unidad.getSize();
        form_Mant_Unidad.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Mant_Unidad.setVisible(true);
        form_Mant_Unidad.toFront();
        bitacora.GuardarEnBitacora("log", "2004");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //FLATLAF
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hoteleria_MDI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu Btn_cerrarSesion;
    private javax.swing.JDesktopPane Jdp_contenedor;
    public static javax.swing.JMenuItem MnI_horario;
    public static javax.swing.JMenuItem MnI_piso;
    public static javax.swing.JMenuBar Mnb_menu;
    public static javax.swing.JMenu Mnu_mantenimientos;
    public static final javax.swing.JMenu Mnu_procesos = new javax.swing.JMenu();
    public static javax.swing.JMenu Sbm_archivos;
    public static javax.swing.JMenu Sbm_ayuda;
    public static javax.swing.JMenu Sbm_catalogo;
    public static javax.swing.JMenu Sbm_herramientas;
    public static javax.swing.JMenu Sbm_procesos;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
