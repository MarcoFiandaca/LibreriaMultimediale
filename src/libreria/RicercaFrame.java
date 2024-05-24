
package libreria;

/**
 * 
 * Classe che implementa un JDialog per la ricerca, cioè visualizza in una finestra di dialogo la libreria contenente gli
 * elementi cercati.
 * Gli elementi cercati sono salvati in una libreria per far si che la ricerca possa coinvolgere più elementi e che possano essere
 * visualizzati in forma tabellare nella finestra di dialogo.
 * 
 * @author Giuseppe
 * @author Calogero
 * @author Marco
 */

public class RicercaFrame extends javax.swing.JDialog {
    /**
     * Variabili.
     * 
     * -modelloTabella -> istanza della classe MyTableModel che fornisce la struttura grafica della tabella per la visualizzazione degli elementi
     *                    della libreria.
     * -libRicerca -> libreria contenente gli elementi cercati
     * -parent ->
     * framenotifica -> istanza della classe Notificaframe che crea un Frame utilizzato per mostrare messaggi di avviso
     */
    private MyTableModel modelloTabella;
    private MyLibreria libRicerca;
    private java.awt.Frame parent;
    private NotificaFrame frameNotifica;

    /**
     * Costruttore.
     * Crea una finestra di dialogo RicercaFrame.
     * @param parent ->
     * @param model ->
     * @param Lib_Ricerca -> Libreria contenente gli elementi cercati
     */
    public RicercaFrame(java.awt.Frame parent, boolean model, MyLibreria Lib_Ricerca) {
        super(parent, model);
        this.parent = parent;
        this.libRicerca = Lib_Ricerca;
        this.modelloTabella = new MyTableModel(Lib_Ricerca);
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JButtonOk = new javax.swing.JButton();
        JButtonStampa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Elementi Trovati");

        jTable1.setModel(modelloTabella);
        jScrollPane1.setViewportView(jTable1);

        JButtonOk.setText("Ok");
        JButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonOkActionPerformed(evt);
            }
        });

        JButtonStampa.setText("Stampa");
        JButtonStampa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonStampaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(JButtonOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(JButtonStampa)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonOk)
                    .addComponent(JButtonStampa))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
 * Metodo che chiude la finestra di dialogo
 * @param evt -> pressione su JButtonOk
 */
    private void JButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonOkActionPerformed
        this.dispose();
    }//GEN-LAST:event_JButtonOkActionPerformed

    /**
 * Metodo che gestisce la Stampa degli elementi trovati
 * @param evt -> pressione su JButtonStampa
 */
    private void JButtonStampaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonStampaActionPerformed
         
        try {
            if(!jTable1.print()) {  
                frameNotifica = new NotificaFrame("Stampa annullata dall'utente",this.frameNotifica,true);
            }
        } catch (java.awt.print.PrinterException e) {
            frameNotifica = new NotificaFrame("ERRORE: impossibile stampare ",this.frameNotifica,true);
        }
    }//GEN-LAST:event_JButtonStampaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonOk;
    private javax.swing.JButton JButtonStampa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
