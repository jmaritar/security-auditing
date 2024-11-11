package Modulo2;

/**
 *
 * @author mario
 */
public class vBitRecognition extends javax.swing.JFrame {

    private String cadenaBits;
    private char[] mascara;
    private int fallos = 0;

    /**
     * Creates new form vBitRecognition
     */
    public vBitRecognition() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelIngresarCadenaBITS = new javax.swing.JLabel();
        jTextFieldCadena = new javax.swing.JTextField();
        jLabelIngresarPosicionamiento = new javax.swing.JLabel();
        jTextFieldPos = new javax.swing.JTextField();
        jTextFieldBit = new javax.swing.JTextField();
        jLabelIngresarBit = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        jTextFieldMascara = new javax.swing.JTextField();
        jLabelFallos = new javax.swing.JLabel();
        jTextFieldFalllos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldMensaje = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelIngresarCadenaBITS.setText("Ingrese cadena BITS");

        jTextFieldCadena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCadenaFocusLost(evt);
            }
        });

        jTextFieldCadena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCadenaActionPerformed(evt);
            }
        });

        jLabelIngresarPosicionamiento.setText("Ingrese Posicionamiento:");

        jLabelIngresarBit.setText("Ingrese BIT:");

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jLabelFallos.setText("Fallos:");

        jLabel5.setText("Mensaje:");

        jTextFieldMensaje.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelIngresarBit)
                                                                .addGap(24, 24, 24))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelFallos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldFalllos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelIngresarPosicionamiento)
                                                .addGap(11, 11, 11)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextFieldPos, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldBit))))
                                .addGap(30, 30, 30))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelIngresarCadenaBITS, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldCadena, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldMascara, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldMensaje))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabelIngresarCadenaBITS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelIngresarPosicionamiento)
                                        .addComponent(jTextFieldPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldBit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelIngresarBit))
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAceptar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldMascara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelFallos)
                                        .addComponent(jTextFieldFalllos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCadenaFocusLost(java.awt.event.FocusEvent evt) {
        cadenaBits = jTextFieldCadena.getText();
        if (cadenaBits != null && !cadenaBits.isEmpty()) {
            mascara = new char[cadenaBits.length()];
            for (int i = 0; i < mascara.length; i++) {
                mascara[i] = '-';
            }
            jTextFieldMascara.setText(new String(mascara));
        } else {
            jTextFieldMensaje.setText("Cadena de bits no puede estar vacía.");
        }
    }

    private void jTextFieldCadenaActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        if (cadenaBits == null || cadenaBits.isEmpty()) {
            jTextFieldMensaje.setText("Cadena de bits no ingresada.");
            return;
        }

        int posicion;
        try {
            posicion = Integer.parseInt(jTextFieldPos.getText());
        } catch (NumberFormatException e) {
            jTextFieldMensaje.setText("Posición inválida");
            return;
        }

        if (posicion < 0 || posicion >= cadenaBits.length()) {
            registrarFallo();
            return;
        }

        String bit = jTextFieldBit.getText();
        if (!bit.equals("0") && !bit.equals("1")) {
            registrarFallo();
            return;
        }

        if (cadenaBits.charAt(posicion) == bit.charAt(0)) {
            mascara[posicion] = bit.charAt(0);
            jTextFieldMascara.setText(new String(mascara));
            jTextFieldMensaje.setText("Hay comunicación en la posición " + posicion);
            verificarCompleto();
        } else {
            registrarFallo();
        }
    }

    private void registrarFallo() {
        fallos++;
        jTextFieldFalllos.setText(String.valueOf(fallos));
        if (fallos >= 3) {
            jTextFieldMensaje.setText("No hay comunicación, 3 fallos");
            javax.swing.JOptionPane.showMessageDialog(this, "Se va a reiniciar");
            reiniciar();
        } else {
            jTextFieldMensaje.setText("Fallo " + fallos + ", intente de nuevo");
        }
    }

    private void verificarCompleto() {
        boolean completo = true;
        for (char c : mascara) {
            if (c == '-') {
                completo = false;
                break;
            }
        }
        if (completo) {
            jTextFieldMensaje.setText("Hay comunicación en todas las posiciones");
            javax.swing.JOptionPane.showMessageDialog(this, "Comunicación completa. Se va a reiniciar");
            reiniciar();
        }
    }

    private void reiniciar() {
        jTextFieldCadena.setText("");
        jTextFieldPos.setText("");
        jTextFieldBit.setText("");
        jTextFieldMascara.setText("");
        jTextFieldFalllos.setText("0");
        jTextFieldMensaje.setText("");
        fallos = 0;
        cadenaBits = "";
        mascara = null;
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vBitRecognition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vBitRecognition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vBitRecognition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vBitRecognition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vBitRecognition().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelFallos;
    private javax.swing.JLabel jLabelIngresarBit;
    private javax.swing.JLabel jLabelIngresarCadenaBITS;
    private javax.swing.JLabel jLabelIngresarPosicionamiento;
    private javax.swing.JTextField jTextFieldBit;
    private javax.swing.JTextField jTextFieldCadena;
    private javax.swing.JTextField jTextFieldFalllos;
    private javax.swing.JTextField jTextFieldMascara;
    private javax.swing.JTextField jTextFieldMensaje;
    private javax.swing.JTextField jTextFieldPos;
    // End of variables declaration//GEN-END:variables
}
