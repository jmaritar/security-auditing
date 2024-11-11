package Modulo2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.*;

public class vProcessDebugging extends javax.swing.JFrame {

    private DefaultTableModel processTableModel;
    private ExecutorService executorService;

    public vProcessDebugging() {
        initComponents();
        executorService = Executors.newCachedThreadPool();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTextFieldProcess = new javax.swing.JTextField();
        jButtonAddProcess = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jScrollPaneTable = new javax.swing.JScrollPane();
        jTableProcesses = new javax.swing.JTable();
        jButtonLinea = new javax.swing.JButton();
        jTextFieldLinea = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAddProcess.setText("Agregar Proceso");
        jButtonAddProcess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addProcess();
            }
        });

        jButtonSearch.setText("Buscar");
        jButtonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                filterTable(jTextFieldSearch.getText());
            }
        });

        jButtonDelete.setText("Limpiar");
        jButtonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextFieldSearch.setText("");
                filterTable("");
            }
        });

        processTableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Proceso", "Resultado", "Acciones"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2; // Solo la columna de acciones es editable
            }
        };

        jTableProcesses.setModel(processTableModel);
        jTableProcesses.setRowHeight(30); // Ajuste de la altura de las filas
        jTableProcesses.getColumn("Acciones").setCellRenderer(new ButtonRenderer());
        jTableProcesses.getColumn("Acciones").setCellEditor(new ButtonEditor(new JCheckBox()));
        jScrollPaneTable.setViewportView(jTableProcesses);

        jButtonLinea.setText("Linea");
        jButtonLinea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateLineaField();
            }
        });

        jTextFieldLinea.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextFieldProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonAddProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextFieldLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonAddProcess))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonSearch)
                                        .addComponent(jButtonDelete))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonLinea))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

    private void addProcess() {
        String processName = jTextFieldProcess.getText();
        if (!processName.isEmpty()) {
            processTableModel.addRow(new Object[]{processName, "", "Acciones"});
        }
    }

    private void filterTable(String query) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(processTableModel);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
        jTableProcesses.setRowSorter(sorter);
    }

    private void deleteProcess() {
        jTextFieldSearch.setText("");
        filterTable("");
    }

    private void updateLineaField() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < processTableModel.getRowCount(); i++) {
            sb.append(processTableModel.getValueAt(i, 0));
            if (i < processTableModel.getRowCount() - 1) {
                sb.append(":");
            }
        }
        jTextFieldLinea.setText(sb.toString());
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new vProcessDebugging().setVisible(true));
    }

    // Custom Button Renderer and Editor
    class ButtonRenderer extends JPanel implements TableCellRenderer {
        private final JButton calculateButton = new JButton("Calcular");
        private final JButton killButton = new JButton("Kill");

        public ButtonRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
            add(calculateButton);
            add(killButton);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        protected JPanel panel;
        private final JButton calculateButton = new JButton("Calcular");
        private final JButton killButton = new JButton("Kill");
        private Future<?> currentTask;
        private long startTime;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            panel.add(calculateButton);
            panel.add(killButton);

            calculateButton.addActionListener(e -> startCalculation());
            killButton.addActionListener(e -> stopCalculation());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return "";
        }

        private void startCalculation() {
            startTime = System.currentTimeMillis();
            int row = jTableProcesses.getSelectedRow();
            String processName = (String) processTableModel.getValueAt(row, 0);
            int processLength = processName.length();
            long maxDuration = 5000; // 5 segundos máximo
            final int[] progress = {0}; // Usamos un arreglo de tamaño 1 para poder modificar su valor

            currentTask = executorService.submit(() -> {
                try {
                    System.out.println("Proceso " + processName + " iniciado.");

                    // Cálculo basado en la suma de los dígitos
                    int digitSum = 0;
                    for (char c : processName.toCharArray()) {
                        digitSum += Character.getNumericValue(c);
                    }

                    // Factor de demora reducido para mayor velocidad
                    long delayFactor = processLength * 5L; // Ajuste para hacerlo más rápido

                    for (int i = 1; i <= 100; i++) {
                        if (Thread.currentThread().isInterrupted()) {
                            throw new InterruptedException();
                        }

                        long elapsedTime = System.currentTimeMillis() - startTime;

                        if (elapsedTime >= maxDuration) {
                            throw new InterruptedException(); // Detener si pasa de 5 segundos
                        }

                        // Simulación de trabajo ajustada al cálculo
                        Thread.sleep(delayFactor); // Menor espera para aumentar la velocidad

                        // Calcular el porcentaje de progreso correctamente
                        progress[0] = (i * 100) / 100;

                        if (progress[0] > 100) {
                            progress[0] = 100; // No exceder el 100%
                        }

                        System.out.println("Proceso " + processName + ": " + progress[0] + "% completado.");
                    }

                    long endTime = System.currentTimeMillis();
                    long elapsedTimeInMs = endTime - startTime; // Tiempo en milisegundos
                    SwingUtilities.invokeLater(() -> {
                        processTableModel.setValueAt(progress[0] + "% completado, " + elapsedTimeInMs + " ms", row, 1); // Columna de resultado
                        System.out.println("Proceso " + processName + " completado en " + elapsedTimeInMs + " ms.");
                        JOptionPane.showMessageDialog(null, "Proceso completado en " + elapsedTimeInMs + " ms.");
                    });
                } catch (InterruptedException ex) {
                    long endTime = System.currentTimeMillis();
                    long elapsedTimeInMs = endTime - startTime; // Tiempo en milisegundos
                    SwingUtilities.invokeLater(() -> {
                        processTableModel.setValueAt(progress[0] + "% detenido, " + elapsedTimeInMs + " ms", row, 1); // Columna de resultado
                        System.out.println("Proceso " + processName + " detenido en " + progress[0] + "% después de " + elapsedTimeInMs + " ms.");
                        JOptionPane.showMessageDialog(null, "Proceso detenido en " + progress[0] + "% después de " + elapsedTimeInMs + " ms.");
                    });
                }
            });
        }


        private void stopCalculation() {
            if (currentTask != null && !currentTask.isDone()) {
                currentTask.cancel(true);
            }
        }
    }

    // Variables declaration
    private javax.swing.JButton jButtonAddProcess;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonLinea;
    private javax.swing.JScrollPane jScrollPaneTable;
    private javax.swing.JTable jTableProcesses;
    private javax.swing.JTextField jTextFieldProcess;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTextField jTextFieldLinea;
}
