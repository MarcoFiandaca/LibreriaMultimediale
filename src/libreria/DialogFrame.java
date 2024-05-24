
package libreria;

/**
 * 
 * Tale classe implementa un JDialog.
 * 
 * Un istanza di tale classe è utilizzata nella classe MyNewFrame per il salvataggio della libreria su file, più
 * precisamente: al suo intero compare il messaggio di avviso di sovrascrizione della libreria precedentemente salvata su file
 * e si fa decidere a l'utente se continuare o meno.
 * 
 * @author Giuseppe
 * @author Calogero
 * @author Marco
 */

public class DialogFrame extends javax.swing.JDialog {
    
/**
 * VARIABILI.
 * -risposta -> variabile booleana che figura la risposta inserita dall'utente mediante i due Jbutton: SI (risposta = true)
 *              e NO(risposta = false).
 */
    private boolean risposta;
   
    /**
     * Creates new form DialogFrame
     * @param parent ->
     * @param modal ->
     */
    public DialogFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        risposta = false;
        setLocationRelativeTo(null);
        initComponents();
        this.setVisible(true);
    }
    
/**
 * Metodo che ritorna la variabile booleana risposta
 * @return risposta
 */
    public boolean getRisposta(){
        return risposta;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JButtonSi = new javax.swing.JButton();
        JButtonNo = new javax.swing.JButton();

        jLabel1.setText("<html>Stai sovrascrivendo una precedente libreria,<br>se continui il vecchio contenuto andrà perso</html>");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 3, 16)); // NOI18N
        jLabel2.setText("Vuoi continuare?");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 20));
        jLabel2.setSize(new java.awt.Dimension(60, 30));

        JButtonSi.setText("Si");
        JButtonSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonSiActionPerformed(evt);
            }
        });

        JButtonNo.setText("No");
        JButtonNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JButtonSi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JButtonNo))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonSi)
                    .addComponent(JButtonNo))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

/**
 * Metodo che setta la variabile risposta = true mediande il JButtonSi
 * @param evt 
 */
    private void JButtonSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonSiActionPerformed
        risposta = true;
        this.dispose();
    }//GEN-LAST:event_JButtonSiActionPerformed

/**
 * Metodo che setta la variabile risposta = false mediante il JButtonNo
 * @param evt 
 */
    private void JButtonNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonNoActionPerformed
        risposta = false;
        this.dispose(); 
    }//GEN-LAST:event_JButtonNoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonNo;
    private javax.swing.JButton JButtonSi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
