
package libreria;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;

/**
 * 
 * Classe che implementa Frame che figura il Player Musicale.
 * Questo Frame permette di gestisce la riproduzione di un brano musicale /graficamente) dando 
 * la possibilità di avviare/stoppare/terminare la riproduzione del brano
 * 
 * @author Giuseppe
 * @author Calogero
 * @author Marco
 */

public class PlayerFrame extends javax.swing.JFrame {
    /**
     * VARIABILI.
     * 
     * -player -> istanza della classe PlayerMP3 che implementa il player musicale.
     * -percorsoBrano -> pathname del brano che si vuole riprodurre
     * -nomeBrano -> titolo del brano da riprodurre
     * -frameNotifica -> Istanza della classe NotificaFrame che crea un frame per la visualizzazione di messaggi di avviso
     */
    private PlayerMP3 player;
    private static String percorsoBrano;
    private static String nomeBrano;
    private NotificaFrame frameNotifica;
    
    
    /**
     * Costruttore.
     * Crea un PlayerFrame
     * @param percorso -> pathname brano da riprodurre
     * @param NomeBrano -> nome del brano da riprodurre
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     */
    public PlayerFrame(String percorso, String NomeBrano) throws IOException, FileNotFoundException {
        initComponents();
        this.setTitle("Player");
        PlayerFrame.percorsoBrano = percorso;
        PlayerFrame.nomeBrano = NomeBrano;
        setLocationRelativeTo(null);
        
        JLabelNomeBrano.setText(NomeBrano+".Mp3");
        
        
        try {
            player = new PlayerMP3(percorsoBrano);   
        } catch (IOException | JavaLayerException ex) {
            frameNotifica = new NotificaFrame("Errore nella Riproduzione",this,true);
        }
        this.setVisible(true);  
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonPlayPause = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        JLabelNomeBrano = new javax.swing.JLabel();
        jLabelImm = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButtonPlayPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini libreria/Play-Pause.png"))); // NOI18N
        jButtonPlayPause.setBorderPainted(false);
        jButtonPlayPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayPauseActionPerformed(evt);
            }
        });

        jButtonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini libreria/Stop.png"))); // NOI18N
        jButtonStop.setBorderPainted(false);
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        JLabelNomeBrano.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JLabelNomeBrano.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelNomeBrano.setText("Nome_brano");
        JLabelNomeBrano.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                JLabelNomeBranoComponentShown(evt);
            }
        });

        jLabelImm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini libreria/apple-music-logo.png"))); // NOI18N
        jLabelImm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jButtonPlayPause)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(jButtonStop)
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLabelNomeBrano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLabelNomeBrano, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonStop)
                    .addComponent(jButtonPlayPause, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Metodo che mette in pausa la riproduzione del brano musicale.
     * @param evt -> Pressione su jButtonPlayPause
     */
    private void jButtonPlayPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayPauseActionPerformed
        player.pause();
    }//GEN-LAST:event_jButtonPlayPauseActionPerformed

    /**
     * Metodo che sospende la riproduzione del brano musicale e chiude il Frame.
     * @param evt -> pressione su jButtonStop
     */
    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        player.stopMP3();
        this.dispose();
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void JLabelNomeBranoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_JLabelNomeBranoComponentShown
        // TODO add your hndling code here:
    }//GEN-LAST:event_JLabelNomeBranoComponentShown

    /**
     * Metodo che sospende la riproduzione del brano quando viene chiuso il Frame
     * @param evt -> chiusura del Frame
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       player.stopMP3();
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelNomeBrano;
    private javax.swing.JButton jButtonPlayPause;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JLabel jLabelImm;
    // End of variables declaration//GEN-END:variables
}
