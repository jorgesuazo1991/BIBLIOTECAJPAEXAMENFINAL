/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.biblioteca.gui;

/**
 *
 * @author ProDesk
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("pnlRegistro");

        jPanel1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
package com.biblioteca.gui;

import com.biblioteca.entidades.Autor;
import com.biblioteca.entidades.Libro;
import com.biblioteca.servicios.AutorService;
import com.biblioteca.servicios.LibroService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {

    private AutorService autorService;
    private LibroService libroService;

    // Componentes de la UI (variables generadas por NetBeans, solo referenciamos)
    private JTextField txtAutorNombre;
    private JTextField txtAutorNacionalidad;
    private JButton btnGuardarAutor;
    private JTextField txtLibroTitulo;
    private JTextField txtLibroAnio;
    private JComboBox<Autor> cmbAutores; // ComboBox para los autores
    private JButton btnGuardarLibro;
    private JTable tblLibros;
    private JButton btnActualizarListado; // Botón para actualizar el listado
    private JTabbedPane tabbedPane; // El JTabbedPane

    // Constructor del JFrame
    public MainFrame() {
        initComponents(); // Método generado automáticamente por NetBeans
        autorService = new AutorService();
        libroService = new LibroService();
        cargarAutoresEnComboBox(); // Cargar autores al iniciar la ventana
        configurarEventos(); // Configurar los listeners
        cargarLibrosEnTabla(); // Cargar libros al iniciar
    }

    // Método generado por NetBeans para inicializar componentes (no lo edites manualmente en la vista de Source)
    private void initComponents() {
        // ... (Este código es generado por el diseñador de NetBeans.
        // Asegúrate de que las variables de tus componentes como txtAutorNombre,
        // btnGuardarAutor, cmbAutores, tblLibros, etc., tengan los nombres correctos
        // que hayas asignado en las propiedades de los componentes en el diseñador.)

        // Ejemplo de cómo se verían algunos componentes si los hicieras manualmente:
        // txtAutorNombre = new JTextField(20);
        // btnGuardarAutor = new JButton("Guardar Autor");
        // cmbAutores = new JComboBox<>();
        // tblLibros = new JTable();
        // btnActualizarListado = new JButton("Actualizar Lista");
        // tabbedPane = new JTabbedPane();

        // Configuración básica del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestión de Biblioteca JPA");
        setSize(800, 600);
        setLocationRelativeTo(null); // Centrar la ventana
        
        // Aquí debes configurar el JTabbedPane y añadir los paneles (ya lo hace el diseñador)
        // Ejemplo (lo que el diseñador hará por ti):
        // JPanel pnlRegistro = new JPanel(new MigLayout("wrap 2", "[][grow]", "[][][][][][grow]"));
        // pnlRegistro.add(new JLabel("Nombre Autor:")); pnlRegistro.add(txtAutorNombre, "growx");
        // pnlRegistro.add(new JLabel("Nacionalidad:")); pnlRegistro.add(txtAutorNacionalidad, "growx");
        // pnlRegistro.add(btnGuardarAutor, "span 2, center, wrap");

        // pnlRegistro.add(new JSeparator(), "span 2, growx, wrap");

        // pnlRegistro.add(new JLabel("Título Libro:")); pnlRegistro.add(txtLibroTitulo, "growx");
        // pnlRegistro.add(new JLabel("Año:")); pnlRegistro.add(txtLibroAnio, "growx");
        // pnlRegistro.add(new JLabel("Autor:")); pnlRegistro.add(cmbAutores, "growx");
        // pnlRegistro.add(btnGuardarLibro, "span 2, center");

        // JPanel pnlListado = new JPanel(new BorderLayout());
        // pnlListado.add(new JScrollPane(tblLibros), BorderLayout.CENTER);
        // pnlListado.add(btnActualizarListado, BorderLayout.SOUTH);

        // tabbedPane.addTab("Registro", pnlRegistro);
        // tabbedPane.addTab("Listado", pnlListado);
        // add(tabbedPane);
    }

    private void configurarEventos() {
        btnGuardarAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarAutor();
            }
        });

        btnGuardarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarLibro();
            }
        });

        btnActualizarListado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarLibrosEnTabla();
            }
        });
        
        // Listener para el cambio de pestaña, para actualizar la tabla
        tabbedPane.addChangeListener(e -> {
            if (tabbedPane.getSelectedIndex() == 1) { // Si la pestaña de "Listado" es seleccionada
                cargarLibrosEnTabla();
            }
        });
    }

    private void guardarAutor() {
        String nombre = txtAutorNombre.getText().trim();
        String nacionalidad = txtAutorNacionalidad.getText().trim();

        if (nombre.isEmpty() || nacionalidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos del autor son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Autor autor = new Autor(nombre, nacionalidad);
        try {
            autorService.agregarAutor(autor);
            JOptionPane.showMessageDialog(this, "Autor guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            txtAutorNombre.setText("");
            txtAutorNacionalidad.setText("");
            cargarAutoresEnComboBox(); // Recargar el combobox después de añadir un nuevo autor
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el autor: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void guardarLibro() {
        String titulo = txtLibroTitulo.getText().trim();
        String anioStr = txtLibroAnio.getText().trim();
        Autor autorSeleccionado = (Autor) cmbAutores.getSelectedItem();

        if (titulo.isEmpty() || anioStr.isEmpty() || autorSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Todos los campos del libro son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Integer anio = Integer.parseInt(anioStr);
            Libro libro = new Libro(titulo, anio, autorSeleccionado);
            libroService.agregarLibro(libro);
            JOptionPane.showMessageDialog(this, "Libro guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            txtLibroTitulo.setText("");
            txtLibroAnio.setText("");
            cargarLibrosEnTabla(); // Actualizar la tabla después de añadir un nuevo libro
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El año debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el libro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void cargarAutoresEnComboBox() {
        cmbAutores.removeAllItems(); // Limpiar items existentes
        List<Autor> autores = autorService.listarAutores();
        for (Autor autor : autores) {
            cmbAutores.addItem(autor);
        }
    }

    private void cargarLibrosEnTabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Título");
        model.addColumn("Año");
        model.addColumn("Autor");
        model.addColumn("Nacionalidad Autor");

        List<Libro> libros = libroService.listarTodosLosLibros();
        for (Libro libro : libros) {
            model.addRow(new Object[]{
                libro.getId(),
                libro.getTitulo(),
                libro.getAnio(),
                libro.getAutor() != null ? libro.getAutor().getNombre() : "N/A",
                libro.getAutor() != null ? libro.getAutor().getNacionalidad() : "N/A"
            });
        }
        tblLibros.setModel(model);
    }

    // Método main para ejecutar la aplicación
    public static void main(String[] args) {
        // Ejecutar la UI en el Event Dispatch Thread de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}