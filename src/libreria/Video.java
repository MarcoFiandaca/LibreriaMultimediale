

package libreria;

import java.io.File;
import java.io.IOException;

/**
 * 
 * Sottoclasse che implementa la struttua di un video (Tipo di file multimediale).
 * Questa classe estende la superclasse Elemento (contenente tutte le variabili e metodi per un file multimediale).
 * 
 * @author Giuseppe
 * @author Calogero
 * @author Marco
 */

public class Video extends Elemento {
    
    private String durata;
    private NotificaFrame Frame_notifica;

    /**
     * Costruttore 
     * 
     * @param titolo -> Titolo video
     * @param autore -> Autore video
     * @param anno -> Anno uscita video
     * @param durata -> Durata del video
     * @param percorso -> pathname del video 
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Video(String titolo, String autore, String anno, String durata, String percorso){
		super.setTitolo(titolo);
		super.setAutore(autore);
		super.setAnno(anno);
		this.setDurata(durata);
		super.setPercorso(percorso);
	}
	
/**
 * Metodo che imposta la durata di un video.
 * @param durata -> durata del video(inserirta dall'utante)
 */
    public void setDurata(String durata){
        if(Elemento.isDoubleOrInt(durata)>=0)
            this.durata=durata;
    }
	
/**
 * Metodo che ritorna la durata di un video
 * @return durata
 */       
    public String getDurata(){
        return durata;
    }

/**
 * Metodo che riproduce il video aprendo il player predifinito.
 */        
@Override
    public void play() {
        File file = new File(this.getPercorso());
        try {
            java.awt.Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            Frame_notifica = new NotificaFrame("Errore apertura File Multimediale",this.Frame_notifica,true);
        }
    
    }

/**
 * Metodo che ritorna il tipo di un video
 * @return MP4
 */       
    @Override
    public String getTipo() {
        return "MP4";
    }

    @Override
    public void stop() {
    }
    
}
