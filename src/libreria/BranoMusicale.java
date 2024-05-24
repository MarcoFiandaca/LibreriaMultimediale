

package libreria;

import java.io.File;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;

/** 
 * 
 * 
 * Sottoclasse che implementa la struttua di un brano musicale (Tipo di file multimediale).
 * Questa classe estende la superclasse Elemento (contenente tutte le variabili e metodi per un file multimediale)
 *
 * @author Giuseppe
 * @author Calogero
 * @author Marco
 */

public class BranoMusicale extends Elemento {

/**
 * VARIABILI.
 * -durata -> durata del brano musicale (in minuti).
 * -freequenza -> frequenza di campionamento del brano.
 * -inRiproduzione -> variabile booleana utilizzata per verificare se un brano e in riproduzione (true)
 *                    oppure no (false).
 * -attivo -> variabile booleana che indica se il braano è pronto per la riproduzione (true) o no (false)
 * -Player -> istanza della classe PlayerMP3 per la riproduzione del brano musicale.
 * -percorsoPlayer -> Variabile Stringa contenente il Pathname del brano musicale da riprodurre (variabile utilizzata dal player).
 * -frameNotifica -> istanza della classe NotificaFrame utilizzato per visualizzare i messaggi di errori in un JFrame.
 */
    private String durata;
    private String frequenza;
    private boolean inRiproduzione;
    private boolean attivo;
    private PlayerMP3 Player;
    public String percorsoBrano = this.getPercorso();
    private NotificaFrame frameNotifica;

/** Costruttore per la creazione di un brano musicale.
 * 
 * @param titolo identifica il titolo del brano.
 * @param autore identifica l'autore del brano.
 * @param anno identifica l'anno del brano.
 * @param durata identifica la durata del brano.
 * @param frequenza identifica la frequenza di campionamento del brano.
 * @param percorso identifica la posizione del brano nel filesystem.
 */
    @SuppressWarnings("OverridableMethodCallInConstructor")
public BranoMusicale(String titolo, String autore, String anno, String durata, String frequenza, String percorso){
		super.setTitolo(titolo);
		super.setAutore(autore);
		super.setAnno(anno);
		this.setDurata(durata);
		this.setFrequenza(frequenza);
		super.setPercorso(percorso);
                inRiproduzione = false;
                attivo = false;
	}

/** 
 * Imposta la durata del Brano Musicale.
 * @param durata
 */
    public void setDurata(String durata){
        if(Elemento.isDoubleOrInt(durata)>=0)
		this.durata=durata;
	}
    
/** 
 * Imposta la frequenza del Brano Musicale.
 * @param frequenza 
 */
    public void setFrequenza(String frequenza){
        if(Elemento.isDoubleOrInt(frequenza)>=0)
            this.frequenza=frequenza;
    }
	
/**
 * Ritorna la durata del Brano Musicale.
 * @return durata
 */
    public String getDurata(){
	return durata;
    }
    
/**
 * Ritorna la frequenza del Brano Musicale.
 * @return frequenza
 */
    public String getFrequenza(){
	return frequenza;
    }

    
   
/** 
 * Metodo che Implementa la riproduzione.
 * Riproduce in background il brano musicale, se già in riproduzione lo mette in pausa.
 */
    @Override
    public void play() {
       
        attivo = true;//il brano è pronto per la riproduzione
        if(!inRiproduzione){
            try {
                Player = new PlayerMP3(percorsoBrano);
                inRiproduzione = true;
            } catch (JavaLayerException|IOException E ){
                frameNotifica = new NotificaFrame("Errore apertura File Multimediale",this.frameNotifica,true);
            }
        } else {
            Player.pause();
        }
        
    }
    
 
 
/**
 * Metodo che ritorna il tipo di elemento. 
 * @return mp3
 */
    @Override
    public String getTipo() {
        return "MP3";
    }

/**
 * Metodo che stoppa la riproduzione.
 */
    @Override
    public void stop() {
        if(attivo){
            Player.stopMP3();
            Player = null;
            inRiproduzione = false;
            attivo = false;
        }
    }
   
}
