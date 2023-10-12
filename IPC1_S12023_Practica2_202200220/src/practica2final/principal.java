/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package practica2final;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paola
 */
public final class principal extends javax.swing.JFrame {
    
    private final DefaultTableModel sourceTableModel;
    private final DefaultTableModel destinationTableModel;
        
    LocalDateTime FechaActual = LocalDateTime.now();
    LocalDateTime fechaFinal = FechaActual.plusMinutes(2);
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String fechaComoString = FechaActual.format(formatter);
    String fechaFinalString = fechaFinal.format(formatter);
    
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modeloH = new DefaultTableModel();
    
    ArrayList<Pedido> ListaPedido = new ArrayList<>();
    ArrayList<historialPedido> ListaHistorialPedidos = new ArrayList<>();
 
    

    /**
     * Creates new form principal
     */
    public principal() {
        initComponents();
        this.setLocationRelativeTo(null);        
        
        sourceTableModel = (DefaultTableModel) jTable1.getModel();
        destinationTableModel = (DefaultTableModel) jTable2.getModel();
        
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow >= 0) {
                    String elemento = (String) sourceTableModel.getValueAt(selectedRow, 1);
                }
            }
        });
        
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                agregarProductoSeleccionado();
            }
        });
         
         AbstractDocument doc = (AbstractDocument) jTextField1.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                currentText += text;
                    int num = Integer.parseInt(currentText);
                 
                        super.replace(fb, offset, length, text, attrs);
                   
                
            }
        });
        jTable3.setModel(modeloH);
         modeloH.addColumn("Vehiculo");
         modeloH.addColumn("Distancia");
         modeloH.addColumn("Total");
         modeloH.addColumn("Fecha y hora de Creacion");
         modeloH.addColumn("Fecha y hora de Entrega");
         
        historialBinario HistorialBinario = new historialBinario();
        ArrayList<historialPedido> historialPedido = HistorialBinario.cargarHistorial();
        ActualizarHistorial();
         
    }
    
    public JLabel getmoto1() {
        return motoo1;
    }
    
    public JLabel getmoto2 () {
        return motoo2;
    }
    
    public JLabel getmoto3 () {
        return motoo3;
    }
    
    public JPanel getvuelta () {
        return vuelta1;
    }
    
    private double calcularTotal(String precioConQ) {
        precioConQ = precioConQ.replaceAll("[^0-9.]+", "");
        try {
            return Double.parseDouble(precioConQ);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
    
    private void agregarProductoSeleccionado() {
        int selectedRow = jTable1.getSelectedRow();
    if (selectedRow >= 0) {
        String producto = (String) sourceTableModel.getValueAt(selectedRow, 0);
        String precioConQ = (String) sourceTableModel.getValueAt(selectedRow, 1);

        destinationTableModel.addRow(new Object[]{producto, precioConQ});

        double nuevoTotal = 0.0;
        for (int i = 0; i < destinationTableModel.getRowCount(); i++) {
            String precioProducto = (String) destinationTableModel.getValueAt(i, 1);
            double precio = calcularTotal(precioProducto);
            nuevoTotal += precio;
        }

        jTextField2.setText(String.format("%.2f", nuevoTotal));
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona un producto de la tabla de Productos.");
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        motoo1 = new javax.swing.JLabel();
        motoo2 = new javax.swing.JLabel();
        motoo3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        vuelta1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Productos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Pedido");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Pizza Grande", "Q60"},
                {"Hamburguesa Combo", "Q40"},
                {"Gaseosa", "Q15"},
                {"Papas Fritas", "Q20"}
            },
            new String [] {
                "Producto", "Precio"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Precio"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Agregar producto seleccionado a la orden");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Vehículo:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir...", "Motocicleta 1", "Motocicleta 2", "Motocicleta 3" }));

        jLabel4.setText("Distancia a recorrer:");

        jLabel5.setText("Km.");

        jLabel6.setText("Total:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton2.setText("Confirmar Pedido");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)))))
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addContainerGap(64, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(15, 15, 15))))
        );

        jTabbedPane5.addTab("Pedido", jPanel1);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Visualización de Trayectorias");

        jLabel7.setText("Motocicleta 1");

        jLabel9.setText("Distancia:");

        jLabel10.setText("Km.");

        jButton3.setText("Enviar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setText("Motocicleta 2");

        jLabel12.setText("Distancia:");

        jLabel13.setText("Km.");

        jButton4.setText("Enviar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel14.setText("Motocicleta 3");

        jLabel15.setText("Distancia:");

        jLabel16.setText("Km.");

        jButton5.setText("Enviar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        motoo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/moto.png"))); // NOI18N

        motoo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/moto.png"))); // NOI18N

        motoo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/moto.png"))); // NOI18N

        jButton6.setText("Enviar todos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vuelta1Layout = new javax.swing.GroupLayout(vuelta1);
        vuelta1.setLayout(vuelta1Layout);
        vuelta1Layout.setHorizontalGroup(
            vuelta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );
        vuelta1Layout.setVerticalGroup(
            vuelta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jButton4)
                    .addComponent(jLabel14)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(motoo3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(motoo1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(motoo2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton3)
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vuelta1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(25, 25, 25)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addComponent(motoo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))
                            .addComponent(motoo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5))
                            .addComponent(motoo3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(vuelta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Envíos", jPanel2);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel20.setText("Historial de Envíos");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Motocicleta 1", "4 km", "Q60.0", "11/10/23-11:17:23", "29/10/2023-11:17:53"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vehiculo", "Distancia", "Monto", "Fecha y hora de creacion", "Fecha y hora de entrega"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel20))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Historial", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        EnlistarPedido();
        
        
        
        String selectedVehicle = (String) jComboBox1.getSelectedItem();
        String kmValue = jTextField1.getText();

                if (selectedVehicle.equals("Motocicleta 1")) {
                    jTextField3.setText(kmValue);
                } else if (selectedVehicle.equals("Motocicleta 2")) {
                    jTextField4.setText(kmValue);
                } else if (selectedVehicle.equals("Motocicleta 3")) {
                    jTextField5.setText(kmValue);
                }
        historialBinario HistorialBinario = new historialBinario();
       
    ActualizarHistorial();
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        EnviarPrimera();       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        EnviarSegunda();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        EnviarTercera();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      EnviarPrimera();
      EnviarSegunda();
      EnviarTercera();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
   
    }//GEN-LAST:event_jTable1MouseClicked

    
    public void ActualizarHistorial(){
        
         while(modeloH.getRowCount()>0){
            modeloH.removeRow(0);
         }
            
            for (historialPedido  h: ListaHistorialPedidos ){
            Object x[]=new Object[5];
            x[0] = h.getVehiculo();
            x[1] = h.getDistancia();
            x[2] = h.getMontoTotal();
            x[3] = h.getFechaInicio();
            x[4] = h.getFechaFinal();
            
            modeloH.addRow(x);
        }
            
        jTable3.setModel(modeloH);
        
    }
    
    
    public void ActualizarTabla(){
        
        while(modelo.getRowCount()>0){
            modelo.removeRow(0);
        }
        double subtotal=0;
        
        for (Pedido  p: ListaPedido ){
            Object x[]=new Object[4];
            x[0] = p.getProducto();
            x[1] = p.getPrecio();
            x[2] = p.getCantidad();
            x[3] = p.getSubtotal();
            
            subtotal= (subtotal + p.getSubtotal());
            modelo.addRow(x);
        }
        
        
    }                                                                 

    
    public void EnlistarPedido(){
             double montoTotal = calcularTotal(jTextField2.getText());
      historialPedido Historial = new historialPedido();
      Historial.setVehiculo(jComboBox1.getSelectedItem().toString());
      Historial.setDistancia(Integer.parseInt(jTextField1.getText()));
      Historial.setMontoTotal(montoTotal);
      Historial.setFechaInicio(fechaComoString);
      Historial.setFechaFinal(fechaFinalString);
        
      
                     String input = jTextField1.getText();
                  
                
                 if (jTextField1.getText() == null){
                 JOptionPane.showMessageDialog(null, "Debe ingresar un numero");
                 }

                 try {
                    int km = Integer.parseInt(input);
                    if (km >= 1 && km <= 10) {
                         
                        
                        
                 ListaHistorialPedidos.add(Historial);
                 ActualizarHistorial();
                 JOptionPane.showMessageDialog(null, "Pedido completado con éxito");
                 DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                 model.setRowCount(0);

                    } 
                    
                     
                    
                    else {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un número del 1 al 10", "Error", JOptionPane.ERROR_MESSAGE);
                        jTextField1.setText(""); 
                    }
                } catch (NumberFormatException ex) {
                   
                    JOptionPane.showMessageDialog(null, "Debe ingresar un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextField1.setText(""); 
                }
    
    }
    
    public void EnviarPrimera() {
    final int Max_x = 150 + (Integer.parseInt(jTextField3.getText()) * 40);
    final int Min_x = 148;

    Thread animation = new Thread(new Runnable() {
        @Override
        public void run() {
            int x = 150; 
            int y = 75;  
            boolean checked = true;
            

            while (true) {
                if (checked) {
                    motoo1.setLocation(x, y);
                    x = x + 10; 
                } else {
                    motoo1.setLocation(x, y);
                    x = x - 10;
                }

                if (x > Max_x) {
                    checked = false;
                    x = 150 + (Integer.parseInt(jTextField3.getText()) * 40);
                    if (x == 150 + (Integer.parseInt(jTextField3.getText()) * 40)) {
                    }
                }

                if (x < Min_x) {
                    x = 150;  
                    y = 75;   
                    jTextField3.setText("");
                    checked = false;
                    x = 150 + (Integer.parseInt(jTextField3.getText()) * 40); 
                }

                try {
                    Thread.sleep(200);
                } catch (Exception e) {

                }
            }
        }
    });
    animation.start();
}
    
    public void EnviarSegunda() {
    final int Max_x = 150 + (Integer.parseInt(jTextField4.getText()) * 40);
    final int Min_x = 148; // Coordenada x mínima

    Thread animation = new Thread(new Runnable() {
        @Override
        public void run() {
            int x = 139; 
            int y = 195; 
            boolean checked = true;

            while (true) {
                if (checked) {
                    motoo2.setLocation(x, y);
                    x = x + 10; 
                } else {
                    motoo2.setLocation(x, y);
                    x = x - 10;
                }

                if (x > Max_x) {
                    checked = false;
                    x = 150 + (Integer.parseInt(jTextField4.getText()) * 40);
                    if (x == 150 + (Integer.parseInt(jTextField4.getText()) * 40)) {

                    }
                }

                if (x < Min_x) {
                    x = 139; 
                    y = 195;
                    jTextField4.setText("");
                    checked = false;
                    x = 150 + (Integer.parseInt(jTextField4.getText()) * 40); 
                }

                try {
                    Thread.sleep(200);
                } catch (Exception e) {

                }
            }
        }
    });
    animation.start();
}




    public void EnviarTercera() {
    final int Max_x = 150 + (Integer.parseInt(jTextField5.getText()) * 40);
    final int Min_x = 148; 

    Thread animation = new Thread(new Runnable() {
        @Override
        public void run() {
            int x = 150;
            int y = 310; 
            boolean checked = true;

            while (true) {
                if (checked) {
                    motoo3.setLocation(x, y);
                    x = x + 10; 
                } else {
                    motoo3.setLocation(x, y);
                    x = x - 10;
                }

                if (x > Max_x) {
                    checked = false;
                    x = 150 + (Integer.parseInt(jTextField5.getText()) * 40);
                    if (x == 150 + (Integer.parseInt(jTextField5.getText()) * 40)) {

                    }
                }

                if (x < Min_x) {
                    x = 150;
                    y = 310; 
                    jTextField5.setText("");
                    checked = false;
                    x = 150 + (Integer.parseInt(jTextField5.getText()) * 40); 
                }

                try {
                    Thread.sleep(200);
                } catch (Exception e) {

                }
            }
        }
    });
    animation.start();
}







    
    public void validarKM() {
                String input = jTextField1.getText();

                 try {
                    int km = Integer.parseInt(input);
                    if (km >= 1 && km <= 10) {
                 ActualizarHistorial();
                JOptionPane.showMessageDialog(null, "Pedido completado con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un número del 1 al 10", "Error", JOptionPane.ERROR_MESSAGE);
                        jTextField1.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    jTextField1.setText("");
                }
            }
    
 
    
    
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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel motoo1;
    private javax.swing.JLabel motoo2;
    private javax.swing.JLabel motoo3;
    private javax.swing.JPanel vuelta1;
    // End of variables declaration//GEN-END:variables
}
