
package libreria;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 * 
 * Classe che implementa il player musicale mediante l'uso di librerie specifiche cioè tale classe 
 * definisce la struttura logica del player. In modo tale da poter riprodurre il brano in background si fa uso dei thread.
 * 
 * @author Giuseppe
 * @author Calogero
 * @author Marco
 */

public class PlayerMP3 extends Thread {
    
    /**
     * VARIABILI.
     * 
     * -player -> istanza della classe AdvacedPlayer contenuta nel package javazoom.jl.player.advanced, essa figura il player.
     * -inputFile -> istanza della classe FileInputStream che ottiene byte di input da un file nel file system (in questo caso
     *               il file multimediale che figura il brano )
     * -scelta -> variabile booleana utilizzata per scegliere se riprodurre (scelta = true) o no (scelta = false)
     * -frameNotifica -> Istanza della classe NotificaFrame che crea un Frame che visualizza messaggi di avviso
     */
    private AdvancedPlayer player;
    private FileInputStream inputFile = null;
    private boolean scelta;
    private NotificaFrame frameNotifica;
    
    
    /**
     * Costruttore
     * @param percorso
     * @throws FileNotFoundException
     * @throws IOException
     * @throws JavaLayerException 
     */
    public PlayerMP3(String percorso) throws FileNotFoundException,IOException,JavaLayerException {
        inputFile = new FileInputStream(percorso);
        player = new AdvancedPlayer(inputFile);
        scelta = false;
        this.start();//avvia il thread
    }
   
    /**
     * Metodo eseguito dal tread.
     * Tale metodo implementa ciò che il thread deve compiere al momento del suo avvio
     */
    @Override
    public void run(){
        /**
         * controllo sull'avvio della riproduzione
         */
        try {
            scelta = true;
            player.play();
           
        } catch (JavaLayerException E){
            frameNotifica = new NotificaFrame("ERRORE nell'avviare riproduzione",this.frameNotifica,true);
        }
        
        /**
         * controllo sul termine della riproduzione
         */
        try {
            player.stop();
            inputFile.close();
        } catch (IOException E){
            frameNotifica = new NotificaFrame("ERRORE nel terminare la riproduzione",this.frameNotifica,true);
        }
     
    }
    
    /**
     * Metodo che soprende/riavvia la riproduzione del brano.
     * in base al valore della variabile "scelta" si mette in pausa la ripoduzione (sospendendo il thread) o la si riavvia
     */
    public void pause(){
        if(scelta){
            scelta =false;
            this.suspend();
         
        } else { 
            scelta = true;
            this.resume();
        }
    }
    
    /**
     * Metodo che interrompe la riproduzione stoppando il thread.
     */
    public void stopMP3(){
        this.stop();
        
    }
}
