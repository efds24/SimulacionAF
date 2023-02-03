
import javax.swing.JFrame;

public class Principal extends JFrame {
    
    private String cadena;
    private Automata a;
    
    public Principal(Automata a) {
        this.a = a;
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        resultadoArea.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadenaText = new javax.swing.JTextField();
        cadenaBoton = new javax.swing.JButton();
        cadenaLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadoArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Practica 2 - Elena Fernandez del Sel");

        cadenaBoton.setText("Empezar");
        cadenaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadenaBotonActionPerformed(evt);
            }
        });

        cadenaLabel.setText("Introduce una cadena:");

        resultadoArea.setColumns(20);
        resultadoArea.setRows(5);
        jScrollPane1.setViewportView(resultadoArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cadenaLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cadenaText, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadenaBoton))
                    .addComponent(jScrollPane1))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(cadenaLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cadenaText)
                    .addComponent(cadenaBoton, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadenaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadenaBotonActionPerformed
        //Se vacia todo lo que haya en el area de texto
        resultadoArea.setText("");
        //Se reinicia al estado inicial
        a.setEstadoInicial();
        resultadoArea.append("Estado inicial:\n");
        resultadoArea.append(a.imprimirEstadoActual()+"\n");
        
        //Se lee la cadena del cuadro de texto
        cadena = cadenaText.getText().trim();
        
        //Se divide la cadena en caracteres
        for(int i = 0; i<cadena.length(); i++) {
            //Que caracter se esta analizando
            resultadoArea.append("Caracter " + (i+1) + ": " + cadena.charAt(i)+"\n");
            
            //Si el caracter esta en el alfabeto
            if(a.enAlfabeto(cadena.charAt(i))) {
                //Se actualiza el estado actual
                a.estadoSiguiente(cadena.charAt(i));
                //Se imprime el estado actual
                resultadoArea.append(a.imprimirEstadoActual()+"\n");
            } else {
                //Si no esta en el alfabeto este caracter se omite
                resultadoArea.append("\nNo esta en el alfabeto, lo saltamos\n");
            }
        }
    }//GEN-LAST:event_cadenaBotonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadenaBoton;
    private javax.swing.JLabel cadenaLabel;
    private javax.swing.JTextField cadenaText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea resultadoArea;
    // End of variables declaration//GEN-END:variables
}
