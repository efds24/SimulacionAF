import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Pantalla extends JFrame {

    private File file;
    private static Automata a;
    
    public Pantalla() {
        file = null;
        initComponents();
        archivoText.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descripcion = new javax.swing.JLabel();
        archivoText = new javax.swing.JTextField();
        seleccionarBoton = new javax.swing.JButton();
        confirmarBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Practica 2 - Elena Fernandez del Sel");

        descripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        descripcion.setText("Selecciona el archivo con la descripción del autómata");

        seleccionarBoton.setText("...");
        seleccionarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarBotonActionPerformed(evt);
            }
        });

        confirmarBoton.setText("Seleccionar archivo");
        confirmarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(descripcion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(confirmarBoton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(archivoText, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(seleccionarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(138, 138, 138))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(descripcion)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(archivoText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seleccionarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(confirmarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(383, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarBotonActionPerformed
        //Se crea el selector de archivo
        JFileChooser fileChooser = new JFileChooser();
        //El selector de archivos se abre en el directorio donde se ejecuta el programa
        fileChooser.setCurrentDirectory(new File("."));
        //Se abre el fileChooser
        int result = fileChooser.showOpenDialog(null);
        //Cuando se seleccione un archivo se almacena en file y se pone la ruta en archivoText
        if(result == JFileChooser.APPROVE_OPTION){
            file = fileChooser.getSelectedFile();
            archivoText.setText(String.valueOf(file));
        }
    }//GEN-LAST:event_seleccionarBotonActionPerformed

    private void confirmarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarBotonActionPerformed
        //Si ya se ha seleccionado un archivo
        if(file != null){
            //Se lee el fichero y se divide correctamente
            a.leerFichero(file);
            //Se crea la ventana principal
            Principal principal = new Principal(a);
            //Se deja de ver esta
            this.setVisible(false);
        }
    }//GEN-LAST:event_confirmarBotonActionPerformed

     public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //Se crea una nueva instancia de la clase con las funciones basicas del programa
                a = new Automata();
                //Se crea la ventana del seleccion de archivos
                Pantalla interfaz = new Pantalla();
                interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                interfaz.pack();
                interfaz.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField archivoText;
    private javax.swing.JButton confirmarBoton;
    private javax.swing.JLabel descripcion;
    private javax.swing.JButton seleccionarBoton;
    // End of variables declaration//GEN-END:variables

}
